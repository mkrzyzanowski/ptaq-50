package org.ptaq.bobcat.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class GithubRepos {

  @FindBy(css = "#your-repos-filter")
  private WebElement searchBox;

  @FindBy(css = ".user-repo-search-results-summary")
  private WebElement resultsMessage;

  public void searchForRepo(String name) {
    searchBox.sendKeys(name);
  }

  public String getResultsMessage() {
    return resultsMessage.getText();
  }
}
