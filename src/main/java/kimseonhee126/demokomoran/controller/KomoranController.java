package kimseonhee126.demokomoran.controller;

import kimseonhee126.demokomoran.service.KomoranService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KomoranController {

    private final KomoranService komoranService;

    public KomoranController(KomoranService komoranService) {
        this.komoranService = komoranService;
    }

    @GetMapping("/analyze")
    public List<List<String>> analyzeText() {
        List<String> textList = List.of(
                "안녕하세요",
                "텍스트 분석을 테스트합니다",
                "오늘 날씨가 좋네요",
                "스프링 부트를 사용한 웹 개발",
                "Komoran은 한국어 형태소 분석기입니다"
        );

        return textList.stream()
                .map(text -> komoranService.analyze(text).stream()
                        .map(token -> token.getMorph() + "/" + token.getPos())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
