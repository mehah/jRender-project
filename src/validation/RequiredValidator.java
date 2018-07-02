package validation;

import com.jrender.jscript.dom.Element;
import com.jrender.jscript.dom.Form;
import com.jrender.jscript.dom.Window;
import com.jrender.jscript.dom.elements.custom.ContainerElement;
import com.jrender.validator.DataValidation;
import com.jrender.validator.Validator;

import controller.TemplateController;

public class RequiredValidator implements Validator {

	public boolean validate(final Window window, Form form, ContainerElement<?> container, final Element element, final String name, Object value, String[] labels, DataValidation dataValidation) {
		if (value == null || value instanceof String && ((String) value).isEmpty()) {
			TemplateController controller = (TemplateController) window;
			controller.alertDanger("Field '"+labels[0]+"' is required.");
			element.focus();
			
			return false;
		}

		return true;
	}
}