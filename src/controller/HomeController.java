package controller;

import java.util.ArrayList;

import com.jQuery.JQuery;
import com.jrender.database.annotation.Connection;
import com.jrender.jscript.dom.window.annotation.Page;
import com.jrender.kernel.JRenderContext;

import modal.User;
import service.UserService;

@Page(name = "home", path = "home.html", ajaxSelector = ".panel-body", rules = "RULE_ADMIN")
public class HomeController extends TemplateController {
	private JQuery tableBody = new JQuery(".table > tbody");

	@Connection
	public void init(JRenderContext context) {
		UserService.getAllUsers()
			.orElse(new ArrayList<User>())
			.stream()
			.forEach(this::addUser);
	}

	public void addUser(User user) {
		JQuery tr = new JQuery("<tr></tr>").appendTo(tableBody);

		tr.append("<td>" + user.getEmail() + "</td><td>" + user.getName() + "</td><td></td>");
	}

}
