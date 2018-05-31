package com.yicai.taotalent.controller;

import com.yicai.taotalent.domain.Livedetails;
import com.yicai.taotalent.repository.LiveDetailsRepository;
import com.yicai.taotalent.utils.PageRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * Created by RamboLi
 * Date 2018/5/5 0005
 * Time 22:46
 */
@RestController
public class LiveDetailsController {
//    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName(charset)));
    private final static Logger logger = LoggerFactory.getLogger(LiveDetailsController.class);
    @Autowired
    private LiveDetailsRepository liveDetailsRepository;
    @GetMapping(value = "/livedetails")
    public Page<Livedetails> getAnchorList(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        //构建分页信息
        PageRequest pageRequest = PageRequestUtil.buildPageRequest(page,pageSize,"created");
        Page<Livedetails> liveDetails = liveDetailsRepository.findAll(pageRequest);
        return liveDetails;
    }
    @RequestMapping("/fivetime")
//    @ResponseBody
    public String tenTime(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "5秒...";
    }
    /**
     * 异步调用
     * @return
     */
    private String resultbody="good man";
    @RequestMapping("/async")
//    @ResponseBody
    public String async() throws Exception{
        AsyncRestTemplate template = new AsyncRestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json;charset=UTF-8");
//        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("liveId","200645900168");
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(jsonObject.toString(), headers);
//        String url = "http://localhost/fivetime";//休眠5秒的服务
        String url = "http://101.132.123.234/api/live/start";
        //调用完后立即返回（没有阻塞）
//        ListenableFuture<ResponseEntity<String>> forEntity = template.getForEntity(url, String.class);
        ListenableFuture<ResponseEntity<String>> forEntity = template.postForEntity(url,httpEntity,String.class);
        //异步调用后的回调函数
        forEntity.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            //调用失败
            @Override
            public void onFailure(Throwable ex) {
                logger.error("=====rest response faliure======");
            }
            //调用成功
            @Override
            public void onSuccess(ResponseEntity<String> result) {
                logger.info("--->async rest response success----, result = "+result.getBody());
//                resultbody=result.getBody();
            }
        });
        return resultbody;
    }

//    @RequestMapping("/async")
//    public String asyncReq(){
//        String url = "http://localhost:8080/jsonAsync";
//        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
//        ListenableFuture<ResponseEntity<JSONObject>> future = asyncRestTemplate.getForEntity(url, JSONObject.class);
//        future.addCallback(new SuccessCallback<ResponseEntity<JSONObject>>() {
//            public void onSuccess(ResponseEntity<JSONObject> result) {
//                System.out.println(result.getBody().toString());
//            }
//        }, new FailureCallback() {
//            public void onFailure(Throwable ex) {
//                System.out.println("onFailure:"+ex);
//            }
//        });
//        return "this is async sample";
//    }
//    @Resource
//    private RestTemplate restTemplate;
//    @RequestMapping("/testresttemp")
//    public Object testPost() throws Exception{
//        String url = "http://localhost/fivetime";
//        JSONObject postData = new JSONObject();
////        postData.put("descp", "request for post");
//        postData.put("","");
//        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
//        logger.info("----------------------------------="+json.toString());
//        return json.toString();
//    }

//    @RequestMapping("/header")
//    public Object postWithHeader() throws Exception{
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("auth_token", "asdfgh");
//        headers.set("Other-Header", "othervalue");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        JSONObject parm = new JSONObject();
//        parm.put("parm", "1234");
//        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(parm, headers);
//        HttpEntity<String> response = restTemplate.exchange(
//                "http://localhost/fivetime", HttpMethod.POST, entity, String.class);//这里放JSONObject, String 都可以。因为JSONObject返回的时候其实也就是string
//        return response.getBody();
//    }
    @PostMapping("/start")
    public String startMtd(String liveId,String topicId) throws Exception{
        String result;
        JSONObject jsonObject=new JSONObject();
        if (liveId != null){
            jsonObject.put("liveId",liveId);
        }else if(topicId != null){
            jsonObject.put("topicId",topicId);
        }else {
            return "请输入直播ID或者主题ID";
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://101.132.123.234/api/live/start";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObject.toString(), headers);

        result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }
}
