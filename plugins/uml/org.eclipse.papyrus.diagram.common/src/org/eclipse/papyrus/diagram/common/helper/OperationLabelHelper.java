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
package org.eclipse.papyrus.diagram.common.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.umlutils.ICustomAppearence;
import org.eclipse.papyrus.umlutils.OperationUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
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
		masks.put(ICustomAppearence.DISP_PARAMETER_MULTIPLICITY, "Parameters Multiplicity");
		masks.put(ICustomAppearence.DISP_PARAMETER_DEFAULT, "Parameters Default Value");
		masks.put(ICustomAppearence.DISP_PARAMETER_MODIFIERS, "Parameters Modifiers");
		masks.put(ICustomAppearence.DISP_MOFIFIERS, "Modifiers");

	}

	/**
	 * Computes the label that should be displayed by the figure managed by this edit part.
	 * 
	 * @param editPart
	 *        the edit part that controls the {@link Property} to be displayed
	 * @return the label corresponding to the specific display of the property ("default" display
	 *         given by preferences or specific display given by eAnnotation).
	 */
	protected String elementLabel(GraphicalEditPart editPart) {
		int displayValue = ICustomAppearence.DEFAULT_UML_OPERATION;

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart
				.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		return OperationUtil.getCustomLabel(getUMLElement(editPart), displayValue);
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
	public Operation getUMLElement(GraphicalEditPart editPart) {
		return (Operation)((View)editPart.getModel()).getElement();
	}

	/**
	 * Computes the label to be displayed for the property
	 */
	protected String labelToDisplay(GraphicalEditPart editPart) {
		StringBuffer buffer = new StringBuffer();

		// computes the label for the stereotype (horizontal presentation)
		buffer.append(stereotypesToDisplay(editPart));

		// computes the string label to be displayed
		buffer.append(elementLabel(editPart));

		// buffer.append(PropertyUtil.getCustomLabel(getUMLElement(), 0));
		return buffer.toString();
	}

	/**
	 * Refreshes the label of the figure associated to the specified edit part
	 * 
	 * @param editPart
	 *        the edit part managing the refreshed figure
	 */
	public void refreshEditPartDisplay(GraphicalEditPart editPart) {
		IFigure figure = editPart.getFigure();

		// computes the icon to be displayed
		final Collection<Image> imageToDisplay = stereotypeIconsToDisplay(editPart);

		// for each element in the list of stereotype icon, adds it to the icons list of the
		// wrapping label
		// problem (RS - CEA LIST): more icons were displayed before refresh: has to clean
		// problem 2 (RS - CEA LIST): no method to know how many icons were displayed => should fix
		// a max number ?!
		// solution: set all images to null, and then add the correct icons
		int i = 0;
		while(((WrappingLabel)figure).getIcon(i) != null) {
			((WrappingLabel)figure).setIcon(null, i);
			i++;
		}
		i = 0;
		for(Image image : imageToDisplay) {
			((WrappingLabel)figure).setIcon(image, i);
			i++;
		}
		((WrappingLabel)figure).setText(labelToDisplay(editPart));
	}
}
