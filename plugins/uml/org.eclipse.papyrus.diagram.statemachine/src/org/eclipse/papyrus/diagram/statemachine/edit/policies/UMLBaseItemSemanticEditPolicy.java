/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
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
import org.eclipse.papyrus.diagram.statemachine.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;


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
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest)request).getConnectionEditPart()
					.getModel();
			if(view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry
						.getVisualID((View)view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
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
	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Object editHelperContext = completedRequest.getEditHelperContext();
		if(editHelperContext instanceof View
				|| (editHelperContext instanceof IEditHelperContext && ((IEditHelperContext)editHelperContext)
				.getEObject() instanceof View)) {
			// no semantic commands are provided for pure design elements
			return null;
		}
		if(editHelperContext == null) {
			editHelperContext = ViewUtil
					.resolveSemanticElement((View)getHost().getModel());
		}
		IElementType elementType = ElementTypeRegistry.getInstance()
				.getElementType(editHelperContext);
		if(elementType == ElementTypeRegistry.getInstance().getType("org.eclipse.gmf.runtime.emf.type.core.default")) { //$NON-NLS-1$ 
			elementType = null;
		}
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		if(semanticCommand != null) {
			ICommand command = semanticCommand instanceof ICommandProxy ? ((ICommandProxy)semanticCommand)
					.getICommand()
					: new CommandProxy(semanticCommand);
			completedRequest.setParameter(
					UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		if(elementType != null) {
			ICommand command = elementType.getEditCommand(completedRequest);
			if(command != null) {
				if(!(command instanceof CompositeTransactionalCommand)) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost())
							.getEditingDomain();
					command = new CompositeTransactionalCommand(editingDomain,
							command.getLabel()).compose(command);
				}
				semanticCommand = new ICommandProxy(command);
			}
		}
		boolean shouldProceed = true;
		if(completedRequest instanceof DestroyRequest) {
			shouldProceed = shouldProceed((DestroyRequest)completedRequest);
		}
		if(shouldProceed) {
			if(completedRequest instanceof DestroyRequest) {
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost())
						.getEditingDomain();
				Command deleteViewCommand = new ICommandProxy(
						new DeleteCommand(editingDomain, (View)getHost()
						.getModel()));
				semanticCommand = semanticCommand == null ? deleteViewCommand
						: semanticCommand.chain(deleteViewCommand);
			}
			return semanticCommand;
		}
		return null;
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
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * @deprecated use getGEFWrapper() instead
	 * @generated
	 */
	@Deprecated
	protected final Command getMSLWrapper(ICommand cmd) {
		// XXX deprecated: use getGEFWrapper() instead
		return getGEFWrapper(cmd);
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement() {
		return ViewUtil.resolveSemanticElement((View)getHost().getModel());
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
	 * Creates command to destroy the link.
	 * 
	 * @generated
	 */
	protected Command getDestroyElementCommand(View view) {
		EditPart editPart = (EditPart)getHost().getViewer()
				.getEditPartRegistry().get(view);
		DestroyElementRequest request = new DestroyElementRequest(
				getEditingDomain(), false);
		return editPart.getCommand(new EditCommandRequestWrapper(request,
				Collections.EMPTY_MAP));
	}

	/**
	 * Creates commands to destroy all host incoming and outgoing links.
	 * 
	 * @generated
	 */
	protected CompoundCommand getDestroyEdgesCommand() {
		CompoundCommand cmd = new CompoundCommand();
		View view = (View)getHost().getModel();
		for(Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			cmd.add(getDestroyElementCommand((Edge)it.next()));
		}
		for(Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			cmd.add(getDestroyElementCommand((Edge)it.next()));
		}
		return cmd;
	}

	/**
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(CompoundCommand command) {
		View view = (View)getHost().getModel();
		if(view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return;
		}
		for(Iterator it = view.getDiagram().getChildren().iterator(); it
				.hasNext();) {
			View nextView = (View)it.next();
			if(nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			command.add(getDestroyElementCommand(nextView));
		}
	}

	/**
	 * @generated NOT
	 */
	protected EObject getRelationshipContainer(Object uelement,
			EClass containerClass, IElementType relationshipType) {
		if(uelement instanceof EObject) {
			EObject element = (EObject)uelement;
			for(; element != null; element = element.eContainer()) {
				if(containerClass.isSuperTypeOf(element.eClass())) {
					return element;
				}
			}
		}
		return null;
	}

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
		private static UMLAbstractExpression Transition_3001_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Transition_3001_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression ElementOwnedComment_3002_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression CommentAnnotatedElement_3003_SourceExpression;

		/**
		 * @generated
		 */
		public static boolean canCreateTransition_3001(Region container,
				Vertex source, Vertex target) {
			return canExistTransition_3001(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateElementOwnedComment_3002(Element source,
				Comment target) {
			if(source != null) {
				if(source.getOwnedComments().contains(target)) {
					return false;
				}
				if(source == target) {
					return false;
				}
			}
			return canExistElementOwnedComment_3002(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateCommentAnnotatedElement_3003(
				Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_3003(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistTransition_3001(Region container,
				Vertex source, Vertex target) {
			try {
				if(source == null) {
					return true;
				}
				if(Transition_3001_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getVertex());
					Transition_3001_SourceExpression = UMLOCLFactory
							.getExpression("if(self.oclIsKindOf(uml::FinalState))\r\nthen false\r\nelse true\r\nendif", UMLPackage.eINSTANCE.getVertex(), env); //$NON-NLS-1$
				}
				Object sourceVal = Transition_3001_SourceExpression.evaluate(
						source, Collections.singletonMap(OPPOSITE_END_VAR,
						target));
				if(false == sourceVal instanceof Boolean
						|| !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Transition_3001_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getVertex());
					Transition_3001_TargetExpression = UMLOCLFactory
							.getExpression("if(self.oclIsKindOf(uml::Pseudostate) and self.oclAsType(uml::Pseudostate).kind = PseudostateKind::initial)\r\nthen false\r\nelse true\r\nendif", UMLPackage.eINSTANCE.getVertex(), env); //$NON-NLS-1$
				}
				Object targetVal = Transition_3001_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
						source));
				if(false == targetVal instanceof Boolean
						|| !((Boolean)targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistElementOwnedComment_3002(Element source,
				Comment target) {
			try {
				if(target == null) {
					return true;
				}
				if(ElementOwnedComment_3002_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					ElementOwnedComment_3002_TargetExpression = UMLOCLFactory
							.getExpression("not(self.annotatedElement->includes(oppositeEnd))", UMLPackage.eINSTANCE.getComment(), env); //$NON-NLS-1$
				}
				Object targetVal = ElementOwnedComment_3002_TargetExpression
						.evaluate(target, Collections.singletonMap(
						OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean
						|| !((Boolean)targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistCommentAnnotatedElement_3003(
				Comment source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(CommentAnnotatedElement_3003_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					CommentAnnotatedElement_3003_SourceExpression = UMLOCLFactory
							.getExpression("not(self.annotatedElement->includes(oppositeEnd))", UMLPackage.eINSTANCE.getComment(), env); //$NON-NLS-1$
				}
				Object sourceVal = CommentAnnotatedElement_3003_SourceExpression
						.evaluate(source, Collections.singletonMap(
						OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean
						|| !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

	}

}
