package udem.edu.co.cda;

import org.springframework.boot.SpringApplication;

import udem.edu.co.cda.CdaApplication;

public class TestCdaApplication {

	public static void main(String[] args) {
		SpringApplication.from(CdaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
