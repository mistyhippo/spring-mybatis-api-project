package mybatis.controllers;

import mybatis.model.meme.MemeRoot;
import mybatis.model.meme.ResponseComparison;
import mybatis.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    MemeService memeService;

    //http://localhost:8080/meme/search?query
//    @RequestMapping("/search")
//    public MemeRoot searchMeme(@RequestParam(value = "query", defaultValue = "cats") String query) {
//        return memeService.searchMemes(query);
//    }

    @RequestMapping("/search")
    public MemeRoot searchMeme(@RequestParam(value = "query", defaultValue = "") String query) {
        return memeService.searchMemes(query);
    }



//http://localhost:8080/meme/compare?t1=cats&t2=dogs
    // ResponseComparison is the return type for the compareMemeResult method
    @RequestMapping("/compare")
    public ResponseComparison compareMemeResult(@RequestParam(value = "t1", required = true) String t1,
                                                @RequestParam(value = "t2", required = true) String t2) {
        return memeService.compareMemeResults(t1, t2);
    }

   // http://localhost:8080/meme/insert?query
    @RequestMapping("/insert")
    public MemeRoot insertMeme(@RequestParam(value = "query", defaultValue = "") String query) {
        MemeRoot rootObject = memeService.searchMemes(query);
        memeService.insertMemeService(rootObject);

        return rootObject;
    }

}
