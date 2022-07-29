package article;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.article.ArticlePage;
import pageobjects.article.PostCommentPage;
import utilities.DataProviders;

import java.time.Duration;

public class ArticleTest extends BaseTest {
    private ArticlePage articlePage;
    private PostCommentPage postCommentPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToArticle();
    }

    @Override
    protected void initPages() {
        articlePage = new ArticlePage(driver);
        postCommentPage = new PostCommentPage(driver);
    }

    @Test(groups = {regression})
    public void verifyArticlePageTest() {
        articlePage.verifyPage();
    }

   @Test(groups = {regression})
    public void verifyTitleIsDisplayed() {
        var articles = new DataProviders().getArticleData();
        articlePage.fillArticle(articles.getTitulo(), articles.getAsunto(), articles.getDetalle(), articles.getEtiqueta());
        postCommentPage.waitPageToLoad();
        postCommentPage.setTitle(articles.getTitulo());
        postCommentPage.verifyTitleIsDisplayed();
    }

    @Test(groups = {regression})
    public void verifyTitleEditIsDisplayed() {
        commonFlows.fillArticle();
        postCommentPage.clickOnEditButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        articlePage.verifyPage();
        var articles = new DataProviders().getArticleData();
        articlePage.fillArticle(articles.getTitulo(), articles.getAsunto(), articles.getDetalle(), articles.getEtiqueta());
        postCommentPage.waitPageToLoad();
        postCommentPage.setTitle(articles.getTitulo());
        postCommentPage.verifyTitleIsDisplayed();
    }
}
