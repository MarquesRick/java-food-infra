package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class JavaVpcStack extends Stack {
    private Vpc vpc;
    public JavaVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public JavaVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);
        Vpc vpc = Vpc.Builder.create(this, "JavaVpc")
                .maxAzs(3)  // Default is all AZs in region
                .build();
    }

    public Vpc getVpc() {
        return vpc;
    }
}
