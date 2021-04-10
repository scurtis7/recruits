package com.scurtis.recruits.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class CollegeTest {

    College college;

    @BeforeEach
    void setup() {
        college = new College();
    }

    @Test
    void testClassAnnotations() {
        Entity entity = College.class.getAnnotation(Entity.class);
        Table table = College.class.getAnnotation(Table.class);

        assertNotNull(entity);
        assertEquals("colleges", table.name());
    }

    @Test
    void testId() throws NoSuchFieldException {
        Id id = College.class.getDeclaredField("id").getAnnotation(Id.class);

        assertNotNull(id);

        assertNull(college.getId());
        college.setId(1);
        assertEquals(1, college.getId());
    }

    @Test
    void testSiteName() {
        assertNull(college.getSiteName());
        college.setSiteName("site name");
        assertEquals("site name", college.getSiteName());
    }

    @Test
    void testDisplayName() {
        assertNull(college.getDisplayName());
        college.setDisplayName("display name");
        assertEquals("display name", college.getDisplayName());
    }

    @Test
    void testConference() {
        assertNull(college.getConference());
        college.setConference("conference");
        assertEquals("conference", college.getConference());
    }

    @Test
    void testDivision() {
        assertNull(college.getDivision());
        college.setDivision("division");
        assertEquals("division", college.getDivision());
    }

}
