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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.ContainerNodeDescriptorRegistry;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.GroupRequestAdvisor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IGroupRequestAdvisor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.Utils;

/**
 * Edit policy use as based for Group Edit Policies
 * 
 * @author arthur daussy
 * 
 */
public abstract class GroupListenerEditPolicy extends GraphicalNodeEditPolicy implements IGroupNotifier {

	/**
	 * {@link IContainerNodeDescriptor} which describe the relation that the semantic element can handle
	 */
	private IContainerNodeDescriptor groupDescriptor;

	/**
	 * State of the part. Return true is the part is currently moving
	 */
	private boolean isMoving = false;

	/**
	 * Moving request
	 */
	private ChangeBoundsRequest movingRequest;

	/**
	 * Constructor
	 * 
	 * @param groupDescriptor
	 *        {@link IContainerNodeDescriptor} which describe the relation that the semantic element can handle
	 */
	public GroupListenerEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super();
		this.groupDescriptor = groupDescriptor;
	}

	/**
	 * {@inheritDoc IGroupNotifier#getEObject()}
	 */
	public EObject getEObject() {
		EditPart editPart = getHost();
		if(editPart instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)editPart).resolveSemanticElement();
		}
		return null;
	}

	/**
	 * Override to unregister this edit part from the group framework
	 */
	@Override
	public void deactivate() {
		GroupRequestAdvisor.getInstance().removeListenner(this);
		super.deactivate();
	}

	/**
	 * Override to register this edit part into the group framework
	 */
	@Override
	public void activate() {
		EObject resolveSemanticElement = getHostEditPart().resolveSemanticElement();
		if(resolveSemanticElement != null) {
			GroupRequestAdvisor.getInstance().addListenner(resolveSemanticElement, this);
		}
		super.activate();
	}

	/**
	 * {@inheritDoc IGroupNotifier#getGroupDescriptor()}
	 */
	public IContainerNodeDescriptor getHostGroupDescriptor() {
		return groupDescriptor;
	}

	/**
	 * {@inheritDoc IGroupNotifier#getGroupRequestAdvisor()}
	 */
	protected IGroupRequestAdvisor getGroupRequestAdvisor() {
		return GroupRequestAdvisor.getInstance();
	}

	/**
	 * {@inheritDoc IGroupNotifier#getHostEditPart()}
	 */
	public IGraphicalEditPart getHostEditPart() {
		return (IGraphicalEditPart)getHost();
	}

	/**
	 * {@inheritDoc IGroupNotifier#isIncludedIn()}
	 */
	public boolean isIncludedIn(Rectangle bounds) {
		Rectangle figureBounds = null;
		if(isMoving()) {
			figureBounds = Utils.getAbslotueRequestBounds(getMovingRequest(), getHostEditPart());
		} else {
			figureBounds = Utils.getAbsoluteBounds(getHostEditPart());
		}
		return bounds.contains(figureBounds);
	}

	/**
	 * {@inheritDoc IGroupNotifier#includes()}
	 */
	public boolean includes(Rectangle bounds) {
		if(getHost() == null) {
			return false;
		}
		IGraphicalEditPart compartmentEditPart = getHostGroupDescriptor().getCompartmentPartFromView(getHostEditPart());
		if(compartmentEditPart != null) {
			Rectangle figureBounds = null;
			if(isMoving()) {
				figureBounds = Utils.getAbslotueRequestBounds(getMovingRequest(), compartmentEditPart);
			} else {
				figureBounds = Utils.getAbsoluteBounds(compartmentEditPart);
			}
			return figureBounds.contains(bounds);
		}
		return false;
	}

	/**
	 * {@inheritDoc IAdaptable#getAdapter(Class)}
	 */
	public Object getAdapter(Class adapter) {
		if(IContainerNodeDescriptor.class.isAssignableFrom(adapter)) {
			return groupDescriptor;
		} else {
			return getHostEditPart().getAdapter(adapter);
		}
	}

	/**
	 * {@inheritDoc Comparable#compareTo(Object)}
	 */
	public int compareTo(IGroupNotifier o) {
		return getHostGroupDescriptor().compareTo(o.getHostGroupDescriptor());
	}

	/**
	 * {@inheritDoc IGroupNotifier#startMoving()}
	 */
	public void startMoving(ChangeBoundsRequest request) {
		setMoving(true);
		setMovingRequest(request);
	}

	/**
	 * {@inheritDoc IGroupNotifier#stopMoving()}
	 */
	public void stopMoving() {
		setMoving(false);
		setMovingRequest(null);
	}

	/**
	 * Get the moving parameter
	 * 
	 * @return
	 */
	protected boolean isMoving() {
		return isMoving;
	}

	protected ChangeBoundsRequest getMovingRequest() {
		return movingRequest;
	}

	protected void setMovingRequest(ChangeBoundsRequest movingRequest) {
		this.movingRequest = movingRequest;
	}

	protected void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	/**
	 * {@inheritDoc IGroupNotifier#isPartMoving()}
	 */
	public boolean isPartMoving() {
		return isMoving();
	}

	public IAdaptable getAdaptableView() {
		return getViewAdapter();
	}

	@Override
	public void eraseTargetFeedback(Request request) {
	}

	@Override
	public void showSourceFeedback(Request request) {
	}

	public IContainerNodeDescriptor getTargetGroupDescriptor(IAdaptable eObjectAdapter) {
		Object adapted = eObjectAdapter.getAdapter(EObject.class);
		if(adapted instanceof EObject) {
			EObject eObject = (EObject)adapted;
			return ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(eObject.eClass());
		}
		return null;
	}
}
