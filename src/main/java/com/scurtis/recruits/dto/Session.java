package com.scurtis.recruits.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Author: Steve Curtis
 * Date: Dec 15, 2020
 **/

@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(generator = "session_id_seq")
    private Integer id;
    private LocalDateTime created;
    private Integer expiration;
    private String username;

}
