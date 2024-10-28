package com.github.gorkiiuss.program3.junit.ejemplo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
    private Counter counter;

    @BeforeEach
    public void setUp() {
        counter = new Counter();
    }

    @Test
    public void testIncrement() {
        counter.increment();
        assertEquals(1, counter.getValue());
        assertTrue(counter.getValue() > 0);
        assertNotNull(counter);
    }

    @Test
    public void testDecrement() {
        counter.increment();
        counter.increment();
        counter.decrement();
        assertEquals(1, counter.getValue());
        assertFalse(counter.getValue() < 0);
    }

    @Test
    public void testDecrementBelowZero() {
        counter.decrement();
        assertEquals(0, counter.getValue());
        assertFalse(counter.getValue() < 0);
    }

    @Test
    public void testGetValue_initialValue() {
        assertEquals(0, counter.getValue());
        assertNotNull(counter);
        assertEquals(0, counter.getValue());
    }

    @Test
    public void testExceptionOnInvalidOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            counter.invalidOperation();
        });
    }

    @Test
    public void testReset() {
        counter.increment();
        counter.reset();
        assertEquals(0, counter.getValue(), "Reset should set value to 0, but it did not.");
    }
}
