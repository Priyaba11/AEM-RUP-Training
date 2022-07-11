package com.ruptraining.aem.core.services;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import org.apache.sling.api.SlingConstants;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.Random;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.event.jobs.JobManager;

@Component(service = {EventHandler.class},
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
                EventConstants.EVENT_FILTER +"=(path=/content/ruptraining/us/en/homepage/*)"
        })
public class JobCreator implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(JobCreator.class);

    @Reference
    JobManager jobManager;

    public void handleEvent(final Event event) {
        try {
            Map<String, Object> jobProperties = new HashMap<String, Object>();
            jobProperties.put("event", event.getTopic());
            jobProperties.put("path", event.getProperty(SlingConstants.PROPERTY_PATH));
            jobProperties.put("dynamicId","12345");
            Job job=jobManager.addJob("ruptraining/job",jobProperties);

        }catch (Exception e){
            LOG.error("\n Exception is : {} " , e.getMessage());
        }
    }
}