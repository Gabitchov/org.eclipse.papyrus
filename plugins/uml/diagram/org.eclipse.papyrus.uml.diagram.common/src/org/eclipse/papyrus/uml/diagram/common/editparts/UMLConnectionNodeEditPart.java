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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Abstract edit part for all connection nodes that control UML elements
 * represented by edges. It then defines basic behavior for Stereotype
 * management. It has facilities to retrieve UML element controlled by this edit
 * part
 */
public abstract class UMLConnectionNodeEditPart extends ConnectionEditPart implements IUMLEditPart, IEditpartListenerAccess {

	/**
	 * Creates a new UMLConnectionNodeEditPart
	 * 
	 * @param view
	 *        owned view by this edit part
	 */
	public UMLConnectionNodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();

		// retrieve element
		final Element element = getUMLElement();
		if(element == null) {
			return;
		}

		// add listener to react to the application and remove of a stereotype
		addListenerFilter(STEREOTYPABLE_ELEMENT, this, resolveSemanticElement());

		// add a lister to each already applied stereotyped
		for(EObject stereotypeApplication : element.getStereotypeApplications()) {
			addListenerFilter(STEREOTYPED_ELEMENT, this, stereotypeApplication);
		}
	}

	public final Iterator getEventListenerIterator(Class clazz) {
		return getEventListeners(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// NOTA: should check here which element has to be refreshed

		// check if this concerns a stereotype application or unapplication
		final int eventType = event.getEventType();

		if(eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			addListenerFilter(STEREOTYPED_ELEMENT, this, (EObject)event.getNewValue());
		}

		// // refresh the figure if stereotypes have changed
		// if (resolveSemanticElement() != null) {
		// refreshAppliedStereotypes();
		// }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// adds the stereotype application edit policy
		installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());

		// adds a custom EditPolicy to manage the displaying of each label on
		// the connector
		// this editpolicy erase ConnectionLabelsEditPolicy
		installEditPolicy(ShowHideLabelEditPolicy.SHOW_HIDE_LABEL_ROLE, new ShowHideLabelEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST.equals(request.getType())) {
			return this;
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public abstract UMLEdgeFigure getPrimaryShape();

	/**
	 * Refresh the display of stereotypes for this uml node edit part.
	 */
	public void refreshAppliedStereotypes() {
		// computes the stereotypes to be displayed
		final String stereotypesToDisplay = stereotypesToDisplay();
		// computes the icon to be displayed
		final Image imageToDisplay = stereotypeIconToDisplay();

		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		if(stereotypesToDisplay != "" || imageToDisplay != null) {
			getPrimaryShape().setStereotypeDisplay(stereotypesToDisplay, imageToDisplay);
		} else {
			// getPrimaryShape().setStereotypeDisplay(null, null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();

		// remove listeners to react to the application and remove of
		// stereotypes
		removeListenerFilter(STEREOTYPABLE_ELEMENT);
		removeListenerFilter(STEREOTYPED_ELEMENT);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getUMLElement() {
		return (Element)resolveSemanticElement();
	}

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay() {
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getModel());
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getModel());

		// check the presentation kind. if only icon => do not display
		// stereotypes
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return ""; // empty string, so stereotype label should not be
						// displayed
		}

		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(((View)getModel()));
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			return stereotypesToDisplay(Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, stereotypesToDisplay, stereotypesToDisplayWithQN);
		} else {
			return stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN);
		}
	}

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 * 
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	public Image stereotypeIconToDisplay() {
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getModel());
		if(stereotypespresentationKind == null) {
			return null;
		}
		if(stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) || stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getModel());
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if(tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
				return Activator.getIconElement(getUMLElement(), stereotype, false);
			}
		}
		return null;
	}

	/**
	 * Computes the string that displays the stereotypes for the current element
	 * 
	 * @param separator
	 *        the separator used to split the string representing the
	 *        stereotypes.
	 * @param stereotypesToDisplay
	 *        the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *        the list of stereotypes displayed using their qualified names
	 * @return the string that represent the stereotypes
	 */
	public String stereotypesToDisplay(String separator, String stereotypesToDisplay, String stereotypeWithQualifiedName) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from
		// ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced
		// to lower case) -
		// default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if(store == null) {
			return "";
		}
		String sNameAppearance = store.getString(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while(strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if(stereotype != null) {
				String name = currentStereotype;
				if((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name
					// from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while(strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1,
				// name.length())+","+separator;

				// check that the name has not already been added to the
				// displayed string
				if(sNameAppearance.equals(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				} else { // VisualInformationPapyrusConstants.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				}
			}
		}
		if(out.endsWith(",")) {
			out = out.substring(0, out.length() - 1);
		}
		if(out.endsWith(separator)) {
			out = out.substring(0, out.length() - separator.length());
		}
		if(out != "") {
			out = Activator.ST_LEFT + out + Activator.ST_RIGHT;
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setLineWidth(int width) {
		if(width < 0) {
			width = 1;
		}
		getPrimaryShape().setLineWidth(width);
	}

}
