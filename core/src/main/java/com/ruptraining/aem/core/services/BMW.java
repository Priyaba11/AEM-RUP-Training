package com.ruptraining.aem.core.services;
import com.ruptraining.aem.core.services.Car;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Car.class,immediate = true,name = "CarBMW")
@ServiceRanking(1001)
public class BMW implements Car{
    private static final Logger LOG= LoggerFactory.getLogger(BMW.class);


    @Override
    public String getName() {
        return "BMW";
    }


}