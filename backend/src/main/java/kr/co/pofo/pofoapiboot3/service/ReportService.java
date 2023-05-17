package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.ReportDto;

public interface ReportService {
    void post(ReportDto reportDto);
    void delete(ReportDto reportDto);
}
