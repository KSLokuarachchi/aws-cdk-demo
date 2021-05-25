package com.example.demo.util;

import static java.lang.String.join;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;

public class CdkUtil {

    private static final String ENV = "env";

    //setting a prefix
    public static String getConstructIdFromParent(Construct parent, String name) {
        return join("-", name, (String) parent.getNode().tryGetContext(ENV));
    }
    
    public static String getConstructIdFromStack(Stack parent, String name) {
        return join("-", name, (String) parent.getNode().tryGetContext(ENV));
    }
}
