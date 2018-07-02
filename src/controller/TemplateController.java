package controller;

import com.jQuery.JQuery;
import com.jrender.jscript.dom.Window;
import com.jrender.kernel.JRenderContext;

public abstract class TemplateController extends Window {
	private final JQuery modal = new JQuery("#modal", this);
	
	private final JQuery modalTitle = modal.find(".modal-title");
	private final JQuery modalContent = modal.find(".modal-body");
	
	private final JQuery alertSuccess = new JQuery(".alert-success");
	private final JQuery alertInfo = new JQuery(".alert-info");
	private final JQuery alertWarning = new JQuery(".alert-warning");
	private final JQuery alertDanger = new JQuery(".alert-danger");
	
	
	public void showModal(String title, String message) {
		modalTitle.text(title);
		modalContent.text(message);
		modal.executePlugin("modal");		
	}
	
	public void alertSuccess(String msg) {
		alert(alertSuccess, msg);
	}
	
	public void alertInfo(String msg) {
		alert(alertInfo, msg);
	}
	
	public void alertWarning(String msg) {
		alert(alertWarning, msg);
	}
	
	public void alertDanger(String msg) {
		alert(alertDanger, msg);
	}
	
	private void alert(JQuery alert, String msg) {
		alert.text(msg).addClass("show");
		
		setTimeout((JRenderContext context) -> {
			alert.removeClass("show");
		}, 3000);
	}
	
}
