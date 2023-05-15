package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.entity.PortfolioLike;
import kr.co.pofo.pofoapiboot3.service.PortfolioLikeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pofo/{portfolioId}/likes")
public class PortfolioLikeController {
    private final PortfolioLikeService service;

    public PortfolioLikeController(PortfolioLikeService service) {
        this.service = service;
    }

    @GetMapping
    public Integer getCount(@PathVariable("portfolioId") int memberId) {
        Integer count = service.count(memberId);
        return count;
    }

    @PostMapping
    public void insert(PortfolioLike portfolioLike) {
        service.insert(portfolioLike);
    }

    @DeleteMapping
    public void delete(PortfolioLike portfolioLike) {
        service.delete(portfolioLike);
    }
}
