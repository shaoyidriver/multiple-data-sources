package com.sy.dao.back;

import com.sy.model.back.BackUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BackUserDao {
    int deleteByPrimaryKey(Integer pkId);

    int insert(BackUser record);

    int insertSelective(BackUser record);

    BackUser selectByPrimaryKey(Integer pkId);
    List<BackUser> selectAll();
    int updateByPrimaryKeySelective(BackUser record);

    int updateByPrimaryKey(BackUser record);
}