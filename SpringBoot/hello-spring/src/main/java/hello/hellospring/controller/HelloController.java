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
    model.addAttribute("data","hello!!");
    return "hello";
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model){
    model.addAttribute("name",name);
    return "hello-template";
  }

    @GetMapping("hello-string")
    @ResponseBody // http의 body부분에 이 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
      return "hello " + name; // view 없이 문자가 그대로 들어감
    }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }
  // static class : 인스턴스(객체)생성 없이 바로 사용 가능
  // -> HelloController class 에서 Hello static class를 그냥 사용할 수 있음
  // -> HelloController.Hello
  static class Hello {
    private String name;
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
