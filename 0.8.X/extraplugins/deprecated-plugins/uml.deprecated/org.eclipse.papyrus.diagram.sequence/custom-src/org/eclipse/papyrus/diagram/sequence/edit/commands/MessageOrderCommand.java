/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.util.MessageCommonUtil;

public class MessageOrderCommand extends Command {

	// To store the command List
	// Put the command
	private List<org.eclipse.emf.common.command.Command> commandList = new ArrayList<org.eclipse.emf.common.command.Command>();

	private ShapeNodeEditPart sourceEditPart = null;
	private ShapeNodeEditPart targetEditPart = null;

	private ConnectionViewAndElementDescriptor connectionViewElemDes = null;

	private DestroyElementRequest destroyRequest = null;
	private CreateConnectionViewAndElementRequest createRequest = null;
	private ReconnectRequest reconnectRequest = null;

	// Only for movement of a BES EditPart
	private BehaviorExecutionSpecificationEditPart besEditPart = null;

	private TransactionalEditingDomain transactionalEditingDomain;

	// New message creation
	public MessageOrderCommand(CreateConnectionViewAndElementRequest req) {

		createRequest = req;

		connectionViewElemDes = createRequest
				.getConnectionViewAndElementDescriptor();

		sourceEditPart = (ShapeNodeEditPart) createRequest.getSourceEditPart();
		targetEditPart = (ShapeNodeEditPart) createRequest.getTargetEditPart();

		transactionalEditingDomain = sourceEditPart.getEditingDomain();
	}

	// Re-orientation/Re-anchoring of one end of the message
	public MessageOrderCommand(ReconnectRequest req) {

		reconnectRequest = req;

		// Used below as old source EditPart
		sourceEditPart = (ShapeNodeEditPart) reconnectRequest
				.getConnectionEditPart().getSource();
		// Used below as old target EditPart
		targetEditPart = (ShapeNodeEditPart) reconnectRequest
				.getConnectionEditPart().getTarget();

		// Note: Since the reconnect command has still not been executed, the
		// connection EditPart still stores the old Source/Target EditPart. That
		// is the reason why it is not necessary to provide to the constructor
		// these values.

		transactionalEditingDomain = sourceEditPart.getEditingDomain();
	}

	// Destruction of a Message. A re-ordering of the ends must be done
	public MessageOrderCommand(DestroyElementRequest req) {
		destroyRequest = req;

		sourceEditPart = null;
		targetEditPart = null;

		transactionalEditingDomain = destroyRequest.getEditingDomain();
	}

	// Movement of a Behavior Execution Specification. A re-ordering of its
	// Start and Finish Message Occurrence Specifications should be done.
	public MessageOrderCommand(BehaviorExecutionSpecificationEditPart besEP) {
		besEditPart = besEP;
		transactionalEditingDomain = besEP.getEditingDomain();
	}

	@Override
	public boolean canExecute() {
		// TODO: Can execute should not return true in all cases
		return true;
	}

	@Override
	public void execute() {
		super.execute();

		if (besEditPart != null) {

			// Get the BES
			BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) besEditPart
					.resolveSemanticElement();

			// If the BES has no Start/Finish values, nothing should be done
			// Note that if one value is null the other value should be null as
			// well. If not, the model is incorrect.
			if (bes.getStart() == null || bes.getFinish() == null)
				return;

			// Get the oldBefore MOS of Start MOS
			OccurrenceSpecification oldBefore = null;
			if (bes.getStart() != null
					&& bes.getStart().getGeneralOrderings().size() > 0)
				oldBefore = bes.getStart().getGeneralOrderings().get(0)
						.getBefore();

			// Get the oldAfter MOS of Finish MOS
			OccurrenceSpecification oldAfter = null;
			if (bes.getFinish() != null
					&& bes.getFinish().getGeneralOrderings().size() > 0)
				oldAfter = bes.getFinish().getGeneralOrderings().get(0)
						.getAfter();

			// Update BES figure
			besEditPart.getFigure().getUpdateManager().performUpdate();

			// Get the newBefore MOS of Start MOS
			ConnectionNodeEditPart startConnEP = MessageCommonUtil
					.getBESStartMessageEditPart(besEditPart);
			Point pStartMOS = MessageCommonUtil.getMessageEndIntersectionPoint(
					besEditPart, startConnEP, bes.getStart());
			OccurrenceSpecification newBefore = getMOSBeforePos(
					(LifelineEditPart) besEditPart.getParent(), pStartMOS,
					startConnEP);
			// If newBefore == null, then newBefore = StartMOS
			if (newBefore == null)
				newBefore = bes.getStart();

			// Get the newAfter MOS of Finish MOS
			ConnectionNodeEditPart finishConnEP = MessageCommonUtil
					.getBESFinishMessageEditPart(besEditPart);
			Point pFinishMOS = MessageCommonUtil
					.getMessageEndIntersectionPoint(besEditPart, finishConnEP,
							bes.getFinish());
			OccurrenceSpecification newAfter = getMOSAfterPos(
					(LifelineEditPart) besEditPart.getParent(), pFinishMOS,
					finishConnEP);
			// if newAfter== null, then newAfter = FinishMOS
			if (newAfter == null)
				newAfter = bes.getFinish();

			// To make changes
			EReference goAfterFeature = UMLPackage.eINSTANCE
					.getGeneralOrdering_After();
			EReference goBeforeFeature = UMLPackage.eINSTANCE
					.getGeneralOrdering_Before();

			if (oldBefore != newBefore) {
				// UPDATE oldBefore MOS
				if (oldBefore != bes.getStart()) {
					if (oldAfter == bes.getFinish())
						doSetCommand(oldBefore.getGeneralOrderings().get(0),
								goAfterFeature, oldBefore);
					else
						doSetCommand(oldBefore.getGeneralOrderings().get(0),
								goAfterFeature, oldAfter);
				}

				// UPDATE newBefore MOS
				if (newBefore != bes.getStart()) {
					doSetCommand(newBefore.getGeneralOrderings().get(0),
							goAfterFeature, bes.getStart());
				}

				// UPDATE Start MOS (from moving BES)
				// Update the Before feature of Start MOS with newBefore
				doSetCommand(bes.getStart().getGeneralOrderings().get(0),
						goBeforeFeature, newBefore);
			}

			if (oldAfter != newAfter) {
				// UPDATE oldAfter MOS
				if (oldAfter != bes.getFinish()) {
					if (oldBefore == bes.getStart())
						doSetCommand(oldAfter.getGeneralOrderings().get(0),
								goBeforeFeature, oldAfter);
					else
						doSetCommand(oldAfter.getGeneralOrderings().get(0),
								goBeforeFeature, oldBefore);
				}

				// UPDATE newAfter MOS
				if (newAfter != bes.getFinish()) {
					doSetCommand(newAfter.getGeneralOrderings().get(0),
							goBeforeFeature, bes.getFinish());
				}

				// UPDATE Finish MOS (from moving BES)
				// Update the After feature of Finish MOS with newAfter
				doSetCommand(bes.getFinish().getGeneralOrderings().get(0),
						goAfterFeature, newAfter);
			}

		}
		// Creation of a new message
		else if (createRequest != null) {

			View newMsgView = (View) connectionViewElemDes
					.getAdapter(View.class);
			ConnectionEditPart newMsgEditPart = (ConnectionEditPart) sourceEditPart
					.getViewer().getEditPartRegistry().get(newMsgView);

			// Needed to update the points of the connection figure
			newMsgEditPart.getFigure().getUpdateManager().performUpdate();

			orderLifelinesAddMessage(newMsgEditPart);

		}
		// Destruction of a message
		else if (destroyRequest != null) {
			if (destroyRequest.getElementToDestroy() instanceof Message) {
				orderLifelinesDelMessage();
			}
		}
		// Re-orientation/Re-anchoring of a existing message
		else if (reconnectRequest != null) {

			Element endElement;
			ShapeNodeEditPart endElementEditPart;

			Message msgElement;
			ConnectionEditPart msgElementEditPart;

			MessageOccurrenceSpecification endMOS;

			// Message
			msgElementEditPart = reconnectRequest.getConnectionEditPart();
			msgElement = (Message) ((ConnectionNodeEditPart) msgElementEditPart)
					.resolveSemanticElement();

			// Old Source End
			if (reconnectRequest.isMovingStartAnchor()) {
				endElement = (Element) sourceEditPart.resolveSemanticElement();
				endMOS = (MessageOccurrenceSpecification) msgElement
						.getSendEvent();
			}
			// Old Target End
			else {
				endElement = (Element) targetEditPart.resolveSemanticElement();
				endMOS = (MessageOccurrenceSpecification) msgElement
						.getReceiveEvent();
			}

			// Remove ordering from the old end
			if (endElement instanceof BehaviorExecutionSpecification) {
				orderBESDelMOS((BehaviorExecutionSpecification) endElement,
						endMOS);
			}
			orderLifelineDelMOS(endMOS);

			// To make a copy of the GeneralOrdering list
			BasicEList<GeneralOrdering> goList = new BasicEList<GeneralOrdering>();
			goList.addAll(endMOS.getGeneralOrderings());
			for (Iterator<GeneralOrdering> i = goList.iterator(); i.hasNext();) {
				GeneralOrdering go = i.next();
				i.remove();
				DestroyElementCommand.destroy(go);
			}

			// Add the ordering to the new end
			// New Source End
			if (reconnectRequest.isMovingStartAnchor()) {
				endElementEditPart = ((ShapeNodeEditPart) reconnectRequest
						.getConnectionEditPart().getSource());
			}
			// New Target End
			else {
				endElementEditPart = ((ShapeNodeEditPart) reconnectRequest
						.getConnectionEditPart().getTarget());
			}

			orderLifelineAddMOS(msgElementEditPart, endElementEditPart);

		}

	}

	public void orderLifelinesAddMessage(ConnectionEditPart newMsgEditPart) {
		orderLifelineAddMOS(newMsgEditPart, sourceEditPart);
		orderLifelineAddMOS(newMsgEditPart, targetEditPart);
	}

	public void orderLifelineAddMOS(ConnectionEditPart msgEditPart,
			ShapeNodeEditPart elementEditPart) {
		// Order the MOS in the Lifeline

		// Obtain the LifelineEditPart
		LifelineEditPart lifelineEditPart;
		if (elementEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			lifelineEditPart = (LifelineEditPart) elementEditPart.getParent();
		} else {
			lifelineEditPart = (LifelineEditPart) elementEditPart;
		}

		// Do the ordering
		Message msg = (Message) ((ConnectionNodeEditPart) msgEditPart)
				.resolveSemanticElement();
		MessageOccurrenceSpecification currentMOS;
		Point currentPos; // Position of the currentMOS

		MessageOccurrenceSpecification beforeMOS = null;
		MessageOccurrenceSpecification afterMOS = null;

		if (msgEditPart.getSource() == elementEditPart) {
			currentMOS = (MessageOccurrenceSpecification) msg.getSendEvent();
			currentPos = elementEditPart.getSourceConnectionAnchor(msgEditPart)
					.getReferencePoint();
		} else {
			currentMOS = (MessageOccurrenceSpecification) msg.getReceiveEvent();
			currentPos = elementEditPart.getTargetConnectionAnchor(msgEditPart)
					.getReferencePoint();
		}

		beforeMOS = getMOSBeforePos(lifelineEditPart, currentPos, msgEditPart);
		afterMOS = getMOSAfterPos(lifelineEditPart, currentPos, msgEditPart);

		// 1.- order current MOS - GeneralOrdering currentGO =
		createGeneralOrderingInMOS(currentMOS, beforeMOS, afterMOS);

		// Feature to make updates
		EReference feature;

		// 2.- Update beforeMOS GeneralOrdering
		if (beforeMOS != null && beforeMOS.getGeneralOrderings().size() > 0) {
			feature = UMLPackage.eINSTANCE.getGeneralOrdering_After();
			doSetCommand(beforeMOS.getGeneralOrderings().get(0), feature,
					currentMOS);
		}

		// 3.- Update afterMOS GeneralOrdering
		if (afterMOS != null && afterMOS.getGeneralOrderings().size() > 0) {
			feature = UMLPackage.eINSTANCE.getGeneralOrdering_Before();
			doSetCommand(afterMOS.getGeneralOrderings().get(0), feature,
					currentMOS);
		}

		// In case the target was a BES, order the MOS in the BES
		if (elementEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			orderBESAddMOS(
					(BehaviorExecutionSpecificationEditPart) elementEditPart,
					currentMOS);
		}
	}

	public MessageOccurrenceSpecification getMOSBeforePos(
			LifelineEditPart lifelineEP, Point pos, ConnectionEditPart msgEP) {
		return getMOSAfterOrBeforePos(lifelineEP, pos, msgEP, true);
	}

	public MessageOccurrenceSpecification getMOSAfterPos(
			LifelineEditPart lifelineEP, Point pos, ConnectionEditPart msgEP) {
		return getMOSAfterOrBeforePos(lifelineEP, pos, msgEP, false);
	}

	private MessageOccurrenceSpecification getMOSAfterOrBeforePos(
			LifelineEditPart lifelineEP, Point pos, ConnectionEditPart msgEP,
			boolean before) {
		// return the MOS before or after the position indicated by pos

		List<EditPart> linksList = new BasicEList<EditPart>();

		Point auxPos = null;
		MessageOccurrenceSpecification auxMOS = null;

		Point returnPos = null;
		MessageOccurrenceSpecification returnMOS = null;

		// Lifeline source connections (Remove itself)
		linksList.clear();
		linksList.addAll(lifelineEP.getSourceConnections());
		// Remove current link
		linksList.remove(msgEP);
		// Remove links whose semantic element is different from Message
		MessageCommonUtil.removeNonMessageConnections(linksList);

		for (Iterator i = linksList.iterator(); i.hasNext();) {
			ConnectionEditPart currentLink = (ConnectionEditPart) i.next();

			if (currentLink instanceof ConnectionNodeEditPart) {
				auxPos = lifelineEP.getSourceConnectionAnchor(currentLink)
						.getReferencePoint(); // intersection point
				Message msg = (Message) ((ConnectionNodeEditPart) currentLink)
						.resolveSemanticElement();
				auxMOS = (MessageOccurrenceSpecification) msg.getSendEvent(); // currentMOS

				if (before && auxPos.y <= pos.y) {
					if (returnPos == null || auxPos.y >= returnPos.y) {
						returnPos = auxPos;
						returnMOS = auxMOS;
					}
				}
				if (!before && auxPos.y >= pos.y) {
					if (returnPos == null || auxPos.y <= returnPos.y) {
						returnPos = auxPos;
						returnMOS = auxMOS;
					}
				}
			}

		}

		// Lifeline target connections
		linksList.clear();
		linksList.addAll(lifelineEP.getTargetConnections());
		// Remove current link
		linksList.remove(msgEP);
		// Remove links whose semantic element is different from Message
		MessageCommonUtil.removeNonMessageConnections(linksList);

		for (Iterator i = linksList.iterator(); i.hasNext();) {
			ConnectionEditPart currentLink = (ConnectionEditPart) i.next();

			if (currentLink instanceof ConnectionNodeEditPart) {
				auxPos = lifelineEP.getTargetConnectionAnchor(currentLink)
						.getReferencePoint(); // intersection point
				Message msg = (Message) ((ConnectionNodeEditPart) currentLink)
						.resolveSemanticElement();
				auxMOS = (MessageOccurrenceSpecification) msg.getReceiveEvent(); // currentMOS

				if (before && auxPos.y <= pos.y) {
					if (returnPos == null || auxPos.y >= returnPos.y) {
						returnPos = auxPos;
						returnMOS = auxMOS;
					}
				}

				if (!before && auxPos.y >= pos.y) {
					if (returnPos == null || auxPos.y <= returnPos.y) {
						returnPos = auxPos;
						returnMOS = auxMOS;
					}
				}
			}

		}

		// BehaviorsExecutionSpecifications contained in the Lifeline
		for (Iterator i = lifelineEP.getChildren().iterator(); i.hasNext();) {
			Object next = i.next();
			if (next instanceof BehaviorExecutionSpecificationEditPart) {
				BehaviorExecutionSpecificationEditPart besEP = (BehaviorExecutionSpecificationEditPart) next;

				// BehaviorExecutionSpecification source connections
				linksList.clear();
				linksList.addAll(besEP.getSourceConnections());
				// Remove current link
				linksList.remove(msgEP);
				// Remove links whose semantic element is different from Message
				MessageCommonUtil.removeNonMessageConnections(linksList);

				for (Iterator j = linksList.iterator(); j.hasNext();) {
					ConnectionEditPart currentLink = (ConnectionEditPart) j
							.next();

					if (currentLink instanceof ConnectionNodeEditPart) {
						auxPos = besEP.getSourceConnectionAnchor(currentLink)
								.getReferencePoint(); // intersection point
						Message msg = (Message) ((ConnectionNodeEditPart) currentLink)
								.resolveSemanticElement();
						auxMOS = (MessageOccurrenceSpecification) msg
								.getSendEvent(); // currentMOS

						if (before && auxPos.y <= pos.y) {
							if (returnPos == null || auxPos.y >= returnPos.y) {
								returnPos = auxPos;
								returnMOS = auxMOS;
							}
						}

						if (!before && auxPos.y >= pos.y) {
							if (returnPos == null || auxPos.y <= returnPos.y) {
								returnPos = auxPos;
								returnMOS = auxMOS;
							}
						}
					}

				}

				// BehaviorExecutionSpecification target connections
				linksList.clear();
				linksList.addAll(besEP.getTargetConnections());
				// Remove current link
				linksList.remove(msgEP);
				// Remove links whose semantic element is different from Message
				MessageCommonUtil.removeNonMessageConnections(linksList);

				for (Iterator j = linksList.iterator(); j.hasNext();) {
					ConnectionEditPart currentLink = (ConnectionEditPart) j
							.next();

					if (currentLink instanceof ConnectionNodeEditPart) {
						auxPos = besEP.getTargetConnectionAnchor(currentLink)
								.getReferencePoint(); // intersection point
						Message msg = (Message) ((ConnectionNodeEditPart) currentLink)
								.resolveSemanticElement();
						auxMOS = (MessageOccurrenceSpecification) msg
								.getReceiveEvent(); // currentMOS

						if (before && auxPos.y <= pos.y) {
							if (returnPos == null || auxPos.y >= returnPos.y) {
								returnPos = auxPos;
								returnMOS = auxMOS;
							}
						}

						if (!before && auxPos.y >= pos.y) {
							if (returnPos == null || auxPos.y <= returnPos.y) {
								returnPos = auxPos;
								returnMOS = auxMOS;
							}
						}
					}

				}

			} // end if bes
		} // end for bes
		return returnMOS;
	}

	public GeneralOrdering createGeneralOrderingInMOS(
			MessageOccurrenceSpecification currentMOS,
			MessageOccurrenceSpecification beforeMOS,
			MessageOccurrenceSpecification afterMOS) {
		GeneralOrdering currentGO = null;
		// Not in a Transactional domain so we cannot use
		// currentMOS.createGeneralOrdering("Name")
		currentGO = UMLFactory.eINSTANCE.createGeneralOrdering();

		// Assign Name
		currentGO.setName(currentMOS.getName() + "_GO");

		// Add the new generalOrdering to the MOS
		EReference featureGO = UMLPackage.eINSTANCE
				.getInteractionFragment_GeneralOrdering();
		doAddCommand(currentMOS, featureGO, currentGO);

		// features
		EReference featureBefore = UMLPackage.eINSTANCE
				.getGeneralOrdering_Before();
		EReference featureAfter = UMLPackage.eINSTANCE
				.getGeneralOrdering_After();

		// currentGO.setBefore(beforeMOS);
		if (beforeMOS != null) {
			doSetCommand(currentGO, featureBefore, beforeMOS);
		} else {
			doSetCommand(currentGO, featureBefore, currentMOS);
		}

		// currentGO.setAfter(afterMOS);
		if (afterMOS != null) {
			doSetCommand(currentGO, featureAfter, afterMOS);
		} else {
			doSetCommand(currentGO, featureAfter, currentMOS);
		}

		if (currentMOS.getGeneralOrderings().size() > 0) {
			return currentMOS.getGeneralOrderings().get(0);
		} else {
			return null;
		}

	}

	public void doSetCommand(Object owner, Object feature, Object value) {
		EditingDomain editingDomain = getEditingDomain();
		org.eclipse.emf.common.command.Command cmd = SetCommand.create(
				editingDomain, owner, feature, value);
		commandList.add(cmd);
		editingDomain.getCommandStack().execute(cmd);
	}

	public void doAddCommand(Object owner, Object feature, Object value) {
		EditingDomain editingDomain = getEditingDomain();
		org.eclipse.emf.common.command.Command cmd = AddCommand.create(
				editingDomain, owner, feature, value);
		commandList.add(cmd);
		editingDomain.getCommandStack().execute(cmd);
	}

	public void doRemoveCommand(Object owner, Object feature, Object value) {
		EditingDomain editingDomain = getEditingDomain();
		org.eclipse.emf.common.command.Command cmd = RemoveCommand.create(
				editingDomain, owner, feature, value);
		commandList.add(cmd);
		editingDomain.getCommandStack().execute(cmd);
	}

	public TransactionalEditingDomain getEditingDomain() {
		return transactionalEditingDomain;
	}

	@Override
	public void undo() {
		for (int i = commandList.size() - 1; i >= 0; i--) {
			if (getEditingDomain().getCommandStack().getUndoCommand() == commandList
					.get(i)) {
				getEditingDomain().getCommandStack().undo();
			}
		}
	}

	@Override
	public void redo() {
		for (int i = 0; i < commandList.size(); i++) {
			if (getEditingDomain().getCommandStack().getRedoCommand() == commandList
					.get(i)) {
				getEditingDomain().getCommandStack().redo();
			}
		}
	}

	public void orderLifelinesDelMessage() {
		Message msg = (Message) destroyRequest.getElementToDestroy();

		// Obtain the elements to destroy
		MessageOccurrenceSpecification msgSend = null;
		MessageOccurrenceSpecification msgReceive = null;

		if (msg.getSendEvent() instanceof MessageOccurrenceSpecification) {
			msgSend = (MessageOccurrenceSpecification) msg.getSendEvent();
			Element src = MessageCommonUtil.getMessageSrc(msg);

			// If source element is a BES, update BES.start && BES.finish
			// attributes
			if (src instanceof BehaviorExecutionSpecification) {
				orderBESDelMOS((BehaviorExecutionSpecification) src, msgSend);
			}

			// Reorder MOS's in its corresponding Lifeline
			orderLifelineDelMOS(msgSend);
		}

		if (msg.getReceiveEvent() instanceof MessageOccurrenceSpecification) {
			msgReceive = (MessageOccurrenceSpecification) msg.getReceiveEvent();
			Element dst = MessageCommonUtil.getMessageDst(msg);

			// If target element is a BES, update BES.start && BES.finish
			// attributes
			if (dst instanceof BehaviorExecutionSpecification) {
				orderBESDelMOS((BehaviorExecutionSpecification) dst, msgReceive);
			}

			// Reorder MOS's in its corresponding Lifeline
			orderLifelineDelMOS(msgReceive);
		}
	}

	public void orderLifelineDelMOS(MessageOccurrenceSpecification mos) {

		OccurrenceSpecification beforeOS = null;
		OccurrenceSpecification afterOS = null;

		EReference beforeFeature = UMLPackage.eINSTANCE
				.getGeneralOrdering_Before();
		EReference afterFeature = UMLPackage.eINSTANCE
				.getGeneralOrdering_After();

		if (mos.getGeneralOrderings().size() > 0) {
			beforeOS = mos.getGeneralOrderings().get(0).getBefore();
			afterOS = mos.getGeneralOrderings().get(0).getAfter();
		}

		if (beforeOS != null && beforeOS != mos
				&& beforeOS.getGeneralOrderings().size() > 0) {
			if (afterOS == mos) {
				doSetCommand(beforeOS.getGeneralOrderings().get(0),
						afterFeature, beforeOS);
			} else {
				doSetCommand(beforeOS.getGeneralOrderings().get(0),
						afterFeature, afterOS);
			}
		}

		if (afterOS != null && afterOS != mos
				&& afterOS.getGeneralOrderings().size() > 0) {
			if (beforeOS == mos) {
				doSetCommand(afterOS.getGeneralOrderings().get(0),
						beforeFeature, afterOS);
			} else {
				doSetCommand(afterOS.getGeneralOrderings().get(0),
						beforeFeature, beforeOS);
			}
		}

	}

	public void orderBESDelMOS(BehaviorExecutionSpecification bes,
			MessageOccurrenceSpecification mos) {
		EReference featureStart = UMLPackage.eINSTANCE
				.getExecutionSpecification_Start();
		EReference featureFinish = UMLPackage.eINSTANCE
				.getExecutionSpecification_Finish();

		// Do nothing.
		if (mos != bes.getStart() && mos != bes.getFinish()) {
			return;
		}

		// Not really necessary because References are removed automatically
		// when the element is deleted.
		if (bes.getStart() == mos && bes.getFinish() == mos) {
			doSetCommand(bes, featureStart, null);
			doSetCommand(bes, featureFinish, null);
			return;
		}

		if (bes.getStart() == mos) {
			if (mos.getGeneralOrderings().size() > 0) {
				doSetCommand(bes, featureStart, mos.getGeneralOrderings()
						.get(0).getAfter());
			}

		} else if (bes.getFinish() == mos) {
			if (mos.getGeneralOrderings().size() > 0) {
				doSetCommand(bes, featureFinish, mos.getGeneralOrderings().get(
						0).getBefore());
			}

		}

	}

	public void orderBESAddMOS(
			BehaviorExecutionSpecificationEditPart besEditPart,
			MessageOccurrenceSpecification currentMOS) {
		BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) besEditPart
				.resolveSemanticElement();
		EReference featureStart, featureFinish;
		featureStart = UMLPackage.eINSTANCE.getExecutionSpecification_Start();
		featureFinish = UMLPackage.eINSTANCE.getExecutionSpecification_Finish();

		// Case is the first MOS on the BES
		if (bes.getStart() == null && bes.getFinish() == null) {
			doSetCommand(bes, featureStart, currentMOS);
			doSetCommand(bes, featureFinish, currentMOS);
		}

		if ((bes.getStart() != null)) {
			// Check if currentMOS is before bes.startMOS
			if (isOS1BeforeOS2(currentMOS, bes.getStart())) {
				doSetCommand(bes, featureStart, currentMOS);
			}
		}

		if (bes.getFinish() != null) {
			// Check if currentMOS is after bes.finishMOS
			if (isOS1AfterOS2(currentMOS, bes.getFinish())) {
				doSetCommand(bes, featureFinish, currentMOS);
			}
		}
	}

	public static boolean isOS1BeforeOS2(OccurrenceSpecification os1,
			OccurrenceSpecification os2) {
		// Check if non of the input parameters is null
		if (os1 == null || os2 == null) {
			return false;
		}

		if (os1.getGeneralOrderings().size() > 0) {

			if (os1.getGeneralOrderings().get(0).getAfter() == null
					|| os1 == os1.getGeneralOrderings().get(0).getAfter()) {
				return false;
			}

			if (os1.getGeneralOrderings().get(0).getAfter() == os2) {
				return true;
			} else {
				return isOS1BeforeOS2(os1.getGeneralOrderings().get(0)
						.getAfter(), os2);
			}

		} else {
			return false;
		}
	}

	public static boolean isOS1AfterOS2(OccurrenceSpecification os1,
			OccurrenceSpecification os2) {
		return isOS1BeforeOS2(os2, os1);
	}

}
