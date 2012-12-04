/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

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
import org.eclipse.papyrus.uml.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.uml.diagram.usecase.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

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
		public boolean canCreateInclude_4008(UseCase container, UseCase source, UseCase target) {
			return canExistInclude_4008(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateExtend_4009(UseCase container, UseCase source, UseCase target) {
			return canExistExtend_4009(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateGeneralization_4010(Classifier container, Classifier source, Classifier target) {
			return canExistGeneralization_4010(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAssociation_4011(Package container, Type source, Type target) {
			return canExistAssociation_4011(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateConstraintConstrainedElement_4012(Constraint source, Element target) {
			if(source != null) {
				if(source.getConstrainedElements().contains(target)) {
					return false;
				}
			}
			return canExistConstraintConstrainedElement_4012(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateDependency_4013(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4013(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateCommentAnnotatedElement_4014(Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_4014(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAbstraction_4015(Package container, NamedElement source, NamedElement target) {
			return canExistAbstraction_4015(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateUsage_4016(Package container, NamedElement source, NamedElement target) {
			return canExistUsage_4016(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRealization_4017(Package container, NamedElement source, NamedElement target) {
			return canExistRealization_4017(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreatePackageMerge_4018(Package container, Package source, Package target) {
			return canExistPackageMerge_4018(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreatePackageImport_4019(Namespace source, Package target) {
			return canExistPackageImport_4019(null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistInclude_4008(UseCase container, Include linkInstance, UseCase source, UseCase target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistExtend_4009(UseCase container, Extend linkInstance, UseCase source, UseCase target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistGeneralization_4010(Classifier container, Generalization linkInstance, Classifier source, Classifier target) {
			try {
				if(source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getClassifier()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(10, UMLPackage.eINSTANCE.getClassifier(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				if(target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getClassifier()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(11, UMLPackage.eINSTANCE.getClassifier(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
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
		public boolean canExistAssociation_4011(Package container, Association linkInstance, Type source, Type target) {
			try {
				if((source instanceof Class) || (source instanceof Component) || (source instanceof Actor) || (source instanceof UseCase)) {
					if((target instanceof Class) || (target instanceof Component) || (target instanceof Actor) || (target instanceof UseCase)) {
						if((source instanceof UseCase) && (target instanceof UseCase)) {
							return (Collections.disjoint(((UseCase)source).getSubjects(), ((UseCase)target).getSubjects()));
						}
						return true;
					}
				} else {
					return false;
				}
				if((source instanceof Class) || (source instanceof Component) || (source instanceof Actor) || (source instanceof UseCase)) {
					if((target instanceof Class) || (target instanceof Component) || (target instanceof Actor) || (target instanceof UseCase)) {
						if((source instanceof UseCase) && (target instanceof UseCase)) {
							return (Collections.disjoint(((UseCase)source).getSubjects(), ((UseCase)target).getSubjects()));
						}
						return true;
					}
				} else {
					return false;
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
		public boolean canExistConstraintConstrainedElement_4012(Constraint source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDependency_4013(Package container, Dependency linkInstance, NamedElement source, NamedElement target) {
			try {
				if(target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(17, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
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
		public boolean canExistCommentAnnotatedElement_4014(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistAbstraction_4015(Package container, Abstraction linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistUsage_4016(Package container, Usage linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRealization_4017(Package container, Realization linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistPackageMerge_4018(Package container, PackageMerge linkInstance, Package source, Package target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistPackageImport_4019(PackageImport linkInstance, Namespace source, Package target) {
			return true;
		}
	}
}
