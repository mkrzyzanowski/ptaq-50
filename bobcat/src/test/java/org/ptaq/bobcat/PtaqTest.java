package org.ptaq.bobcat;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.ptaq.bobcat.pageobjects.GithubRepos;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class PtaqTest {

  public static final String URL = "https://github.com/mkrzyzanowski?tab=repositories";

  @Inject
  private WebDriver webDriver;

  @Inject
  private GithubRepos githubRepos;

  @Test
  public void isPtaqThere() {
    webDriver.get(URL);

    githubRepos.searchForRepo("ptaq");

    Assert.assertThat(githubRepos.getResultsMessage(), not(containsString("0")));
  }
}
