package junit_tests;

import com.kradova.pages.blog.BlogPage;
import com.kradova.pages.publications.PublicationsPage;
import com.kradova.util.WaitUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NewsCountTest extends JunitBaseTest {
    private static Stream<Arguments> testParams() {
        return Stream.of(
                arguments(BlogPage.FRONT_END_THEME, 121, "Front-end"),
                arguments(BlogPage.GAME_DEV_THEME, 5, "GameDev"),
                arguments(BlogPage.QA_THEME, 87, "QA")
        );
    }

    @ParameterizedTest(name = "{index} - {2}")
    @MethodSource("testParams")
    public void testAmountOfArticles(String themeName, int expectedArticles, String name) {
        blogPage.open();
        WebElement theme = blogPage.getThemeByName(themeName);
        WaitUtil.waitElementIsVisible(driver, theme);
        theme.click();
        WaitUtil.scrollPageBottom(driver);
        List<WebElement> articles = driver.findElements(PublicationsPage.article);
        Assertions.assertEquals(expectedArticles, articles.size());
    }
}
