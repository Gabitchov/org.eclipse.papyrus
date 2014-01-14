/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.InstanceSpecificationUtil;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class InstanceSpecificationLabelHelper extends StereotypedElementLabelHelper implements ILabelMaskProvider {

	//Singleton instance
	private static InstanceSpecificationLabelHelper labelHelper;

	public static InstanceSpecificationLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new InstanceSpecificationLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<Integer, String> masks = new HashMap<Integer, String>();

	protected InstanceSpecificationLabelHelper() {
		// initialize the map
		masks.put(ICustomAppearence.DISP_NAME, "Name");
		masks.put(ICustomAppearence.DISP_TYPE, "Type");
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
		int displayValue = getDefaultValue();

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);

		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		} else if(editPart.getModel() instanceof View) {
			displayValue = AppearanceHelper.getLabelDisplay((View)editPart.getModel());
		}

		return parseString(editPart, displayValue);
	}

	protected String parseString(GraphicalEditPart editPart, int displayValue) {
		InstanceSpecification instance = getUMLElement(editPart);

		if(instance != null) {
			return InstanceSpecificationUtil.getCustomLabel(instance, displayValue);
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
	@Override
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
	public InstanceSpecification getUMLElement(GraphicalEditPart editPart) {
		if(editPart.getModel() instanceof View) {
			View view = (View)editPart.getModel();
			if(view.getElement() instanceof InstanceSpecification) {
				return (InstanceSpecification)view.getElement();
			}
		}
		return null;
	}

	@Override
	public int getDefaultValue() {
		return ICustomAppearence.DEFAULT_UML_INSTANCESPECIFICATION;
	}

}
