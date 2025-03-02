package udem.edu.co.CDA;

import org.springframework.boot.SpringApplication;

public class TestCdaApplication {

	public static void main(String[] args) {
		SpringApplication.from(CdaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
