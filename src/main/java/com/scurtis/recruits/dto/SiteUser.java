package com.scurtis.recruits.dto;

import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private Role role;
}
