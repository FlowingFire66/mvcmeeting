package com.example.service;

import com.example.domain.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String username);

    public void deleteByUsername(Long username);

    void register(UserInfo userInfo);
}