package gr.ieee.cs.uowm.myuowm_admin_panel;

import gr.ieee.cs.uowm.myuowm_admin_panel.auth.AuthenticationService;
import gr.ieee.cs.uowm.myuowm_admin_panel.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static gr.ieee.cs.uowm.myuowm_admin_panel.user.Role.ADMIN;

@SpringBootApplication
public class MyUoWmAdminPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUoWmAdminPanelApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService servicel
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Adam")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token:" + servicel.register(admin).getAccessToken());
		};
	}

}
