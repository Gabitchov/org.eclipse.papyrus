/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Initial API implementation
 * 				 Franciso Javier Cano Muñoz (Prodevelop) - Improvements in the first msg search
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.sequence.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.gmf.runtime.common.core.util.HashUtil;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class DiagramInitializationUtil {

	public static List<List<Message>> getGlobalMsgOrdering(
			Interaction interaction) {
		HashMap<Lifeline, List<Message>> lifelinesOrderedList = new HashMap<Lifeline, List<Message>>();

		// For each lifeline, obtains it's ordered messages
		for (Lifeline lifeline : interaction.getLifelines()) {
			lifelinesOrderedList.put(lifeline,
					getLifelineOrderdedMsgs(lifeline));
		}

		// Merge the information of all the lifelines in a global message
		// ordered list
		List<List<Message>> globalOrderedList = mergeOrderedMsgsLists(lifelinesOrderedList);

		// Return the list
		return globalOrderedList;
	}

	public static Message getLifelineFirstMessage(Lifeline lifeline) {
		// Obtain the Interaction in which the Lifeline is contained
		Interaction interaction = lifeline.getInteraction();

		// If there is no interaction, we cannot continue
		if (interaction == null)
			return null;

		// Loop through the list of messages
		for (Message msg : interaction.getMessages()) {

			MessageOccurrenceSpecification sourceEnd = MessageCommonUtil
					.getMessageSrcMOS(msg);
			MessageOccurrenceSpecification targetEnd = MessageCommonUtil
					.getMessageDstMOS(msg);

			// This should not happen but just in case
			if (sourceEnd == null || targetEnd == null)
				continue;

			// This should not happen either
			if (sourceEnd.getGeneralOrderings().size() == 0
					|| targetEnd.getGeneralOrderings().size() == 0)
				continue;

			// Check if the message belongs to this Lifeline
			if (MessageCommonUtil.getMessageSrcLifeline(msg) == lifeline) {
				// Check if it is the first message
				if (sourceEnd.getGeneralOrderings().get(0).getBefore() == sourceEnd)
					return msg;
			}
			if (MessageCommonUtil.getMessageDstLifeline(msg) == lifeline) {
				// Check if it is the first message
				if (targetEnd.getGeneralOrderings().get(0).getBefore() == targetEnd)
					return msg;
			}
		}

		// If we get here it means the lifeline has no messages
		return null;
	}

	public static List<Message> getLifelineOrderdedMsgs(Lifeline lifeline) {
		// Get it's first message
		Message msg = getLifelineFirstMessage(lifeline);

		// Create the empty list
		ArrayList<Message> orderedList = new ArrayList<Message>();

		// If no message found then nothing is left to do
		if (msg == null)
			return orderedList;

		// Add the first element
		orderedList.add(msg);

		// Get the initial OS
		OccurrenceSpecification auxOS;
		if (MessageCommonUtil.getMessageSrcLifeline(msg) == lifeline) {
			auxOS = MessageCommonUtil.getMessageSrcMOS(msg);
		} else {
			auxOS = MessageCommonUtil.getMessageDstMOS(msg);
		}
		// Add the rest of elements
		while (!isLastOS(auxOS)) {
			auxOS = auxOS.getGeneralOrderings().get(0).getAfter();
			if (auxOS instanceof MessageOccurrenceSpecification
					&& ((MessageOccurrenceSpecification) auxOS).getMessage() != null) {
				orderedList.add(((MessageOccurrenceSpecification) auxOS)
						.getMessage());
			}
		}

		// Return the ordered list
		return orderedList;
	}

	public static List<List<Message>> mergeOrderedMsgsLists(
			HashMap<Lifeline, List<Message>> orderedLists) {

		ArrayList<List<Message>> globalList = new ArrayList<List<Message>>();

		// We need one or more lists to order
		if (orderedLists.size() >= 1) {
			// VisitedLists
			List<List<Message>> visitedLists = new ArrayList<List<Message>>();
			// HashMap
			HashMap<Message, Integer> hashMap = new HashMap<Message, Integer>();

			for (List<Message> partialList : orderedLists.values()) {
				// Case the hashMap is empty
				if (hashMap.size() == 0) {
					for (int i = 0; i < partialList.size(); i++) {
						hashMap.put(partialList.get(i), i);
					}
					visitedLists.add(partialList);
				}
				// Otherwise
				else {
					int offset = 0;
					Integer existingPos;
					for (int i = 0; i < partialList.size(); i++) {
						Message msg = partialList.get(i);
						existingPos = hashMap.get(msg);
						// If not found add it
						if (existingPos == null) {
							// Add it to it's position
							hashMap.put(msg, i + offset);
						}
						// Found
						else {
							if (existingPos > (i + offset)) {
								// The global list rules
								offset = existingPos - i;
							} else if (existingPos < (i + offset)) {
								// The partial list rules

								// Current message (and the ones that go after
								// him) need to be moved to the new position
								List<Message> followersList = getFollowersList(
										msg, visitedLists);

								// Note: The followers list also includes msg

								int shift = (i + offset) - existingPos;
								for (Message follower : followersList) {
									// Update it's position
									hashMap.put(follower, hashMap.get(follower)
											+ shift); 
								}

							} else {
								// If existingPos == (i + offset), then do
								// nothing
							}
						}
					} // end for (partialList elements)
					visitedLists.add(partialList);
				}
			} // end for (orderedLists elements)

			// If the hashMap is not empty, add the ordered elements to the
			// globalList
			if (!hashMap.isEmpty()) {
				// Obtain the list of values ordered and without repeated elements
				Set<Integer> valuesSet = new HashSet<Integer>();
				valuesSet.addAll(hashMap.values());
				Object[] valuesSortedArray = valuesSet.toArray();
				Arrays.sort(valuesSortedArray);
				
				// Initialize the globalList with the maximum size possible
				for (int i = 0; i < valuesSortedArray.length; i++)
					globalList.add(new ArrayList<Message>());

				
				// Add the ordered elements
				for (Entry<Message, Integer> entry : hashMap.entrySet()) {
					int pos = Arrays.binarySearch(valuesSortedArray, entry.getValue());
					globalList.get(pos).add(entry.getKey());
				}
			}
		}

		// Return the list
		return globalList;
	}

	public static List<Message> getFollowersList(Message msg,
			List<List<Message>> visitedLists) {
		List<Message> followersList = new ArrayList<Message>();
		HashMap<List<Message>, List<Message>> followersFoundPerList = new HashMap<List<Message>, List<Message>>();
		Set<Message> addSet = new HashSet<Message>();
		Set<Message> partialAddSet = new HashSet<Message>();

		// Foreach visited list obtain it's followersList
		for (List<Message> visitedList : visitedLists) {
			followersFoundPerList.put(visitedList, followersList(msg,
					visitedList));
		}

		// Build a set with the all followersLists
		for (Entry<List<Message>, List<Message>> entry : followersFoundPerList
				.entrySet()) {
			addSet.addAll(entry.getValue());
		}

		boolean modifiedFlag;
		do {
			modifiedFlag = false;

			// Check if any of the visited lists has an empty followersList
			for (Entry<List<Message>, List<Message>> entry : followersFoundPerList
					.entrySet()) {
				// If empty, obtain again it's list with the addSet
				if (entry.getValue().isEmpty()) {
					// Loop through the addSet
					for (Message auxMsg : addSet) {
						partialAddSet.addAll(followersList(auxMsg, entry
								.getKey()));
					}
					if (!partialAddSet.isEmpty()) {
						entry.getValue().addAll(partialAddSet);
						addSet.addAll(partialAddSet);
						partialAddSet.clear();
						modifiedFlag = true;
					}
				}
			}
		} while (modifiedFlag);

		// Add the msg
		addSet.add(msg);

		// Add the set to the list
		followersList.addAll(addSet);

		return followersList;
	}

	public static List<Message> followersList(Message msg, List<Message> msgList) {
		if (msgList.contains(msg)) {
			List<Message> returnList = new ArrayList<Message>();
			returnList.addAll(msgList.subList(msgList.indexOf(msg) + 1, msgList
					.size()));
			return returnList;
		} else
			return new ArrayList<Message>();
	}

	public static boolean isLastOS(OccurrenceSpecification mos) {
		// If there is no ordering, we will consider as the last MOS
		if (mos.getGeneralOrderings().size() == 0)
			return true;

		// If the After attribute matches with itself, then it is the last MOS
		if (mos.getGeneralOrderings().get(0).getAfter() == mos)
			return true;
		else
			return false;
	}

}
