# Java 打印流
(这一章写出来是为了之后打日志作准备)

### PrintStream（字节流）类的常用方法包括：
print()：输出一个对象的字符串表示形式。
println()：输出一个对象的字符串表示形式，并在末尾添加一个换行符。
printf()：使用指定的格式字符串和参数输出格式化的字符串。

### System.out.printf的格式说明：
使用 %5d 来指定输出的整数占据 5 个字符的宽度，不足部分在左侧填充空格。
使用 %-5d 来指定输出的整数占据 5 个字符的宽度，不足部分在右侧填充空格。
使用 %05d 来指定输出的整数占据 5 个字符的宽度，不足部分在左侧填充 0。
使用 %10.2f 来指定输出的浮点数占据 10 个字符的宽度，保留 2 位小数，不足部分在左侧填充空格。

### PrintWriter（字符流）的使用说明：
创建一个 PrintWriter 对象，它的构造函数接收一个 Writer 对象作为参数。在这里，我们使用 FileWriter 来创建一个输出文件流，并将其作为参数传递给 
PrintWriter 的构造函数。然后，我们使用 PrintWriter 的 println 和 printf 方法来输出两行内容，其中 printf 方法可以接收格式化字符串。
最后，我们调用 PrintWriter 的 close 方法来关闭输出流。

![恐怖的房子](https://raw.githubusercontent.com/wenjinglee1104/blog_file/master/20240526222106.png)
