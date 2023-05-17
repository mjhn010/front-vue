package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.ReportDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportRepository {
    void insert(ReportDto reportDto);

    void delete(ReportDto reportDto);
}
