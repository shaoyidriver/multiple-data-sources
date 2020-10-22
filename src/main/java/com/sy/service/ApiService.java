package com.sy.service;

import com.sy.model.back.BackUser;
import com.sy.model.primary.PrimaryUser;

import java.util.List;

public interface ApiService {
    List<PrimaryUser> getAllPrimaryUsers();
    List<BackUser> getAllBackUsers();
}
