package cuke.acceptance_tests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "classpath:cuke", 

	glue = {"classpath:cuke/acceptance_tests/"},
	plugin = { "html:target/cucumber/wikipedia.html"}, 
	monochrome=true, 
	snippets = SnippetType.CAMELCASE,
	tags = {"not @ignored"}
	)
public class AcceptanceTest {
}
