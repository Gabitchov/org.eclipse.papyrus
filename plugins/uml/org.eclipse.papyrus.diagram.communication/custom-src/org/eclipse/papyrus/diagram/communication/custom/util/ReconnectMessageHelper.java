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
package org.eclipse.papyrus.diagram.communication.custom.util;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

// TODO: Auto-generated Javadoc
/**
 * An helper class to reconnect message.
 * TODO : finish the implementation of this class
 */
public class ReconnectMessageHelper {

	/**
	 * Update Message :
	 * - Update its signature.
	 * 
	 * @param message
	 *        the message
	 */
	public static void updateMessage(Message message) {
		// TODO Auto-generated method stub

	}

	/**
	 * Update the message end :.
	 * 
	 * @param messageEnd
	 *        the message end
	 * @param oldElement
	 *        the old element
	 * @param newElement
	 *        the new element
	 */
	public static void updateMessageEnd(MessageEnd messageEnd, Element oldElement, Element newElement) {
		if(messageEnd instanceof MessageOccurrenceSpecification) {
			updateMos((MessageOccurrenceSpecification)messageEnd, oldElement, newElement);
		}
	}



	/**
	 * Update mos.
	 * 
	 * @param messageEnd
	 *        the message end
	 * @param oldElement
	 *        the old element
	 * @param newElement
	 *        the new element
	 */
	public static void updateMos(MessageOccurrenceSpecification messageEnd, Element oldElement, Element newElement) {
		if(newElement instanceof Lifeline && oldElement instanceof Lifeline) {
			updateOccurenceSpecification(messageEnd, (Lifeline)newElement);
		}
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
		os.getCovereds().clear();
		os.getCovereds().add(newLifeline);
	}
}
