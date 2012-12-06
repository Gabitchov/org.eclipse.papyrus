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
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.tools.ToolUtilities;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.swt.dnd.DND;

/**
 * An abstract implementation of a DropStrategy, which provides helper methods
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractDropStrategy implements DropStrategy {

	/**
	 * Returns the Semantic element which is the drop target
	 * 
	 * @param targetEditPart
	 *        The drop target edit part
	 * @return
	 *         The drop target semantic element
	 */
	protected EObject getTargetSemanticElement(EditPart targetEditPart) {
		return EMFHelper.getEObject(targetEditPart);
	}

	/**
	 * Returns the Notation View which is the drop target
	 * 
	 * @param targetEditPart
	 *        The drop target edit part
	 * @return
	 *         The drop target notation View
	 */
	protected View getTargetView(EditPart targetEditPart) {
		return NotationHelper.findView(targetEditPart);
	}

	/**
	 * Returns the list of selected objects. The objects can be of any type.
	 * 
	 * @param request
	 *        The drop request
	 * @return
	 *         The list of dropped Objects
	 */
	protected List<Object> getSourceObjects(Request request) {
		List<Object> result = new LinkedList<Object>();
		if(request instanceof DropObjectsRequest) {
			List objects = ((DropObjectsRequest)request).getObjects();
			if(objects != null) {
				result.addAll(objects);
			}
		} else if(request instanceof GroupRequest) {
			List editParts = ((ChangeBoundsRequest)request).getEditParts();
			if(editParts != null) {
				result.addAll(editParts);
			}
		}
		return result;
	}

	/**
	 * Returns the list of semantic EObjects being dropped. If some of the dropped elements
	 * cannot be resolved to EObjects, they are ignored.
	 * 
	 * @param request
	 *        The drop request
	 * @return
	 *         The list of dropped EObjects
	 */
	protected List<EObject> getSourceEObjects(Request request) {
		List<EObject> result = new LinkedList<EObject>();

		for(Object object : getSourceObjects(request)) {
			EObject eObject = EMFHelper.getEObject(object);
			if(eObject instanceof View) {
				eObject = ((View)eObject).getElement();
			}

			if(eObject != null) {
				result.add(eObject);
			}
		}

		return result;
	}

	/**
	 * Returns a DropObjectsRequest corresponding to the given request,
	 * or null is such an operation is not possible.
	 * 
	 * @param request
	 * @return
	 */
	protected DropObjectsRequest getDropObjectsRequest(Request request) {
		if(request instanceof DropObjectsRequest) {
			return (DropObjectsRequest)request;
		}

		//Adapted from org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#castToDropObjectsRequest
		if(request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;
			Iterator<EditPart> editParts = ToolUtilities.getSelectionWithoutDependants(changeBoundsRequest.getEditParts()).iterator();

			List<EObject> elements = new LinkedList<EObject>();
			while(editParts.hasNext()) {
				EditPart editPart = editParts.next();
				if(editPart instanceof IGraphicalEditPart) {
					EObject element = ViewUtil.resolveSemanticElement((View)((IGraphicalEditPart)editPart).getModel());
					if(element != null) {
						elements.add(element);
					}
				}
			}

			DropObjectsRequest req = new DropObjectsRequest();
			req.setObjects(elements);
			req.setAllowedDetail(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
			req.setLocation(changeBoundsRequest.getLocation());
			req.setRequiredDetail(DND.DROP_COPY); //FIXME: Handle drop links (DND.DROP_LINK)
			return req;
		}

		return null;
	}
}
