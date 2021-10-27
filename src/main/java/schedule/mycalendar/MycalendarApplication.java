package schedule.mycalendar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class MycalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycalendarApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}

	// @CreatedBy @LastModifiedBy 어노테이션으로 등록된 컬럼에 데이터를 생성하는 Bean
	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of(UUID.randomUUID().toString());
	}

}
