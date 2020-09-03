package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

public class AppSpringXML {
	public static void main(String...strings) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-memoire.xml")) {
			
			Menu menu = context.getBean(Menu.class);
			
			menu.afficher();
			
			context.getBean(Scanner.class).close();
		}
	}
}
