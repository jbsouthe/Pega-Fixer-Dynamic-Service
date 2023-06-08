package com.singularity.ee.service.pegafixer;

import java.util.HashMap;
import java.util.Map;

public class MetaData {
    public static final String VERSION = "v0.1";
    public static final String BUILDTIMESTAMP = "06/08/2023 12:43 PM -0600";
    public static final String SERVICENAME = "Pega Fixer Service";
    public static final String GECOS = "John Southerland josouthe@cisco.com AppDynamics Field Architecture Team";
    public static final String GITHUB = "https://github.com/jbsouthe/Pega-Fixer-Dynamic-Service";
    public static final String DEVNET = "";
    public static final String SUPPORT = "https://github.com/jbsouthe/Pega-Fixer-Dynamic-Service/issues";


    public static Map<String,String> getAsMap() {
        Map<String,String> map = new HashMap<>();
        map.put("plugin-version", VERSION);
        map.put("plugin-name", SERVICENAME);
        map.put("plugin-buildTimestamp", BUILDTIMESTAMP);
        map.put("plugin-developer", GECOS);
        map.put("plugin-github", GITHUB);
        map.put("plugin-devnet", DEVNET);
        map.put("plugin-support", SUPPORT);
        return map;
    }
}
