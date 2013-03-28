/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeExternalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * this is a specific class to display stereotype label for accept event action, it is only display if the event is a TimeEvent
 *
 */
public class AcceptTimeEventActionStereotypeExternalNodeEditPolicy extends AppliedStereotypeExternalNodeEditPolicy{

	/**
	 * add a specific test about TimeEvent 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeExternalNodeEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	protected void refreshStereotypeDisplay() {
		if(getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

			if( getUMLElement() instanceof AcceptEventAction){
				if( ((AcceptEventAction)getUMLElement()).getTriggers().size()>0 
					&&( ((AcceptEventAction)getUMLElement()).getTriggers().get(0).getEvent() instanceof TimeEvent)){
					if(figure instanceof IPapyrusUMLElementFigure) {
						// calculate text
						// and icon to display
						final String stereotypesToDisplay = stereotypesToDisplay();
						((IPapyrusUMLElementFigure)figure).setStereotypeDisplay(tag + (stereotypesToDisplay), null);
					}
				}
				else{
					((IPapyrusUMLElementFigure)figure).setStereotypeDisplay("", null);
				}
			}
		}

	}
	
	/**
	 * 
	 * do not pary attention if this compartment or brace due to shape change
	 * @return the list of stereotypes to display with properties if there are
	 *         selected to be displayed
	 */
	public String stereotypesToDisplay() {

		// retrieve all stereotypes to be displayed

		if (parentView == null) {
			return "";
		}

		// try to display stereotype properties
		String stereotypespresentationLocation = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(parentView);
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(parentView);
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(parentView);
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(parentView);


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
		String display = "";
		if(!UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION.equals(stereotypespresentationLocation)) {
			String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(parentView);

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
		}
		return display;
	}
	
	/**
	 * add notification about trigger
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		super.notifyChanged(notification);
		 if(UMLPackage.eINSTANCE.getAcceptEventAction_Trigger().equals(notification.getFeature())){
			 refreshStereotypeDisplay();
		 }
	}

}
