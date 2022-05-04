package co.com.sofka.crud.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperTodoDto {


    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();

    }
}
