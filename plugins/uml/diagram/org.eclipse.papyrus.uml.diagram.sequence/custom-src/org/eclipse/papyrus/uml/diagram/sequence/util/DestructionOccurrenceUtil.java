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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageSort;

public class DestructionOccurrenceUtil {

	public static void reorderDestructionOccurrence(List<InteractionFragment> reorderedFragments) {
		int size = reorderedFragments.size();
		List<InteractionFragment> destructionOccurrenceList = new ArrayList<InteractionFragment>(size);
		for(int i = 0; i < size; i++) {
			InteractionFragment o = reorderedFragments.get(i);
			if(o instanceof DestructionOccurrenceSpecification) {
				destructionOccurrenceList.add(o);
			}
		}
		reorderedFragments.removeAll(destructionOccurrenceList);
		reorderedFragments.addAll(destructionOccurrenceList);
	}

	public static void constraintDestructionOccurrence(Message mess, List<InteractionFragment> constraint) {
		if(mess.getMessageSort() != MessageSort.DELETE_MESSAGE_LITERAL)
			return;
		addDestructionOccurrenceConstraint(mess.getReceiveEvent(), constraint);
		addDestructionOccurrenceConstraint(mess.getSendEvent(), constraint);
	}

	public static void addDestructionOccurrenceConstraint(MessageEnd end, List<InteractionFragment> constraint) {
		if(end instanceof InteractionFragment) {
			InteractionFragment frag = (InteractionFragment)end;
			if(frag.getCovereds().size() > 0) {
				Lifeline lifeline = ((InteractionFragment)frag).getCovereds().get(0);
				DestructionOccurrenceSpecification d = findDestructionOccurrence(lifeline);
				if(d != null)
					constraint.add(d);
			}
		}
	}

	public static DestructionOccurrenceSpecification findDestructionOccurrence(Lifeline lifeline) {
		EList<InteractionFragment> list = lifeline.getCoveredBys();
		for(InteractionFragment f : list)
			if(f instanceof DestructionOccurrenceSpecification) {
				return (DestructionOccurrenceSpecification)f;
			}
		return null;
	}
}
