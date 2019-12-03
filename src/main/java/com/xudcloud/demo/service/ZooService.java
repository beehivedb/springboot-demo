/**
 * File : ZooService.java
 * Copyright (C) 2008-2018 www.oneapm.com . all rights reserved.
 */
package com.xudcloud.demo.service;

import org.apache.zookeeper.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author : Ron
 * date :2019/12/3:15:49
 * TODO
 * version 1.0
 */
@Service
public class ZooService implements Watcher {
    private ZooKeeper zooKeeper;

    @Value("${zookeeper.host}")
    private String host;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @PostConstruct
    public void init(){
        try {
            zooKeeper = new ZooKeeper(host, 2000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String create(String path, String data) {
        try {
            return this.zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return path;
    }

    public String get(String path) {
        try {
            byte[] data = zooKeeper.getData(path, false, null);
            if (data != null) {
                return new String(data);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean exist(String path) {
        try {
            byte[] data = zooKeeper.getData(path, false, null);
            if (data != null) {
                return  true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("Watch received event");
            countDownLatch.countDown();
        }
    }
}
