package annot_reflect_unit.unit40;

public @interface Author {
    String name() default "Some name";
    int dateOfBirth() default 2000;

}
