# 什么是mybatis

mybatis是ORM（Object Relational Mapping）对象关系映射的一个框架，主要是为了提高JDBC的操作效率。

平时我们都用JDBC访问数据库，除了需要自己写SQL之外，还必须操作Connection, Statement, ResultSet 这些其实只是手段的辅助类。 不仅如此，访问不同的表，还会写很多雷同的代码，显得繁琐和枯燥。

那么用了Mybatis之后，只需要自己提供SQL语句，其他的工作，诸如建立连接，Statement， JDBC相关异常处理等等都交给Mybatis去做了，那些重复性的工作Mybatis也给做掉了，我们只需要关注在增删改查等操作层面上，而把技术细节都封装在了我们看不见的地方。



基本例子分析

首先创建数据库

~~~sql
create database test
~~~



接着创建表category

~~~sql
USE test;

CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
~~~



导入数据

~~~sql
USE test;
INSERT INTO category VALUES (null,'category1');
INSERT INTO category VALUES (null,'category2');
~~~



创建项目以及导入jar
下载解压后，在项目目录下新建目录lib,并复制过来，然后通过ecipse在mybatis的项目上导入这个jar包



创建实体类

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
     
}
~~~



配置文件mybatis-config.xml

在src目录下创建mybatis的主配置文件**mybatis-config.xml**
其作用主要是提供连接数据库用的驱动，数据库名称，编码方式，账号密码

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
      <package name="com.bwf.pojo"/>
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/bwf/pojo/Category.xml"/>
    </mappers>
</configuration>
~~~



配置文件Category.xml

在包com.bwf.pojo下，新建文件**Category.xml**

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

	<mapper namespace="com.bwf.pojo">
	    <select id="find" resultType="Category">
	        select * from   category    
	    </select>
	</mapper>
~~~



测试类TestMybatis

~~~java
package com.bwf;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
         
        List<Category> cs=session.selectList("find");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
         
    }
}
~~~



# 简单的增删改查

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

	<mapper namespace="com.bwf.pojo">
	    <insert id="addCategory" parameterType="Category" >
	        insert into category ( name ) values (#{name})    
	    </insert>
	    
	    <delete id="deleteCategory" parameterType="Category" >
	        delete from category where id= #{id}   
	    </delete>
	    
	    <select id="getCategory" parameterType="_int" resultType="Category">
	        select * from   category  where id= #{id}    
	    </select>

	    <update id="updateCategory" parameterType="Category" >
	        update category_ set name=#{name} where id=#{id}    
	    </update>
	    <select id="listCategory" resultType="Category">
	        select * from   category      
	    </select>	    
	</mapper>
~~~



测试代码

~~~java
package com.bwf;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        Category c = new Category();
        c.setName("新增加的Category");
        session.insert("addCategory",c);
        
        Category c = new Category();
        c.setId(6);
        session.delete("deleteCategory",c);
        
        c.setName("修改了的Category名称");
        session.update("updateCategory",c);
         
        Category c= session.selectOne("getCategory",3);
        System.out.println(c.getName());
        
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
       
         
        session.commit();
        session.close();
 
    }
 
    private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}
~~~

# 开启日志

有时候需要打印日志，知道mybatis执行了什么样的SQL语句，以便进行调试。这时，就需要开启日志，而mybatis自身是没有带日志的，使用的都是第三方日志，为了开启log4j，需要使用对应的jar包。

log4j.properties文件

在src目录下，新建文件log4j.properties，其作用是SQL语句输出

~~~properties
log4j.rootLogger=INFO, stdout
log4j.logger.com.ibatis=DEBUG
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource=DEBUG
log4j.logger.com.ibatis.common.jdbc.ScriptRunner=DEBUG
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate=DEBUG
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%d] [%-5p] %c %n--%m--%n
~~~



# 更多查询

## 模糊查询

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <select id="listCategoryByName"  parameterType="string" resultType="Category">
            select * from   category_  where name like concat('%',#{0},'%')
        </select>    
    </mapper>
~~~

~~~java
List<Category> cs = session.selectList("listCategoryByName","cat");
~~~



## 多条件查询

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <select id="listCategoryByName"  resultType="Category">
            select * from   category_  where name like concat('%',#{0},'%')
        </select>    
        <select id="listCategoryByIdAndName"  parameterType="map" resultType="Category">
            select * from   category_  where id> #{id}  and name like concat('%',#{name},'%')
        </select>    
    </mapper>
~~~

~~~java
 Map<String,Object> params = new HashMap<>();
 params.put("id", 3);
 params.put("name", "cat");
 List<Category> cs = session.selectList("listCategoryByIdAndName",params);
~~~



## 一对多查询

分类表不变化，新增加产品表

~~~sql
use test;
create table product(
id int NOT NULL AUTO_INCREMENT,
name varchar(30)  DEFAULT NULL,
price float  DEFAULT 0,
cid int ,
PRIMARY KEY (id)
)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
~~~

~~~sql
use test;

INSERT INTO category VALUES (1,'category1');
INSERT INTO category VALUES (2,'category2');

INSERT INTO product VALUES (1,'product a', 88.88, 1);
INSERT INTO product VALUES (2,'product b', 88.88, 1);
INSERT INTO product VALUES (3,'product c', 88.88, 1);
INSERT INTO product VALUES (4,'product x', 88.88, 2);
INSERT INTO product VALUES (5,'product y', 88.88, 2);
INSERT INTO product VALUES (6,'product z', 88.88, 2);
~~~



Product实体类

~~~java
package com.bwf.pojo;

public class Product {
	private int id;
	private String name;
	private float price;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

~~~



修改Category实体类，提供products的集合

~~~java
package com.bwf.pojo;
 
import java.util.List;
 
public class Category {
    private int id;
    private String name;
    List<Product> products;
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
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
     
}
~~~



修改Category.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <resultMap type="Category" id="categoryBean">
            <id column="cid" property="id" />
            <result column="cname" property="name" />
     
            <!-- 一对多的关系 -->
            <!-- property: 指的是集合属性的值, ofType：指的是集合中元素的类型 -->
            <collection property="products" ofType="Product">
                <id column="pid" property="id" />
                <result column="pname" property="name" />
                <result column="price" property="price" />
            </collection>
        </resultMap>
     
        <!-- 关联查询分类和产品表 -->
        <select id="listCategory" resultMap="categoryBean">
            select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname' 
            from category c 
            left join product p 
            on c.id = p.cid
        </select>   
    </mapper>
~~~



测试运行

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Category;
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }
 
        session.commit();
        session.close();
  
    }
}
~~~



## 多对一查询

修改Product.java

~~~java
package com.bwf.pojo;
 
public class Product {
    private int id;
    private String name;
    private float price;
    private Category category;
     
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
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
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
 
}
~~~



Product.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <resultMap type="Product" id="productBean">
            <id column="pid" property="id" />
            <result column="pname" property="name" />
            <result column="price" property="price" />
     
            <!-- 多对一的关系 -->
            <!-- property: 指的是属性名称, javaType：指的是属性的类型 -->
            <association property="category" javaType="Category">
                <id column="cid" property="id"/>
                <result column="cname" property="name"/>
            </association>
        </resultMap>
     
        <!-- 根据id查询Product, 关联将Orders查询出来 -->
        <select id="listProduct" resultMap="productBean">
            select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname' 
            from category c 
            left join product p
            on c.id = p.cid
        </select>   
    </mapper>
~~~



mybatis-config.xml

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
      <package name="com.bwf.pojo"/>
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
            <property name="driver" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8"/>
            <property name="username" value="root"/>
            <property name="password" value="123"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/bwf/pojo/Category.xml"/>
        <mapper resource="com/bwf/pojo/Product.xml"/>
    </mappers>
</configuration>
~~~



测试代码

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
        }
 
        session.commit();
        session.close();
  
    }
}
~~~



## 多对多查询

定义多对多关系

这里以订单Order和产品Product为例：
一张订单里 可以包含多种产品
一种产品 可以出现在多张订单里
这就是多对多关系
为了维系多对多关系，必须要一个中间表。 在这里我们使用订单项(OrderItem)表来作为中间表



表结构

~~~sql
create table order (
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
create table order_item(
  id int(11) NOT NULL AUTO_INCREMENT, 
  oid int ,
  pid int ,
  number int ,
  PRIMARY KEY(id)
)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
~~~

~~~sql
INSERT INTO order VALUES (1,'code000A');
INSERT INTO order VALUES (2,'code000B');
 
INSERT INTO order_item VALUES (null, 1, 1, 100);
INSERT INTO order_item VALUES (null, 1, 2, 100);
INSERT INTO order_item VALUES (null, 1, 3, 100);
INSERT INTO order_item VALUES (null, 2, 2, 100);
INSERT INTO order_item VALUES (null, 2, 3, 100);
INSERT INTO order_item VALUES (null, 2, 4, 100);
~~~



实体类Order和OrderItem

~~~java
package com.bwf.pojo;
 
import java.util.List;
 
public class Order {
    private int id;
    private String code;
     
    List<OrderItem> orderItems;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
 
}
~~~



~~~java
package com.bwf.pojo;
 
public class OrderItem {
    private int id;
    private int number;
    private Order order;
    private Product product;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
     
}
~~~



映射文件

order.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <resultMap type="Order" id="orderBean">
            <id column="oid" property="id" />
            <result column="code" property="code" />
             
            <collection property="orderItems" ofType="OrderItem">
                <id column="oiid" property="id" />
                <result column="number" property="number" />
                <association property="product" javaType="Product">
                    <id column="pid" property="id"/>
                    <result column="pname" property="name"/>
                    <result column="price" property="price"/>
                </association>               
            </collection>
        </resultMap>
         
        <select id="listOrder" resultMap="orderBean">
            select o.*,p.*,oi.*, o.id 'oid', p.id 'pid', oi.id 'oiid', p.name 'pname'
                from order o
                left join order_item oi    on o.id =oi.oid
                left join product p on p.id = oi.pid
        </select>
             
        <select id="getOrder" resultMap="orderBean">
            select o.*,p.*,oi.*, o.id 'oid', p.id 'pid', oi.id 'oiid', p.name 'pname'
                from order o
                left join order_item oi on o.id =oi.oid
                left join product p on p.id = oi.pid
            where o.id = #{id}
        </select>
    </mapper>
~~~



product.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <resultMap type="Product" id="productBean">
            <id column="pid" property="id" />
            <result column="pname" property="name" />
            <result column="price" property="price" />
     
            <!-- 多对一的关系 -->
            <!-- property: 指的是属性名称, javaType：指的是属性的类型 -->
            <association property="category" javaType="Category">
                <id column="cid" property="id"/>
                <result column="cname" property="name"/>
            </association>
        </resultMap>
 
        <select id="listProduct" resultMap="productBean">
            select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname'
                from category c
                left join product p on c.id = p.cid
        </select>   
        <select id="getProduct" resultMap="productBean">
            select c.*, p.*, c.id 'cid', p.id 'pid', c.name 'cname', p.name 'pname'
                from category c
                left join product p on c.id = p.cid
            where p.id = #{id}
        </select>   
    </mapper>
~~~



orderitem.java

~~~java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
     
        <insert id="addOrderItem" parameterType="OrderItem">
            insert into order_item
                values(null,#{order.id},#{product.id},#{number})
        </insert>   
    
        <insert id="deleteOrderItem" parameterType="OrderItem">
            delete from order_item
                where oid = #{order.id} and pid = #{product.id}
        </insert>   
     
    </mapper>
~~~



添加对于Order.xml和OrderItem的映射

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
      <package name="com.bwf.pojo"/>
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
            <property name="driver" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8"/>
            <property name="username" value="root"/>
            <property name="password" value="123"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/bwf/pojo/Category.xml"/>
        <mapper resource="com/bwf/pojo/Product.xml"/>
        <mapper resource="com/bwf/pojo/Order.xml"/>
        <mapper resource="com/bwf/pojo/OrderItem.xml"/>
    </mappers>
</configuration>
~~~



查询操作

查询出所有的订单，然后遍历每个订单下的多条订单项，以及订单项对应的产品名称，价格，购买数量

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Order;
import com.bwf.pojo.OrderItem;
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
       
        List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois= o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
        
 
        session.commit();
        session.close();
  
    }
 
   
}
~~~



建立关系

~~~java
package com.bwf;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Order;
import com.bwf.pojo.OrderItem;
import com.bwf.pojo.Product;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        addOrderItem(session);
        listOrder(session);
 
        session.commit();
        session.close();
 
    }
 
    private static void addOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder", 1);
        Product p6 = session.selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);
 
        session.insert("addOrderItem", oi);
    }
 
    private static void listOrder(SqlSession session) {
        List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(),
                        oi.getNumber());
            }
        }
    }
}
~~~



删除关系

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Order;
import com.bwf.pojo.OrderItem;
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        deleteOrderItem(session);
        listOrder(session);
 
        session.commit();
        session.close();
  
    }
 
    private static void deleteOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        session.delete("deleteOrderItem", oi);     
    }
 
 
    private static void listOrder(SqlSession session) {
        List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois= o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
    }
}
~~~



# 动态sql

## if标签

如果Product的字段比较多的话，为了应付各个字段的查询，那么就需要写多条sql语句，这样就变得难以维护。
这个时候，就可以使用Mybatis 动态SQL里的if标签

product.xml

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <select id="listProduct" resultType="Product">
            select * from product
            <if test="name!=null">
                where name like concat('%',#{name},'%')
            </if>        
        </select>
         
    </mapper>
~~~



测试类

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        System.out.println("查询所有的");
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p);
        }
         
        System.out.println("模糊查询");
        Map<String,Object> params = new HashMap<>();
        params.put("name","a");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }      
         
        session.commit();
        session.close();
  
    }
}
~~~



## where标签

<where>标签会进行自动判断
如果任何条件都不成立，那么就在sql语句里就不会出现where关键字
如果有任何条件成立，会自动去掉多出来的 and 或者 or。

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
    <select id="listProduct" resultType="Product">
        select * from product
        <where>
            <if test="name!=null">
                and name like concat('%',#{name},'%')
            </if>        
            <if test="price!=null and price!=0">
                and price > #{price}
            </if>
        </where>     
    </select>
         
    </mapper>
~~~

测试类

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
  
        System.out.println("多条件查询");
        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
        params.put("price","10");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }      
         
        session.commit();
        session.close();
  
    }
}
~~~



## set标签

与where标签类似的，在update语句里也会碰到多个字段相关的问题。 在这种情况下，就可以使用set标签

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
    <select id="listProduct" resultType="Product">
        select * from product
        <where>
            <if test="name!=null">
                and name like concat('%',#{name},'%')
            </if>        
            <if test="price!=null and price!=0">
                and price > #{price}
            </if>
        </where>     
    </select>
     
    <update id="updateProduct" parameterType="Product" >
        update product_
        <set>
            <if test="name != null">name=#{name},</if>
            <if test="price != null">price=#{price}</if>
              
        </set>
         
         where id=#{id}   
    </update>
         
    </mapper>
~~~

测试类

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        Product p = new Product();
        p.setId(6);
        p.setName("product zz");
        p.setPrice(99.99f);
        session.update("updateProduct",p);
         
        listAll(session);
 
        session.commit();
        session.close();
  
    }
 
    private static void listAll(SqlSession session) {
        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        params.put("price","10");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }
    }
}
~~~



## trim标签

trim 用来定制想要的功能，比如where标签就可以用

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
    <select id="listProduct" resultType="Product">
        select * from product
        <trim prefix="WHERE" prefixOverrides="AND |OR ">
            <if test="name!=null">
                and name like concat('%',#{name},'%')
            </if>        
            <if test="price!=null and price!=0">
                and price > #{price}
            </if>
        </trim>      
    </select>
     
    <update id="updateProduct" parameterType="Product" >
        update product
        <trim prefix="SET" suffixOverrides=",">
            <if test="name != null">name=#{name},</if>
            <if test="price != null">price=#{price}</if>
              
        </trim>
         
         where id=#{id}   
    </update>
         
    </mapper>
~~~



## choose标签

Mybatis里面没有else标签，但是可以使用when otherwise标签来达到这样的效果

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
        <select id="listProduct" resultType="Product">
              SELECT * FROM product
              <where>
                <choose>
                  <when test="name != null">
                    and name like concat('%',#{name},'%')
                  </when>          
                  <when test="price !=null and price != 0">
                    and price > #{price}
                  </when>                
                  <otherwise>
                    and id >1
                  </otherwise>
                </choose>
              </where>
        </select>
    </mapper>
~~~

测试类

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        Map<String,Object> params = new HashMap<>();
//      params.put("name","a");
//      params.put("price","10");
      List<Product> ps = session.selectList("listProduct",params);
      for (Product p : ps) {
          System.out.println(p);
      }
 
        session.commit();
        session.close();
  
    }
 
    private static void listAll(SqlSession session) {
 
    }
}
~~~



## foreach标签

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="com.bwf.pojo">
    <select id="listProduct" resultType="Product">
          SELECT * FROM product
            WHERE ID in
                <foreach item="item" index="index" collection="list"
                    open="(" separator="," close=")">
                    #{item}
                </foreach>
    </select>
    </mapper>
~~~

测试类

~~~java
package com.bwf;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Product;
  
public class TestMybatis {
  
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        List<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(3);
        ids.add(5);
         
      List<Product> ps = session.selectList("listProduct",ids);
      for (Product p : ps) {
          System.out.println(p);
      }
 
        session.commit();
        session.close();
  
    }
}
~~~



# 缓存的使用

mybatis中主要有2种缓存，一级缓存和二级缓存

Mybatis的一级缓存在session上，只要通过session查过的数据，都会放在session上，下一次再查询相同id的数据，都直接冲缓存中取出来，而不用到数据库里去取了。



在session1中查询两次id=1的Category对象。
第一次会去数据库中取数据，但是第二次就不会访问数据库了，而是直接从session中取出来。

~~~java
package com.bwf;
 
import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session1 = sqlSessionFactory.openSession();
 
        Category c1 = session1.selectOne("getCategory", 1);
        System.out.println(c1);
        Category c2 = session1.selectOne("getCategory", 1);
        System.out.println(c2);
 
        session1.commit();
        session1.close();
         
    }
 
}
~~~



在不同Session里查相同id的数据

这一次，另外打开一个session,取同样id的数据，就会发现需要执行sql语句，证实了一级缓存是在session里的。

~~~java
package com.bwf;
 
import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.bwf.pojo.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session1 = sqlSessionFactory.openSession();
 
        Category c1 = session1.selectOne("getCategory", 1);
        System.out.println(c1);
        Category c2 = session1.selectOne("getCategory", 1);
        System.out.println(c2);
 
        session1.commit();
        session1.close();
         
        SqlSession session2 = sqlSessionFactory.openSession();
        Category c3 = session2.selectOne("getCategory", 1);
        System.out.println(c3);    
        session2.commit();
        session2.close();
         
    }
 
}
~~~



Mybatis二级缓存是SessionFactory，如果两次查询基于同一个SessionFactory，那么就从二级缓存中取数据，而不用到数据库里去取了。

启动二级缓存

~~~properties
<setting name="cacheEnabled" value="true"/>
~~~

在Category.xml中增加 <cache/>

~~~xml
<mapper namespace="com.bwf.pojo">
        <cache/>
 ......
~~~



# 延迟加载

~~~xml
 <settings> 
         <!-- 打开延迟加载的开关 --> 
         <setting name="lazyLoadingEnabled" value="true" /> 
         <!-- 将积极加载改为消息加载即按需加载 --> 
         <setting name="aggressiveLazyLoading" value="false"/> 
 </settings> 
~~~

