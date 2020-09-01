package dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

import dev.config.AppConfig;
import dev.ihm.Menu;

public class AppSpringJava {
	public static void main(String...args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Menu menu = context.getBean(Menu.class);
		
		menu.afficher();
		
		context.getBean(Scanner.class).close();

		context.close();
		
	}
}
