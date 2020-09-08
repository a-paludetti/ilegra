package br.com.desafio.ilegra;

import br.com.desafio.ilegra.api.factories.ReadFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IlegraApplication {

	public static void main(String[] args) {
		start(args);
	}

	private static void start(String... args){
		new ReadFile().verifyFolders();
		new ReadFile().run();
		SpringApplication.run(IlegraApplication.class, args);
	}
}
