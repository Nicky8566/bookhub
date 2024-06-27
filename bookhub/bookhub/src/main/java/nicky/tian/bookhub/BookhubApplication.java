package nicky.tian.bookhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookhubApplication.class, args);
	}

	@GetMapping("/home")
	public String header() {
		return "WELCOME TO BOOKHUB!";
	}

}
