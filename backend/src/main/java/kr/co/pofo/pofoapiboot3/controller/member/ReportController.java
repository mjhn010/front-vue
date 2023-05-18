package kr.co.pofo.pofoapiboot3.controller.member;

import kr.co.pofo.pofoapiboot3.entity.Report;
import kr.co.pofo.pofoapiboot3.service.ReportService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @PostMapping
    public void post(@RequestBody Report report) {
        service.post(report);
    }

    @DeleteMapping
    public void delete(@RequestBody Report report) {
        service.delete(report);
    }
}
