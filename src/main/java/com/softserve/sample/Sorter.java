package com.softserve.sample;

import com.softserve.mappers.DomainProvider;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/*
 * TODO: Should be renamed to ServiceFacade;
 */
@Named
public class Sorter {

    @Inject
    DomainProvider provider;

    public DomainProvider getProvider() {
        return provider;
    }

    public String sort(String jsonItems) {
        String items = provider.fromJson(jsonItems);

        return provider.toJson(items);
    }

    public String addWorld(String input) {
        return input + " world";
    }

}