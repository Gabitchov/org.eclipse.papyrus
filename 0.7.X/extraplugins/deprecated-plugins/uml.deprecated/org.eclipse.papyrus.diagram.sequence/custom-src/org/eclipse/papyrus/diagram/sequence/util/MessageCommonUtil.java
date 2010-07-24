/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Initial API implementation
 * 				 Javier Muñoz (Prodevelop) - Messages are updated when properties changes
 * 				 Franciso Javier Cano Muñoz (Prodevelop) - New operations added
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.ValueSpecification;

import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;

public class MessageCommonUtil {

	/**
	 * Returns the source Element (a BES or a Lifeline) of a Message.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return The source Element
	 */
	public static Element getMessageSrc(Message msg) {
		if (msg.getSendEvent() != null
				&& msg.getSendEvent() instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mos = (MessageOccurrenceSpecification) msg
					.getSendEvent();

			if (mos.getCovereds().size() > 0) {
				Element element = mos.getCovereds().get(0);

				// element should always be an instance of Lifeline
				if (element instanceof Lifeline) {
					// Check if the message source is connected to the Lifeline
					// or to one of its owned BehaviorExecutionSpecifications
					Lifeline lifeline = (Lifeline) element;

					// Get the BES's from the lifeline
					EList<BehaviorExecutionSpecification> besList = getLifelineBESList(lifeline);

					// Fore each BES, check if it is contained within its
					// start/finish boundaries
					for (BehaviorExecutionSpecification bes : besList) {
						// A MOS might be contained within the boundaries of
						// more than one BE (remember that BES can contained
						// sub-BES)
						BehaviorExecutionSpecification mostToRightBes = null;
						if (isOSinBES(mos, bes)) {
							// We want the most-to-right BES
							if (mostToRightBes == null
									|| MessageOrderCommand.isOS1AfterOS2(bes
											.getStart(), mostToRightBes
											.getStart()))
								mostToRightBes = bes;
						}
						element = mostToRightBes != null ? mostToRightBes
								: element;
					}
				}

				return element;
			}
		}
		return null;
	}

	/**
	 * Returns the destination Element (a BES or a Lifeline) of a Message.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return The destination Element
	 */
	public static Element getMessageDst(Message msg) {
		if (msg.getReceiveEvent() != null
				&& msg.getReceiveEvent() instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mos = (MessageOccurrenceSpecification) msg
					.getReceiveEvent();

			if (mos.getCovereds().size() > 0) {
				Element element = mos.getCovereds().get(0);

				// element should always be an instance of Lifeline
				if (element instanceof Lifeline) {
					// Check if the message target is connected to the Lifeline
					// or to one of its owned BehaviorExecutionSpecifications
					Lifeline lifeline = (Lifeline) element;

					// Get the BES's from the lifeline
					EList<BehaviorExecutionSpecification> besList = getLifelineBESList(lifeline);

					// Fore each BES, check if it is the source of the msg
					for (BehaviorExecutionSpecification bes : besList) {
						// A MOS might be contained within the boundaries of
						// more than one BE (remember that BES can contained
						// sub-BES)
						BehaviorExecutionSpecification mostToRightBes = null;
						if (isOSinBES(mos, bes)) {
							// We want the most-to-right BES
							if (mostToRightBes == null
									|| MessageOrderCommand.isOS1AfterOS2(bes
											.getStart(), mostToRightBes
											.getStart()))
								mostToRightBes = bes;
						}
						element = mostToRightBes != null ? mostToRightBes
								: element;
					}
				}

				return element;
			}
		}
		return null;
	}

	/**
	 * Returns the destination Lifeline of a Message.
	 * 
	 * @param message
	 * @return
	 */
	public static Lifeline getMessageSrcLifeline(Message message) {
		if (message == null) {
			return null;
		}
		Element source = MessageCommonUtil.getMessageSrc(message);
		if (source instanceof BehaviorExecutionSpecification) {
			if (((BehaviorExecutionSpecification) source).getCovereds().size() > 0
					&& ((BehaviorExecutionSpecification) source).getCovereds()
							.get(0) instanceof Lifeline) {
				source = ((BehaviorExecutionSpecification) source)
						.getCovereds().get(0);
			}
		}
		if (source instanceof Lifeline) {
			return (Lifeline) source;
		}
		return null;
	}

	/**
	 * Returns the destination Lifeline of a Message.
	 * 
	 * @param message
	 * @return
	 */
	public static Lifeline getMessageDstLifeline(Message message) {
		if (message == null) {
			return null;
		}
		Element target = MessageCommonUtil.getMessageDst(message);
		if (target instanceof BehaviorExecutionSpecification) {
			if (((BehaviorExecutionSpecification) target).getCovereds().size() > 0
					&& ((BehaviorExecutionSpecification) target).getCovereds()
							.get(0) instanceof Lifeline) {
				target = ((BehaviorExecutionSpecification) target)
						.getCovereds().get(0);
			}
		}
		if (target instanceof Lifeline) {
			return (Lifeline) target;
		}
		return null;
	}

	/**
	 * Returns a list with the BESs drawn within a Lifeline (It is important to
	 * mention that a BES is physically contained in a Interaction but drawn in
	 * a Lifeline)
	 * 
	 * @author Gabriel Merin
	 * @param lifeline
	 * @return an EList with the BES
	 */
	public static EList<BehaviorExecutionSpecification> getLifelineBESList(
			Lifeline lifeline) {
		EList<BehaviorExecutionSpecification> besList = new BasicEList<BehaviorExecutionSpecification>();

		// Get the Interaction where the Lifeline is contained.
		Interaction interaction = lifeline.getInteraction();

		if (interaction == null)
			return besList;

		// Get all the BES contained in the Interaction. Only store those
		// coveredBy the lifeline.
		for (Iterator i = interaction.getFragments().iterator(); i.hasNext();) {
			InteractionFragment fragment = (InteractionFragment) i.next();
			if (fragment instanceof BehaviorExecutionSpecification) {
				BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) fragment;
				if (bes.getCovereds().size() > 0
						&& bes.getCovereds().get(0) == lifeline) {
					besList.add((BehaviorExecutionSpecification) fragment);
				}
			}

		}

		// Return the besList
		return besList;
	}

	/**
	 * Returns true if an OS is contained between the BES.start and BES.finish
	 * Occurrence Specifications. It is important to take into account that the
	 * passed OS might be within the start/finish properties of a Sub-BES.
	 * 
	 * @author Gabriel Merin
	 * @param os
	 * @param bes
	 * @return true if the OS intersects, false otherwise
	 */
	public static boolean isOSinBES(OccurrenceSpecification os,
			BehaviorExecutionSpecification bes) {
		if (bes.getStart() == os || bes.getFinish() == os) {
			return true;
		}

		if (bes.getStart() == null || bes.getFinish() == null) {
			return false;
		}

		if (MessageOrderCommand.isOS1AfterOS2(os, bes.getStart())
				&& MessageOrderCommand.isOS1BeforeOS2(os, bes.getFinish())) {
			return true;
		}

		// In other case
		return false;
	}

	/**
	 * Checks if one of the end points is already occupied with another
	 * connection figure. NOTE: This is used to avoid the creation of two links
	 * with the same end points.
	 * 
	 * @author Gabriel Merin
	 * @param request
	 * @return true if connection
	 */
	public static boolean checkFreeConnectionEnds(Request request) {

		if (request instanceof CreateConnectionViewAndElementRequest) {

			CreateConnectionViewAndElementRequest createRequest = (CreateConnectionViewAndElementRequest) request;

			ShapeNodeEditPart sourceEP, targetEP;
			ConnectionAnchor sourceAnchor, targetAnchor;
			Point targetRefLocation, sourceRefLocation;
			Point targetLocation, sourceLocation;

			sourceEP = (ShapeNodeEditPart) createRequest.getSourceEditPart();
			targetEP = (ShapeNodeEditPart) createRequest.getTargetEditPart();

			// Source and Target should not be anchored at the same EditPart
			// either
			if (sourceEP == targetEP)
				return false;

			ICommandProxy icp = (ICommandProxy) createRequest.getStartCommand();

			CompositeCommand cc = ((CompositeCommand) icp.getICommand());
			Iterator iterator = cc.iterator();
			// 0: (nothing interesting)
			iterator.next();
			// 1: SetConnectionEndsCommand
			iterator.next();
			// 2: SetConnectionAnchorsCommand
			iterator.next();
			// 3: SetConnectionBendpointsCommand
			SetConnectionBendpointsCommand scbp = (SetConnectionBendpointsCommand) iterator
					.next();

			sourceRefLocation = scbp.getSourceRefPoint();
			targetRefLocation = scbp.getTargetRefPoint();

			sourceAnchor = ((NodeFigure) sourceEP.getFigure())
					.getSourceConnectionAnchorAt(sourceRefLocation);
			targetAnchor = targetEP.getTargetConnectionAnchor(createRequest);

			targetLocation = targetAnchor.getLocation(sourceAnchor
					.getLocation(sourceRefLocation));

			sourceLocation = sourceAnchor.getLocation(targetAnchor
					.getLocation(targetRefLocation));

			// Source and Target should not be anchored at the same point
			if (sourceLocation.x == targetLocation.x
					&& sourceLocation.y == targetLocation.y)
				return false;

			if (checkFreeEnd(sourceEP, sourceLocation)
					&& checkFreeEnd(targetEP, targetLocation)) {
				return true;
			} else {
				return false;
			}

		}

		if (request instanceof ReconnectRequest
				&& ((ReconnectRequest) request).getTarget() instanceof ShapeNodeEditPart) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;

			ShapeNodeEditPart sourceEP;
			ShapeNodeEditPart targetEP;
			ShapeNodeEditPart endEP;

			ConnectionAnchor sourceAnchor;
			ConnectionAnchor targetAnchor;

			Point endLocation;

			sourceEP = (ShapeNodeEditPart) reconnectRequest
					.getConnectionEditPart().getSource();
			targetEP = (ShapeNodeEditPart) reconnectRequest
					.getConnectionEditPart().getTarget();

			if (reconnectRequest.isMovingStartAnchor()) {
				// Update the corresponding EditPart
				sourceEP = (ShapeNodeEditPart) reconnectRequest.getTarget();

				sourceAnchor = sourceEP
						.getSourceConnectionAnchor(reconnectRequest);
				targetAnchor = targetEP
						.getTargetConnectionAnchor(reconnectRequest
								.getConnectionEditPart());
				endLocation = sourceAnchor.getLocation(
						targetAnchor.getReferencePoint()).getCopy();
				endEP = sourceEP;
			} else {
				// Update the corresponding EditPart
				targetEP = (ShapeNodeEditPart) reconnectRequest.getTarget();

				sourceAnchor = sourceEP
						.getSourceConnectionAnchor(reconnectRequest
								.getConnectionEditPart());
				targetAnchor = targetEP
						.getTargetConnectionAnchor(reconnectRequest);
				endLocation = targetAnchor.getLocation(
						sourceAnchor.getReferencePoint()).getCopy();
				endEP = targetEP;
			}

			// Source and Target should not be anchored at the same EditPart
			// either
			if (sourceEP == targetEP)
				return false;

			if (checkFreeEnd(endEP, endLocation, reconnectRequest
					.getConnectionEditPart())) {
				return true;
			} else {
				return false;
			}

		}

		return false;
	}

	/**
	 * Checks if a Point is already occupied by an existing connection end.
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param endLocation
	 * @return true if the passed point is free, false otherwise
	 */
	public static boolean checkFreeEnd(ShapeNodeEditPart shapeEP,
			Point endLocation) {
		return checkFreeEnd(shapeEP, endLocation, null);
	}

	/**
	 * Checks if a Point is already occupied by an existing connection end. A
	 * connection EditPart can be passed in order to avoid the checking of that
	 * connection.
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param endLocation
	 * @param connection
	 *            EditPart to avoid checking
	 * @return true if the passed point is free, false otherwise
	 */
	public static boolean checkFreeEnd(ShapeNodeEditPart shapeEP,
			Point endLocation, ConnectionEditPart connEPToAvoid) {
		List<EditPart> sourceConnections = new BasicEList<EditPart>();
		sourceConnections.addAll(shapeEP.getSourceConnections());

		// Remove from the list the connection EditPart to avoid
		if (connEPToAvoid != null) {
			sourceConnections.remove(connEPToAvoid);
		}

		// Discard connections whose semantic element is different from Message
		removeNonMessageConnections(sourceConnections);

		for (Iterator i = sourceConnections.iterator(); i.hasNext();) {
			ConnectionEditPart linkEP = (ConnectionEditPart) i.next();

			Point existingLocation;

			ShapeNodeEditPart sourceEP = shapeEP;
			ShapeNodeEditPart targetEP = (ShapeNodeEditPart) linkEP.getTarget();

			ConnectionAnchor sourceAnchor = sourceEP
					.getSourceConnectionAnchor(linkEP);
			ConnectionAnchor targetAnchor = targetEP
					.getTargetConnectionAnchor(linkEP);

			existingLocation = sourceAnchor.getLocation(targetAnchor
					.getReferencePoint());

			if (endLocation.y == existingLocation.y) {
				return false;
			}
		}

		List<EditPart> targetConnections = new BasicEList<EditPart>();
		targetConnections.addAll(shapeEP.getTargetConnections());

		// Remove from the list the connection EditPart to avoid
		if (connEPToAvoid != null) {
			targetConnections.remove(connEPToAvoid);
		}

		// Discard connections whose semantic element is different from Message
		removeNonMessageConnections(targetConnections);

		for (Iterator i = targetConnections.iterator(); i.hasNext();) {
			ConnectionEditPart linkEP = (ConnectionEditPart) i.next();

			Point existingLocation;

			ShapeNodeEditPart sourceEP = (ShapeNodeEditPart) linkEP.getSource();
			ShapeNodeEditPart targetEP = shapeEP;

			ConnectionAnchor targetAnchor = targetEP
					.getTargetConnectionAnchor(linkEP);
			ConnectionAnchor sourceAnchor = sourceEP
					.getSourceConnectionAnchor(linkEP);

			existingLocation = targetAnchor.getLocation(sourceAnchor
					.getReferencePoint());

			if (endLocation.y == existingLocation.y) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the Operation from the Send Operation Event of the Message.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return the Operation if exists, null otherwise
	 */
	public static Operation getMessageSendOperation(Message msg) {
		return getMessageOperation(msg, true);
	}

	/**
	 * Returns the Operation from the Receive Operation Event of the Message.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return the Operation if exists, null otherwise
	 */
	public static Operation getMessageReceiveOperation(Message msg) {
		return getMessageOperation(msg, false);
	}

	/**
	 * Used by '{@link #getMessageSendOperation()
	 * <em>Message Send Operation</em>}' and '
	 * {@link #getMessageReceiveOperation() <em>Message Receive Operation</em>}'
	 * to obtain the operation from the Send/Receive Operation Event.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @param getSendOp
	 * @return the Operation if exists, null otherwise
	 */
	public static Operation getMessageOperation(Message msg, Boolean getSendOp) {
		MessageEnd msgEnd;

		if (getSendOp) {
			msgEnd = msg.getSendEvent();
		} else {
			msgEnd = msg.getReceiveEvent();
		}

		if (msgEnd instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mosEnd = (MessageOccurrenceSpecification) msgEnd;
			Event event = mosEnd.getEvent();

			if (event instanceof SendOperationEvent) {
				return ((SendOperationEvent) event).getOperation();
			}

			if (event instanceof ReceiveOperationEvent) {
				return ((ReceiveOperationEvent) event).getOperation();
			}

			if (event instanceof CallEvent) {
				return ((CallEvent) event).getOperation();
			}

		}
		return null;
	}

	/**
	 * Returns the sent Event of a Message.
	 * 
	 * @param msg
	 * @return The Event if exists
	 */
	public static Event getMessageSendEvent(Message msg) {
		return getMessageEvent(msg, true);
	}

	/**
	 * Returns the received Event of a Message
	 * 
	 * @param msg
	 * @return
	 */
	public static Event getMessageReceiveEvent(Message msg) {
		return getMessageEvent(msg, false);
	}

	/**
	 * Used by '{@link #getMessageSendEvent() <em>Message Send Event</em>}' and
	 * '{@link #getMessageReceiveEvent() <em>Message Receive Event</em>}'. It
	 * returns the sent/received Event of a Message.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @param getSendOp
	 * @return the Sent/Received Event if exists, null otherwise
	 */
	public static Event getMessageEvent(Message msg, Boolean getSendOp) {
		MessageEnd msgEnd;

		if (getSendOp) {
			msgEnd = msg.getSendEvent();
		} else {
			msgEnd = msg.getReceiveEvent();
		}

		if (msgEnd instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mosEnd = (MessageOccurrenceSpecification) msgEnd;
			return mosEnd.getEvent();

		}
		return null;
	}

	/**
	 * Given a Message and an Operation, it returns a String representing the
	 * Operation appropriately.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @param op
	 * @return a String representing the Operation
	 */
	public static String getMessageOperationString(Message msg, Operation op) {
		String returnString;

		// Name of the operation
		returnString = op.getName();

		returnString += "(";

		// The value of the parameters is in the message itself
		for (Iterator<ValueSpecification> i = msg.getArguments().iterator(); i
				.hasNext();) {
			ValueSpecification value = i.next();

			if (value.getName() != null
					&& value.getName().compareTo("return") == 0) {
				continue;
			}

			if (value instanceof LiteralString) {
				LiteralString lString = ((LiteralString) value);
				returnString += "\"";
				if (lString.isSetValue()) {
					returnString += lString.getValue();
				}
				returnString += "\"";
			} else if (value instanceof LiteralBoolean) {
				returnString += ((LiteralBoolean) value).stringValue();
			} else if (value instanceof LiteralInteger) {
				returnString += ((LiteralInteger) value).getValue();
			} else if (value instanceof InstanceValue) {
				if (((InstanceValue) value).getInstance() != null)
					returnString += ((InstanceValue) value).getInstance()
							.getName();
				else
					returnString += "null";
			} else {
				returnString += "?";
			}

			// if there are more elements, add a comma
			if (i.hasNext())
				returnString += ", ";
		}

		returnString += ")";

		return returnString;
	}

	/**
	 * Obtains the Message EditPart associated with the Start property of the
	 * BES.
	 * 
	 * @author Gabriel Merin
	 * @param besEP
	 * @return returns the ConnectionNodeEditPart that represents the
	 *         MessageEditPart. If no connection is not found, null is returned.
	 */
	public static ConnectionNodeEditPart getBESStartMessageEditPart(
			BehaviorExecutionSpecificationEditPart besEP) {
		BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) besEP
				.resolveSemanticElement();
		return getMessageEditPart(bes.getStart(), besEP);
	}

	/**
	 * Obtains the Message EditPart associated with the Finish property of the
	 * BES.
	 * 
	 * @author Gabriel Merin
	 * @param besEP
	 * @return returns the ConnectionNodeEditPart that represents the
	 *         MessageEditPart. If no connection is not found, null is returned.
	 */
	public static ConnectionNodeEditPart getBESFinishMessageEditPart(
			BehaviorExecutionSpecificationEditPart besEP) {
		BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) besEP
				.resolveSemanticElement();
		return getMessageEditPart(bes.getFinish(), besEP);
	}

	/**
	 * Used by '{@link #getBESStartMessageEditPart()
	 * <em>BES Start Message Edit Part</em>}' and '
	 * {@link #getBESFinishMessageEditPart()
	 * <em>BES Finish Message Edit Part</em>}' It returns the Message EditPart
	 * associated with an OS.
	 * 
	 * @author Gabriel Merin
	 * @param os
	 * @param besEP
	 * @return returns the ConnectionNodeEditPart that represents the
	 *         MessageEditPart. If no connection is found, null is returned.
	 */
	public static ConnectionNodeEditPart getMessageEditPart(
			OccurrenceSpecification os,
			BehaviorExecutionSpecificationEditPart besEP) {

		// Loop through source connections
		List sourceList = besEP.getSourceConnections();
		for (Iterator i = sourceList.iterator(); i.hasNext();) {
			ConnectionNodeEditPart conn = (ConnectionNodeEditPart) i.next();
			if (conn.resolveSemanticElement() instanceof Message) {
				Message msg = (Message) conn.resolveSemanticElement();
				if (msg.getSendEvent() == os)
					return conn;
			} else
				continue;
		}

		// Loop through target connections
		List targetList = besEP.getTargetConnections();
		for (Iterator i = targetList.iterator(); i.hasNext();) {
			ConnectionNodeEditPart conn = (ConnectionNodeEditPart) i.next();
			if (conn.resolveSemanticElement() instanceof Message) {
				Message msg = (Message) conn.resolveSemanticElement();
				if (msg.getReceiveEvent() == os)
					return conn;
			}
		}

		// If no connection edit part found, return null
		return null;
	}

	/**
	 * Returns the intersection point between a Shape Node EditPart and the
	 * source of a Connection EditPart. Used by '
	 * {@link #getMessageEndIntersectionPoint()
	 * <em>Message End Intersection Point</em>}'.
	 * 
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param connEP
	 * @return the intersection Point
	 */
	public static Point getSourceIntersectionPoint(ShapeNodeEditPart shapeEP,
			ConnectionNodeEditPart connEP) {
		return getIntersectionPoint(shapeEP, connEP, true);
	}

	/**
	 * Returns the intersection point between a Shape Node EditPart and the
	 * target of a Connection EditPart. Used by '
	 * {@link #getMessageEndIntersectionPoint()
	 * <em>Message End Intersection Point</em>}'.
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param connEP
	 * @return the intersection Point
	 */
	public static Point getTargetIntersectionPoint(ShapeNodeEditPart shapeEP,
			ConnectionNodeEditPart connEP) {
		return getIntersectionPoint(shapeEP, connEP, false);
	}

	/**
	 * Used by '{@link #getSourceIntersectionPoint()
	 * <em>Source Intersection Point</em>}' and '
	 * {@link #getTargetIntersectionPoint() <em>Target Intersection Point</em>}
	 * '. It returns the intersection point between a Shape Node EditPart and
	 * the source/target of a Connection EditPart (depends on the source value)
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param connEP
	 * @param source
	 * @return the intersection Point
	 */
	public static Point getIntersectionPoint(ShapeNodeEditPart shapeEP,
			ConnectionNodeEditPart connEP, boolean source) {
		Point p;
		ConnectionAnchor cAnchor;

		if (source == true && shapeEP.getSourceConnections().contains(connEP)) {
			cAnchor = shapeEP.getSourceConnectionAnchor(connEP);
			p = cAnchor.getReferencePoint().getCopy();
			return p;
		}

		if (source == false && shapeEP.getTargetConnections().contains(connEP)) {
			cAnchor = shapeEP.getSourceConnectionAnchor(connEP);
			p = cAnchor.getReferencePoint().getCopy();
			return p;
		}

		// If the connEP was not within shapeEP connections then return null
		return null;
	}

	/**
	 * Returns the intersection point between a Shape Node EditPart and the end
	 * of a Connection EditPart indicated by the OS.
	 * 
	 * @author Gabriel Merin
	 * @param shapeEP
	 * @param connEP
	 * @param os
	 * @return the intersection Point
	 */
	public static Point getMessageEndIntersectionPoint(
			ShapeNodeEditPart shapeEP, ConnectionNodeEditPart connEP,
			OccurrenceSpecification os) {
		Message msg = (Message) connEP.resolveSemanticElement();
		if (msg.getSendEvent() == os)
			return getSourceIntersectionPoint(shapeEP, connEP);
		if (msg.getReceiveEvent() == os)
			return getTargetIntersectionPoint(shapeEP, connEP);

		return null;
	}

	/**
	 * Checks if the semantic hint (a VISUAL_ID string) matches any of the
	 * MessageEditPart's VISUAL_ID.
	 * 
	 * @author Gabriel Merin
	 * @param semanticHint
	 * @return true if the there is a match among any of VISUAL_IDs from the
	 *         Message EditParts.
	 */
	public static boolean isMessageEditPart(String semanticHint) {

		switch (Integer.valueOf(semanticHint)) {
		case MessageEditPart.VISUAL_ID:
			return true;
		case Message2EditPart.VISUAL_ID:
			return true;
		case Message3EditPart.VISUAL_ID:
			return true;
		case Message4EditPart.VISUAL_ID:
			return true;
		case Message5EditPart.VISUAL_ID:
			return true;
		case Message6EditPart.VISUAL_ID:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Checks if the connectionEP given as a parameter is instance of any of the
	 * Message EditParts
	 * 
	 * @author Gabriel Merin
	 * @param connectionEP
	 * @return true in case the connectionEP is instance of any of the Message
	 *         EditParts, false otherwise.
	 */
	public static boolean isMessageEditPart(ConnectionEditPart connectionEP) {
		if (connectionEP instanceof MessageEditPart)
			return true;
		if (connectionEP instanceof Message2EditPart)
			return true;
		if (connectionEP instanceof Message3EditPart)
			return true;
		if (connectionEP instanceof Message4EditPart)
			return true;
		if (connectionEP instanceof Message5EditPart)
			return true;
		if (connectionEP instanceof Message6EditPart)
			return true;

		return false;
	}

	/**
	 * Removes from a EditPart List all the elements that are not instances of
	 * ConnectionNodeEditPart and whose semantic element is different from
	 * Message
	 * 
	 * @author Gabriel Merin
	 * @param epList
	 */
	public static void removeNonMessageConnections(List<EditPart> epList) {
		List<EditPart> messageList = new BasicEList<EditPart>();
		for (Iterator<EditPart> i = epList.iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof ConnectionNodeEditPart) {
				if (((ConnectionNodeEditPart) obj).resolveSemanticElement() instanceof Message) {
					messageList.add((EditPart) obj);
				}
			}
		}
		epList.retainAll(messageList);
	}

	/**
	 * It returns the casting of msg.getSendEvent() to
	 * MessageOccurrenceSpecification if possible, otherwise it returns null.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return The source MessageOccurrenceSpecification of the given message
	 */
	public static MessageOccurrenceSpecification getMessageSrcMOS(Message msg) {
		return getMessageMOS(msg, true);
	}

	/**
	 * It returns the casting of msg.getReceiveEvent() to
	 * MessageOccurrenceSpecification if possible, otherwise it returns null.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @return The target MessageOccurrenceSpecification of the given message
	 */
	public static MessageOccurrenceSpecification getMessageDstMOS(Message msg) {
		return getMessageMOS(msg, false);
	}

	/**
	 * It returns the casting of msg.getSendEvent() (source=true) or
	 * msg.getReceiveEvent() (source=false) to MessageOccurrenceSpecification if
	 * possible, otherwise it returns null.
	 * 
	 * @author Gabriel Merin
	 * @param msg
	 * @param source
	 * @return The source or target MessageOccurrenceSpecification
	 */
	private static MessageOccurrenceSpecification getMessageMOS(Message msg,
			boolean source) {
		MessageEnd msgEnd;
		if (source) {
			msgEnd = msg.getSendEvent();
		} else {
			msgEnd = msg.getReceiveEvent();
		}
		if (msgEnd instanceof MessageOccurrenceSpecification)
			return (MessageOccurrenceSpecification) msgEnd;
		else
			return null;
	}

}
