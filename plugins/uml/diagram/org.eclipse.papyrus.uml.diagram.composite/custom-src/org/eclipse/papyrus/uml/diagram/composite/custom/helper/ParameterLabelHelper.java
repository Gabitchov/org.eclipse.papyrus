/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.papyrus.uml.tools.utils.ParameterUtil;
import org.eclipse.uml2.uml.Parameter;

/**
 * Helper for labels displaying {@link Parameter} in Composite Diagram
 */
public class ParameterLabelHelper extends StereotypedElementLabelHelper {

	/** Single instance */
	private static ParameterLabelHelper labelHelper;

	/** Single instance getter */
	public static ParameterLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new ParameterLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<String, String> masks = new HashMap<String, String>();

	/**
	 * Returns the collection of mask names
	 *
	 * @return the collection of mask names
	 */
	public Collection<String> getMaskLabels() {
		return masks.values();
	}

	/**
	 * Returns the map of masks used to display a {@link Parameter}
	 *
	 * @return the {@link Map} of masks used to display a {@link Parameter}
	 */
	public Map<String, String> getMasks() {
		return masks;
	}

	/** Disable constructor (private) */
	protected ParameterLabelHelper() {
		super();
		// initialize the map
		masks.clear();
		masks.put(ICustomAppearance.DISP_DIRECTION, "Direction");
		masks.put(ICustomAppearance.DISP_NAME, "Name");
		masks.put(ICustomAppearance.DISP_TYPE, "Type");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		Collection<String> displayValue = ICustomAppearance.DEFAULT_UML_PARAMETER;

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		Parameter elem = getUMLElement(editPart);
		if(elem != null) {
			return ParameterUtil.getCustomLabel(elem, displayValue);
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Parameter getUMLElement(GraphicalEditPart editPart) {
		return (Parameter)((View)editPart.getModel()).getElement();
	}

}
