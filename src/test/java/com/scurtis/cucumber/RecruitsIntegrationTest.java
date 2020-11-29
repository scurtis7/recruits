package com.scurtis.cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Author: Steve Curtis
 * Date: Nov 28, 2020
 **/

@ExtendWith(SpringExtension.class)
@CucumberOptions(features = "src/integTest/resources")
public class RecruitsIntegrationTest {
}
