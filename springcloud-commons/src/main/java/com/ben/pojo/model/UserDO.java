package com.ben.pojo.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserDO implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String remark;
    private String otherInfo;
}
