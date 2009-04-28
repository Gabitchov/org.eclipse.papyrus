package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class InterfaceItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RedefinableTemplateSignatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(node)) {
			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(incomingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(outgoingLink) == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(cnode)) {
					case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(cnode)) {
					case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(cnode)) {
					case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClass2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClass2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClassReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2ReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InterfaceRealizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.DependencyReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2ReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PackageImportReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.CommentAnnotatedElementReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
