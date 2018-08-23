package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="features/Application.feature", 
				  glue= {"stepDefination"})
public class LoginRunner {

}
