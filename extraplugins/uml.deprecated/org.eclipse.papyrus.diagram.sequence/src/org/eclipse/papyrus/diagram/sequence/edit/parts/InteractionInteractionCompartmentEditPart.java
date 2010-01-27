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
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.ZOrderRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.commands.ChangeZOrderOfCreatedEP;
import org.eclipse.papyrus.diagram.common.editpolicies.DragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CreateLifelineAndBESCommand;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionCompartmentXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionInteractionCompartmentCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionInteractionCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceDiagramDragAndDropEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.Messages;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionInteractionCompartmentEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5001;

	/**
	 * @generated NOT
	 */
	private final ViewAndFeatureResolver resolver = new ViewAndFeatureResolver() {

		/**
		 * generated NOT
		 */
		public boolean isEObjectNode(EObject element) {
			if (element instanceof Interaction) {
				// Check if is children
				if (resolveSemanticElement().eContents().contains(element)) {
					// check if there is no existing view of the children
					if (DiagramEditPartsUtil.getEObjectViews(element).size() == 0)
						return true;
				}
			}
			return false;
		}

		public boolean isEObjectLink(EObject element) {
			return false;
		}

		public int getEObjectSemanticHint(EObject element) {
			if (element instanceof Interaction) {
				return UMLVisualIDRegistry.getNodeVisualID(getNotationView(),
						element);
			}
			return -1;
		}

		public EStructuralFeature getEStructuralFeatureForEClass(EClass class1) {
			return null;
		}
	};

	/**
	 * @generated
	 */
	public InteractionInteractionCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	public String getCompartmentName() {
		return Messages.InteractionInteractionCompartmentEditPart_title;
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * Modified to install custom Drag&Drop policy.
	 * 
	 * @author Gabriel Merin
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InteractionInteractionCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		DragDropEditPolicy dragAndDropEditPolicy = null;
		dragAndDropEditPolicy = new DragDropEditPolicy(resolver);
		// modified to install custom Drag&Drop policy.
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new SequenceDiagramDragAndDropEditPolicy(resolver));

		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new InteractionCompartmentXYLayoutEditPolicy());

		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new InteractionInteractionCompartmentCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		if (notification.getNotifier() instanceof ShapeStyle) {
			// Propagate style
			for (Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if (!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart) obj;

				if (ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle) ((View) ep.getModel())
						.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if (style != null) {
					style.eSet((EStructuralFeature) notification.getFeature(),
							notification.getNewValue());
					ep.refresh();
				}
			}

		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getInteraction_Fragment());
		features.add(UMLPackage.eINSTANCE.getInteraction_Lifeline());
		features.add(UMLPackage.eINSTANCE.getInteraction_Fragment());
		DiagramEditPartsUtil.handleNotificationForView(this, notification,
				features);
	}

	/**
	 * @generated
	 */
	@Override
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	 * When creating of a Lifeline a BES will be created too
	 * 
	 * @generated-NOT
	 */
	@Override
	public Command getCommand(Request _request) {

		// lets to create a CommentLink for an Activity by clicking in the
		// Subvertices Compartment
		if (_request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest cutcr = (CreateUnspecifiedTypeConnectionRequest) _request;
			String type = (String) cutcr.getType();
			IHintedType iet = (IHintedType) cutcr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_START
					.equals(type)
					&& String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID)
							.equals(id)) {
				if (cutcr.getTargetEditPart() instanceof InteractionInteractionCompartmentEditPart)
					cutcr.setTargetEditPart(getParent());
				return getParent().getCommand(cutcr);
			} else if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_END
					.equals(type)
					&& String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID)
							.equals(id)) {
				if (cutcr.getSourceEditPart() instanceof InteractionInteractionCompartmentEditPart)
					cutcr.setSourceEditPart(getParent());
				return getParent().getCommand(cutcr);
			}
		}

		// can create comments by clicking into the compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil
						.getDiagramEditPart(this).getCommand(_request);
			}
		}
		// don't let to move a comment into a compartment
		if (_request instanceof EditCommandRequestWrapper) {
			EditCommandRequestWrapper ecrw = (EditCommandRequestWrapper) _request;
			if (ecrw.getEditCommandRequest() instanceof MoveRequest) {
				MoveRequest mr = (MoveRequest) ecrw.getEditCommandRequest();
				for (Object o : mr.getElementsToMove().keySet()) {
					if (o instanceof Comment) {
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
		}// end

		if (_request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest request = (CreateViewAndElementRequest) _request;
			IElementType type = (IElementType) request
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter().getAdapter(
							IElementType.class);
			if (type.equals(UMLElementTypes.Lifeline_2002)) {
				CompoundCommand compoundCommand = new CompoundCommand(
						"Create Lifeline and BES");
				compoundCommand.add(super.getCommand(request));
				compoundCommand.add(new ICommandProxy(
						new CreateLifelineAndBESCommand(getEditingDomain(),
								request.getViewAndElementDescriptor(),
								getViewer())));
				return compoundCommand;
			}
			if (type.equals(UMLElementTypes.CombinedFragment_2004)) {
				CompoundCommand compoundCommand = new CompoundCommand(
						"Create Combined Fragment and send it to the back");
				compoundCommand.add(super.getCommand(request));
				compoundCommand.add(new ICommandProxy(
						new ChangeZOrderOfCreatedEP(getEditingDomain(), request
								.getViewAndElementDescriptor(), getViewer(),
								ZOrderRequest.REQ_SEND_TO_BACK)));
				return compoundCommand;
			}
			return super.getCommand(request);
		}

		return super.getCommand(_request);
	}

	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter != null && adapter.equals(ViewAndFeatureResolver.class)) {
			return this.resolver;
		}
		return super.getAdapter(adapter);
	}

}
