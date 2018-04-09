$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/provided/add_book.feature");
formatter.feature({
  "name": "Add book",
  "description": "\tDescription: A book is added to the library\n\tActors: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a book successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have a book with title \"Extreme Programming\", author \"Kent Beck\", and signature \"Beck99\"",
  "keyword": "And "
});
formatter.match({
  "location": "BookSteps.iHaveABookWithTitleAuthorAndSignature(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the book",
  "keyword": "When "
});
formatter.match({
  "location": "BookSteps.iAddTheBook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the book with title \"Extreme Programming\", author \"Kent Beck\", and signature \"Beck99\" is added to the library",
  "keyword": "Then "
});
formatter.match({
  "location": "BookSteps.theBookWithTitleAuthorAndSignatureIsAddedToTheLibrary(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a book when the adminstrator is not logged in",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have a book with title \"Extreme Programming\", author \"Kent Beck\", and signature \"Beck99\"",
  "keyword": "And "
});
formatter.match({
  "location": "BookSteps.iHaveABookWithTitleAuthorAndSignature(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the book",
  "keyword": "When "
});
formatter.match({
  "location": "BookSteps.iAddTheBook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Administrator login required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BookSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/provided/admin_login.feature");
formatter.feature({
  "name": "Admin login",
  "description": "\tDescription: The administrator logs into the library system and also logs out\n\tActor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Administrator can login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password is \"adminadmin\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thePasswordIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator login succeeds",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdministratorLoginSucceeds()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat dtu.library.acceptance_tests.LoginLogoutSteps.theAdministratorLoginSucceeds(LoginLogoutSteps.java:32)\n\tat ✽.the administrator login succeeds(use_cases/provided/admin_login.feature:8)\n",
  "status": "failed"
});
formatter.step({
  "name": "the adminstrator is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdminstratorIsLoggedIn()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Administrator has the wrong password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password is \"wrong password\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "error_message": "cucumber.runtime.AmbiguousStepDefinitionsException: \"the password is \"wrong password\"\" matches more than one step definition:\n  \"^the password is \"([^\"]*)\"$\" in LoginLogoutSteps.thePasswordIs(String)\n  \"^the password is \"wrong password\"$\" in LoginLogoutSteps.thePasswordIsWrongPassword(String)\n\n\tat cucumber.runtime.RuntimeGlue.stepDefinitionMatch(RuntimeGlue.java:80)\n\tat cucumber.runner.Runner.addTestStepsForPickleSteps(Runner.java:111)\n\tat cucumber.runner.Runner.createTestCaseForPickle(Runner.java:99)\n\tat cucumber.runner.Runner.runPickle(Runner.java:79)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:140)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:117)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:55)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:126)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "ambiguous"
});
formatter.step({
  "name": "the administrator login fails",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdministratorLoginFails1()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the administrator is not logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdministratorIsNotLoggedInAndHasFailed()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("use_cases/provided/admin_logout.feature");
formatter.feature({
  "name": "Admin logout",
  "description": "\tDescription: The administrator logs out from the library system\n\tActor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Administrator logs out",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator logs out",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdministratorLogsOut()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator is not logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdministratorIsNotLoggedInAndHasFailed()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/provided/register_user.feature");
formatter.feature({
  "name": "Register user",
  "description": "\tDescription: The administrator registers a user of the library\n\tActors: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Register a user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a user with CPR \"020563-4886\", name \"Helena M. Bertelsen\", e-mail \"HelenaMBertelsen@rhyta.com \"",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAUserWithCPRNameEMail(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has address street \"Slåenhaven 50\", post code 4560, and city \"Vig\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserHasAddressStreetPostCodeAndCity(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator registers the user",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theAdministratorRegistersTheUser()"
});
formatter.result({
  "error_message": "dtu.library.app.OperationNotAllowedException: Administrator login required\n\tat dtu.library.acceptance_tests.UserSteps.theAdministratorRegistersTheUser(UserSteps.java:39)\n\tat ✽.the administrator registers the user(use_cases/provided/register_user.feature:9)\n",
  "status": "failed"
});
formatter.step({
  "name": "the user is a registered user of the library",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theUserIsARegisteredUserOfTheLibrary()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Register a user when not the administrator",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a user with CPR \"020563-4886\", name \"Helena M. Bertelsen\", e-mail \"HelenaMBertelsen@rhyta.com \"",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAUserWithCPRNameEMail(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has address street \"Slåenhaven 50\", post code 4560, and city \"Vig\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserHasAddressStreetPostCodeAndCity(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator registers the user",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theAdministratorRegistersTheUser()"
});
formatter.result({
  "error_message": "dtu.library.app.OperationNotAllowedException: Administrator login required\n\tat dtu.library.acceptance_tests.UserSteps.theAdministratorRegistersTheUser(UserSteps.java:39)\n\tat ✽.the administrator registers the user(use_cases/provided/register_user.feature:16)\n",
  "status": "failed"
});
formatter.step({
  "name": "I get the error message \"Administrator login required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BookSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Register a user that is already registered",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a user is registered with the library",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.aUserIsRegisteredWithTheLibrary()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat dtu.library.acceptance_tests.UserSteps.aUserIsRegisteredWithTheLibrary(UserSteps.java:50)\n\tat ✽.a user is registered with the library(use_cases/provided/register_user.feature:20)\n",
  "status": "failed"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the administrator registers the user again",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theAdministratorRegistersTheUserAgain()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I get the error message \"User is already registered\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BookSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "skipped"
});
});