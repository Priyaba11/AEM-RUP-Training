package com.ruptraining.aem.core.services;
import com.ruptraining.aem.core.services.Car;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Car.class,immediate = true,name = "CarAudi")
@ServiceRanking(1000)
public class Audi implements Car{
    private static final Logger LOG= LoggerFactory.getLogger(Audi.class);


    @Override
    public String getName() {
        return "Audi";
    }


}