package gs4.kingbbode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by YG on 2017-07-14.
 */
public class KingbbodeCalculatorTest {
    private KingbbodeInteger i1 = new KingbbodeInteger(1);
    private KingbbodeInteger i2 = new KingbbodeInteger(2);
    private KingbbodeInteger i3 = new KingbbodeInteger(3);
    private KingbbodeDouble d1 = new KingbbodeDouble(1);
    private KingbbodeDouble d2 = new KingbbodeDouble(2);
    private KingbbodeDouble d3 = new KingbbodeDouble(3);
    
    
    @Test(expected = RuntimeException.class)
    public void 나누기_0_으로는_못나눔(){
        new KingbbodeCalculator(d1).divided(new KingbbodeInteger(0));
    }

    @Test
    public void 더하기_테스트_INTEGER() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(i1).plus(i2,i3).calculate(), "6");
    }

    @Test
    public void 더하기_테스트_DOUBLE() throws Exception {        
        Assert.assertEquals(new KingbbodeCalculator(d1).plus(d2,d3).calculate(), "6.0");
    }

    @Test
    public void 빼기_테스트_INTEGER() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(i3).minus(i1).calculate(), "2");
    }

    @Test
    public void 빼기_테스트_DOUBLE() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(d3).minus(d1).calculate(), "2.0");
    }

    @Test
    public void 곱하기_테스트_INTEGER() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(i3).multiply(i2).calculate(), "6");
    }

    @Test
    public void 곱하기_테스트_DOUBLE() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(d3).multiply(d2).calculate(), "6.0");
    }

    @Test
    public void 나누기_테스트_INTEGER() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(i3).divided(i2).calculate(), "1");
    }

    @Test
    public void 나누기_테스트_DOUBLE() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(d3).divided(d2).calculate(), "1.5");
    }

    @Test
    public void 형변환_보장_테스트() throws Exception {
        Assert.assertEquals(new KingbbodeCalculator(i1).plus(i2,i3).divided(d2).calculate(), "3.0");
    }
}
