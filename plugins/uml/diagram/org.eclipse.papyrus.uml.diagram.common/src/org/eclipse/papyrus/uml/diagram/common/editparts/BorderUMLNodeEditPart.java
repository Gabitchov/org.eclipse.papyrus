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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.ICompartmentLayoutHelper;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.Element;

/**
 * <pre>
 * Abstract EditPart supporting :
 *  - node and compartments management
 *  - stereotype application
 * Similar implementation to {@link UMLNodeEditPart} but inheriting indirectly from {@link BorderedBorderItemEditPart}
 * in order to provide support for Affixed Child nodes.
 * </pre>
 */
public abstract class BorderUMLNodeEditPart extends BorderNodeEditPart implements IUMLEditPart {

	/** FontDescriptor saved in order to dispose the font later */
	private FontDescriptor cachedFontDescriptor;

	/** Helper used to change compartment layout when existing **/
	private ICompartmentLayoutHelper compartmentLayoutHelper;

	/**
	 * Get the compartment layout.
	 * 
	 * @return the compartmentLayoutHelper
	 */
	protected ICompartmentLayoutHelper getCompartmentLayoutHelper() {
		return compartmentLayoutHelper;
	}

	/**
	 * Set the compartment layout.
	 * 
	 * @param compartmentLayoutHelper
	 *        the compartmentLayoutHelper to set
	 */
	protected void setCompartmentLayoutHelper(ICompartmentLayoutHelper compartmentLayoutHelper) {
		this.compartmentLayoutHelper = compartmentLayoutHelper;
	}

	/**
	 * Constructor.
	 * 
	 * @param view
	 *        the view controlled by this edit part
	 */
	public BorderUMLNodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		super.refresh();

		changeLayoutCompartment();
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getUMLElement() {
		return (Element)resolveSemanticElement();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		if(event.getNotifier() instanceof EAnnotation) {
			if(VisualInformationPapyrusConstants.LAYOUTFIGURE.equals(((EAnnotation)event.getNotifier()).getSource())) {
				changeLayoutCompartment();
			}
		}

		Object feature = event.getFeature();
		if(NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			refreshFontColor();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// Add the stereotype application edit policy
		installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
	}

	/**
	 * this method has in charge to apply the good layout policy on compartments
	 */
	protected void changeLayoutCompartment() {
		if(getCompartmentLayoutHelper() != null) {
			Iterator<?> childrenIterator = getChildren().iterator();
			while(childrenIterator.hasNext()) {
				EditPart currentEditPart = (EditPart)childrenIterator.next();
				if(currentEditPart instanceof ListCompartmentEditPart) {
					getCompartmentLayoutHelper().applyLayout((ListCompartmentEditPart)currentEditPart);
				}
			}
		}
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
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		refreshShadow();
		refreshFontColor();
	}

	/**
	 * <pre>
	 * Refresh used font. This method should not be overridden by subclasses. 
	 * To refresh labels font, the method refreshLabelsFont should be used. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void refreshFont() {
		FontStyle style = (FontStyle)getPrimaryView().getStyle(NotationPackage.Literals.FONT_STYLE);
		if(style != null) {
			// Get the font
			FontDescriptor fontDescriptor = FontDescriptor.createFrom(getFontData(style));
			Font newFont = getResourceManager().createFont(fontDescriptor);

			refreshLabelsFont(newFont);

			// Dispose previous Font and FontDescriptor
			if(cachedFontDescriptor != null) {
				getResourceManager().destroyFont(cachedFontDescriptor);
			}
			cachedFontDescriptor = fontDescriptor;
		}
	}

	/**
	 * <pre>
	 * A method to specify the labels to be update when the font is refreshed. 
	 * Subclasses should call super.refreshLabelsFont(font).
	 * </pre>
	 * 
	 * @param font
	 *        the font to use
	 */
	protected void refreshLabelsFont(Font font) {
		Label stereotypesLabel = ((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel();
		if(stereotypesLabel != null) {
			stereotypesLabel.setFont(font);
		}
	}

	/**
	 * Get the fontData
	 * 
	 * @param style
	 *        the font style of the figure
	 * @return the new font data to use
	 */
	protected FontData getFontData(FontStyle style) {
		return new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setFontColor(Color color) {
		super.setFontColor(color);

		Label stereotypesLabel = ((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel();
		if(stereotypesLabel != null) {
			stereotypesLabel.setForegroundColor(color);
		}
	}

}
