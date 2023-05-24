package kr.co.pofo.pofoapiboot3.admin;

import java.util.List;
import kr.co.pofo.pofoapiboot3.service.AdminCalcuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin1")
public class AdminController {

  @Autowired
  VisitService visitService;

  @Autowired
  AdminCalcuService adminCalcuService;

  @Autowired
  AdminSelector selectTests;

  @GetMapping("/index")
  public String admin(Model model) {
    List<String> resultVisit = selectTests.todayVisitCount();
    List<String> resultDiff = selectTests.getDiffPercentAndStatus();
    List<String> resultSignupStatus = selectTests.getSignupStats();

    System.out.println(resultVisit.get(0));
    System.out.println(resultVisit.get(1));
    model.addAttribute("growth_rate", resultVisit.get(0));
    model.addAttribute("change_status", resultVisit.get(1));
    System.out.println(resultDiff.get(0));
    System.out.println(resultDiff.get(1));
    model.addAttribute("diff_percent", resultDiff.get(0));
    model.addAttribute("diffStatus", resultDiff.get(1));
    System.out.println(resultSignupStatus.get(0));
    System.out.println(resultSignupStatus.get(1));
    model.addAttribute("signup_diffPercent", resultSignupStatus.get(0));
    model.addAttribute("signup_diffStatus", resultSignupStatus.get(1));
    return "admin.html";
  }

  @GetMapping("/login")
  public String admin2() {
    return "login.html";
  }
}
