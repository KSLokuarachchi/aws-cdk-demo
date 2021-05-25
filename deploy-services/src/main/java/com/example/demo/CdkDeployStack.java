package com.example.demo;

import com.example.demo.stacks.DynamoDbStack;
import com.example.demo.util.CdkUtil;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class CdkDeployStack extends Stack {

	public CdkDeployStack(final Construct parent, final String id, final StackProps props) {
		super(parent, CdkUtil.getConstructIdFromParent(parent, id), props);

		final DynamoDbStack dynamoDbStack = new DynamoDbStack(this);
	}
}
