package com.github.kr1tya3;

import com.codahale.metrics.health.jvm.ThreadDeadlockHealthCheck;
import com.github.kr1tya3.api.PrimeResource;
import com.github.kr1tya3.core.Sieve;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PrimeService extends Application<PrimeServiceConfiguration> {
    @Override
    public void run(PrimeServiceConfiguration primeServiceConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new PrimeResource(new Sieve()));
        environment.healthChecks().register("deadlocks", new ThreadDeadlockHealthCheck());
    }

    @Override
    public String getName() {
        return "prime-service";
    }

    public static void main(String[] args) throws Exception {
        new PrimeService().run(args);
    }
}
