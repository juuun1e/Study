package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired //연관된 객체를 스프링컨테이너에서 찾아 넣어준다. => 의존성 주입 DI
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

}
