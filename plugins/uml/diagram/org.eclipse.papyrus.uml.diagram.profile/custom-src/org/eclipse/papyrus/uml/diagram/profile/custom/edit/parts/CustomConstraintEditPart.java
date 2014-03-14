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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Constraint;

/**
 * Custom variant. Automatically changes to context link tool.
 */
@SuppressWarnings("restriction")
public class CustomConstraintEditPart extends ConstraintEditPart {

	protected boolean first = true;
	
	public CustomConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performDirectEditRequest(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
		if (resolveSemanticElement() instanceof Constraint) {
			Constraint constraint = (Constraint) resolveSemanticElement();
			if (first && constraint.getContext() == null)  {
				first = false;
				// instead of editing, open link element tool
				List<IElementType> elementTypes = new ArrayList<IElementType>();
				elementTypes.add(UMLElementTypes.ConstraintContext_8500);
				getEditDomain().setActiveTool(new AspectUnspecifiedTypeConnectionTool(elementTypes));
				return;
			}
		}
		EditPart editPart = this;
		if (request instanceof DirectEditRequest){
			Point p = new Point(((DirectEditRequest)request).getLocation());
			getFigure().translateToRelative(p);
			IFigure fig = getFigure().findFigureAt(p);
			editPart =(EditPart) getViewer().getVisualPartMap().get(fig);
		}
		if (editPart == this) {
			try {
				editPart = (EditPart) getEditingDomain().runExclusive(
					new RunnableWithResult.Impl() {

						public void run() {
							// edit body, which can be found in 2nd child, instead of default action (first child)
							setResult(getChildren().get(1));
						}
					});
			} catch (InterruptedException e) {
				Trace.catching(DiagramUIPlugin.getInstance(),
					DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(),
					"performDirectEditRequest", e); //$NON-NLS-1$
				Log.error(DiagramUIPlugin.getInstance(),
					DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING,
					"performDirectEditRequest", e); //$NON-NLS-1$
			}
			if (editPart != null){
				editPart.performRequest(request);
			}
		}
	}
}
