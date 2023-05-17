package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.BookmarkDto;
import kr.co.pofo.pofoapiboot3.entity.PortfolioBookmark;
import kr.co.pofo.pofoapiboot3.repository.PortfolioBookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPortfolioBookmarkService implements PortfolioBookmarkService {
    private final PortfolioBookmarkRepository repository;

    public DefaultPortfolioBookmarkService(PortfolioBookmarkRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PortfolioBookmark> getListByPortfolioId(Integer portfolioId) {
        return repository.selectByPortfolioId(portfolioId);
    }

    @Override
    public void post(BookmarkDto bookmarkDto) {
        repository.insert(bookmarkDto);
    }

    @Override
    public void delete(BookmarkDto bookmarkDto) {
        repository.delete(bookmarkDto);
    }
}
