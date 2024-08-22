package gr.ieee.cs.uowm.myuowm_admin_panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SLF4J
@SpringBootApplication
public class MyUoWmAdminPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUoWmAdminPanelApplication.class, args);
		log.info("Application Started");
	}

}
