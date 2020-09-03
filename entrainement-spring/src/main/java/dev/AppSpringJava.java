package dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import dev.config.AppConfig;
import dev.ihm.Menu;

@Controller
public class AppSpringJava {
	public static void main(String...strings) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(AppConfig.class);
			context.refresh();
			Menu menu = context.getBean(Menu.class);
			menu.afficher();
			context.close();
		}
	}
}
