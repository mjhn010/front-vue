package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Report;

public interface ReportService {
    void post(Report reportDto);
    void delete(Report reportDto);
}
