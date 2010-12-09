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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * The Class StereotypeValueTreeObject. Represents an stereotype attribute that is typed
 * by another stereotype.
 */
public class StereotypeValueTreeObject extends ValueTreeObject {

	/**
	 * Creates a new StereotypeValueTreeObject.
	 * 
	 * @param value
	 *        the value
	 * @param parent
	 *        the parent
	 */
	public StereotypeValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value) {
		super(parent, value);
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.profile.tree.objects.ValueTreeObject#editMe()
	 */
	@Override
	public void editMe() {

		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)getParent();
		Element elt = ((StereotypedElementTreeObject)getParent().getParent().getParent()).getElement();
		Property property = pTO.getProperty();
		Type type = property.getType();

		final ArrayList<Element> filteredElements = Util.getInstancesFilteredByType(elt, null, (Stereotype) type);

		// filter elements that are already selected from the proposal list
		// pTO.removeSelected (filteredElements, (EObject) value);
		// does not work here, since filteredElements are base elements, not stereotype applications
		if (property.isMultivalued()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) pTO.getValue();
			if (values != null) {
				Iterator<Element> filteredElementIt = filteredElements.iterator ();
				while (filteredElementIt.hasNext ()) {
					EObject eObj = filteredElementIt.next();
					if (eObj instanceof Element) {
						Element element = (Element) eObj;
						EObject stereoApplication = element.getStereotypeApplication((Stereotype) type);
						if ((values.contains (stereoApplication)) && (stereoApplication != value)) {
							// remove already selected elements, but not the current (value)
							filteredElementIt.remove ();
						}
					}
				}
			}
		}

		String[] elementNames = Util.getStringArrayFromList(filteredElements);
		// if no possible selection : abort
		if(elementNames == null) {
			Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
			return;
		}

		ProfileElementLabelProvider labelProvider = new ProfileElementLabelProvider();
		String initialValue = (value != null ? labelProvider.getText(this) : elementNames[0]);
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(new Shell(), "New value:", elementNames, initialValue);
		int val = valueDialog.open();
		if((val == ComboSelectionDialog.OK) && (valueDialog.indexOfSelection != -1)) {
			Element newElement = (Element)filteredElements.get(valueDialog.indexOfSelection);
			EObject newValue = newElement.getStereotypeApplication((Stereotype)type);
			if (newValue == null) {
				// the selected element is stereotyped with stereotype specializing type
				EList<Stereotype> specialStereotypes = newElement.getAppliedSubstereotypes((Stereotype)type);
				if(!specialStereotypes.isEmpty()) {
					newValue = newElement.getStereotypeApplication(specialStereotypes.get(0));
				}
			}
			pTO.updateValue(pTO.appendMV(newValue));
		}

		// Close dialog box and refresh table
		valueDialog.close();
	}
}
