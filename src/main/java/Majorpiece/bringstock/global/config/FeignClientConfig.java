package Majorpiece.bringstock.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableFeignClients(basePackages = "Majorpiece.bringstock")
public class FeignClientConfig {

}
