package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.service.CommentService;
import kr.co.pofo.pofoapiboot3.service.PortfolioContentsService;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/pofo")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final PortfolioContentsService portfolioContentsService;

    public PortfolioController(PortfolioService portfolioService, PortfolioContentsService portfolioContentsService, CommentService commentService) {
        this.portfolioService = portfolioService;
        this.portfolioContentsService = portfolioContentsService;
    }

    @GetMapping("{portfolioId}")
    public Map<String, Object> getPortfolioDetail(@PathVariable("portfolioId") Integer portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        List<PortfolioContents> contents = portfolioContentsService.getPortfolioContents(portfolioId);

        Map<String, Object> objectMap = new LinkedHashMap<>();

        objectMap.put("portfolio", portfolio);
        objectMap.put("contents", contents);

        return objectMap;
    }
}
