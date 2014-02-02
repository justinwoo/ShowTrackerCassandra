package com.github.kimagure.showtrackerservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 8:08 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template = "Hello, %s.";

    @NotEmpty
    @JsonProperty
    private String defaultName = "Man-child";

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }
}
