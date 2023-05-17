package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.entity.PortfolioLike;
import kr.co.pofo.pofoapiboot3.service.PortfolioLikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pofo/{portfolioId}/likes")
public class PortfolioLikeController {
    private final PortfolioLikeService service;

    public PortfolioLikeController(PortfolioLikeService service) {
        this.service = service;
    }

    @GetMapping
    public List<PortfolioLike> getPortfolioLikesByPortfolioId(@PathVariable("portfolioId") Integer portfolioId) {
        List<PortfolioLike> portfolioLikes = service.getByPortfolioId(portfolioId);
        return portfolioLikes;
    }

    @GetMapping("count")
    public Integer getCountByPortfolioId(@PathVariable("portfolioId") int portfolioId) {
        Integer count = service.countByPortfolioId(portfolioId);
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
