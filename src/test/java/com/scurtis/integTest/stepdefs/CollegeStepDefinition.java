package com.scurtis.integTest.stepdefs;

import com.scurtis.recruits.dto.College;
import com.scurtis.recruits.dto.CollegeRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Author: Steve Curtis
 * Date: Nov 29, 2020
 **/

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CollegeStepDefinition {

    @Autowired
    private CollegeRepository repository;

    @Given("the colleges are in the database")
    public void collegesInDatabase() {
        loadCollegesToDatabase();
    }

    @When("the client calls GET colleges")
    public void clientCallsGetColleges() {
        callGetColleges();
    }

    @Then("the client receives status code {int}")
    public void theClientReceivesStatusCode(int status) {
        System.out.println("theClientReceivesStatusCode(" + status + ")");
    }

    @Then("the client receives a list of colleges")
    public void clientReceivesListOfColleges() {
        System.out.println("clientReceivesListOfColleges()");
    }

    private void loadCollegesToDatabase() {
        College college = new College();
        college.setSiteName("boston-college");
        college.setDisplayName("Boston College");
        college.setConference("ACC");
        college.setDivision("Atlantic");
        repository.save(college);
        college = new College();
        college.setSiteName("maryland");
        college.setDisplayName("University of Maryland");
        college.setConference("Big 10");
        college.setDivision("East");
        repository.save(college);
        college = new College();
        college.setSiteName("arizona-state");
        college.setDisplayName("Arizona State University");
        college.setConference("Pac 12");
        college.setDivision("NA");
        repository.save(college);
        college = new College();
        college.setSiteName("oklahoma");
        college.setDisplayName("University of Oklahoma");
        college.setConference("Big 12");
        college.setDivision("NA");
        repository.save(college);
        college = new College();
        college.setSiteName("auburn");
        college.setDisplayName("Auburn University");
        college.setConference("SEC");
        college.setDivision("West");
        repository.save(college);
    }

    private void callGetColleges() {

    }

}
