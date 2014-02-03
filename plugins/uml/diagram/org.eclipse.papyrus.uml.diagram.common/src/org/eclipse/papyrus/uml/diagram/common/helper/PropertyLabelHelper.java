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
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class PropertyLabelHelper extends StereotypedElementLabelHelper {

	// Einstance
	private static PropertyLabelHelper labelHelper;

	public static PropertyLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new PropertyLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<String, String> masks = new HashMap<String, String>();

	protected PropertyLabelHelper() {
		// initialize the map
		masks.put(ICustomAppearance.DISP_VISIBILITY, "Visibility");
		masks.put(ICustomAppearance.DISP_DERIVE, "Is Derived");
		masks.put(ICustomAppearance.DISP_NAME, "Name");
		masks.put(ICustomAppearance.DISP_TYPE, "Type");
		masks.put(ICustomAppearance.DISP_MULTIPLICITY, "Multiplicity");
		masks.put(ICustomAppearance.DISP_DEFAULT_VALUE, "Default Value");
		masks.put(ICustomAppearance.DISP_MODIFIERS, "Modifiers");
	}

	/**
	 * Computes the label that should be displayed by the figure managed by this
	 * edit part.
	 *
	 * @param editPart
	 *        the edit part that controls the {@link Property} to be
	 *        displayed
	 * @return the label corresponding to the specific display of the property
	 *         ("default" display given by preferences or specific display given
	 *         by eAnnotation).
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);

		Collection<String> displayValue = Collections.emptySet();

		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}

		return parseString(editPart, displayValue);
	}

	protected String parseString(GraphicalEditPart editPart, Collection<String> displayValue) {
		Property property = getUMLElement(editPart);

		if(property != null) {
			return PropertyUtil.getCustomLabel(property, displayValue);
		}

		return "";
	}


	/**
	 * Returns the map of masks used to display a {@link Property}
	 *
	 * @return the {@link Map} of masks used to display a {@link Property}
	 */
	public Map<String, String> getMasks() {
		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Property getUMLElement(GraphicalEditPart editPart) {
		if(editPart.getModel() instanceof View) {
			View view = (View)editPart.getModel();
			if(view.getElement() instanceof Property) {
				return (Property)view.getElement();
			}
		}
		return null;
	}

}
