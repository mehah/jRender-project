package form;

import com.jrender.jscript.dom.Form;
import com.jrender.jscript.dom.elements.InputPasswordElement;
import com.jrender.jscript.dom.elements.InputTextElement;
import com.jrender.jscript.dom.form.annotation.ElementValue;
import com.jrender.jscript.dom.form.annotation.Name;
import com.jrender.jscript.dom.form.annotation.Validator;

import validation.EmailValidator;
import validation.RequiredValidator;

@Name("loginForm")
public final class LoginForm extends Form {

	@ElementValue(validators= {@Validator(value=RequiredValidator.class, labels="Email address"), @Validator(value=EmailValidator.class, labels="Email address")})
	public final InputTextElement<String> email = null;

	@ElementValue(validators= @Validator(value=RequiredValidator.class, labels="Password"))
	public final InputPasswordElement password = null;
}
