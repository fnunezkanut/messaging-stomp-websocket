package ie.nuigalway.sd3;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting( HelloMessage message ) throws Exception{

		Thread.sleep(1000); //delay

		return new Greeting("Hello, " + message.getName() + "!");
	}
}
