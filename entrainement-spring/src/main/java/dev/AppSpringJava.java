package dev;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.ihm.Menu;


public class AppSpringJava {
	public static void main(String...strings) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(AppConfig.class);
			context.refresh();
			Menu menu = context.getBean(Menu.class);
			menu.afficher();
			context.getBean(Scanner.class).close();
			context.close();
		}
	}
}
