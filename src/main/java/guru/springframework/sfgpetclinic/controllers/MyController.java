package guru.springframework.sfgpetclinic.controllers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@ComponentScan
@Controller
public class MyController {


    public String sayHello(){
        System.out.println("SAY Hello World");
        return "Hi Guys!";
    }
}

