package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
    System.out.println("memberService =" + memberService.getClass());
  }

  @GetMapping(value = "/members/new")
  public String createForm() {
    return "members/createMemberForm";
  }

  @PostMapping(value = "/members/new")
  public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName());

    memberService.join(member);

    return "redirect:/";
  }

  @GetMapping(value = "/members")
  public String list(Model model) {
    List<Member> members = memberService.findMembers(); // 모든 회원 목록 조회
    model.addAttribute("members", members); // 회원 리스트 자체를 모델에 담아 화면에 넘김
    return "members/memberList";
  }
}
