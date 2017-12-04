package intj;

import intj.domain.elasticsearch.CatFeature;
import intj.domain.elasticsearch.FunnyCat;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.IndicesAdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class CatController
{
    @Autowired
    private FunnyCatService funnyCatService;

    @Autowired
    private CatFeatureRepository catFeatureRepository;

    @Autowired
    Client client;

    @RequestMapping(value = "/test/{name}/{age}")
    @ResponseBody
    public String test(@PathVariable("name") String name,
                       @PathVariable("age") String age){
        FunnyCat funnyCat = new FunnyCat(name, Integer.valueOf(age));

        CatFeature catFeature = new CatFeature(funnyCat, "jumping high and falling!");

       // catFeatureRepository.save(catFeature);

        funnyCat.addCatFeature(catFeature);

        funnyCatService.addFunnyCat(funnyCat);
        return "success!";

    }

    @RequestMapping(value = "/query1")
    @ResponseBody
    public String queryElasticsearch(){
        GetResponse response = client.prepareGet(
                ElasticSearchSettings.indexName,
                ElasticSearchSettings.type, "1").get();
        return response.getSource().toString();
    }
    @RequestMapping(value = "/query2")
    @ResponseBody
    public String queryElasticsearch2(){
        IndicesAdminClient indicesAdminClient = client.admin().indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        ActionFuture<GetIndexResponse> actionFuture = indicesAdminClient.getIndex(getIndexRequest);
        GetIndexResponse getIndexResponse = actionFuture.actionGet();
        return Arrays.toString(getIndexResponse.getIndices());
    }

}
