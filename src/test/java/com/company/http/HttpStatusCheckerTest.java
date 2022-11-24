package com.company.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpStatusCheckerTest {

    @Test
    public void testThatGetStatusImageHandledCorrectly() throws Exception {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        final String url = "https://http.cat/";
        int code = 200;
        String expectedStatusImage = url.concat(code + ".jpg");

        Assertions.assertEquals(expectedStatusImage, httpStatusChecker.getStatusImage(code));
        Assertions.assertThrowsExactly(Exception.class, () -> httpStatusChecker.getStatusImage(10000));
    }
}