package hello.demo.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   //class 레벨 붙인다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
