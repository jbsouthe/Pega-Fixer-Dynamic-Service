package com.singularity.ee.service.pegafixer;

import com.singularity.ee.agent.appagent.kernel.spi.IServicePropertyListener;

public class AgentNodePropertyListener implements IServicePropertyListener {
    private PegaFixerService service;

    public AgentNodePropertyListener(PegaFixerService service) {
        this.service=service;
        this.service.getServiceContext().getKernel().getConfigManager().registerConfigPropertyChangeListener("DynamicService", AgentNodeProperties.NODE_PROPERTIES, (IServicePropertyListener)this);
    }

    @Override
    public void servicePropertyChanged(String serviceName, String propertyName, String newPropertyValue) {
        this.service.getAgentNodeProperties().updateProperty(propertyName, newPropertyValue);
    }
}
