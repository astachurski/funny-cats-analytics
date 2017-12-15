package intj;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "intj.domain.elasticsearch")
public interface Configuration {
}
