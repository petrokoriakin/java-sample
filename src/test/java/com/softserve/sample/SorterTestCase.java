package com.softserve.sample;

import com.softserve.mappers.DomainProvider;
import com.softserve.sample.Sorter;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(Arquillian.class)
public class SorterTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SorterTestCase.class);
    private static final String PATH_TO_SEARCH_REQUEST = "/json/search_request.json";
    private static final String PATH_TO_HOTELS = "/json/hotels_49.json";

    @Inject
    Sorter sorter;

    private String jsonSortRequest;
    private String jsonHotels;

    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Sorter.class)
            .addClass(DomainProvider.class)
            .addAsManifestResource(
                new ByteArrayAsset("<beans/>".getBytes()),
                ArchivePaths.create("beans.xml")
            );
    }

    @Test
    public void testSorter() {
        DomainProvider provider = sorter.getProvider();
        assertNotNull(provider);
    }

}
