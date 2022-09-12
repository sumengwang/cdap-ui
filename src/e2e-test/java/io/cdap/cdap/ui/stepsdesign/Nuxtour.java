/*
 * Copyright © 2022 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.cdap.ui.stepsdesign;

import io.cdap.cdap.ui.utils.Constants;
import io.cdap.cdap.ui.utils.Helper;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.SeleniumDriver;
import io.cdap.e2e.utils.WaitHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Nuxtour {
  private static final String NUXTOUR_MODAL_XPATH =
    "//div[contains(@class, 'guided-tour-tooltip') and not(contains(@style, 'display: none'))]";
  private static final String NUXTOUR_TITLE_XPATH = NUXTOUR_MODAL_XPATH +
      "//*[contains(@class, 'shepherd-title')]";
  private static final String NUXTOUR_NEXT_XPATH = NUXTOUR_MODAL_XPATH +
    "//a[contains(@class, 'next-btn')]";
  private static final String NUXTOUR_COMPLETE_XPATH = NUXTOUR_MODAL_XPATH +
    "//a[contains(@class, 'complete-btn')]";
  private static final String NUXTOUR_PREVIOUS_XPATH = NUXTOUR_MODAL_XPATH +
    "//a[contains(@class, 'prev-btn')]";
  private static final String NUXTOUR_CANCEL_XPATH = NUXTOUR_MODAL_XPATH +
    "//a[contains(@class, 'shepherd-cancel-link')]";


  @When("Open CDAP welcome page")
  public void openCdap() {
    SeleniumDriver.openPage(Constants.CDAP_URL);
    Helper.setShowWelcomeSessionStorage();
    WaitHelper.waitForPageToLoad();
  }

  @Then("Welcome nux tour should exist")
  public void welcomeExists() {
    Helper.isElementExists(Helper.getCssSelectorByDataTestId("welcome-nux-tour"));
  }

  @Then("Click Start Tour button")
  public void clickStartTour() {
    ElementHelper.clickOnElement(
      Helper.locateElementByCssSelector(Helper.getCssSelectorByDataTestId("start-tour-btn"))
    );
  }

  @Then("Click No thanks button")
  public void clickNoThanks() {
    ElementHelper.clickOnElement(
      Helper.locateElementByCssSelector(Helper.getCssSelectorByDataTestId("no-tour-btn"))
    );
  }

  @Then("Check Don't show again checkbox")
  public void checkDontShowAgain() {
    ElementHelper.clickOnElement(
      Helper.locateElementByCssSelector(Helper.getCssSelectorByDataTestId("show-again-checkbox"))
    );
  }

  @Then("{string} title should exist")
  public void pipelineStudiosTitleExists(String title) {
    Assert.assertEquals(title,
                        Helper.locateElementByXPath(NUXTOUR_TITLE_XPATH).getText());
  }

  @Then("Click Nuxtour Next button")
  public void clickNextButton() {
    ElementHelper.clickOnElement(
      Helper.locateElementByXPath(NUXTOUR_NEXT_XPATH)
    );
  }

  @Then("Click Nuxtour Complete button")
  public void clickCompleteButton() {
    ElementHelper.clickOnElement(
      Helper.locateElementByXPath(NUXTOUR_COMPLETE_XPATH)
    );
  }

  @Then("Click Nuxtour Previous button")
  public void clickPreviousButton() {
    ElementHelper.clickOnElement(
      Helper.locateElementByXPath(NUXTOUR_PREVIOUS_XPATH)
    );
  }

  @Then("Click Nuxtour Cancel button")
  public void clickCancelButton() {
    ElementHelper.clickOnElement(
      Helper.locateElementByXPath(NUXTOUR_CANCEL_XPATH)
    );
  }

  @Then("Welcome tour should close")
  public void welcomeShouldClose() {
    Assert.assertEquals(false, Helper.isElementExists(Helper.getCssSelectorByDataTestId("welcome-nux-tour")));
  }
}