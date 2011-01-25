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
package org.eclipse.papyrus.properties.creation;

import java.util.Collection;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.runtime.ConstraintEngine;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.swt.widgets.Control;

/**
 * A generic ReferenceValueFactory, which uses the Property View configurations
 * to edit objects. For a given object, the factory uses the matching constraints
 * to find the property views associated to the object, and displays these views
 * in a Dialog.
 * This factory cannot instantiate new objects. However, subclasses should override {@link #createObject()} and {@link #canCreateObject()} to enable
 * this behavior.
 * 
 * @see org.eclipse.papyrus.properties.creation.EditionDialog
 * 
 * @author Camille Letavernier
 */
public class PropertyEditorFactory implements ReferenceValueFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PropertyEditorFactory() {
	}

	/**
	 * {@inheritDoc}
	 */
	public Object createObject(Control widget) {
		Object source = createObject();
		if(source == null)
			return null;

		IStructuredSelection selection = new StructuredSelection(source);

		ConstraintEngine constraintEngine = ConfigurationManager.instance.constraintEngine;
		constraintEngine.setSelection(selection);
		if(constraintEngine.match()) {
			Set<View> views = constraintEngine.getViews();
			if(!views.isEmpty()) {
				EditionDialog dialog = new EditionDialog(widget.getShell());
				dialog.setViews(views);
				dialog.setInput(source);

				int result = dialog.open();
				if(result != Window.OK) {
					return null;
				}
			}
		}

		return source;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canEdit() {
		return true;
	}

	/**
	 * Edits the given object via the matching Property view, if any
	 * The editing Dialog is directly binded to the underlying object, which means that all modifications are applied
	 * in real time, and cannot be undone (Except via the "Undo" command). The "Cancel" button is thus disabled.
	 * 
	 * @see org.eclipse.papyrus.widgets.creation.ReferenceValueFactory#edit(org.eclipse.swt.widgets.Control, java.lang.Object)
	 * 
	 * @param widget
	 *        The widget calling the factory. The Dialog for editing the object will open in this widget's shell
	 * @param source
	 *        The object to edit
	 */
	public void edit(Control widget, Object source) {
		IStructuredSelection selection = new StructuredSelection(source);

		ConstraintEngine constraintEngine = ConfigurationManager.instance.constraintEngine;
		constraintEngine.setSelection(selection);
		if(constraintEngine.match()) {
			Set<View> views = constraintEngine.getViews();
			if(!views.isEmpty()) {
				EditionDialog dialog = new EditionDialog(widget.getShell());
				dialog.setViews(views);
				dialog.setInput(source);

				dialog.open();
			}
		}
	}

	/**
	 * Creates a new empty instance. The instance will then be edited through
	 * the matching property view, if any.
	 * Subclasses should override this method if canCreateObject returns true
	 * 
	 * @return
	 *         The newly created object
	 */
	protected Object createObject() {
		return null;
	}

	/**
	 * The standard Property Editor Factory cannot instantiate new objects.
	 * However, subclasses may override this method to return true if they
	 * implement {@link #createObject()}
	 * 
	 * @see org.eclipse.papyrus.widgets.creation.ReferenceValueFactory#canCreateObject()
	 * 
	 * @return
	 *         True if the factory can create a new instance
	 */
	public boolean canCreateObject() {
		return false;
	}
}
