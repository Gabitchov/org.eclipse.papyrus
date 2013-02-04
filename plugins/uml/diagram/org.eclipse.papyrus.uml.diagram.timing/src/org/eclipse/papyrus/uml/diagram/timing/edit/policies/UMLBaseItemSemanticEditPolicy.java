/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.policies;

import java.util.Iterator;

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
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
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
	protected UMLBaseItemSemanticEditPolicy(final IElementType elementType) {
		this.myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id. Add visual id of edited editpart to extended data of the
	 * request so command switch can decide what kind of diagram element is being edited. It is done in those cases when
	 * it's not possible to deduce diagram element kind from domain element. Add the reoriented view to the request
	 * extended data so that the view currently edited can be distinguished from other views of the same element and
	 * these latter possibly removed if they become inconsistent after reconnect
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Command getCommand(final Request request) {
		if(request instanceof ReconnectRequest) {
			final Object view = ((ReconnectRequest)request).getConnectionEditPart().getModel();
			if(view instanceof View) {
				final Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View)view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
				request.getExtendedData().put(GRAPHICAL_RECONNECTED_EDGE, view);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * 
	 * @generated
	 */
	protected int getVisualID(final IEditCommandRequest request) {
		final Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer)id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getSemanticCommand(final IEditCommandRequest request) {
		final IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if(completedRequest instanceof DestroyRequest) {
			final DestroyRequest destroyRequest = (DestroyRequest)completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(final Command mainCommand, final DestroyRequest completedRequest) {
		final Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View)getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(final IEditCommandRequest request, final Command editPolicyCommand) {
		if(editPolicyCommand != null) {
			final ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy)editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, command);
		}
		final IElementType requestContextElementType = getContextElementType(request);
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
	 * @generated
	 */
	protected IElementType getContextElementType(final IEditCommandRequest request) {
		final IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : this.myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(final IEditCommandRequest req) {
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
	protected Command getConfigureCommand(final ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(final CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(final CreateElementRequest req) {
		// no more usage of the extended types here.
		return null;
	}

	// RS: add code for extended types
	/**
	 * @generated
	 */
	protected Command getExtendedTypeCreationCommand(final CreateElementRequest request, final IExtendedHintedElementType requestElementType) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(request.getContainer());
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		final ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	/**
	 * @generated
	 */
	protected Command getExtendedStartCreateRelationshipCommand(final CreateElementRequest request, final IExtendedHintedElementType requestElementType) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(requestElementType);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		final ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	/**
	 * @generated
	 */
	protected Command getExtendedCompleteCreateRelationshipCommand(final CreateElementRequest request, final IExtendedHintedElementType requestElementType) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(requestElementType);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		final ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}

	// RS: End of add code for extended types
	/**
	 * @generated
	 */
	protected Command getSetCommand(final SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(final GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(final DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(final DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(final DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(final MoveRequest req) {

		final EObject targetCEObject = req.getTargetContainer();
		if(targetCEObject != null) {
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetCEObject);
			if(provider != null) {
				final ICommand moveCommand = provider.getEditCommand(req);
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
	protected Command getReorientReferenceRelationshipCommand(final ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(final ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(final ICommand cmd) {
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
	protected void addDestroyShortcutsCommand(final ICompositeCommand cmd, final View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for(final Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			final View nextView = (View)it.next();
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
		public boolean canCreateMessage_3(final Interaction container, final MessageEnd source, final MessageEnd target) {
			return canExistMessage_3(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_4(final Interaction container, final MessageEnd source, final MessageEnd target) {
			return canExistMessage_4(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_41(final Interaction container, final MessageEnd source, final MessageEnd target) {
			return canExistMessage_41(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_44(final Interaction container, final MessageEnd source, final MessageEnd target) {
			return canExistMessage_44(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_47(final Interaction container, final MessageEnd source, final MessageEnd target) {
			return canExistMessage_47(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_50(final Interaction container, final MessageEnd source, final Element target) {
			return canExistMessage_50(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMessage_53(final Interaction container, final Element source, final MessageEnd target) {
			return canExistMessage_53(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_3(final Interaction container, final Message linkInstance, final MessageEnd source, final MessageEnd target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_4(final Interaction container, final Message linkInstance, final MessageEnd source, final MessageEnd target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_41(final Interaction container, final Message linkInstance, final MessageEnd source, final MessageEnd target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_44(final Interaction container, final Message linkInstance, final MessageEnd source, final MessageEnd target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_47(final Interaction container, final Message linkInstance, final MessageEnd source, final MessageEnd target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_50(final Interaction container, final Message linkInstance, final MessageEnd source, final Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMessage_53(final Interaction container, final Message linkInstance, final Element source, final MessageEnd target) {
			return true;
		}
	}

}
