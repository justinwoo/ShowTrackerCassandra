package com.github.kimagure.showtrackerservice.resources;

import com.github.kimagure.showtrackerservice.ShowTrackerConfiguration;
import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/2/14
 * Time: 5:29 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerResourceTest {
    private final ShowTrackerConfiguration configuration = new ShowTrackerConfiguration();
    private final ShowTrackerResource resource = new ShowTrackerResource(configuration.getTemplate(), configuration.getDefaultName());

    @Test
    public void testSayHello() throws Exception {
        String response = resource.sayHello(Optional.of("man-child"));
        assert(response.contains("man-child"));
        assert(!response.contains(configuration.getDefaultName()));
    }
}
