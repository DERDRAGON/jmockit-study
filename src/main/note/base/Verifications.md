##Verifications是用于做验证。验证Mock对象

1.验证Mock对象<br/>
（即@Moked/@Injectable@Capturing修饰的或传入Expectation构造函数的对象)有没有调用过某方法，调用了多少次。与Exceptations的写法相似。如下：
```aidl
new Verifications() {
    // 这是一个Verifications匿名内部类
    {
          // 这个是内部类的初始化代码块，我们在这里写验证脚本，脚本的格式要遵循下面的约定
        //方法调用(可是类的静态方法调用，也可以是对象的非静态方法调用)
        //times/minTimes/maxTimes 表示调用次数的限定要求。赋值要紧跟在方法调用后面，也可以不写（表示只要调用过就行，不限次数）
        //...其它准备验证脚本的代码
        //方法调用
        //times/minTimes/maxTimes 赋值
    }
};
  
还可以再写new一个Verifications，只要出现在重放阶段之后均有效。
new Verifications() {
       
    {
         //...验证脚本
    }
};
```
eg:VerificationTest

通常，在实际测试程序中，我们更倾向于通过JUnit/TestNG/SpringTest的Assert类对测试结果的验证， 对类的某个方法有没调用，调用多少次的测试场景并不是太多。<br/>
因此在验证阶段，我们完全可以用JUnit/TestNG/SpringTest的Assert类取代new Verifications() {{}}验证代码块。<br/>
除非，你的测试程序关心类的某个方法有没有调用，调用多少次，你可以使用new Verifications() {{}}验证代码块。<br/>
如果你还关心方法的调用顺序，你可以使用new VerificationsInOrder() {{}} .这里就不做详细的介绍了。