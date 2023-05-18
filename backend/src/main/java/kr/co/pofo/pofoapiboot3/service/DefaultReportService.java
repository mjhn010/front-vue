package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Report;
import kr.co.pofo.pofoapiboot3.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultReportService implements ReportService{
    private final ReportRepository repository;

    public DefaultReportService(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void post(Report report) {
        repository.insert(report);
    }

    @Override
    public void delete(Report report) {
        repository.delete(report);
    }
}
