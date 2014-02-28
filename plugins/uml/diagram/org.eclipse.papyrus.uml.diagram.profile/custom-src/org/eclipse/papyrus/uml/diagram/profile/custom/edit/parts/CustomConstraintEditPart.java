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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;

/**
 * @generated
 */
@SuppressWarnings("restriction")
public class CustomConstraintEditPart extends ConstraintEditPart {

	public CustomConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performDirectEditRequest(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
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
