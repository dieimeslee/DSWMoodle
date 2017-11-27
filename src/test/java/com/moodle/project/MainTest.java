package com.moodle.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testMain() {
        Main main = new Main();
        try {
            main.main(new String[0]);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}