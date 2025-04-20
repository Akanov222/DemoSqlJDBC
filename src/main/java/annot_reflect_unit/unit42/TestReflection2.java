package annot_reflect_unit.unit42;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        // Название_класса1 Название_класса2 Название_метода
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName(scanner.next());
        String methodName = scanner.next();

    // вводим java.lang.Thread java.lang.String setName

        Method method = classObject1.getMethod(methodName, classObject2);
        Object object1 = classObject1.newInstance();
        Object object2 = classObject2.getConstructor(String.class).newInstance("String value");

        method.invoke(object1, object2);

        System.out.println(object1);
    }
}
