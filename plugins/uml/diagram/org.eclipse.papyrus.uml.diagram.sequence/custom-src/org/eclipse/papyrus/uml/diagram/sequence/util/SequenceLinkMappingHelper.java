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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * A link mapping helper used for dNd.
 * 
 * See {@link CustomDiagramDragDropEditPolicy}
 */
public class SequenceLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static SequenceLinkMappingHelper instance = new SequenceLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static SequenceLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private SequenceLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseMessage(org.eclipse.uml2.uml.Message object) {
				if(object.getSendEvent() != null) {
					MessageEnd messageEnd = object.getSendEvent();
					if(messageEnd instanceof MessageOccurrenceSpecification) {
						return ((MessageOccurrenceSpecification)messageEnd).getCovereds();
					} else if(messageEnd instanceof Gate) {
						ArrayList<Element> sources = new ArrayList<Element>();
						sources.add(((Gate)messageEnd).getOwner());
						return sources;
					}
				} else {
					return Collections.singletonList(object.getInteraction());
				}
				return Collections.EMPTY_LIST;
			};

			public Collection<?> caseGeneralOrdering(GeneralOrdering object) {
				if(object.getBefore() != null) {
					OccurrenceSpecification before = object.getBefore();
					return before.getCovereds();
				}
				return Collections.EMPTY_LIST;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseMessage(org.eclipse.uml2.uml.Message object) {
				if(object.getReceiveEvent() != null) {
					MessageEnd messageEnd = (MessageEnd)object.getReceiveEvent();
					if(messageEnd instanceof MessageOccurrenceSpecification) {
						return ((MessageOccurrenceSpecification)messageEnd).getCovereds();
					} else if(messageEnd instanceof Gate) {
						ArrayList<Element> sources = new ArrayList<Element>();
						sources.add(((Gate)messageEnd).getOwner());
						return sources;
					}
				} else {
					return Collections.singletonList(object.getInteraction());
				}
				return Collections.EMPTY_LIST;
			};

			public Collection<?> caseGeneralOrdering(GeneralOrdering object) {
				if(object.getAfter() != null) {
					OccurrenceSpecification after = object.getAfter();
					return after.getCovereds();
				}
				return Collections.EMPTY_LIST;
			}

		});
	}
}
