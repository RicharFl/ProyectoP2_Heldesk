package com.ipn.Helpdesk;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages={
"com.ipn.Helpdesk", "com.ipn.Helpdesk.controladores", "com.ipn.Heldesk.Servicios.ServiciosImpl"})


public class HelpdeskApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
