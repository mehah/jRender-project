package validation;

import java.util.regex.Pattern;

import com.jrender.jscript.dom.Element;
import com.jrender.jscript.dom.Form;
import com.jrender.jscript.dom.Window;
import com.jrender.jscript.dom.elements.custom.ContainerElement;
import com.jrender.validator.DataValidation;
import com.jrender.validator.Validator;

import controller.TemplateController;

public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public boolean validate(Window window, Form form, ContainerElement<?> container, final Element element, final String name, Object value, String[] labels, DataValidation dataValidation) {
		if (!pattern.matcher((String) value).matches()) {
			TemplateController controller = (TemplateController) window;
			controller.alert.danger("The mail format is incorrect in the '"+labels[0]+"' field.");
			element.focus();
			
			return false;
		}

		return true;
	}
}