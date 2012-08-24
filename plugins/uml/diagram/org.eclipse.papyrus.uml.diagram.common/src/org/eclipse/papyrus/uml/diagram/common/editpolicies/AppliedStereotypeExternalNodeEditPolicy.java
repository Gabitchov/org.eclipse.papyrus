/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;

/**
 * This edit policy is used to display only applied stereotypes and properties
 * in a external node (that is a labelEditPart) In order to use it, the edit
 * part has to be {@link IPapyrusEditPart} and the associated figure has to be {@link IPapyrusUMLElementFigure}
 */
public class AppliedStereotypeExternalNodeEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	public AppliedStereotypeExternalNodeEditPolicy() {
		super();
	}

	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		super.activate();
		// add a listener for TimeObservationEditPart
		// eContainer = getParent() , but here it's the ECore model
		if(view.eContainer() != null)
			getDiagramEventBroker().addNotificationListener(view.eContainer(), this);

		refreshDisplay();

	}

	@Override
	public void deactivate() {
		if(getView().eContainer() != null)
			getDiagramEventBroker().removeNotificationListener(getView().eContainer(), this);

		super.deactivate();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();
	}

	/**
	 * 
	 * 
	 * @return the list of stereotypes to display with properties if there are
	 *         selected to be displayed
	 */
	public String stereotypesToDisplay() {

		// retrieve all stereotypes to be displayed

		// try to display stereotype properties
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)((View)getHost().getModel()).eContainer());
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)((View)getHost().getModel()).eContainer());
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)((View)getHost().getModel()).eContainer());

		// now check presentation.
		// if horizontal => equivalent to the inBrace visualization in nodes
		// (i.e. only name =
		// value, separator = comma, delimited with brace
		// if vertical => equivalent to compartment visualization name of
		// stereotype, NL, property =
		// value, NL, etC.

		// check the presentation kind. if only icon => do not display
		// stereotype, only values
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
		}

		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay((View)((View)getHost().getModel()).eContainer());
		String display = "";
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			display += stereotypesAndPropertiesToDisplay("\n", stereotypesToDisplay, stereotypesToDisplayWithQN, stereotypesPropertiesToDisplay);
		} else {
			final String st = stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN);
			if(st != null && !st.equals("")) {
				display += Activator.ST_LEFT + st + Activator.ST_RIGHT;
			}
			final String propSt = StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
			if(propSt != null && !propSt.equals("")) {
				if(st != null && !st.equals("")) {
					display += "\n";
				}
				display += "{" + propSt + "}";
			}
		}
		return display;
	}

	/**
	 * Refresh the text of the stereotype
	 */

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
