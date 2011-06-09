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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.helper;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ObjectFlow;

/**
 * Specialization of the link mapping helper for the Activity diagram
 */
public class ActivityLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static ActivityLinkMappingHelper instance = new ActivityLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static ActivityLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private ActivityLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			public Collection<?> caseActivityEdge(ActivityEdge object) {
				return Collections.singleton(object.getSource());
			}

			public Collection<?> caseObjectFlow(ObjectFlow object) {
				return caseActivityEdge(object);
			}

			public Collection<?> caseControlFlow(ControlFlow object) {
				return caseActivityEdge(object);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			public Collection<?> caseActivityEdge(ActivityEdge object) {
				return Collections.singleton(object.getTarget());
			}

			public Collection<?> caseObjectFlow(ObjectFlow object) {
				return caseActivityEdge(object);
			}

			public Collection<?> caseControlFlow(ControlFlow object) {
				return caseActivityEdge(object);
			}
		});
	}

}
