package pl.bladekp.magazyn.test;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.bladekp.magazyn.di.consumer.ParameterConsumer;
import pl.bladekp.magazyn.di.service.ParameterService;

@Configuration
@ComponentScan(value = "pl.bladekp.magazyn.di.consumer")
public class SpringDIJUnitTest {
    
    private AnnotationConfigApplicationContext context = null;
    
    @Bean
    public ParameterService getParameterService(){
        return new ParameterService(){

            @Override
            public int addParameter(String name, String description, String unit, String measure) {
                System.out.println("Mock service");
                return 1;
            }
            
        };
    }
    
    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(SpringDIJUnitTest.class);
    }
    
    @After
    public void tearDown() throws Exception {
        context.close();
    }
    
    @Test
    public void test() {
        ParameterConsumer app = context.getBean(ParameterConsumer.class);
        Assert.assertTrue(app.processParameter("x", "y", "z", "") == -1);
        Assert.assertTrue(app.processParameter("x", "", "z", "y") == 1);
    }
}
