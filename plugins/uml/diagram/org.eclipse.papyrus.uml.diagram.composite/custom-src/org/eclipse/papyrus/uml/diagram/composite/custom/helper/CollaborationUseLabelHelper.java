/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.CollaborationUseUtil;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.CollaborationUse;

/**
 * Helper for labels displaying {@link CollaborationUse} in Composite Diagram
 */
public class CollaborationUseLabelHelper extends StereotypedElementLabelHelper {

	/** Single instance */
	private static CollaborationUseLabelHelper labelHelper;

	/** Single instance getter */
	public static CollaborationUseLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new CollaborationUseLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<String, String> masks = new HashMap<String, String>();

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
	public Map<String, String> getMasks() {
		return masks;
	}

	/** Disable constructor (private) */
	protected CollaborationUseLabelHelper() {
		super();
		// initialize the map
		masks.clear();
		masks.put(ICustomAppearance.DISP_VISIBILITY, "Visibility");
		masks.put(ICustomAppearance.DISP_NAME, "Name");
		masks.put(ICustomAppearance.DISP_TYPE, "Type");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		Collection<String> displayValue = ICustomAppearance.DEFAULT_UML_PROPERTY;

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		CollaborationUse elem = getUMLElement(editPart);
		if(elem != null) {
			return CollaborationUseUtil.getCustomLabel(elem, displayValue);
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CollaborationUse getUMLElement(GraphicalEditPart editPart) {
		EObject element = super.getUMLElement(editPart);
		if(element instanceof CollaborationUse) {
			return (CollaborationUse)element;
		}
		return null;
	}

}
