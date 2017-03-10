package com.sparkcentral.calculator.calculatorApp;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
public class App {
	
	@Bean
	public CalculatorAppView calculatorAppView(){
		return new CalculatorAppView();
	}
	@Bean
	public CalculatorViewHelper calculatorViewHelper(){
		return new CalculatorViewHelper();
	}
	@Bean
	public CalFunctions calFunctions(){
		return new CalFunctions();
	}
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        CalculatorAppView view = context.getBean(CalculatorAppView.class);
        view.initilize();
    }
}
