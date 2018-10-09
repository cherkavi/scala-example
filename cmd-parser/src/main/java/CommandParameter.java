import java.lang.annotation.*;

public @interface CommandParameter {
    String text() default "";
    String overrideName() default "";
}
