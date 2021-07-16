package org.ron.m3.spring.example3_springIOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HWServer {

    private final Helper helper;

    @Bean
    public static AudienceProvider getAudienceProvider() {
        return new DepA();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HWServer.class);
        HWServer hwServer = context.getBean(HWServer.class);
        hwServer.sayHello();
    }

//    @Autowired
//    public void setHelper(Helper helper) {
//        this.helper = helper;
//    }

    // (implicitly) @Autowired
    public HWServer(Helper helper) {
        this.helper = helper;
    }

    private void sayHello() {
        helper.sayHi();
    }
}
