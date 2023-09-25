package ch03.sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
	날짜 : 2023/09/19
	이름 : 신진성
	내용 : 스프링 XML기반 AOP 실습
*/
public class AOPTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		Service service = (Service) ctx.getBean("service1");
		
		service.insert();
		service.select();
		service.update(1);
		service.delete(1, "henlo");
	}
}