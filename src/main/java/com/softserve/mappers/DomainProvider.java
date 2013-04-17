package com.softserve.mappers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@Named
@ApplicationScoped
public class DomainProvider {

    @PostConstruct
    private void configureObjectMapper() {

        System.out.println("=====@PostConstruct=works=fine=========");
    }

    @PreDestroy
    private void disposeDependencies() {

        System.out.println("=====@PreDestroy=works=fine=========");
    }

    public String toJson(String json) {

        return json;
    }

    public String fromJson(String json) {

        return json;
    }

}