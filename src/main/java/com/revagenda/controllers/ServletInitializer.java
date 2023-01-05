package com.revagenda.controllers;

import com.revagenda.Revagenda;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This class is not strictly necessary just yet. This is the initializer for a servlet container.
 * As of now we are running this application in the dev server by running the main method.
 * Later we will want to package this application and deploy it as a WAR file, in which case
 * we will need this class in order to make our application compatible with some webservers like
 * tomcat.
 *
 * You will commonly see people extend their main method and override the configure() method
 * there. When it comes time, we will move this logic into main().
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("Servlet Initialization...");
        return builder.sources(Revagenda.class);
    }
}
