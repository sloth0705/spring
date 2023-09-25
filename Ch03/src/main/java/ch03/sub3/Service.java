package ch03.sub3;

import org.springframework.stereotype.Component;

@Component("service2")
public class Service {
	public void insert() {
		System.out.println("Core Concern insert...");
	}

	public void select() {
		System.out.println("Core Concern select...");
	}

	public void update(int no) {
		System.out.println("Core Concern update...");
	}

	public void delete(int no, String name) {
		System.out.println("Core Concern delete...");
	}
}