package com.battery;

public class BatteryMonitor {

    public String checkBatteryCondition(
            double voltage,
            double current,
            double temperature,
            int chargeLevel) {

        if (voltage <= 0 || current < 0
                || chargeLevel < 0 || chargeLevel > 100) {

            throw new IllegalArgumentException(
                    "Invalid battery input");
        }

        if (temperature >= 60) {
            return "Over Temperature";
        }

        if (voltage < 10.5) {
            return "Low Voltage";
        }

        if (voltage > 14.5) {
            return "Over Voltage";
        }

        if (chargeLevel <= 5) {
            return "Critical";
        }

        return "Normal";
    }

    public static void main(String[] args) {

        BatteryMonitor monitor = new BatteryMonitor();

        double voltage = 12.5;
        double current = 2.0;
        double temperature = 30.0;
        int chargeLevel = 80;

        String condition = monitor.checkBatteryCondition(
                voltage,
                current,
                temperature,
                chargeLevel
        );

        System.out.println("Smart Battery Monitoring System");
        System.out.println("--------------------------------");

        System.out.println("Battery Voltage: " + voltage + " V");

        System.out.println("Battery Current: " + current + " A");

        System.out.println("Battery Temperature: "
                + temperature + " C");

        System.out.println("Charge Level: " + chargeLevel + "%");

        System.out.println("Battery Condition: " + condition);
    }
}

