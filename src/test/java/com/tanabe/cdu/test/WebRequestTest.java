package com.tanabe.cdu.test;

import com.tanabe.cdu.fixtures.WebPageFixture;
import com.tanabe.cdu.web.WebRequest;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by Brian on 8/23/14.
 */
public class WebRequestTest {

    @Test
    public void testCanDownloadWebPage(){
        try {
            String drinkLionHtml = WebRequest.getWebPage("http://www.drinklion.com");
            assertEquals("DrinkLion web pages did not match", drinkLionHtml, WebPageFixture.getDrinkLionDotComHtml().trim());
        } catch (IOException ex){
            fail("Failed to download http://www.drinklion.com");
            ex.printStackTrace();
        }
    }

    @Test
    public void testAnExceptionIsThrownForNonExistantWebSites(){
        try {
            WebRequest.getWebPage("http://www.drinklionn.com");
        } catch (IOException ex){
            assertNotNull(ex);
        }
    }

    @Test
    public void testRequestsWithoutHttpPrefix(){
        try {
            String drinkLionHtml = WebRequest.getWebPage("www.drinklion.com");
            assertEquals("DrinkLion web pages did not match", drinkLionHtml, WebPageFixture.getDrinkLionDotComHtml().trim());
        } catch (IOException ex){
            fail("Failed to download www.drinklion.com");
            ex.printStackTrace();
        }
    }

    @Test
    public void testRequestsWithoutHttpOrWwwPrefix(){
        try {
            String drinkLionHtml = WebRequest.getWebPage("drinklion.com");
            assertEquals("DrinkLion web pages did not match", drinkLionHtml, WebPageFixture.getDrinkLionDotComHtml().trim());
        } catch (IOException ex){
            fail("Failed to download drinklion.com");
            ex.printStackTrace();
        }
    }
}
