//package mybatis.threads;
//
//import mybatis.model.nyt.NYTDocs;
//import mybatis.model.nyt.NYTRoot;
//import mybatis.model.nyt.internal.NYTOverview;
//import mybatis.services.NYTService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class NYTOverviewThread implements Runnable {
//
//    @Autowired
//    NYTService nytService;
//
//    Thread thrd;
//    NYTRoot data;
//
//    public NYTOverviewThread( NYTRoot data) {
//        thrd = new Thread(this);
//        this.data = data;
//        thrd.start();
//    }
//
////    @Override
////    public void run() {
////        for(NYTDocs result : data.getResponse().getDocs()){
////
////            NYTOverview obj = new NYTOverview();
////            obj.setDate(result.getPub_date());
////            obj.setHeadline(result.getHeadline().getMain());
////            obj.setSummary(result.getSnippet());
////
////            try {
////
////                obj.setImageUrl(result.getMultimedia()[0].getUrl());
////
////            } catch (Exception e){
////
////                obj.setImageUrl("n/a");
////            }
////
////            nytService.insertNYTSummary(obj);
////
////        }
//    }
//}
