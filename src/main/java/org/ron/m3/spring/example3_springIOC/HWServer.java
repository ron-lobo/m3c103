package org.ron.m3.spring.example3_springIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HWServer {

    @Autowired
    private Helper helper;

    @Bean
    public AudienceProvider getAudienceProvider() {
        return new DepA();
    }

    @Bean
    public GreetingService getGreetingService(AudienceProvider audienceProvider) {
        return new HWService(audienceProvider);
    }

    @Bean
    public Helper getHelper(GreetingService greetingService) {
        return new HWHelper(greetingService);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HWServer.class);
        HWServer hwServer = context.getBean(HWServer.class);
        hwServer.sayHello();

        AudienceProvider a = context.getBean(AudienceProvider.class);
        AudienceProvider b = context.getBean(AudienceProvider.class);
        System.out.println("equals?  " + (a == b));
    }

    private void sayHello() {
        helper.sayHi();
    }
}
