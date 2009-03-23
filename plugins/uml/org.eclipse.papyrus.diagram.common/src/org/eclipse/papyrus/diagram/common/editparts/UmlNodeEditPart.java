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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.umlutils.ui.GradientColorHelper;
import org.eclipse.papyrus.umlutils.ui.ShadowFigureHelper;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.swt.graphics.Color;

/**
 * this uml edit part can refresh shadow, applied stereotypes, gradient color
 * 
 */
public abstract class UmlNodeEditPart extends AbstractBorderedShapeEditPart {

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

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		refreshGradient();
		refreshShadow();
		// set the figure active when the feature of the of a class is true
		if (resolveSemanticElement() != null) {
			refreshAppliedStereotypes();
		}
	}

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay() {
		EAnnotation stereotypeDisplayKind = ((View) getModel()).getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(VisualInformationPapyrusConstant.STEREOTYPE_LIST);
			String stereotypespresentationKind = entries.get(VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND);
			if (VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
				return stereotypesToDisplay("\n", stereotypesToDisplay);
			} else {
				return stereotypesToDisplay(" ", stereotypesToDisplay);

			}
		}
		return "";
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshAppliedStereotypes();
		refreshShadow();
		refreshGradient();

	}

	protected void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View) getModel()));

	}

	protected void refreshGradient() {
		getPrimaryShape().setDisplayGradient(GradientColorHelper.getGradientColorValue((View) getModel()));

	}

	public void refreshAppliedStereotypes() {
		if (stereotypesToDisplay() != "") {
			((NodeNamedElementFigure) getPrimaryShape()).setStereotypes(stereotypesToDisplay());
		}
	}

	public String stereotypesToDisplay(String separator, String stereotypesToDisplay) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced to lower case) - default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String sNameAppearance = store.getString(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strqualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while (strqualifiedName.hasMoreElements()) {

			// property value contains qualifiedName ==> extract name from it
			StringTokenizer strToken = new StringTokenizer(strqualifiedName.nextToken(), "::");
			String name = "";
			while (strToken.hasMoreTokens()) {
				name = strToken.nextToken();
			}
			// AL Changes Feb. 07 - Beg
			// Handling STEREOTYPE_NAME_APPEARANCE preference (from ProfileApplicationPreferencePage)
			// Previously lowercase forced onto first letter (standard UML)
			// stereotypesToDisplay = stereotypesToDisplay+name.substring(0, 1).toLowerCase()+name.substring(1, name.length())+","+separator;

			if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
				out = out + name + "," + separator;
			} else if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM)) {
				out = out + name.substring(0, 1).toLowerCase() + name.substring(1, name.length()) + "," + separator;
			} else { // should not happen since radio button are used to set choice
				out = out + name.substring(0, 1).toLowerCase() + name.substring(1, name.length()) + "," + separator;
			}
		}
		return stereotypesToDisplay;
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

}
