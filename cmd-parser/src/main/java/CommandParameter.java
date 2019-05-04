import java.lang.annotation.*;

public @interface CommandParameter {
    String text() default "";
    String description() default "";
    String overrideName() default "";
}
