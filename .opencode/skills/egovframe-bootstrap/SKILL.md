---
name: egovframe-bootstrap
description: eGovFrame 4.3.0 기반 Maven 프로젝트 초기 셋업 및 디렉토리 구조 생성
license: Apache-2.0
compatibility: opencode
metadata:
  version: 1.0.0
  created: 2026-03-30
  based-on: 260330-egov-demo project
  tested-with: Java-11, Maven-3.9, Jetty-9.4
  audience: java-developers
  framework: eGovFrame-4.3.0
  language: Korean
  purpose: project-initialization
  stack: Spring-MyBatis-JSP-H2-Jetty
---

# eGovFrame Bootstrap Skill

전자정부프레임워크 (eGovFrame) 4.3.0 기반 Maven 프로젝트의 초기 셋업을 자동화하는 스킬입니다.

---

## 🎯 Overview

이 스킬은 **eGovFrame 4.3.0** 프로젝트의 초기 셋업과 디렉토리 구조 생성을 담당합니다.

**제공 기능:**
- Maven pom.xml 자동 생성 (eGovFrame 4.3.0 + 필수 의존성)
- 표준 프로젝트 디렉토리 구조 생성
- Spring 설정 파일 7 개 템플릿 제공
- H2 데이터베이스 초기화 설정
- Jetty 9.4 기반 실행 환경 설정

**기술 스택:**
- eGovFrame 4.3.0
- Spring 5.3.37
- MyBatis 3.5.9
- H2 Database (임베디드)
- Jetty 9.4 (Servlet 4.0 호환)
- DBCP2 (Connection Pool)

---

## 📋 When to Use

이 스킬을 사용하는 경우:

1. **새로운 eGovFrame 프로젝트 시작**
   - "eGovFrame 프로젝트 만들어줘"
   - "전자정부프레임워크로 새 프로젝트 시작해줘"
   - "Maven 기반 eGovFrame 프로젝트 셋업해줘"

2. **프로젝트 구조 생성**
   - "eGovFrame 표준 디렉토리 구조 만들어줘"
   - "Spring 설정 파일 생성해줘"
   - "H2 데이터베이스 초기화 설정해줘"

3. **빌드 환경 설정**
   - "Jetty 로 실행 가능한 프로젝트 만들어줘"
   - "Maven 플러그인 설정해줘"

---

## ⚙️ Pre-requisites (필수)

**작업 시작 전에 반드시 확인:**

### 1. Java 버전 확인

```bash
java -version
javac -version
echo $JAVA_HOME
```

**확인 사항:**
- eGovFrame 4.3.0 은 **Java 11 이상** 권장
- Spring 5.3.x 는 Java 8 이상 지원
- 사용 중인 Java 버전과 프로젝트 요구사항 호환성 확인

### 2. Maven 버전 확인

```bash
mvn -version
```

**확인 사항:**
- **Maven 3.6 이상** 권장
- eGovFrame 공식 리포지토리 접근 가능 여부 확인

### 3. Servlet 컨테이너 (Tomcat 9 또는 Jetty 9.4)

**이 스킬은 Servlet 4.0 (Tomcat 9 / Jetty 9.4) 을 사용합니다.**

```bash
# Tomcat 버전 확인 (사용 시)
$CATALINA_HOME/bin/catalina.sh version

# Jetty 는 Maven 플러그인으로 자동 설치
mvn jetty:run
```

**주의사항:**
- **Tomcat 10 이상 사용 금지** (Jakarta EE 9+ 호환성 문제)
- eGovFrame 4.3.0 은 Servlet 4.0 기반

---

## 🏗️ Project Structure

생성할 표준 디렉토리 구조:

```
project-root/
├── pom.xml                                   # Maven 설정 (eGovFrame 4.3.0)
├── src/
│   ├── main/
│   │   ├── java/egovframe/example/{module}/
│   │   │   ├── web/                          # REST Controller
│   │   │   ├── service/                      # Service Interface
│   │   │   ├── service/impl/                 # Service Implementation
│   │   │   ├── dao/                          # DAO (EgovAbstractMapper)
│   │   │   └── config/                       # Configuration classes
│   │   ├── resources/egovframework/
│   │   │   ├── spring/com/                   # Spring 설정 파일 (7 개)
│   │   │   │   ├── context-common.xml
│   │   │   │   ├── context-datasource.xml
│   │   │   │   ├── context-mapper.xml
│   │   │   │   ├── context-mvc.xml
│   │   │   │   ├── context-idgnr.xml
│   │   │   │   ├── context-transaction.xml
│   │   │   │   └── context-properties.xml
│   │   │   ├── sqlmap/
│   │   │   │   ├── sqlmap-config.xml         # MyBatis 설정
│   │   │   │   └── mappings/                 # SQL 맵핑 파일
│   │   │   └── egovProps/
│   │   │       └── globals.properties        # Validation 메시지
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml                   # Servlet 설정
│   │   │   │   └── jsp/                      # JSP 뷰 파일
│   │   │   └── index.jsp                     # 메인 페이지
│   │   └── resources/
│   │       └── schema.sql                    # DB 스키마
│   └── test/java/egovframe/example/{module}/ # 테스트 코드
└── README.md
```

---

## 🚀 File Templates

### 1. pom.xml (완전 버전)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.egovframe.example</groupId>
    <artifactId>egov-demo</artifactId>
    <version>1.0.0</version>
    <packaging>war</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        
        <!-- eGovFrame Version -->
        <egovframe.version>4.3.0</egovframe.version>
        <spring.version>5.3.37</spring.version>
        <mybatis.version>3.5.9</mybatis.version>
        <mybatis-spring.version>2.1.1</mybatis-spring.version>
        <h2.version>2.2.224</h2.version>
        <hibernate-validator.version>6.2.5.Final</hibernate-validator.version>
    </properties>

    <repositories>
        <repository>
            <id>egovframe</id>
            <name>eGovFrame Maven Repository</name>
            <url>https://maven.egovframe.go.kr/maven/</url>
            <releases><enabled>true</enabled></releases>
            <snapshots><enabled>false</enabled></snapshots>
        </repository>
    </repositories>

    <dependencies>
        <!-- eGovFrame Core -->
        <dependency>
            <groupId>org.egovframe.rte</groupId>
            <artifactId>org.egovframe.rte.ptl.mvc</artifactId>
            <version>${egovframe.version}</version>
        </dependency>
        <dependency>
            <groupId>org.egovframe.rte</groupId>
            <artifactId>org.egovframe.rte.psl.dataaccess</artifactId>
            <version>${egovframe.version}</version>
        </dependency>
        <dependency>
            <groupId>org.egovframe.rte</groupId>
            <artifactId>org.egovframe.rte.fdl.idgnr</artifactId>
            <version>${egovframe.version}</version>
        </dependency>
        <dependency>
            <groupId>org.egovframe.rte</groupId>
            <artifactId>org.egovframe.rte.fdl.property</artifactId>
            <version>${egovframe.version}</version>
        </dependency>

        <!-- Spring (spring-webmvc 는 eGovFrame 에서 transitively 로드됨) -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- MyBatis -->
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

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>${h2.version}</version>
            <scope>runtime</scope>
        </dependency>

        <!-- DBCP2 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.9.0</version>
        </dependency>

        <!-- Validation -->
        <dependency>
            <groupId>javax.validation</groupId>
            <artifactId>validation-api</artifactId>
            <version>2.0.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>${hibernate-validator.version}</version>
        </dependency>

        <!-- JSON -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version>
        </dependency>

        <!-- Servlet API (Servlet 4.0 = Tomcat 9) -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

        <!-- JSP & JSTL -->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <!-- Logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.36</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.12</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>egov-demo</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.4.0</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>

            <!-- Jetty 9.4 Maven Plugin (Servlet 4.0) -->
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>9.4.53.v20231009</version>
                <configuration>
                    <scan>10</scan>
                    <webApp>
                        <contextPath>/</contextPath>
                    </webApp>
                    <httpConnector>
                        <port>8080</port>
                    </httpConnector>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### 2. web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>EgovFrame Demo</display-name>

    <!-- Spring Context Config Location -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>
            classpath*:egovframework/spring/com/context-common.xml
            classpath*:egovframework/spring/com/context-datasource.xml
            classpath*:egovframework/spring/com/context-mapper.xml
            classpath*:egovframework/spring/com/context-transaction.xml
            classpath*:egovframework/spring/com/context-idgnr.xml
            classpath*:egovframework/spring/com/context-properties.xml
        </param-value>
    </context-param>

    <!-- Context Listener -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- Encoding Filter -->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- Dispatcher Servlet -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:/egovframework/spring/com/context-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!-- Welcome File List -->
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

</web-app>
```

### 3. Spring 설정 파일 7 개

#### 3.1 context-common.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Component Scan -->
    <context:component-scan base-package="egovframe.example"/>

    <!-- Message Source for validation messages -->
    <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
        <property name="basenames">
            <list>
                <value>egovframework.egovProps.globals</value>
            </list>
        </property>
        <property name="defaultLocale" value="ko_KR"/>
        <property name="useCodeAsDefaultMessage" value="true"/>
    </bean>

    <!-- LeaveaTrace for EgovAbstractServiceImpl AOP logging -->
    <bean id="leaveaTrace" class="org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace"/>

</beans>
```

#### 3.2 context-datasource.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- H2 DataSource -->
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="org.h2.Driver"/>
        <property name="url" value="jdbc:h2:mem:egovdb;DB_CLOSE_DELAY=-1;MODE=MySQL;CASE_INSENSITIVE_IDENTIFIERS=TRUE"/>
        <property name="username" value="sa"/>
        <property name="password" value=""/>
        <property name="defaultAutoCommit" value="false"/>
        <property name="defaultReadOnly" value="false"/>
        <property name="initialSize" value="10"/>
        <property name="maxTotal" value="30"/>
        <property name="maxIdle" value="20"/>
        <property name="minIdle" value="5"/>
        <property name="maxWaitMillis" value="60000"/>
    </bean>

    <!-- JdbcTemplate for schema initialization -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

</beans>
```

#### 3.3 context-mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- SqlSessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:/egovframework/sqlmap/sqlmap-config.xml"/>
        <property name="mapperLocations" value="classpath*:egovframework/sqlmap/mappings/*.xml"/>
    </bean>

    <!-- SqlSessionTemplate -->
    <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg ref="sqlSessionFactory"/>
    </bean>

    <!-- SqlSession alias for EgovAbstractMapper -->
    <alias name="sqlSessionFactory" alias="sqlSession"/>

</beans>
```

#### 3.4 context-mvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/mvc
            http://www.springframework.org/schema/mvc/spring-mvc.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Component Scan for Controllers -->
    <context:component-scan base-package="egovframe.example.*.web"/>

    <!-- Validator for Bean Validation -->
    <bean id="beanValidator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean"/>

    <!-- Annotation Driver -->
    <mvc:annotation-driven validator="beanValidator">
        <mvc:message-converters>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>

    <!-- View Resolver for JSP -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
        <property name="order" value="1"/>
    </bean>

</beans>
```

#### 3.5 context-idgnr.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- ID Generator Template (복사하여 각 모듈마다 생성) -->
    <!--
    <bean name="egov{Module}IdGnrService"
          class="org.egovframe.rte.fdl.idgnr.impl.EgovTableIdGnrServiceImpl"
          destroy-method="destroy">
        <property name="dataSource" ref="dataSource"/>
        <property name="strategy" ref="{module}IdStrategy"/>
        <property name="blockSize" value="10"/>
        <property name="table" value="IDS"/>
        <property name="tableName" value="{MODULE}_ID"/>
    </bean>

    <bean name="{module}IdStrategy"
          class="org.egovframe.rte.fdl.idgnr.impl.strategy.EgovIdGnrStrategyImpl">
        <property name="prefix" value="{MODULE}_"/>
        <property name="cipers" value="6"/>
        <property name="fillChar" value="0"/>
    </bean>
    -->

</beans>
```

#### 3.6 context-transaction.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/tx
            http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!-- Transaction Manager -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- Transaction Annotation Driver -->
    <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>
```

#### 3.7 context-properties.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Properties Service (필요시 추가) -->

</beans>
```

### 4. sqlmap-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <setting name="cacheEnabled" value="true"/>
        <setting name="lazyLoadingEnabled" value="false"/>
        <setting name="aggressiveLazyLoading" value="false"/>
        <setting name="multipleResultSetsEnabled" value="true"/>
        <setting name="useColumnLabel" value="true"/>
        <setting name="useGeneratedKeys" value="false"/>
        <setting name="autoMappingBehavior" value="PARTIAL"/>
        <setting name="defaultExecutorType" value="SIMPLE"/>
        <setting name="defaultStatementTimeout" value="25000"/>
        <setting name="callSettersOnNulls" value="false"/>
    </settings>
</configuration>
```

### 5. DatabaseInitializer.java

```java
package egovframe.example.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class DatabaseInitializer {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        try {
            String sql = readSqlFile("/schema.sql");
            String[] statements = sql.split(";");
            for (String statement : statements) {
                statement = statement.trim();
                if (!statement.isEmpty()) {
                    try {
                        jdbcTemplate.execute(statement);
                    } catch (Exception e) {
                        // Ignore errors (tables may already exist)
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    private String readSqlFile(String path) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sql = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sql.append(line).append("\n");
        }
        reader.close();
        return sql.toString();
    }
}
```

### 6. schema.sql (예시)

```sql
-- BOARD 테이블 생성
CREATE TABLE IF NOT EXISTS BOARD (
    bbs_id VARCHAR(20) PRIMARY KEY,
    bbs_title VARCHAR(100) NOT NULL,
    bbs_content TEXT NOT NULL,
    user_id VARCHAR(50),
    user_name VARCHAR(50) NOT NULL,
    view_count INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    upd_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_yn CHAR(1) DEFAULT 'N'
);

-- IDS 테이블 생성 (ID Generator 용)
CREATE TABLE IF NOT EXISTS IDS (
    TABLE_NAME VARCHAR(50) PRIMARY KEY,
    NEXT_ID BIGINT NOT NULL
);

-- ID Generator 초기값 설정
INSERT INTO IDS (TABLE_NAME, NEXT_ID) VALUES ('BOARD_ID', 1)
ON CONFLICT (TABLE_NAME) DO NOTHING;
```

### 7. globals.properties

```properties
# Validation Messages
NotBlank.value=입력은 필수입니다
Size.value=길이는 {max} 이하여야 합니다
```

### 8. DAO 템플릿 (EgovAbstractMapper 표준 방식)

```java
package egovframe.example.{module}.dao;

import egovframe.example.{module}.service.{Module}VO;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("{module}DAO")
public class Egov{Module}DAO extends EgovAbstractMapper {

    // 목록 조회 (명시적 타입 캐스팅 필요)
    public List<{Module}VO> select{Module}List() {
        return (List<{Module}VO>)list("egovframe.example.{module}.dao.Egov{Module}DAO.select{Module}List", null);
    }

    // 상세 조회 (selectByPk 사용)
    public {Module}VO select{Module}Detail(String id) {
        return ({Module}VO)selectByPk("egovframe.example.{module}.dao.Egov{Module}DAO.select{Module}Detail", id);
    }

    // 등록 (void 반환)
    public void insert{Module}({Module}VO vo) {
        insert("egovframe.example.{module}.dao.Egov{Module}DAO.insert{Module}", vo);
    }

    // 수정 (int 반환)
    public int update{Module}({Module}VO vo) {
        return update("egovframe.example.{module}.dao.Egov{Module}DAO.update{Module}", vo);
    }

    // 삭제 (int 반환)
    public int delete{Module}(String id) {
        return delete("egovframe.example.{module}.dao.Egov{Module}DAO.delete{Module}", id);
    }
}
```

**중요 주의사항:**
- ❌ `getSession()` 메서드는 **존재하지 않음**
- ✅ `list()`, `selectByPk()`, `insert()`, `update()`, `delete()` 메서드 사용
- ⚠️ `insert()` 는 `void` 반환 (return value 필요 시 적합하지 않음)
- ⚠️ `list()`, `selectByPk()` 는 **명시적 타입 캐스팅 필요**

---

## ⚠️ Critical Configuration Notes

**실제 프로젝트에서 발생한 문제 기반의 중요 설정 사항:**

### 1. context-mvc.xml 에 Component Scan 필수

```xml
<context:component-scan base-package="egovframe.example.*.web"/>
```

**이유:** DispatcherServlet 은 `context-mvc.xml` 만 로드하므로, Controller 가 스캔되지 않습니다.

### 2. sqlSession 빈 타입 설정

```xml
<alias name="sqlSessionFactory" alias="sqlSession"/>
```

**이유:** `EgovAbstractMapper` 는 `SqlSessionFactory` 타입의 `sqlSession` 빈을 필요로 합니다. `SqlSessionTemplate` 은 안 됩니다.

### 3. DBCP2 속성명

```xml
<property name="maxTotal" value="30"/>        <!-- DBCP2 -->
<property name="maxWaitMillis" value="60000"/> <!-- DBCP2 -->
```

**주의:** DBCP1 은 `maxActive`, `maxWait` 를 사용합니다. DBCP2 는 다릅니다.

### 4. DispatcherServlet 경로

```xml
<param-value>classpath:/egovframework/spring/com/context-mvc.xml</param-value>
```

**이유:** `classpath:` 접두사가 없으면 ServletContext 리소스로 해석되어 찾을 수 없습니다.

### 5. H2 스키마 초기화

**권장:** Java 코드 (`DatabaseInitializer`) 에서 처리
**비권장:** JDBC URL 에 `INIT=` 파라미터 사용 (이스케이프 문제 발생)

### 6. EgovAbstractMapper 의 올바른 사용법

```java
// ✅ 올바른 사용 - EgovAbstractMapper 가 제공하는 메서드 사용
@Repository("bookDAO")
public class BookDAO extends EgovAbstractMapper {
    
    public List<BookVO> selectBookList() {
        return (List<BookVO>)list("namespace.selectBookList", null);
    }
    
    public BookVO selectBookDetail(String id) {
        return (BookVO)selectByPk("namespace.selectBookDetail", id);
    }
    
    public void insertBook(BookVO vo) {
        insert("namespace.insertBook", vo);  // void 반환
    }
    
    public int updateBook(BookVO vo) {
        return update("namespace.updateBook", vo);
    }
    
    public int deleteBook(String id) {
        return delete("namespace.deleteBook", id);
    }
}
```

**중요 주의사항:**
- ❌ `getSession()` 메서드는 **존재하지 않음**
- ✅ `list()`, `selectByPk()`, `insert()`, `update()`, `delete()` 메서드 사용
- ⚠️ `insert()` 는 `void` 반환 (return value 필요 시 적합하지 않음)
- ⚠️ `list()`, `selectByPk()` 는 **명시적 타입 캐스팅 필요**

---

## 🛠️ Build & Run Commands

```bash
# 컴파일
mvn clean compile

# 실행 (Jetty - 백그라운드 실행, 로그 파일 기록)
lsof -ti:8080 | xargs kill -9 2>/dev/null; mvn jetty:run > jetty.log 2>&1 &

# API 테스트 (10 초 대기 후)
sleep 10 && curl -s http://localhost:8080/demo/api/books | head -100

# WAR 빌드
mvn clean package

# 테스트 실행
mvn test

# Tomcat 9 로 실행 (대안)
# pom.xml 에 tomcat9-maven-plugin 추가 필요
mvn tomcat9:run
```

---

## ✅ Verification Checklist

초기셋업 완료 후 반드시 확인:

### 1. 컴파일 성공

```bash
mvn clean compile
# SUCCESS 확인
```

### 2. Jetty 실행

```bash
lsof -ti:8080 | xargs kill -9 2>/dev/null; mvn jetty:run > jetty.log 2>&1 &
sleep 10 && curl -s http://localhost:8080/
# 200 OK 또는 JSP 응답 확인
```

### 3. DB 초기화

```bash
# Jetty 로그에서 DatabaseInitializer 확인
# "Failed to initialize database" 오류 없음 확인
```

### 4. Spring 컨텍스트

```bash
# Jetty 로그 확인
"Initializing Spring root WebApplicationContext"
"Initializing Spring DispatcherServlet 'dispatcher'"
# 오류 없음 확인
```

---

## ⚡ Server Execution Guidelines

**중요:** 서버 실행 시 무한 대기하지 말고 백그라운드에서 실행하세요.

### 올바른 서버 실행 방법

```bash
# 1. 기존 프로세스 종료
lsof -ti:8080 | xargs kill -9 2>/dev/null

# 2. 백그라운드 실행 (로그 파일 기록)
mvn jetty:run > jetty.log 2>&1 &

# 3. 10 초 대기 후 API 테스트 (절대 sleep 시간을 늘리지 마세요)
sleep 10 && curl -s http://localhost:8080/demo/api/books
```

### 주의사항

- ❌ `mvn jetty:run` 만 실행하지 마세요 (터미널이 블락됨)
- ✅ 항상 `> jetty.log 2>&1 &` 로 백그라운드 실행
- ✅ sleep 시간은 **10 초로 고정** (늘리지 마세요)
- ✅ API 테스트는 `sleep 10 && curl ...` 한 줄로 실행

---

## ⚠️ Common Issues & Solutions

### 1. `ClassNotFoundException: org.apache.commons.dbcp.BasicDataSource`

**원인:** DBCP1 대신 DBCP2 사용

**해결:**
```xml
<!-- DBCP2 사용 -->
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
    <property name="maxTotal" value="30"/>  <!-- maxActive 아님 -->
</bean>
```

### 2. `Mapped Statements collection does not contain value`

**원인:** MyBatis mapper 파일 로드 실패

**해결:**
```xml
<!-- context-mapper.xml -->
<alias name="sqlSessionFactory" alias="sqlSession"/>
```

### 3. `Table "BOARD" not found`

**원인:** H2 스키마 초기화 실패

**해결:** `DatabaseInitializer.java` 추가

### 4. Controller 스캔 안 됨 (404)

**원인:** `context-mvc.xml` 에 Component Scan 없음

**해결:**
```xml
<context:component-scan base-package="egovframe.example.*.web"/>
```

### 5. H2 INIT 스크립트 이스케이프 오류

**원인:** JDBC URL 에서 이스케이프 문자 처리 문제

**해결:** Java 코드 (`DatabaseInitializer`) 에서 스키마 초기화

### 6. `cannot find symbol: method getSession()` 오류

**원인:** `EgovAbstractMapper` 는 `getSession()` 메서드를 제공하지 않음

**해결:**
```java
// ❌ 잘못된 사용
public List<BookVO> selectBookList() {
    return getSession().selectList("namespace.query");
}

// ✅ 올바른 사용
public List<BookVO> selectBookList() {
    return (List<BookVO>)list("namespace.query", null);
}
```

---

## 📚 Next Steps

초기셋업 완료 후 구현할 내용:

### 1. VO (Value Object) 생성

```java
package egovframe.example.{module}.service;

import javax.validation.constraints.*;

public class {Module}VO {
    private String id;
    @NotBlank
    private String title;
    // getter/setter
}
```

### 2. DAO 구현

```java
package egovframe.example.{module}.dao;

import egovframe.example.{module}.service.{Module}VO;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("{module}DAO")
public class Egov{Module}DAO extends EgovAbstractMapper {

    public List<{Module}VO> select{Module}List() {
        return (List<{Module}VO>)list("egovframe.example.{module}.dao.Egov{Module}DAO.select{Module}List", null);
    }

    public {Module}VO select{Module}Detail(String id) {
        return ({Module}VO)selectByPk("egovframe.example.{module}.dao.Egov{Module}DAO.select{Module}Detail", id);
    }

    public void insert{Module}({Module}VO vo) {
        insert("egovframe.example.{module}.dao.Egov{Module}DAO.insert{Module}", vo);
    }

    public int update{Module}({Module}VO vo) {
        return update("egovframe.example.{module}.dao.Egov{Module}DAO.update{Module}", vo);
    }

    public int delete{Module}(String id) {
        return delete("egovframe.example.{module}.dao.Egov{Module}DAO.delete{Module}", id);
    }
}
```

**중요 주의사항:**
- ❌ `getSession()` 메서드는 **존재하지 않음**
- ✅ `list()`, `selectByPk()`, `insert()`, `update()`, `delete()` 메서드 사용
- ⚠️ `insert()` 는 `void` 반환
- ⚠️ `list()`, `selectByPk()` 는 **명시적 타입 캐스팅 필요**
```

### 3. Service 구현

```java
package egovframe.example.{module}.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("egov{Module}Service")
public class Egov{Module}ServiceImpl extends EgovAbstractServiceImpl {
    // 비즈니스 로직 구현
}
```

### 4. Controller 생성

```java
package egovframe.example.{module}.web;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/{module}/api")
public class {Module}RestController {
    // REST API 엔드포인트
}
```

### 5. MyBatis SQL 맵핑

```xml
<!-- src/main/resources/egovframework/sqlmap/mappings/{module}_SQL.xml -->
<mapper namespace="egovframe.example.{module}.dao.Egov{Module}DAO">
    <!-- CRUD SQL 정의 -->
</mapper>
```

### 6. JSP 뷰 생성 (선택사항)

```jsp
<!-- src/main/webapp/WEB-INF/jsp/{module}.jsp -->
<html>
<!-- UI 구현 -->
</html>
```

---

## 📚 Reference

- **eGovFrame 4.3.0**: https://www.egovframe.go.kr
- **Maven Repository**: https://maven.egovframe.go.kr/maven/
- **Spring 5.3**: https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/
- **MyBatis 3.5**: https://mybatis.org/mybatis-3/
- **H2 Database**: https://www.h2database.com/
- **Jetty 9.4**: https://www.eclipse.org/jetty/documentation/9.4.x/

---

## 🔧 eGovRAGServer MCP

전자정부프레임워크의 정보를 찾을 수 있는 `eGovRAGServer` MCP 를 사용할 수 있습니다.

**사용 방법:**
```
eGovRAGServer_search_egov_docs(query="검색할 키워드", top_k=3)
```

**예시:**
- "게시판 페이징 처리 방법"
- "DispatcherServlet 설정"
- "EgovAbstractMapper 사용 방법"
