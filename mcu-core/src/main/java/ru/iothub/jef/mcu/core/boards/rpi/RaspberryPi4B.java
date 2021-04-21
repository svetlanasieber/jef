package ru.iothub.jef.mcu.core.boards.rpi;

import ru.iothub.jef.linux.gpio.PinSet;
import ru.iothub.jef.linux.i2c.I2CBus;
import ru.iothub.jef.linux.spi.SpiBus;
import ru.iothub.jef.linux.spi.SpiMode;
import ru.iothub.jef.mcu.core.boards.Board;
import ru.iothub.jef.mcu.core.boards.BoardPin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaspberryPi4B extends Board {
    private final static String GPIO_MAPPING = "/dev/gpiochip0";
    private final static int[] pinout = new int[] {
            0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27
    };

    private final List<BoardPin> pins;
    private final List<SpiBus> spis;

    public RaspberryPi4B() throws IOException {
        PinSet set = PinSet.getInstance(GPIO_MAPPING, pinout);
        this.pins = RaspberryPi4BPins.createPins(set);

        List<SpiBus> ss = new ArrayList<>();
        if(new File("/dev/spidev0.0").exists()) {
            ss.add(
                    new SpiBus("/dev/spidev0.0", 500000, SpiMode.SPI_MODE_3, 8, 0)
            );
        }

        if(new File("/dev/spidev0.1").exists()) {
            ss.add(
                    new SpiBus("/dev/spidev0.1", 500000, SpiMode.SPI_MODE_3, 8, 0)
            );
        }

        spis = Collections.unmodifiableList(ss);
    }

    @Override
    public int getPinCount() {
        return pins.size();
    }

    @Override
    public BoardPin getPin(int index) {
        return pins.get(index-1);
    }

    @Override
    public List<SpiBus> getSpiBuses() {
        return spis;
    }

    @Override
    public List<I2CBus> getI2CBuses() {
        return null;
    }
}