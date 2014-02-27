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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.FollowSVGSymbolEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.NameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this editpart manage the font and icon of the name label and qualified name
 * label.
 * 
 */
public abstract class NamedElementEditPart extends UMLNodeEditPart implements IUMLNamedElementEditPart {

	/**
	 * CSS boolean property controlling whether stereotypes should be displayed
	 */
	public static final String DISPLAY_STEREOTYPES = "displayStereotypes";

	/**
	 * CSS boolean property controlling whether tags should be displayed
	 */
	public static final String DISPLAY_TAGS = "displayTags";


	/**
	 * {@inheritDoc}
	 */
	public NamedElementEditPart(View view) {
		super(view);
	}

	public NamedElement getNamedElement() {
		return (NamedElement)getUMLElement();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshIconNamedLabel();
			refreshFontColor();
		}
	}

	private void refreshIconNamedLabel() {
		getNodeNamedElementFigure().setNameLabelIcon(AppearanceHelper.showElementIcon((View)getModel()));
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		if(getNodeNamedElementFigure() != null && resolveSemanticElement() != null) {
			refreshIconNamedLabel();
			refreshFontColor();
			refreshLabelDisplay();
		}
	}

	@Override
	public void activate() {
		super.activate();
	}


	protected void refreshLabelDisplay() {
		View view = getNotationView();
		BooleanValueStyle displayNameStyle = (BooleanValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), NameDisplayEditPolicy.DISPLAY_NAME);
		BooleanValueStyle displayStereotypes = (BooleanValueStyle) view.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_STEREOTYPES);
		BooleanValueStyle displayTags = (BooleanValueStyle) view.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_TAGS);
		if(displayNameStyle != null && !displayNameStyle.isBooleanValue()) {
			getNodeNamedElementFigure().removeNameLabel();
			getNodeNamedElementFigure().removeStereotypeLabel();
			getNodeNamedElementFigure().removeTaggedLabel();
		} else {
			getNodeNamedElementFigure().restoreNameLabel();
			if (displayStereotypes != null && !displayStereotypes.isBooleanValue()) {
				getNodeNamedElementFigure().removeStereotypeLabel();
			} else {
				getNodeNamedElementFigure().restoreStereotypeLabel();
			}
			if (displayTags != null && !displayTags.isBooleanValue()) {
				getNodeNamedElementFigure().removeTaggedLabel();
			} else {
				getNodeNamedElementFigure().restoreTaggedLabel();
			}
		}
	}



	/**
	 * A method to specify the labels to be update when the font is refreshed.
	 * Subclasses should call super.refreshLabelsFont(font)
	 * 
	 * @param font
	 *        the font to use
	 */
	@Override
	protected void refreshLabelsFont(Font font) {
		super.refreshLabelsFont(font);
		// Apply the font to the Name Label
		getNodeNamedElementFigure().getNameLabel().setFont(font);
		// Apply the font to the Qualified Name
		if(getNodeNamedElementFigure().getQualifiedNameLabel() != null) {
			getNodeNamedElementFigure().getQualifiedNameLabel().setFont(font);
		}
		// Apply the font to the tagged Label
		if(getNodeNamedElementFigure().getTaggedLabel() != null) {
			getNodeNamedElementFigure().getTaggedLabel().setFont(font);
		}
	}

	private IPapyrusNodeNamedElementFigure getNodeNamedElementFigure() {
		return (IPapyrusNodeNamedElementFigure)getPrimaryShape();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void setFontColor(Color color) {
		super.setFontColor(color);
		// Qualified Name
		if(getNodeNamedElementFigure().getQualifiedNameLabel() != null) {
			getNodeNamedElementFigure().getQualifiedNameLabel().setForegroundColor(color);
		}
		// TaggedLabel
		if(getNodeNamedElementFigure().getTaggedLabel() != null) {
			getNodeNamedElementFigure().getTaggedLabel().setForegroundColor(color);
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(NameDisplayEditPolicy.NAME_DISPLAY_EDITPOLICY, new NameDisplayEditPolicy());
		installEditPolicy(FollowSVGSymbolEditPolicy.FOLLOW_SVG_SYMBOL_EDITPOLICY, new FollowSVGSymbolEditPolicy());
	}

	@Override
	protected NodeFigure createNodeFigure() {
		return new BorderedNodeFigure(createMainFigureWithSVG());
	}



}
