package com.singularity.ee.service.pegafixer;

import com.singularity.ee.agent.appagent.kernel.spi.data.IServiceConfig;
import com.singularity.ee.agent.util.log4j.ADLoggerFactory;
import com.singularity.ee.agent.util.log4j.IADLogger;
import com.singularity.ee.util.string.StringOperations;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AgentNodeProperties extends Observable {
    private static final IADLogger logger = ADLoggerFactory.getLogger((String)"com.singularity.dynamicservice.pegafixer.AgentNodeProperties");
    public static final String ENABLE_PROPERTY = "agent.pegafixer.enabled";
    public static final String[] NODE_PROPERTIES = new String[]{ENABLE_PROPERTY};
    private final Map<String, String> properties = new HashMap<>();

    public void initializeConfigs(IServiceConfig serviceConfig) {
        Map configProperties = serviceConfig.getConfigProperties();
        if( configProperties != null ) {
            boolean enabled = StringOperations.safeParseBoolean((String)((String)configProperties.get(ENABLE_PROPERTY)), (boolean)false);
            this.properties.put(ENABLE_PROPERTY, Boolean.toString(enabled));
            logger.info("Initializing the properties " + this);
        } else {
            logger.error("Config properties map is null?!?!");
        }
    }

    public String getProperty( String name ) {
        return this.properties.get(name);
    }

    public void updateProperty( String name, String value ) {
        String existingPropertyValue = this.properties.get(name);
        if( !StringOperations.isEmpty((String)value) && !value.equals(existingPropertyValue)) {
            this.properties.put(name, value);
            logger.info("updated property = " + name + " with value = " + value);
            this.notifyMonitoringService(name);
        } else {
            logger.info("did not update property = " + name + " because it was either unchanged or empty");
        }
    }

    protected void notifyMonitoringService(String name) {
        this.setChanged();
        this.notifyObservers(name);
    }

    public String toString() {
        return "AgentNodeProperties{properties=" + this.properties + '}';
    }

    public boolean isEnabled() {
        return StringOperations.safeParseBoolean((String)this.getProperty(ENABLE_PROPERTY), (boolean)false);
    }

}
