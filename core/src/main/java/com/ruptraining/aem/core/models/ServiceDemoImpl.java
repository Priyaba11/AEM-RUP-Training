package com.ruptraining.aem.core.models;
import com.ruptraining.aem.core.services.Car;

import org.apache.sling.api.SlingHttpServletRequest;
import com.ruptraining.aem.core.models.ServiceDemo;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceDemoImpl  implements ServiceDemo {
    private static final Logger LOG= LoggerFactory.getLogger(ServiceDemoImpl.class);

   // @OSGiService(filter = "(component.name=CarAudi)")
    @OSGiService
    Car car;

    @Override
    public String getNameFromService() {
        return car.getName();
    }


}