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

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.OperationUtil;
import org.eclipse.uml2.uml.Operation;

/**
 * Helper for labels displaying {@link Operation}
 */
public class OperationLabelHelper extends StereotypedElementLabelHelper {

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
	protected final Map<String, String> masks = new HashMap<String, String>();

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
		masks.put(ICustomAppearence.DISP_MODIFIERS, "Modifiers");

	}

	/**
	 * Computes the label that should be displayed by the figure managed by this
	 * edit part.
	 *
	 * @param editPart
	 *        the edit part that controls the {@link Operation} to be
	 *        displayed
	 * @return the label corresponding to the specific display of the property
	 *         ("default" display given by preferences or specific display given
	 *         by eAnnotation).
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		Collection<String> displayValue = ICustomAppearence.DEFAULT_UML_OPERATION;

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		return OperationUtil.getCustomLabel(getUMLElement(editPart), displayValue);
	}

	/**
	 * Returns the map of masks used to display an {@link Operation}
	 *
	 * @return the {@link Map} of masks used to display a {@link Operation}
	 */
	public Map<String, String> getMasks() {
		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operation getUMLElement(GraphicalEditPart editPart) {
		return (Operation)((View)editPart.getModel()).getElement();
	}

}
