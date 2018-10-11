package demo.dao;

import java.util.*;
import org.hibernate.*;
import org.hibernate.transform.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import demo.entities.*;

@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findAll() {
		List<EventEntity> list = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			list = session.createQuery("select e.id as id, "
					+ "e.name as title, "
					+ "DATE_FORMAT(e.startDate,'%Y-%m-%d') as start, "
					+ "DATE_FORMAT(e.endDate,'%Y-%m-%d') as end "
					+ "from Event e")
					.setResultTransformer(
						Transformers.aliasToBean(EventEntity.class))
					.list();
			transaction.commit();
		} catch (Exception e) {
			list = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void create(Event event) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(event);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvents() {
		List<Event> list = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			list = session.createCriteria(Event.class)
					.list();
			transaction.commit();
		} catch (Exception e) {
			list = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Event find(int id) {
		Event event = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			event = (Event) session.createQuery("from Event "
						+ "where id = :id")
					.setInteger("id", id)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			event = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return event;
	}

	@Override
	public void delete(Event event) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(event);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Event event) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(event);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

}
