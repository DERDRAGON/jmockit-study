##Expectations作用

主要是用于录制。即录制类/对象的调用，返回值是什么。
```aidl
new Expectations() {
    // 这是一个Expectations匿名内部类
    {
          // 这是这个内部类的初始化代码块，我们在这里写录制脚本，脚本的格式要遵循下面的约定
        //方法调用(可是类的静态方法调用，也可以是对象的非静态方法调用)
        //result赋值要紧跟在方法调用后面
        //...其它准备录制脚本的代码
        //方法调用
        //result赋值
    }
};
 
还可以再写new一个Expectations，只要出现在重放阶段之前均有效。
new Expectations() {
      
    {
         //...录制脚本
    }
};
```
###Expectations主要有两种使用方式。
1.通过引用外部类的Mock对象(@Injectabe,@Mocked,@Capturing)来录制<br/>
    在这个例子中，在Expectations匿名内部类的初始代码块中，我们可以对外部类的任意成员变量，方法进行调用。大大便利我们书写录制脚本。

2.通过构建函数注入类/对象来录制<br/>
    在上面的例子中，我们通过引用外部类的Mock对象(@Injectabe,@Mocked,@Capturing)来录制，可是无论是@Injectabe,@Mocked,@Capturing哪种Mock对象，都是对类的方法都mock了，可是有时候，我们只希望JMockit只mock类/对象的某一个方法。怎么办？ 看下面的例子就明白啦。