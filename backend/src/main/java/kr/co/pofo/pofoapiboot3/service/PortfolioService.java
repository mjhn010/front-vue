package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;

public interface PortfolioService {
	//index 페이지에서 사용하는 getViewList;
	List<PortfolioView> getViewList();
	//list 페이지에서 사용하는 getViewList;
	List<PortfolioView> getViewList(String q, String o);
	List<PortfolioView> getViewList(Integer type, String o);
	
	void add(Portfolio pf);

	int getId();

	//  Detail
	Portfolio getPortfolioById(Integer id);
}
