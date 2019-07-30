package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// Mapper 인터페이스를 인식할 수 있도록 설정
@MapperScan(value = {"com.example.demo.board.mapper"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*
	 * SqlSessionFactory 설정 
	 * MyBatis의 SqlSessionFactory를 반환해줍니다.
	 * 스프링부트가 실행할 대 DataSource객체를 이 메서드 실행 시 주입해서 결과를 만들고,
	 * 그 결과를 스프링내 빈으로 사용하게 됩니다.
	 */
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
	

}
