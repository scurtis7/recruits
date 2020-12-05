package com.scurtis.integTest;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ActiveProfiles;

/**
 * Author: Steve Curtis
 * Date: Nov 28, 2020
 **/

@CucumberContextConfiguration
@ActiveProfiles("test")
public class RecruitsIntegrationTest {
}
