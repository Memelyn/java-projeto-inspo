package br.com.erudio.java_springboot_erudio.Controller;

import br.com.erudio.java_springboot_erudio.Model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting") //para ser reconhecido como um método exposto via http
    public Greeting greeting(
            @RequestParam (value = "name", defaultValue = "Word")// para ler o parametro
            String name){
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
        // incrementAndGet - a cada requisição incrementa e retorna um valor maior
    }
}
