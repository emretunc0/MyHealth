package com.garmin.gh.apps.wellnessmonitor;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import com.garmin.gh.apps.wellnessmonitor.dao.h2.UserPartnerDao;
import com.garmin.gh.apps.wellnessmonitor.domain.UserPartner;



@SpringBootApplication
public class HealthApiSampleImplApp extends SpringBootServletInitializer implements CommandLineRunner
{

	@Autowired
    private UserPartnerSource userSource;

    @Autowired
    UserPartnerDao userPartnerDao;
	
    
    private static final Logger logger = LoggerFactory.getLogger(HealthApiSampleImplApp.class);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(HealthApiSampleImplApp.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(HealthApiSampleImplApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
    	// loading default users from properties file
    	 List<UserPartner> userPartner = userSource.getUsers();
         userPartnerDao.save(userPartner);
         logger.info("displaying useraccesstoken and secret");
        

    }

}