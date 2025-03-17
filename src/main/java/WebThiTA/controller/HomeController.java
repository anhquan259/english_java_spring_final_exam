package WebThiTA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    private String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbyBBEtGbgVUDJ7K77Kd-_mTbkzX7PcI0PyoLOSqQZf573DoFP_5EY3q56_w7hKHPWUy/exec"
                + "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    @RequestMapping("/tratu")
    public String tratu(Model model) {
        model.addAttribute("tutra", "");
        model.addAttribute("tudich", "");
        return "TraTu";
    }

    @RequestMapping("/tudich")
    public String dichtu(Model model, @ModelAttribute("tutra") String tutra) throws GeneralSecurityException, IOException {

//        ChromeDriverManager.getInstance(DriverManagerType.CHROME).version("76.0.3809.126").setup();
//        Configuration.startMaximized = true;
//        open("https://translate.google.com/?hl=ru#view=home&op=translate&sl=en&tl=ru");
//        String[] strings = {"hello","hi"};
//        for (String data: strings) {
//            $x("//textarea[@id='source']").clear();
//            $x("//textarea[@id='source']").sendKeys(data);
//            String translation = $x("//span[@class='tlid-translation translation']").getText();
//        }

        String tudich = "Can't translate";

        try {
            String text = "Hello world!";
            //Translated text: Hallo Welt!
            System.out.println("Translated text: " + translate("en", "de", text));
            tudich = translate("en", "de", tutra);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("tutra", tutra);
        model.addAttribute("tudich", tudich);
        return "TraTu";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        // TODO Auto-generated method stub
        return "Test";
    }

}
