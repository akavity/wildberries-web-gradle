package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.NavigationPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class NavigationSteps {
    NavigationPage navigationPage = new NavigationPage();

    @Step
    public void clickMainListItem(String item) {
        log.info("CLick main-list item: {}", item);
        navigationPage.getMailListElement().shouldBe(visible);
        navigationPage.getMainListItem(item).click();
    }

    @Step
    public void hoverMainListItem(String item) {
        log.info("Hover main-list item: {}", item);
        navigationPage.getMailListElement().shouldBe(exist, Duration.ofSeconds(5));
        navigationPage.getMainListItem(item).hover();
    }

    @Step
    public void clickDropListItem(String itemML, String itemDL1, String itemDL2) {
        log.info("Click first item of drop list: {}", itemDL1);
        navigationPage.getFirstDropListItem(itemML, itemDL1).click();
        if (itemDL2.equalsIgnoreCase("no")) {
            log.info("Drop list doesn't have second item");
        } else {
            log.info("Drop list have second item: {}", itemDL2);
            navigationPage.getDropListTitle(itemML, itemDL1).shouldBe(visible);
            navigationPage.getSecondDropListItem(itemML, itemDL2).click();
        }
    }
}
