 ##Mock接口
2种Mock接口的2种方法。

1.用Expectations来Mock<br/>
eg:InterfaceMockingByExpectationsTest

2.用MockUp来Mock<br/>
eg:InterfaceMockingByMockUpTest<br/>
显然， 在Mock接口时，使用@Injectable注解API，比使用MockUp更方便。单纯通过MockUp生成接口的某个Mock实例，在实际的测试场景中并没有多大用途，接口就是用来给类依赖的，我们要充分利用JMockit的依赖注入功能。