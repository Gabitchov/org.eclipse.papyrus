/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * This is an abstract edit-part to manage a constraint
 * (1) Automatically changes to context link tool after first creation. Since this class needs
 * diagram-specific UMLElementType information, the constraint edit part of diagram must
 * implement function "elementTypeOfToolAfterCreation"
 * (2) Does not filter direct-edit requests in function of selected (sub-) edit part
 */
@SuppressWarnings("restriction")
public abstract class AbstractConstraintEditPart extends NamedElementEditPart {

	private static final String SPECIFICATION = "specification"; //$NON-NLS-1$

	protected static final String CONSTRAINT_VALUE_SPECIFICATION_LISTENER = "Constraint_valueSpecification_Listener"; //$NON-NLS-1$

	public AbstractConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * assure that a specification change gets handled by the constraint body.
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() instanceof ENamedElement) {
			if (((ENamedElement) event.getFeature()).getName().equals(SPECIFICATION)) {
				GraphicalEditPart gef = (GraphicalEditPart) getChildren().get(1);
				gef.notifyChanged(event);
			}
		}
		super.handleNotificationEvent(event);
	}

	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		EObject semanicElement = resolveSemanticElement();
		if (semanicElement instanceof Constraint) {
			ValueSpecification vs = ((Constraint) semanicElement).getSpecification();
			// delegate to constraint-body, will refresh listeners by removing and adding semantic listeners again
			addListenerFilter(SPECIFICATION, this, vs);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NodeEditPart#getPrimaryShape()
	 */
	@Override
	public IPapyrusNodeFigure getPrimaryShape() {
		return new ConstraintFigure();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refreshLabelsFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	protected void refreshLabelsFont(Font font) {
		super.refreshLabelsFont(font);
		if (getPrimaryShape() instanceof ConstraintFigure) {
			((ConstraintFigure) getPrimaryShape()).getTextFlow().setFont(font);
		}
	}

	@Override
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (style != null) {
			if (style.getGradient() == null || !supportsGradient()) {
				setBackgroundColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getFillColor())));
			} else {
				setGradient(style.getGradient());
			}
		}
	}

	/**
	 * Refresh figure's background transparency.
	 * 
	 * @since 1.2
	 */
	@Override
	protected void refreshTransparency() {
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (style.getGradient() != null) {
			setTransparency(style.getTransparency());
		} else {
			setTransparency(0);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#setFontColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	protected void setFontColor(Color color) {
		super.setFontColor(color);
		if (getPrimaryShape() instanceof ConstraintFigure) {
			((ConstraintFigure) getPrimaryShape()).getPageFlow().setForegroundColor(color);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performDirectEditRequest(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
		if (resolveSemanticElement() instanceof Constraint) {
			Constraint constraint = (Constraint) resolveSemanticElement();
			if (first && constraint.getContext() == null) {
				first = false;
				// instead of editing, open link element tool
				List<IElementType> elementTypes = new ArrayList<IElementType>();
				if (elementTypeOfToolAfterCreation() != null) {
					elementTypes.add(elementTypeOfToolAfterCreation());
					AspectUnspecifiedTypeConnectionTool tool = new AspectUnspecifiedTypeConnectionTool(elementTypes);
					getEditDomain().setActiveTool(tool);
					tool.setSourceEditPart(this);
					return;
				}
			}
		}
		EditPart editPart = this;
		// suppress condition based on selected edit part, always edit.
		try {
			editPart = (EditPart) getEditingDomain().runExclusive(
					new RunnableWithResult.Impl<Object>() {

						public void run() {
							// edit body, which can be found in 2nd child, instead of default action (first child)
							setResult(getChildren().get(1));
						}
					});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(),
					DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "performDirectEditRequest", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(),
					DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "performDirectEditRequest", e); //$NON-NLS-1$
		}
		if (editPart != null) {
			editPart.performRequest(request);
		}
	}

	/**
	 * @return the element type corresponding to the tool that should be used after creation, needs to be sub-classed.
	 */
	protected IElementType elementTypeOfToolAfterCreation() {
		return null;
	}

	protected boolean first = true;

}
