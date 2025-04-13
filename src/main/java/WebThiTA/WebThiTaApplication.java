package WebThiTA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebThiTaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebThiTaApplication.class, args);
    }

}
