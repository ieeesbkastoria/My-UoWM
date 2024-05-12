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

}
