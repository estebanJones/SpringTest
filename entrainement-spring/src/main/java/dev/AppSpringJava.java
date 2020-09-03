package dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import dev.config.AppConfig;
import dev.ihm.MenuBean;

@Controller
public class AppSpringJava {
	public static void main(String...strings) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(AppConfig.class);
			context.refresh();
			MenuBean menu = context.getBean(MenuBean.class);
			menu.afficher();
			context.close();
		}
	}
}
