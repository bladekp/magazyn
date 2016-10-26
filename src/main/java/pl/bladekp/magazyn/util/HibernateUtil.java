package pl.bladekp.magazyn.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *
 * @author bladekp
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure()
			.build();
	try {
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
		StandardServiceRegistryBuilder.destroy( registry );
                throw e;
	}
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
