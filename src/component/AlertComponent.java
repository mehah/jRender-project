package component;

import com.jQuery.JQuery;
import com.jrender.jscript.dom.Window;

public final class AlertComponent {
	private final Window window;

	public AlertComponent(Window window) {
		this.window = window;
	}

	private JQuery alertSuccess, alertInfo, alertWarning, alertDanger;

	public void success(String msg) {
		if (this.alertSuccess == null) {
			this.alertSuccess = new JQuery(".alert-success", window);
		}

		alert(this.alertSuccess, msg);
	}

	public void info(String msg) {
		if (this.alertInfo == null) {
			this.alertInfo = new JQuery(".alert-info", window);
		}

		alert(this.alertInfo, msg);
	}

	public void warning(String msg) {
		if (this.alertWarning == null) {
			this.alertWarning = new JQuery(".alert-warning", window);
		}

		alert(this.alertWarning, msg);
	}

	public void danger(String msg) {
		if (this.alertDanger == null) {
			this.alertDanger = new JQuery(".alert-danger", window);
		}

		alert(this.alertDanger, msg);
	}

	private void alert(JQuery alert, String msg) {
		alert.text(msg).addClass("show");
		window.setTimeout(context -> alert.removeClass("show"), 2300);
	}
	
	public 
}
