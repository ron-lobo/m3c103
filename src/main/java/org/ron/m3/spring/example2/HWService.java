package org.ron.m3.spring.example2;

public class HWService implements GreetingService {

    private final AudienceProvider audienceProvider;

    public HWService(AudienceProvider audienceProvider) {
        this.audienceProvider = audienceProvider;
    }

    @Override
    public int makeGreeting(String salutation) {
        System.out.printf("%s %s%n", salutation, audienceProvider.getAudience());
        return salutation.length();
    }
}
