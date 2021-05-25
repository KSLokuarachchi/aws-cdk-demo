package com.example.demo;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

public final class CdkDeployApp {
    public static void main(final String[] args) {
        App app = new App();
        
        StackProps stackProps = StackProps
                .builder()
                .env(createEnvironment())
                .build();

        new CdkDeployStack(app, "CdkDeployStack", stackProps);

        app.synth();
    }
    
    private static Environment createEnvironment() {
    	//AWS Account details
        return Environment
            .builder()
            .account("AWS-ACCOUNT")
            .region("REGION")
            .build();
    }
}

