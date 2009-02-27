/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IEditHelperContext;
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
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.TemplateableElement;
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
			if (source != null) {
				if (source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_4013(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateConstraintConstrainedElement_4014(Constraint source, Element target) {
			if (source != null) {
				if (source.getConstrainedElements().contains(target)) {
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
	protected void addDestroyShortcutsCommand(CompoundCommand command) {
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return;
		}
		for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			command.add(getDestroyElementCommand(nextView));
		}
	}

	/**
	 * Extended request data key to hold editpart visual id. Add visual id of edited editpart to extended data of the request so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View) view));
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
	 * Creates commands to destroy all host incoming and outgoing links.
	 * 
	 * @generated
	 */
	protected CompoundCommand getDestroyEdgesCommand() {
		CompoundCommand cmd = new CompoundCommand();
		View view = (View) getHost().getModel();
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			cmd.add(getDestroyElementCommand((Edge) it.next()));
		}
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			cmd.add(getDestroyElementCommand((Edge) it.next()));
		}
		return cmd;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * Creates command to destroy the link.
	 * 
	 * @generated
	 */
	protected Command getDestroyElementCommand(View view) {
		EditPart editPart = (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		DestroyElementRequest request = new DestroyElementRequest(getEditingDomain(), false);
		return editPart.getCommand(new EditCommandRequestWrapper(request, Collections.EMPTY_MAP));
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
	 * Returns editing domain from the host edit part.
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
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
	 * @deprecated use getGEFWrapper() instead
	 * @generated
	 */
	protected final Command getMSLWrapper(ICommand cmd) {
		// XXX deprecated: use getGEFWrapper() instead
		return getGEFWrapper(cmd);
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
		Object editHelperContext = completedRequest.getEditHelperContext();
		if (editHelperContext instanceof View || (editHelperContext instanceof IEditHelperContext && ((IEditHelperContext) editHelperContext).getEObject() instanceof View)) {
			// no semantic commands are provided for pure design elements
			return null;
		}
		if (editHelperContext == null) {
			editHelperContext = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		}
		IElementType elementType = ElementTypeRegistry.getInstance().getElementType(editHelperContext);
		if (elementType == ElementTypeRegistry.getInstance().getType("org.eclipse.gmf.runtime.emf.type.core.default")) { //$NON-NLS-1$ 
			elementType = null;
		}
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		if (elementType != null) {
			if (semanticCommand != null) {
				ICommand command = semanticCommand instanceof ICommandProxy ? ((ICommandProxy) semanticCommand).getICommand() : new CommandProxy(semanticCommand);
				completedRequest.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
			}
			ICommand command = elementType.getEditCommand(completedRequest);
			if (command != null) {
				if (!(command instanceof CompositeTransactionalCommand)) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
					command = new CompositeTransactionalCommand(editingDomain, command.getLabel()).compose(command);
				}
				semanticCommand = new ICommandProxy(command);
			}
		}
		boolean shouldProceed = true;
		if (completedRequest instanceof DestroyRequest) {
			shouldProceed = shouldProceed((DestroyRequest) completedRequest);
		}
		if (shouldProceed) {
			if (completedRequest instanceof DestroyRequest) {
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
				Command deleteViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View) getHost().getModel()));
				semanticCommand = semanticCommand == null ? deleteViewCommand : semanticCommand.chain(deleteViewCommand);
			}
			return semanticCommand;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement() {
		return ViewUtil.resolveSemanticElement((View) getHost().getModel());
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
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

}
