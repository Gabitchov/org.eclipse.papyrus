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
package org.eclipse.papyrus.views.properties.creation;

import java.util.Collection;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.messages.Messages;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.ViewConstraintEngine;
import org.eclipse.swt.widgets.Control;

/**
 * A generic ReferenceValueFactory, which uses the Property View configurations
 * to edit objects. For a given object, the factory uses the matching constraints
 * to find the property views associated to the object, and displays these views
 * in a Dialog.
 * This factory cannot instantiate new objects. However, subclasses should override {@link #createObject(Control)} and {@link #canCreateObject()} to
 * enable
 * this behavior.
 * 
 * @see org.eclipse.papyrus.views.properties.creation.EditionDialog
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
	 * Return a null value. Implementors should override when object creation
	 * needs to be supported. Implementors may rely on {@link #createObject(Control, Object)}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory#createObject(org.eclipse.swt.widgets.Control)
	 * @see #createObject(org.eclipse.swt.widgets.Control, Object)
	 * 
	 * @param widget
	 *        The widget from which this method is called. May be used to retrieve the current shell
	 * @return
	 *         The newly created object
	 */
	public Object createObject(Control widget) {
		return null;
	}

	/**
	 * This class cannot instantiate objects. However, this method provides
	 * a base implementation to be used by subclasses.
	 * 
	 * Subclasses should instantiate the base object, which will then be
	 * editable via a property dialog.
	 * 
	 * @param widget
	 *        The widget used to open the dialog
	 * @param source
	 *        The created EObject. If null, nothing will happen
	 * @return
	 *         The source EObject, which potential in-place modifications
	 */
	protected Object createObject(Control widget, Object source) {
		if(source == null) {
			return null;
		}

		IStructuredSelection selection = new StructuredSelection(source);

		ViewConstraintEngine constraintEngine = ConfigurationManager.getInstance().getConstraintEngine();
		Set<View> views = constraintEngine.getViews(selection);
		if(!views.isEmpty()) {
			EditionDialog dialog = new EditionDialog(widget.getShell(), true);
			dialog.setViews(views);
			dialog.setInput(source);
			dialog.setTitle(getCreationDialogTitle());

			int result = dialog.open();
			if(result != Window.OK) {
				return null;
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
	 * @see org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory#edit(org.eclipse.swt.widgets.Control, java.lang.Object)
	 * 
	 * @param widget
	 *        The widget calling the factory. The Dialog for editing the object will open in this widget's shell
	 * @param source
	 *        The object to edit
	 */
	public Object edit(Control widget, Object source) {
		IStructuredSelection selection = new StructuredSelection(source);

		ViewConstraintEngine constraintEngine = ConfigurationManager.getInstance().getConstraintEngine();

		Set<View> views = constraintEngine.getViews(selection);
		if(!views.isEmpty()) {
			EditionDialog dialog = new EditionDialog(widget.getShell());
			dialog.setTitle(getEditionDialogTitle(source));
			dialog.setViews(views);
			dialog.setInput(source);

			dialog.open();
		}

		return source;
	}

	/**
	 * The standard Property Editor Factory cannot instantiate new objects.
	 * However, subclasses may override this method to return true if they
	 * implement {@link #createObject(Control)}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory#canCreateObject()
	 * 
	 * @return
	 *         True if the factory can create a new instance
	 */
	public boolean canCreateObject() {
		return false;
	}

	/**
	 * @return
	 *         The title of the dialog used to edit the newly created instance
	 * 
	 * @see #canCreateObject()
	 * @see #createObject(Control)
	 */
	public String getCreationDialogTitle() {
		return Messages.PropertyEditorFactory_CreateANewElement;
	}

	public String getEditionDialogTitle(Object objectToEdit) {
		return "Edit an element";
	}
}
