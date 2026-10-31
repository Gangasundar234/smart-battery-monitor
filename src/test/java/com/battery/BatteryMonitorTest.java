package com.battery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryMonitorTest {

    BatteryMonitor monitor = new BatteryMonitor();

    @Test
    void testNormal() {
        assertEquals("Normal",
            monitor.checkBatteryCondition(12.5, 2.0, 30.0, 80));
    }

    @Test
    void testLowVoltage() {
        assertEquals("Low Voltage",
            monitor.checkBatteryCondition(9.0, 2.0, 30.0, 80));
    }

    @Test
    void testOverVoltage() {
        assertEquals("Over Voltage",
            monitor.checkBatteryCondition(15.0, 2.0, 30.0, 80));
    }

    @Test
    void testOverTemperature() {
        assertEquals("Over Temperature",
            monitor.checkBatteryCondition(12.5, 2.0, 65.0, 80));
    }

    @Test
    void testCritical() {
        assertEquals("Critical",
            monitor.checkBatteryCondition(12.5, 2.0, 30.0, 5));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class,
            () -> monitor.checkBatteryCondition(0, 2.0, 30.0, 80));
    }
}