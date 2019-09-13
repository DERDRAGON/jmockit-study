##模拟Dubbo消费Bean

eg:dubbo-consumer.xml

上面xml配置是Dubbo的基本配置，配置了dubbo服务的zookeeper地址，还配置了名叫mailService的Dubbo消费Bean，用于在应用程序中发送邮件。<br/>
 我们在运行单元测试时，如果zookeeper连不上或者mailService的服务提供者不存在，则会导致Spring初始化失败， <br/>
 而且我们也不希望真正发送邮件（除非是为了测试发送邮件）。于是我们希望对mailService进行Mock。<br/>
下面给出一种Mock Dubbo消费Bean的方案：

1.在spring初始化前，对所有Dubbo消费Bean的进行Mock，即<dubbo>标签里的interface都返回本地默认实现。

2.如果想对某几个Dubbo消费Bean进行Mock，则自定义Dubbo消费Bean的实现即可。

eg:DubboConsumerBeanMockingTest