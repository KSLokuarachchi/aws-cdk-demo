package com.example.demo.stacks;

import com.example.demo.util.CdkUtil;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.services.dynamodb.Attribute;
import software.amazon.awscdk.services.dynamodb.AttributeType;
import software.amazon.awscdk.services.dynamodb.BillingMode;
import software.amazon.awscdk.services.dynamodb.Table;

/**
 * @author Kasuni Lokuarachchi
 *
 */
public class DynamoDbStack extends Construct {

	private final Table demoTable;

	public DynamoDbStack(Stack scope) {
		super(scope, CdkUtil.getConstructIdFromStack(scope, "dynamodb"));
		this.demoTable = buildTaxiTable(CdkUtil.getConstructIdFromParent(this, "demoDynamoDB"));
	}

	private Table buildTaxiTable(String taxiTableName) {
		// Creating table including PK and SK
		return Table.Builder.create(this, taxiTableName).tableName(taxiTableName).removalPolicy(RemovalPolicy.DESTROY)
				.billingMode(BillingMode.PAY_PER_REQUEST).partitionKey(getTaxiTablePk()).sortKey(getTaxiTableSk())
				.build();
	}

	private Attribute getTaxiTableSk() {
		return Attribute.builder().name("sk").type(AttributeType.STRING).build();
	}

	private Attribute getTaxiTablePk() {
		return Attribute.builder().name("pk").type(AttributeType.STRING).build();
	}

	public Table getTaxiTable() {
		return demoTable;
	}

}
