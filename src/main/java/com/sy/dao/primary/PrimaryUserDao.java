package com.sy.dao.primary;

import com.sy.model.primary.PrimaryUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrimaryUserDao {
    int deleteByPrimaryKey(Integer pkId);

    int insert(PrimaryUser record);

    int insertSelective(PrimaryUser record);

    PrimaryUser selectByPrimaryKey(Integer pkId);
    List<PrimaryUser> selectAll();

    int updateByPrimaryKeySelective(PrimaryUser record);

    int updateByPrimaryKey(PrimaryUser record);
}