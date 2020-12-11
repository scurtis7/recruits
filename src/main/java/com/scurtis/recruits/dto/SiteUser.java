package com.scurtis.recruits.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Data
@Entity
@Table(name = "site_user")
public class SiteUser {

    @Id
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private Role role;
}
