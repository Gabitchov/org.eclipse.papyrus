/*****************************************************************************
 * Copyright (c) 2008-2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Style implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.appearance.helper.ShadowFigureHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.StyleEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.FillStyleProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.FontStyleProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.LineStyleProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;

/**
 * this uml edit part can refresh shadow and gradient.
 */
//TODO: Move this EditPart to infra.gmfdiag.common
//TODO: Move IPapyrusNodeFigure to infra.gmfdiag.common
//TODO: Move ShadowFigureHelper to infra.gmfdiag.common
public abstract class NodeEditPart extends AbstractBorderedShapeEditPart implements IPapyrusEditPart, IStylableEditPart {

	public NodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected NodeFigure createMainFigure() {
		return createNodeFigure();
	}

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public abstract IPapyrusNodeFigure getPrimaryShape();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supportsGradient() {
		return true;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// Update the figure when the line width changes
		Object feature = event.getFeature();
		if((getModel() != null) && (getModel() == event.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} else if(NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
				refreshLineType();
			}
		}

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshShadow();
		}
	}

	@Override
	public void activate() {
		super.activate();
	}

	@Override
	protected void setLineWidth(int width) {
		if(width < 0) {
			width = 1;
		}
		getPrimaryShape().setLineWidth(width);
	}

	@Override
	protected void setLineType(int style) {
		getPrimaryShape().setLineStyle(style);
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *        the new value of the back ground color
	 */
	@Override
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
		IPapyrusNodeFigure fig = getPrimaryShape();
		if(gradient != null) {
			fig.setIsUsingGradient(true);
			fig.setGradientData(getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * sets the font color
	 * 
	 * @param color
	 *        the new value of the font color
	 */
	@Override
	protected void setFontColor(Color color) {
		// NULL implementation
	}

	/**
	 * sets the fore ground color of this edit part's figure
	 * 
	 * @param color
	 *        the new value of the foregroundcolor
	 */
	@Override
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setForegroundColor(color);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshShadow();
		refreshLineType();
		refreshLineWidth();
		refreshFontColor();
	}

	//Style Implementation

	@Override
	protected final void refreshBackgroundColor() {
		if(supportsGradient()) {
			GradientData gradient = getGradient();
			if(gradient != null) {
				setGradient(gradient);
				return;
			}
		}

		setBackgroundColor(DiagramColorRegistry.getInstance().getColor(getFillColor()));
	}

	protected int getFillColor() {
		FillStyleProvider provider = (FillStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getFillStyle());
		if(provider == null) {
			return ((FillStyle)getNotationView().getStyle(NotationPackage.eINSTANCE.getFillStyle())).getFillColor();
		}
		return provider.getFillColor();
	}

	protected GradientData getGradient() {
		FillStyleProvider provider = (FillStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getFillStyle());
		if(provider == null) {
			return ((FillStyle)getNotationView().getStyle(NotationPackage.eINSTANCE.getFillStyle())).getGradient();
		}
		return provider.getGradient();
	}

	/**
	 * Refresh the shadow of the figure
	 */
	protected final void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View)getModel()));
	}

	//	@Override
	//	protected final void refreshLineType() {
	//
	//	}
	//
	//	@Override
	//	protected final void refreshLineWidth() {
	//
	//	}
	//

	@Override
	protected final void refreshForegroundColor() {
		LineStyleProvider provider = (LineStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getLineStyle());

		if(provider == null) {
			super.refreshForegroundColor();
			return;
		}

		setForegroundColor(DiagramColorRegistry.getInstance().getColor(Integer.valueOf(provider.getLineColor())));
	}


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

	//	@Override
	//	protected final void refreshBounds() {
	//
	//	}
	//
	//	@Override
	//	protected final void refreshVisibility() {
	//
	//	}

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
