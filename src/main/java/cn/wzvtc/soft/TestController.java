package cn.wzvtc.soft;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController()
public class TestController {


    @RequestMapping(value = "/userinfo")
    public Map<String, String> userinfo(HttpServletRequest httpServletRequest) {

        Map<String, String> resultMap = new HashMap<>();
        //判断是否已经登陆,判断SESSION里面是否有我的用户名信息
        if (httpServletRequest.getSession(true).getAttribute("loginnumber") != null) {
            resultMap.put("myname", (String) httpServletRequest.getSession(true).getAttribute("loginnumber"));
            resultMap.put("mynumber", (String) httpServletRequest.getSession(true).getAttribute("username"));
        }
        return resultMap;
    }

    @RequestMapping(value = "/login")
    public Map<String, String> login(@RequestBody Map<String, String> map, HttpServletRequest httpServletRequest) {
        String password = map.get("password");
        String number = map.get("number");
        Map<String, String> resultMap = new HashMap<>();
        if ("2012020045".equals(number) && "2012020045".equals(password)) {
            //将用户名存入到session中
            httpServletRequest.getSession(true).setAttribute("loginnumber", number);
            httpServletRequest.getSession(true).setAttribute("username", number);
            resultMap.put("result", "success");
        }
        return resultMap;
    }


}