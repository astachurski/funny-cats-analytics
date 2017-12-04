package intj;

import intj.domain.elasticsearch.CatFeature;
import intj.domain.elasticsearch.FunnyCat;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CatFeatureRepository extends ElasticsearchRepository<CatFeature, Integer> {


}

