# spring6

## 1. revelation

1. 设置 `project structure` 使用 JDK17
2. 设置 `setting` 选择 maven 仓库

**开闭原则**OCP(open/close)：对扩展开放，对修改关闭。
- 只要扩展系统功能的时候，没有修改以前写好的代码，那么就符合OCP原则
- 当进行系统功能扩展时，如果动了之前稳定的程序，修改了之前的程序，之前所有程序都需要进行重新测试。

**依赖倒置原则**(DIP)：面向接口编程、面向抽象类编程，而不面向具体编程
- 降低程序的耦合度，提高扩展能力

当前程序既违反OCP，又违反DIP原则，可以采用**控制反转**编程思想

控制反转(`IoC`, Inversion of Control)
1. 不在程序中采用硬编码的方式来 new 对象
2. 不再程序中采用硬编码的方式来维护对象的关系

Spring框架完成了控制反转IoC这种思想
- Spring是一个实现了IoC思想的容器
- 控制反转的实现方式有多种，其中比较重要的叫作：**依赖注入**(Dependency Injection, `DI`)
- 依赖是对象A和对象B的关系，注入是一种手段，可以让A对象和B对象产生关系
- 依赖注入DI有两种常见的方式：
  1. set方法注入
  2. 构造方法注入

![spring的8大模块](img.png)

## 2. first

让spring帮助创建bean，管理依赖，需要通过spring配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--spring的配置文件-->
    <!--配置文件最好放在类路径当中，方便后期的移植，放在resources跟目录下，就相当于放到了类的跟目录下-->
    <!--配置bean，这样spring才可以帮助我们管理这个对象-->

    <!--
        bean标签有两个重要属性：
            id: bean的唯一标识，不能重复！
            class: 必须填写类的全路径，全限定类名（带包名的类名）
    -->
    <bean id="userBean" class="com.charlie.spring6.bean.User"/>
    <!--配置其它的bean-->
    <bean id="userDaoBean" class="com.charlie.spring6.dao.UserDaoImplForMySQL"/>

    <!--配置java.util.Date bean-->
    <bean id="nowTime" class="java.util.Date"/>
</beans>
```

4. Spring把创建好的对象到一个什么样的数据结构当中？
- ![spring容器](img_1.png)
5. Spring可以配置多个xml文件
- 不同xml文件中配置的bean的id可以相同，但是会被覆盖
6. 在配置文件中配置的类可以是自定义的，也可以是JDK中的类
7. 如果bean的id不存在，`getBean`会抛出异常而非返回null
8. 使用 `FileSystemXmlApplicationContext` 加载非类目录下的xml文件
9. ApplicationContext的超级父接口BeanFactory
10. Bean创建的时机，并不是在调用 getBean() 方法时才创建Bean，在创建容器时`new ClassPathXmlApplicationContext()`即创建了Bean对象

p1~p14
