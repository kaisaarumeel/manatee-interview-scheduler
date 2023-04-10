package ee.cyber.manatee;


import ee.cyber.manatee.seeders.Seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class Manatee {


    @Autowired
    private Seeder seeder;



    public static void main(String[] args) {
        SpringApplication.run(Manatee.class, args);
    }


    @PostConstruct
    public void seedDatabase() throws Exception {
        seeder.run();
    }



}
