package com.sy.service.impl;

import com.sy.dao.back.BackUserDao;
import com.sy.dao.primary.PrimaryUserDao;
import com.sy.model.back.BackUser;
import com.sy.model.primary.PrimaryUser;
import com.sy.service.ApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    @Resource
    private PrimaryUserDao primaryUser;

    @Resource
    private BackUserDao backUser;

    @Override
    public List<PrimaryUser> getAllPrimaryUsers() {
        return primaryUser.selectAll();
    }

    @Override
    public List<BackUser> getAllBackUsers() {
        return backUser.selectAll();
    }
}
