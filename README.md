# BaseDao
SSM抽取baseDao和BaseService




https://ke.qq.com/course/439506?tuin=c4ad01b分布式电商项目https://ke.qq.com/course/398016?tuin=c4ad01b互联网架构课程





讲师：任亮






 
1	maven环境搭建
1.1	解压maven3.5.3
 
1.2	设置maven本地仓库
 

打开settings.xml修改本地仓库的位置
 
1.3	idea的配置

1.3.1	jdk配置
设置jdk1.8
 
 

1.3.2	配置maven

在idea中配置好maven的HOME和 settings.xml
 
2	创建工程
 
2.1	加入pom文件的依赖
子模块要继承父模块，父模块要聚合子模块
的pom.xml
<dependencies>
    <!-- spring -->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>${aspectj.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
    </dependency>

    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>${servlet.version}</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>${jsp.version}</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>${jstl.version}</version>
    </dependency>

    <!-- log start -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j.version}</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>${slf4j.version}</version>
    </dependency>
    <!-- log end -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
    </dependency>

    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>${mybatis-spring.version}</version>
    </dependency>
<!-- https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core -->
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.5</version>
</dependency>
    <!--连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>${druid.version}</version>
    </dependency>


    <!-- fastjson -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>${fastjson.version}</version>
    </dependency>
    <!--文件上传处理-->
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>${commons-io.version}</version>
    </dependency>
    <dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>${commons-fileupload.version}</version>
    </dependency>

    <dependency>
        <groupId>commons-codec</groupId>
        <artifactId>commons-codec</artifactId>
        <version>${commons-codec.version}</version>
    </dependency>

</dependencies>


<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <spring.version>5.0.2.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <log4j.version>1.2.12</log4j.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
    <aspectj.version>1.6.8</aspectj.version>
    <junit.version>4.12</junit.version>
    <servlet.version>2.5</servlet.version>
    <jsp.version>2.0</jsp.version>
    <jstl.version>1.2</jstl.version>
    <druid.version>1.1.10</druid.version>
    <fastjson.version>1.2.47</fastjson.version>
    <commons-io.version>2.0.1</commons-io.version>
    <commons-fileupload.version>1.3.1</commons-fileupload.version>
    <commons-codec.version>1.10</commons-codec.version>
    <mybatis-spring.version>1.3.0</mybatis-spring.version>
</properties>



2.2	 搭建mybatis和spring的架构


视图层				控制层					业务层			数据层






对应数据库表   modle包
dao层			  dao包
Service层		  service包
mapper映射文件存储



2.2.1	建包

 resources资源包下引入
	日志文件log4j.properties
	数据库连接文件：db.properties
 



















2.2.2	逆向工程
2.2.2.1	在core工程中加入配置文件generatorConfig.xml
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <context id="mybatisGenerator" >
        <commentGenerator>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
            <property name="suppressAllComments" value="true" />
        </commentGenerator>
        <!--数据库连接的信息：驱动类、连接地址、用户名、密码 -->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/ham?serverTimezone=CTT&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;allowMultiQueries=true" userId="root"
                        password="root">
        </jdbcConnection>

        <!-- 默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer，为 true时把JDBC DECIMAL 和
            NUMERIC 类型解析为java.math.BigDecimal -->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <!-- targetProject:生成PO类的位置 -->
        <javaModelGenerator targetPackage="cn.tx.model"
                            targetProject="src\main\java">
            <!-- 从数据库返回的值被清理前后的空格 -->
            <property name="trimStrings" value="true" />
        </javaModelGenerator>
        <!-- targetProject:mapper映射文件生成的位置 -->
        <sqlMapGenerator targetPackage="mapper"
                         targetProject="src\main\resources">
        </sqlMapGenerator>
        <!-- targetPackage：mapper接口生成的位置 -->
        <javaClientGenerator type="XMLMAPPER"
                             targetPackage="cn.tx.dao"
                             targetProject="src\main\java">
        </javaClientGenerator>
        <!-- 指定数据库表 -->
        <table tableName="songer" enableCountByExample="false"
               enableUpdateByExample="false" enableDeleteByExample="false"
               enableSelectByExample="false" selectByExampleQueryId="false"/>

    </context>
</generatorConfiguration>

2.2.2.2	在类中创建逆向工程的执行类
package cn.tx.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        /**指向逆向工程配置文件*/
        File configFile = new File("src/main/resources/mybatis-generator.xml");
        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration config = parser.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {
        try {
            Generator generatorSqlmap = new Generator();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


执行逆向工程后，就会我们的项目中就会生成下面的代码
 

逆向工程做完后我们已经有了数据层和model

2.2.3	创建Service层
在service包中创建接口

public interface SongerService {


    public void addSonger(Songer songer);

    public Songer getSongerById(int songId);

    public void updateSonger(Songer songer);

    public void delSongerById(int songId);

}
在service.impl中创建接口的实现类
@Service
public class SongerServiceImpl implements SongerService {

    @Autowired
    private SongerMapper songerMapper;

    @Override
    public void addSonger(Songer songer) {
        songerMapper.insert(songer);
    }

    @Override
    public Songer getSongerById(int songId) {
        return songerMapper.selectByPrimaryKey(songId);
    }

    @Override
    public void updateSonger(Songer songer) {
        songerMapper.updateByPrimaryKeySelective(songer);
    }

    @Override
    public void delSongerById(int songId) {
        songerMapper.deleteByPrimaryKey(songId);
    }
}


2.2.4	创建mybatis的全局配置文件
在resources里面创建sqlMapConfig.xml
注册映射配置文件SongerMapper.xml

<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <mappers>
        <mapper resource="mapper/SongerMapper.xml"/>
    </mappers>
</configuration>
2.2.5	创建spring的配置文件
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop.xsd
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx.xsd">

    <context:component-scan base-package="cn.tx"></context:component-scan>

    <context:property-placeholder location="classpath:db.properties"/>    
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${driverClass}"></property>
        <property name="url" value="${url}"></property>
        <property name="username" value="${uname}"></property>
        <property name="password" value="${pword}"></property>
    </bean>

    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="configLocation" value="classpath:sqlMapConfig.xml"></property>
    </bean>

    <bean id="mapperScan" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
        <property name="basePackage" value="cn.tx.dao"></property>
    </bean>

    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <tx:advice id="txAdvice" transaction-manager="txManager">
        <tx:attributes>
            <tx:method name="add*" propagation="REQUIRED"/>
            <tx:method name="update*" propagation="REQUIRED"/>
            <tx:method name="del*" propagation="REQUIRED"/>
            <tx:method name="modify*" propagation="REQUIRED"/>
            <tx:method name="remove*" propagation="REQUIRED"/>
            <tx:method name="get" read-only="true"></tx:method>
            <tx:method name="select" read-only="true"></tx:method>
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:advisor advice-ref="txAdvice" pointcut="execution(* cn.tx.service..*.*(..))"></aop:advisor>
    </aop:config>
</beans>

2.2.6	在测试资源包内测试整合
 



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class SongerTest {

    @Autowired
    SongerService songerService;

    @Test
    public void testAdd(){
        Songer s = new Songer();
        s.setArea("北京");
        s.setIntro("很好");
        s.setIsHot(1);
        s.setPic("zz");
        s.setSrname("亮哥");
        songerService.addSonger(s);
    }

    @Test
    public void getById(){
        Songer songer = songerService.getSongerById(1);
        System.out.println(songer);
    }

    @Test
    public void updateSonger(){
        Songer songer = songerService.getSongerById(1);
        songer.setSrname("最亮的仔");
        songerService.updateSonger(songer);
    }

    @Test
    public void delSongerById(){
        songerService.delSongerById(1);
    }
}

3	公共的代码抽取
3.1	创建baseDao

public interface BaseDao<T> {

    int deleteByPrimaryKey(Integer srid);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer srid);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}



3.2	创建专辑的Dao接口
public interface MtypeMapper extends BaseDao<Mtype> {

}


类图：

 

3.3	创建公共的Service接口
public interface BaseService<T> {

    int deleteByPrimaryKey(Integer srid);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer srid);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}


3.4	创建公共Service的实现类
public class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseDao<T> baseDao;

    @Override
    public int deleteByPrimaryKey(Integer srid) {
        return 0;
    }

    @Override
    public int insert(T record) {
        return 0;
    }

    @Override
    public int insertSelective(T record) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(Integer srid) {
        return baseDao.selectByPrimaryKey(srid);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return 0;
    }
}


3.5	创建专辑的Service接口

public interface AlbumService extends BaseService<AlbumQuery, Album> {


}


3.6	创建专辑的Service接口实现类
@Service
public class MtypeServiceImpl extends BaseServiceImpl<Mtype> implements MtypeService {

    private MtypeMapper mtypeMapper;

    @Autowired
    public void setMtypeMapper(MtypeMapper mtypeMapper) {
        this.mtypeMapper = mtypeMapper;
        this.baseDao = mtypeMapper;
    }
}



类图：
 
3.7	创建测试类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class MtypeTest {

    @Autowired
    private MtypeService mtypeService;

    @Test
    public void test(){
        Mtype mtype = mtypeService.selectByPrimaryKey(2);
        System.out.println(mtype);
    }
}




