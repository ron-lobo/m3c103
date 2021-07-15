package org.ron.m3.spring.example2.example1;

public class HWService implements GreetingService {

    private final AudienceProvider audienceProvider;

    public HWService(AudienceProvider audienceProvider) {
        this.audienceProvider = audienceProvider;
    }

    @Override
    public void makeGreeting(String salutation) {
        System.out.printf("%s %s%n", salutation, audienceProvider.getAudience());
    }
}
