/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.actions.gmf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.CreateShapeViewAction;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @see CreateShapeViewAction
 * 
 *      We create the note, with a white background
 * 
 */
public class CustomCreateShapeViewAction extends CreateShapeViewAction {

	public static final String ActionId = "customAddNoteLinkAction"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 * @param actionId
	 * @param semanticHint
	 * @param label
	 * @param imageDescriptor
	 */
	public CustomCreateShapeViewAction(IWorkbenchPage workbenchPage, String actionId, String semanticHint, String label, ImageDescriptor imageDescriptor) {
		super(workbenchPage, actionId, semanticHint, label, imageDescriptor);
	}


	/**
	 * Selects the newly added shape view(s) by default.
	 */
	@Override
	protected void selectAddedObject() {
		Object result = ((CreateRequest)getTargetRequest()).getNewObject();
		if(!(result instanceof Collection)) {
			return;
		}
		final List editparts = new ArrayList(1);

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
		if(viewer == null) {
			return;
		}

		Map editpartRegistry = viewer.getEditPartRegistry();
		for(Iterator iter = ((Collection)result).iterator(); iter.hasNext();) {
			Object viewAdaptable = iter.next();
			if(viewAdaptable instanceof IAdaptable) {
				Object editPart = editpartRegistry.get(((IAdaptable)viewAdaptable).getAdapter(View.class));
				if(editPart != null)
					editparts.add(editPart);
			}
		}

		if(!editparts.isEmpty()) {
			viewer.setSelection(new StructuredSelection(editparts));

			// automatically put the first shape into edit-mode
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					EditPart editPart = (EditPart)editparts.get(0);
					ChangePropertyValueRequest request = new ChangePropertyValueRequest("Fill Color", "notation.FillStyle.fillColor"); //$NON-NLS-1$ //$NON-NLS-2$
					request.setType("property_change"); //$NON-NLS-1$
					RGB rgb = new RGB(255, 255, 255);
					request.setValue(FigureUtilities.RGBToInteger(rgb));
					editPart.performRequest(request);
					editPart.performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
				}
			});
		}
	}
}
