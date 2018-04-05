package mybatis.services;

import mybatis.model.nyt.NYTDocs;
import mybatis.model.nyt.NYTRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.model.nyt.internal.NYTOverview;
//import mybatis.threads.NYTOverviewThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



    @Service
    public class NYTService {

        @Autowired
        RestTemplate restTemplate;

        public NYTRoot searchNYT(String query) {
            String fQuery = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q="+query+"&api-key=75d3534c073a442abbab62367f493b32";
            NYTRoot response = restTemplate.getForObject(
                    fQuery, NYTRoot.class);

            return  response;
        }

        public ResponseComparison compareNYTResults(String t1, String t2) {
            //set the first search term in the ResponseComparison
            NYTRoot responseOne = searchNYT(t1);
            //set the second search term in the ResponseComparison
            NYTRoot responseTwo = searchNYT(t2);

            ResponseComparison obj = new ResponseComparison();
            // set the count for number of results in the ResponseComparison for Term one
            obj.setSearchTermOne(t1);
            //set the count for the number of results in the ResponseComparion for Term two
            obj.setSearchTermTwo(t2);
            obj.setSearchTermOneResultCount(responseOne.getResponse().getDocs().length);
            obj.setSearchTermTwoResultCount(responseTwo.getResponse().getDocs().length);

            return obj;
        }
//
//        public void insertNYTSummary(NYTDocs result) {
//        }
//
//        public void insertNYTSummary(NYTOVerview result){
//            nytMapper.insertSummary(result);
//        }

//        if(persist){
//            System.out.println("........starting persistence thread");
//            NYTOverviewThread thread = new NYTOverviewThread(response);
//        }
    }


