package com.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CamelHelloWorldSpringExample {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("jmsmq:MyQueue", "Hello World");
		} finally {
			camelContext.stop();
		}
}
}
/*	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public void welcome(Model model) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("jmsmq:MyQueue", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
	}*/
