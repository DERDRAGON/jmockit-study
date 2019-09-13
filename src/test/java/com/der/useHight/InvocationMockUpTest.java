package com.der.useHight;

import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @program: jmockit-study
 * @description: Mock方法中还可以调用老方法
 * @author: long
 * @create: 2019-07-30 13:41
 */
public class InvocationMockUpTest {

    @Test
    public void testMockUp() {
        // 对Java自带类Calendar的get方法进行定制
        new MockUp<Calendar>(Calendar.class) {
            // 申明参数invocation，表示老方法的调用
            @Mock
            public int get(Invocation invocation, int unit) {
                // 只希望时间是早上7点
                if (unit == Calendar.HOUR_OF_DAY) {
                    return 7;
                }
                // 其它时间（年份，月份，日，分，秒均不变)
                return invocation.proceed(unit);
            }
        };
        Calendar now = Calendar.getInstance();
        // 只有小时变成Mock方法
        assertEquals(7, now.get(Calendar.HOUR_OF_DAY));
        // 其它的还是走老的方法
        assertEquals(now.get(Calendar.MONTH), (new Date()).getMonth());
        assertEquals(now.get(Calendar.DAY_OF_MONTH), (new Date()).getDate());
    }
}
