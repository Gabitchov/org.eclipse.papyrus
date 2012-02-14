/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.StyleEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.FontStyleProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;


public abstract class PapyrusCompartmentEditPart extends CompartmentEditPart implements IStylableEditPart {

	public PapyrusCompartmentEditPart(EObject model) {
		super(model);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFont();
		refreshFontColor();
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
