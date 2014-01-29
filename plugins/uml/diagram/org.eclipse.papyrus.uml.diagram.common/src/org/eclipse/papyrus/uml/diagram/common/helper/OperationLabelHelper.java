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
import org.eclipse.papyrus.uml.tools.utils.OperationUtil;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class OperationLabelHelper extends StereotypedElementLabelHelper implements ILabelMaskProvider {

	/**
	 * singelton instance
	 */
	private static OperationLabelHelper labelHelper;

	/**
	 * Returns the singleton instance of this class
	 *
	 * @return the singleton instance.
	 */
	public static OperationLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new OperationLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<Integer, String> masks = new HashMap<Integer, String>(7);

	/**
	 * Creates a new Operation label helper.
	 */
	protected OperationLabelHelper() {
		// initialize the map
		masks.put(ICustomAppearence.DISP_VISIBILITY, "Visibility");
		masks.put(ICustomAppearence.DISP_NAME, "Name");
		masks.put(ICustomAppearence.DISP_PARAMETER_NAME, "Parameters Name");
		masks.put(ICustomAppearence.DISP_PARAMETER_DIRECTION, "Parameters Direction");
		masks.put(ICustomAppearence.DISP_PARAMETER_TYPE, "Parameters Type");
		masks.put(ICustomAppearence.DISP_RT_TYPE, "Return Type");
		masks.put(ICustomAppearence.DISP_PARAMETER_MULTIPLICITY, "Parameters Multiplicity");
		masks.put(ICustomAppearence.DISP_PARAMETER_DEFAULT, "Parameters Default Value");
		masks.put(ICustomAppearence.DISP_PARAMETER_MODIFIERS, "Parameters Modifiers");
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
		//		int displayValue = ICustomAppearence.DEFAULT_UML_OPERATION;
		//
		//		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		//		if(policy != null) {
		//			displayValue = policy.getCurrentDisplayValue();
		//		}
		//		return OperationUtil.getCustomLabel(getUMLElement(editPart), displayValue);

		Object model = editPart.getModel();
		if(model instanceof View) {
			Operation element = getUMLElement(editPart);
			if(element != null) {
				int displayValue = AppearanceHelper.getLabelDisplay((View)model);
				return OperationUtil.getCustomLabel(element, displayValue);
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
	public Operation getUMLElement(GraphicalEditPart editPart) {
		return (Operation)((View)editPart.getModel()).getElement();
	}

	public int getDefaultValue() {
		return ICustomAppearence.DEFAULT_UML_OPERATION;
	}

}
