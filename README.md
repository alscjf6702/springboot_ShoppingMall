
# Springboot 🛒ShoppingMall 만들기🛒

<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=plastic&logo=SpringBoot&logoColor=white"> : version '2.7.5'<br>
<img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=plastic&logo=Thymeleaf&logoColor=white"> : version '3.0.0' <br>
<img src="https://img.shields.io/badge/OpenJDK-437291?style=plastic&logo=OpenJDK&logoColor=white"> : version '17' <br>
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=plastic&logo=springsecurity&logoColor=white"> : version '5.7.4' <br>
<img src="https://img.shields.io/badge/QueryDSL-437291?style=plastic&logo=&logoColor=white"> : version '5.0.0' <br>
buildtool : <img src="https://img.shields.io/badge/Gradle-02303A?style=plastic&logo=Gradle&logoColor=white"> <br>
database : <img src="https://img.shields.io/badge/MySQL-4479A1?style=plastic&logo=MySQL&logoColor=white">  <br>
IDE : <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=plastic&logo=intellijidea&logoColor=white">  <br>
<br>
<img src="https://img.shields.io/badge/database_Name-ECD53F?style=plastic&logo=&logoColor=white"> : 'shoppingMall' <br>
<img src="https://img.shields.io/badge/server_port-ECD53F?style=plastic&logo=&logoColor=white"> : '80' <br>
<img src="https://img.shields.io/badge/MySQL_port-ECD53F?style=plastic&logo=&logoColor=white"> : '3306' <br>
<br>
<img src="https://img.shields.io/badge/usedSkills-6DB33F?style=plastic&logo=&logoColor=white"><br>
<img src="https://img.shields.io/badge/JPA-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/h2database-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/lombok-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/springweb-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/mysql-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/springboot-devtools-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/thymeleaf-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/springSecurity-000000?style=plastic&logo=&logoColor=white">
<img src="https://img.shields.io/badge/QueryDsl-000000?style=plastic&logo=&logoColor=white">
<hr>

#### JPA란?
##### JPA ( Java Persistence API )는 애플리케이션 데이터를 객체지향 관점으로 바라보고 다룰 수 있게 해주는 자바 진영의 ORM 기술 표준인 객체지향 기술이다.
ORM ( Object Relational Mapping )은 객체와 관계형 데이터베이스를 맵핑해주는 기술이다.<br>
즉 SQL 작성없이 객체를 데이터베이스에 직접 저장할 수 있게 도와주는 기술이며, 애플리케이션과 JDBC사이에서 동작한다.<br>
<br>
JPA를 사용하려면 JPA를 구현한 ORM 프레임워크를 선택해야 하는데, ORM프레임워크는 hibernate, EclipseLink, DataNucleus 중 hibernate가 <br>가장 대중적이며, 지금 하고있는 shoppingmall 프로젝트에 쓰인다.
<br>
#### 그렇다면, SQL을 직접 다룰 때의 단점으로는?
🔸 반복적인 CRUD SQL문 작성과 객체를 SQL에 맵핑하는 코드를 작성하는데 시간이 많이 걸린다.<br>
🔸 객체에 필드를 하나 추가할 때 DAO의 CRUD코드와 SQL 대부분을 변경해야 하는 문제가 있다. (SQL에 매우 의존적인 방법)<br>

#### JPA를 사용해야 하는 이유?
🔹특정 데이터베이스에 종속되지 않음<br>
&nbsp;&nbsp;&nbsp;데이터베이스에는 Oracle DB, MariaDB 등의 여러가지 DB가 있는데, Oracle DB를 사용하다가 Maria DB를 사용해야해서 변경을 한다면 <br>
&nbsp;&nbsp;&nbsp;데이터베이스마다 쿼리문이 다르기 때문에 전체를 수정해야 한다. 이 때문에 처음 선택한 데이터베이스를 변경하려면 시간이<br>
&nbsp;&nbsp;&nbsp;오래 걸리고 어렵다. 하지만 JPA는 추상화한 데이터 접근 계층을 제공하기 때문에 설정 파일에 어떤 데이터베이스를<br>
&nbsp;&nbsp;&nbsp;사용할 것인지 알려주면 얼마든지 데이터베이스를 변경하기 쉽다.<br>
🔹객체지향적 프로그래밍<br>
&nbsp;&nbsp;&nbsp;SQL을 직접 다루면서 데이터베이스 설계 중심의 패러다임에서 객체지향적으로 설계가 가능하다.<br> 
&nbsp;&nbsp;&nbsp;좀 더 직관적이고 비즈니스 로직에 집중할 수 있도록 도와준다.<br>
🔹생산성 향상<br>
&nbsp;&nbsp;&nbsp;SQL을 직접 다룬다면 데이터 베이스 테이블에 새로운 컬럼이 추가될 경우, 해당 테이블의 컬럼을 사용하는 DTO클래스의<br> 
&nbsp;&nbsp;&nbsp;필드도 모두 변경해야한다. JPA에서는 테이블과 맵핑된 클래스에 필드만 추가하면 쉽게 관리가 가능하다. <br>
&nbsp;&nbsp;&nbsp;또한 SQL문을 직접 작성하지 않고 객체를 사용하여 동작하기 때문에 유지보수 측면에서 좋고 재사용성도 증가한다.<br>

#### JPA 동작 방식은?
JPA 동작을 위해 Entity, Entity Manager Factory, Entity Manager, Persistence Context를 알아야 한다.<br>
![image](https://github.com/alscjf6702/springboot_study/assets/143998544/a9a925d5-544d-44cc-879e-dd952caf9678)<br>
<br>
🔳Entity(엔티티)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ 엔티티란 데이터베이스의 테이블에 대응하는 클래스라고 생각한다.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; @Entity 어노테이션이 붙은 클래스는 JPA에서 관리되며 엔티티라고 부른다. 데이터베이스에 item테이블을 만들고, 이에 대응되는 item.java<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 클래스를 만들어서 @Entity 어노테이션을 붙이면 이 클래스가 엔티티가 되는 것 이다. 클래스 혹은 생성한 인스턴스도 엔티티라 부른다.<br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ 밑의 표는 엔티티 맵핑 관련 어노테이션이다.<br>
![image](https://github.com/alscjf6702/springboot_study/assets/143998544/8312d215-b44b-46bd-8a33-0441f7105e93)
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ 예시로,<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; @Table(name = "") 을 이용해서 "" 안에 DB에 저장된 table명을 작성해준다.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; @Id 를 이용하면 해당 변수가 해당 테이블의 기본키가 된다.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; @Column(name="") 을 이용하면 @Table과 같이 name="" 안에 DB에 저장 할 column명을 써준다.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; @GeneratedValue( strategy = GenerationType.AUTO) 를 이용하면 SQL문의 AUTO_INCREMENT와 같이 1,2,3,4,5,6,7 처럼 자동으로 숫자가 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 늘어난다. 이와 같이 SQL문을 대체하는 간단한 어노테이션을 사용해서 Entity클래스를 만들어 줄 수 있다.<br>
<br>
![image](https://github.com/alscjf6702/springboot_study/assets/143998544/66e5c63e-59fa-4c13-9806-1da75a1ad325)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ 위의 코드에서 Item클래스에 @Entity와 @Table(name="item") 어노테이션을 사용해주면서 Entity 등록이 되었고, JPA에서 관리된다.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 그리고 private Long id에는 위에 설명했듯이 @Id, @Column, @GeneratedValue 어노테이션을 사용해주면서 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; id변수는 기본키이며, item_id라는 컬럼명을 갖고, 1씩 늘어나는 값을 가지게 된다.<br>

<hr>

🔳 Entity Manager(엔티티 매니저)<br>
엔티티 메니저란 영속성 컨텍스트에 접근하여 엔티티에 대한 데이터베이스 작업을 제공한다. 내부적으로 데이터 베이스 커넥션을 사용해서 데이터베이스에 접근한다.<br>
엔티티 매니저의 몇 가지 메서드를 살펴보자.<br><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ <b>엔티티 메니저의 메서드</b> <br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ find() : 영속성 컨텍스트에서 엔티티를 검색, 영속성 컨텍스트에 없을 경우 DB에서 데이터를 찾아 영속성 컨텍스트에 저장한다.<br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ persist() : 엔티티를 영속성 컨텍스트에 저장한다.<br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ remove() : 엔티티 클래스를 영속성 컨텍스트에서 삭제한다.<br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ▪️ flush() : 영속성 컨텍스트에 저장된 내용을 데이터베이스에 반영한다.<br>
<hr>
🔳 Entity Manager Factory(엔티티 매니저 팩토리)<br>
엔티티 매니저 팩토리는 엔티티 매니저 인스턴스를 관리하는 주체이다. 애플리케이션 실행 시 한 개만 만들어지며, 사용자로부터 요청이 오면 엔티티 매니저 팩토리<br>
로부터 엔티티 매니저를 생성한다.
<hr>
🔳 Persistence Context(영속성 컨텍스트)<br>
JPA를 이해하기 위해서는 영속성 컨텍스트를 이해해야한다. 엔티티를 영구 저장하는 환경으로 엔티티 매니저를 통해 영속성 컨텍스트에 접근한다.



### 회원가입
