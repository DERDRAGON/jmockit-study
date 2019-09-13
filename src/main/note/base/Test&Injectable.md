##@Injectable 与 @Mocked的不同

@Injectable 也是告诉 JMockit生成一个Mocked对象，但@Injectable只是针对其修饰的实例，而@Mocked是针对其修饰类的所有实例。
此外，@Injectable对类的静态方法，构造函数没有影响。因为它只影响某一个实例嘛！

@Tested & @Injectable 两个好基友，通常搭配使用

@Tested & @Injectable功能总结

@Injectable 也表示一个Mocked对象，相比@Mocked，只不过只影响类的一个实例。而@Mocked默认是影响类的所有实例。
@Tested表示被测试对象。如果该对象没有赋值，JMockit会去实例化它，若@Tested的构造函数有参数，
则JMockit通过在测试属性&测试参数中查找@Injectable修饰的Mocked对象注入@Tested对象的构造函数来实例化，
不然，则用无参构造函数来实例化。除了构造函数的注入，JMockit还会通过属性查找的方式，把@Injectable对象注入到@Tested对象中。
 注入的匹配规则：先类型，再名称(构造函数参数名，类的属性名)。若找到多个可以注入的@Injectable，则选择最优先定义的@Injectable对象。
当然，我们的测试程序要尽量避免这种情况出现。因为给哪个测试属性/测试参数加@Injectable，是人为控制的。
