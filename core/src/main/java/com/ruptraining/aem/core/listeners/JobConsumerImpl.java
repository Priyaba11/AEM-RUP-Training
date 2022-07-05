package com.ruptraining.aem.core.listeners;

import com.ruptraining.aem.core.utils.ResolverUtil;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = JobConsumer.class,
        immediate = true,
        property = {
                JobConsumer.PROPERTY_TOPICS + "=ruptraining/job"
        })
public class JobConsumerImpl implements JobConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(JobConsumerImpl.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public JobResult process(Job job) {
        try {
            ResourceResolver resourceResolver= ResolverUtil.newResolver(resourceResolverFactory);
            String path = (String) job.getProperty("path");
            String event= (String) job.getProperty("event");
            String dynamicId=(String) job.getProperty("dynamicId");
            LOG.info("\n Job executing for  : {} ",resourceResolver.getResource(dynamicId).getName());
            return JobResult.OK;
        } catch (Exception e) {
            LOG.info("\n Error in Job Consumer : {}  ", e.getMessage());
            return JobResult.FAILED;
        }
    }
}
