package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.Report;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportRepository {
    void insert(Report report);

    void delete(Report report);
}
