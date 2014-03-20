/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429275
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.graphics.Image;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 */
public class AppliedStereotypeNodeLabelDisplayEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	public AppliedStereotypeNodeLabelDisplayEditPolicy() {
		super();
	}

	public AppliedStereotypeNodeLabelDisplayEditPolicy(String tag) {
		super(tag);
	}

	/**
	 * Refreshes the stereotype display
	 */
	protected void refreshStereotypeDisplay() {
		if(getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

			// calculate text and icon to display
			final String stereotypesToDisplay = stereotypesOnlyToDisplay();
			// computes the icon to be displayed
			final Image imageToDisplay = stereotypeIconToDisplay();

			// if the string is not empty, then, the figure has to display it.
			// Else, it displays
			// nothing
			// if (stereotypesToDisplay != "" || imageToDisplay != null) {
			if(figure instanceof IPapyrusNodeUMLElementFigure) {
				((IPapyrusNodeUMLElementFigure)figure).setStereotypeDisplay(tag + (stereotypesOnlyToDisplay().equals("") ? stereotypesToDisplay : stereotypesToDisplay), imageToDisplay);

				if(figure instanceof IPapyrusNodeNamedElementFigure) {
					refreshAppliedStereotypesProperties((IPapyrusNodeNamedElementFigure)figure);
				} else {
					refreshAppliedStereotypesProperties((IPapyrusNodeUMLElementFigure)figure);
				}
			}
			// TODO we should manage PapyrusNodeFigure here too (and
			// WrappingLabel ?)
		}
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesProperties(IPapyrusNodeNamedElementFigure figure) {
		final String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)getHost().getModel());

		refreshAppliedStereotypesPropertiesInCompartment(stereotypesPropertiesToDisplay, figure);
		refreshAppliedStereotypesPropertiesInBrace(stereotypesPropertiesToDisplay, figure);

		BooleanValueStyle displayStereotypes = (BooleanValueStyle) getView().getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), NamedElementEditPart.DISPLAY_STEREOTYPES);
		if (displayStereotypes != null && !displayStereotypes.isBooleanValue()) {
			figure.removeStereotypeLabel();
		} else {
			figure.restoreStereotypeLabel();
		}
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesProperties(IPapyrusNodeUMLElementFigure figure) {
		final String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)getHost().getModel());

		refreshAppliedStereotypesPropertiesInCompartment(stereotypesPropertiesToDisplay, figure);
		refreshAppliedStereotypesPropertiesInBrace(stereotypesPropertiesToDisplay, figure);
	}

	/**
	 * Refreshes the stereotypes properties displayed in a compartment of this
	 * edit part.
	 * 
	 * @param stereotypesPropertiesToDisplay
	 *        list of properties to display
	 * @param figure
	 *        the figure in which stereotype will be displayed
	 */
	protected void refreshAppliedStereotypesPropertiesInCompartment(String stereotypesPropertiesToDisplay, IPapyrusNodeUMLElementFigure figure) {
		// retrieve the stereotype properties to be displayed

		final boolean displayInCompartment = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay((View)(View)getHost().getModel(), UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		if(displayInCompartment) {
			String todisplay = StereotypeUtil.getPropertiesValues(stereotypesPropertiesToDisplay, getUMLElement());
			figure.setStereotypePropertiesInCompartment(todisplay);
		} else {
			figure.setStereotypePropertiesInCompartment(null);
		}
	}

	/**
	 * Refreshes the stereotypes properties displayed above name of the element
	 * in this edit part.
	 */
	protected void refreshAppliedStereotypesPropertiesInBrace(String stereotypesPropertiesToDisplay, IPapyrusNodeUMLElementFigure figure) {
		// check if properties have to be displayed in braces.
		final boolean displayInBrace = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay((View)getHost().getModel(), UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);

		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		if(displayInBrace) {
			// it has to be displayed in braces, so compute the string to
			// display
			String todisplay = StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
			figure.setStereotypePropertiesInBrace(todisplay);
		} else {
			figure.setStereotypePropertiesInBrace(null);
		}
	}

	/**
	 * this method is used to display only applied stereotypes
	 * 
	 * @return the string with applied stereotypes. It can return "" if there is
	 *         no stereotypes to display
	 */
	public String stereotypesOnlyToDisplay() {
		// list of stereotypes to display
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getHost().getModel());
		// Kind of the representation
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getHost().getModel());

		// check the presentation kind. if only icon => do not display
		// stereotypes
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return ""; // empty string, so stereotype label should not be
						// displayed
		}

		// stereotypes with qualified name to display
		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(((View)getHost().getModel()));

		// the set is empty
		if(stereotypesToDisplayWithQN.length() == 0 && stereotypesToDisplay.length() == 0) {
			return "";
		}
		// vertical representation
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			return Activator.ST_LEFT + stereotypesToDisplay(Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, stereotypesToDisplay, stereotypesToDisplayWithQN) + Activator.ST_RIGHT;
		} else {// horizontal representation
			return Activator.ST_LEFT + stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN) + Activator.ST_RIGHT;

		}
	}

}
