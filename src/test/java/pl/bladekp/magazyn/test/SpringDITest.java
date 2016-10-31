package pl.bladekp.magazyn.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.bladekp.magazyn.di.configuration.DIConfiguration;
import pl.bladekp.magazyn.di.consumer.ParameterConsumer;

public class SpringDITest {
    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new
            AnnotationConfigApplicationContext(DIConfiguration.class);
        ParameterConsumer app =
            context.getBean(ParameterConsumer.class);
        int pid = app.processParameter("Frequency", "", "f", "Hz");
        System.out.println(pid);
        context.close();
    }
}
