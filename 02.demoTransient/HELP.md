# transient(adj.短暂的)

### 01.作用及使用方法
在实际开发过程中，类的个别字段不需要被序列化，字段加上transient关键字即可，作用是告诉JVM在序列化对象时不需要将该变量的
值持久化，避免一些安全或者性能问题。但是在反序列化时，该成员变量会自动初始为默认值（int -> 0, 引用 -> null）。

    TransientTest运行的结果如下：

    read before Serializable
    username:沉默王二
    passwd:123456
    
    read after Serializable
    username: 沉默王二
    password: null
    
    所以反序列化时根本没有从文件中获取到passwd的信息。

### 02.使用小结
1） 字段被transient修饰过，表示成员变量将不能被对象持久化。同时，transient关键字只能修饰字段，不能修饰方法和类。
2） static修饰过的静态变量从属于类，不属于对象，因此static修饰的字段也不可以被序列化。

    TransientTest02运行的结果如下：

    read before Serializable02
    username:斯琴高娃
    passwd:12345678
    
    read after Serializable02
    username: 迪丽热巴
    passwd: null

### 03.transient修饰的字段是否真的不能被修饰？
不是的。前面两个例子都是通过实现Serializable接口实现对象的序列化，所有字段的序列化自动进行，transient修饰
的字段被自动屏蔽。而在ExternalizableTest例子中，对象的序列化是通过Externalizable接口实现的，在writeExternal方
法中指定了要序列化的字段（相当于手动实现序列和反序列），所以例子输出的结果是

    “是的，我将会被序列化，不管我是否被transient关键字修饰”。

### 04.ShoppingCartTest的例子
1）这个例子定义了两个类，Item和ShoppingCart。前者的基本属性都可以被序列化，且定义了一个获得全部金额的方法，即getTotalPrice。
ShoppingCart定义了三个方法，paymentInfo属于支付手段等敏感信息，所以用transient修饰，不参与序列化。mallName和totalSpent
表示用户的总支出金额，属于类的静态变量，也不参与序列化。
2）序列化 ShoppingCart 对象到文件 cart.ser。
修改静态变量 mallName 和 totalSpent，模拟商场重启后的变化。
反序列化 ShoppingCart 对象从文件 cart.ser。
3）输出如下：

    ShoppingCart{items=[Item{name='Apple', price=0.5, quantity=10}, Item{name='Banana', price=0.2, quantity=20}], paymentInfo='null'}
    Mall Name: New Mall
    Total Spent: 9.0

paymentInfo的值为null，因被transient修饰所以不参与序列化。而Mall Name被static修饰，属于系统静态变量，所以值被修改。因为Total Spent同属于
系统静态变量，所以可以直接读取，不借助类，得到结果。

![李志铅笔](https://raw.githubusercontent.com/wenjinglee1104/blog_file/master/20240525195609.png


