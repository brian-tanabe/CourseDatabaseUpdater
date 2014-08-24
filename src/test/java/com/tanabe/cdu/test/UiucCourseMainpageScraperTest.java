package com.tanabe.cdu.test;

import com.tanabe.cdu.scrapers.UiucCourseMainPageScraper;
import org.junit.Test;

/**
 * Created by Brian on 8/23/14.
 */
public class UiucCourseMainpageScraperTest {


    @Test
    public void testCreate(){
        UiucCourseMainPageScraper scraper = new UiucCourseMainPageScraper();
    }

    @Test
    public void testCanDownloadPage(){
        UiucCourseMainPageScraper scraper = new UiucCourseMainPageScraper();
        scraper.scrape();
    }
}
