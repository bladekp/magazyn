package pl.bladekp.magazyn.di.service;

import org.hibernate.Session;
import pl.bladekp.magazyn.model.Parameter;
import pl.bladekp.magazyn.util.HibernateUtil;

public class CasualParameterService implements ParameterService {

    @Override
    public int addParameter(String name, String description, String unit, String measure) {
        Parameter p = new Parameter();
        p.setName(name);
        p.setUnit(unit);
        p.setMeasure(measure);
        p.setDescription(description);
        
        //creating
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        return p.getId();
    }

}
