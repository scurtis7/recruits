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
    @GeneratedValue(generator = "site_user_id_seq")
    private Integer id;
    private String fullname;
    private String username;
    private String password;
    private Role role;
    private String college;
}
