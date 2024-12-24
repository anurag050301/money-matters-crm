package org.moneymatters.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class MoneyMattersCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyMattersCrmApplication.class, args);
//        User user = new User();
//        UserDto userDto = new UserDto();
//        System.out.println(user);
//        System.out.println(userDto);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
