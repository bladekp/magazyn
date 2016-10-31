package pl.bladekp.magazyn.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bladekp.magazyn.di.service.ParameterService;

@Component
public class ParameterConsumer {
    
    private ParameterService service;
    
    @Autowired
    public void setService(ParameterService s){
        this.service = s;
    }
    
    public int processParameter(String name, String description, String unit, String measure){
        if (name != null && unit != null && measure != null &&
                name.length() > 0 && unit.length() > 0 && measure.length() >0){
            return this.service.addParameter(name, description, unit, measure);
        } else {
            return -1;
        }
    }
}
