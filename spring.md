# 什么是spring

Spring是一个基于IOC和AOP的结构J2EE系统的框架
IOC 反转控制 是Spring的基础，Inversion Of Control

简单说就是创建对象由以前的程序员自己new 构造方法来调用，变成了交由Spring创建对象
DI 依赖注入 Dependency Inject. 简单地说就是拿到的对象的属性，已经被注入好相关值了，直接使用即可。



# IOC简单例子

下载 lib.rar，并解压到 项目中的/lib 目录下

Category.java

~~~java
package com.bwf.pojo;
 
public class Category {
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private int id;
    private String name;
}
~~~



applicationContext.xml

在src目录下新建applicationContext.xml文件
applicationContext.xml是Spring的核心配置文件，通过关键字c即可获取Category对象

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
   http://www.springframework.org/schema/context     
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
  
    <bean name="c" class="com.bwf.pojo.Category">
     
    </bean>
  
</beans>
~~~



测试代码

~~~java
package com.bwf.test;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.bwf.pojo.Category;
 
public class TestSpring {
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
 
        Category c = (Category) context.getBean("c");
         
        System.out.println(c);
    }
}
~~~



## 对象的作用域

常用的主要有两种，一个是单例，还一个是原型

~~~xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 
    <bean id = "beanScope" class = "com.bwf.pojo.Category" scope="prototype"></bean>
 
</beans>
~~~



## 注入数据

可以是基本类型已经对象类型，数据注入的方式主要有，构造函数注入，属性注入，外部引用，内部引用注入以及注解注入

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 
    <bean id = "a" class = "com.bwf.pojo.Category">
        <constructor-arg index="0">1</constructor-arg>
    </bean>
    
     <bean id = "b" class = "com.bwf.pojo.Category">
       <property name="name" value="bwf"></property>
    </bean>
    
     <bean id = "c" class = "com.bwf.pojo.Category">
       <property name="user" ref="user"></property>
    </bean>
    
     <bean id = "d" class = "com.bwf.pojo.Category">
       <bean class="com.bwf.User"></bean>
    </bean>
 
</beans>
~~~



注解方式

修改applicationContext.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
   http://www.springframework.org/schema/context     
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
  
    <context:annotation-config/>
    <bean name="c" class="com.bwf.pojo.Category">
        <property name="name" value="category 1" />
    </bean>
    <bean name="p" class="com.bwf.pojo.Product">
        <property name="name" value="product1" />
<!--         <property name="category" ref="c" /> -->
    </bean>
  
</beans>
~~~

在Product.java的category属性前加上@Autowired注解

~~~java
@Autowired
private Category category;
~~~

测试类

~~~java
package com.bwf.test;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.bwf.pojo.Product;
 
public class TestSpring {
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        Product p = (Product) context.getBean("p");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());
    }
}
~~~



修改applicationContext.xml，什么都去掉，只新增：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
   http://www.springframework.org/schema/context     
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
  
    <context:component-scan base-package="com.bwf.pojo"/>
     
</beans>
~~~



为Product类加上@Component注解，即表明此类是bean

为Category 类加上@Component注解，即表明此类是bean

Product.java类

~~~java
package com.bwf.pojo;
 
import javax.annotation.Resource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component("p")
public class Product {
 
    private int id;
    private String name="product 1";
     
    @Autowired
    private Category category;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Category getCategory() {
        return category;
    }
     
    public void setCategory(Category category) {
        this.category = category;
    }
}
~~~



## 装配其它类型

| 集合元素 | 用途                                               |
| -------- | -------------------------------------------------- |
| <list>   | 装配list类型的值，允许重复                         |
| <set>    | 装配set类型，不允许重复                            |
| <map>    | 装配map类型的值，名称和值可以是任意类型            |
| <props>  | 装配properties类型的值，名称和值必须都是String类型 |

~~~xml
//1、 list集合
 
<bean id="userService" class="com.spring.service.UserService"> 
    <property name="list"> 
        <list> 
            <value>aaaa</value> 
            <value>bbbb</value> 
        </list> 
    </property> 
 </bean> 
  
//2、set集合
 
<bean id="userService" class="com.spring.service.UserService"> 
    <property name="set"> 
        <set> 
            <value>cccc</value> 
            <value>dddd</value> 
        </set> 
    </property> 
</bean>  
 
//3、map集合
 
<bean id="userService" class="com.spring.service.UserService"> 
    <property name="set"> 
        <map> 
            <entry key="1111" value="aaaa"/> 
            <entry key="2222" value="bbbb"/> 
        </map> 
    </property> 
</bean> 
 
//4、properties
 
<bean id="userService" class="com.spring.service.UserService"> 
    <property name="pro"> 
        <props> 
            <prop key="1111">aaaa</prop> 
            <prop key="2222">cccc</prop> 
        </props>   
    </property> 
</bean>
~~~



# AOP简单例子

AOP 即 Aspect Oriented Program 面向切面编程
首先，在面向切面编程的思想里面，把功能分为**核心业务功能**，和**周边功能**。
所谓的核心业务，比如登陆，增加数据，删除数据都叫核心业务
所谓的周边功能，比如性能统计，日志，事务管理等等

周边功能在Spring的面向切面编程AOP思想里，即被定义为**切面**

在面向切面编程AOP的思想里面，核心业务功能和切面功能分别**独立进行开发**
然后把切面功能和核心业务功能 **"编织"** 在一起，这就叫AOP



为了支持AOP，需要用到一些额外的JAR包。 这些额外的JAR包放在右上角的可运行项目，解压出来的lib目录下。



ProductService.java类

~~~java
package com.bwf.service;
 
public class ProductService {
     
    public void doSomeService(){
         
        System.out.println("doSomeService");
         
    }
     
}
~~~



LoggerAspect.java类

该日志切面的功能是 在调用核心功能之前和之后分别打印日志

~~~java
package com.bwf.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
 
public class LoggerAspect {
 
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
~~~



applicationContext.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
   http://www.springframework.org/schema/context     
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
  
    <bean name="c" class="com.bwf.pojo.Category">
        <property name="name" value="yyy" />
    </bean>
 
    <bean name="p" class="com.bwf.pojo.Product">
        <property name="name" value="product1" />
        <property name="category" ref="c" />
    </bean>
     
    <bean name="s" class="com.bwf.service.ProductService">
    </bean>   
     
    <bean id="loggerAspect" class="com.bwf.aspect.LoggerAspect"/>
     
    <aop:config>
        <aop:pointcut id="loggerCutpoint"
            expression=
            "execution(* com.bwf.service.ProductService.*(..)) "/>
             
        <aop:aspect id="logAspect" ref="loggerAspect">
            <aop:around pointcut-ref="loggerCutpoint" method="log"/>
        </aop:aspect>
    </aop:config>    
  
</beans>
~~~



测试类

~~~java
package com.bwf.test;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.bwf.service.ProductService;
  
public class TestSpring {
  
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}
~~~



## 注解方式

使用@Component("s") 注解ProductService 类

~~~java
package com.bwf.service;
 
import org.springframework.stereotype.Component;
 
@Component("s")
public class ProductService {
    public void doSomeService(){
        System.out.println("doSomeService");
    }
     
}
~~~



注解配置切面

@Aspect 注解表示这是一个切面
@Component 表示这是一个bean,由Spring进行管理
@Around(value = "execution(* com.bwf.service.ProductService.*(..))") 表示对com.bwf.service.ProductService 这个类中的所有方法进行切面操作

~~~java
package com.bwf.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class LoggerAspect {
     
    @Around(value = "execution(* com.bwf.service.ProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
~~~

applicationContext.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
   http://www.springframework.org/schema/context     
   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
  
    <context:component-scan base-package="com.bwf.aspect"/>
    <context:component-scan base-package="com.bwf.service"/>
    <aop:aspectj-autoproxy/> 
   
</beans>
~~~



测试类

~~~java
package com.bwf.test;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.bwf.service.ProductService;
 
public class TestSpring {
  
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}
~~~



# 整合mybatis

pojo类

~~~java
package com.bwf.pojo;
 
public class Category {
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
     
}
~~~



Mapper接口

~~~java
package com.bwf.mapper;
  
import java.util.List;
 
import com.bwf.pojo.Category;
  
public interface CategoryMapper {
  
    public int add(Category category); 
        
    public void delete(int id); 
        
    public Category get(int id); 
      
    public int update(Category category);  
        
    public List<Category> list();
     
    public int count(); 
     
}
~~~

Category.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
    <mapper namespace="com.bwf.mapper.CategoryMapper">
        <insert id="add" parameterType="Category" >
            insert into category ( name ) values (#{name})   
        </insert>
         
        <delete id="delete" parameterType="Category" >
            delete from category where id= #{id}  
        </delete>
         
        <select id="get" parameterType="_int" resultType="Category">
            select * from   category  where id= #{id}   
        </select>
 
        <update id="update" parameterType="Category" >
            update category set name=#{name} where id=#{id}   
        </update>
        <select id="list" resultType="Category">
            select * from   category     
        </select>    
    </mapper>
~~~

applicationContext.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
     http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
     
   <context:annotation-config />
     
   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> 
        <property name="driverClassName"> 
            <value>com.mysql.jdbc.Driver</value> 
        </property> 
        <property name="url"> 
            <value>jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8</value> 
     
        </property> 
        <property name="username"> 
            <value>root</value> 
        </property> 
        <property name="password"> 
            <value>123</value> 
        </property>  
   </bean>
     
    
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="typeAliasesPackage" value="com.bwf.pojo" />
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:com/bwf/mapper/*.xml"/>
        <property name="configLocation" value="classpath:SqlMapConfig.xml"></property>
    </bean>
 
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.bwf.mapper"/>
    </bean>
    
    <bean id="txManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
	</bean>

    <tx:advice id="txAdvice" transaction-manager="txManager">
        <tx:attributes>
        <tx:method name=“save*" propagation="REQUIRED" />
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:pointcut id="txPointCut"
        expression="execution(* com.itany.aop.TeacherOption.del(..))" />
        <aop:advisor advice-ref="txAdvice"
        pointcut-ref="txPointCut" />
    </aop:config>

     
</beans>
~~~



注解方式

~~~xml
<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource" />
</bean>
<!-- enable transaction annotation support -->
<tx:annotation-driven transaction-manager="txManager" />
~~~



~~~java
@Transactional
  public void updateFoo(Foo foo) {
    // do something
  }
~~~



# Springmvc

创建项目springmvc

在eclipse中新建项目springmvc，使用dynamic web project的方式。并且导入jar包

web.xml

在WEB-INF目录下创建 web.xml

配置Spring MVC的入口 **DispatcherServlet**，把所有的请求都提交到该Servlet

注意：<servlet-name>**springmvc**</servlet-name>

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
~~~



创建springmvc-servlet.xml

在WEB-INF目录下创建 springmvc-servlet.xml
springmvc-servlet.xml 与上一步中的<servlet-name>springmvc</servlet-name>**springmvc**对应

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
    <bean id="simpleUrlHandlerMapping"
        class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
        <property name="mappings">
            <props>
                <prop key="/index">indexController</prop>
            </props>
        </property>
    </bean>
    <bean id="indexController" class="controller.IndexController"></bean>
</beans>
~~~



控制类 IndexController控制类 IndexController实现接口Controller ，提供方法handleRequest处理请求

SpringMVC通过 ModelAndView 对象把模型和视图结合在一起

~~~java
package controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
 
public class IndexController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}
~~~



准备index.jsp

在WebContent目录下创建index.jsp

index.jsp很简单，通过EL表达式显示message的内容

~~~jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<h1>${message}</h1>
~~~



## 视图改为

如果代码写成这样，就表示跳转到页面 index.jsp
new ModelAndView("**index.jsp**");

所谓的视图定位，指的是代码还是写成这样，但是会跳转到 /WEB-INF/page/index.jsp
new ModelAndView("**index**");

修改springmvc-servlet.xml，增加

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
 
    <bean id="viewResolver"
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/page/" />
        <property name="suffix" value=".jsp" />
    </bean>
 
    <bean id="/index" class="controller.IndexController"></bean>
    
</beans>
~~~



## 注解方式

修改IndexController

在类前面加上**@Controller** 表示该类是一个控制器
在方法handleRequest 前面加上 **@RequestMapping("/index")** 表示路径/index会映射到该方法上
**注意**：**不再**让IndexController实现Controller接口

~~~java
package controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}
~~~



修改springmvc-servlet.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context        
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
     
    <context:component-scan base-package="controller" />
    
    <bean id="irViewResolver"
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/page/" />
        <property name="suffix" value=".jsp" />
    </bean>

</beans>
~~~



## 接受参数

@RequestParam绑定单个请求参数值

~~~java
public void  add(HttpServletRequest request,

HttpServletResponse response,HttpSession session,@RequestParam String id) {
    
}
~~~



参数类型的自动装换

**1.** **基本数据类型**

**2.** **包装类型**

**3.** **自定义对象类型** 

**4.** **自定义复合对象类型**

**5.list,set,map类型**

**6.日期处理**

~~~java
@RequestMapping(value = "/testType.htm")
public void testType(@DateTimeFormat(pattern="yyyy-MM-dd")Date date){

}

<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean“> </bean> 
  
<mvc:annotation-driven conversion-service="conversionService" /> 

~~~



## 整合spring

~~~xml
<context:component-scan base-package="com.itany.controller" />
<context:component-scan base-package="com.itany.service" />
~~~

~~~java

@Controlle
public class UserController  {
	......
} 

@Service
public class UserService implements IUserService {
	......
} 

~~~



## ajax的支持

有以下3种方式：

1.直接请求资源，通过HttpServletResponse返回

~~~java
@RequestMapping(value="/ajax.htm")
public void testAjax(HttpServletRequest request, HttpServletResponse response){

String name=request.getParameter("name");
try {
PrintWriter out= response.getWriter();

}}

~~~



2.通过注解@ResponseBody返回

~~~java
@RequestMapping(value="/ajax2.htm")
@ResponseBody
public String testAjax2(String name){

return name;

}
~~~



3.请求和响应的JSON格式，使用jackson.jar包的支持

~~~java
@RequestMapping(value="/ajax2.shtm")
@ResponseBody
public List<User> testAjax2(String name){
User user=new User();
user.setName("itany");
List<User> list=new ArrayList<User>();
list.add(user);
list.add(user);
return list;
}

~~~



## 文件上传

在springmvc中有两种方式实现文件的上传



第一种：使用代码实现

~~~html
<form action=*"**up.shtm**"* method=*"post"* enctype=*"multipart/form-data"*>

<input type=*"text"* name=*"name"*/>

<input type=*"file"* name=*"**fileName**"*/>

<input type=*"submit"* value=*"**上传**"*/>

</form>
~~~



~~~java
@RequestMapping(value="/up.shtm")

public   void  upLoad(HttpServletRequest req){


MultipartResolver resolver =  new  CommonsMultipartResolver();

MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(req);     

MultipartFile file = multipartRequest.getFile("fileName");

String name=multipartRequest.getParameter("name");

file.transferTo( new  File("d:/a.jpg"));

}
~~~



第二种：使用参数实现



首先在配置文件中定义一个多文件解决类，类名用*multipartResolver*

~~~xml
<bean id= " multipartResolver " class="org.springframework.web.multipart.commons.CommonsMultipartResolver">

<property name= "maxUploadSize " value="10240000000"></property>

 <property name="defaultEncoding" value="UTF-8"/>

<property name="resolveLazily" value="true"/> 

</bean>
~~~



~~~java
@RequestMapping(value="/up.shtm")

 public void  upLoad(@RequestParam(value = "fileName", required =  false) MultipartFile mf){

mf.transferTo( new File("d:/a1.jpg"));

}
~~~



## 拦截器的使用

~~~java
public class MyInterceptor1 implements HandlerInterceptor {
public void afterCompletion(HttpServletRequest arg0,
HttpServletResponse arg1, Object arg2, Exception arg3)
throws Exception {
System.out.println("拦截之后运行");}

public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
Object arg2, ModelAndView arg3) throws Exception {
System.out.println(arg3);}

public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
Object arg2) throws Exception {
    if(arg0.getServletPath().startsWith("/login.shtm")) {  
        return true;  }
    if(arg0.getSession().getAttribute("id") != null) {  
        return true;  
    }  arg1.sendRedirect("login.jsp");  
    return false;  }}

~~~

~~~xml
<mvc:interceptors>  

所有的请求拦截
<bean class="com.itany.interceptor.MyInterceptor1"/>   

    <mvc:interceptor>  
        特定的请求拦截
        <mvc:mapping path="/login.shtm"/>  
        <bean class="com.itany.interceptor.MyInterceptor1"/>  
    </mvc:interceptor>  
    
        <mvc:interceptor>  
        具体路径下所有拦截
        <mvc:mapping path="/a/**"/> 
        不需要拦截的
        <mvc:exclude-mapping path="/a/login.do"/>
        <bean class="com.itany.interceptor.MyInterceptor1"/>  
           
    </mvc:interceptor>  

</mvc:interceptors>
~~~



## 使用thymeleaf视图

Thymeleaf 是一个服务器端 Java 模板引擎，能够处理 HTML、XML、CSS、JAVASCRIPT 等模板文件。Thymeleaf 模

板可以直接当作静态原型来使用，它主要目标是为开发者的开发工作流程带来优雅的自然模板，也是 Java 服务器

端 HTML5 开发的理想选择。

Thymeleaf模板文件：

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div th:text="${data}"></div>
</body>
</html>
```



下载对应的jar包

~~~xml
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf</artifactId>
	<version>2.1.4.RELEASE</version>
</dependency>
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring3</artifactId>
	<version>2.1.4.RELEASE</version>
</dependency>
~~~



修改applicationContext-servlet.xml文件配置

~~~xml
<!-- 注释掉JSP视图解析器配置 -->
<!-- <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean> -->
	
<!-- Thymeleaf视图模板引擎配置 -->
<bean id="templateResolver" class="org.thymeleaf.templateresolver.ServletContextTemplateResolver">
    <property name="prefix" value="/WEB-INF/templates/" />
    <property name="suffix" value=".html" />
    <property name="templateMode" value="HTML5" />
</bean>
    
<bean id="templateEngine" class="org.thymeleaf.spring4.SpringTemplateEngine">
    <property name="templateResolver" ref="templateResolver" />
</bean>
	
<!-- 视图解析器配置 -->
<bean class="org.thymeleaf.spring4.view.ThymeleafViewResolver">
    <property name="templateEngine" ref="templateEngine" />
    <property name="order" value="1" />
    <!-- <property name="viewNames" value="*.html,*.xhtml" /> -->
</bean>
~~~



### Thymleaf基本应用

#### 绑定文本数据

将数据绑定到网页标签之间（相当于设置标签的`innerHTML`），通常使用文本标签 `th:text`。

##### 简单属性

数据存放：

```java
    request.setAttribute("data", "success");
    request.setAttribute("a", 1);
    request.setAttribute("b", 2);
    request.setAttribute("flag", false);
```

模板代码：

```html
	<div th:text="${data}"></div>
	<!-- 用+字符串拼接 -->
	<div th:text="'结果是:'+(${a}+${b})"></div>
	<!-- 用|  |字符串拼接 -->
	<div th:text="|${a} ${b}|"></div>
	<!-- 比较 -->
	<div th:text="${a} > ${b}"></div>
	<!-- 取反 -->
	<div th:text="!${flag}"></div>
```

解析结果：

```html
	<div>success</div>
	<div>结果是:3</div>
	<div>1 2</div>
	<div>false</div>
	<div>true</div>
```

##### 格式化数据

数据存放：

```java
	request.setAttribute("num", 88.8888);
	request.setAttribute("hiredate", new Date());
```

模板代码：

```html
	<!-- 格式化货币-->
	<div th:text="${#numbers.formatCurrency(num)}"></div>
	<!-- 格式化百分比-->
	<div th:text="${#numbers.formatPercent(num, 1, 2)}"></div>
	<!-- 格式化小数-->
	<div th:text="${#numbers.formatDecimal(num,3, 'COMMA', 2,'POINT')}"></div>
	<!-- 格式化日期-->
	<div th:text="${#dates.format(hiredate,'yyyy-MM-dd HH:mm:ss')}"></div>
```

其中的`numbers`和`dates`是**thymleaf**的预定义工具对象，提供了对数值和日期的一些常用方法，除了这2个对象以外，还有`strings`、`bools`提供了字符串和布尔型数据的相关的方法，`arrays`、`sets`、`lists`、`maps`、`aggregates`提供了与数组、集合相关的方法。

解析结果：

```html
	<div>￥88.89</div>
	<div>8,888.88%</div>
	<div>088.89</div>
	<div>2021-01-12 23:06:37</div>
```

##### 对象属性

对象定义：

```java
public class User {
	private Integer age;
	private Date birth;
	private String name;
    ......
}
```

数据存放：

```java
	request.setAttribute("user", new User("tom",22,new Date()));
	request.getSession().setAttribute("price", "666");
	request.getSession().setAttribute("userinfo", new User("mike",23,new Date()));
```

模板代码：

```html
	<!-- 对象属性 -->
	<div th:text="${user.name}"></div>
	<div th:text="${user.age}"></div>
	<div th:text="${user.birth}"></div>
	<div th:text="${#dates.format(user.birth,'yyyy-MM-dd HH:mm:ss')}"></div>
	<!-- session中的数据 -->
	<div th:text="${session.price}"></div>
	<div th:text="${session.userinfo.name}"></div>
```

解析结果：

```html
	<!-- 对象属性 -->
	<div>tom</div>
	<div>22</div>
	<div>Thu Jan 14 09:35:21 CST 2021</div>
	<div>2021-01-14 09:35:21</div>
	
	<!-- session中的数据 -->
	<div>666</div>
	<div>mike</div>
```

#### 集合遍历/分支判断

##### 循环

###### th:each

**th:each** 遍历集合

数据存放：

```java
		//模拟从数据库中查出数据
		List<Student> stuList=new ArrayList<>();
		Student s1=new Student(1,"张三","13813381221",60);
		Student s2=new Student(2,"李四","18913383828",100);
		Student s3=new Student(3,"王五","18913383828",180);
		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);
		//保存数据
		request.setAttribute("stuList", stuList);
```

模板代码：

```html
		<table>
			<tbody>
				<tr style="height: 25px" align="center">
					<th>编号</th>
					<th>姓名</th>
					<th>电话</th>
					<th>余额</th>
					<th>奇偶数</th>
					<th>当前元素</th>
					<th>迭代个数</th>
				</tr>
				<tr align="center" th:each="stu,status:${stuList}">
					<td th:text="${stu.stuId }"></td>
					<td th:text="${stu.stuStuname }"></td>
					<td th:text="${stu.stuPhone }"></td>
					<td th:text="${stu.stuRemain }"></td>
					<td th:text="${status.odd }"></td>
					<td th:text="${status.current }"></td>
					<td th:text="${status.count }"></td>
				</tr>
			</tbody>
		</table>
```

`th:each="stu,status:${stuList}"`中的`stu`为迭代变量，`${stuList}`是遍历的集合，

`status`是用来记录当前迭代状态的变量，它有一些记录当前迭代状态的属性：

- index:当前迭代对象的迭代索引，从0开始，这是索引属性；
- count:当前迭代对象的迭代索引，从1开始，这个是统计属性；
- size:迭代变量元素的总量，这是被迭代对象的大小属性；
- current:当前迭代变量；
- even/odd:布尔值，当前循环是否是偶数/奇数（从0开始计算）；
- first:布尔值，当前循环是否是第一个；
- last:布尔值，当前循环是否是最后一个

解析结果：

![image-20210113152718920](D:/上课/网课/文档/JavaEE/JavaEE-前端页面/文档/image/d7d8b885-ecaf-4fe1-b07f-06c3a44d6834.png)

##### 条件判断

###### th:if/th:unless

**th:if** 当条件为true则显示
**th:unless** 当条件为false 则显示

数据存放：

```java
		request.setAttribute("num", 50);
```

模板代码：

```html
		<!-- 当条件为true则显示 -->
		<div th:if="${num}>80">
			num大于80
		</div>
		<!-- 当条件为false则显示 -->
		<div th:unless="${num}>80">
			num小于80
		</div>
```

解析结果：

```html
		<div>
			num小于80
		</div>
```

###### th:switch

**th:switch** 用于多分支的条件判断，条件为真则显示对应的分支

数据存放：

```java
		request.setAttribute("user", "admin");
```

模板代码：

```html
		<div th:switch="${user}">
			<div th:case="'admin'">管理员</div>
			<div th:case="'common'">普通用户</div>
			<div th:case="'guest'">客人</div>
		</div>
```

解析结果：

```html
		<div>管理员</div>
```

#### @{…}链接网址表达式

一般和 `th:href`、`th:src`进行结合使用，用于显示Web 应用中的URL链接。通过`@{…}`表达式可以拼接上web应用访问的全路径，同时可以通过（）进行参数的拼接。

例如，在页面中引入样式表和脚本文件：

```html
<link rel="stylesheet" type="text/css" href="/css/css.css" th:href="@{/css/css.css}">
<link href="/css/table.css" th:href="@{/css/table.css}" rel="stylesheet" type="text/css"/>
<script src="/js/jquery.min.js" th:src="@{/js/jquery.min.js}"></script>
<script src="/js/layer.js" th:src="@{/js/layer.js}"></script>
```

解析结果：

```html
    <link rel="stylesheet" type="text/css" href="/thymleaf-demo/css/css.css">
    <link href="/thymleaf-demo/css/table.css" rel="stylesheet" type="text/css"/>
    <script src="/thymleaf-demo/js/jquery.min.js"></script>
    <script src="/thymleaf-demo/js/layer.js"></script>
```

设置表单的`action`属性：

```html
<form th:action="@{/card/savestu}" method="post">
</form>
```

解析结果：

```html
<form action="/thymleaf-demo/card/savestu" method="post">
</form>
```

设置图片路径：

```html
<img th:src="@{/images/logo.png}"  />
```

解析结果：

```html
<img src="/thymleaf-demo/images/logo.png">
```

设置超链接路径：

```html
<a  th:href="@{/card/stu(stuId=${stu.stuId},stuNo=${stu.stuStuno})}">查看</a>
```

解析结果：

```html
<a  href="/thymleaf-demo/card/stu?stuId=1&amp;stuNo=S001">查看</a>
```

#### 绑定表单数据

在表单元素的属性前加`th:`就是其在**thymleaf**中对应的属性，例如：`th:value`对应`value`，`th:checked`对应`checked`。

数据存放：

```java
		//模拟从数据库中查出数据
		Student stu=new Student();
		stu.setDeptId(2);//对应下拉列表
		stu.setStuId(1);//对应隐藏域
		stu.setStuLimit(1);//对应单选按钮
		stu.setStuPhone("1234567890");//对应文本框
		stu.setStuRemain(88);//对应文本框
		stu.setStuStuname("张三");//对应文本框
		stu.setStuStuno("S001");//对应文本框
		List<Dept> deptList=new ArrayList<>();//下拉列表的数据源
		Dept d1=new Dept(1,"南校区");
		Dept d2=new Dept(2,"北校区");
		Dept d3=new Dept(3,"东校区");
		deptList.add(d1);
		deptList.add(d2);
		deptList.add(d3);
		//保存数据
		request.setAttribute("stu", stu);
		request.setAttribute("deptList", deptList);
```

模板代码：

```html
<form th:action="@{/card/savestu}" method="post">
        <input type="hidden" name="stuId" th:value="${stu.stuId}"/>
        <table>
            <tbody>
            <tr>
                <td align="right" width="80">编号:</td>
                <td>
                    <input type="text" readOnly name="stuStuno" 
                           th:value="${stu.stuStuno}"/>
                </td>
                <td align="right" width="90">姓名:</td>
                <td>
                    <input type="text" name="stuStuname" th:readonly="${stu!=null}" 
                           th:value="${stu.stuStuname}"/>
                </td>
            </tr>
            <tr>
                <td align="right">限额:</td>
                <td>
                    <input type="radio" name="stuLimit" value="1" 
                           th:checked="${stu.stuLimit==1}"/>是
                    <input type="radio" name="stuLimit" value="0" 
                           th:checked="${stu.stuLimit==0 or stu==null}"/>否
                </td>
                <td align="right">院系:</td>
                <td>
                    <select id="dept">
                            <option th:each="dept:${deptList}" th:value="${dept.deptId }" 
                                    th:selected="${stu.deptId==dept.deptId}"
                                th:text="${dept.deptName }">
                            </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">余额:</td>
                <td>
                    <input type="text" readOnly name="stuRemain" 
                           th:value="${stu.stuRemain }"/>
                </td>
                <td align="right">电话:</td>
                <td>
                    <input type="text" name="stuPhone" th:value="${stu.stuPhone }"/>
                </td>
            </tr>
            <tr align="center">
                <td colspan="5" height="40">
                    <div align="center">
                        <input type="submit" value="保存">
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
```

解析结果：

```html
    <form action="/thymleaf-demo/card/savestu" method="post">
        <input type="hidden" name="stuId" value="1"/>
        <table>
            <tbody>
            <tr>
                <td align="right" width="80">编号:</td>
                <td>
                    <input type="text" readOnly name="stuStuno" value="S001"/>
                </td>
                <td align="right" width="90">姓名:</td>
                <td>
                    <input type="text" name="stuStuname" value="张三" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right">限额:</td>
                <td>
                    <input type="radio" name="stuLimit" value="1" checked="checked"/>是
                    <input type="radio" name="stuLimit" value="0"/>否
                </td>
                <td align="right">院系:</td>
                <td>
                    <select id="dept">
                            <option value="1">南校区</option>
                            <option value="2" selected="selected">北校区</option>
                            <option value="3">东校区</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">余额:</td>
                <td>
                    <input type="text" readOnly name="stuRemain" value="88"/>
                </td>
                <td align="right">电话:</td>
                <td>
                    <input type="text" name="stuPhone" value="1234567890"/>
                </td>
            </tr>
            <tr align="center">
                <td colspan="5" height="40">
                    <div align="center">
                        <input type="submit" value="保存">
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
```

显示效果：

![image-20210113223225347](D:/上课/网课/文档/JavaEE/JavaEE-前端页面/文档/image/d91c76c4-ba98-4739-b08f-8d032fb58641.png)

#### JavaScript内联

如果想在JavaScript 中使用**thymleaf**，需要在 `script` 标签上声明 `th:inline=“javascript”`， 然后就可以使用了，例如：

模板代码：

```html
    <script th:inline="javascript">
        var sno = [[${stu.stuStuno}]];
    </script>
```

解析结果：

```html
	<script>
	    var sno = "S001";
	</script>
```

#### 引用代码片段

首先添加依赖：

```xml
<dependency>
	<groupId>nz.net.ultraq.thymeleaf</groupId>
	<artifactId>thymeleaf-layout-dialect</artifactId>
	<version>2.2.2</version>
</dependency>
```

在`footer.html`中定义代码片段

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div th:fragment="copy">
        &copy; 2021 版权所有
    </div>
</body>
</html>
```

模板中使用代码片段：

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div th:insert="footer :: copy"></div>
</body>
</html>
```

解析结果：

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
        <div>
        	&copy; 2021 版权所有
    	</div>
    </div>
</body>
</html>
```

