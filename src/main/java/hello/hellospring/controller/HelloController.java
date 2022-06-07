package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", " hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
     public String helloMvc(@RequestParam(value="name") String name, Model model){ //모델에 담으면 모델에 넘어가는
        model.addAttribute("name",  name);
        return  "hello-template";

    }
    @GetMapping("hello-string")
    @ResponseBody  //Body 부에 직접 응답해서 넣어주겠다는 말
     public String helloString(@RequestParam("name" ) String name){
        return "hello " + name;  //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();  //문자가 아니라 객체를
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private  String name;  //외부에서 바로 못 꾸내기 떄문에 get set 으로 사용 public

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    }
