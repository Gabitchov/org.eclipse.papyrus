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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ObservationLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * This Helper must be used for performing move/reconnect operations which modify the location of an OccurrenceSpecification.
 * 
 * @author vhemery
 */
public class OccurrenceSpecificationMoveHelper {

	/**
	 * Get the complete command to move or reconnect all edit parts attached to one or two occurrence specification(s).
	 * 
	 * @param movedOccurrenceSpecification1
	 *        first moved occurrence specification
	 * @param movedOccurrenceSpecification2
	 *        second moved occurrence specification (or null)
	 * @param yLocation1
	 *        y location where first occurrence specification is moved
	 * @param yLocation2
	 *        y location where second occurrence specification is moved (or -1)
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param notToMoveEditParts
	 *        list of edit parts which must not be moved in the created command
	 * @return command to move all edit parts linked to the occurrence specifications or null
	 */
	public static Command getMoveOccurrenceSpecificationsCommand(OccurrenceSpecification movedOccurrenceSpecification1, OccurrenceSpecification movedOccurrenceSpecification2, int yLocation1, int yLocation2, LifelineEditPart lifelinePart, List<EditPart> notToMoveEditParts) {
		// the global command which shall be completed and returned
		CompoundCommand globalCmd = new CompoundCommand();
		// move the corresponding execution specification if necessary
		Command command = getMoveExecutionSpecificationCommand(movedOccurrenceSpecification1, movedOccurrenceSpecification2, yLocation1, yLocation2, lifelinePart, notToMoveEditParts);
		if(command != null) {
			globalCmd.add(command);
		}
		// reconnect the corresponding message(s) if necessary
		if(movedOccurrenceSpecification1 instanceof MessageOccurrenceSpecification) {
			command = getReconnectMessageCommand(movedOccurrenceSpecification1, yLocation1, lifelinePart, notToMoveEditParts);
			if(command != null) {
				globalCmd.add(command);
			}
		}
		if(movedOccurrenceSpecification2 instanceof MessageOccurrenceSpecification) {
			command = getReconnectMessageCommand(movedOccurrenceSpecification2, yLocation2, lifelinePart, notToMoveEditParts);
			if(command != null) {
				globalCmd.add(command);
			}
		}
		// move the corresponding time/duration constraints/observations if necessary
		command = getMoveTimeElementsCommand(movedOccurrenceSpecification1, movedOccurrenceSpecification2, yLocation1, yLocation2, lifelinePart, notToMoveEditParts);
		if(command != null) {
			globalCmd.add(command);
		}
		// reconnect the corresponding general ordering(s) if necessary
		command = getReconnectGeneralOrderingCommand(movedOccurrenceSpecification1, yLocation1, lifelinePart, notToMoveEditParts);
		if(command != null) {
			globalCmd.add(command);
		}
		if(movedOccurrenceSpecification2 != null) {
			command = getReconnectGeneralOrderingCommand(movedOccurrenceSpecification2, yLocation2, lifelinePart, notToMoveEditParts);
			if(command != null) {
				globalCmd.add(command);
			}
		}
		// return null rather than an empty non executable command
		if(globalCmd.isEmpty()) {
			return null;
		}
		return globalCmd;
	}

	/**
	 * Get the command to reconnect general ordering attached to a moved occurrence specification
	 * 
	 * @param movedOccurrenceSpecification
	 *        moving occurrence specification
	 * @param yLocation
	 *        y location where occurrence specification is moved
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param notToMoveEditParts
	 *        list of edit parts which must not be moved in the created command
	 * @return command to reconnect general ordering edit parts linked to the occurrence specification or null
	 */
	private static Command getReconnectGeneralOrderingCommand(OccurrenceSpecification movedOccurrenceSpecification, int yLocation, LifelineEditPart lifelinePart, List<EditPart> notToMoveEditParts) {
		// the global command which shall be completed and returned
		CompoundCommand command = new CompoundCommand();
		Point referencePoint = getReferencePoint(lifelinePart, movedOccurrenceSpecification, yLocation);
		EditPart childToReconnectTo = SequenceUtil.findPartToReconnectTo(lifelinePart, referencePoint);
		// if referencePoint is on a moved part, it must be translated with the location delta of this part
		if(!notToMoveEditParts.isEmpty() && childToReconnectTo != lifelinePart) {
			Point oldLoc = SequenceUtil.findLocationOfEvent(lifelinePart, movedOccurrenceSpecification);
			referencePoint.y = oldLoc.y;
		}
		// reconnect general ordering from the event
		for(GeneralOrdering go : movedOccurrenceSpecification.getToAfters()) {
			Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(go);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
					// the general ordering part must start or finish on the lifeline (with the event)
					if(part instanceof ConnectionEditPart && !notToMoveEditParts.contains(part)) {
						Request reconnectRequest = makeReconnectRequest((ConnectionEditPart)part, true, referencePoint, childToReconnectTo);
						Command reconnect = childToReconnectTo.getCommand(reconnectRequest);
						if(reconnect.canExecute()) {
							command.add(reconnect);
						}
					}
				}
			}
		}
		// reconnect general ordering to the event
		for(GeneralOrdering go : movedOccurrenceSpecification.getToBefores()) {
			Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(go);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
					// the general ordering part must start or finish on the lifeline (with the event)
					if(part instanceof ConnectionEditPart && !notToMoveEditParts.contains(part)) {
						Request reconnectRequest = makeReconnectRequest((ConnectionEditPart)part, false, referencePoint, childToReconnectTo);
						Command reconnect = childToReconnectTo.getCommand(reconnectRequest);
						if(reconnect.canExecute()) {
							command.add(reconnect);
						}
					}
				}
			}
		}
		// return null rather than an empty non executable command
		if(command.isEmpty()) {
			return null;
		}
		return command;
	}

	/**
	 * Get the command to reconnect message attached to a moved occurrence specification
	 * 
	 * @param movedOccurrenceSpecification
	 *        moving occurrence specification
	 * @param yLocation
	 *        y location where occurrence specification is moved
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param notToMoveEditParts
	 *        list of edit parts which must not be moved in the created command
	 * @return command to reconnect message edit part linked to the occurrence specification or null
	 */
	private static Command getReconnectMessageCommand(OccurrenceSpecification movedOccurrenceSpecification, int yLocation, LifelineEditPart lifelinePart, List<EditPart> notToMoveEditParts) {
		// the global command which shall be completed and returned
		CompoundCommand command = new CompoundCommand();
		if(movedOccurrenceSpecification instanceof MessageOccurrenceSpecification) {
			Point referencePoint = getReferencePoint(lifelinePart, movedOccurrenceSpecification, yLocation);
			EditPart childToReconnectTo = SequenceUtil.findPartToReconnectTo(lifelinePart, referencePoint);
			// reconnect message from the event
			Message message = ((MessageOccurrenceSpecification)movedOccurrenceSpecification).getMessage();
			if(message != null && movedOccurrenceSpecification.equals(message.getSendEvent())) {
				Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(message);
				for(Setting ref : settings) {
					if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
						View view = (View)ref.getEObject();
						EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
						// the message part must start or finish on the lifeline (with the event)
						if(part instanceof ConnectionEditPart && !notToMoveEditParts.contains(part)) {
							Request reconnectRequest = makeReconnectRequest((ConnectionEditPart)part, true, referencePoint, childToReconnectTo);
							Command reconnect = childToReconnectTo.getCommand(reconnectRequest);
							command.add(reconnect);
							// update enclosing interaction fragment
							Command updateIFrag = SequenceUtil.createUpdateEnclosingInteractionCommand((MessageOccurrenceSpecification)movedOccurrenceSpecification, referencePoint, lifelinePart);
							if(updateIFrag != null && updateIFrag.canExecute()) {
								command.add(updateIFrag);
							}
						}
					}
				}
			}
			// reconnect message to the event
			if(message != null && movedOccurrenceSpecification.equals(message.getReceiveEvent())) {
				Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(message);
				for(Setting ref : settings) {
					if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
						View view = (View)ref.getEObject();
						EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
						// the message part must start or finish on the lifeline (with the event)
						if(part instanceof ConnectionEditPart && !notToMoveEditParts.contains(part)) {
							Request reconnectRequest = makeReconnectRequest((ConnectionEditPart)part, false, referencePoint, childToReconnectTo);
							Command reconnect = childToReconnectTo.getCommand(reconnectRequest);
							command.add(reconnect);
							// update enclosing interaction fragment
							Command updateIFrag = SequenceUtil.createUpdateEnclosingInteractionCommand((MessageOccurrenceSpecification)movedOccurrenceSpecification, referencePoint, lifelinePart);
							if(updateIFrag != null && updateIFrag.canExecute()) {
								command.add(updateIFrag);
							}
						}
					}
				}
			}
		}
		// return null rather than an empty non executable command
		if(command.isEmpty()) {
			return null;
		}
		return command;
	}

	/**
	 * Get the command to move time/duration observations/constraints attached to a moved occurrence specification
	 * 
	 * @param movedOccurrenceSpecification1
	 *        first moved occurrence specification
	 * @param movedOccurrenceSpecification2
	 *        second moved occurrence specification (or null)
	 * @param yLocation1
	 *        y location where first occurrence specification is moved
	 * @param yLocation2
	 *        y location where second occurrence specification is moved (or -1)
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param notToMoveEditParts
	 *        list of edit parts which must not be moved in the created command
	 * @return command to move time edit parts linked to the occurrence specification or null
	 */
	private static Command getMoveTimeElementsCommand(OccurrenceSpecification movedOccurrenceSpecification1, OccurrenceSpecification movedOccurrenceSpecification2, int yLocation1, int yLocation2, LifelineEditPart lifelinePart, List<EditPart> notToMoveEditParts) {
		// the global command which shall be completed and returned
		CompoundCommand globalCmd = new CompoundCommand();
		IFigure lifelineFigure = lifelinePart.getFigure();
		// relocate each linked time element contained within the lifeline part
		for(Object lifelineChild : lifelinePart.getChildren()) {
			if(lifelineChild instanceof IBorderItemEditPart && !notToMoveEditParts.contains(lifelineChild)) {
				final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
				Command cmd = getMoveSingleTimeRelatedElementCommand(timePart, movedOccurrenceSpecification1, movedOccurrenceSpecification2, yLocation1, yLocation2, lifelinePart);
				if(cmd != null) {
					globalCmd.add(cmd);
				}
			}
		}
		// relocate each observation linked time element
		for(Object targetConnection : lifelinePart.getTargetConnections()) {
			if(targetConnection instanceof ObservationLinkEditPart) {
				Command cmd = getMoveSingleTimeRelatedElementCommand((ObservationLinkEditPart)targetConnection, movedOccurrenceSpecification1, movedOccurrenceSpecification2, yLocation1, yLocation2, lifelinePart);
				if(cmd != null) {
					globalCmd.add(cmd);
				}
			}
		}
		// refresh layout commands :
		// one before the commands for the undo and one after for classic execution
		if(!globalCmd.isEmpty() && lifelineFigure instanceof BorderedNodeFigure) {
			Command relayout = getReLayoutCmd((BorderedNodeFigure)lifelineFigure, false);
			Command relayoutUndo = getReLayoutCmd((BorderedNodeFigure)lifelineFigure, true);
			if(relayout != null && relayoutUndo != null) {
				CompoundCommand commandWithRelayout = new CompoundCommand();
				commandWithRelayout.add(relayoutUndo);
				commandWithRelayout.add(globalCmd);
				commandWithRelayout.add(relayout);
				return commandWithRelayout;
			}
		}
		// return null rather than an empty non executable command
		if(globalCmd.isEmpty()) {
			return null;
		}
		return globalCmd;
	}

	private static Command getMoveSingleTimeRelatedElementCommand(final ObservationLinkEditPart targetConnection, final OccurrenceSpecification movedOccurrenceSpecification1, final OccurrenceSpecification movedOccurrenceSpecification2, final int yLocation1, final int yLocation2, final LifelineEditPart lifelinePart) {
		AbstractTransactionalCommand updateTargetAnchorCommand = new AbstractTransactionalCommand(((IGraphicalEditPart)targetConnection).getEditingDomain(), "update target anchor", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				// both bounds may have changed
				Point referencePoint1 = getReferencePoint(lifelinePart, movedOccurrenceSpecification1, yLocation1);
				Point referencePoint2 = getReferencePoint(lifelinePart, movedOccurrenceSpecification2, yLocation2);
				int position1 = PositionConstants.NONE;
				int position2 = PositionConstants.NONE;
				TimeObservationLabelEditPart tolEP = (TimeObservationLabelEditPart)targetConnection.getSource();
				if(tolEP == null) {
					return CommandResult.newCancelledCommandResult();
				}
				if(movedOccurrenceSpecification1 != null) {
					position1 = SequenceUtil.positionWhereEventIsLinkedToPart(movedOccurrenceSpecification1, tolEP);
				}
				if(movedOccurrenceSpecification2 != null) {
					position2 = SequenceUtil.positionWhereEventIsLinkedToPart(movedOccurrenceSpecification2, tolEP);
				}
				ConnectionAnchor targetAnchor = null;
				if(position1 == PositionConstants.CENTER) {
					targetAnchor = LifelineEditPartUtil.getNodeFigure(lifelinePart).getSourceConnectionAnchorAt(referencePoint1);
				} else if(position2 == PositionConstants.CENTER) {
					targetAnchor = LifelineEditPartUtil.getNodeFigure(lifelinePart).getSourceConnectionAnchorAt(referencePoint2);
				}
				if(targetAnchor != null) {
					String newTargetTerminal = lifelinePart.mapConnectionAnchorToTerminal(targetAnchor);
					ConnectorImpl c = (ConnectorImpl)targetConnection.getModel();
					if(newTargetTerminal != null) {
						if(newTargetTerminal.length() == 0) {
							c.setTargetAnchor(null);
						} else {
							IdentityAnchor a = (IdentityAnchor)c.getTargetAnchor();
							if(a == null) {
								a = NotationFactory.eINSTANCE.createIdentityAnchor();
							}
							a.setId(newTargetTerminal);
							c.setTargetAnchor(a);
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		// return the resize command
		ICommandProxy resize = new ICommandProxy(updateTargetAnchorCommand);
		return resize;
	}

	/**
	 * Get a command to move the time related element's edit part
	 * 
	 * @param timePart
	 *        time related element's edit part to move
	 * @param movedOccurrenceSpecification1
	 *        first moved occurrence specification
	 * @param movedOccurrenceSpecification2
	 *        second moved occurrence specification (or null)
	 * @param yLocation1
	 *        y location where first occurrence specification is moved
	 * @param yLocation2
	 *        y location where second occurrence specification is moved (or -1)
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @return
	 */
	private static Command getMoveSingleTimeRelatedElementCommand(IBorderItemEditPart timePart, OccurrenceSpecification movedOccurrenceSpecification1, OccurrenceSpecification movedOccurrenceSpecification2, int yLocation1, int yLocation2, LifelineEditPart lifelinePart) {
		IFigure lifelineFigure = lifelinePart.getFigure();
		// get positions where edit part is attached to events
		int position1 = PositionConstants.NONE;
		int position2 = PositionConstants.NONE;
		if(movedOccurrenceSpecification1 != null) {
			position1 = SequenceUtil.positionWhereEventIsLinkedToPart(movedOccurrenceSpecification1, timePart);
		}
		if(movedOccurrenceSpecification2 != null) {
			position2 = SequenceUtil.positionWhereEventIsLinkedToPart(movedOccurrenceSpecification2, timePart);
		}
		// move necessary bounds
		Rectangle newBounds = null;
		if(position1 != PositionConstants.NONE && position2 != PositionConstants.NONE) {
			// both bounds may have changed
			Point referencePoint1 = getReferencePoint(lifelinePart, movedOccurrenceSpecification1, yLocation1);
			Point referencePoint2 = getReferencePoint(lifelinePart, movedOccurrenceSpecification2, yLocation2);
			makeRelativeToLifeline(referencePoint1, lifelinePart, false);
			makeRelativeToLifeline(referencePoint2, lifelinePart, false);
			// Get old bounds information by consulting old figure
			int oldY = timePart.getFigure().getBounds().getLocation().y - lifelineFigure.getBounds().getLocation().y;
			int oldHeight = timePart.getFigure().getSize().height;
			// Compute new bounds of the time element
			if(position1 == PositionConstants.CENTER || position2 == PositionConstants.CENTER) {
				// should not happen, except if both events are merged at the same location
				newBounds = new Rectangle(referencePoint1.x, referencePoint1.y - oldHeight / 2, -1, oldHeight);
			} else {
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position1 == PositionConstants.TOP) {
					top = referencePoint1.y;
				} else if(position1 == PositionConstants.BOTTOM) {
					bottom = referencePoint1.y;
				}
				if(position2 == PositionConstants.TOP) {
					top = referencePoint2.y;
				} else if(position2 == PositionConstants.BOTTOM) {
					bottom = referencePoint2.y;
				}
				// top and bottom may have been inverted during the move.
				// restore x position, fix time duration always move to east
				int viewX = (Integer)ViewUtil.getPropertyValue((View)timePart.getModel(), NotationPackage.eINSTANCE.getLocation_X(), NotationPackage.eINSTANCE.getLocation_X().getEContainingClass());
				newBounds = new Rectangle(viewX, Math.min(top, bottom), -1, Math.abs(bottom - top));
				//				newBounds = new Rectangle(referencePoint1.x, Math.min(top, bottom), -1, Math.abs(bottom - top));
			}
		} else if(position1 != PositionConstants.NONE) {
			Point referencePoint1 = getReferencePoint(lifelinePart, movedOccurrenceSpecification1, yLocation1);
			makeRelativeToLifeline(referencePoint1, lifelinePart, false);
			// Get old bounds information by consulting old figure
			int oldY = timePart.getFigure().getBounds().getLocation().y - lifelineFigure.getBounds().getLocation().y;
			int oldHeight = timePart.getFigure().getSize().height;
			// Compute new bounds of the time element
			if(position1 == PositionConstants.CENTER) {
				newBounds = new Rectangle(referencePoint1.x, referencePoint1.y - oldHeight / 2, -1, oldHeight);
			} else {
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position1 == PositionConstants.TOP) {
					top = referencePoint1.y;
				} else if(position1 == PositionConstants.BOTTOM) {
					bottom = referencePoint1.y;
				}
				// top and bottom may have been inverted during the move.
				newBounds = new Rectangle(referencePoint1.x, Math.min(top, bottom), -1, Math.abs(bottom - top));
			}
		} else if(position2 != PositionConstants.NONE) {
			Point referencePoint2 = getReferencePoint(lifelinePart, movedOccurrenceSpecification2, yLocation2);
			makeRelativeToLifeline(referencePoint2, lifelinePart, false);
			// Get old bounds information by consulting old figure
			int oldY = timePart.getFigure().getBounds().getLocation().y - lifelineFigure.getBounds().getLocation().y;
			int oldHeight = timePart.getFigure().getSize().height;
			// Compute new bounds of the time element
			if(position2 == PositionConstants.CENTER) {
				newBounds = new Rectangle(referencePoint2.x, referencePoint2.y - oldHeight / 2, -1, oldHeight);
			} else {
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position2 == PositionConstants.TOP) {
					top = referencePoint2.y;
				} else if(position2 == PositionConstants.BOTTOM) {
					bottom = referencePoint2.y;
				}
				// top and bottom may have been inverted during the move.
				newBounds = new Rectangle(referencePoint2.x, Math.min(top, bottom), -1, Math.abs(bottom - top));
			}
		}
		if(newBounds != null) {
			TransactionalEditingDomain editingDomain = timePart.getEditingDomain();
			if(timePart instanceof CustomDurationConstraintEditPart) {
				CustomDurationConstraintEditPart dcep = (CustomDurationConstraintEditPart)timePart;
				newBounds = dcep.updateMoveBounds(newBounds);
			}
			// return the resize command
			ICommandProxy resize = new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter((View)timePart.getModel()), newBounds));
			return resize;
		}
		return null;
	}

	/**
	 * Make an absolute point relative to a lifeline figure.
	 * 
	 * @param absolutePoint
	 *        the absolute point to translate
	 * @param lifelinePart
	 *        the containing lifeline edit part
	 */
	private static void makeRelativeToLifeline(Point absolutePoint, LifelineEditPart lifelinePart, boolean relativeToContentPane) {
		IFigure figure;
		if(relativeToContentPane) {
			figure = lifelinePart.getContentPane();
		} else {
			figure = lifelinePart.getFigure();
		}
		figure.translateToRelative(absolutePoint);
		absolutePoint.translate(figure.getBounds().getLocation().getNegated());
	}

	/**
	 * Get the command to move execution specification(s) attached to moved occurrence specification(s)
	 * 
	 * @param movedOccurrenceSpecification1
	 *        first moved occurrence specification
	 * @param movedOccurrenceSpecification2
	 *        second moved occurrence specification (or null)
	 * @param yLocation1
	 *        y location where first occurrence specification is moved
	 * @param yLocation2
	 *        y location where second occurrence specification is moved (or -1)
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param notToMoveEditParts
	 *        list of edit parts which must not be moved in the created command
	 * @return command to move execution specification edit part linked to the occurrence specification or null
	 */
	private static Command getMoveExecutionSpecificationCommand(OccurrenceSpecification movedOccurrenceSpecification1, OccurrenceSpecification movedOccurrenceSpecification2, int yLocation1, int yLocation2, LifelineEditPart lifelinePart, List<EditPart> notToMoveEditParts) {
		// the global command which shall be completed and returned
		CompoundCommand globalCmd = new CompoundCommand();
		// execution(s) linked to the event must be resized
		EditPart node1 = null;
		if(movedOccurrenceSpecification1 != null) {
			node1 = SequenceUtil.getLinkedEditPart(lifelinePart, movedOccurrenceSpecification1);
		}
		EditPart node2 = null;
		if(movedOccurrenceSpecification2 != null) {
			node2 = SequenceUtil.getLinkedEditPart(lifelinePart, movedOccurrenceSpecification2);
		}
		if(node1 instanceof GraphicalEditPart && !notToMoveEditParts.contains(node1)) {
			Command cmd = getMoveSingleExecutionSpecificationCommand((GraphicalEditPart)node1, movedOccurrenceSpecification1, movedOccurrenceSpecification2, yLocation1, yLocation2, lifelinePart);
			if(cmd != null) {
				globalCmd.add(cmd);
			}
		}
		if(node2 != node1 && node2 instanceof GraphicalEditPart && !notToMoveEditParts.contains(node2)) {
			Command cmd = getMoveSingleExecutionSpecificationCommand((GraphicalEditPart)node2, movedOccurrenceSpecification2, null, yLocation2, -1, lifelinePart);
			if(cmd != null) {
				globalCmd.add(cmd);
			}
		}
		// return null rather than an empty non executable command
		if(globalCmd.isEmpty()) {
			return null;
		}
		return globalCmd;
	}

	/**
	 * Get the command to move an execution specification attached to moved occurrence specification(s)
	 * 
	 * @param executionSpecificationPart
	 *        the execution specification edit part to move
	 * @param movedOccurrenceSpecification1
	 *        first moved occurrence specification
	 * @param movedOccurrenceSpecification2
	 *        second moved occurrence specification (or null)
	 * @param yLocation1
	 *        y location where first occurrence specification is moved
	 * @param yLocation2
	 *        y location where second occurrence specification is moved (or -1)
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @return command to move the execution specification edit part or null
	 */
	private static Command getMoveSingleExecutionSpecificationCommand(GraphicalEditPart executionSpecificationPart, OccurrenceSpecification movedOccurrenceSpecification1, OccurrenceSpecification movedOccurrenceSpecification2, int yLocation1, int yLocation2, LifelineEditPart lifelinePart) {
		// execution linked to the event must be resized
		EObject execution = executionSpecificationPart.resolveSemanticElement();
		if(execution instanceof ExecutionSpecification) {
			// finish or start events of the execution have been moved
			// get positions where execution edit part is attached to events
			int position1 = PositionConstants.NONE;
			int position2 = PositionConstants.NONE;
			OccurrenceSpecification start = ((ExecutionSpecification)execution).getStart();
			OccurrenceSpecification finish = ((ExecutionSpecification)execution).getFinish();
			if(start != null && start.equals(movedOccurrenceSpecification1)) {
				position1 = PositionConstants.TOP;
			} else if(finish != null && finish.equals(movedOccurrenceSpecification1)) {
				position1 = PositionConstants.BOTTOM;
			}
			if(start != null && start.equals(movedOccurrenceSpecification2)) {
				position2 = PositionConstants.TOP;
			} else if(finish != null && finish.equals(movedOccurrenceSpecification2)) {
				position2 = PositionConstants.BOTTOM;
			}
			// move necessary bounds
			Rectangle newBounds = null;
			int heighDelta = 0;
			if(position1 != PositionConstants.NONE && position2 != PositionConstants.NONE) {
				// both bounds have changed
				Point referencePoint1 = getReferencePoint(lifelinePart, movedOccurrenceSpecification1, yLocation1);
				Point referencePoint2 = getReferencePoint(lifelinePart, movedOccurrenceSpecification2, yLocation2);
				makeRelativeToLifeline(referencePoint1, lifelinePart, true);
				makeRelativeToLifeline(referencePoint2, lifelinePart, true);
				// Get old bounds information by consulting old figure
				Rectangle esBounds = SequenceUtil.getAbsoluteBounds(executionSpecificationPart);
				Point esLoc = esBounds.getLocation();
				makeRelativeToLifeline(esLoc, lifelinePart, true);
				esBounds.setLocation(esLoc);
				int oldX = esBounds.x;
				int oldY = esBounds.y;
				int oldWidth = esBounds.width;
				int oldHeight = esBounds.height;
				// Compute new bounds of the time element
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position1 == PositionConstants.TOP) {
					top = referencePoint1.y;
				} else if(position1 == PositionConstants.BOTTOM) {
					bottom = referencePoint1.y;
				}
				if(position2 == PositionConstants.TOP) {
					top = referencePoint2.y;
				} else if(position2 == PositionConstants.BOTTOM) {
					bottom = referencePoint2.y;
				}
				// top and bottom may have been inverted during the move.
				newBounds = new Rectangle(oldX, Math.min(top, bottom), oldWidth, Math.abs(bottom - top));
			} else if(position1 != PositionConstants.NONE) {
				Point referencePoint1 = getReferencePoint(lifelinePart, movedOccurrenceSpecification1, yLocation1);
				makeRelativeToLifeline(referencePoint1, lifelinePart, true);
				// Get old bounds information by consulting old figure
				Rectangle esBounds = SequenceUtil.getAbsoluteBounds(executionSpecificationPart);
				Point esLoc = esBounds.getLocation();
				makeRelativeToLifeline(esLoc, lifelinePart, true);
				esBounds.setLocation(esLoc);
				int oldX = esBounds.x;
				int oldY = esBounds.y;
				int oldWidth = esBounds.width;
				int oldHeight = esBounds.height;
				// Compute new bounds of the time element
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position1 == PositionConstants.TOP) {
					top = referencePoint1.y;
				} else if(position1 == PositionConstants.BOTTOM) {
					bottom = referencePoint1.y;
				}
				// top and bottom may have been inverted during the move.
				newBounds = new Rectangle(oldX, Math.min(top, bottom), oldWidth, Math.abs(bottom - top));
			} else if(position2 != PositionConstants.NONE) {
				Point referencePoint2 = getReferencePoint(lifelinePart, movedOccurrenceSpecification2, yLocation2);
				makeRelativeToLifeline(referencePoint2, lifelinePart, true);
				// Get old bounds information by consulting old figure
				Rectangle esBounds = SequenceUtil.getAbsoluteBounds(executionSpecificationPart);
				Point esLoc = esBounds.getLocation();
				makeRelativeToLifeline(esLoc, lifelinePart, true);
				esBounds.setLocation(esLoc);
				int oldX = esBounds.x;
				int oldY = esBounds.y;
				int oldWidth = esBounds.width;
				int oldHeight = esBounds.height;
				// Compute new bounds of the time element
				int top = oldY;
				int bottom = oldY + oldHeight;
				// bound is based on two events. Recompute it according to moved event(s).
				if(position2 == PositionConstants.TOP) {
					top = referencePoint2.y;
				} else if(position2 == PositionConstants.BOTTOM) {
					bottom = referencePoint2.y;
				}
				// top and bottom may have been inverted during the move.
				newBounds = new Rectangle(oldX, Math.min(top, bottom), oldWidth, Math.abs(bottom - top));
			}
			if(newBounds != null) {
				// adjust bounds for execution specification
				newBounds.height -= heighDelta;
				// return the resize command
				return getChangeBoundsCommand((AbstractExecutionSpecificationEditPart)executionSpecificationPart, newBounds);
			}
		}
		return null;
	}

	/**
	 * Fixed bug about moving Duration Constraint, make sure the child Execution Specifications also be moved.
	 */
	private static Command getChangeBoundsCommand(AbstractExecutionSpecificationEditPart editPart, Rectangle newBounds) {
		Rectangle oldBounds = SequenceUtil.getAbsoluteBounds(editPart);
		Point location = oldBounds.getLocation();
		makeRelativeToLifeline(location, (LifelineEditPart)editPart.getParent(), true);
		oldBounds.setLocation(location);
		Point moveDelta = new Point(newBounds.x - oldBounds.x, newBounds.y - oldBounds.y);
		ChangeBoundsRequest req = new ChangeBoundsRequest();
		req.setMoveDelta(moveDelta);
		req.setEditParts(editPart);
		//Make sure do not coming again to update duration constraints...
		req.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_EDIT_PARTS, true);
		return LifelineXYLayoutEditPolicy.getResizeOrMoveChildrenCommand((LifelineEditPart)editPart.getParent(), req, true, false, true);
	}

	/**
	 * Get the reference point to reconnect or resize edit parts at the given y location
	 * 
	 * @param lifelinePart
	 *        lifeline edit part containing the moved element
	 * @param movedOccurrenceSpecification
	 *        the moving occurrence specification which a reference point is searched for
	 * @param yLocation
	 *        y location
	 * @return reference point on the lifeline
	 */
	private static Point getReferencePoint(LifelineEditPart lifelinePart, OccurrenceSpecification movedOccurrenceSpecification, int yLocation) {
		Point referencePoint = SequenceUtil.findLocationOfEvent(lifelinePart, movedOccurrenceSpecification);
		if(referencePoint == null) {
			referencePoint = lifelinePart.getFigure().getBounds().getCenter().getCopy();
		}
		referencePoint.y = yLocation;
		return referencePoint;
	}

	/**
	 * Chain the commands to move associated parts when a connection end is reconnected.
	 * 
	 * @param command
	 *        existing reconnection command
	 * @param request
	 *        the reconnection request
	 * @param connectableNode
	 *        the node edit part connected to the moved connection
	 * @return the completed command
	 */
	public static Command completeReconnectConnectionCommand(Command command, ReconnectRequest request, INodeEditPart connectableNode) {
		if(chainEffectIsDisabled(request)) {
			return command;
		}
		CompoundCommand globalCmd = new CompoundCommand();
		globalCmd.add(command);
		List<EditPart> notToMoveEditParts = new ArrayList<EditPart>(1);
		notToMoveEditParts.add(request.getConnectionEditPart());
		// move time related elements linked with the event
		LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(connectableNode);
		MessageEnd event = getMessageEndFromReconnectMessage(request);
		if(event instanceof OccurrenceSpecification) {
			Command cmd = getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification)event, null, request.getLocation().y, -1, lifelinePart, notToMoveEditParts);
			if(cmd != null) {
				globalCmd.add(cmd);
			}
		}
		OccurrenceSpecification event2 = getOccurrenceSpecificationFromReconnectGeneralOrdering(request);
		if(event2 instanceof OccurrenceSpecification) {
			Command cmd = getMoveOccurrenceSpecificationsCommand(event2, null, request.getLocation().y, -1, lifelinePart, notToMoveEditParts);
			if(cmd != null) {
				globalCmd.add(cmd);
			}
		}
		return globalCmd;
	}

	/**
	 * Check if moving chain effect has been disabled to avoid an infinite loop.
	 * 
	 * @param request
	 *        the request wich initiated the move
	 * @return true if no additional command must be performed.
	 */
	private static boolean chainEffectIsDisabled(Request request) {
		Object doNotToMoveEditParts = request.getExtendedData().get(SequenceRequestConstant.DO_NOT_MOVE_EDIT_PARTS);
		return Boolean.TRUE.equals(doNotToMoveEditParts);
	}

	/**
	 * Complete a command to move time/duration constraints/observation which are linked to the moved edit part
	 * 
	 * @param compoundCmd
	 *        existing command to complete
	 * @param executionSpecificationEP
	 *        the moved edit part representing an execution specification
	 * @param newBounds
	 *        the new part's bounds (relative to the figure's parent)
	 * @param request
	 *        the change bounds request which originated this move
	 * @return the updated parameter compoundCmd for convenience
	 */
	public static CompoundCommand completeMoveExecutionSpecificationCommand(CompoundCommand compoundCmd, ShapeNodeEditPart executionSpecificationEP, Rectangle newBounds, ChangeBoundsRequest request) {
		if(chainEffectIsDisabled(request)) {
			return compoundCmd;
		}
		// Move events delimiting the ExecutionSpecification
		EObject execSpec = executionSpecificationEP.resolveSemanticElement();
		if(execSpec instanceof ExecutionSpecification) {
			LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(executionSpecificationEP);
			// first, get absolute bounds
			newBounds = newBounds.getCopy();
			IFigure parentFig = executionSpecificationEP.getFigure().getParent();
			parentFig.translateToAbsolute(newBounds);
			newBounds.translate(parentFig.getBounds().getLocation());
			// move start and finish events
			OccurrenceSpecification start = ((ExecutionSpecification)execSpec).getStart();
			int startY = newBounds.getTop().y;
			OccurrenceSpecification finish = ((ExecutionSpecification)execSpec).getFinish();
			int finishY = newBounds.getBottom().y;
			List<EditPart> notToMoveEditParts = new ArrayList<EditPart>(1);
			notToMoveEditParts.add(executionSpecificationEP);
			//Fixed bug for moving ExecutionSpecification, since fixed bug(https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975)
			//The start and finish event may be a MessageOccurrenceSpecification, in case, we need ignore the message when moving.
			if(start instanceof MessageOccurrenceSpecification) {
				EditPart message = SequenceUtil.getLinkedEditPart(lifelinePart, start);
				if(message != null) {
					notToMoveEditParts.add(message);
				}
			}
			if(finish instanceof MessageOccurrenceSpecification) {
				EditPart message = SequenceUtil.getLinkedEditPart(lifelinePart, finish);
				if(message != null) {
					notToMoveEditParts.add(message);
				}
			}
			Command cmd = getMoveOccurrenceSpecificationsCommand(start, finish, startY, finishY, lifelinePart, notToMoveEditParts);
			if(cmd != null) {
				compoundCmd.add(cmd);
			}
			//			if(request.getSizeDelta().height == 0) {
			//				// move time elements for events between start and finish
			//				InteractionFragment nextOccSpec = InteractionFragmentHelper.findNextFragment(start, start.eContainer());
			//				while(nextOccSpec != null && nextOccSpec != finish) {
			//					Point occSpecLocation = SequenceUtil.findLocationOfEvent(lifelinePart, nextOccSpec);
			//					if(nextOccSpec instanceof OccurrenceSpecification && occSpecLocation != null) {
			//						int occSpecY = occSpecLocation.y + request.getMoveDelta().y;
			//						cmd = getMoveTimeElementsCommand((OccurrenceSpecification)nextOccSpec, null, occSpecY, -1, lifelinePart, notToMoveEditParts);
			//						if(cmd != null) {
			//							compoundCmd.add(cmd);
			//						}
			//					}
			//					nextOccSpec = InteractionFragmentHelper.findNextFragment(nextOccSpec, start.eContainer());
			//				}
			//			}
		}
		return compoundCmd;
	}

	/**
	 * Prepare a request which is supposed to move a time/duration constraints/observation edit part.
	 * The request will be updated if some operations are forbidden.
	 * 
	 * @param request
	 *        the move request
	 * @param movedTimePart
	 *        the moved time/duration constraints/observation edit part.
	 */
	public static void prepareTimeRelatedElementMoveRequest(ChangeBoundsRequest request, IBorderItemEditPart movedTimePart) {
		// Erase the y move if element can not be moved on y axe
		if(!canTimeElementPartBeYMoved(movedTimePart)) {
			request.getMoveDelta().y = 0;
		} else {
			//move to one direction at once.
			Point moveDelta = request.getMoveDelta();
			if(Math.abs(moveDelta.x) > Math.abs(moveDelta.y)) {
				moveDelta.y = 0;
			} else {
				moveDelta.x = 0;
			}
		}
	}

	/**
	 * Complete the command to move an edit part representing a time/duration constraints/observation.
	 * 
	 * @param moveCommand
	 *        the move command to complete with chaining
	 * @param request
	 *        the request which initiated the move
	 * @param hostFigure
	 *        figure which is being moved
	 * @param hostEditPart
	 *        edit part which is being moved
	 * @return the complete command.
	 */
	public static Command completeMoveTimeRelatedElementCommand(Command moveCommand, ChangeBoundsRequest request, EditPart hostEditPart, IFigure hostFigure) {
		if(chainEffectIsDisabled(request)) {
			return moveCommand;
		}
		Rectangle bounds = request.getTransformedRectangle(hostFigure.getBounds());
		hostFigure.getParent().translateToAbsolute(bounds);
		LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(hostEditPart);
		if(lifelinePart != null && hostEditPart instanceof IBorderItemEditPart) {
			IBorderItemEditPart timeElementEditPart = (IBorderItemEditPart)hostEditPart;
			EObject timeElement = timeElementEditPart.resolveSemanticElement();
			OccurrenceSpecification occSpec1 = null;
			int yLocation1 = -1;
			OccurrenceSpecification occSpec2 = null;
			int yLocation2 = -1;
			// find occurrence specifications of the time element
			if(timeElement instanceof TimeConstraint) {
				Iterator<Element> it = ((TimeConstraint)timeElement).getConstrainedElements().iterator();
				while(it.hasNext() && occSpec1 == null) {
					Element elem = it.next();
					if(elem instanceof OccurrenceSpecification) {
						int position1 = whereEventIsLinked((OccurrenceSpecification)elem, timeElementEditPart);
						if(position1 != PositionConstants.NONE) {
							occSpec1 = (OccurrenceSpecification)elem;
							yLocation1 = getLocation(bounds, position1).y;
						}
					}
				}
			} else if(timeElement instanceof TimeObservation) {
				NamedElement event = ((TimeObservation)timeElement).getEvent();
				if(event instanceof OccurrenceSpecification) {
					int position1 = whereEventIsLinked((OccurrenceSpecification)event, timeElementEditPart);
					if(position1 != PositionConstants.NONE) {
						occSpec1 = (OccurrenceSpecification)event;
						yLocation1 = getLocation(bounds, position1).y;
					}
				}
			} else if(timeElement instanceof DurationConstraint) {
				Iterator<Element> it = ((DurationConstraint)timeElement).getConstrainedElements().iterator();
				while(it.hasNext() && (occSpec1 == null || occSpec2 == null)) {
					Element elem = it.next();
					if(elem instanceof OccurrenceSpecification && occSpec1 != null) {
						int position2 = whereEventIsLinked((OccurrenceSpecification)elem, timeElementEditPart);
						if(position2 != PositionConstants.NONE) {
							occSpec2 = (OccurrenceSpecification)elem;
							yLocation2 = getLocation(bounds, position2).y;
						}
					} else if(elem instanceof OccurrenceSpecification) {
						int position1 = whereEventIsLinked((OccurrenceSpecification)elem, timeElementEditPart);
						if(position1 != PositionConstants.NONE) {
							occSpec1 = (OccurrenceSpecification)elem;
							yLocation1 = getLocation(bounds, position1).y;
						}
					}
				}
			}
			if(occSpec1 != null) {
				List<EditPart> notToMoveEditParts = Collections.singletonList(hostEditPart);
				Command cmd = getMoveOccurrenceSpecificationsCommand(occSpec1, occSpec2, yLocation1, yLocation2, lifelinePart, notToMoveEditParts);
				if(cmd != null) {
					return moveCommand.chain(cmd);
				}
			}
		}
		return null;
	}

	/**
	 * Make the request to reconnect the connection
	 * 
	 * @param connection
	 *        connection part
	 * @param isSource
	 *        true if the source must be reconnect, false for target
	 * @param location
	 *        the location where to reconnect
	 * @param partToReconnectTo
	 *        the part which the connection must be reconnected to (or null if unknown or of no importance)
	 * @return the reconnection request
	 */
	@SuppressWarnings("unchecked")
	private static ReconnectRequest makeReconnectRequest(ConnectionEditPart connection, boolean isSource, Point location, EditPart partToReconnectTo) {
		// Obtain the target edit part
		EditPart targetEP = partToReconnectTo;
		String type;
		if(isSource) {
			type = RequestConstants.REQ_RECONNECT_SOURCE;
			if(targetEP == null) {
				targetEP = connection.getSource();
			}
		} else {
			type = RequestConstants.REQ_RECONNECT_TARGET;
			if(targetEP == null) {
				targetEP = connection.getTarget();
			}
		}
		// Create and set the properties of the request
		ReconnectRequest reconnReq = new ReconnectRequest();
		reconnReq.setConnectionEditPart(connection);
		reconnReq.setLocation(location);
		reconnReq.setTargetEditPart(targetEP);
		reconnReq.setType(type);
		// add a parameter to bypass the move impact to avoid infinite loop
		reconnReq.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_EDIT_PARTS, true);
		// Return the request
		return reconnReq;
	}

	/**
	 * Get the location on the bounds
	 * 
	 * @param bounds
	 *        the rectangle bounds
	 * @param position
	 *        one of {@link PositionConstants#TOP}, {@link PositionConstants#CENTER}, {@link PositionConstants#BOTTOM}
	 * @return the point at the given position or null if position is incorrect
	 */
	private static Point getLocation(Rectangle bounds, int position) {
		if(position == PositionConstants.TOP) {
			return bounds.getTop();
		} else if(position == PositionConstants.CENTER) {
			return bounds.getCenter();
		} else if(position == PositionConstants.BOTTOM) {
			return bounds.getBottom();
		}
		return null;
	}

	/**
	 * The position of the host where the event is linked
	 * 
	 * @param event
	 *        the occurrence specification
	 * @param hostEditPart
	 *        the host edit part which is linked to the occurrence specification
	 * @return one of {@link PositionConstants#TOP}, {@link PositionConstants#CENTER}, {@link PositionConstants#BOTTOM},
	 *         {@link PositionConstants#NONE}
	 */
	private static int whereEventIsLinked(OccurrenceSpecification event, EditPart hostEditPart) {
		if(hostEditPart instanceof IBorderItemEditPart) {
			return SequenceUtil.positionWhereEventIsLinkedToPart(event, (IBorderItemEditPart)hostEditPart);
		}
		return PositionConstants.NONE;
	}

	/**
	 * Get the occurrence specification which correspond to the moved general ordering end
	 * 
	 * @param request
	 *        the general odering reconnection request
	 * @return moved OccurrenceSpecification or null
	 */
	private static OccurrenceSpecification getOccurrenceSpecificationFromReconnectGeneralOrdering(ReconnectRequest request) {
		if(request.getConnectionEditPart() instanceof ConnectionEditPart) {
			EObject generalOrdering = ((ConnectionEditPart)request.getConnectionEditPart()).resolveSemanticElement();
			if(generalOrdering instanceof GeneralOrdering) {
				if(RequestConstants.REQ_RECONNECT_SOURCE.equals(request.getType())) {
					return ((GeneralOrdering)generalOrdering).getBefore();
				} else if(RequestConstants.REQ_RECONNECT_TARGET.equals(request.getType())) {
					return ((GeneralOrdering)generalOrdering).getAfter();
				}
			}
		}
		return null;
	}

	/**
	 * Get the message end which correspond to the moved message end
	 * 
	 * @param request
	 *        the message reconnection request
	 * @return moved MessageEnd or null
	 */
	private static MessageEnd getMessageEndFromReconnectMessage(ReconnectRequest request) {
		if(request.getConnectionEditPart() instanceof ConnectionEditPart) {
			EObject message = ((ConnectionEditPart)request.getConnectionEditPart()).resolveSemanticElement();
			if(message instanceof Message) {
				if(RequestConstants.REQ_RECONNECT_SOURCE.equals(request.getType())) {
					return ((Message)message).getSendEvent();
				} else if(RequestConstants.REQ_RECONNECT_TARGET.equals(request.getType())) {
					return ((Message)message).getReceiveEvent();
				}
			}
		}
		return null;
	}

	/**
	 * Know whether this time element part can be moved within the lifeline or not.
	 * Parts linked with a destruction event can not be moved since the destruction event is always at the end.
	 * 
	 * @param timeElementPart
	 *        the part representing a time/duration constraint/observation
	 * @return true if the part can be moved
	 */
	public static boolean canTimeElementPartBeYMoved(IBorderItemEditPart timeElementPart) {
		EObject timeElement = timeElementPart.resolveSemanticElement();
		List<? extends Element> occurrences = Collections.emptyList();
		if(timeElement instanceof TimeObservation) {
			NamedElement occurence = ((TimeObservation)timeElement).getEvent();
			occurrences = Collections.singletonList(occurence);
		} else if(timeElement instanceof TimeConstraint || timeElement instanceof DurationConstraint) {
			occurrences = ((IntervalConstraint)timeElement).getConstrainedElements();
		}
		// check whether one of the time occurrences correspond to a DestructionEvent
		for(Element occurrence : occurrences) {
			if(occurrence instanceof DestructionOccurrenceSpecification) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get a command which refreshes the bordered layout of the node.
	 * 
	 * @param node
	 *        the node figure with bordered items (including time-related parts)
	 * @param onUndo
	 *        if true the relayout will be done on undo only, if false it will be done on classic execute only
	 * @return the refresh command
	 */
	private static Command getReLayoutCmd(BorderedNodeFigure node, boolean onUndo) {
		// relayout the border container figure so that time elements are refreshed
		final IFigure container = node.getBorderItemContainer();
		if(onUndo) {
			return new Command() {

				@Override
				public void undo() {
					container.getLayoutManager().layout(container);
				}
			};
		} else {
			return new Command() {

				@Override
				public void execute() {
					container.getLayoutManager().layout(container);
				}
			};
		}
	}
}
