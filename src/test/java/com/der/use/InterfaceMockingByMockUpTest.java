package com.der.use;

import com.der.base.api.AnOrdinaryInterface;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p> @ClassName InterfaceMockingByMockUpTest </p>
 * <p> @Desctiption TODO 用MockUp来mock接口 </p>
 * <p> @Author 曹世龙 </p>
 * <p> @Date 2019/7/29 0:14 </p>
 * <p> @Version 1.0 </p>
 **/
public class InterfaceMockingByMockUpTest {

    @Test
    public void testInterfaceMockingByMockUp() {
        // 手工通过MockUp创建这个接口的实例
        AnOrdinaryInterface anOrdinaryInterface = new MockUp<AnOrdinaryInterface>(AnOrdinaryInterface.class) {
            // 对方法Mock
            @Mock
            public int method1() {
                return 10;
            }

            @Mock
            public int method2() {
                return 20;
            }
        }.getMockInstance();

        Assert.assertTrue(anOrdinaryInterface.method1() == 10);
        Assert.assertTrue(anOrdinaryInterface.method2() == 20);
    }

}
