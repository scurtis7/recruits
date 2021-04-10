package com.scurtis.recruits.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Player247Test {

    private Player247 player247;

    @BeforeEach
    void setup() {
        player247 = new Player247();
    }

    @Test
    void testClassAnnotations() {
        Entity entity = Player247.class.getAnnotation(Entity.class);
        Table table = Player247.class.getAnnotation(Table.class);

        assertNotNull(entity);
        assertEquals("recruits", table.name());
    }

    @Test
    void testId() throws NoSuchFieldException {
        Id id = Player247.class.getDeclaredField("id").getAnnotation(Id.class);
        GeneratedValue generatedValue = Player247.class.getDeclaredField("id").getAnnotation(GeneratedValue.class);
        SequenceGenerator sequenceGenerator = Player247.class.getDeclaredField("id").getAnnotation(SequenceGenerator.class);
        Column column = Player247.class.getDeclaredField("id").getAnnotation(Column.class);

        assertNotNull(id);
        assertEquals(GenerationType.SEQUENCE, generatedValue.strategy());
        assertEquals("sequence-generator", generatedValue.generator());
        assertEquals("sequence-generator", sequenceGenerator.name());
        assertEquals("recruits_id_seq", sequenceGenerator.sequenceName());
        assertEquals(1, sequenceGenerator.allocationSize());
        assertEquals(100, sequenceGenerator.initialValue());
        assertEquals("id", column.name());
        assertTrue(column.unique());
        assertFalse(column.nullable());

        assertNull(player247.getId());
        player247.setId(1L);
        assertEquals(1, player247.getId());
    }

//    private Integer siteId;
//    private String name;
//    private String position;
//    private String height;
//    private String weight;
//    private String homeTown;
//    private String highSchool;
//    private Integer year;
//    private String compositeRank;
//    private Integer rankNational;
//    private Integer rankPosition;
//    private String welcomePagePlaylist;
//    private Integer rankState;
//    private Integer stars;
//    private String link;
//    private String college;
}
