package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class JavaAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();
        JavaVpcStack vpcStack = new JavaVpcStack(app, "Vpc");
        JavaClusterStack clusterStack = new JavaClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);
        JavaServiceStack serviceStack = new JavaServiceStack(app, "Service", clusterStack.getCluster());
        serviceStack.addDependency(clusterStack);
        app.synth();
    }
}

