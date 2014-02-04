package com.github.kimagure.showtrackerservice.resources;

import com.github.kimagure.showtrackerservice.core.Show;
import com.github.kimagure.showtrackerservice.hibernate.ShowDAO;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/2/14
 * Time: 5:29 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerResourceTest extends ResourceTest {
    private final Show show = new Show(1, "マイピュアメイデンのアニメ", 12);
    private final ShowDAO showDAO = mock(ShowDAO.class);

    @Override
    protected void setUpResources() {
        when(showDAO.findById(anyLong())).thenReturn(show);
        addResource(new ShowTrackerResource(showDAO));
    }

    @Test
    public void testSayHello() throws Exception {
        Show testShow = client().resource("/show-tracker/getShow?id=1").get(Show.class);
        System.out.println(testShow.getTitle());
        assert(testShow.getId() == 1);
    }
}
