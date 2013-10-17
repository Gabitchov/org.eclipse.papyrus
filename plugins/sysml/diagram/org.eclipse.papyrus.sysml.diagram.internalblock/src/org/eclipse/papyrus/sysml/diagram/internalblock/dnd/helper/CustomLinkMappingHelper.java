/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.dnd.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.dnd.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class CustomLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		CommonSourceUMLSwitch umlSwitch = new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {

				java.util.Collection<?> ends = Collections.emptySet();

				// Support for binary Connector only in this diagram.

				if(object.getEnds().size() == 2) {

					ConnectorEnd semanticSource = object.getEnds().get(0);
					ends = Arrays.asList(new EObject[]{ semanticSource });

				} else {
					// TODO: log warning here - can only drop binary associations in this diagram...
				}

				return ends;
			};

		};
		return umlSwitch.doSwitch(link);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		CommonTargetUMLSwitch umlSwitch = new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {

				java.util.Collection<?> ends = Collections.emptySet();

				// Support for binary Connector only in this diagram.			

				if(object.getEnds().size() == 2) {

					ConnectorEnd semanticTarget = object.getEnds().get(1);
					ends = Arrays.asList(new EObject[]{ semanticTarget });

				} else {
					// TODO: log warning here - can only drop binary associations in this diagram...
				}

				return ends;
			};

		};
		return umlSwitch.doSwitch(link);
	}
}
