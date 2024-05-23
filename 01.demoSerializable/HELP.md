Serializable 

`demoSerializable` 文件夹包含了一个简单的示例，演示了如何在 Java 中使用 Serializable 接口来实现对象的序列化和反序列化。

### 原理说明

- 串行化（Serialization）是指将对象转换为字节流的过程，以便可以在网络上传输或者将其保存到文件中。在 Java 中，实现了 `Serializable` 接口的类的对象可以被串行化，这意味着它们的状态可以被保存为字节序列，并且可以在需要时进行反序列化以重新创建对象。

  ![串行图片](https://github.com/wenjinglee1104/blog_file/blob/00337d0d936fc4789e6972044b0fdddaa65a28e4/20240523%E4%B8%B2%E8%A1%8C.jpg)

- 简单来说，串行化允许我们将一个对象的状态保存到一个字节流中，然后在需要时重新构造出这个对象。这对于在网络上传输对象、在进程之间共享对象或者将对象永久保存到文件中都非常有用。串行化可以帮助我们在不同的环境中轻松地传输和保存对象，而不需要担心对象的具体实现细节。

### 示例说明

- `Wanger`：定义了一个 对象 类，实现了 Serializable 接口，用于演示对象的序列化和反序列化。
- `SerializationDemo.java`：包含了一个主类，演示了如何将 Person 对象序列化到文件中，以及如何从文件中反序列化出 Wanger 对象。

### 运行示例

1. 在 `demoSerializable` 文件夹中编译和运行 `SerializationDemo.java`。
2. 查看控制台输出，以及生成的 `chenmo` 文件。

## 贡献

欢迎贡献代码，提出问题和建议。请在提交新功能或更改之前先创建一个问题（Issue）来讨论。



