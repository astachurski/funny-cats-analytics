package intj;

import intj.domain.elasticsearch.CatDetails;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CatFeatureRepository extends ElasticsearchRepository<CatDetails, Integer> {


}

