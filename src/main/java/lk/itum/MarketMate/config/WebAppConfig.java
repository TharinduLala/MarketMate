package lk.itum.MarketMate.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {
    public ModelMapper modelMapper(){return new ModelMapper();}
}
