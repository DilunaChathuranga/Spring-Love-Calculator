package com.diluna.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String nameInUpper=text.toUpperCase();
		setValue(nameInUpper);
		
	}

	
	
}
