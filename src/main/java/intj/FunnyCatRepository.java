package intj;

import intj.domain.elasticsearch.FunnyCat;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FunnyCatRepository extends ElasticsearchRepository<FunnyCat, Integer> {


}

