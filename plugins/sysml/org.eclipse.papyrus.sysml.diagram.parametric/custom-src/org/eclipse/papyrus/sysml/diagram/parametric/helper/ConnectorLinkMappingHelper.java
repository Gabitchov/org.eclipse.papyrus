/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.helper;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;

/**
 * Specialization of the link mapping helper for the Connector
 * 
 * @author eperico
 */
public class ConnectorLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static ConnectorLinkMappingHelper instance = new ConnectorLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ConnectorLinkMappingHelper.
	 * 
	 * @return single instance of ConnectorLinkMappingHelper
	 */
	public static ConnectorLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private ConnectorLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				EList<ConnectorEnd> ends = object.getEnds();
				if (ends != null && !ends.isEmpty()) {
					return Collections.singleton(object.getEnds().get(0));					
				}
				return Collections.emptyList();
			};
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				EList<ConnectorEnd> ends = object.getEnds();
				if (ends != null && !ends.isEmpty() && ends.size() > 0) {
					return Collections.singleton(object.getEnds().get(1));					
				}
				return Collections.emptyList();
			};
		});
	}

}