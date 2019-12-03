/**
 * File : UserRepository.java
 * Copyright (C) 2008-2018 www.oneapm.com . all rights reserved.
 */
package com.xudcloud.demo.repository;

import com.xudcloud.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : Ron
 * date :2019/11/29:16:05
 * TODO
 * version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);
}
