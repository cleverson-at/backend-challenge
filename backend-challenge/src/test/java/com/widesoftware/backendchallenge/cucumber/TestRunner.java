package com.widesoftware.backendchallenge.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
                 glue="com.widesoftware.backendchallenge.cucumber.stepdefinitions", 
                 snippets = SnippetType.CAMELCASE)
public class TestRunner {}
