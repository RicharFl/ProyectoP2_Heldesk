package com.ipn.Helpdesk;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.ipn.Helpdesk", "com.ipn.Helpdesk.controladores", "com.ipn.Heldesk.Servicios.ServiciosImpl"})


public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
