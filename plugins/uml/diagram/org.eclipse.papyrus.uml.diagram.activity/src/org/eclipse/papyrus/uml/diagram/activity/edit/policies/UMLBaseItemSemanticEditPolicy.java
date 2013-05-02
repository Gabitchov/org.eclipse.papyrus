/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.activity.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.uml.diagram.activity.helper.CustomObjectFlowEditHelper;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * 
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * Extended request data key to hold the edge view during a reconnect request.
	 * 
	 * @generated
	 */
	public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected UMLBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Command getCommand(Request request) {
		if(request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest)request).getConnectionEditPart().getModel();
			if(view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View)view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
				request.getExtendedData().put(GRAPHICAL_RECONNECTED_EDGE, (View)view);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * 
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer)id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if(completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest)completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View)getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * @generated NOT adding the possibility to globally disabling a request
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		// disable the request if necessary
		if(requestIsDisabled(request)) {
			return null;
		}
		if(editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy)editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if(command != null) {
			if(!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * Check whether the request should be disabled.
	 * 
	 * @param request
	 *        the request to analyze
	 * @return true if the request must not succeed
	 * @generated NOT
	 */
	private boolean requestIsDisabled(IEditCommandRequest request) {
		if(request instanceof MoveRequest) {
			// prevent moving a constraint to another parent, since the representation would not be the same
			for(Object element : ((MoveRequest)request).getElementsToMove().keySet()) {
				if(element instanceof Constraint) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if(req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest)req);
		} else if(req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest)req);
		} else if(req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest)req);
		} else if(req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest)req);
		} else if(req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest)req);
		} else if(req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest)req);
		} else if(req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest)req);
		} else if(req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest)req);
		} else if(req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest)req);
		} else if(req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest)req);
		} else if(req instanceof SetRequest) {
			return getSetCommand((SetRequest)req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		// no more usage of the extended types here. 
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getExtendedTypeCreationCommand(CreateElementRequest request, IExtendedHintedElementType requestElementType) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(request.getContainer());
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	/**
	 * @generated
	 */
	protected Command getExtendedStartCreateRelationshipCommand(CreateElementRequest request, IExtendedHintedElementType requestElementType) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(requestElementType);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	/**
	 * @generated
	 */
	protected Command getExtendedCompleteCreateRelationshipCommand(CreateElementRequest request, IExtendedHintedElementType requestElementType) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(requestElementType);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	/**
	 * @generated
	 */
	protected ICommand getSemanticCreationCommand(CreateElementRequest req) {
		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getContainer());
		if(commandService == null) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		return commandService.getEditCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		EObject targetCEObject = req.getTargetContainer();
		if(targetCEObject != null) {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetCEObject);
			if(provider != null) {
				ICommand moveCommand = provider.getEditCommand(req);
				if(moveCommand != null) {
					return new ICommandProxy(moveCommand);
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else {
			return getGEFWrapper(new MoveElementsCommand(req));
		}
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * 
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for(Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated
	 */
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = UMLDiagramEditorPlugin.getInstance().getLinkConstraints();
		if(cached == null) {
			UMLDiagramEditorPlugin.getInstance().setLinkConstraints(cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		public LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateActionLocalPrecondition_4001(Action source, Constraint target) {
			if(source != null) {
				if(source.getLocalPreconditions().contains(target)) {
					return false;
				}
				if(source == target) {
					return false;
				}
			}
			return canExistActionLocalPrecondition_4001(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateActionLocalPostcondition_4002(Action source, Constraint target) {
			if(source != null) {
				if(source.getLocalPostconditions().contains(target)) {
					return false;
				}
				if(source == target) {
					return false;
				}
			}
			return canExistActionLocalPostcondition_4002(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateObjectFlow_4003(Activity container, ActivityNode source, ActivityNode target) {
			return canExistObjectFlow_4003(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateControlFlow_4004(Activity container, ActivityNode source, ActivityNode target) {
			return canExistControlFlow_4004(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateExceptionHandler_4005(ExecutableNode container, ExecutableNode source, ObjectNode target) {
			return canExistExceptionHandler_4005(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateCommentAnnotatedElement_4006(Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_4006(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateConstraintConstrainedElement_4007(Constraint source, Element target) {
			if(source != null) {
				if(source.getConstrainedElements().contains(target)) {
					return false;
				}
			}
			return canExistConstraintConstrainedElement_4007(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistActionLocalPrecondition_4001(Action source, Constraint target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistActionLocalPostcondition_4002(Action source, Constraint target) {
			return true;
		}

		/**
		 * modify the generation to call explicitly custom helper
		 * 
		 * @generated NOT
		 */
		public boolean canExistObjectFlow_4003(Activity container, ObjectFlow linkInstance, ActivityNode source, ActivityNode target) {
			try {
				if(source instanceof Action) {
					// rule validateObjectFlow_validateNoActions
					// rule workaround by addition of pins in case of Action
					if(!CustomObjectFlowEditHelper.canStartNewObjectFlow((Action)source)) {
						return false;
					}
				}
				if(source instanceof InputPin) {
					// rule validateInputPin_validateOutgoingEdgesStructuredOnly
					if(source.getOwner() instanceof StructuredActivityNode) {
						if(target != null && !source.getOwner().equals(target.getInStructuredNode())) {
							return false;
						}
					} else {
						return false;
					}
				}
				if(source instanceof InitialNode) {
					// rule validateInitialNode_validateControlEdges
					return false;
				}
				if(source instanceof FinalNode) {
					// rule validateFinalNode_validateNoOutgoingEdges
					return false;
				}
				if(source instanceof JoinNode) {
					// rule validateJoinNode_validateOneOutgoingEdge
					if(!source.getOutgoings().isEmpty()) {
						return false;
					}
					/*
					 * rule validateJoinNode_validateIncomingObjectFlow :
					 * We do not prevent creation of an outgoing ObjectFlow even if there is no incoming ObjectFlow.
					 * We let the possibility that the user intends to add an incoming ObjectFlow later.
					 */
				}
				if(source instanceof ForkNode) {
					// rule validateForkNode_validateEdges on source Fork node
					ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						// there is a ControlFlow which means there must be no ObjectFlow
						return false;
					}
				}
				if(source instanceof MergeNode) {
					//rule validateMergeNode_validateOneOutgoingEdge
					if(!source.getOutgoings().isEmpty()) {
						return false;
					}
					// rule validateMergeNode_validateEdges on source Merge node
					ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						// there is a ControlFlow which means there must be no ObjectFlow
						return false;
					}
				}
				if(source instanceof DecisionNode) {
					// rule validateDecisionNode_validateEdges on source Decision node
					ActivityEdge outgoingControlFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						// there is a ControlFlow which means there must be no ObjectFlow
						return false;
					}
				}
				if(source instanceof ActivityParameterNode) {
					// rule validateActivityParameterNode_validateIncomingOrOutgoing
					EList<ActivityEdge> incomings = source.getIncomings();
					if(!incomings.isEmpty()) {
						return false;
					}
				}
				if(target instanceof Action) {
					// rule validateObjectFlow_validateNoActions
					// rule workaround by addition of pins in case of Action
					if(!CustomObjectFlowEditHelper.canEndNewObjectFlow((Action)target)) {
						return false;
					}
				}
				if(target instanceof OutputPin) {
					// rule validateOutputPin_validateIncomingEdgesStructuredOnly
					if(target.getOwner() instanceof StructuredActivityNode) {
						if(source != null && !target.getOwner().equals(source.getInStructuredNode())) {
							return false;
						}
					} else {
						return false;
					}
				}
				if(target instanceof InitialNode) {
					// rule validateInitialNode_validateNoIncomingEdges
					return false;
				}
				if(target instanceof JoinNode) {
					// rule validateJoinNode_validateIncomingObjectFlow
					ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null) {
						// the outgoing edge is a ControlFlow which means there must be no incoming ObjectFlow
						return false;
					}
				}
				if(target instanceof ForkNode) {
					// rule validateForkNode_validateOneIncomingEdge
					if(!target.getIncomings().isEmpty()) {
						return false;
					}
					// rule validateForkNode_validateEdges on target Fork node
					ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						// there is a ControlFlow which means there must be no ObjectFlow
						return false;
					}
				}
				if(target instanceof MergeNode) {
					// rule validateMergeNode_validateEdges on target Merge node
					ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						// there is a ControlFlow which means there must be no ObjectFlow
						return false;
					}
				}
				if(target instanceof DecisionNode) {
					// rule validateDecisionNode_validateIncomingOutgoingEdges
					if(target.getIncomings().size() >= 2) {
						// no more than two incoming edges
						return false;
					}
					// rule validateDecisionNode_validateEdges on target Decision node
					ActivityEdge outgoingControlFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getControlFlow());
					ActivityEdge incomingControlFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getControlFlow());
					if(outgoingControlFlow != null || incomingControlFlow != null) {
						/*
						 * There is a ControlFlow which means there must be no
						 * ObjectFlow but the decision flow itself.
						 * We let the user insert up to one ObjectFlow for being
						 * able to select the decision flow among existing
						 * input flows.
						 */
						if(target.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow()) != null) {
							// there is already an object flow which is intended to become the decision flow
							return false;
						}
					}
				}
				if(target instanceof ActivityParameterNode) {
					// rule validateActivityParameterNode_validateIncomingOrOutgoing
					EList<ActivityEdge> outgoings = target.getOutgoings();
					if(!outgoings.isEmpty()) {
						return false;
					}
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistControlFlow_4004(Activity container, ControlFlow linkInstance, ActivityNode source, ActivityNode target) {
			try {
				if(source instanceof ObjectNode) {
					if(!((ObjectNode)source).isControlType()) {
						// rule validateControlFlow_validateObjectNodes
						return false;
					}
				}
				if(source instanceof InputPin) {
					// rule validateInputPin_validateOutgoingEdgesStructuredOnly
					if(source.getOwner() instanceof StructuredActivityNode) {
						if(target != null && !source.getOwner().equals(target.getInStructuredNode())) {
							return false;
						}
					} else {
						return false;
					}
				}
				if(source instanceof FinalNode) {
					// rule validateFinalNode_validateNoOutgoingEdges
					return false;
				}
				if(source instanceof JoinNode) {
					// rule validateJoinNode_validateOneOutgoingEdge
					if(!source.getOutgoings().isEmpty()) {
						return false;
					}
					// rule validateJoinNode_validateIncomingObjectFlow
					ActivityEdge incomingObjectFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					if(incomingObjectFlow != null) {
						// the outgoing edge must be an ObjectFlow
						return false;
					}
				}
				if(source instanceof ForkNode) {
					// rule validateForkNode_validateEdges on source Fork node
					ActivityEdge outgoingObjectFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					ActivityEdge incomingObjectFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					if(outgoingObjectFlow != null || incomingObjectFlow != null) {
						// there is an ObjectFlow which means there must be no ControlFlow
						return false;
					}
				}
				if(source instanceof MergeNode) {
					//rule validateMergeNode_validateOneOutgoingEdge
					if(!source.getOutgoings().isEmpty()) {
						return false;
					}
					// rule validateMergeNode_validateEdges on source Merge node
					ActivityEdge outgoingObjectFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					ActivityEdge incomingObjectFlow = source.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					if(outgoingObjectFlow != null || incomingObjectFlow != null) {
						// there is an ObjectFlow which means there must be no ControlFlow
						return false;
					}
				}
				if(source instanceof DecisionNode) {
					// rule validateDecisionNode_validateEdges on source Decision node
					ActivityEdge outgoingObjectFlow = source.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					int incomingObjectFlowNumber = 0;
					for(ActivityEdge incomingEdge : source.getIncomings()) {
						if(incomingEdge instanceof ObjectFlow) {
							incomingObjectFlowNumber++;
						}
					}
					if(outgoingObjectFlow != null || incomingObjectFlowNumber > 1) {
						// there is an ObjectFlow (not intended for decisionInputFlow) which means there must be no ControlFlow
						return false;
					}
				}
				if(target instanceof ObjectNode) {
					if(!((ObjectNode)target).isControlType()) {
						// rule validateControlFlow_validateObjectNodes
						return false;
					}
				}
				if(target instanceof OutputPin) {
					// rule validateOutputPin_validateIncomingEdgesStructuredOnly
					if(target.getOwner() instanceof StructuredActivityNode) {
						if(source != null && !target.getOwner().equals(source.getInStructuredNode())) {
							return false;
						}
					} else {
						return false;
					}
				}
				if(target instanceof InitialNode) {
					// rule validateInitialNode_validateNoIncomingEdges
					return false;
				}
				if(target instanceof ForkNode) {
					// rule validateForkNode_validateOneIncomingEdge
					if(!target.getIncomings().isEmpty()) {
						return false;
					}
					// rule validateForkNode_validateEdges on target Fork node
					ActivityEdge outgoingObjectFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					ActivityEdge incomingObjectFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					if(outgoingObjectFlow != null || incomingObjectFlow != null) {
						// there is an ObjectFlow which means there must be no ControlFlow
						return false;
					}
				}
				if(target instanceof MergeNode) {
					// rule validateMergeNode_validateEdges on target Merge node
					ActivityEdge outgoingObjectFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					ActivityEdge incomingObjectFlow = target.getIncoming(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					if(outgoingObjectFlow != null || incomingObjectFlow != null) {
						// there is an ObjectFlow which means there must be no ControlFlow
						return false;
					}
				}
				if(target instanceof DecisionNode) {
					// rule validateDecisionNode_validateIncomingOutgoingEdges
					if(target.getIncomings().size() >= 2) {
						// no more than two incoming edges
						return false;
					}
					// rule validateDecisionNode_validateEdges on target Decision node
					ActivityEdge outgoingObjectFlow = target.getOutgoing(null, true, UMLPackage.eINSTANCE.getObjectFlow());
					ActivityEdge incomingObjectFlow = null;
					for(ActivityEdge incomingEdge : target.getIncomings()) {
						// filter the decision flow
						if(incomingEdge instanceof ObjectFlow && incomingEdge != ((DecisionNode)target).getDecisionInputFlow()) {
							incomingObjectFlow = incomingEdge;
						}
					}
					if(outgoingObjectFlow != null || incomingObjectFlow != null) {
						// there is an ObjectFlow which means there must be no ControlFlow
						return false;
					}
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistExceptionHandler_4005(ExecutableNode container, ExceptionHandler linkInstance, ExecutableNode source, ObjectNode target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistCommentAnnotatedElement_4006(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistConstraintConstrainedElement_4007(Constraint source, Element target) {
			return true;
		}
	}
}
