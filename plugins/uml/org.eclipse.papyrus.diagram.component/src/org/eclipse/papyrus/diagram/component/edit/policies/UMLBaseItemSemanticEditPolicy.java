package org.eclipse.papyrus.diagram.component.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
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
import org.eclipse.papyrus.diagram.common.helper.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.component.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

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
	 * Add the reoriented view to the request extended data so that the view
	 * currently edited can be distinguished from other views of the same element
	 * and these latter possibly removed if they become inconsistent after reconnect
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
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
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
		// check if the type is an extended type, and then create directly the element...
		IElementType type = req.getElementType();
		if(type instanceof IExtendedHintedElementType) {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getContainer());
			if(provider == null) {
				return UnexecutableCommand.INSTANCE;
			}
			// Retrieve create command from the Element Edit service
			ICommand createGMFCommand = provider.getEditCommand(req);

			return getGEFWrapper(createGMFCommand);
		}
		return null;
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


		return getGEFWrapper(new MoveElementsCommand(req));


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
		public boolean canCreateUsage_4001(Package container, NamedElement source, NamedElement target) {
			return canExistUsage_4001(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateInterfaceRealization_4006(Package container, NamedElement source, NamedElement target) {
			return canExistInterfaceRealization_4006(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateGeneralization_4003(Classifier container, Classifier source, Classifier target) {
			return canExistGeneralization_4003(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateSubstitution_4012(Package container, NamedElement source, NamedElement target) {
			return canExistSubstitution_4012(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateManifestation_4014(Package container, NamedElement source, NamedElement target) {
			return canExistManifestation_4014(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateComponentRealization_4007(Package container, NamedElement source, NamedElement target) {
			return canExistComponentRealization_4007(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateAbstraction_4013(Package container, NamedElement source, NamedElement target) {
			return canExistAbstraction_4013(container, null, source, target);
		}


		/**
		 * @generated
		 */
		public boolean canCreateLink_4016() {
			return canExistLink_4016();
		}


		/**
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
		 * @generated
		 */
		public boolean canCreateDependency_4010(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4010(container, null, source, target);
		}


		/**
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
		 * @generated
		 */
		public boolean canExistInterfaceRealization_4006(Package container, InterfaceRealization linkInstance, NamedElement source, NamedElement target) {
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
		 * @generated
		 */
		public boolean canExistGeneralization_4003(Classifier container, Generalization linkInstance, Classifier source, Classifier target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistSubstitution_4012(Package container, Substitution linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistManifestation_4014(Package container, Manifestation linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistComponentRealization_4007(Package container, ComponentRealization linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistAbstraction_4013(Package container, Abstraction linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistLink_4016() {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistCommentAnnotatedElement_4015(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistConstraintConstrainedElement_4009(Constraint source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDependency_4010(Package container, Dependency linkInstance, NamedElement source, NamedElement target) {
			return true;
		}
	}

}
