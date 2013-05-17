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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.ContainerNodeDescriptorRegistry;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.GroupRequestAdvisor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.request.AbstractGroupRequest;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.request.IGroupRequest;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.Utils;

public class GroupCreationEditPolicy extends CreationEditPolicy {

	/**
	 * Node descriptor
	 */
	private IContainerNodeDescriptor groupDescriptor;

	/**
	 * @param groupDescriptor
	 */
	public GroupCreationEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super();
		this.groupDescriptor = groupDescriptor;
	}

	/**
	 * Return the {@link IContainerNodeDescriptor} of the group owning this edit policy
	 * 
	 * @return
	 */
	protected IContainerNodeDescriptor getGroupDescriptor() {
		return groupDescriptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getReparentCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while(editParts.hasNext()) {
			EditPart ep = (EditPart)editParts.next();
			if(ep instanceof LabelEditPart) {
				continue;
			}
			if(ep instanceof GroupEditPart) {
				cc.compose(getReparentGroupCommand((GroupEditPart)ep));
			}
			View view = (View)ep.getAdapter(View.class);
			if(view == null) {
				continue;
			}
			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if(semantic == null) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
			} else if(context != null) {
				if(shouldReparentModel(semantic, context)) {
					cc.compose(getReparentCommand((IGraphicalEditPart)ep));
				} else if(shouldGraphicalyReparent(semantic, context)) {
					cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
				}
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}

	/**
	 * Return true if the node is visually contained into the host
	 * 
	 * @param ep
	 * @return
	 */
	protected boolean isVisuallyContained(IGraphicalEditPart ep, ChangeBoundsRequest request) {
		Rectangle hostBounds = Utils.getAbsoluteBounds((IGraphicalEditPart)getHost());
		Rectangle ndeBounds = Utils.getAbslotueRequestBounds(request, ep);
		return hostBounds.contains(ndeBounds);
	}

	/**
	 * Return true if this element should be a model child of this element
	 * 
	 * @param semantic
	 * @param context
	 * @return
	 */
	protected boolean shouldReparentModel(EObject element, EObject newContext) {
		EReference feature = PackageUtil.findFeature(newContext.eClass(), element.eClass());
		return feature != null && feature.isContainment() && shouldReparent(element, newContext) && !isSameContainer(element, newContext);
	}

	/**
	 * Return true if the element should be a graphical child to this element
	 * 
	 * @param semantic
	 * @param context
	 * @return
	 */
	protected boolean shouldGraphicalyReparent(EObject element, EObject newContext) {
		EReference feature = findFeatureWhichReference(newContext.eClass(), element.eClass());
		return feature != null && !feature.isContainment() && shouldReparent(element, newContext);
	}

	/**
	 * Finds a feature that can contain an object of type eClass.
	 * 
	 * @param container
	 *        The container <code>EClass</code>.
	 * @param eClass
	 *        The contained <code>EClass</code>.
	 * @return The found feature.
	 */
	protected static EReference findFeatureWhichReference(EClass container, EClass eClass) {
		Iterator i = container.getEAllReferences().iterator();
		while(i.hasNext()) {
			EReference reference = (EReference)i.next();
			if(PackageUtil.canReference(container, reference, eClass))
				return reference;
		}
		return null;
	}

	/**
	 * Checks if a container <code>EClass</code> can reference another <code>EClass</code>.
	 * 
	 * @param class1
	 *        The referencer <code>EClass</code>.
	 * @param class2
	 *        The referenced <code>EClass</code>.
	 * @return True if an object can contain other objects of a given type.
	 */
	protected static boolean canReference(EClass class1, EClass class2) {
		Iterator i = class1.getEAllReferences().iterator();
		while(i.hasNext()) {
			EReference reference = (EReference)i.next();
			if(!reference.isContainment()) {
				EClass eType = (EClass)reference.getEType();
				if((eType.equals(class2)) || (eType.isSuperTypeOf(class2))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected boolean shouldReparent(EObject element, EObject newContext) {
		return !(element == null || element == newContext || isContainedIn(element, newContext));
	}

	/**
	 * Return true if the the container of the element if the newContext
	 * 
	 * @param element
	 * @param newContext
	 * @return
	 */
	protected boolean isSameContainer(EObject element, EObject newContext) {
		return element.eContainer() == newContext;
	}

	/*
	 * This method checks to see element's containment tree already includes
	 * itself. This is necessary to prevent cyclic graphs in the model that
	 * cause StackOverflowExceptions.
	 */
	private boolean isContainedIn(EObject element, EObject newContext) {
		EObject container = newContext.eContainer();
		while(container != null) {
			if(container.equals(element))
				return true;
			container = container.eContainer();
		}
		return false;
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest chRequest = (ChangeBoundsRequest)request;
			List editParts = chRequest.getEditParts();
			if(editParts != null) {
				for(Object p : editParts) {
					if(p instanceof IGraphicalEditPart) {
						IGraphicalEditPart graphEditPart = (IGraphicalEditPart)p;
						if(isVisuallyContained(graphEditPart, chRequest)) {
							return getHost();
						}
						return ((IGraphicalEditPart)getHost()).getTopGraphicEditPart().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		// get the semantic request
		CreateElementRequest createElementRequest = (CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class);
		tryToFindModelParentFromGroupFramework(createElementRequest, new AbstractGroupRequest((IGraphicalEditPart)getHost(), request, request.getViewAndElementDescriptor().getElementAdapter(), ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(createElementRequest.getElementType().getEClass())) {

			public GroupRequestType getGroupRequestType() {
				return GroupRequestType.CREATION;
			}
		});
		if(createElementRequest.getContainer() == null) {
			// complete the semantic request by filling in the host's semantic
			// element as the context
			View view = (View)getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);
			if(hostElement == null && view.getElement() == null) {
				hostElement = view;
			}
			// Returns null if host is unresolvable so that trying to create a
			// new element in an unresolved shape will not be allowed.
			if(hostElement == null) {
				return null;
			}
			createElementRequest.setContainer(hostElement);
		}
		// get the create element command based on the elementdescriptor's
		// request
		Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));
		if(createElementCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!createElementCommand.canExecute()) {
			return createElementCommand;
		}
		// create the semantic create wrapper command
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		Command viewCommand = getCreateCommand(request);
		if(viewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!viewCommand.canExecute()) {
			return UnexecutableCommand.INSTANCE;
		}
		Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List)request.getNewObject())));
		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		if(refreshConnectionCommand != null) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}
		return new ICommandProxy(cc);
	}

	/**
	 * Try to set the container of the request thanks to the group framework
	 * 
	 * @param createElementRequest
	 */
	protected void tryToFindModelParentFromGroupFramework(CreateElementRequest createElementRequest, IGroupRequest request) {
		EObject parent = GroupRequestAdvisor.getInstance().getPossibleModelParent(request);
		if(parent != null) {
			createElementRequest.setContainer(parent);
		}
	}
}
