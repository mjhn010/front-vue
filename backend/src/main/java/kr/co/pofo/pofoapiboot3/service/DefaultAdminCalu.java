package kr.co.pofo.pofoapiboot3.service;

import java.util.List;
import kr.co.pofo.pofoapiboot3.repository.AdminCalcuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAdminCalu implements AdminCalcuService {

  @Autowired
  private AdminCalcuRepository adminCalcuRepository;

  @Override
  public List<String> todayVisitCount() {
    List<String> result = adminCalcuRepository.todayVisitCount();
    return result;
  }

  @Override
  public List<String> memberDiff() {
    List<String> result = adminCalcuRepository.todayVisitCount();
    return result;
  }
}
