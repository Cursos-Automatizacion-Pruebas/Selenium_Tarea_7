package article;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.article.ArticlePage;
import pageobjects.article.PostCommentPage;
import pageobjects.profile.ProfilePage;
import utilities.DataProviders;

import java.time.Duration;

public class ArticleTest extends BaseTest {
    private ArticlePage articlePage;
    private PostCommentPage postCommentPage;
    private ProfilePage profilelPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToArticle();
    }

    @Override
    protected void initPages() {
        articlePage = new ArticlePage(driver);
        postCommentPage = new PostCommentPage(driver);
        profilelPage = new ProfilePage(driver);
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
        postCommentPage.clickOnEditArticleButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        articlePage.verifyPage();
        var articles = new DataProviders().getArticleData();
        articlePage.fillArticle(articles.getTitulo(), articles.getAsunto(), articles.getDetalle(), articles.getEtiqueta());
        postCommentPage.waitPageToLoad();
        postCommentPage.setTitle(articles.getTitulo());
        postCommentPage.verifyTitleIsDisplayed();
    }

    @Test(groups = {regression})
    public void verifyArticleWasDelete() {
        commonFlows.fillArticle();
        postCommentPage.clickOnDeleteArticleButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        profilelPage.clickOnUsernameImg();
        var articles = new DataProviders().getArticleData();
        profilelPage.verifyArticleWasDelete(articles.getTitulo());
    }
}
