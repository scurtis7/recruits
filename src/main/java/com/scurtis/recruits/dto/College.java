package com.scurtis.recruits.dto;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Data
public class College {

    private Integer id;
    private String siteName;
    private String displayName;
    private String conference;
    private String division;

}
