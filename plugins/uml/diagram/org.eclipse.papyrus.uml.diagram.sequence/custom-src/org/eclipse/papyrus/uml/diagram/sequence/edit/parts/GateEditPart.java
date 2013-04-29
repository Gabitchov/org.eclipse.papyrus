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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;
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
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.editparts.AbstractBorderEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GateGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.GateItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateEditPart extends AbstractBorderEditPart implements IBorderItemEditPart {

	public static final String GATE_TYPE = "Gate";

	public static final Dimension DEFAULT_SIZE = new Dimension(16, 16);

	protected GateFigure primaryShape;

	private NotificationHelper notifier = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public GateEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 * 
	 */
	@Override
	public void activate() {
		super.activate();
		hookExternalGates();
	}

	/**
	 * Hook external gates such as ActualGate of InteractionUse for a FormalGate of Interaction, outer gate of CombinedFragment for a inner gate of
	 * CombinedFragment.
	 */
	protected void hookExternalGates() {
		Gate gate = (Gate)resolveSemanticElement();
		if(gate.eContainer() instanceof CombinedFragment) {
			if(!GateHelper.isInnerCFGate(gate)) {
				Message message = gate.getMessage();
				if(message != null) {
					notifier.listenObject(message);
				}
			} else {
				//For CombinedFragment
				Gate outerGate = GateHelper.getOuterCFGate(gate);
				if(outerGate != null) {
					notifier.listenObject(outerGate);
					Message message = outerGate.getMessage();
					if(message != null) {
						notifier.listenObject(message);
					}
				}
			}
		} else if(gate.eContainer() instanceof Interaction) {
			//For gate on interaction
			Gate actualGate = GateHelper.getActualGate(gate);
			if(actualGate != null) {
				notifier.listenObject(actualGate);
				Message message = actualGate.getMessage();
				if(message != null) {
					notifier.listenObject(message);
				}
			}
		}
	}

	public void deactivate() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.deactivate();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.BorderUMLNodeEditPart#createDefaultEditPolicies()
	 * 
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GateGraphicalNodeEditPolicy());
	}

	public EditPolicy getPrimaryDragEditPolicy() {
		return new BorderItemSelectionEditPolicy() {

			protected Command getMoveCommand(ChangeBoundsRequest request) {
				IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
				IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
				if(borderItemLocator != null) {
					PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
					getHostFigure().translateToAbsolute(rect);
					rect.translate(request.getMoveDelta());
					rect.resize(request.getSizeDelta());
					getHostFigure().translateToRelative(rect);
					Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
					Point location = realLocation.getLocation();
					ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
					return new ICommandProxy(moveCommand);
				}
				return null;
			}
		};
	}

	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if(child instanceof GateNameEditPart) {
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
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
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.BorderNodeEditPart#createMainFigure()
	 * 
	 * @return
	 */
	@Override
	protected NodeFigure createMainFigure() {
		return primaryShape = new GateFigure();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart#addChildVisual(org.eclipse.gef.EditPart, int)
	 * 
	 * @param childEditPart
	 * @param index
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(childEditPart instanceof GateNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, 0));
			getContentPaneFor((GateNameEditPart)childEditPart).add(((GateNameEditPart)childEditPart).getFigure(), locator);
			return;
		}
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.BorderNodeEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public IPapyrusNodeFigure getPrimaryShape() {
		return primaryShape;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart#removeChildVisual(org.eclipse.gef.EditPart)
	 * 
	 * @param child
	 */
	@Override
	protected void removeChildVisual(EditPart child) {
		if(child instanceof GateNameEditPart) {
			getContentPaneFor((GateNameEditPart)child).remove(((GateNameEditPart)child).getFigure());
			return;
		}
		super.removeChildVisual(child);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#refreshBounds()
	 * 
	 */
	@Override
	protected void refreshBounds() {
		if(getBorderItemLocator() != null) {
			int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			Point loc = new Point(x, y);
			getBorderItemLocator().setConstraint(new Rectangle(loc, DEFAULT_SIZE));
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.AbstractBorderEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		if(!event.isTouch()) {
			hookExternalGates();
		}
		if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(event.getFeature())) {
			refreshGateLabel();
		} else if(UMLPackage.eINSTANCE.getMessageEnd_Message().equals(event.getFeature())) {
			notifier.unlistenObject((Notifier)event.getOldValue());
			notifier.listenObject((Notifier)event.getNewValue());
			refreshGateLabel();
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * Refresh the label of Gate.
	 */
	protected void refreshGateLabel() {
		GateNameEditPart labelEditPart = getLabelEditPart();
		if(labelEditPart != null) {
			labelEditPart.refreshLabel();
		}
	}

	public GateNameEditPart getLabelEditPart() {
		return (GateNameEditPart)getChildBySemanticHint(GateNameEditPart.GATE_NAME_TYPE);
	}

	public class GateFigure extends NodeNamedElementFigure {

		/**
		 * Constructor.
		 * 
		 */
		public GateFigure() {
			setBorder(new LineBorder(ColorConstants.black));
			setPreferredSize(DEFAULT_SIZE);
		}

		protected ConnectionAnchor createDefaultAnchor() {
			return new SlidableAnchor(this) {

				@Override
				public Point getLocation(Point reference) {
					Point location = getLocation(new PrecisionPoint(getBox().getCenter()), reference);
					if(location == null) {
						location = getBox().getCenter();
					}
					return location;
				}
			};
		}

		protected ConnectionAnchor createAnchor(PrecisionPoint p) {
			return new SlidableAnchor(this, p) {

				public Point getLocation(Point reference) {
					Rectangle box = getBox();
					Point location = getLocation(new PrecisionPoint(box.getCenter()), reference);
					if(location == null) {
						location = getBox().getCenter();
					}
					return location;
				}
			};
		}
	}
}
