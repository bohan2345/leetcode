package tc;

import java.lang.annotation.Documented;

@Documented
public @interface Anotations {
	String author() default "Bohan";

	String date() default "N/A";
}
