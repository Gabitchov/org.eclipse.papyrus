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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.umlutils.StereotypeUtil;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.umlutils.ui.helper.ShadowFigureHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * this uml edit part can refresh shadow, applied stereotypes
 * 
 */
public abstract class UmlNodeEditPart extends AbstractBorderedShapeEditPart implements IUMLEditPart {

	/**
	 * Creates a new UmlNodeEditPart.
	 * 
	 * @param view
	 *            the view controlled by this edit part
	 */
	public UmlNodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	protected NodeFigure createMainFigure() {
		return createNodeFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();

		// retrieve element
		final Element element = getUMLElement();
		if (element == null) {
			return;
		}

		// add listener to react to the application and remove of a stereotype
		addListenerFilter(STEREOTYPABLE_ELEMENT, this, element);

		// add a lister to each already applied stereotyped
		for (EObject stereotypeApplication : element.getStereotypeApplications()) {
			addListenerFilter(STEREOTYPED_ELEMENT, this, stereotypeApplication);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();

		removeListenerFilter(STEREOTYPABLE_ELEMENT); //$NON-NLS-1$

		// remove listeners to react to the application and remove of stereotypes
		removeListenerFilter(STEREOTYPABLE_ELEMENT);
		removeListenerFilter(STEREOTYPED_ELEMENT);
	}



	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public abstract NodeNamedElementFigure getPrimaryShape();

	/**
	 * {@inheritDoc}
	 */
	public Element getUMLElement() {
		return (Element) resolveSemanticElement();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// NOTA: should check here which element has to be refreshed

		// check if this concerns a stereotype application or unapplication
		final int eventType = event.getEventType();

		if (eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			addListenerFilter(STEREOTYPED_ELEMENT, this, (EObject) event.getNewValue());
		}

		refreshShadow();
		// set the figure active when the feature of the of a class is true
		if (resolveSemanticElement() != null) {
			refreshAppliedStereotypes();
			refreshAppliedStereotypesProperties();
		}
	}

	/**
	 * Refresh the display of stereotypes for this uml node edit part.
	 */
	public void refreshAppliedStereotypes() {
		// retrieve the stereotype to be displayed
		final String stereotypesToDisplay = stereotypesToDisplay();

		// if the string is not empty, then, the figure has to display it. Else, it displays nothing
		if (stereotypesToDisplay != "") {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypes(stereotypesToDisplay);
		} else {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypes(null);
		}

		// refresh the icon to be displayed
		final Image imageToDisplay = stereotypeIconToDisplay();
		((NodeNamedElementFigure) getPrimaryShape()).setAppliedStereotypeIcon(imageToDisplay);
	}

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 * 
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	public Image stereotypeIconToDisplay() {
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View) getModel());
		if (stereotypespresentationKind == null) {
			return null;
		}
		if (stereotypespresentationKind.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION)
				|| stereotypespresentationKind.equals(VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View) getModel());
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if (tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
				return Activator.getIconElement(getUMLElement(), stereotype, false);
			}
		}
		return null;
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesProperties() {
		refreshAppliedStereotypesPropertiesInCompartment();
		refreshAppliedStereotypesPropertiesInBrace();
	}

	/**
	 * Refreshes the stereotypes properties displayed in a compartment of this edit part.
	 */
	protected void refreshAppliedStereotypesPropertiesInCompartment() {
		// retrieve the stereotype properties to be displayed
		final String stereotypesPropertiesToDisplay = stereotypesPropertiesToDisplayInCompartment();

		// if the string is not empty, then, the figure has to display it. Else, it displays nothing
		if (stereotypesPropertiesToDisplay != "") {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInCompartment(stereotypesPropertiesToDisplay);
		} else {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInCompartment(null);
		}
	}

	/**
	 * return string that contains value of properties of applied stereotype
	 * 
	 * @return "" or {'\u00AB'<B>StereotypeName</B>'\u00BB' {<B>propertyName</B>'='<B>propertyValue</B>','}*';'}*
	 */
	public String stereotypesPropertiesToDisplayInCompartment() {

		// check if properties have to be displayed in compartment.
		final boolean displayInCompartment = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay((View) getModel(), VisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

		// if not, return the empty string
		if (!displayInCompartment) {
			return "";
		}

		// it has to be displayed in compartment. Get the string to be displayed
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View) getModel());
		if ("".equals(stereotypesPropertiesToDisplay)) {
			return stereotypesPropertiesToDisplay;
		}
		return StereotypeUtil.getPropertiesValues(stereotypesPropertiesToDisplay, getUMLElement());
	}

	/**
	 * Refreshes the stereotypes properties displayed above name of the element in this edit part.
	 */
	protected void refreshAppliedStereotypesPropertiesInBrace() {
		// retrieve the stereotype properties to be displayed
		final String stereotypesPropertiesToDisplay = stereotypesPropertiesToDisplayInBrace();

		// if the string is not empty, then, the figure has to display it. Else, it displays nothing
		if (stereotypesPropertiesToDisplay != "") {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInBrace(stereotypesPropertiesToDisplay);
		} else {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInBrace(null);
		}
	}

	
	/**
	 * Papyrus Node support gradient. 
	 */
	@Override
	public boolean supportsGradient() {
		 return true;
	}

	/**
	 * return string that contains value of properties of applied stereotype
	 * 
	 * @return "" or {'\u00AB'<B>StereotypeName</B>'\u00BB' {<B>propertyName</B>'='<B>propertyValue</B>','}*';'}*
	 */
	public String stereotypesPropertiesToDisplayInBrace() {
		// check if properties have to be displayed in braces.
		final boolean displayInBrace = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay((View) getModel(), VisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);

		// if not, return the empty string
		if (!displayInBrace) {
			return "";
		}

		// it has to be displayed in braces, so compute the string to display
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View) getModel());
		if ("".equals(stereotypesPropertiesToDisplay)) {
			return stereotypesPropertiesToDisplay;
		}
		return StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
	}


	/**
	 * Refresh the gradient for this edit part
	 */
	protected void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View) getModel()));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshAppliedStereotypesProperties();
		refreshAppliedStereotypes();
		refreshShadow();
	}

	/**
	* Override to set the preferency to the correct figure
	*/
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}
	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *            the new value of the back ground color
	 */
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
	}

	/**
	* Override to set the gradient data to the correct figure
	*/
	@Override
	protected void setGradient(GradientData gradient) {
		NodeFigure fig = getPrimaryShape();
    	if (gradient != null) {    		    		
    		fig.setIsUsingGradient(true);
    		fig.setGradientData(gradient.getGradientColor1(), gradient.getGradientColor2(), gradient.getGradientStyle()); 		
    	} else {
    		fig.setIsUsingGradient(false);
    	}
	}

	/**
	 * sets the font color
	 * 
	 * @param color
	 *            the new value of the font color
	 */
	protected void setFontColor(Color color) {
		// NULL implementation
	}

	/**
	 * sets the fore ground color of this edit part's figure
	 * 
	 * @param color
	 *            the new value of the foregroundcolor
	 */
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setForegroundColor(color);
	}

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay() {
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View) getModel());
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View) getModel());

		// check the presentation kind. if only icon => do not display stereotypes
		if (VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return ""; // empty string, so stereotype label should not be displayed
		}

		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(((View) getModel()));
		if (VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			return stereotypesToDisplay(Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, stereotypesToDisplay, stereotypesToDisplayWithQN);
		} else {
			return stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN);

		}
	}

	/**
	 * Computes the string that displays the stereotypes for the current element
	 * 
	 * @param separator
	 *            the separator used to split the string representing the stereotypes.
	 * @param stereotypesToDisplay
	 *            the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *            the list of stereotypes displayed using their qualified names
	 * @return the string that represent the stereotypes
	 */
	public String stereotypesToDisplay(String separator, String stereotypesToDisplay, String stereotypeWithQualifiedName) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced to lower case) - default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if (store == null) {
			return "";
		}
		String sNameAppearance = store.getString(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while (strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if (stereotype != null) {
				String name = currentStereotype;
				if ((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while (strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0, 1).toLowerCase()+name.substring(1, name.length())+","+separator;

				// check that the name has not already been added to the displayed string
				if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if (out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				} else { // VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM)) {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if (out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				}
			}
		}
		if (out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if (out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}
}
