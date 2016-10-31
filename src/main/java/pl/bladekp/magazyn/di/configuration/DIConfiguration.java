package pl.bladekp.magazyn.di.configuration;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.bladekp.magazyn.annotation.MethodInfo;
import pl.bladekp.magazyn.di.service.CasualParameterService;
import pl.bladekp.magazyn.di.service.ParameterService;

@Configuration
@ComponentScan(value={"pl.bladekp.magazyn.di.consumer"})
public class DIConfiguration {
    
    @Bean
    @MethodInfo(comments = "some comment", date = "30.10.2016", revision = 2)
    public ParameterService getParameterService(){
        return new CasualParameterService();
    }
}
