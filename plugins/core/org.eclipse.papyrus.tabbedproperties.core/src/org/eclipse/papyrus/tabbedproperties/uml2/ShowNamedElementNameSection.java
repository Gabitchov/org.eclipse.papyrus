/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml2;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.tabbedproperties.core.forms.InputTextControls;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.NamedElement;

/**
 * The Label section on the Button tab.
 * 
 * 
 */
public class ShowNamedElementNameSection extends AbstractEnhancedPropertySection implements IFilter {

	// private InputTextFigure inputTextFigure;
	private InputTextControls inputTextFigure;

	private NamedElement namedElement;

	private BusinessModelListener modelListener = new BusinessModelListener();

	public ShowNamedElementNameSection() {
	}

	@Override
	public PropertyEditor createFigure() {
		inputTextFigure = new InputTextControls("Name:", "");
		return inputTextFigure;
	}

	public void initializeFigure() {

		// Listener to listen to the property change
		PropertyChangeListener<String> editorListener = new PropertyChangeListener<String>() {

			public void propertyChanged(PropertyEditor editor, String newValue) {
				// to change to send a command
				namedElement.setName(newValue);
			}

		};
		inputTextFigure.setPropertyChangeListener(editorListener);
	}

	@Override
	public void refresh() {
		super.refresh();
		inputTextFigure.setText(namedElement.getName());
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert (selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();

		this.namedElement = (NamedElement) getBusinessElement(input);
	}

	/**
	 * Return true if this section can select such element.
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof NamedElement;
	}

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		namedElement.eAdapters().add(modelListener);
	}

	@Override
	public void aboutToBeHidden() {
		// Stop listening
		namedElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	@Override
	public void dispose() {
		// stop listening
		if (namedElement != null) {
			namedElement.eAdapters().remove(modelListener);
		}
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * 
	 * @author dumoulin
	 * 
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {

		public void notifyChanged(Notification notification) {
			refresh();
		}
	}

}