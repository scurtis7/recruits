package com.scurtis.recruits;

import com.scurtis.recruits.config.PostgresJdbcProperties;
import com.scurtis.recruits.controller.CollegeController;
import com.scurtis.recruits.controller.PlayerController;
import com.scurtis.recruits.storage.CollegeDataAccess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class RecruitsApplicationTests {

    @Autowired
    private PostgresJdbcProperties postgresJdbcProperties;
    @Autowired
    private CollegeController collegeController;
    @Autowired
    private PlayerController playerController;
    @Autowired
    private CollegeDataAccess collegeDataAccess;

	@Test
	void contextLoads() {
        assertNotNull(postgresJdbcProperties);
        assertNotNull(collegeController);
        assertNotNull(playerController);
        assertNotNull(collegeDataAccess);
	}

}
