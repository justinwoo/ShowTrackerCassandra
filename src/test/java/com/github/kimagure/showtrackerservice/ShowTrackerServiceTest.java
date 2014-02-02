package com.github.kimagure.showtrackerservice;

import com.github.kimagure.showtrackerservice.resources.ShowTrackerResource;
import com.yammer.dropwizard.config.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/2/14
 * Time: 5:10 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerServiceTest {
    private final Environment environment = mock(Environment.class);
    private final ShowTrackerService service = new ShowTrackerService();
    private final ShowTrackerConfiguration config = new ShowTrackerConfiguration();

    @Before
    public void setup() throws Exception {

    }

    @Test
    public void buildsShowTrackerResource() throws Exception {
        service.run(config, environment);

        verify(environment).addResource(any(ShowTrackerResource.class));
    }

}
