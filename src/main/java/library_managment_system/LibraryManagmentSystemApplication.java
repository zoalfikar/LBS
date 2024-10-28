package library_managment_system;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableAspectJAutoProxy

public class LibraryManagmentSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagmentSystemApplication.class, args);
	}

}
