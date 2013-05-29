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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * An helper class to reconnect message.
 * TODO : finish the implementation of this class
 */
public class ReconnectMessageHelper {

	/**
	 * Update Message :
	 * - Update its signature
	 * 
	 * @param message
	 */
	public static void updateMessage(Message message) {
		// TODO Auto-generated method stub
	}

	/**
	 * Update the message end :
	 * 
	 * @param messageEnd
	 * @param oldElement
	 * @param newElement
	 */
	public static void updateMessageEnd(MessageEnd messageEnd, Element oldElement, Element newElement) {
		if(messageEnd instanceof MessageOccurrenceSpecification) {
			updateMos((MessageOccurrenceSpecification)messageEnd, oldElement, newElement);
		} else if(messageEnd instanceof Gate) {
			updateGate((Gate)messageEnd, oldElement, newElement);
		}
	}

	public static void updateGate(Gate messageEnd, Element oldElement, Element newElement) {
		if(newElement instanceof Gate && messageEnd != newElement) {
			Gate newEnd = (Gate)newElement;
			Message message = messageEnd.getMessage();
			if(message != null) {
				if(messageEnd == message.getSendEvent()) {
					message.setSendEvent(newEnd);
				} else if(messageEnd == message.getReceiveEvent()) {
					message.setReceiveEvent(newEnd);
				}
				newEnd.setMessage(message);
				messageEnd.setMessage(null);
			}
		}
	}

	public static void updateMos(MessageOccurrenceSpecification messageEnd, Element oldElement, Element newElement) {
		if(newElement instanceof Lifeline && !(oldElement instanceof CombinedFragment && InteractionOperatorKind.PAR_LITERAL.equals(((CombinedFragment)oldElement).getInteractionOperator()))) {
			updateOccurenceSpecification(messageEnd, (Lifeline)newElement);
		} else if(newElement instanceof ExecutionSpecification && !(oldElement instanceof CombinedFragment && InteractionOperatorKind.PAR_LITERAL.equals(((CombinedFragment)oldElement).getInteractionOperator()))) {
			Lifeline lifeline = CommandHelper.getExecutionSpecificationLifeline((ExecutionSpecification)newElement);
			if(lifeline != null) {
				updateOccurenceSpecification(messageEnd, lifeline);
			}
		} else if(newElement instanceof CombinedFragment && InteractionOperatorKind.PAR_LITERAL.equals(((CombinedFragment)newElement).getInteractionOperator())) {
			// handle reorient on coregion
			CombinedFragment cf = (CombinedFragment)newElement;
			InteractionOperand io = CommandHelper.getCoRegionInteractionOperand(cf);
			messageEnd.setEnclosingOperand(io);
			// try to find and put in the operand the other mos of the message
			MessageEnd messageEnd2 = findSecondMessageEnd(messageEnd);
			if(messageEnd2 instanceof MessageOccurrenceSpecification) {
				((MessageOccurrenceSpecification)messageEnd2).setEnclosingOperand(io);
			}
			// update interaction operands covered lifelines
			updateCoveredLifelinesOfCoregionOperand(cf);
		} else if(oldElement instanceof CombinedFragment && InteractionOperatorKind.PAR_LITERAL.equals(((CombinedFragment)oldElement).getInteractionOperator())) {
			// handle reorient from coregion
			CombinedFragment cf = (CombinedFragment)oldElement;
			Element backInteraction = cf.getOwner();
			SequenceUtil.setEnclosingInteraction(messageEnd, backInteraction, true);
			MessageEnd messageEnd2 = findSecondMessageEnd(messageEnd);
			if(messageEnd2 instanceof MessageOccurrenceSpecification) {
				SequenceUtil.setEnclosingInteraction((MessageOccurrenceSpecification)messageEnd2, backInteraction, true);
			}
			// update interaction operands covered lifelines
			updateCoveredLifelinesOfCoregionOperand(cf);
		}
	}

	public static MessageEnd findSecondMessageEnd(MessageEnd messageEnd) {
		Message msg = messageEnd.getMessage();
		MessageEnd messageEnd2 = null;
		if(msg != null) {
			if(messageEnd.equals(msg.getSendEvent())) {
				messageEnd2 = msg.getReceiveEvent();
			} else {
				messageEnd2 = msg.getSendEvent();
			}
		}
		return messageEnd2;
	}

	/**
	 * OccurrenceSpecification cover a unique lifeline.
	 * 
	 * @param os
	 *        the occurrence specification to update
	 * @param newLifeline
	 *        the new lifeline covered by the OS
	 */
	public static void updateOccurenceSpecification(OccurrenceSpecification os, Lifeline newLifeline) {
		// An occurrence specification covers a unique lifeline
		EList<Lifeline> covereds = os.getCovereds();
		if(covereds.isEmpty()) {
			covereds.add(newLifeline);
		} else if(covereds.size() == 1) {
			if(newLifeline != covereds.get(0)) {
				os.setCovered(newLifeline);
			}
		} else {
			covereds.clear();
			covereds.add(newLifeline);
		}
	}

	/**
	 * Update the list of lifelines covered by the Interaction Operands of a coregion.
	 * These are the lifelines covered by all contained Message Occurrence Specifications.
	 * 
	 * @param coregion
	 *        the coregion to update operands
	 */
	public static void updateCoveredLifelinesOfCoregionOperand(CombinedFragment coregion) {
		coregion.getCovereds().clear();
		for(InteractionOperand operand : coregion.getOperands()) {
			operand.getCovereds().clear();
			for(InteractionFragment fragment : operand.getFragments()) {
				if(fragment instanceof MessageOccurrenceSpecification) {
					operand.getCovereds().addAll(fragment.getCovereds());
					coregion.getCovereds().addAll(fragment.getCovereds());
				}
			}
		}
	}
}
