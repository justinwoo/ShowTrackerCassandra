package com.github.kimagure.showtrackerservice.health;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/2/14
 * Time: 3:09 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template ain't got no name");
        }
        return Result.healthy();
    }
}
