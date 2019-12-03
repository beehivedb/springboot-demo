/**
 * File : User.java
 * Copyright (C) 2008-2018 www.oneapm.com . all rights reserved.
 */
package com.xudcloud.demo.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : Ron
 * date :2019/11/29:15:59
 * TODO
 * version 1.0
 */
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
}
