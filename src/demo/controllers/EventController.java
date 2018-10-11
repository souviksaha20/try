package demo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import demo.entities.Event;
import demo.services.EventService;

@Controller

public class EventController  {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "event/index";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.put("events", eventService.findAllEvents());
		return "event/list";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		eventService.delete(eventService.find(id));
		return "redirect:../list.html";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("event", eventService.find(id));
		return "event/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("event") Event event, 
		HttpServletRequest request,
		ModelMap modelMap) {
		try {
			
			Event currentEvent = eventService.find(event.getId());
			currentEvent.setDescription(event.getDescription());
			currentEvent.setStartDate(new SimpleDateFormat("yyy/MM/dd").parse(request.getParameter("startDate")));
			currentEvent.setEndDate(new SimpleDateFormat("yyy/MM/dd").parse(request.getParameter("endDate")));
			currentEvent.setName(event.getName());
			currentEvent.setTime(event.getTime());
			System.out.println(currentEvent.getTime());
			eventService.update(currentEvent);
			return "redirect:../event.html";
		} catch (Exception e) {
			modelMap.put("event", event);
			return "event/index";
		}
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("event", new Event());
		return "event/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(
		@ModelAttribute("event") Event event, 
		HttpServletRequest request,
		ModelMap modelMap) {
		try {
		      
			event.setStartDate(new SimpleDateFormat("yyy/MM/dd").parse(request.getParameter("startDate")));
			event.setEndDate(new SimpleDateFormat("yyy/MM/dd").parse(request.getParameter("endDate")));
			System.out.println(event.getRemindme());
			System.out.println(event.getTime());
			
			eventService.create(event);
			return "redirect:../event.html";
		} catch (Exception e) {
			modelMap.put("event", event);
			return "event/index";
		}
	}
	
}
