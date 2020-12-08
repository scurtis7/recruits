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
@Table(name = "user-accounts")
public class UserAccount {

    @Id
    private Integer id;
    private String name;
    private String username;
    private String password;

}
