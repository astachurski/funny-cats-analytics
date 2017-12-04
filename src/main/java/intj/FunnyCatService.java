package intj;

import intj.domain.elasticsearch.FunnyCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class FunnyCatService {

    Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    @Autowired
    ElasticsearchTemplate template;

    @Autowired
    private FunnyCatRepository funnyCatRepository;

    public void addFunnyCat(FunnyCat funnyCat){
        log.info("adding to ELK");
        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(funnyCat.getId());
        indexQuery.setObject(funnyCat);

        template.putMapping(FunnyCat.class);
        template.index(indexQuery);
        template.refresh(FunnyCat.class);


    }
}
