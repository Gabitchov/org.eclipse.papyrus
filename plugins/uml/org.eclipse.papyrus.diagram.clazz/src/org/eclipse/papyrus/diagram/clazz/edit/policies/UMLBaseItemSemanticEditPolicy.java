/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import java.util.Iterator;

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
import org.eclipse.papyrus.diagram.clazz.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;

/**
 * @generated
 */
public class UMLBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated
		 */
		public static boolean canCreateAbstraction_4006(Package container, NamedElement source, NamedElement target) {
			return canExistAbstraction_4006(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAssociation_4001(Package container, Type source, Type target) {
			return canExistAssociation_4001(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAssociation_4019(Package container, Type source, Type target) {
			return canExistAssociation_4019(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAssociationClass_4017(Package container, Type source, Type target) {
			return canExistAssociationClass_4017(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateCommentAnnotatedElement_4013(Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}

			return canExistCommentAnnotatedElement_4013(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateConstraintConstrainedElement_4014(Constraint source, Element target) {
			if(source != null) {
				if(source.getConstrainedElements().contains(target)) {
					return false;
				}
			}

			return canExistConstraintConstrainedElement_4014(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDependency_4008(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4008(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDependency_4018(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4018(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateElementImport_4009(Namespace source, PackageableElement target) {
			return canExistElementImport_4009(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGeneralization_4002(Classifier source, Classifier target) {
			return canExistGeneralization_4002(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGeneralizationSet_4020(Package container, Generalization source, Generalization target) {
			return canExistGeneralizationSet_4020(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateLink_4021() {
			return canExistLink_4021();
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDependency_4022(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4022(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateLink_4023() {
			return canExistLink_4023();
		}

		/**
		 * @generated
		 */
		public static boolean canCreateTimeObservationEvent_4024(TimeObservation source, NamedElement target) {
			if(source != null) {
				if(source.getEvent() != null) {
					return false;
				}
			}

			return canExistTimeObservationEvent_4024(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDurationObservationEvent_4025(DurationObservation source, NamedElement target) {
			if(source != null) {
				if(source.getEvents().size() >= 2 || source.getEvents().contains(target)) {
					return false;
				}
			}

			return canExistDurationObservationEvent_4025(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateInterfaceRealization_4003(BehavioredClassifier source, Interface target) {
			return canExistInterfaceRealization_4003(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateLink_4016() {
			return canExistLink_4016();
		}

		/**
		 * @generated
		 */
		public static boolean canCreatePackageImport_4010(Namespace source, Package target) {
			return canExistPackageImport_4010(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreatePackageMerge_4011(Package container, Package source, Package target) {
			return canExistPackageMerge_4011(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateProfileApplication_4012(Package source, Profile target) {
			return canExistProfileApplication_4012(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateRealization_4005(Package container, NamedElement source, NamedElement target) {
			return canExistRealization_4005(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateSubstitution_4004(Classifier container, Classifier source, Classifier target) {
			return canExistSubstitution_4004(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateTemplateBinding_4015(TemplateableElement container, TemplateableElement source, Element target) {
			return canExistTemplateBinding_4015(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateUsage_4007(Package container, NamedElement source, NamedElement target) {
			return canExistUsage_4007(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistAbstraction_4006(Package container, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAssociation_4001(Package container, Type source, Type target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAssociation_4019(Package container, Type source, Type target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAssociationClass_4017(Package container, Type source, Type target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistCommentAnnotatedElement_4013(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistConstraintConstrainedElement_4014(Constraint source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDependency_4008(Package container, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDependency_4018(Package container, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistElementImport_4009(Namespace source, PackageableElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGeneralization_4002(Classifier source, Classifier target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGeneralizationSet_4020(Package container, Generalization source, Generalization target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistLink_4021() {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDependency_4022(Package container, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistLink_4023() {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistTimeObservationEvent_4024(TimeObservation source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDurationObservationEvent_4025(DurationObservation source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistInterfaceRealization_4003(BehavioredClassifier source, Interface target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistLink_4016() {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistPackageImport_4010(Namespace source, Package target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistPackageMerge_4011(Package container, Package source, Package target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistProfileApplication_4012(Package source, Profile target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistRealization_4005(Package container, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistSubstitution_4004(Classifier container, Classifier source, Classifier target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistTemplateBinding_4015(TemplateableElement container, TemplateableElement source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistUsage_4007(Package container, NamedElement source, NamedElement target) {
			return true;
		}
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * 
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

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
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View)getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
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
	 * Extended request data key to hold editpart visual id. Add visual id of edited editpart to
	 * extended data of the request so command switch can decide what kind of diagram element is
	 * being edited. It is done in those cases when it's not possible to deduce diagram element kind
	 * from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if(request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest)request).getConnectionEditPart().getModel();
			if(view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View)view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
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
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
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
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
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
	 * Returns editing domain from the host edit part.
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
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
	protected Command getSetCommand(SetRequest req) {
		return null;
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
}
