package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldSetMaxStation() {
        Radio radio = new Radio(12);
        assertEquals(12, radio.getMaxStation());
    }

    @Test
    public void shouldIncreaseWithNewMaxStation() {
        Radio radio = new Radio(12);
        radio.setCurrentStation(10);
        radio.nextCurrentStation();
        assertEquals(11, radio.getCurrentStation());
    }

    @Test
    public void shouldSetRequiredStation() {
        radio.setCurrentStation(6);
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldNextCurrentStation() {
        radio.setCurrentStation(6);
        radio.nextCurrentStation();
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevCurrentStation() {
        radio.setCurrentStation(5);
        radio.prevCurrentStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldNextCurrentStationIfLimit() {
        radio.setCurrentStation(10);
        radio.nextCurrentStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextCurrentStationIfOverLimit() {
        radio.setCurrentStation(13);
        radio.nextCurrentStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevCurrentStationIfLimit() {
        radio.setCurrentStation(0);
        radio.prevCurrentStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevCurrentStationIfUnderLimit() {
        radio.setCurrentStation(-10);
        radio.prevCurrentStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseCurrentVolume() {
        radio.setCurrentVolume(50);
        radio.increaseCurrentVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeIfOverLimit() {
        radio.setCurrentVolume(150);
        radio.increaseCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseCurrentVolume() {
        radio.setCurrentVolume(50);
        radio.decreaseCurrentVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseCurrentVolumeIfUnderLimit() {
        radio.setCurrentVolume(-100);
        radio.decreaseCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}