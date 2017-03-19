package nl.ordina.demo.springboot.components;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreemarkerController {

        @Value("${app.mykey}")
        private String greeting;

        @GetMapping("/freemarker")
        public ModelAndView welcome(Map<String, Object> model) {
            ModelAndView modelAndView = new ModelAndView("welcome");
            modelAndView.addObject("greeting",greeting);
            return modelAndView;
        }
}
