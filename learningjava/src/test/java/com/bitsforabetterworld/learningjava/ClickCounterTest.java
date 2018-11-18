package com.bitsforabetterworld.learningjava;

import static org.junit.Assert.*;

import org.junit.Test;

class ClickCounter {
	private int count = 0;

	public void click() {
		count++; // add 1 to count
	}

	public int getCount() {
		return count;
	}
}

/**
 * Unit test for simple App.
 */
public class ClickCounterTest 
{

    @Test
    public void TestCountStartsAtZero() {
        ClickCounter cc = new ClickCounter();
        assertEquals(0, cc.getCount());
    }

    @Test
    public void TestClickingTwice() {
        ClickCounter cc = new ClickCounter();
        cc.click();
        cc.click();
        assertEquals(2, cc.getCount());
    }

    @Test
    public void TestEachCountsIndependently() {
        // Make 2 ClickCounters, ca and cb.
        // Click ca 3 times and cb 7 times, and expect
        // the counts to be correct.
        ClickCounter ca = new ClickCounter();
        ClickCounter cb = new ClickCounter();

        for (int i = 0; i < 3; i++) {
            ca.click();
        }
        for (int i = 0; i < 7; i++) {
            cb.click();
        }

        assertEquals(3, ca.getCount());
        assertEquals(7, cb.getCount());
    }
}
