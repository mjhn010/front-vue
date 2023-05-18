package kr.co.pofo.pofoapiboot3.controller.member;

import kr.co.pofo.pofoapiboot3.entity.BookmarkDto;
import kr.co.pofo.pofoapiboot3.entity.PortfolioBookmark;
import kr.co.pofo.pofoapiboot3.service.PortfolioBookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pofo/{portfolioId}/bookmark")
public class PortfolioBookmarkController {
    private final PortfolioBookmarkService service;

    public PortfolioBookmarkController(PortfolioBookmarkService service) {
        this.service = service;
    }

    @GetMapping
    public List<PortfolioBookmark> getList(@PathVariable Integer portfolioId) {
        return service.getListByPortfolioId(portfolioId);
    }

    @PostMapping
    public void post(@RequestBody BookmarkDto bookmarkDto) {
        service.post(bookmarkDto);
    }

    @DeleteMapping
    public void delete(@RequestBody BookmarkDto bookmarkDto) {
        service.delete(bookmarkDto);
    }
}
