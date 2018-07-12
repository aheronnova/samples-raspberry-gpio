package org.acheron.sample.pi.gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Agent {

    static {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Agent.class);

    public static void main(String[] args) {
        LOGGER.info("Running GPIO sample");

        final GpioController gpio = GpioFactory.getInstance();
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "GPIO_Pin_01" , PinState.LOW);

        gpio.getProvisionedPins().forEach(pin -> LOGGER.info("Pin " + pin.getName() + " found."));
    }
}
