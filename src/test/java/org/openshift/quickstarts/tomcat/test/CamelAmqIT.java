package org.openshift.quickstarts.tomcat.test;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.DisableJmx;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Here we want to run a basic test to ensure
 * that we can connect to an external AMQ and
 * we can send and receive messages...
 * Created by swinchester on 16/01/2017.
 */
@Category(CamelAmqIT.class)
@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisableJmx(false)
public class CamelAmqIT {

    @Autowired
    protected CamelContext camelContext;

    @EndpointInject(uri = "mock:mypoint")
    MockEndpoint myPoint;

    @Test
    public void runTest() throws InterruptedException {
        ProducerTemplate pt = camelContext.createProducerTemplate();

        myPoint.setExpectedCount(10);

        for(int i=0; i <10; i++){
            pt.sendBody("activemq:queue:helloqueue", "{ 'hello':'world' }");
        }

        Thread.sleep(10000);
        myPoint.assertIsSatisfied();

    }



}
