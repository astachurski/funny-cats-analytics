package intj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class FunnyCatsAnalyticsApplication implements CommandLineRunner {

	private FunnyCatService funnyCatService;

    @Autowired
    public void setFunnyCatService(FunnyCatService funnyCatService) {
        this.funnyCatService = funnyCatService;
    }

    public static void main(String[] args) {
		SpringApplication.run(FunnyCatsAnalyticsApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {


    }
}
