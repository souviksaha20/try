package demo.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import demo.services.EventService;

@Controller
@RequestMapping("api/event")
public class EventRestController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET)
	@ResponseBody
	public String findall() {
		Gson gson = new Gson();
		return gson.toJson(eventService.findAll());
	}
	
}
