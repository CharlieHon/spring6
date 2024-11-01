package com.charlie.spring6;

import com.charlie.spring6.bean.User;
import com.charlie.spring6.dao.UserDaoImplForMySQL;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: charlie
 * @date: Created in 2024/11/1 14:12
 * @description: FirstSpringTest
 */
public class FirstSpringTest {

    @Test
    public void testBeginInitBean4() {
        // Bean创建的时机，并不是在调用 getBean() 方法时才创建Bean
        new ClassPathXmlApplicationContext("spring.xml");
        // User的无参构造方法执行...
    }

    @Test
    public void testBeanFactory3() {
        // 1. ApplicationContext接口的超级父接口是 BeanFactory（Bean工厂，能够生产Bean对象的一个工厂对象）
        // 2. BeanFactory 是 IoC 容器的顶级接口，Spring的IoC容器底层实际上使用了 工厂模式，
        // 3. Spring底层IoC实现：xml解析 + 工厂模式 + 反射机制
        BeanFactory ioc = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = ioc.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testXmlPath2() {
        ApplicationContext ioc = new FileSystemXmlApplicationContext("非类路径(resources)下的xml文件");
    }

    @Test
    public void testFirstSpringTest1() {
        // 1.获取Spring容器
        // 1.1 Application（应用上下文，即Spring容器），是一个接口
        // 1.2 ClassPathXmlApplicationContext 是其一个实现类，专门从类路径当中加载spring配置文件的一个spring上下文对象
        // 1.3 该行代码执行，就相当于启动spring容器，解析spring.xml文件，并且实例化所有的bean对象，放入到spring容器中
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml", "beans.xml", "xml/beans.xml");

        // 2. 根据bean id从容器中获取对象
        Object userBean = ioc.getBean("userBean");
        System.out.println(userBean);   // com.charlie.spring6.bean.User@4550bb58

        // 不同配置文件中配置的bean，id 可以 相同
        User userBean1 = ioc.getBean("userBean2", User.class);
        System.out.println(userBean1);  // com.charlie.spring6.bean.User@1a482e36

        UserDaoImplForMySQL userDaoBean = ioc.getBean("userDaoBean", UserDaoImplForMySQL.class);
        userDaoBean.insert();   // MySQL正在保存信息...

        Object userBeanVip = ioc.getBean("userBeanVip");
        System.out.println(userBeanVip);    // com.charlie.spring6.bean.Vip@59662a0b

        // 配置JDK中的类
        Date nowTime = ioc.getBean("nowTime", Date.class);
        // System.out.println(nowTime);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strNowTime = sdf.format(nowTime);
        System.out.println(strNowTime); // 2024-11-01 15:01:24 585
    }

}
