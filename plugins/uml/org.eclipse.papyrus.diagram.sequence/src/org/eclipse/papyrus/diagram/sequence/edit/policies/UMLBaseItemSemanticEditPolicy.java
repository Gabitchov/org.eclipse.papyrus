/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

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
import org.eclipse.papyrus.diagram.sequence.edit.helpers.UMLBaseEditHelper;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
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
	private IElementType getContextElementType(IEditCommandRequest request) {
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
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4003_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4003_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4004_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4004_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4005_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4005_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4006_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4006_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4007_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4007_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4008_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4008_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4009_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Message_4009_TargetExpression;

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4003(Interaction container, Element source, Element target) {
			return canExistMessage_4003(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4004(Interaction container, Element source, Element target) {
			return canExistMessage_4004(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4005(Interaction container, Element source, Element target) {
			return canExistMessage_4005(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4006(Interaction container, Element source, Element target) {
			return canExistMessage_4006(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4007(Interaction container, Element source, Element target) {
			return canExistMessage_4007(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4008(Interaction container, Element source, Element target) {
			return canExistMessage_4008(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMessage_4009(Interaction container, Element source, Element target) {
			return canExistMessage_4009(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateCommentAnnotatedElement_4010(Comment source, Element target) {
			if(source != null) {
				if(source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}

			return canExistCommentAnnotatedElement_4010(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateConstraintConstrainedElement_4011(Constraint source, Element target) {
			if(source != null) {
				if(source.getConstrainedElements().contains(target)) {
					return false;
				}
			}

			return canExistConstraintConstrainedElement_4011(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistMessage_4003(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4003_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4003_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4003_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4003_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4003_TargetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4003_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4004(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4004_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4004_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4004_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4004_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4004_TargetExpression = UMLOCLFactory.getExpression("(self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)) and (self.owner = oppositeEnd.owner or self.owner = oppositeEnd or self = oppositeEnd.owner)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4004_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4005(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4005_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4005_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4005_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4005_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4005_TargetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4005_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4006(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4006_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4006_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4006_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4006_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4006_TargetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Lifeline)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4006_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4007(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4007_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4007_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4007_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4007_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4007_TargetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Lifeline)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4007_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4008(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4008_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4008_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Lifeline) or self.oclIsKindOf(uml::InteractionFragment)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4008_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4008_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4008_TargetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Interaction)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4008_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistMessage_4009(Interaction container, Element source, Element target) {
			try {
				if(source == null) {
					return true;
				}
				if(Message_4009_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4009_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Interaction)", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object sourceVal = Message_4009_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if(false == sourceVal instanceof Boolean || !((Boolean)sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				if(target == null) {
					return true;
				}
				if(Message_4009_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getElement());
					Message_4009_TargetExpression = UMLOCLFactory.getExpression("(self.oclIsKindOf(uml::Lifeline) or self.oclIsKindOf(uml::InteractionFragment))", UMLPackage.eINSTANCE.getElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Message_4009_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if(false == targetVal instanceof Boolean || !((Boolean)targetVal).booleanValue()) {
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
		public static boolean canExistCommentAnnotatedElement_4010(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistConstraintConstrainedElement_4011(Constraint source, Element target) {
			return true;
		}

	}
}
