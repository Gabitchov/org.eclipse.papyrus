/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.request;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.Utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public abstract class AbstractGroupRequest extends Request implements IGroupRequest {

	protected IGraphicalEditPart host;

	protected Request request;

	protected IAdaptable target;

	protected IContainerNodeDescriptor nodeDescriptor;

	/**
	 * Map to link to a parent with a EReference
	 */
	private Multimap<EReference, EObject> eParentRefenceMap;

	/**
	 * Map to link to a child with {@link EReference}
	 */
	private Multimap<EReference, EObject> eChildrenRefenceMap;

	public AbstractGroupRequest(IGraphicalEditPart host, Request request, IAdaptable target, IContainerNodeDescriptor nodeDescriptor) {
		super();
		this.host = host;
		this.request = request;
		this.target = target;
		this.nodeDescriptor = nodeDescriptor;
	}

	public IGraphicalEditPart getHostRequest() {
		return host;
	}

	public Request getInitialRequest() {
		return request;
	}

	public IContainerNodeDescriptor getNodeDescpitor() {
		return nodeDescriptor;
	}

	public IAdaptable getTargetElement() {
		return target;
	}

	public String getLabel() {
		StringBuilder builder = new StringBuilder(" IGroupRequest :\n \t Request : ").append(request).append("\n \t Target : ");
		Object eObject = getTargetElement().getAdapter(EObject.class);
		if(eObject instanceof EObject) {
			return "";
		}
		builder.append(Utils.getCorrectLabel((EObject)eObject));
		builder.append("\n \t Host :").append(Utils.getCorrectLabel(getHostRequest()));
		builder.append("\n \t Type :").append(getGroupRequestType());
		return builder.toString();
	}

	//	/**
	//	 * Get the absolute bounds of the initial target.
	//	 * For example for changeBoudnsRequest in group. This will represent the bounds of the group after the bounds have changed
	//	 * 
	//	 * @return
	//	 */
	//	public Rectangle getIntialTargetAbsoluteBounds() {
	//		@SuppressWarnings("rawtypes")
	//		Map metadata = request.getExtendedData();
	//		if(metadata != null) {
	//			Object bounds_ = metadata.get((Object)INITIAL_TARGET_REQUEST_NEW_BOUNDS);
	//			if(bounds_ instanceof Rectangle) {
	//				Rectangle bounds = (Rectangle)bounds_;
	//				return bounds;
	//			}
	//		}
	//		return null;
	//	}
	//	/**
	//	 * Set the absolute bounds of the initial target.
	//	 * For example for changeBoudnsRequest in group. This will represent the bounds of the group after the bounds have changed
	//	 * 
	//	 * @return
	//	 */
	//
	//	public void setIntialTargetAbsoluteBounds(Rectangle bounds) {
	//		Map metadata = request.getExtendedData();
	//		if(bounds == null) {
	//			return;
	//		}
	//		if(metadata != null) {
	//			Object oldsBounds = metadata.put((Object)INITIAL_TARGET_REQUEST_NEW_BOUNDS, bounds);
	//			if(DebugUtils.isDebugging()) {
	//				DebugUtils.getLog().debug("The absolute bounds of " + Utils.getCorrectLabel(getTargetElement()) + " went from " + oldsBounds + " to " + bounds);
	//			}
	//		}
	//	}
	public Multimap<EReference, EObject> getParentEReferenceMap() {
		if(eParentRefenceMap == null) {
			eParentRefenceMap = ArrayListMultimap.create();
		}
		return this.eParentRefenceMap;
	}

	public Multimap<EReference, EObject> getChildrenEReferenceMap() {
		if(eChildrenRefenceMap == null) {
			eChildrenRefenceMap = ArrayListMultimap.create();
		}
		return this.eChildrenRefenceMap;
	}
}
