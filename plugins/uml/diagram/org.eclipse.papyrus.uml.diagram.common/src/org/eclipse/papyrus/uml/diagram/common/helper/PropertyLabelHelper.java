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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class PropertyLabelHelper extends StereotypedElementLabelHelper implements ILabelMaskProvider {

	// Einstance
	private static PropertyLabelHelper labelHelper;

	public static PropertyLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new PropertyLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<Integer, String> masks = new HashMap<Integer, String>(7);

	protected PropertyLabelHelper() {
		// initialize the map
		masks.put(ICustomAppearence.DISP_VISIBILITY, "Visibility");
		masks.put(ICustomAppearence.DISP_DERIVE, "Is Derived");
		masks.put(ICustomAppearence.DISP_NAME, "Name");
		masks.put(ICustomAppearence.DISP_TYPE, "Type");
		masks.put(ICustomAppearence.DISP_MULTIPLICITY, "Multiplicity");
		masks.put(ICustomAppearence.DISP_DFLT_VALUE, "Default Value");
		masks.put(ICustomAppearence.DISP_MOFIFIERS, "Modifiers");
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
		//		int displayValue = ICustomAppearence.DEFAULT_UML_PROPERTY;
		//
		//		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		//		if(policy != null) {
		//			displayValue = policy.getCurrentDisplayValue();
		//		}
		//		Property elem = getUMLElement(editPart);
		//		if(elem != null) {
		//			return PropertyUtil.getCustomLabel(elem, displayValue);
		//		}
		//		return "";
		Object model = editPart.getModel();
		if(model instanceof View) {
			Property element = getUMLElement(editPart);
			if(element != null) {
				int displayValue = AppearanceHelper.getLabelDisplay((View)model);
				return PropertyUtil.getCustomLabel(element, displayValue);
			}
		}

		return "";
	}

	/**
	 * Returns the mask name given the value of the mask
	 * 
	 * @return the mask name or <code>null</code> if no masks has been found
	 */
	public String getMaskLabel(int value) {
		return masks.get(value);
	}

	/**
	 * Returns the collection of mask names
	 * 
	 * @return the collection of mask names
	 */
	public Collection<String> getMaskLabels() {
		return masks.values();
	}

	/**
	 * Returns the map of masks used to display a {@link Property}
	 * 
	 * @return the {@link Map} of masks used to display a {@link Property}
	 */
	public Map<Integer, String> getMasks() {
		return masks;
	}

	/**
	 * Returns the collection of mask values
	 * 
	 * @return the collection of mask values
	 */
	public Set<Integer> getMaskValues() {
		return masks.keySet();
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

	public int getDefaultValue() {
		return ICustomAppearence.DEFAULT_UML_PROPERTY;
	}

}
