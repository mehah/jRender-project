package controller;

import com.jrender.jscript.dom.Window;

import component.AlertComponent;

public abstract class TemplateController extends Window {
	public final AlertComponent alert = new AlertComponent(this);
}