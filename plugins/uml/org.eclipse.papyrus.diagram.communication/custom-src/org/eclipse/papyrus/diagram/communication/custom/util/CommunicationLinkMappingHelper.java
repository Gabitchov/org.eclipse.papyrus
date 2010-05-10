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
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * 
 * The Communication LinkMappingHelper is specialization of the link mapping helper for the Communication diagram
 * 
 */
public class CommunicationLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static CommunicationLinkMappingHelper instance = new CommunicationLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static CommunicationLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private CommunicationLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			@Override
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
				}
				return Collections.EMPTY_LIST;
			};
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			@Override
			public java.util.Collection<?> caseMessage(org.eclipse.uml2.uml.Message object) {
				if(object.getReceiveEvent() != null) {
					MessageEnd messageEnd = object.getReceiveEvent();
					if(messageEnd instanceof MessageOccurrenceSpecification) {
						return ((MessageOccurrenceSpecification)messageEnd).getCovereds();
					} else if(messageEnd instanceof Gate) {
						ArrayList<Element> sources = new ArrayList<Element>();
						sources.add(((Gate)messageEnd).getOwner());
						return sources;
					}
				}
				return Collections.EMPTY_LIST;
			};

		});
	}
}
