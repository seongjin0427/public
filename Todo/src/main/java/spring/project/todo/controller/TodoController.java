package spring.project.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.project.todo.dto.Todo;
import spring.project.todo.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	//등록
	@RequestMapping(value = "created")
	public String write(HttpServletRequest req, Todo todo) {
		todo.setModel("add");
		req.setAttribute("todo", todo);
		return "insert";
	}
	@RequestMapping(value = "created_ok", method = {RequestMethod.GET,RequestMethod.POST})
	public String write_ok(HttpServletRequest req, Todo todo) throws Exception{
		todoService.add(todo);
		return "redirect:/list";
	}
	//수정	
	@RequestMapping(value = "updated")
	public String update(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Todo todo = todoService.selectDetail(id);
		todo.setModel("update");
		req.setAttribute("todo", todo);
		return "insert";
	}
	@RequestMapping(value = "updated_ok", method = {RequestMethod.GET,RequestMethod.POST})
	public String update_ok(HttpServletRequest req, Todo todo) throws Exception{
		todoService.update(todo);
		return "redirect:/list";
	}
	//삭제
	@RequestMapping(value = "deleted")
	public String delete(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		todoService.delete(id);
		return "redirect:/list";
	}
	//리스트
	@RequestMapping(value = "list", method = {RequestMethod.GET,RequestMethod.POST})
	public String listData(HttpServletRequest req) {
		List<Todo> lists = todoService.listData();
		req.setAttribute("lists", lists);
		req.setAttribute("cp", req.getContextPath());
		return "list";
	}
	
}
