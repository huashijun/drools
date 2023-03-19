package com.huashijun.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    private static final KieServices KIE_SERVICES = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = KIE_SERVICES.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newUrlResource("https://raw.githubusercontent.com/huashijun/huashijun.github.io/master/pay-info.drl"));
        KieBuilder kb = KIE_SERVICES.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return KIE_SERVICES.newKieContainer(kieModule.getReleaseId());
    }
}
