package kr.co.pofo.pofoapiboot3.controller.member;

import kr.co.pofo.pofoapiboot3.entity.ReportDto;
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
    public void post(ReportDto reportDto) {
        service.post(reportDto);
    }

    @DeleteMapping
    public void delete(ReportDto reportDto) {
        service.delete(reportDto);
    }
}
