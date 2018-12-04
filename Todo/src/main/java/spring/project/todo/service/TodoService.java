package spring.project.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.todo.dao.TodoDAO;
import spring.project.todo.dto.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoDAO todoDAO;
	
	public void add(Todo todo) {
		todoDAO.insert(todo);
	}
	public void update(Todo todo) {
		todoDAO.modify(todo);
	}
	public void delete(int id) {
		todoDAO.delete(id);
	}
	public List<Todo> listData() {
		List<Todo> lists = todoDAO.list();
		return lists;
	}
	public Todo selectDetail(int id) {
		Todo todo = todoDAO.selectedList(id);
		return todo;
	}
}
