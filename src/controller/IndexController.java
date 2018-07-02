package controller;

import com.jrender.jscript.dom.FunctionHandle;
import com.jrender.jscript.dom.event.Events;
import com.jrender.jscript.dom.window.annotation.Page;
import com.jrender.jscript.dom.window.annotation.Validate;
import com.jrender.kernel.JRenderContext;

import form.LoginForm;

@Page(name="index", path="index.html")
public final class IndexController extends TemplateController {
	private final LoginForm loginForm = document.forms(LoginForm.class);
	
	public void init(JRenderContext arg0) {
		document.getElementById("signin").addEventListener(Events.CLICK, new FunctionHandle("signin"));
		
		loginForm.reset();
	}
	
	@Validate
	public void signin() {
	}
}
