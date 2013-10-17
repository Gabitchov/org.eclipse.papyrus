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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DeselectAllTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.RubberbandDragTracker;
import org.eclipse.gmf.runtime.notation.View;

/**
 * this is an abstract editpart used to allow double click on XY layout compartment
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractPackageableElementCompartmentEditPart extends ShapeCompartmentEditPart {

	public AbstractPackageableElementCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart#getDragTracker(org.eclipse.gef.Request)
	 * 
	 */
	public DragTracker getDragTracker(Request req) {
		if(!supportsDragSelection())
			return super.getDragTracker(req);
		if(req instanceof SelectionRequest && ((SelectionRequest)req).getLastButtonPressed() == 3)
			return new DeselectAllTracker(this) {

				protected boolean handleButtonDown(int button) {
					getCurrentViewer().select(AbstractPackageableElementCompartmentEditPart.this);
					return true;
				}
			};
		return new RubberbandDragTracker() {

			/*
			 * this method has been respecified in order to allow double click
			 * on the compartment.
			 * hence it allows the navigation by double click
			 */
			protected boolean handleDoubleClick(int button) {
				SelectionRequest request = new SelectionRequest();
				request.setLocation(getLocation());
				request.setType(RequestConstants.REQ_OPEN);
				AbstractPackageableElementCompartmentEditPart.this.performRequest(request);
				return true;
			}

			protected void handleFinished() {
				if(getViewer().getSelectedEditParts().isEmpty())
					getViewer().select(AbstractPackageableElementCompartmentEditPart.this);
			}
		};
	}
}
