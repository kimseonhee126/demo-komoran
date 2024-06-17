package kimseonhee126.demokomoran.service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomoranService {

    private final Komoran komoran;

    public KomoranService() {
        // Komoran 초기화 (LIGHT 모델 사용)
        this.komoran = new Komoran(DEFAULT_MODEL.FULL);
    }

    public List<Token> analyze(String text) {
        return komoran.analyze(text).getTokenList();
    }
}
