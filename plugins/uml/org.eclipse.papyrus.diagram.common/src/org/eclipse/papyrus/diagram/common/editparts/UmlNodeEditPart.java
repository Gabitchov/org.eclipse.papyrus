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
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.umlutils.StereotypeUtil;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.umlutils.ui.helper.GradientColorHelper;
import org.eclipse.papyrus.umlutils.ui.helper.ShadowFigureHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Element;

/**
 * this uml edit part can refresh shadow, applied stereotypes, gradient color
 * 
 */
public abstract class UmlNodeEditPart extends AbstractBorderedShapeEditPart implements IUMLEditPart {

	public UmlNodeEditPart(View view) {
		super(view);
	}

	protected NodeFigure createMainFigure() {
		return createNodeFigure();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected NodeFigure createNodeFigure() {
		return new BorderedNodeFigure(createMainFigure());
	}

	public abstract NodeNamedElementFigure getPrimaryShape();

	public Element getUMLElement() {
		return (Element) resolveSemanticElement();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		refreshGradient();
		refreshShadow();
		// set the figure active when the feature of the of a class is true
		if (resolveSemanticElement() != null) {
			refreshAppliedStereotypes();
			refreshAppliedStereotypesProperties();
		}
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	private void refreshAppliedStereotypesProperties() {
		if ("" != stereotypesPropertiesToDisplay()) {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInCompartment(stereotypesPropertiesToDisplay());
		} else {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypePropertiesInCompartment(null);
		}

	}

	public void refreshAppliedStereotypes() {
		if (stereotypesToDisplay() != "") {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypes(stereotypesToDisplay());
		} else {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypes(null);
		}
	}

	protected void refreshGradient() {
		getPrimaryShape().setDisplayGradient(GradientColorHelper.getGradientColorValue((View) getModel()));

	}

	protected void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View) getModel()));

	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshAppliedStereotypesProperties();
		refreshAppliedStereotypes();
		refreshShadow();
		refreshGradient();

	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *            the new value of the back ground color
	 */
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
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
		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(((View) getModel()));
		if (VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			return stereotypesToDisplay(Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, stereotypesToDisplay, stereotypesToDisplayWithQN);
		} else {
			return stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN);

		}
	}

	/**
	 * Computes the string that displays the stereotypes for the current element 
	 * @param separator the separator used to split the string representing the stereotypes. 
	 * @param stereotypesToDisplay the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName the list of stereotypes displayed using their qualified names
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
		if(store == null) {
			return "";
		}
		String sNameAppearance = store.getString(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while (strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();
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

			if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
				out = out + name + separator;
			} else if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM)) {
				out = out + name.substring(0, 1).toLowerCase() + name.substring(1, name.length()) + separator;
			} else { // should not happen since radio button are used to set choice
				out = out + name.substring(0, 1).toLowerCase() + name.substring(1, name.length()) + separator;
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

	/**
	 * return string that contains value of properties of applied stereotype
	 * 
	 * @return "" or {'\u00AB'<B>StereotypeName</B>'\u00BB' {<B>propertyName</B>'='<B>propertyValue</B>','}*';'}*
	 */
	public String stereotypesPropertiesToDisplay() {
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View) getModel());
		if (stereotypesPropertiesToDisplay.equals("")) {
			return stereotypesPropertiesToDisplay;
		}
		return StereotypeUtil.getPropertiesValues(stereotypesPropertiesToDisplay, getUMLElement());
	}

}
