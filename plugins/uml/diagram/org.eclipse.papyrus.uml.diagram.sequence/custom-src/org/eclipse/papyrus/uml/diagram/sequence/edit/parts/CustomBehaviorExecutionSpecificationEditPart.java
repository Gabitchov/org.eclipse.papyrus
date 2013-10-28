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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart.DummyCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ExecutionGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomBehaviorExecutionSpecificationItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.BehaviorDisplayHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417376. Display the behavior of an BehaviorExecutionSpecification as a Label.
 * 
 * IMPORTANT, the new behavior label was added to the BorderedNodeFigure of Interaction, it seems there are some problems about moving when it was
 * added
 * on the BorderedNodeFigure of current BehaviorExecutionSpecification EditPart.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomBehaviorExecutionSpecificationEditPart extends BehaviorExecutionSpecificationEditPart {

	private NotificationHelper helper = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Registered a removing listener in parent editpart, this can help us to remove the behavior label(tips: behavior label was added to interaction
	 * figure.).
	 */
	private EditPartListener selfRemovingListener;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomBehaviorExecutionSpecificationEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomBehaviorExecutionSpecificationItemSemanticEditPolicy());
		//Fixed bug about reconnect message when the ends of execution were MessageOccurrenceSpecification. 
		removeEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ExecutionGraphicalNodeEditPolicy());
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if(child instanceof BehaviorExecutionSpecificationBehaviorEditPart) {
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}

						protected Command getMoveCommand(ChangeBoundsRequest request) {
							IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
							IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();

							if(borderItemLocator != null) {
								LayoutConstraint layout = ((Node)getHost().getModel()).getLayoutConstraint();
								Point location = new Point();
								if(layout instanceof Location) {
									location.x = ((Location)layout).getX();
									location.y = ((Location)layout).getY();
								}
								location.translate(request.getMoveDelta());

								ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
								return new ICommandProxy(moveCommand);
							}
							return null;
						}


					};
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is no more stuck with the middle of the
	 * figure.
	 * 
	 * @Override
	 */
	@Override
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(16, 60) {

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}

			@Override
			public ConnectionAnchor getConnectionAnchor(String terminal) {
				//Use FixedAnchorEx for MessageSync, this will be invoked by mapConnectionAnchor(termial) operation.
				if(terminal != null && terminal.indexOf("{") != -1 && terminal.indexOf("}") != -1) {
					int position = AnchorHelper.FixedAnchorEx.parsePosition(terminal);
					if(PositionConstants.TOP == position || PositionConstants.BOTTOM == position) {
						return new AnchorHelper.FixedAnchorEx(this, position);
					}
				}
				return super.getConnectionAnchor(terminal);
			}
		};
		result.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20))); // min height 20
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @Override
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		//figure.setLayoutManager(new StackLayout());
		figure.setLayoutManager(new DelegatingLayout());
		IFigure shape = createNodeShape();
		figure.add(shape, new FillParentLocator());
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * We did NOT use a BorderedNodeFigure in current EditPart. There are some problems about moving external labels.
	 * 
	 * We just find and use the root(Interaction) BorderedNodeFigure.
	 */
	private BorderedNodeFigure getBorderedFigure() {
		EditPart parent = getParent();
		while(parent != null && !(parent instanceof CustomInteractionEditPart)) {
			parent = parent.getParent();
		}
		if(parent != null) {
			return ((CustomInteractionEditPart)parent).getBorderedFigure();
		}
		return null;
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(childEditPart instanceof BehaviorExecutionSpecificationBehaviorEditPart) {
			IFigure childFigure = ((BehaviorExecutionSpecificationBehaviorEditPart)childEditPart).getFigure();
			BorderedNodeFigure borderedFigure = getBorderedFigure();
			final IFigure figure = getFigure();
			BehaviorLabelLocator locator = new BehaviorLabelLocator(figure);
			if(borderedFigure != null) {
				borderedFigure.getBorderItemContainer().add(childFigure, locator);
			}
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if(childEditPart instanceof BehaviorExecutionSpecificationBehaviorEditPart) {
			IFigure childFigure = ((BehaviorExecutionSpecificationBehaviorEditPart)childEditPart).getFigure();
			BorderedNodeFigure borderedFigure = getBorderedFigure();
			if(borderedFigure != null) {
				borderedFigure.getBorderItemContainer().remove(childFigure);
			}
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart#setLineWidth(int)
	 * 
	 * @param width
	 */
	@Override
	protected void setLineWidth(int width) {
		//		super.setLineWidth(width);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBehavior();
	}

	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		refreshBehavior();
	}

	protected void refreshBehavior() {
		if(!BehaviorDisplayHelper.shouldDisplayBehavior(getNotationView())) {
			return;
		}
		List children = getChildren();
		for(Object child : children) {
			if(child instanceof BehaviorExecutionSpecificationBehaviorEditPart) {
				((BehaviorExecutionSpecificationBehaviorEditPart)child).refresh();
			}
		}
	}

	@Override
	public void activate() {
		super.activate();
		EObject elt = resolveSemanticElement();
		if(elt instanceof BehaviorExecutionSpecification) {
			Behavior behavior = ((BehaviorExecutionSpecification)elt).getBehavior();
			if(behavior != null) {
				helper.listenObject(behavior);
			}
		}
		if(getParent() != null) {
			getParent().addEditPartListener(selfRemovingListener = new EditPartListener.Stub() {

				@Override
				public void removingChild(EditPart child, int index) {
					if(child == CustomBehaviorExecutionSpecificationEditPart.this) {
						List children = new ArrayList(getChildren());
						for(Object object : children) {
							if(object instanceof BehaviorExecutionSpecificationBehaviorEditPart) {
								removeChild((EditPart)object);
								break;
							}
						}
					}
				}
			});
		}
	}

	@Override
	public void deactivate() {
		helper.unlistenAll();
		if(getParent() != null) {
			getParent().removeEditPartListener(selfRemovingListener);
		}
		super.deactivate();
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		Object feature = event.getFeature();
		Object notifier = event.getNotifier();
		if(UMLPackage.eINSTANCE.getBehaviorExecutionSpecification_Behavior() == feature) {
			helper.unlistenObject((Notifier)event.getOldValue());
			helper.listenObject((Notifier)event.getNewValue());
			refreshBehavior();
		} else if(notifier != null) {
			EObject elt = resolveSemanticElement();
			if(elt instanceof BehaviorExecutionSpecification && notifier == ((BehaviorExecutionSpecification)elt).getBehavior()) {
				refreshBehavior();
			}
		}
		if(BehaviorDisplayHelper.isDisplayBehaviorChanged(event)) {
			refreshChildren();
		}
	}

	@Override
	protected List getModelChildren() {
		List modelChildren = new ArrayList(super.getModelChildren());
		boolean displayBehavior = BehaviorDisplayHelper.shouldDisplayBehavior(getNotationView());
		//Lazy check and create behavior label model.
		boolean hasBehaviorLabel = false;
		final View view = getNotationView();
		for(Object object : view.getChildren()) {
			if(object instanceof View && BehaviorExecutionSpecificationBehaviorEditPart.BEHAVIOR_TYPE.equals(((View)object).getType())) {
				hasBehaviorLabel = true;
				if(!displayBehavior) {
					modelChildren.remove(object);
				}
				break;
			}
		}
		if(!hasBehaviorLabel && displayBehavior) {
			final DecorationNode behaviorLabel = NotationFactory.eINSTANCE.createDecorationNode();
			Location location = NotationFactory.eINSTANCE.createLocation();
			location.setX(16);
			location.setY(16);
			behaviorLabel.setLayoutConstraint(location);
			behaviorLabel.setType(BehaviorExecutionSpecificationBehaviorEditPart.BEHAVIOR_TYPE);
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {

				@Override
				public void execute() {
					ViewUtil.insertChildView(view, behaviorLabel, ViewUtil.APPEND, true);
				}
			}, true);
			modelChildren.add(behaviorLabel);
		}
		return modelChildren;
	}

	private static class BehaviorLabelLocator implements IBorderItemLocator {

		private IFigure referenceFigure;

		private Rectangle constraint = new Rectangle();


		/**
		 * Constructor.
		 * 
		 */
		public BehaviorLabelLocator(IFigure referenceFigure) {
			this.referenceFigure = referenceFigure;
		}

		/**
		 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
		 * 
		 * @param constraint
		 */

		public void setConstraint(Rectangle constraint) {
			this.constraint = constraint;
		}

		/**
		 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
		 *      org.eclipse.draw2d.IFigure)
		 * 
		 * @param proposedLocation
		 * @param borderItem
		 * @return
		 */

		public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
			return new Rectangle(proposedLocation);
		}

		/**
		 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
		 * 
		 * @return
		 */

		public int getCurrentSideOfParent() {
			return 0;
		}

		/**
		 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
		 * 
		 * @param target
		 */

		public void relocate(IFigure target) {
			Rectangle ref = referenceFigure.getBounds().getCopy();
			referenceFigure.translateToAbsolute(ref);
			Rectangle bounds = constraint.getTranslated(ref.getLocation());
			bounds.setSize(target.getPreferredSize());
			target.translateToRelative(bounds);
			target.setBounds(bounds);
		}

	}
}
