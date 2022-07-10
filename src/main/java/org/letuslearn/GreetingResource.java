package org.letuslearn;

import io.agroal.api.AgroalDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Path("/hello")
public class GreetingResource {

    @Inject
    PropertiesReader propertiesReader;


    @ConfigProperty(name = "file.location")
    String location;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws SQLException {

        return "welcome to quarkus"+location;
    }
}