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

import com.google.common.collect.Multimap;

public interface IGroupRequest {

	public static enum GroupRequestType {
		/**
		 * Refer to an creation event
		 */
		CREATION,
		/**
		 * Refer to an move(and or resize) event
		 */
		MOVE,
		/**
		 * Refresh groups request
		 */
		REFRESH
	}

	public static String INITIAL_TARGET_REQUEST_NEW_BOUNDS = "GroupFramework_InitialTargetRequestNewBounds";////$NON-NLS-1$

	public GroupRequestType getGroupRequestType();

	public IGraphicalEditPart getHostRequest();

	public Request getInitialRequest();

	public IAdaptable getTargetElement();

	/**
	 * Get the label of the request
	 * 
	 * @return
	 */
	public String getLabel();

	public IContainerNodeDescriptor getNodeDescpitor();

	//	/**
	//	 * Get the absolute bounds of the initial target.
	//	 * For example for changeBoudnsRequest in group. This will represent the bounds of the group after the bounds have changed
	//	 * @return
	//	 */
	//	public Rectangle getIntialTargetAbsoluteBounds();
	//	/**
	//	 * Set the absolute bounds of the initial target.
	//	 * For example for changeBoudnsRequest in group. This will represent the bounds of the group after the bounds have changed
	//	 * @return
	//	 */
	//	public void setIntialTargetAbsoluteBounds(Rectangle bounds);
	/**
	 * Map which link an An Reference to it's values
	 * 
	 * @return
	 */
	public Multimap<EReference, EObject> getParentEReferenceMap();

	/**
	 * Map which link an EObject to its {@link EReference} of the current target
	 * 
	 * @return
	 */
	public Multimap<EReference, EObject> getChildrenEReferenceMap();
}
