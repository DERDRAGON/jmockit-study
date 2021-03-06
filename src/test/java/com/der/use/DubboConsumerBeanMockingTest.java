package com.der.use;

import com.der.JmockitStudyApplication;
import com.der.base.api.MailService;
import mockit.Mock;
import mockit.MockUp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * dubbo消费bean Mock
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JmockitStudyApplication.class})
public class DubboConsumerBeanMockingTest {

    // 这里要@BeforeClass,因为要抢在spring加载dubbo前，对dubbo的消费工厂bean
    // ReferenceBean进行mock，不然dubbo可能因为连上不zk或无法找不
    // 服务的提供者等原因而无法初始化的，进而，单元测试运行不下去
    @BeforeClass
    public static void mockDubbo() {
        // 你准备mock哪个消费bean
        // 比如要对dubbo-consumber.xml里配置的com.der.base.api.MailService这个消费bean进行mock
        Map<String, Object> mockMap = new HashMap<String, Object>();
        mockMap.put("com.der.base.api.MailService", new MockUp(MailService.class) {
            // 在这里书写对这个消费bean进行mock的mock逻辑，想mock哪个方法，就自行添加，注意方法一定要加上@Mock注解哦
            @Mock
            public boolean sendMail(Long userId, String content) {
                // 单元测试时，不需要调用邮件服务器发送邮件，这里统一mock邮件发送成功
                return true;
            }
        }.getMockInstance());
        // 如果要Mock其它的消费bean，自行添加,mockMap.put.....如上
        new DubboConsumerBeanMockUp(mockMap);
    }

    // 现在你使用的dubbo消费bean就是本地mock过的了，并不是指向远程dubbo服务的bean了
    @Resource
    MailService mailService;

    @Test
    public void testSendMail() {
        long userId = 123456;
        String content = "test mail content";
        System.out.println(mailService.sendMail(userId, content));
    }
}
