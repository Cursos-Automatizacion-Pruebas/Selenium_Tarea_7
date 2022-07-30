package article;

import base.BaseTest;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.article.PostCommentPage;
import utilities.DataProviders;

import java.time.Duration;

public class PostCommentTest extends BaseTest {
    private PostCommentPage postCommentPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToArticle();
        commonFlows.fillArticle();
    }

    @Override
    protected void initPages() {
        postCommentPage = new PostCommentPage(driver);
    }

    @Test(groups = {regression})
    @Video
    public void verifyCommentIsDisplayed() {
        var comments = new DataProviders().getCommentsModel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        postCommentPage.fillComments(comments.getComments());
        postCommentPage.verifyCommentsIsDisplayed();
    }

    @Test(groups = {regression})
    public void verifyCommentWasDelete() {
        var comments = new DataProviders().getCommentsModel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        postCommentPage.fillComments(comments.getComments());
        postCommentPage.clickOnDeleteButton();
        postCommentPage.verifyCommentWasDelete();
    }
}
