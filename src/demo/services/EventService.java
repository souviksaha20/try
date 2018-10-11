package demo.services;

import java.util.List;

import demo.entities.Event;
import demo.entities.EventEntity;

public interface EventService {

	public List<EventEntity> findAll();
	
	public List<Event> findAllEvents();
	
	public void create(Event event);
	
	public Event find(int id);
	
	public void delete(Event event);
	
	public void update(Event event);
	
}
