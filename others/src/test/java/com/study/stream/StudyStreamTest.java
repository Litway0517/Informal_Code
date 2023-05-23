package com.study.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class StudyStreamTest {

    @Resource
    private StudyStream studyStream;

    @Test
    public void testFilter() {
        studyStream.testFilter();
    }

    @Test
    public void testFindAny() {
        studyStream.testFindAny();
    }
}
