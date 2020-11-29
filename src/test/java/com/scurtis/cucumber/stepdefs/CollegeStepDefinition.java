package com.scurtis.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Author: Steve Curtis
 * Date: Nov 29, 2020
 **/

@ExtendWith(SpringExtension.class)
public class CollegeStepDefinition {

    @Given("the colleges are in the database")
    public void collegesInDatabase() {
        System.out.println("collegesInDatabase()");
    }

    @When("the client calls GET colleges")
    public void clientCallsGetColleges() {
        System.out.println("clientCallsGetColleges()");
    }

//    @Then("the client receives status code {200}")
//    public void clientReceivesStatus(int status) {
//
//    }
    @Then("the client receives status code {int}")
    public void theClientReceivesStatusCode(int status) {
        System.out.println("theClientReceivesStatusCode(" + status + ")");
    }

    @Then("the client receives a list of colleges")
    public void clientReceivesListOfColleges() {
        System.out.println("clientReceivesListOfColleges()");
    }

}
