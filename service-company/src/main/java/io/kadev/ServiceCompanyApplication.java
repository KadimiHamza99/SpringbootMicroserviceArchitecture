package io.kadev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompanyRepository cr,RepositoryRestConfiguration rrc) {
		return args->{
			rrc.exposeIdsFor(Company.class);
			cr.save(new Company(null,"A",100+Math.random()*900));
			cr.save(new Company(null,"B",100+Math.random()*900));
			cr.save(new Company(null,"C",100+Math.random()*900));
		};
	}

}
