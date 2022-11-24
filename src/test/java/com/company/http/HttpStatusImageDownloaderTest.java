package com.company.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class HttpStatusImageDownloaderTest {

    @Test
    public void testThatImageDownloaderHandledCorrectly() throws Exception {
        int code = 200;
        File expectedFile = new File("downloadedImages/" + code + ".jpg");
        new HttpStatusImageDownloader().downloadStatusImage(code);
        Assertions.assertNotNull(expectedFile);
    }
}