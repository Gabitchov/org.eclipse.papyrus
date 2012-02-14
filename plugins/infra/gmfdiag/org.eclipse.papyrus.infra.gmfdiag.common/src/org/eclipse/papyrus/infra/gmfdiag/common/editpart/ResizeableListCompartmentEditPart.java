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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.StyleEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.FontStyleProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

public abstract class ResizeableListCompartmentEditPart extends ListCompartmentEditPart implements IStylableEditPart {

	public ResizeableListCompartmentEditPart(EObject model) {
		super(model);
	}

	/**
	 * refresh the bounds
	 */
	protected void refreshBounds() {
		int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
		Dimension size = new Dimension(width, height);
		int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getSize_Width().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature) || NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {
			refreshBounds();
		}
		super.handleNotificationEvent(notification);
	}

	//Style support

	@Override
	protected void refreshFont() {
		FontStyle style = (FontStyle)getNotationView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			setFont(getFontData(style));
		}
	}

	/**
	 * Update the fontData
	 * 
	 * @param style
	 *        the font style of the figure
	 * @return the new font data to use
	 */
	protected FontData getFontData(FontStyle style) {
		FontStyleProvider provider = (FontStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getFontStyle());

		if(provider == null) {
			return new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
		}

		return new FontData(provider.getFontName(), provider.getFontHeight(), (provider.isBold() ? SWT.BOLD : SWT.NORMAL) | (provider.isItalic() ? SWT.ITALIC : SWT.NORMAL));
	}

	@Override
	protected final void refreshFontColor() {
		FontStyleProvider provider = (FontStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getFontStyle());
		if(provider == null) {
			super.refreshFontColor();
			return;
		}

		setFontColor(DiagramColorRegistry.getInstance().getColor(Integer.valueOf(provider.getFontColor())));
	}

	protected Object getStyleProvider(EClass styleClass) {
		Object styleEditPolicy = getEditPolicy(StyleEditPolicy.KEY);
		if(styleEditPolicy == null || !(styleEditPolicy instanceof StyleEditPolicy)) {
			return null;
		}

		Object styleProvider = ((StyleEditPolicy)styleEditPolicy).getStyle(styleClass);
		return styleProvider;
	}

}
