package com.sy.controller;

import com.sy.model.back.BackUser;
import com.sy.model.primary.PrimaryUser;
import com.sy.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiTest {
    @Autowired
    private ApiService apiService;

    @GetMapping("/getAllPrimaryUsers")
    public List<PrimaryUser> getAllPrimaryUsers() {
        return apiService.getAllPrimaryUsers();
    }

    @GetMapping("/getAllBackUsers")
    public List<BackUser> getAllBackUsers() {
        return apiService.getAllBackUsers();
    }
}
