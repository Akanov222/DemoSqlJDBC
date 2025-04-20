package annot_reflect_unit.unit41;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodIfo {
    String author() default "Ivan";
    int dateOfBirth() default 2025;
    String purpose();
}
