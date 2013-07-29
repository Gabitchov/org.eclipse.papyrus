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

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AppliedStereotypeCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.ICompartmentLayoutHelper;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.Element;

/**
 * This UML edit part that can manage node and compartments. It also manages the
 * application of stereotypes on UML elements represented by nodes
 * 
 */
public abstract class UMLNodeEditPart extends NodeEditPart implements IUMLEditPart {

	/**
	 * Save the fontDescriptor in order to dispose the font later
	 */
	private FontDescriptor cachedFontDescriptor;

	/** helper use to change the layout of compartment if exist **/
	private ICompartmentLayoutHelper compartmentLayoutHelper;

	/**
	 * @return the compartmentLayoutHelper
	 */
	protected ICompartmentLayoutHelper getCompartmentLayoutHelper() {
		return compartmentLayoutHelper;
	}

	/**
	 * @param compartmentLayoutHelper
	 *        the compartmentLayoutHelper to set
	 */
	protected void setCompartmentLayoutHelper(ICompartmentLayoutHelper compartmentLayoutHelper) {
		this.compartmentLayoutHelper = compartmentLayoutHelper;
	}

	/**
	 * Creates a new UmlNodeEditPart.
	 * 
	 * @param view
	 *        the view controlled by this edit part
	 */
	public UMLNodeEditPart(View view) {
		super(view);
	}

	@Override
	public void refresh() {
		super.refresh();
		changeLayoutCompartment();
		fixCompartmentTitleVisibility();
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getUMLElement() {
		return (Element)resolveSemanticElement();
	}

	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if(!(childFigure instanceof AppliedStereotypeCompartmentFigure)) {
			getContentPaneFor((IGraphicalEditPart)child).setConstraint(childFigure, constraint);
		}
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
		// adds the stereotype application edit policy
		installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
	}

	/**
	 * this method has in charge to apply the good layout policy on compartments
	 */
	protected void changeLayoutCompartment() {
		if(getCompartmentLayoutHelper() != null) {
			Iterator<EditPart> childrenIterator = getChildren().iterator();
			while(childrenIterator.hasNext()) {
				EditPart currentEditPart = childrenIterator.next();
				if(currentEditPart instanceof ListCompartmentEditPart) {
					getCompartmentLayoutHelper().applyLayout((ListCompartmentEditPart)currentEditPart);
				}
			}
		}
	}

	/**
	 * Models created with Papyrus 0.7.x do not have a TitleStyle in the
	 * compartment views. In this case, the GMF code does not touch the
	 * visibility of the title, i.e. it remains true by default. This does not
	 * correspond to the diagrams in Papyrus 0.7.x having no title visible. See
	 * bug 351084
	 */
	public void fixCompartmentTitleVisibility() {
		for(Object currentEditPart : getChildren()) {
			if(currentEditPart instanceof ResizableCompartmentEditPart) {
				ResizableCompartmentEditPart rcep = (ResizableCompartmentEditPart)currentEditPart;
				View compartmentView = (View)rcep.getModel();
				Style titleStyle = compartmentView.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
				if(titleStyle == null) {
					if(rcep.getFigure() instanceof ResizableCompartmentFigure) {
						ResizableCompartmentFigure rcf = (ResizableCompartmentFigure)rcep.getFigure();
						rcf.setTitleVisibility(false);
					}
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
	 * Refresh the font. This method shouldn't be overriden by subclasses. To
	 * refresh labels font, the method refreshLabelsFont should be used. {@inheritDoc}
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
	 * A method to specify the labels to be update when the font is refreshed.
	 * Subclasses should call super.refreshLabelsFont(font)
	 * 
	 * @param font
	 *        the font to use
	 */
	protected void refreshLabelsFont(Font font) {
		if(((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel() != null) {
			((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel().setFont(font);
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
		return new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setFontColor(Color color) {
		super.setFontColor(color);
		if(((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel() != null) {
			((IPapyrusNodeUMLElementFigure)getPrimaryShape()).getStereotypesLabel().setForegroundColor(color);
		}
	}

}
