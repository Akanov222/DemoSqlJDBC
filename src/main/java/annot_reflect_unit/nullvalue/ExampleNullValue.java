package annot_reflect_unit.nullvalue;

import java.util.Optional;

public class ExampleNullValue {
    public static void main(String[] args) {
        long first = 0L;
        String name = null;

        Optional.ofNullable(name).ifPresent(System.out::println);
        Optional.ofNullable(name).ifPresentOrElse(System.out::println,
                () -> System.out.println("Не валидное значение"));

        String result = Optional.ofNullable(name)
                .map(String::toLowerCase)
                .orElse("Не валидное значение");
    }
}
