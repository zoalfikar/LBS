package library_managment_system;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* library_managment_system.controllers.BookController.*.*(..))")
    public void logBefore() {
        System.out.println("Before method execution");
    }

}
