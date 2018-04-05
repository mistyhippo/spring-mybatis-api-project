package mybatis.services;
import mybatis.mappers.MemeMapper;
import mybatis.model.meme.MemeResult;
import mybatis.model.meme.MemeRoot;
import mybatis.model.meme.ResponseComparison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemeService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MemeMapper memeMapper;

    public MemeRoot searchMemes(String query) {
        String fQuery = "http://version1.api.memegenerator.net//Instances_Select_ByPopular?" +
                "languageCode=en&pageIndex=0&urlName="+query+"&days=" +
                "&apiKey=4c8324fe-84d7-45c8-b63b-fac5122b8c47";
            //boilerplate code
        MemeRoot response = restTemplate.getForObject(fQuery, MemeRoot.class);

        return  response;
    }

    public ResponseComparison compareMemeResults(String t1, String t2) {
        //set the first search term in the ResponseComparison
        MemeRoot responseOne = searchMemes(t1);
        //set the second search term in the ResponseComparison
        MemeRoot responseTwo = searchMemes(t2);

        ResponseComparison obj = new ResponseComparison();
        // set the count for number of results in the ResponseComparison for Term one
        obj.setSearchTermOne(t1);
        //set the count for the number of results in the ResponseComparion for Term two
        obj.setSearchTermTwo(t2);
        obj.setSearchTermOneResultCount(responseOne.getResult().length);
        obj.setSearchTermTwoResultCount(responseTwo.getResult().length);

        return obj;
    }

    public MemeResult insertMemeService(MemeRoot object){
        //with our object we call the .getResult() method which returns the array of
        //MemeResult and we store that in the memeResults variable
        MemeResult[] memeResults= object.getResult();

        //we use foreach to loop through the elements of Memeresult array
        //and pass each array element to the insert()method in memeMapper
        for (MemeResult element:memeResults ) {
            //this method inserts into the database
            memeMapper.insert(element);
        }
        return memeResults[1];
    }

}
