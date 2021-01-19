package com.scurtis.recruits.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Data
@Entity
@Table(name = "recruits")
public class Player247 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "recruits_id_seq", allocationSize = 1, initialValue = 100)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private Integer siteId;
    private String name;
    private String position;
    private String height;
    private String weight;
    private String homeTown;
    private String highSchool;
    private Integer year;
    private String compositeRank;
    private Integer rankNational;
    private Integer rankPosition;
    private String welcomePagePlaylist;
    private Integer rankState;
    private Integer stars;
    private String link;
    private String college;

}
