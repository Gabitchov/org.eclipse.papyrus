/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.xtext.widgets.creation;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.xtext.widgets.adapter.IXtextAdapter;
import org.eclipse.swt.widgets.Control;

//This factory should only be used for containment references, as there is no "CreateIn" parameter
public class XtextValueFactory implements ReferenceValueFactory {

	protected IXtextAdapter adapter;

	public XtextValueFactory() {
	}

	public void setAdapter(IXtextAdapter adapter) {
		this.adapter = adapter;
	}

	public IXtextAdapter getAdapter() {
		return adapter;
	}

	public XtextValueFactory(IXtextAdapter adapter) {
		this.adapter = adapter;
	}

	public Object createObject(Control widget) {
		XtextEditorDialog dialog = new XtextEditorDialog(widget.getShell(), adapter, null);
		int result = dialog.open();
		if(result == Window.OK) {
			return dialog.getValue();
		}
		return null;
	}

	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate; //add the objects to the right resource
	}

	public boolean canEdit() {
		return true; //Unsupported yet (We need a Write Transaction)
	}

	public Object edit(Control widget, Object object) {
		if(object instanceof EObject) {
			XtextEditorDialog dialog = new XtextEditorDialog(widget.getShell(), adapter, (EObject)object);
			dialog.open();
		} else {
			Activator.log.warn("The XtextValueFactory can only edit EObjects"); //$NON-NLS-1$
		}
		return object;
	}

	public boolean canCreateObject() {
		return true;
	}

}
