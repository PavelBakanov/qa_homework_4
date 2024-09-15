import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void searchJUnit5ExampleCodeTest() {
        //Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide/");

        //Переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        //Открываем страницу SoftAssertions
        $(".Box-row.wiki-more-pages-link").$("button").click();
        $("div.wiki-rightbar").$(byText("SoftAssertions")).click();

        //Проверяем
        $(".markdown-body").shouldHave(text(""" 
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));
    }

}
