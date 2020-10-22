package com.sy.model.primary;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BackUser",description = "用户对象")
public class PrimaryUser {
    private Integer pkId;

    private String userName;

    private String password;

    private String realName;

    private Integer gender;

    private String mobile;

    private String roleName;

    private Integer status;

    private Integer eable;

    private Integer sort;

    private Date createTime;

}