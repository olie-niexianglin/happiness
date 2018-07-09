package olie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/9 13:11
 * @Description:
 */
public class ReplaceConditionalLogicwithStrategyPatternTest {

    @Test
    public void low() {
        assertEquals(1825, insuranceFor(5000), 0.01);
    }

    @Test
    public void medium() {
        assertEquals(38600, insuranceFor(25000), 0.01);
    }

    @Test
    public void high() {
        assertEquals(78500, insuranceFor(50000), 0.01);
    }

    @Test
    public void veryHigh() {
        assertEquals(106400, insuranceFor(100_000), 0.01);
    }

    private double insuranceFor(double income) {
        return new ReplaceConditionalLogicwithStrategyPattern().calculateInsurance(income);
    }

}