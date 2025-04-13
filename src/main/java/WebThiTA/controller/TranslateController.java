package WebThiTA.controller;

import WebThiTA.constant.Translate;
import WebThiTA.dto.LanguageDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
@CrossOrigin(origins = "*")
public class TranslateController {
    @PostMapping("/")
    public static LanguageDto Translate(@RequestBody LanguageDto lang) {
        System.out.println("json: " + " " + lang.getText());
        String tranT = null;
        try {
            tranT = Translate.translate("en", "vi", lang.getText());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lang.setText(tranT);
        return lang;
    }

//    @PostMapping("/")
//    public static LanguageDto Translate(S) {
//        System.out.println("json: "+" "+ lang.getText());
//        String tranT=null;
//        try {
//            tranT = Translate.translate("en", "vi", lang.getText());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        lang.setText(tranT);
//        return lang;
//    }

}
