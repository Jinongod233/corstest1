package cn.wzvtc.soft;

import org.omg.CORBA.ORB;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@CrossOrigin
@RestController("/" )
public class TestController {


    @RequestMapping(value="/data.json")
    public Map<String,String> bookById(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","刘笑锋1");
        resultMap.put("mynumber","2012020045");
        return resultMap;
    }
}