package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pofo")
public class PortfolioController {
    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @GetMapping("{portfolioId}")
    public Portfolio getPortfolio(@PathVariable("portfolioId") Integer portfolioId) {
        Portfolio portfolio = service.getPortfolioById(portfolioId);
        return portfolio;
    }
}
