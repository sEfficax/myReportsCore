package com.efficax.myreports.core;

import com.efficax.myreports.core.manager.MyReportsManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyReportsManagerTests {
    @Test
    void testOrganization() {
        MyReportsManager manager= new MyReportsManager();
        manager.getDetailsById("1");
    }
}
