/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomZOrderCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * The custom LayoutEditPolicy for LifelineEditPart.
 */
public class LifelineXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/** Initialization width of Execution Specification. */
	public final static int EXECUTION_INIT_WIDTH = 16;

	/** Initialization width of CoRegion. */
	public final static int COREGION_INIT_WIDTH = 30;

	/** Initialization height of Execution Specification. */
	private final static int EXECUTION_INIT_HEIGHT = 50;

	/** Initialization height of a time bar figure. */
	private static final int TIME_BAR_HEIGHT = 1;

	/** The default spacing used between Execution Specification */
	private final static int SPACING_HEIGHT = 5;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if(request instanceof CreateViewRequest) {
			CreateViewRequest cvr = (CreateViewRequest)request;
			if(cvr.getViewDescriptors().size() > 0) {
				ViewDescriptor viewDescriptor = cvr.getViewDescriptors().iterator().next();
				String semanticHint = viewDescriptor.getSemanticHint();

				// force location of time/duration elements and ES
				String timeConstraintHint = ((IHintedType)UMLElementTypes.TimeConstraint_3019).getSemanticHint();
				String timeObservationHint = ((IHintedType)UMLElementTypes.TimeObservation_3020).getSemanticHint();
				String durationConstraintOnLifelineHint = ((IHintedType)UMLElementTypes.DurationConstraint_3021).getSemanticHint();
				String actionExecutionSpecificationHint = ((IHintedType)UMLElementTypes.ActionExecutionSpecification_3006).getSemanticHint();
				String behaviorExecutionSpecificationHint = ((IHintedType)UMLElementTypes.BehaviorExecutionSpecification_3003).getSemanticHint();
				String coRegionHint = ((IHintedType)UMLElementTypes.CombinedFragment_3018).getSemanticHint();

				if(timeConstraintHint.equals(semanticHint) || timeObservationHint.equals(semanticHint)) {
					Command cmd = getCommandForTimeObservationOrConstraint(cvr, viewDescriptor);
					if(cmd != null) {
						return cmd;
					}
				}
				if(durationConstraintOnLifelineHint.equals(semanticHint)) {
					Command cmd = getCommandForDurationConstraint(cvr, viewDescriptor);
					if(cmd != null) {
						return cmd;
					}
				}
				if(actionExecutionSpecificationHint.equals(semanticHint) || behaviorExecutionSpecificationHint.equals(semanticHint)) {
					Command cmd = getCommandForExecutionSpecificationCreation(cvr, viewDescriptor);
					if(cmd != null) {
						return cmd;
					}
				}
				if(coRegionHint.equals(semanticHint)) {
					Command cmd = getCommandForCoRegionCreation(cvr, viewDescriptor);
					if(cmd != null) {
						return cmd;
					}
				}
			}
		}

		return super.getCreateCommand(request);
	}
	
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		View childView = (View)child.getModel();
		switch(UMLVisualIDRegistry.getVisualID(childView)) {
			case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
				return new BorderItemResizableEditPolicy();
		}		
		return super.createChildEditPolicy(child);
	}
	
	protected Rectangle getCurrentConstraintFor(GraphicalEditPart child) {
		IFigure fig = child.getFigure();
		Object con = fig.getParent().getLayoutManager()
				.getConstraint(fig);
		if(con instanceof Rectangle)
			return (Rectangle) con;
		return fig.getBounds();
	}

	protected Object getConstraintFor(CreateRequest request) {
		Rectangle constraint = (Rectangle)super.getConstraintFor(request);
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest req = (CreateViewAndElementRequest)request;
			IHintedType type = (IHintedType) UMLElementTypes.Lifeline_3001;
			if (type.getSemanticHint().equals(req.getViewAndElementDescriptor().getSemanticHint())) {
				constraint.y = 0 ;  	// fix layout offset
			}
		}
		return constraint;
	}

	private static Rectangle getNewBoundsForCoRegion(LifelineEditPart lifelineEP, Rectangle bounds) {
		Rectangle newBounds = bounds.getCopy();

		// Get the dotline figure
		LifelineDotLineFigure figureLifelineDotLineFigure = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure();

		// Translate the absolute location to relative
		figureLifelineDotLineFigure.translateToRelative(newBounds);
		newBounds.translate(figureLifelineDotLineFigure.getBounds().getLocation().getCopy().negate());

		Rectangle dotLineFigureBounds = figureLifelineDotLineFigure.getBounds();

		newBounds.x = dotLineFigureBounds.width / 2 - COREGION_INIT_WIDTH / 2;
		newBounds.width = COREGION_INIT_WIDTH;

		return newBounds;
	}

	private Command getCommandForCoRegionCreation(CreateViewRequest cvr, ViewDescriptor viewDescriptor) {
		Rectangle newBounds = new Rectangle();
		if(cvr.getLocation() != null) {
			newBounds.setLocation(cvr.getLocation());
		}
		if(cvr.getSize() != null) {
			newBounds.setSize(cvr.getSize());
		} else {
			newBounds.width = -1;
			newBounds.height = -1;
		}

		if(newBounds.x < 0 || newBounds.y < 0) {
			newBounds.x = newBounds.y = 0;
		}

		newBounds = getNewBoundsForCoRegion((LifelineEditPart)getHost(), newBounds);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		return new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, newBounds));
	}

	private Command getCommandForExecutionSpecificationCreation(CreateViewRequest cvr, ViewDescriptor viewDescriptor) {
		Point newLocation = cvr.getLocation().getCopy();

		if(newLocation.x < 0 || newLocation.y < 0) {
			newLocation.x = newLocation.y = 0;
		}

		LifelineEditPart editPart = (LifelineEditPart)getHost();

		// Get the dotline figure
		LifelineDotLineFigure figureLifelineDotLineFigure = editPart.getPrimaryShape().getFigureLifelineDotLineFigure();
		List<ShapeNodeEditPart> executionSpecificationList = editPart.getChildShapeNodeEditPart();

		// Translate the absolute location to relative
		figureLifelineDotLineFigure.translateToRelative(newLocation);

		Rectangle dotLineFigureBounds = figureLifelineDotLineFigure.getBounds();
		// If we are creating an ES from the popup menu bar
		// We need to get a valid location to be able to create the ES figure
		if(newLocation.y < dotLineFigureBounds.y) {
			int max = dotLineFigureBounds.y;
			for(ShapeNodeEditPart sp : executionSpecificationList) {
				int figureBottom = sp.getFigure().getBounds().y + sp.getFigure().getBounds().height;
				if(figureBottom > max) {
					max = figureBottom;
				}
			}
			// Vertically, the new ES is located after all existing ES on the lifeline
			newLocation.y = max + SPACING_HEIGHT;
			// Horizontally, the figure is placed at the center of the lifeline
			newLocation.x = dotLineFigureBounds.x + dotLineFigureBounds.width / 2 - EXECUTION_INIT_WIDTH / 2;
		}

		// Get the height of the Execution specification
		int newHeight = getFigureHeight(cvr);

		// Define the bounds of the new Execution specification
		Rectangle newBounds = new Rectangle(newLocation.x, newLocation.y, -1, newHeight);
		ShapeNodeEditPart parent = getParent((LifelineEditPart)getHost(), newBounds, executionSpecificationList);
		newBounds = getExecutionSpecificationNewBounds(true, editPart, new Rectangle(), newBounds, new ArrayList<ShapeNodeEditPart>(0), false);
		if(newBounds == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Command p = new ICommandProxy(new SetBoundsCommand(editPart.getEditingDomain(), "Creation of an ExecutionSpecification", viewDescriptor, newBounds));		

		// resize parent bar
		if(parent != null){
			p = p.chain(resizeParentExecutionSpecification((LifelineEditPart)getHost(), parent, newBounds.getCopy(), executionSpecificationList));
		}		
		return p;
	}

	private static Command resizeParentExecutionSpecification(LifelineEditPart lifelinePart, ShapeNodeEditPart part, Rectangle childBounds, List<ShapeNodeEditPart> list) {
		Rectangle bounds = getRelativeBounds(part.getFigure());
		
		childBounds.x = bounds.x;
		childBounds.width = bounds.width;
		if(bounds.contains(childBounds))
			return null; 
		bounds.union(childBounds);
		Command c = new ICommandProxy(new SetBoundsCommand(part.getEditingDomain(), "Resize of Parent Bar", part, bounds.getCopy()));
		
		list.remove(part);
		ShapeNodeEditPart parent = getParent(lifelinePart, part.getFigure().getBounds(), list);
		if(parent == null)
			return c;
		
		return c.chain(resizeParentExecutionSpecification(lifelinePart, parent, bounds.getCopy(), list));
	}

	/**
	 * Get the command for setting initial bounds of a Time Observation or Constraint representation
	 * 
	 * @param cver
	 *        the request
	 * @return command or null if none is appropriate
	 */
	private Command getCommandForTimeObservationOrConstraint(CreateViewRequest cvr, ViewDescriptor viewDescriptor) {
		Object loc = cvr.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
		if(loc instanceof Point) {
			IFigure parentFigure = ((IGraphicalEditPart)getHost()).getFigure();
			Point referencePoint = ((Point)loc).getCopy();
			parentFigure.translateToRelative(referencePoint);
			referencePoint.translate(parentFigure.getBounds().getLocation().getCopy().negate());
			// Get the height of the element
			int newHeight = getFigureHeight(cvr);
			// Define the bounds of the new time element
			Rectangle newBounds = new Rectangle(referencePoint.x, referencePoint.y - newHeight / 2, -1, newHeight);
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			return new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, newBounds));
		}
		return null;
	}

	/**
	 * Get the command for setting initial bounds of a Duration Constraint representation
	 * 
	 * @param cver
	 *        the request
	 * @return command or null if none is appropriate
	 */
	private Command getCommandForDurationConstraint(CreateViewRequest cvr, ViewDescriptor viewDescriptor) {
		Object locTop = cvr.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
		Object locBottom = cvr.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2);
		if(locTop instanceof Point && locBottom instanceof Point) {
			IFigure parentFigure = ((IGraphicalEditPart)getHost()).getFigure();
			Point referenceTop = ((Point)locTop).getCopy();
			Point referenceBottom = ((Point)locBottom).getCopy();
			// Get the height of the element
			int newHeight = referenceBottom.y - referenceTop.y;
			if(newHeight > 0) {
				parentFigure.translateToRelative(referenceTop);
				Point parentFigDelta = parentFigure.getBounds().getLocation().getCopy().negate();
				referenceTop.translate(parentFigDelta);
				// Define the bounds of the new time element
				Rectangle newBounds = new Rectangle(referenceTop.x, referenceTop.y, -1, newHeight);
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
				return new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, newBounds));
			} else if(newHeight < 0) {
				parentFigure.translateToRelative(referenceBottom);
				Point parentFigDelta = parentFigure.getBounds().getLocation().getCopy().negate();
				referenceBottom.translate(parentFigDelta);
				// Define the bounds of the new time element
				Rectangle newBounds = new Rectangle(referenceBottom.x, referenceBottom.y, -1, -newHeight);
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
				return new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, newBounds));
			}
		}
		return null;
	}

	/**
	 * Get the adapted height, taking in account the represented figure
	 * 
	 * @param cr
	 *        the create request
	 * @return the height defined in the create request or a default value depending on the created figure
	 */
	private int getFigureHeight(CreateRequest cr) {
		final String timeObsHint = ((IHintedType)UMLElementTypes.TimeObservation_3020).getSemanticHint();
		final String timeCstHint = ((IHintedType)UMLElementTypes.TimeConstraint_3019).getSemanticHint();
		String semHint = null;
		if(cr instanceof CreateViewAndElementRequest) {
			semHint = ((CreateViewAndElementRequest)cr).getViewAndElementDescriptor().getSemanticHint();
		}
		int newHeight;
		if(timeObsHint.equals(semHint) || timeCstHint.equals(semHint)) {
			// height for a time bar (takes precedence on request's size)
			newHeight = TIME_BAR_HEIGHT;
		} else if(cr.getSize() != null) {
			// heigh from request
			newHeight = cr.getSize().height;
		} else {
			newHeight = EXECUTION_INIT_HEIGHT;
		}
		return newHeight;
	}

	/**
	 * Useful operation to know where the figure of a ExecutionSpecification EditPart should be
	 * positioned within a Lifeline EditPart. The notToCheckList is needed to avoid checking those
	 * ExecutionSpecification EditParts. The returned bounds are relative to the Lifeline figure so
	 * they can be used, directly, within a SetBoundsCommand.
	 * 
	 * @param lifelineEP
	 *        the lifeline ep
	 * @param oldBounds
	 *        The old bounds of the ES
	 * @param newBounds
	 *        The new initial bounds
	 * @param notToCheckExecutionSpecificationList
	 *        The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */
	protected final static Rectangle getExecutionSpecificationNewBounds(boolean isMove, LifelineEditPart lifelineEP, Rectangle oldBounds, Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList, boolean useFixedXPos) {
		// Lifeline's figure where the child is drawn
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();

		// if ExecutionSpecification is resize outside of the lifeline bounds
		if(newBounds.y <= dotLineBounds.y || newBounds.x < dotLineBounds.x || newBounds.x > dotLineBounds.right()) {
			return null;
		}

		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getChildShapeNodeEditPart();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

		if(isMove) {
			ShapeNodeEditPart parent = getParent(lifelineEP, newBounds, toCheckExecutionSpecificationList);

			if(useFixedXPos) {
				newBounds.x = oldBounds.x;
			} else if(parent == null) {
				// No mother, center position
				int width = newBounds.width > 0 ? newBounds.width : EXECUTION_INIT_WIDTH;
				newBounds.x = dotLineBounds.x + dotLineBounds.width / 2 - width / 2;
			} else {
				Rectangle parentBounds = parent.getFigure().getBounds();
				int width = parentBounds.width > 0 ? parentBounds.width : EXECUTION_INIT_WIDTH;
				newBounds.x = parentBounds.x + width / 2 + 1;
			}
		} else {
			ShapeNodeEditPart oldParent = getParent(lifelineEP, oldBounds, toCheckExecutionSpecificationList);
			// forbid resize if the new bounds exceed Y-wise the bounds of a non-parent ES
			for(ShapeNodeEditPart esPart : toCheckExecutionSpecificationList) {
				Rectangle esBounds = esPart.getFigure().getBounds();
				int esYBottom = esBounds.y + esBounds.height;
				if(esPart != oldParent) {
					if(((oldBounds.y + oldBounds.height) <= esBounds.y && (newBounds.y + newBounds.height) >= esBounds.y) || (oldBounds.y >= esYBottom && newBounds.y <= esYBottom)) {
						return null;
					}
				}
			}
		}

		// Change to relative bounds of the LifelineEP
		newBounds.x -= dotLineBounds.x;
		newBounds.y -= dotLineBounds.y;

		return newBounds;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart)getHost();
		Command command = getResizeOrMoveChildrenCommand(lifelineEP, request, false, true, false);

		if(command == null) {
			command = super.getResizeChildrenCommand(request);
		}
		return command;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Command getMoveChildrenCommand(Request request) {
		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart)getHost();
		Command command = getResizeOrMoveChildrenCommand(lifelineEP, (ChangeBoundsRequest)request, true, true, false);

		if(command == null) {
			command = super.getMoveChildrenCommand(request);
		}
		return command;
	}

	@SuppressWarnings("unchecked")
	public static Command getResizeOrMoveChildrenCommand(LifelineEditPart lifelineEP, ChangeBoundsRequest request, boolean isMove, boolean updateEnclosingInteraction, boolean useFixedXPos) {
		List<EditPart> editParts = request.getEditParts();

		if(editParts != null) {
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Move or resize");
			compoundCmd.setDebugLabel("Debug: Move or resize of an ExecutionSpecification");

			for(EditPart ep : editParts) {

				if(ep instanceof ActionExecutionSpecificationEditPart || ep instanceof BehaviorExecutionSpecificationEditPart) {

					// an execution specification have been moved or resized
					ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart)ep;

					// Check if height is within the limits of the figure
					Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(executionSpecificationEP.getFigure(), request.getSizeDelta());

					// Current bounds of the ExecutionSpecification
					Rectangle oldBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

					Rectangle newBounds = oldBounds.getCopy();

					// According to the parameters, the new bounds would be the following
					newBounds.x += request.getMoveDelta().x;
					newBounds.y += request.getMoveDelta().y;
					newBounds.height += newSizeDelta.height;

					// Not to check list
					List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new BasicEList<ShapeNodeEditPart>();
					// Affixed ExecutionSpecification List
					notToCheckExecutionSpecificationList.addAll(getAffixedExecutionSpecificationEditParts(executionSpecificationEP));
					// Add also current ExecutionSpecification EditPart
					notToCheckExecutionSpecificationList.add(executionSpecificationEP);

					// find parent bar
					List<ShapeNodeEditPart> executionSpecificationList = lifelineEP.getChildShapeNodeEditPart();
					executionSpecificationList.remove(executionSpecificationEP);
					ShapeNodeEditPart parentBar = getParent(lifelineEP, newBounds, executionSpecificationList);
					
					// change bounds to relative
					newBounds = getExecutionSpecificationNewBounds(isMove, lifelineEP, oldBounds, newBounds, notToCheckExecutionSpecificationList, useFixedXPos);
					if(newBounds == null) {
						return UnexecutableCommand.INSTANCE;
					}

					if(parentBar != null){
						compoundCmd.add(resizeParentExecutionSpecification(lifelineEP, parentBar, newBounds.getCopy(), executionSpecificationList));
					}
					
					// Create and add the command to the compound command
					SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Resize of a ExecutionSpecification", executionSpecificationEP, newBounds);
					compoundCmd.add(new ICommandProxy(setBoundsCmd));

					Rectangle realMoveDelta = getRealMoveDelta(getRelativeBounds(executionSpecificationEP.getFigure()), newBounds);

					if(isMove) {
						// Move also children
						compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(executionSpecificationEP, realMoveDelta, newBounds));

						compoundCmd.add(createZOrderCommand(lifelineEP, executionSpecificationEP, newBounds, notToCheckExecutionSpecificationList));
					}

					// Move also linked Time elements
					compoundCmd = OccurrenceSpecificationMoveHelper.completeMoveExecutionSpecificationCommand(compoundCmd, executionSpecificationEP, newBounds, request);

					IFigure parentFigure = executionSpecificationEP.getFigure().getParent();
					parentFigure.translateToAbsolute(newBounds);
					// translateToAbsolute only does half of the work, I don't know why
					newBounds.translate(parentFigure.getBounds().getLocation());

					if(updateEnclosingInteraction) {
						// update the enclosing interaction of a moved execution specification
						compoundCmd.add(SequenceUtil.createUpdateEnclosingInteractionCommand(executionSpecificationEP, request.getMoveDelta(), newSizeDelta));
					}

					// keep absolute position of anchors
					compoundCmd.add(new ICommandProxy(new LifelineEditPart.PreserveAnchorsPositionCommandEx(executionSpecificationEP, new Dimension(realMoveDelta.width, realMoveDelta.height), PreserveAnchorsPositionCommand.PRESERVE_Y, executionSpecificationEP.getFigure(), request.getResizeDirection())));
				}

				if(ep instanceof CombinedFragment2EditPart) {
					CombinedFragment2EditPart cf2EP = (CombinedFragment2EditPart)ep;
					IFigure cf2Figure = cf2EP.getFigure();
					Rectangle bounds = cf2Figure.getBounds().getCopy();
					cf2Figure.getParent().translateToAbsolute(bounds);

					Dimension sizeDelta = request.getSizeDelta();
					if(sizeDelta != null) {
						if(sizeDelta.width != 0) {
							return UnexecutableCommand.INSTANCE;
						}
						bounds.resize(sizeDelta);
					}
					Point moveDelta = request.getMoveDelta();
					if(moveDelta != null) {
						bounds.translate(moveDelta);
					}

					// Create and add the set bounds command to the compound command
					SetBoundsCommand setBoundsCmd = new SetBoundsCommand(cf2EP.getEditingDomain(), "Resize of a CoRegion", cf2EP, getNewBoundsForCoRegion(lifelineEP, bounds));
					compoundCmd.add(new ICommandProxy(setBoundsCmd));
				}
			}

			if(!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}

		return null;
	}

	/**
	 * Command for change ZOrder of ExecutionSpecification ordered from parent to children.
	 * 
	 * @param lifelineEP
	 *        the lifeline ep
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * @param newBounds
	 *        the new bounds
	 * @param notToCheckExecutionSpecificationList
	 *        the not to check bes list
	 * 
	 * @return the command
	 */
	protected final static Command createZOrderCommand(LifelineEditPart lifelineEP, ShapeNodeEditPart executionSpecificationEP, Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getChildShapeNodeEditPart();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);
		CompoundCommand cmd = new CompoundCommand();
		for(ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = getRelativeBounds(externalExecutionSpecificationEP.getFigure());
			// Check if there is any contact
			if(externalExecutionSpecificationBounds.touches(newBounds)) {
				View containerView = ViewUtil.getContainerView(executionSpecificationEP.getPrimaryView());
				if(containerView != null) {
					int i = 0;
					int parentIndex = -1;
					int childIndex = -1;
					for(Object child : containerView.getChildren()) {
						if(child == externalExecutionSpecificationEP.getPrimaryView()) {
							parentIndex = i;
						} else if(child == executionSpecificationEP.getPrimaryView()) {
							childIndex = i;
						}
						if(parentIndex != -1 && childIndex != -1) {
							if(childIndex > parentIndex) {
								cmd.add(new ICommandProxy(new CustomZOrderCommand(executionSpecificationEP.getEditingDomain(), executionSpecificationEP.getPrimaryView(), parentIndex)));
								cmd.add(new ICommandProxy(new CustomZOrderCommand(externalExecutionSpecificationEP.getEditingDomain(), externalExecutionSpecificationEP.getPrimaryView(), childIndex)));
							} else {
								break;
							}
						}
						i++;
					}
				}
			}
		}

		if(!cmd.isEmpty()) {
			return cmd;
		}
		return null;
	}

	/**
	 * Useful operation to know where the figure of a ExecutionSpecification EditPart should be
	 * positioned within a Lifeline EditPart. The notToCheckList is needed to avoid checking those
	 * ExecutionSpecification EditParts. The returned bounds are relative to the Lifeline figure so
	 * they can be used, directly, within a SetBoundsCommand.
	 * 
	 * @param lifelineDotLineFigure
	 *        TODO
	 * @param newBounds
	 *        The new initial bounds
	 * @param executionSpecifactionEditPart
	 *        TODO
	 * @param notToCheckExecutionSpecificationList
	 *        The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */


	/**
	 * Get the (futur) parent of a ExecutionSpecification
	 * @param lifelinePart 
	 * 
	 * @param childBounds
	 *        the child bounds
	 * @param toCheckExecutionSpecificationList
	 *        List of EditPart to check
	 * @return The parent
	 */
	public final static ShapeNodeEditPart getParent(LifelineEditPart lifelinePart, Rectangle childBounds, List<ShapeNodeEditPart> toCheckExecutionSpecificationList) {
		ShapeNodeEditPart parent = null;
		// Loop through the ExecutionSpecification list and try to find the most to the right
		// ExecutionSpecification within the executionSpecificationEP Y-axis bounds
		Rectangle externalBounds = childBounds.getCopy();
		for(ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = externalExecutionSpecificationEP.getFigure().getBounds();
			externalBounds.x = externalExecutionSpecificationBounds.x;
			externalBounds.width = externalExecutionSpecificationBounds.width;
			if(externalExecutionSpecificationBounds.touches(externalBounds) && externalExecutionSpecificationBounds.x <= childBounds.x) {
				if(parent == null || externalExecutionSpecificationBounds.x > parent.getFigure().getBounds().x) {
					parent = externalExecutionSpecificationEP;
				}
			}
		}
		return parent;
	}

	/**
	 * Used to modify the sizeDelta if the given value is higher/lower than the highest/lowest
	 * allowed values of the figure.
	 * 
	 * @param figure
	 *        the figure
	 * @param sizeDelta
	 *        the size delta
	 * 
	 * @return a corrected sizeDelta
	 */
	protected final static Dimension adaptSizeDeltaToMaxHeight(IFigure figure, Dimension sizeDelta) {
		Dimension newSizeDelta = new Dimension(sizeDelta);

		int figureHeight = figure.getBounds().height;
		int maximunFigureHeight = figure.getMaximumSize().height;
		int minimunFigureHeight = figure.getMinimumSize().height;

		int height = figureHeight + newSizeDelta.height;
		if(height > maximunFigureHeight) {
			newSizeDelta.height = maximunFigureHeight - figureHeight;
		} else if(height < minimunFigureHeight) {
			newSizeDelta.height = minimunFigureHeight - figureHeight;
		}

		return newSizeDelta;
	}

	/**
	 * Returns all the ExecutionSpecification EditParts that are affixed to the right side of the
	 * given ExecutionSpecification EditPart. Not only the ones directly affixed to the
	 * executionSpecificationEP are returned, but the ones that are indirectly affixed as well (this
	 * is done recursively)
	 * 
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	public final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(ShapeNodeEditPart executionSpecificationEP) {
		List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		return getAffixedExecutionSpecificationEditParts(executionSpecificationEP, notToCheckExecutionSpecificationList);

	}

	/**
	 * Operation used by the above operation. It's main goal is to obtain, recursively, all the
	 * affixed ExecutionSpecification. In order to do so, it is needed a ExecutionSpecification
	 * EditPart and the notToCheckList.
	 * 
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * @param notToCheckExecutionSpecificationList
	 *        the not to check ExecutionSpecification list
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	protected final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(ShapeNodeEditPart executionSpecificationEP, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Add itself to the notToCheck list
		List<ShapeNodeEditPart> newNotToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>(notToCheckExecutionSpecificationList);
		newNotToCheckExecutionSpecificationList.add(executionSpecificationEP);

		// LifelineEditPart where the ExecutionSpecification EditPart is contained
		LifelineEditPart lifelineEP = (LifelineEditPart)executionSpecificationEP.getParent();

		// ExecutionSpecification EditParts list
		List<ShapeNodeEditPart> executionSpecificationList = lifelineEP.getChildShapeNodeEditPart();
		executionSpecificationList.remove(newNotToCheckExecutionSpecificationList);

		// List to store the Affixed ExecutionSpecification
		List<ShapeNodeEditPart> affixedExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();

		// Loop ExecutionSpecificationough the ExecutionSpecification list
		for(ShapeNodeEditPart childExecutionSpecificationEP : executionSpecificationList) {
			if(isAffixedToRight(executionSpecificationEP.getFigure().getBounds(), childExecutionSpecificationEP.getFigure().getBounds())) {
				affixedExecutionSpecificationList.add(childExecutionSpecificationEP);
				// Add also it's affixed ExecutionSpecification
				affixedExecutionSpecificationList.addAll(getAffixedExecutionSpecificationEditParts(childExecutionSpecificationEP, newNotToCheckExecutionSpecificationList));
			}
		}

		// To the ExecutionSpecification list
		return affixedExecutionSpecificationList;
	}

	/**
	 * Checks whether the right EditPart is affixed to the left EditPart. In order to do so, the
	 * operation checks if the right figure is really on the right and, if so, it just returns true
	 * if figures touch each other.
	 * 
	 * @param leftFigure
	 *        The left rectangle
	 * @param rightFigure
	 *        The right rectangle
	 * 
	 * @return true if the rectangles of both figures touch and the right figure is really on the
	 *         right. False otherwise
	 */
	protected final static boolean isAffixedToRight(Rectangle leftFigure, Rectangle rightFigure) {
		return leftFigure.touches(rightFigure) && leftFigure.x < rightFigure.x;
	}

	/**
	 * If a ExecutionSpecification EditPart is going to be moved according to a moveDelta, this
	 * operation returns a compoundCommand that also moves the affixed ExecutionSpecification
	 * according to that delta.
	 * 
	 * @param executionSpecificationEP
	 *        The ExecutionSpecification EditPart that is going to be moved
	 * @param moveDelta
	 *        The moveDelta of the previous EditPart
	 * @param newBounds
	 *        the new bounds
	 * 
	 * @return the compound command
	 */
	protected final static CompoundCommand createMovingAffixedExecutionSpecificationCommand(ShapeNodeEditPart executionSpecificationEP, Rectangle moveDelta, Rectangle newBounds) {
		if(moveDelta.y != 0 || moveDelta.height != 0) {
			CompoundCommand compoundCmd = new CompoundCommand();
			for(ShapeNodeEditPart childExecutionSpecificationEP : getAffixedExecutionSpecificationEditParts(executionSpecificationEP)) {
				// Get Relative Bounds
				Rectangle childBounds = getRelativeBounds(childExecutionSpecificationEP.getFigure());
				// Apply delta
				childBounds.y += moveDelta.y;
				childBounds.x += moveDelta.x;

				// Create the child's SetBoundsCommand
				SetBoundsCommand childSetBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Movement of affixed ExecutionSpecification", childExecutionSpecificationEP, childBounds);
				compoundCmd.add(new ICommandProxy(childSetBoundsCmd));


				IFigure parentFigure = childExecutionSpecificationEP.getFigure().getParent();
				parentFigure.translateToAbsolute(newBounds);
				// translateToAbsolute only does half of the work, I don't know why
				newBounds.translate(parentFigure.getBounds().getLocation());

				// change the enclosing interaction of the moved affixed child if necessary
				compoundCmd.add(SequenceUtil.createUpdateEnclosingInteractionCommand(childExecutionSpecificationEP, moveDelta.getLocation(), moveDelta.getSize()));

				// Move it's children as well
				if(!getAffixedExecutionSpecificationEditParts(childExecutionSpecificationEP).isEmpty()) {
					compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(childExecutionSpecificationEP, moveDelta, childBounds));
				}
			}
			if(!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}
		return null;
	}



	/**
	 * Given an AbstractGraphialEditPart and the new relative bounds that the EditPart will have, it
	 * returns the real delta applied to the movement.
	 * 
	 * @param oldRelativeBounds
	 *        The old position of the mentioned EditPart
	 * @param newRelativeBounds
	 *        The new position of the mentioned EditPart
	 * 
	 * @return The real MoveDelta applied
	 */
	protected final static Rectangle getRealMoveDelta(Rectangle oldRelativeBounds, Rectangle newRelativeBounds) {
		Rectangle realMoveDelta = new Rectangle();
		realMoveDelta.x = newRelativeBounds.x - oldRelativeBounds.x;
		realMoveDelta.y = newRelativeBounds.y - oldRelativeBounds.y;
		realMoveDelta.height = newRelativeBounds.height - oldRelativeBounds.height;
		realMoveDelta.width = newRelativeBounds.width - oldRelativeBounds.width;
		return realMoveDelta;
	}

	/**
	 * It returns the relative bounds of an Figure.
	 * 
	 * @param figure
	 *        The Figure
	 * 
	 * @return The relative bounds regarding it's parent figure
	 */
	protected final static Rectangle getRelativeBounds(IFigure figure) {
		Rectangle relBounds = figure.getBounds().getCopy();
		Rectangle parentRectangle = figure.getParent().getBounds();
		relBounds.x -= parentRectangle.x;
		relBounds.y -= parentRectangle.y;
		return relBounds;
	}
}
