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
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart.DummyCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeCommentCreationEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomStateInvariantItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.CenterLocator;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomStateInvariantEditPart extends StateInvariantEditPart implements IPapyrusEditPart {

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifierHelper = new NotificationHelper(new UIAdapterImpl() {

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
	public CustomStateInvariantEditPart(View view) {
		super(view);
	}

	@Override
	public void activate() {
		super.activate();
		EObject element = resolveSemanticElement();
		if(element instanceof StateInvariant && ((StateInvariant)element).getInvariant() != null) {
			notifierHelper.listenObject(((StateInvariant)element).getInvariant());
		}
	}

	@Override
	public void deactivate() {
		EObject element = resolveSemanticElement();
		if(element instanceof StateInvariant && ((StateInvariant)element).getInvariant() != null) {
			notifierHelper.unlistenObject(((StateInvariant)element).getInvariant());
		}
		super.deactivate();
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStateInvariantItemSemanticEditPolicy());
		//install a editpolicy to display stereotypes
		installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicyEx());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		Object notifier = notification.getNotifier();
		if((getModel() != null) && (getModel() == notifier)) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		} else if(UMLPackage.eINSTANCE.getStateInvariant_Invariant() == feature) {
			if(Notification.SET == notification.getEventType() || Notification.UNSET == notification.getEventType()) {
				notifierHelper.unlistenObject((Notifier)notification.getOldValue());
				notifierHelper.listenObject((Notifier)notification.getNewValue());
			}
			refreshLabels();
		} else if(notifier != null) {
			EObject element = resolveSemanticElement();
			if(element instanceof StateInvariant && notifier == ((StateInvariant)element).getInvariant()) {
				refreshLabels();
			}
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getModelChildren()
	 * 
	 * @return
	 */
	@Override
	protected List getModelChildren() {
		List<Object> modelChildren = new ArrayList<Object>(super.getModelChildren());
		boolean hasInvariantView = false;
		for(Object object : modelChildren) {
			if(object instanceof View && UMLVisualIDRegistry.getType(StateInvariantLabelEditPart.VISUAL_ID).equals(((View)object).getType())) {
				hasInvariantView = true;
				break;
			}
		}
		if(!hasInvariantView) {
			final View view = getNotationView();
			final DecorationNode guardNode = NotationFactory.eINSTANCE.createDecorationNode();
			guardNode.setType(UMLVisualIDRegistry.getType(StateInvariantLabelEditPart.VISUAL_ID));
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new DummyCommand() {

				@Override
				public void execute() {
					ViewUtil.insertChildView(view, guardNode, ViewUtil.APPEND, true);
				}
			}, true);
			modelChildren.add(guardNode);
		}
		return modelChildren;
	}

	@Override
	protected void setFontColor(Color color) {
		super.setFontColor(color);
		StateInvariantFigure primaryShape = getPrimaryShape();
		if(primaryShape != null && primaryShape.getConstraintContentContainer() != null) {
			primaryShape.getConstraintContentContainer().setForegroundColor(color);
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLineWidth();
		refreshTransparency();
		refreshLabels();
	}

	/**
	 * Refresh Invariant.
	 */
	protected void refreshLabels() {
		List parts = getChildren();
		for(Object p : parts) {
			if(p instanceof CustomStateInvariantLabelEditPart) {
				((CustomStateInvariantLabelEditPart)p).refreshLabel();
			}
		}
	}

	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	@Override
	protected void refreshBounds() {
		if(getBorderItemLocator() != null) {
			int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			Point loc = new Point(x, y);
			int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
			Dimension size = new Dimension(width, height);
			// fix size
			getFigure().setBounds(new Rectangle(loc, size));
			getBorderItemLocator().setConstraint(new Rectangle(loc, size));
		} else {
			super.refreshBounds();
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public StateInvariantFigure getPrimaryShape() {
		return (StateInvariantFigure)primaryShape;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#addFixedChild(org.eclipse.gef.EditPart)
	 * 
	 * @param childEditPart
	 * @return
	 */
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CustomStateInvariantLabelEditPart) {
			((CustomStateInvariantLabelEditPart)childEditPart).setLabel(getPrimaryShape().getInvariantFigure());
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#removeFixedChild(org.eclipse.gef.EditPart)
	 * 
	 * @param childEditPart
	 * @return
	 */
	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CustomStateInvariantLabelEditPart) {
			return true;
		}
		return super.removeFixedChild(childEditPart);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new StateInvariantFigure();
	}

	public class StateInvariantFigure extends ContinuationFigure implements ILabelFigure, IMultilineEditableFigure, IPapyrusNodeUMLElementFigure {

		protected static final String LEFT_BRACE = "{";

		protected static final String RIGHT_BRACE = "}";

		/**
		 * The transparency of this shape in percent.
		 * Must be in [0, 100] range.
		 */
		private int transparency = 0;

		private FlowPage constraintContentContainer;

		private TextFlowEx constraintContent;

		private CenteredWrappedLabel fFigureContinuationNameLabel;

		private Label stereotypesLabel;

		private Label stereotypePropertiesLabel;

		private IFigure labelContainer;

		/**
		 * Constructor.
		 * 
		 */
		public StateInvariantFigure() {
			super();
			getChildren().clear();
			setBorder(new MarginBorder(8));
			RoundedRectangle contents = new RoundedRectangle();
			contents.setCornerDimensions(new Dimension(getMapMode().DPtoLP(50), getMapMode().DPtoLP(50)));
			contents.setOutline(false);
			this.add(contents);
			//Name figure
			fFigureContinuationNameLabel = new CenteredWrappedLabel();
			contents.add(fFigureContinuationNameLabel);

			//Invariant figure
			constraintContentContainer = new FlowPage();
			constraintContentContainer.setOpaque(false);
			constraintContentContainer.setHorizontalAligment(PositionConstants.CENTER);
			constraintContent = new TextFlowEx("");
			constraintContentContainer.add(constraintContent);
			contents.add(constraintContentContainer);

			//Contents layout.
			ToolbarLayout layout = new ToolbarLayout(false);
			layout.setStretchMinorAxis(true);
			layout.setMinorAlignment(OrderedLayout.ALIGN_CENTER);
			contents.setLayoutManager(layout);
			labelContainer = contents;
		}

		public FlowPage getConstraintContentContainer() {
			return constraintContentContainer;
		}

		@Override
		public CenteredWrappedLabel getFigureContinuationNameLabel() {
			return fFigureContinuationNameLabel;
		}

		public IFigure getInvariantFigure() {
			return this;
		}

		protected void fillShape(Graphics graphics) {
			graphics.pushState();
			applyTransparency(graphics);
			graphics.fillRoundRectangle(getBounds(), corner.width, corner.height);
			graphics.popState();
		}

		/**
		 * Returns transparency value (belongs to [0, 100] interval)
		 * 
		 * @return transparency
		 * @since 1.2
		 */
		public int getTransparency() {
			return transparency;
		}

		/**
		 * Sets the transparency if the given parameter is in [0, 100] range
		 * 
		 * @param transparency
		 *        The transparency to set
		 * @since 1.2
		 */
		public void setTransparency(int transparency) {
			if(transparency != this.transparency && transparency >= 0 && transparency <= 100) {
				this.transparency = transparency;
				repaint();
			}
		}

		/**
		 * Converts transparency value from percent range [0, 100] to alpha range
		 * [0, 255] and applies converted value. 0% corresponds to alpha 255 and
		 * 100% corresponds to alpha 0.
		 * 
		 * @param g
		 *        The Graphics used to paint
		 * @since 1.2
		 */
		protected void applyTransparency(Graphics g) {
			g.setAlpha(255 - transparency * 255 / 100);
		}

		public void setText(String text) {
			if(constraintContent != null) {
				constraintContent.setText(LEFT_BRACE + text + RIGHT_BRACE);
			}
		}

		public String getText() {
			if(constraintContent != null) {
				return constraintContent.getText();
			}
			return null;
		}

		public void setIcon(Image icon) {

		}

		public Image getIcon() {
			return null;
		}

		public Point getEditionLocation() {
			if(constraintContentContainer != null) {
				return constraintContentContainer.getLocation();
			}
			return null;
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
		 *      org.eclipse.swt.graphics.Image)
		 * 
		 * @param stereotypes
		 * @param image
		 */

		public void setStereotypeDisplay(String stereotypes, Image image) {
			if(stereotypes == null || stereotypes.trim().equals("")) {
				if(stereotypesLabel != null) {
					labelContainer.remove(stereotypesLabel);
				}
				stereotypesLabel = null;
			} else {
				if(stereotypesLabel == null) {
					stereotypesLabel = new Label(stereotypes, image);
					labelContainer.add(stereotypesLabel, 0);
				} else {
					stereotypesLabel.setText(stereotypes);
					stereotypesLabel.setIcon(image);
				}
			}
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInBrace(java.lang.String)
		 * 
		 * @param stereotypeProperties
		 */

		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			if(stereotypeProperties == null || stereotypeProperties.trim().equals("")) {
				if(stereotypePropertiesLabel != null) {
					labelContainer.remove(stereotypePropertiesLabel);
				}
				stereotypePropertiesLabel = null;
			} else {
				if(stereotypePropertiesLabel == null) {
					stereotypePropertiesLabel = new Label();
					int index = labelContainer.getChildren().indexOf(stereotypesLabel);
					labelContainer.add(stereotypePropertiesLabel, index + 1);
				}
				stereotypePropertiesLabel.setText(LEFT_BRACE + stereotypeProperties + RIGHT_BRACE);
			}
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInCompartment(java.lang.String)
		 * 
		 * @param stereotypeProperties
		 */

		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {

		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#getStereotypesLabel()
		 * 
		 * @return
		 */

		public Label getStereotypesLabel() {
			return stereotypesLabel;
		}
	}

	static class StateInvariantLocator extends CenterLocator {

		public StateInvariantLocator(IFigure parentFigure, int location) {
			super(parentFigure, location);
		}

		public void relocate(IFigure borderItem) {
			Point constraintLocation = getConstraint().getLocation();
			Dimension size = getSize(borderItem);
			Point ptNewLocation = new Point(getParentBorder().getCenter().x - size.width / 2, constraintLocation.y);
			borderItem.setBounds(new Rectangle(ptNewLocation, size));
		}

		public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
			Rectangle realLocation = new Rectangle(proposedLocation);
			Point point = new Point(getParentBorder().getCenter().x - realLocation.getSize().width / 2, realLocation.y);
			realLocation.setLocation(point);
			return realLocation;
		}
	};

	public static class StateInvariantResizableEditPolicy extends BorderItemResizableEditPolicy {

		protected Command getResizeCommand(ChangeBoundsRequest request) {
			IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
			IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
			if(borderItemLocator != null) {
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				getHostFigure().translateToRelative(rect);
				Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
				if(borderItemEP.getParent() instanceof LifelineEditPart && !restrictInParentBounds((LifelineEditPart)borderItemEP.getParent(), borderItemEP, realLocation.getCopy()))
					return null;
				ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), realLocation);
				return new ICommandProxy(moveCommand);
			}
			return null;
		}

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
				if(borderItemEP.getParent() instanceof LifelineEditPart && !restrictInParentBounds((LifelineEditPart)borderItemEP.getParent(), borderItemEP, realLocation.getCopy()))
					return null;
				Point location = realLocation.getTopLeft();
				ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
				return new ICommandProxy(moveCommand);
			}
			return null;
		}

		private boolean restrictInParentBounds(LifelineEditPart ep, IBorderItemEditPart borderItemEP, Rectangle realLocation) {
			borderItemEP.getFigure().translateToAbsolute(realLocation);
			Rectangle bounds = ep.getPrimaryShape().getBounds().getCopy();
			ep.getPrimaryShape().translateToAbsolute(bounds);
			int nameHeight = ep.getPrimaryShape().getFigureLifelineNameContainerFigure().getBounds().height;
			if(realLocation.y - nameHeight < bounds.y)
				return false;
			if(realLocation.getBottom().y > bounds.getBottom().y)
				return false;
			return true;
		}
	}
}
