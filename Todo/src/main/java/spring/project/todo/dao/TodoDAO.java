package spring.project.todo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.todo.dto.Todo;

@Repository
public class TodoDAO {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public void insert(Todo todo) {
		sessionTemplate.insert("TodoMapper.insert", todo);
	}
	public void modify(Todo todo) {
		sessionTemplate.update("TodoMapper.modify", todo);
	}
	public void delete(int id) {
		sessionTemplate.delete("TodoMapper.delete", id);
	}
	public List<Todo> list() {
		List<Todo> lists = sessionTemplate.selectList("TodoMapper.list");
		return lists;
	}
	public Todo selectedList(int id) {
		Todo todo = sessionTemplate.selectOne("TodoMapper.selectedList", id);
		return todo;
	}
}
