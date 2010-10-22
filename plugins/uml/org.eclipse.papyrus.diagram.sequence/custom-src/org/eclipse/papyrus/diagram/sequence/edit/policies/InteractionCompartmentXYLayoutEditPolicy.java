/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * The customn XYLayoutEditPolicy for InteractionCompartmentEditPart.
 */
public class InteractionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * Handle lifeline and combined fragment resize
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		CompoundCommand compoundCmd = new CompoundCommand();
		compoundCmd.setLabel("Move or Resize");

		for(Object o : request.getEditParts()) {
			GraphicalEditPart child = (GraphicalEditPart)o;
			Object constraintFor = getConstraintFor(request, child);
			if(constraintFor != null) {
				if(child instanceof LifelineEditPart) {
					addLifelineResizeChildrenCommand(compoundCmd, request, (LifelineEditPart)child, 1);
				} else if(child instanceof CombinedFragmentEditPart) {
					Command resizeChildrenCommand = getCombinedFragmentResizeChildrenCommand(request, (CombinedFragmentEditPart)child);
					if(resizeChildrenCommand == null) {
						return null;
					}
					if(resizeChildrenCommand.canExecute()) {
						compoundCmd.add(resizeChildrenCommand);
					}
				}

				Command changeConstraintCommand = createChangeConstraintCommand(request, child, translateToModelConstraint(constraintFor));
				compoundCmd.add(changeConstraintCommand);
			}
		}
		return compoundCmd.unwrap();

	}

	/**
	 * Resize children of LifelineEditPart (Execution specification and lifeline)
	 * 
	 * @param compoundCmd
	 *        The command
	 * @param request
	 *        The request
	 * @param lifelineEditPart
	 *        The lifelineEditPart to resize
	 * @param number
	 *        The number of brother of the LifelineEditPart
	 */
	private static void addLifelineResizeChildrenCommand(CompoundCommand compoundCmd, ChangeBoundsRequest request, LifelineEditPart lifelineEditPart, int number) {
		// If the width increases or decreases, ExecutionSpecification elements need to
		// be moved
		int widthDelta;
		for(ShapeNodeEditPart executionSpecificationEP : lifelineEditPart.getChildShapeNodeEditPart()) {
			if(executionSpecificationEP.resolveSemanticElement() instanceof ExecutionSpecification) {
				// Lifeline's figure where the child is drawn
				Rectangle rDotLine = lifelineEditPart.getContentPane().getBounds();

				// The new bounds will be calculated from the current bounds
				Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

				widthDelta = request.getSizeDelta().width;

				if(widthDelta != 0) {

					if(rDotLine.getSize().width + widthDelta < newBounds.width * 2) {
						compoundCmd.add(UnexecutableCommand.INSTANCE);
					}

					// Apply SizeDelta to the children
					widthDelta = Math.round(widthDelta / ((float)2 * number));

					newBounds.x += widthDelta;

					// Convert to relative
					newBounds.x -= rDotLine.x;
					newBounds.y -= rDotLine.y;

					SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Re-location of a ExecutionSpecification due to a Lifeline movement", executionSpecificationEP, newBounds);
					compoundCmd.add(new ICommandProxy(setBoundsCmd));
				}

				// update the enclosing interaction of a moved execution specification
				compoundCmd.add(SequenceUtil.createUpdateEnclosingInteractionCommand(executionSpecificationEP, request.getMoveDelta(), new Dimension(widthDelta, 0)));
			}
		}

		List<LifelineEditPart> innerConnectableElementList = lifelineEditPart.getInnerConnectableElementList();
		for(LifelineEditPart lifelineEP : innerConnectableElementList) {
			addLifelineResizeChildrenCommand(compoundCmd, request, lifelineEP, number * innerConnectableElementList.size());
		}
	}

	/**
	 * Handle the owning of interaction fragments when moving or resizing a CF.
	 * 
	 * @param compoundCmd
	 *        The command
	 * @param moveDelta
	 *        The move delta (given by the request).
	 * @param sizeDelta
	 *        The size delta (given by the request).
	 * @param combinedFragmentEditPart
	 *        The CF edit part.
	 */
	@SuppressWarnings("unchecked")
	public static Command getCombinedFragmentResizeChildrenCommand(ChangeBoundsRequest request, CombinedFragmentEditPart combinedFragmentEditPart) {
		Point moveDelta = request.getMoveDelta();
		Dimension sizeDelta = request.getSizeDelta();

		Rectangle origCFBounds = combinedFragmentEditPart.getFigure().getBounds().getCopy();

		combinedFragmentEditPart.getFigure().translateToAbsolute(origCFBounds);

		CompoundCommand compoundCmd = new CompoundCommand();

		// specific case for move :
		// we want the execution specifications graphically owned by the lifeline to move with the combined fragment, and the contained messages too
		if(sizeDelta.equals(0, 0)) {
			// retrieve all the edit parts in the registry
			Set<Entry<Object, EditPart>> allEditPartEntries = combinedFragmentEditPart.getViewer().getEditPartRegistry().entrySet();
			for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
				EditPart ep = epEntry.getValue();

				// handle move of object graphically owned by the lifeline
				if(ep instanceof ShapeEditPart) {
					ShapeEditPart sep = (ShapeEditPart)ep;
					EObject elem = sep.getNotationView().getElement();

					if(elem instanceof InteractionFragment) {
						IFigure figure = sep.getFigure();

						Rectangle figureBounds = figure.getBounds().getCopy();
						figure.getParent().translateToAbsolute(figureBounds);

						if(origCFBounds.contains(figureBounds)) {
							EditPart parentEP = sep.getParent();

							if(parentEP instanceof LifelineEditPart) {
								ChangeBoundsRequest esRequest = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
								esRequest.setEditParts(sep);
								esRequest.setMoveDelta(moveDelta);

								Command moveESCommand = LifelineXYLayoutEditPolicy.getResizeOrMoveChildrenCommand((LifelineEditPart)parentEP, esRequest, true, false, true);

								if(moveESCommand == null || !moveESCommand.canExecute()) {
									// forbid move if the es can't be moved correctly
									return null;
								}
								compoundCmd.add(moveESCommand);
							}
						}

					}
				}

				// handle move of messages directly attached to a lifeline
				if(ep instanceof ConnectionEditPart) {
					ConnectionEditPart cep = (ConnectionEditPart)ep;

					Connection msgFigure = cep.getConnectionFigure();

					ConnectionAnchor sourceAnchor = msgFigure.getSourceAnchor();
					ConnectionAnchor targetAnchor = msgFigure.getTargetAnchor();

					Point sourcePoint = sourceAnchor.getReferencePoint();
					Point targetPoint = targetAnchor.getReferencePoint();

					Edge edge = (Edge)cep.getModel();

					if(origCFBounds.contains(sourcePoint) && cep.getSource() instanceof LifelineEditPart) {
						IdentityAnchor gmfAnchor = (IdentityAnchor)edge.getSourceAnchor();
						Rectangle figureBounds = sourceAnchor.getOwner().getBounds();
						compoundCmd.add(new ICommandProxy(getMoveAnchorCommand(moveDelta.y, figureBounds, gmfAnchor)));
					}
					if(origCFBounds.contains(targetPoint) && cep.getTarget() instanceof LifelineEditPart) {
						IdentityAnchor gmfAnchor = (IdentityAnchor)edge.getTargetAnchor();
						Rectangle figureBounds = targetAnchor.getOwner().getBounds();
						compoundCmd.add(new ICommandProxy(getMoveAnchorCommand(moveDelta.y, figureBounds, gmfAnchor)));
					}
				}
			}

		} else {
			// calculate the new CF bounds
			Rectangle newBoundsCF = origCFBounds.getCopy();
			newBoundsCF.translate(moveDelta);
			newBoundsCF.resize(sizeDelta);

			CombinedFragment cf = (CombinedFragment)((CombinedFragmentEditPart)combinedFragmentEditPart).resolveSemanticElement();

			if(combinedFragmentEditPart.getChildren().size() > 0 && combinedFragmentEditPart.getChildren().get(0) instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {

				CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragmentEditPart.getChildren().get(0);
				List<EditPart> interactionOperandEditParts = compartment.getChildren();

				InteractionOperand firstOperand = null;

				for(EditPart ep : interactionOperandEditParts) {
					if(ep instanceof InteractionOperandEditPart) {
						InteractionOperandEditPart ioEP = (InteractionOperandEditPart)ep;
						InteractionOperand io = (InteractionOperand)ioEP.resolveSemanticElement();

						Rectangle newBoundsIO = ioEP.getFigure().getBounds().getCopy();

						// used to compensate the height of the "header" where the OperandKind is stored
						if(firstOperand == null) {
							firstOperand = io;
							int heightDiff = newBoundsIO.y - origCFBounds.y;
							newBoundsIO.y = origCFBounds.y;
							newBoundsIO.height += heightDiff;
						}

						// calculate the new bounds of the interaction operand
						// this is currently wrong for a resize of a CF with multiple IO
						ioEP.getFigure().translateToAbsolute(newBoundsIO);
						newBoundsIO.translate(moveDelta);
						newBoundsIO.resize(sizeDelta);

						Set<InteractionFragment> coveredInteractionFragments = SequenceUtil.getCoveredInteractionFragments(newBoundsIO, combinedFragmentEditPart);

						// retrieve fragments currently owned by the interaction operand so we can remove fragments that are not covered anymore
						Set<InteractionFragment> notCoveredAnymoreInteractionFragments = new HashSet<InteractionFragment>(io.getFragments());
						notCoveredAnymoreInteractionFragments.removeAll(coveredInteractionFragments);

						for(InteractionFragment ift : notCoveredAnymoreInteractionFragments) {
							if(cf.getEnclosingOperand() != null) {
								compoundCmd.add(new ICommandProxy(SequenceUtil.getSetEnclosingInteractionCommand(ioEP.getEditingDomain(), ift, cf.getEnclosingOperand())));
							} else {
								compoundCmd.add(new ICommandProxy(SequenceUtil.getSetEnclosingInteractionCommand(ioEP.getEditingDomain(), ift, cf.getEnclosingInteraction())));
							}
						}

						// set the enclosing operand to the moved/resized one if the current enclosing interaction is the enclosing interaction
						// of the moved/resized operand.
						// => the interaction fragment that are inside an other container (like an enclosed CF) are not modified
						for(InteractionFragment ift : coveredInteractionFragments) {
							if(!cf.equals(ift)) {
								if((cf.getEnclosingOperand() != null && cf.getEnclosingOperand().equals(ift.getEnclosingOperand())) || (cf.getEnclosingInteraction() != null && cf.getEnclosingInteraction().equals(ift.getEnclosingInteraction()))) {
									compoundCmd.add(new ICommandProxy(SequenceUtil.getSetEnclosingInteractionCommand(ioEP.getEditingDomain(), ift, io)));
								}
							}
						}
					}
				}
			}
		}

		return compoundCmd;
	}

	private static ICommand getMoveAnchorCommand(int yDelta, Rectangle figureBounds, IdentityAnchor gmfAnchor) {
		String oldTerminal = gmfAnchor.getId();
		PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(oldTerminal);

		int yPos = (int)Math.round(figureBounds.height * pp.preciseY);
		yPos += yDelta;

		pp.preciseY = (double)yPos / figureBounds.height;

		if(pp.preciseY > 1.0) {
			pp.preciseY = 1.0;
		} else if(pp.preciseY < 0.0) {
			pp.preciseY = 0.0;
		}

		String newTerminal = (new BaseSlidableAnchor(null, pp)).getTerminal();

		return new SetValueCommand(new SetRequest(gmfAnchor, NotationPackage.Literals.IDENTITY_ANCHOR__ID, newTerminal));
	}

	/**
	 * Change constraint for comportment by return null if the resize is lower than the minimun
	 * size.
	 */
	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {
		Rectangle rect = new PrecisionRectangle(child.getFigure().getBounds());
		child.getFigure().translateToAbsolute(rect);
		rect = request.getTransformedRectangle(rect);
		child.getFigure().translateToRelative(rect);
		rect.translate(getLayoutOrigin().getNegated());

		if(request.getSizeDelta().width == 0 && request.getSizeDelta().height == 0) {
			Rectangle cons = getCurrentConstraintFor(child);
			if(cons != null) {
				rect.setSize(cons.width, cons.height);
			}
		} else { // resize
			Dimension minSize = getMinimumSizeFor(child);
			if(rect.width < minSize.width) {
				return null;
			}
			if(rect.height < minSize.height) {
				return null;
			}
		}
		rect = (Rectangle)getConstraintFor(rect);

		Rectangle cons = getCurrentConstraintFor(child);
		if(request.getSizeDelta().width == 0) {
			rect.width = cons.width;
		}
		if(request.getSizeDelta().height == 0) {
			rect.height = cons.height;
		}

		return rect;
	}

	/**
	 * Handle mininum size for lifeline
	 */
	@Override
	protected Dimension getMinimumSizeFor(GraphicalEditPart child) {
		Dimension minimunSize;
		if(child instanceof LifelineEditPart) {
			minimunSize = getMinimumSizeFor((LifelineEditPart)child);
		} else {
			minimunSize = super.getMinimumSizeFor(child);
		}
		return minimunSize;
	}

	/**
	 * Get minimun for a lifeline
	 * 
	 * @param child
	 *        The lifeline
	 * @return The minimun size
	 */
	private Dimension getMinimumSizeFor(LifelineEditPart child) {
		LifelineEditPart lifelineEditPart = child;
		Dimension minimunSize = lifelineEditPart.getFigure().getMinimumSize();
		for(LifelineEditPart lifelineEP : lifelineEditPart.getInnerConnectableElementList()) {
			minimunSize.union(getMinimumSizeFor(lifelineEP));
		}
		for(ShapeNodeEditPart executionSpecificationEP : lifelineEditPart.getChildShapeNodeEditPart()) {
			int minimunHeight = executionSpecificationEP.getFigure().getBounds().bottom();
			minimunSize.setSize(new Dimension(minimunSize.width, Math.max(minimunSize.height, minimunHeight)));
		}
		return minimunSize;
	}

	/**
	 * Block adding element by movement on Interaction
	 */
	@Override
	public Command getAddCommand(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getAddCommand(request);
	}


	/**
	 * Overrides to change the policy of connection anchors when resizing the lifeline.
	 * When resizing the lifeline, the connection must not move.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCommand(org.eclipse.gef.Request)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = (ChangeBoundsRequest)request;

			int resizeDirection = cbr.getResizeDirection();

			CompoundCommand compoundCmd = new CompoundCommand("Resize of Interaction Compartment Elements");

			for(EditPart ep : (List<EditPart>)cbr.getEditParts()) {
				if(ep instanceof LifelineEditPart) {
					// Lifeline EditPart
					LifelineEditPart lifelineEP = (LifelineEditPart)ep;

					int preserveY = PreserveAnchorsPositionCommand.PRESERVE_Y;
					Dimension newSizeDelta = PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors(lifelineEP, cbr.getSizeDelta(), preserveY);

					// SetBounds command modifying the sizeDelta
					compoundCmd.add(getSetBoundsCommand(lifelineEP, cbr, newSizeDelta));

					// PreserveAnchors command
					compoundCmd.add(new ICommandProxy(new PreserveAnchorsPositionCommand(lifelineEP, newSizeDelta, preserveY, lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure(), resizeDirection)));
				}
			}

			if(compoundCmd.size() == 0) {
				return super.getCommand(request);
			} else {
				return compoundCmd;
			}
		}

		return super.getCommand(request);
	}

	/**
	 * It obtains an appropriate SetBoundsCommand for a LifelineEditPart. The
	 * newSizeDelta provided should be equal o less than the one contained in
	 * the request. The goal of this newDelta is to preserve the anchors'
	 * positions after the resize. It is recommended to obtain this newSizeDelta
	 * by means of calling
	 * PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors() operation
	 * 
	 * @param lifelineEP
	 *        The Lifeline that will be moved or resized
	 * @param cbr
	 *        The ChangeBoundsRequest for moving or resized the lifelineEP
	 * @param newSizeDelta
	 *        The sizeDelta to used instead of the one contained in the
	 *        request
	 * @return The SetBoundsCommand
	 */
	@SuppressWarnings("rawtypes")
	protected Command getSetBoundsCommand(LifelineEditPart lifelineEP, ChangeBoundsRequest cbr, Dimension newSizeDelta) {
		// Modify request
		List epList = cbr.getEditParts();
		Dimension oldSizeDelta = cbr.getSizeDelta();
		cbr.setEditParts(lifelineEP);
		cbr.setSizeDelta(newSizeDelta);

		// Obtain the command with the modified request
		Command cmd = super.getCommand(cbr);

		// Restore the request
		cbr.setEditParts(epList);
		cbr.setSizeDelta(oldSizeDelta);

		// Return the SetBoundsCommand only for the Lifeline and with the
		// sizeDelta modified in order to preserve the links' anchors positions
		return cmd;
	}

}
