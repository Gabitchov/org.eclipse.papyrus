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
package org.eclipse.papyrus.properties.uml.widgets;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.papyrus.diagram.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.providers.XWTCompliantMaskProvider;
import org.eclipse.papyrus.properties.providers.XWTCompliantMaskProviderListener;
import org.eclipse.papyrus.properties.uml.modelelement.UMLNotationModelElement;


/**
 * A MaskProvider for the labelCustomization property
 * 
 * @author Camille Letavernier
 */
//TODO : we should actually look for the right Edit Policy to use (There are many implementations of IMaskManagedLabelEditPolicy)
public class LabelCustomizationMaskProvider implements XWTCompliantMaskProvider {

	private IMaskManagedLabelEditPolicy editPolicy;

	private DataSource input;

	private String propertyPath;

	private final Set<XWTCompliantMaskProviderListener> listeners = new HashSet<XWTCompliantMaskProviderListener>();

	public LabelCustomizationMaskProvider() {
	}

	public Map<Integer, String> getMasks() {
		return editPolicy.getMasks();
	}

	public void setProperty(String propertyPath) {
		this.propertyPath = propertyPath;
		checkInput();
	}

	public String getProperty() {
		return propertyPath;
	}

	public void setInput(DataSource input) {
		this.input = input;
		checkInput();
	}

	public DataSource getInput() {
		return input;
	}

	protected void checkInput() {
		if(input != null && propertyPath != null) {
			ModelElement element = input.getModelElement(propertyPath);
			if(element instanceof UMLNotationModelElement) {
				UMLNotationModelElement modelElement = (UMLNotationModelElement)element;
				editPolicy = (IMaskManagedLabelEditPolicy)modelElement.getEditPart().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
				if(editPolicy != null) {
					notifyListeners();
				}
			}
		}
	}

	private void notifyListeners() {
		for(XWTCompliantMaskProviderListener listener : listeners) {
			listener.notifyReady(this);
		}
	}

	public void addMaskProviderListener(XWTCompliantMaskProviderListener listener) {
		listeners.add(listener);
	}

	public void removeMaskProviderListener(XWTCompliantMaskProviderListener listener) {
		listeners.remove(listener);
	}

}
