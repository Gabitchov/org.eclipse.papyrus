/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.helpers;

import java.util.Collection;

import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * This helper is used to retrieve Link ends for use in drag and drop behavior.
 */
public class ComponentLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * Singleton management.
	 */
	private static class SingletonHolder {

		/** Singleton instance. */
		private final static ComponentLinkMappingHelper instance = new ComponentLinkMappingHelper();
	}

	/**
	 * Get singleton instance.
	 *
	 * @return the instance
	 */
	public static ComponentLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor.
	 */
	private ComponentLinkMappingHelper() {
		// do nothing
	}

	/**
	 * Gets the source.
	 *
	 * @param link the link
	 * @return the source
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			@Override
			public java.util.Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getSources();
			};

			@Override
			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				return object.getEnds();
			};
		});
	}

	/**
	 * Gets the target.
	 *
	 * @param link the link
	 * @return the target
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			@Override
			public java.util.Collection<?> caseDependency(org.eclipse.uml2.uml.Dependency object) {
				return object.getTargets();
			};

			@Override
			public java.util.Collection<?> caseConnector(org.eclipse.uml2.uml.Connector object) {
				return object.getEnds();
			};
		});
	}

}
