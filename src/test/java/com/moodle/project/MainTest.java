package com.moodle.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testMain() {
        Main main = new Main();
        try {
            String[] args = new String[1];
            args[0] = "test";
            main.main(new String[0]);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}