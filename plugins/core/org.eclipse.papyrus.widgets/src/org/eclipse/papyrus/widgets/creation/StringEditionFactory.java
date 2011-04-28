/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.creation;

import java.util.Collection;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.widgets.editors.InputDialog;
import org.eclipse.papyrus.widgets.messages.Messages;
import org.eclipse.swt.widgets.Control;


public class StringEditionFactory implements ReferenceValueFactory {

	private String title = Messages.StringEditionFactory_EnterANewValue;

	private String label = Messages.StringEditionFactory_EnterANewValue;

	private IInputValidator validator;

	public StringEditionFactory() {
	}

	public StringEditionFactory(String title, String label) {
		this.title = title;
		this.label = label;
	}

	public StringEditionFactory(IInputValidator validator) {
		this.validator = validator;
	}

	public StringEditionFactory(String title, String label, IInputValidator validator) {
		this.title = title;
		this.label = label;
		this.validator = validator;
	}

	public boolean canCreateObject() {
		return false;
	}

	public Object createObject(Control widget) {
		return null;
	}

	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate;
	}

	public boolean canEdit() {
		return true;
	}

	public Object edit(Control widget, Object object) {
		if(!(object instanceof String)) {
			return object;
		}

		InputDialog dialog = new InputDialog(widget.getShell(), title, label, (String)object, validator);

		int result = dialog.open();
		if(result == Window.OK) {
			String newValue = dialog.getText();
			return newValue;
		}

		return object;
	}

	public void setValidator(IInputValidator validator) {
		this.validator = validator;
	}
}
