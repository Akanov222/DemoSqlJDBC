package annot_reflect_unit.unit42;

import java.lang.annotation.Annotation;
import annot_reflect_unit.unit40.Author;
//import annot_reflect_unit.unit42.Person;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class personClass = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("annot_reflect_unit.unit42.Person");


//        Method[] methods = personClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//            System.out.println(method.getReturnType());
//            System.out.println(Arrays.toString(method.getParameterTypes()));
//        }

//        Field[] fields = personClass.getFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//        }

//        Field[] fields = personClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//        }
//
//        Class<Person> cv = Person.class;

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes");
            }
        }
    }
}
