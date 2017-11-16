package com.example.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.UserInfo;

import java.util.List;

/**
 * UserInfo持久化类
 *
 * @author Administrator
 *
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    /** 通过username查找用户信息 **/
    public UserInfo findByUsername(String username);
    public UserInfo save(UserInfo userInfo);
    public void delete(UserInfo userInfo);
    public void delete(Long id);
    public List<UserInfo> findAll();
}