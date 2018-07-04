package controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.jrender.database.annotation.Connection;
import com.jrender.jscript.dom.FunctionHandle;
import com.jrender.jscript.dom.event.Events;
import com.jrender.jscript.dom.window.annotation.Page;
import com.jrender.jscript.dom.window.annotation.Validate;
import com.jrender.kernel.JRenderContext;

import form.LoginForm;
import modal.User;
import service.UserService;

@Page(name = "index", path = "index.html")
public final class IndexController extends TemplateController {
	private final LoginForm loginForm = document.forms(LoginForm.class);

	public void init(JRenderContext context) {
		loginForm.reset();

		document.getElementById("signin").addEventListener(Events.CLICK, new FunctionHandle("signin"));
	}

	@Connection
	@Validate
	public void signin(JRenderContext context) throws NoSuchAlgorithmException, SQLException {
		User user = UserService.getUserBy(loginForm.email.value(), loginForm.password.value());
		if (user == null) {
			alert.warning("Email or Password is incorrect.");
			return;
		}

		context.getRequest().setUserPrincipal(user);
		alert.success("Logged in with success.");
		setTimeout((arg) -> location.href("home.html"), 1000);
	}
}
