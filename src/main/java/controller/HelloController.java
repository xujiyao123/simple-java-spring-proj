package controller;

import entity.UserParam;
import entity.UserResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujiyao on 2017/4/26.
 * springdemo
 * controller
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    @ResponseBody
    public Object hello() {



        ArrayList<String> arrayList = new ArrayList<String>();


        return new UserParam("xujiyao" , "22" , "M");
    }

    @ResponseBody
    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public Object test2(@RequestBody UserParam user) {

        System.out.println(user);


        List<UserParam> list = new ArrayList<UserParam>();
        for (int i = 0; i <10 ; i++) {
            list.add(user);
        }
        return new UserResult("200" , list);

    }


}
