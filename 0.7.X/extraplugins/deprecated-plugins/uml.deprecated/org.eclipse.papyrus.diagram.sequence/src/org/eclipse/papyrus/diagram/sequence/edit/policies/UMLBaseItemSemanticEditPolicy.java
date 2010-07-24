/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.sequence.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;

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
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart()
					.getModel();
			if (view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry
						.getVisualID((View) view));
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
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Object editHelperContext = completedRequest.getEditHelperContext();
		if (editHelperContext instanceof View
				|| (editHelperContext instanceof IEditHelperContext && ((IEditHelperContext) editHelperContext)
						.getEObject() instanceof View)) {
			// no semantic commands are provided for pure design elements
			return null;
		}
		if (editHelperContext == null) {
			editHelperContext = ViewUtil
					.resolveSemanticElement((View) getHost().getModel());
		}
		IElementType elementType = ElementTypeRegistry.getInstance()
				.getElementType(editHelperContext);
		if (elementType == ElementTypeRegistry.getInstance().getType(
				"org.eclipse.gmf.runtime.emf.type.core.default")) { //$NON-NLS-1$ 
			elementType = null;
		}
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		if (semanticCommand != null) {
			ICommand command = semanticCommand instanceof ICommandProxy ? ((ICommandProxy) semanticCommand)
					.getICommand()
					: new CommandProxy(semanticCommand);
//			completedRequest.setParameter(
//					UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		if (elementType != null) {
			ICommand command = elementType.getEditCommand(completedRequest);
			if (command != null) {
				if (!(command instanceof CompositeTransactionalCommand)) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
							.getEditingDomain();
					command = new CompositeTransactionalCommand(editingDomain,
							command.getLabel()).compose(command);
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
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
						.getEditingDomain();
				Command deleteViewCommand = new ICommandProxy(
						new DeleteCommand(editingDomain, (View) getHost()
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
		return ViewUtil.resolveSemanticElement((View) getHost().getModel());
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
	 * Creates command to destroy the link.
	 * 
	 * @generated
	 */
	protected Command getDestroyElementCommand(View view) {
		EditPart editPart = (EditPart) getHost().getViewer()
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
	protected void addDestroyShortcutsCommand(CompoundCommand command) {
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return;
		}
		for (Iterator it = view.getDiagram().getChildren().iterator(); it
				.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			command.add(getDestroyElementCommand(nextView));
		}
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
		private static UMLAbstractExpression Message_3001_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_3002_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_3003_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_3004_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_3005_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_3006_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression ElementOwnedComment_3007_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression CommentAnnotatedElement_3008_SourceExpression;

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3001(Interaction container,
				Element source, Element target) {
			return canExistMessage_3001(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3002(Interaction container,
				Element source, Element target) {
			return canExistMessage_3002(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3003(Interaction container,
				Element source, Element target) {
			return canExistMessage_3003(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3004(Interaction container,
				Element source, Element target) {
			return canExistMessage_3004(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3005(Interaction container,
				Element source, Element target) {
			return canExistMessage_3005(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_3006(Interaction container,
				Element source, Element target) {
			return canExistMessage_3006(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateElementOwnedComment_3007(Element source,
				Comment target) {
			if (source != null) {
				if (source.getOwnedComments().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			return canExistElementOwnedComment_3007(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateCommentAnnotatedElement_3008(
				Comment source, Element target) {
			if (source != null) {
				if (source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}
			return canExistCommentAnnotatedElement_3008(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3001(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3001_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3001_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3001_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3002(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3002_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3002_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3002_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3003(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3003_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3003_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3003_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3004(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3004_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3004_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3004_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3005(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3005_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3005_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3005_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_3006(Interaction container,
				Element source, Element target) {
			try {
				if (target == null) {
					return true;
				}
				if (Message_3006_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					Message_3006_TargetExpression = UMLOCLFactory
							.getExpression(
									"((self.oclIsKindOf(uml::ExecutionSpecification) or self.oclIsKindOf(uml::Lifeline)) and (oppositeEnd.oclIsKindOf(uml::ExecutionSpecification) or oppositeEnd.oclIsKindOf(uml::Lifeline))) and (self.eContainer() = oppositeEnd.eContainer())", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_3006_TargetExpression.evaluate(
						target, Collections.singletonMap(OPPOSITE_END_VAR,
								source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistElementOwnedComment_3007(Element source,
				Comment target) {
			try {
				if (target == null) {
					return true;
				}
				if (ElementOwnedComment_3007_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					ElementOwnedComment_3007_TargetExpression = UMLOCLFactory
							.getExpression(
									"not(self.annotatedElement->includes(oppositeEnd))", UMLPackage.eINSTANCE.getComment(), env); //$NON-NLS-1$
				}
				Object targetVal = ElementOwnedComment_3007_TargetExpression
						.evaluate(target, Collections.singletonMap(
								OPPOSITE_END_VAR, source));
				if (false == targetVal instanceof Boolean
						|| !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistCommentAnnotatedElement_3008(
				Comment source, Element target) {
			try {
				if (source == null) {
					return true;
				}
				if (CommentAnnotatedElement_3008_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR,
							UMLPackage.eINSTANCE.getElement());
					CommentAnnotatedElement_3008_SourceExpression = UMLOCLFactory
							.getExpression(
									"not(self.annotatedElement->includes(oppositeEnd))", UMLPackage.eINSTANCE.getComment(), env); //$NON-NLS-1$
				}
				Object sourceVal = CommentAnnotatedElement_3008_SourceExpression
						.evaluate(source, Collections.singletonMap(
								OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean
						|| !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

	}

}
