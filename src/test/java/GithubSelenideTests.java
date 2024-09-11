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
    void searchJUnit5ExampleCode() {
        //Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide/");

        //Переходим в раздел Wiki проекта
        $("#wiki-tab").click();


        //Открываем страницу SoftAssertions, и проверяем, что внутри есть пример кода для JUnit5
        $(".Box-row.wiki-more-pages-link").$("button").click();
        $("div.wiki-rightbar").$(byText("SoftAssertions")).click();

        /* Я нашел информацию, что аннотации @ExtendWith не было в Junit4. Она добавилась только в Junit5,
        поэтому надеюсь, что это будет именно пример кода на Junit5 =) */
        $(".markdown-body").shouldHave(text("@ExtendWith"));

    }

}
