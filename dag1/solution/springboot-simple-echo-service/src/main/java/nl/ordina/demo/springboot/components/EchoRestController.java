package nl.ordina.demo.springboot.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoRestController {

    private String mykey;
    private MyProperties myProperties;

    public EchoRestController(@Value("${app.mykey}") String mykey, MyProperties myProperties) {
        this.mykey = mykey;
        this.myProperties = myProperties;
    }

    @RequestMapping("echo")
    public String echo(String name) {
        return mykey + ", sworld!";
    }


}
