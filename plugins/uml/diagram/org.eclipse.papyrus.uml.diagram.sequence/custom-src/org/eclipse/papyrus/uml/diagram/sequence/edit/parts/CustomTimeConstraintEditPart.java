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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.TimeRelatedSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomTimeConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomTimeConstraintEditPart extends TimeConstraintEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomTimeConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomTimeConstraintItemSemanticEditPolicy());
	}

	/**
	 * @Override use ExternalLabelPrimaryDragRoleEditPolicy
	 */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case TimeConstraintLabelEditPart.VISUAL_ID:
				case TimeConstraintAppliedStereotypeEditPart.VISUAL_ID:
					// use ExternalLabelPrimaryDragRoleEditPolicy
					return new ExternalLabelPrimaryDragRoleEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * This method creates a specific edit policy for time realted elements
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#getPrimaryDragEditPolicy()
	 * 
	 * @return <code>EditPolicy</code>
	 * @Override
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new TimeRelatedSelectionEditPolicy();
	}

	/**
	 * @Override use ExternalLabelPositionLocator
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof TimeConstraintLabelEditPart || borderItemEditPart instanceof TimeConstraintAppliedStereotypeEditPart) {
			//use ExternalLabelPositionLocator
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @Override use correct dimensions
	 */
	@Override
	protected NodeFigure createNodePlate() {
		// use correct dimensions
		/*
		 * Bypass the preference mechanism which finally returns an incoherent constant hard written in NodePreferencePage.xpt templates.
		 * Instead, we shall use the correct default size.
		 */
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(TimeConstraintFigure.TIME_MARK_LENGTH, 1);
		//String prefElementId = "TimeConstraint";
		//IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		//String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		//String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		//DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new TimeConstraintFigure();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public TimeConstraintFigure getPrimaryShape() {
		return (TimeConstraintFigure)primaryShape;
	}

	public class TimeConstraintFigure extends TimeMarkElementFigure {

		/**
		 * the length of the time mark
		 * 
		 */
		private static final int TIME_MARK_LENGTH = 20;

		/**
		 * The side where the figure currently is
		 * 
		 */
		private int sideOfFigure = PositionConstants.NONE;

		/**
		 * Update the side of the lifeline where the figure lies
		 * 
		 * @param side
		 *        side where the figure must be
		 * @param newLocation
		 *        the new location rectangle
		 * @generated NOT
		 */
		public void setCurrentSideOfFigure(int side, Rectangle newLocation) {
			// no effect if side has not changed
			if(sideOfFigure != side && !(PositionConstants.NONE == sideOfFigure && side == PositionConstants.EAST)) {
				// mirror the label too
				IGraphicalEditPart labelChild = getChildBySemanticHint(UMLVisualIDRegistry.getType(TimeConstraintLabelEditPart.VISUAL_ID));
				if(labelChild instanceof TimeConstraintLabelEditPart) {
					TimeConstraintLabelEditPart label = (TimeConstraintLabelEditPart)labelChild;
					int labelWidth = label.getFigure().getMinimumSize().width;
					if(label.getNotationView() instanceof Node) {
						LayoutConstraint constraint = ((Node)label.getNotationView()).getLayoutConstraint();
						// update model location constraint for persisting the mirror effect
						if(constraint instanceof Location) {
							int xLocation = ((Location)constraint).getX();
							int mirroredLocation = -xLocation - labelWidth;
							TransactionalEditingDomain dom = getEditingDomain();
							org.eclipse.emf.common.command.Command setCmd = SetCommand.create(dom, constraint, NotationPackage.eINSTANCE.getLocation_X(), mirroredLocation);
							TransactionalCommandStack stack = (TransactionalCommandStack)dom.getCommandStack();
							Map<String, Boolean> options = new HashMap<String, Boolean>();
							options.put(Transaction.OPTION_NO_NOTIFICATIONS, true);
							options.put(Transaction.OPTION_NO_UNDO, true);
							options.put(Transaction.OPTION_UNPROTECTED, true);
							try {
								stack.execute(setCmd, options);
								// then, update graphically for short time effect
								IBorderItemLocator locator = label.getBorderItemLocator();
								Rectangle constrRect = ((ExternalLabelPositionLocator)locator).getConstraint();
								constrRect.x = mirroredLocation;
								locator.relocate(label.getFigure());
							} catch (InterruptedException e) {
								// log and skip update
								UMLDiagramEditorPlugin.log.error(e);
							} catch (RollbackException e) {
								// log and skip update
								UMLDiagramEditorPlugin.log.error(e);
							}
						}
					}
				}
			}
			sideOfFigure = side;
		}
	}
}
