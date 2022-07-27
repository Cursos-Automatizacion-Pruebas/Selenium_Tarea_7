package article;

import base.BaseTest;
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
    articlePage=new ArticlePage(driver);
        postCommentPage=new PostCommentPage(driver);
    }

    @Test(groups = {regression})
    public void verifyTitleIsDisplayed() {
        var articles = new DataProviders().getArticleData();
        articlePage.fillLogin(articles.getTitulo(),articles.getAsunto(),articles.getDetalle(),articles.getEtiqueta());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        postCommentPage.waitPageToLoad();
        postCommentPage.setTitle(articles.getTitulo());
        postCommentPage.verifyTitleIsDisplayed();
    }
}
