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
package org.eclipse.papyrus.diagram.usecase.helper;

import java.util.Collection;

import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;

/**
 * Specialization of the link mapping helper for the Use Case diagram
 * 
 * @author eperico
 */
public class UseCaseLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static UseCaseLinkMappingHelper instance = new UseCaseLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static UseCaseLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private UseCaseLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			public java.util.Collection<?> caseInclude(org.eclipse.uml2.uml.Include object) {
				return object.getSources();
			};

			public java.util.Collection<?> caseExtend(org.eclipse.uml2.uml.Extend object) {
				return object.getSources();
			};
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			public java.util.Collection<?> caseInclude(org.eclipse.uml2.uml.Include object) {
				return object.getTargets();
			};

			public java.util.Collection<?> caseExtend(org.eclipse.uml2.uml.Extend object) {
				return object.getTargets();
			};
		});
	}

}
