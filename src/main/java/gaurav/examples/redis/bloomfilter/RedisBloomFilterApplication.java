package gaurav.examples.redis.bloomfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RedisBloomFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisBloomFilterApplication.class, args);
	}

}
