package com.API.TP;
import com.API.TP.model.Ticket;
import com.API.TP.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;


@SpringBootApplication
public class TpApiApplication {

    public static void main(String[] args) {
        // créer un user
        User user = new User();
        user.setNom("test");
        user.setEmail("test@gmail.com");
        user.setMotDePasse("password");

        SpringApplication.run(TpApiApplication.class, args);
    }
}
