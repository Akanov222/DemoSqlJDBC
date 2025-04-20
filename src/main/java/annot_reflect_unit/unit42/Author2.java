package annot_reflect_unit.unit42;

public @interface Author2 {
    String name() default "Some name";
    int age() default 20;

}
