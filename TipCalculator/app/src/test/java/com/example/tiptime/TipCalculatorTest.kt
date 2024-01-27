package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        // given
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // when
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)

        // then
        assertEquals(expectedTip, actualTip)
    }
}
