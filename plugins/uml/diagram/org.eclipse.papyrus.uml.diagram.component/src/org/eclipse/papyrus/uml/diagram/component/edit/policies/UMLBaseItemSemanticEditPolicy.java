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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
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
import org.eclipse.papyrus.uml.diagram.common.helper.UMLBaseEditHelper;
import org.eclipse.papyrus.uml.diagram.component.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

// TODO: Auto-generated Javadoc
/**
 * The Class UMLBaseItemSemanticEditPolicy.
 * 
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

	/** The my element type. @generated */
	private final IElementType myElementType;

	/**
	 * Instantiates a new uML base item semantic edit policy.
	 * 
	 * @param elementType
	 *        the element type
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
	 * Add the reoriented view to the request extended data so that the view
	 * <<<<<<< .mine
	 * currently edited can be distinguished from other views of the same element
	 * and these latter possibly removed if they become inconsistent after reconnect
	 * 
	 * @param request
	 *        the request
	 * @return the command
	 *         =======
	 *         currently edited can be distinguished from other views of the same element
	 *         and these latter possibly removed if they become inconsistent after reconnect
	 * 
	 *         >>>>>>> .r4908
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
	 * <<<<<<< .mine
	 * 
	 * @param request
	 *        the request
	 * @return the visual id
	 *         =======
	 * 
	 *         >>>>>>> .r4908
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer)id).intValue() : -1;
	}

	/**
	 * Gets the semantic command.
	 * 
	 * @param request
	 *        the request
	 * @return the semantic command
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
	 * Adds the delete view command.
	 * 
	 * @param mainCommand
	 *        the main command
	 * @param completedRequest
	 *        the completed request
	 * @return the command
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View)getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * Gets the edits the helper command.
	 * 
	 * @param request
	 *        the request
	 * @param editPolicyCommand
	 *        the edit policy command
	 * @return the edits the helper command
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		if(editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy)editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, null);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, null);
		if(command != null) {
			if(!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * Gets the context element type.
	 * 
	 * @param request
	 *        the request
	 * @return the context element type
	 * @generated
	 */
	protected IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
	}

	/**
	 * Gets the semantic command switch.
	 * 
	 * @param req
	 *        the req
	 * @return the semantic command switch
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
	 * Gets the configure command.
	 * 
	 * @param req
	 *        the req
	 * @return the configure command
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * Gets the creates the relationship command.
	 * 
	 * @param req
	 *        the req
	 * @return the creates the relationship command
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * Gets the creates the command.
	 * 
	 * @param req
	 *        the req
	 * @return the creates the command
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
	 * Gets the sets the command.
	 * 
	 * @param req
	 *        the req
	 * @return the sets the command
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * Gets the edits the context command.
	 * 
	 * @param req
	 *        the req
	 * @return the edits the context command
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * Gets the destroy element command.
	 * 
	 * @param req
	 *        the req
	 * @return the destroy element command
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * Gets the destroy reference command.
	 * 
	 * @param req
	 *        the req
	 * @return the destroy reference command
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * Gets the duplicate command.
	 * 
	 * @param req
	 *        the req
	 * @return the duplicate command
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * Gets the move command.
	 * 
	 * @param req
	 *        the req
	 * @return the move command
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
	 * Gets the reorient reference relationship command.
	 * 
	 * @param req
	 *        the req
	 * @return the reorient reference relationship command
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the reorient relationship command.
	 * 
	 * @param req
	 *        the req
	 * @return the reorient relationship command
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the gEF wrapper.
	 * 
	 * @param cmd
	 *        the cmd
	 * @return the gEF wrapper
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * <<<<<<< .mine
	 * 
	 * @return the editing domain
	 *         =======
	 * 
	 *         >>>>>>> .r4908
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram.
	 * 
	 * @param cmd
	 *        the cmd
	 * @param view
	 *        the view
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
	 * Gets the link constraints.
	 * 
	 * @return the link constraints
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
	 * The Class LinkConstraints.
	 * 
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * Instantiates a new link constraints.
		 * 
		 * @generated
		 */
		public LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * Can create usage_4001.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateUsage_4001(Package container, NamedElement source, NamedElement target) {
			return canExistUsage_4001(container, null, source, target);
		}

		/**
		 * Can create interface realization_4006.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateInterfaceRealization_4006(Package container, NamedElement source, Interface target) {
			return canExistInterfaceRealization_4006(container, null, source, target);
		}

		/**
		 * Can create generalization_4003.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateGeneralization_4003(Classifier container, Classifier source, Classifier target) {
			return canExistGeneralization_4003(container, null, source, target);
		}

		/**
		 * Can create substitution_4012.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateSubstitution_4012(Package container, NamedElement source, NamedElement target) {
			return canExistSubstitution_4012(container, null, source, target);
		}

		/**
		 * Can create manifestation_4014.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateManifestation_4014(Package container, NamedElement source, NamedElement target) {
			return canExistManifestation_4014(container, null, source, target);
		}

		/**
		 * Can create component realization_4007.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateComponentRealization_4007(Package container, NamedElement source, NamedElement target) {
			return canExistComponentRealization_4007(container, null, source, target);
		}

		/**
		 * Can create abstraction_4013.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateAbstraction_4013(Package container, NamedElement source, NamedElement target) {
			return canExistAbstraction_4013(container, null, source, target);
		}

		/**
		 * Can create link_4016.
		 * 
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateLink_4016() {
			return canExistLink_4016();
		}

		/**
		 * Can create comment annotated element_4015.
		 * 
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateCommentAnnotatedElement_4015(Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_4015(source, target);
		}

		/**
		 * Can create constraint constrained element_4009.
		 * 
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateConstraintConstrainedElement_4009(Constraint source, Element target) {
			if(source != null) {
				if(source.getConstrainedElements().contains(target)) {
					return false;
				}
			}
			return canExistConstraintConstrainedElement_4009(source, target);
		}

		/**
		 * Can create dependency_4010.
		 * 
		 * @param container
		 *        the container
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canCreateDependency_4010(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4010(container, null, source, target);
		}

		/**
		 * Can exist usage_4001.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistUsage_4001(Package container, Usage linkInstance, NamedElement source, NamedElement target) {
			try {
				if(source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				if(target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
					if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * Can exist interface realization_4006.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistInterfaceRealization_4006(Package container, InterfaceRealization linkInstance, NamedElement source, Interface target) {
			try {
				if(source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getInterface()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				if(target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getInterface(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
					if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * Can exist generalization_4003.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistGeneralization_4003(Classifier container, Generalization linkInstance, Classifier source, Classifier target) {
			return true;
		}

		/**
		 * Can exist substitution_4012.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistSubstitution_4012(Package container, Substitution linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * Can exist manifestation_4014.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistManifestation_4014(Package container, Manifestation linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * Can exist component realization_4007.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistComponentRealization_4007(Package container, ComponentRealization linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * Can exist abstraction_4013.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistAbstraction_4013(Package container, Abstraction linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * Can exist link_4016.
		 * 
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistLink_4016() {
			return true;
		}

		/**
		 * Can exist comment annotated element_4015.
		 * 
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistCommentAnnotatedElement_4015(Comment source, Element target) {
			return true;
		}

		/**
		 * Can exist constraint constrained element_4009.
		 * 
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistConstraintConstrainedElement_4009(Constraint source, Element target) {
			return true;
		}

		/**
		 * Can exist dependency_4010.
		 * 
		 * @param container
		 *        the container
		 * @param linkInstance
		 *        the link instance
		 * @param source
		 *        the source
		 * @param target
		 *        the target
		 * @return true, if successful
		 * @generated
		 */
		public boolean canExistDependency_4010(Package container, Dependency linkInstance, NamedElement source, NamedElement target) {
			return true;
		}
	}
}
