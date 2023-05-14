package Order.miniproject.webcontroller;

import Order.miniproject.webcontroller.dto.SessionMember;
import Order.miniproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

  private final MemberRepository memberRepository;
  @GetMapping("/")    // 로그인 안한 사용자는 home, 로그인 한 사용자는 loginHome 화면 보여지게 함.
  public String root( // @CookieValue(name="memberId2",required = false) Long memberId,
                     HttpServletRequest request,
                     Model model) {
    HttpSession session = request.getSession(false);
    if(session == null){
      return "home";
    }
    // 세션이 존재하면
    SessionMember findMember = (SessionMember)session.getAttribute("loginMember");
    if(findMember == null) {
      return "home";
    } else {
      model.addAttribute("name", findMember.getName());
      return "loginHome";
    }
  }

  @GetMapping("/home")
  public String home() {
    return "redirect:/";
  }
}
