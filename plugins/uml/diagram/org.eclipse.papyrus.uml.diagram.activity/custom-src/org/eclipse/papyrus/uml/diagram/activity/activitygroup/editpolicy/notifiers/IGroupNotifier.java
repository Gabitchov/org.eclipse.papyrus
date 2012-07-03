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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;

/**
 * This interface represent an element that can notify to the group framework some changes that may impact Activity groups
 * 
 * @author arthur daussy
 * 
 */
public interface IGroupNotifier extends IAdaptable, EditPolicy, Comparable<IGroupNotifier> {

	/**
	 * Get the {@link EObject} which is the notifier
	 * 
	 * @return
	 */
	public EObject getEObject();

	/**
	 * 
	 * @return {@link IContainerNodeDescriptor} of the notifier
	 */
	public abstract IContainerNodeDescriptor getHostGroupDescriptor();

	/**
	 * 
	 * @return {@link IContainerNodeDescriptor} of the target
	 */
	public abstract IContainerNodeDescriptor getTargetGroupDescriptor(IAdaptable eObjectAdapter);

	/**
	 * Get the view of the notifier
	 * 
	 * @return {@link IAdaptable} of the view of the element
	 */
	public abstract IAdaptable getAdaptableView();

	/**
	 * Get the {@link IGraphicalEditPart} host
	 * (Sam as than getHost() but with GMF)
	 * 
	 * @return
	 */
	public IGraphicalEditPart getHostEditPart();

	/**
	 * Return true if the element is included on the specified bounds
	 * This method should take into account if the node is currently moving or not
	 * 
	 * @param bounds
	 *        {@link Rectangle} in which the element is tested
	 * @return
	 */
	public boolean isIncludedIn(Rectangle bounds);

	/**
	 * Return true if the specified bounds are included in the bounds of the element.
	 * This method should take into account if the node is currently moving or not
	 * 
	 * @param bounds
	 * @return
	 */
	public boolean includes(Rectangle bounds);

	/**
	 * Notify edit policy that edit part start to move
	 * This method represent a state of the edit part
	 * 
	 * @param request
	 */
	public void startMoving(ChangeBoundsRequest request);

	/**
	 * Notify edit policy that edit part stop moving
	 * This method represent a state of the edit part
	 */
	public void stopMoving();

	/**
	 * Return true if the part is moving
	 * 
	 * @return
	 */
	public boolean isPartMoving();
}
