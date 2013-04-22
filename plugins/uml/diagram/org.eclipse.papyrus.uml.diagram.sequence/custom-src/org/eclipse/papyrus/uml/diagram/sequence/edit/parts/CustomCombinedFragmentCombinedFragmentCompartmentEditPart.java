/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomCombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperandBoundsComputeHelper;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragmentCombinedFragmentCompartmentEditPart extends CombinedFragmentCombinedFragmentCompartmentEditPart {

	/**
	 * Children string for notification event type.
	 */
	private static final String CHILDREN_TYPE = "children";

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomCombinedFragmentCombinedFragmentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * Not generated for delete borders add stretch children figures.
	 * 
	 * @Override
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.getScrollPane().setVerticalScrollBarVisibility(ScrollPane.NEVER);
		result.setTitleVisibility(false);
		result.setBorder(null);
		IFigure contentPane = result.getContentPane();
		if(contentPane != null) {
			contentPane.setBorder(null);
			//fix Scroll bars(https://bugs.eclipse.org/bugs/show_bug.cgi?id=364697)
			contentPane.setLayoutManager(new XYLayout());
			//			LayoutManager layout = contentPane.getLayoutManager();
			//			if(layout instanceof ConstrainedToolbarLayout) {
			//				ConstrainedToolbarLayout constrainedToolbarLayout = (ConstrainedToolbarLayout)layout;
			//				constrainedToolbarLayout.setStretchMajorAxis(true);
			//				constrainedToolbarLayout.setStretchMinorAxis(true);
			//			}
		}
		return result;
	}

	/**
	 * Add RemoveOrphanView role
	 * 
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomCombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, createCreationEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
	}

	private EditPolicy createCreationEditPolicy() {
		return new PapyrusCreationEditPolicy() {

			@Override
			protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
				//THIS WAS ALREADY DID IN getCreateCommand(), WHY AGAIN?
				//				Command createCommand = super.getCreateElementAndViewCommand(request);
				//				if (createCommand == null || !createCommand.canExecute()){
				//					return createCommand;
				//				}
				//				ICommandProxy commandProxy = (ICommandProxy)createCommand;
				//				CompositeCommand command = (CompositeCommand)commandProxy.getICommand();
				//				
				//				IHintedType type = (IHintedType)UMLElementTypes.InteractionOperand_3005;
				//				if(type.getSemanticHint().equals(request.getViewAndElementDescriptor().getSemanticHint())) {
				//					//fix Scroll bars(https://bugs.eclipse.org/bugs/show_bug.cgi?id=364697), note that we use XYLayout
				//					//to relocate both its bounds and combined fragment bounds when operand is added to combined fragment 
				//					OperandBoundsComputeHelper.addUpdateBoundsForIOCreationCommand(CombinedFragmentCombinedFragmentCompartmentEditPart.this, request.getViewAndElementDescriptor(), command);
				//				}
				//				return commandProxy;
				return super.getCreateElementAndViewCommand(request);
			}

			@Override
			protected Command getCreateCommand(CreateViewRequest request) {
				ICommandProxy commandProxy = (ICommandProxy)super.getCreateCommand(request);
				ICommand command = commandProxy.getICommand();
				CompositeCommand compositeCommand = null;
				if(command instanceof CompositeCommand) {
					compositeCommand = (CompositeCommand)command;
				} else {
					compositeCommand = new CompositeCommand(commandProxy.getLabel());
					compositeCommand.add(command);
				}
				for(ViewDescriptor viewDescriptor : request.getViewDescriptors()) {
					IHintedType type = (IHintedType)UMLElementTypes.InteractionOperand_3005;
					if(type.getSemanticHint().equals(viewDescriptor.getSemanticHint())) {
						//fix Scroll bars(https://bugs.eclipse.org/bugs/show_bug.cgi?id=364697), note that we use XYLayout
						//to relocate both its bounds and combined fragment bounds when operand is added to combined fragment 
						OperandBoundsComputeHelper.addUpdateBoundsForIOCreationCommand(CustomCombinedFragmentCombinedFragmentCompartmentEditPart.this, viewDescriptor, compositeCommand);
					}
				}
				return new ICommandProxy(compositeCommand.reduce());
			}
		};
	}

	/**
	 * Not generated for handle the first InteractionOperand case (no LineSeparator) {@inheritDoc}
	 * 
	 */
	@Override
	protected EditPart createChild(Object model) {
		EditPart child = super.createChild(model);
		if(getChildren() == null || getChildren().isEmpty() && child instanceof CustomInteractionOperandEditPart) {
			((CustomInteractionOperandEditPart)child).setFirstOperand(true);
		}
		return child;
	}

	/**
	 * Handle the first InteractionOperand deletion case (change FirstOperand attribute)
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if(feature instanceof EStructuralFeature) {
			EStructuralFeature ref = (EStructuralFeature)feature;
			String typeName = ref.getName();
			if(CHILDREN_TYPE.equals(typeName)) {
				if(event.getEventType() == Notification.UNSET || event.getEventType() == Notification.REMOVE) {
					List<?> children = getChildren();
					if(children != null && children.size() > 1) {
						Object firstChild = children.get(0);
						if(firstChild instanceof CustomInteractionOperandEditPart) {
							CustomInteractionOperandEditPart firstOperandChild = (CustomInteractionOperandEditPart)firstChild;
							Object firstChildModel = firstOperandChild.getModel();
							if(firstChildModel != null && firstChildModel.equals(event.getOldValue()) && children.get(1) instanceof CustomInteractionOperandEditPart) {
								CustomInteractionOperandEditPart secondOperandChild = (CustomInteractionOperandEditPart)children.get(1);
								secondOperandChild.setFirstOperand(true);
							}
						}
					}
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	public boolean ignoreRequest(Request request) {
		if(request instanceof ChangeBoundsRequest && (request.getType().equals(org.eclipse.gef.RequestConstants.REQ_ADD) || request.getType().equals(RequestConstants.REQ_DROP))) {
			List parts = ((ChangeBoundsRequest)request).getEditParts();
			if(parts != null) {
				for(Object obj : parts) {
					if(obj instanceof CommentEditPart || obj instanceof ConstraintEditPart || obj instanceof TimeObservationEditPart) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void showTargetFeedback(Request request) {
		if(ignoreRequest(request)) {
			return;
		}
		super.showTargetFeedback(request);
	}

	@Override
	public Command getCommand(Request request) {
		if(ignoreRequest(request)) {
			return null;
		}
		return super.getCommand(request);
	}
}
