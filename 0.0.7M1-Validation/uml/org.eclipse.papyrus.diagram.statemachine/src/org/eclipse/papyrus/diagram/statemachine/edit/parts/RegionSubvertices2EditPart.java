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
package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueCommand;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueRequest;
import org.eclipse.papyrus.diagram.common.edit.policies.DragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.edit.policies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.RegionSubvertices2CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.RegionSubvertices2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.Messages;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class RegionSubvertices2EditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5002;

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
				return UMLVisualIDRegistry.getNodeVisualID(getNotationView(),
						element);
			}
			return -1;
		}

		public EStructuralFeature getEStructuralFeatureForEClass(EClass class1) {
			if (UMLPackage.eINSTANCE.getState().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getState().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getState().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getFinalState().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getPseudostate().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			if (UMLPackage.eINSTANCE.getState().equals(class1)) {
				return UMLPackage.eINSTANCE.getRegion_Subvertex();
			}
			return null;
		}
	};

	/**
	 * @generated
	 */
	public RegionSubvertices2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	public String getCompartmentName() {
		return Messages.RegionSubvertices2EditPart_title;
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
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RegionSubvertices2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		DragDropEditPolicy dragAndDropEditPolicy = null;
		dragAndDropEditPolicy = new DragDropEditPolicy(resolver);
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, dragAndDropEditPolicy);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new RegionSubvertices2CanonicalEditPolicy());
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
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
		features.add(UMLPackage.eINSTANCE.getRegion_Subvertex());
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
	 * @generated NOT
	 * 
	 * Used to modify <i>transition</i> property in case of drag and drop of a
	 * vertex and wrap substatemachine creation.
	 */
	@Override
	public Command getCommand(Request _request) {

		// if an element is being added
		if (RequestConstants.REQ_ADD.equals(_request.getType())) {
			if (_request instanceof ChangeBoundsRequest) {
				Command superCommand = super.getCommand(_request);
				ChangeBoundsRequest request = (ChangeBoundsRequest) _request;
				Command command = getAddTransitionsOnAddChild(request);
				if (command != null) {
					CompoundCommand cc = new CompoundCommand();
					cc.add(superCommand);
					cc.add(command);
					return cc;
				} else {
					return superCommand;
				}
			}
		}

		// lets to create a CommentLink for a StateMachine by clicking in the
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
				if (cutcr.getTargetEditPart() instanceof RegionSubvertices2EditPart)
					cutcr.setTargetEditPart(getParent().getParent());
				return getParent().getParent().getCommand(cutcr);
			} else if (org.eclipse.gef.RequestConstants.REQ_CONNECTION_END
					.equals(type)
					&& String.valueOf(ElementOwnedCommentEditPart.VISUAL_ID)
							.equals(id)) {
				if (cutcr.getSourceEditPart() instanceof RegionSubvertices2EditPart)
					cutcr.setSourceEditPart(getParent().getParent());
				return getParent().getParent().getCommand(cutcr);
			}
		}

		// can create parent elements by clicking into the compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(RegionEditPart.VISUAL_ID).equals(id)
							|| String.valueOf(
									ConnectionPointReferenceEditPart.VISUAL_ID)
									.equals(id) || String.valueOf(
							ConnectionPointReference2EditPart.VISUAL_ID)
							.equals(id))) {
				return getParent().getParent().getCommand(_request);
			}
		}
		// end

		// can create comments by clicking into the compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			if (org.eclipse.gef.RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return DiagramEditPartsUtil
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
	 * @generated NOT
	 * @param request
	 *            ChangeBoundsRequest with required information
	 * @return Command to add transitions to this region and remove them from
	 *         source region
	 */
	private Command getAddTransitionsOnAddChild(ChangeBoundsRequest request) {
		List<EditPart> parts = request.getEditParts();

		if (parts == null || parts.size() <= 0) {
			return null;
		}

		Command command = null;

		if (parts.size() == 1) {
			EObject element = ((View) parts.get(0).getModel()).getElement();
			if (element instanceof Vertex) {
				command = getAdaptTransition((Vertex) element);
			}
		} else {
			command = new CompoundCommand();
			for (EditPart ep : parts) {
				EObject element = ((View) ep.getModel()).getElement();
				if (element instanceof Vertex) {
					Command c = getAdaptTransition((Vertex) element);
					if (c != null) {
						((CompoundCommand) command).add(c);
					}
				}
			}
			if (((CompoundCommand) command).size() <= 0) {
				command = null;
			}
		}

		return command;
	}

	/**
	 * @geerated NOT
	 * @param vertex
	 *            vertex to analize
	 * @return command to add transition to this region and remove it from
	 *         source
	 */
	private Command getAdaptTransition(Vertex vertex) {

		// remove all outgoing transitions from source region
		List<Transition> outgoings = vertex.getOutgoings();
		Region oldContainer = vertex.getContainer();
		RemoveValueRequest removeRequest = new RemoveValueRequest(oldContainer,
				UMLPackage.eINSTANCE.getRegion_Transition(), outgoings);
		RemoveValueCommand removeCommand = new RemoveValueCommand(removeRequest);

		CompoundCommand cc = new CompoundCommand();
		if (removeCommand != null) {
			cc.add(new ICommandProxy(removeCommand));
		}

		// add all outgoing transitions to target (this) region
		Region thisContainer = (Region) ((View) getModel()).getElement();
		for (Transition t : outgoings) {
			SetRequest setRequest = new SetRequest(thisContainer,
					UMLPackage.eINSTANCE.getRegion_Transition(), t);
			SetValueCommand setCommand = new SetValueCommand(setRequest);
			if (setCommand != null) {
				cc.add(new ICommandProxy(setCommand));
			}
		}

		if (cc.size() <= 0) {
			return null;
		} else {
			return cc;
		}
	}

}
