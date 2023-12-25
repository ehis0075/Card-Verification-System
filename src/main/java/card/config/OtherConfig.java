package card.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OtherConfig {

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public Gson getGson() {
        return new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.BIG_DECIMAL)
                .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

}
