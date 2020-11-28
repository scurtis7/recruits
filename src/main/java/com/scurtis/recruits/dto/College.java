package com.scurtis.recruits.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Data
@Entity
@Table(name = "colleges")
public class College {

    @Id
    private Integer id;
    private String siteName;
    private String displayName;
    private String conference;
    private String division;

}
