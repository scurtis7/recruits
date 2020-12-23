package com.scurtis.recruits.dto;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Dec 22, 2020
 **/

@Data
public class ChangePassword {

    private String oldUsername;
    private String oldPassword;
    private String newPassword;

}
