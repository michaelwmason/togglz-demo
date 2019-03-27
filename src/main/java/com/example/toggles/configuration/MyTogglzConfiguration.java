package com.example.toggles.configuration;

import java.io.File;

import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;

import com.example.toggles.MyFeatures;

//@Component
public class MyTogglzConfiguration implements TogglzConfig {

//	@Autowire
//	MongoClient mongoClient
	
    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }

    public StateRepository getStateRepository() {
        return new FileBasedStateRepository(new File("/features.properties"));
//        StateRepository stateRepository = MongoStateRepository.newBuilder(mongoClient, "myDatabase")
//                .collection("myFeatureState")
//                .writeConcern(WriteConcern.REPLICA_ACKNOWLEDGED)
//                .build();
    }

    public UserProvider getUserProvider() {
        return new ServletUserProvider("admin");
    }

}
