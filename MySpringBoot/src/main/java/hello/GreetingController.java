package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private AtomicLong counter  = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/me")
    public Greeting greetMe(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/increment")
    public ResponseEntity<Greeting> incrementMe(@RequestBody Greeting greeting){
        this.counter = new AtomicLong(greeting.getId());
        return new ResponseEntity<Greeting>(new Greeting(counter.longValue(), greeting.getContent()), HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/remove")
    public ResponseEntity<String> removeMe(){
        this.counter = new AtomicLong();
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}