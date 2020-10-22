package com.sy.model.back;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "PrimaryUser" ,description = "用户对象")
public class BackUser {
    private Integer pkId;

    private String userName;

    private String password;

    private String gender;

    private String realName;

    private Date timestamp;

    private String enble;

    private String comminutyType;

    private Integer sort;

    private Integer userStatus;

    private String mobliephone;

    private String position;

    private String intro;

    private String address;

    private Integer errorCount;

    private String doctorId;

    private String doctorNo;

}