package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.ReportDto;
import kr.co.pofo.pofoapiboot3.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultReportService implements ReportService{
    private final ReportRepository repository;

    public DefaultReportService(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void post(ReportDto reportDto) {
        repository.insert(reportDto);
    }

    @Override
    public void delete(ReportDto reportDto) {
        repository.delete(reportDto);
    }
}
