/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;


/**
 * Display both stereotype and stereotype properties in one figure.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AppliedStereotypeExternalNodeLabelEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	protected View hostView = null;

	/**
	 * Constructor.
	 * 
	 */
	public AppliedStereotypeExternalNodeLabelEditPolicy() {
		this(null);
	}

	/**
	 * Constructor.
	 * 
	 */
	public AppliedStereotypeExternalNodeLabelEditPolicy(View hostView) {
		this.hostView = hostView;
	}

	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		super.activate();
		if(hostView == null) {
			// add a listener for TimeObservationEditPart
			// eContainer = getParent() , but here it's the ECore model
			EObject parent = view.eContainer();
			if(parent instanceof View) {
				hostView = (View)parent;
			}
		}
		getDiagramEventBroker().addNotificationListener(hostView, this);

		refreshDisplay();

	}

	@Override
	public void deactivate() {
		if(hostView != null) {
			getDiagramEventBroker().removeNotificationListener(hostView, this);
		}
		super.deactivate();
	}

	@Override
	public void refreshDisplay() {
		super.refreshDisplay();
		if(getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

			if(figure instanceof IPapyrusNodeUMLElementFigure) {
				refreshAppliedStereotypesProperties((IPapyrusNodeUMLElementFigure)figure);
			}
		}
	}

	public String stereotypesToDisplay() {
		if(hostView == null) {
			return "";
		}
		// list of stereotypes to display
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(hostView);
		// Kind of the representation
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(hostView);

		// check the presentation kind. if only icon => do not display
		// stereotypes
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return ""; // empty string, so stereotype label should not be
						// displayed
		}

		// stereotypes with qualified name to display
		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(hostView);

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

	protected void refreshAppliedStereotypesProperties(IPapyrusNodeUMLElementFigure figure) {
		if(hostView == null) {
			return;
		}
		final String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(hostView);

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
		if(hostView == null) {
			return;
		}
		// retrieve the stereotype properties to be displayed

		final boolean displayInCompartment = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay(hostView, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

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
		if(hostView == null) {
			return;
		}
		// check if properties have to be displayed in braces.
		final boolean displayInBrace = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay(hostView, UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);

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
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 * 
	 */

	@Override
	protected void refreshStereotypeDisplay() {
		if(getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

			if(figure instanceof IPapyrusUMLElementFigure) {// calculate text
				// and icon to
				// display
				final String stereotypesToDisplay = stereotypesToDisplay();
				((IPapyrusUMLElementFigure)figure).setStereotypeDisplay(tag + (stereotypesToDisplay), null);
			}
		}
	}
}
