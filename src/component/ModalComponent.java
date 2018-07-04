package component;

import com.jQuery.JQuery;
import com.jrender.jscript.dom.Window;

public final class ModalComponent {
	private final JQuery modal, modalTitle, modalContent;

	public ModalComponent(Window window) {
		this.modal = new JQuery("#modal", window);
		modalTitle = modal.find(".modal-title");
		modalContent = modal.find(".modal-body");
	}

	public void show(String title, String message) {
		modalTitle.text(title);
		modalContent.text(message);
		modal.executePlugin("modal");
	}
}
