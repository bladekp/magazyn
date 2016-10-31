package pl.bladekp.magazyn.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import pl.bladekp.magazyn.annotation.MethodInfo;

public class AnnotationParser {
    
    public static void main(String args[]) throws Exception{
        try{
            for (Method method : AnnotationParser.class.getClassLoader().loadClass("pl.bladekp.magazyn.di.configuration.DIConfiguration").getMethods()){
                if (method.isAnnotationPresent(pl.bladekp.magazyn.annotation.MethodInfo.class)){
                    try{
                        for (Annotation annotation : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method " + method + " : " + annotation);
                        }
                        MethodInfo mi = method.getAnnotation(MethodInfo.class);
                        System.out.println("Rev: " + mi.revision() + " author: " + mi.author() + " comment " + mi.comments() + " date " + mi.date());
                    } catch (Exception ex1){
                        throw ex1;
                    }
                }
            }
        } catch(Exception ex2){
            throw ex2;
        }
    }
}
