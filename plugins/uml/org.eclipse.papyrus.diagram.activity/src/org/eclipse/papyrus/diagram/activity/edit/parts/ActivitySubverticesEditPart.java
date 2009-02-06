/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.commands.AddChildToActivityPartitionCommand;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivitySubverticesCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivitySubverticesItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.edit.policies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

/**
 * @generated
 */
public class ActivitySubverticesEditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5001;

	/**
	 * @generated
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
			if (UMLPackage.eINSTANCE.getSendObjectAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Node();
			}
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
			if (UMLPackage.eINSTANCE.getOpaqueAction().equals(class1)) {
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
			if (UMLPackage.eINSTANCE.getActivityPartition().equals(class1)) {
				return UMLPackage.eINSTANCE.getActivity_Group();
			}
			return null;
		}
	};

	/**
	 * @generated
	 */
	public ActivitySubverticesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	public String getCompartmentName() {
		return Messages.ActivitySubverticesEditPart_title;
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
	 * Modified to install a special layout.
	 * 
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		;
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivitySubverticesItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		org.eclipse.papyrus.diagram.common.edit.policies.DragDropEditPolicy dragAndDropEditPolicy = null;
		dragAndDropEditPolicy = new org.eclipse.papyrus.diagram.common.edit.policies.DragDropEditPolicy(resolver) {

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
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActivitySubverticesCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ActivityXYLayoutEditPolicy());
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
	 * Modified to update <ActivityPartition>s references when <ActivityNode>s are moved/created
	 * 
	 * @generated NOT
	 */
	@Override
	public Command getCommand(Request _request) {
		if (org.eclipse.gef.RequestConstants.REQ_ADD.equals(_request.getType())) {
			if (_request instanceof ChangeBoundsRequest) {
				ChangeBoundsRequest request = (ChangeBoundsRequest) _request;
				return new AddChildToActivityPartitionCommand(request, (IAdaptable) getAdapter(IAdaptable.class));
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
		// Subvertices Compartment
		if (_request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest cutcr = (CreateUnspecifiedTypeConnectionRequest) _request;
			String type = (String) cutcr.getType();
			IHintedType iet = (IHintedType) cutcr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_START.equals(type) && String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID).equals(id)) {
				if (cutcr.getTargetEditPart() instanceof ActivitySubverticesEditPart)
					cutcr.setTargetEditPart(getParent());
				return getParent().getCommand(cutcr);
			} else if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_END.equals(type) && String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID).equals(id)) {
				if (cutcr.getSourceEditPart() instanceof ActivitySubverticesEditPart)
					cutcr.setSourceEditPart(getParent());
				return getParent().getCommand(cutcr);
			}
		}
		// lets to create an ActivityParameterNode by clicking in the
		// Subvertices Compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type) && String.valueOf(ActivityParameterNodeEditPart.VISUAL_ID).equals(id)) {
				return getParent().getCommand(_request);
			}
		}
		if (_request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest cvaer = (CreateViewAndElementRequest) _request;
			String type = (String) cvaer.getType();
			CreateViewAndElementRequest.ViewAndElementDescriptor vaed = (CreateViewAndElementRequest.ViewAndElementDescriptor) cvaer.getViewDescriptors().get(0);
			String id = vaed.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type) && String.valueOf(ActivityParameterNodeEditPart.VISUAL_ID).equals(id)) {
				return getParent().getCommand(_request);
			}
		}// end

		// can create comments by clicking into the compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type) && (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil.getDiagramEditPart(this).getCommand(_request);
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

	/**
	 * removes all editParts that have an <ActivityPartition> as semantic element
	 * 
	 * @param selection
	 */
	private List removeActivityPartitionsFromSelection(List selection) {
		List purgedSelection = new ArrayList();
		for (Object o : selection) {
			if (o instanceof EditPart) {
				EObject element = null;
				Object model = ((EditPart) o).getModel();
				if (model instanceof EObject) {
					element = (EObject) model;
				}
				if (model instanceof View) {
					element = ((View) model).getElement();
				}
				if (element instanceof ActivityPartition == false) {
					purgedSelection.add(o);
				}
			}
		}
		return purgedSelection;
	}

	/**
	 * Modified to refresh children <ActivityPartition>s when needed.
	 * 
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		for (Iterator it = this.getChildren().iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof ActivityPartitionEditPart)
				((ActivityPartitionEditPart) o).refresh();
			else if (o instanceof OpaqueActionEditPart && event.getEventType() != Notification.REMOVE)
				((OpaqueActionEditPart) o).refresh();
		}

		if (event.getNotifier() instanceof ShapeStyle) {
			// Propagate style
			for (Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if (!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart) obj;

				if (ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle) ((View) ep.getModel()).getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if (style != null) {
					style.eSet((EStructuralFeature) event.getFeature(), event.getNewValue());
					ep.refresh();
				}
			}
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getActivity_Node());
		features.add(UMLPackage.eINSTANCE.getActivity_Group());
		features.add(UMLPackage.eINSTANCE.getActivity_Edge());
		features.add(UMLPackage.eINSTANCE.getActivity_Partition());
		org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil.handleNotificationForView(this, event, features);

		// Activity partitions need refresh too.
		for (Object o : getChildren()) {
			if (o instanceof ActivityPartitionEditPart) {
				DiagramEditPartsUtil.updateEditPartAndChildren(((IGraphicalEditPart) o), UMLPackage.eINSTANCE.getActivityPartition());
			}
		}

		// reorder activity partitions
		if (event.getOldValue() instanceof Node) {
			Node n = (Node) event.getOldValue();
			if (n.getType().compareTo(String.valueOf(ActivityPartitionEditPart.VISUAL_ID)) == 0) {
				EditCommandRequestWrapper ecrw = new EditCommandRequestWrapper("wrap semantic request", new DestroyElementRequest(false));
				Command c = getCommand(ecrw);
				getEditDomain().getCommandStack().execute(c);
			}
		}
		// end reorder activity partitions
	}
}
