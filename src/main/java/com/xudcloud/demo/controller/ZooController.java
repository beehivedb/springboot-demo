/**
 * File : ZooController.java
 * Copyright (C) 2008-2018 www.oneapm.com . all rights reserved.
 */
package com.xudcloud.demo.controller;

import com.xudcloud.demo.service.ZooService;
import org.apache.zookeeper.server.ZooKeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ron
 * date :2019/12/3:17:57
 * TODO
 * version 1.0
 */
@RestController
public class ZooController {

    @Autowired
    private ZooService zooService;

    @GetMapping("/zk/nodes/{path}")
    public String named(@PathVariable String path) {
        path = "/" + path;
        if (zooService.exist(path)) {
            return zooService.get(path);
        }
        return zooService.create(path, path);
    }

}
