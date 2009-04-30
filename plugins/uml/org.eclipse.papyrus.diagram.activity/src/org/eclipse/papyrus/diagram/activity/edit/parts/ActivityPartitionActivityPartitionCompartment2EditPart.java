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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.commands.AddChildToActivityPartitionCommand;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityPartitionActivityPartitionCompartment2CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityPartitionActivityPartitionCompartment2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.edit.policies.DragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.edit.policies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivityPartitionActivityPartitionCompartment2EditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5003;

	/**
	 * @generated NOT
	 */
	private ViewAndFeatureResolver resolver = new ViewAndFeatureResolver() {

		public boolean isEObjectNode(EObject element) {
			if (UMLVisualIDRegistry.getNodeVisualID(getNotationView(), element) > -1) {
				return true;
			}
			return false;
		}

		public boolean isEObjectLink(EObject element) {
			if (UMLVisualIDRegistry.getLinkWithClassVisualID(element) > -1) {
				return true;
			}
			return false;
		}

		public int getEObjectSemanticHint(EObject element) {
			if (element != null) {
				return UMLVisualIDRegistry.getNodeVisualID(getNotationView(), element);
			}
			return -1;
		}

		public EStructuralFeature getEStructuralFeatureForEClass(EClass class1) {
			if (UMLPackage.eINSTANCE.getActivityPartition().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivityPartition_Subpartition();
			}
			// OpaqueAction feature should be Activity_Node too
			if (UMLPackage.eINSTANCE.getOpaqueAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			// AcceptEventAction feature should be Activity_Node too
			if (UMLPackage.eINSTANCE.getAcceptEventAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getMergeNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getInitialNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getForkNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getJoinNode().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getPin().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			return null;
		}
	};

	/**
	 * @generated
	 */
	public ActivityPartitionActivityPartitionCompartment2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	public String getCompartmentName() {
		return Messages.ActivityPartitionActivityPartitionCompartment2EditPart_title;
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * Modified to install a special LayoutEditPolicy
	 * 
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityPartitionActivityPartitionCompartment2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		DragDropEditPolicy dragAndDropEditPolicy = null;
		dragAndDropEditPolicy = new DragDropEditPolicy(resolver) {

			// don't highlight the target if the element to drag is a Label
			@Override
			public void showTargetFeedback(Request request) {
				if (request instanceof ChangeBoundsRequest) {
					for (Object o : ((ChangeBoundsRequest) request).getEditParts()) {
						if (o instanceof LabelEditPart)
							return;
					}
				}
				super.showTargetFeedback(request);
			}
		};
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, dragAndDropEditPolicy);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActivityPartitionActivityPartitionCompartment2CanonicalEditPolicy());
		// fjcano : special layout policy to trat ActivityPartitions
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ActivityXYLayoutEditPolicy());
	}

	/**
	 * Modified to refresh contained ActivityPartitions
	 * 
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		boolean refreshed = false;
		java.lang.Object notifier = notification.getNotifier();
		java.lang.Object feature = notification.getFeature();
		java.lang.Object oldValue = notification.getOldValue();
		java.lang.Object newValue = notification.getNewValue();
		if (notifier != null && notifier.equals(resolveSemanticElement())) {

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivityPartition_Subpartition()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getStructuredActivityNode_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getStructuredActivityNode_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

			if (!refreshed && feature != null && feature.equals(UMLPackage.eINSTANCE.getActivity_Node()) && oldValue != null && oldValue != newValue) {
				refreshed = true;
			}

		}
		// Activity partitions need refresh too.
		if (refreshed) {
			for (Object o : getChildren()) {
				if (o instanceof ActivityPartition2EditPart) {
					DiagramEditPartsUtil.updateEditPartAndChildren(((IGraphicalEditPart) o), UMLPackage.eINSTANCE.getActivityPartition());
				}
			}
			DiagramEditPartsUtil.updateDiagram(this);
		}

		// reorder activity partitions
		if (oldValue instanceof Node) {
			Node n = (Node) oldValue;
			if (n.getType().compareTo(String.valueOf(ActivityPartition2EditPart.VISUAL_ID)) == 0) {
				EditCommandRequestWrapper ecrw = new EditCommandRequestWrapper("wrap semantic request", new DestroyElementRequest(false));
				Command c = getCommand(ecrw);
				getEditDomain().getCommandStack().execute(c);
			}
		}
		// end reorder activity partitions
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
	 * @generated not
	 */
	@Override
	public Command getCommand(Request _request) {
		if (org.eclipse.gef.RequestConstants.REQ_ADD.equals(_request.getType())) {
			if (_request instanceof ChangeBoundsRequest) {
				return new AddChildToActivityPartitionCommand((ChangeBoundsRequest) _request, (IAdaptable) getAdapter(IAdaptable.class));
			}

			return super.getCommand(_request);
		}
		if (org.eclipse.gef.RequestConstants.REQ_ORPHAN.equals(_request.getType())) {
			return super.getCommand(_request);
		}
		// reorder activity partitions
		if (org.eclipse.gef.RequestConstants.REQ_DELETE.equals(_request.getType())) {
			return getEditPolicy(EditPolicy.LAYOUT_ROLE).getCommand(_request);
		}
		if (_request instanceof EditCommandRequestWrapper && ((EditCommandRequestWrapper) _request).getEditCommandRequest() instanceof DestroyElementRequest) {
			return getEditPolicy(EditPolicy.LAYOUT_ROLE).getCommand(_request);
		}
		// end reorder activity partitions

		// lets to create a CommentLink for an Activity by clicking in the
		// ActivityPartitionCompartment
		if (_request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest cutcr = (CreateUnspecifiedTypeConnectionRequest) _request;
			String type = (String) cutcr.getType();
			IHintedType iet = (IHintedType) cutcr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_START.equals(type) && String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID).equals(id)) {
				if (cutcr.getTargetEditPart() instanceof ActivityPartitionActivityPartitionCompartment2EditPart)
					cutcr.setTargetEditPart(getParent());
				return getParent().getCommand(cutcr);
			} else if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_END.equals(type) && String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID).equals(id)) {
				if (cutcr.getSourceEditPart() instanceof ActivityPartitionActivityPartitionCompartment2EditPart)
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

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type) && (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return DiagramEditPartsUtil.getDiagramEditPart(this).getCommand(_request);
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
