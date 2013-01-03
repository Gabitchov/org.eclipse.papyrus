/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.helper;

import java.util.Collection;

import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;

/**
 * Specialization of the link mapping helper for the timing diagram
 */
public class TimingDiagramLinkMappingHelper implements ILinkMappingHelper {

	private static TimingDiagramLinkMappingHelper INSTANCE;

	/**
	 * Gets the single instance of {@link TimingDiagramLinkMappingHelper}.
	 * 
	 * @return single instance of {@link TimingDiagramLinkMappingHelper}
	 */
	public static TimingDiagramLinkMappingHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TimingDiagramLinkMappingHelper();
		}
		return INSTANCE;
	}

	private TimingDiagramLinkMappingHelper() {
		// singleton helper
	}

	public Collection<?> getSource(final Element link) {
		// TODO: define source link mapping
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {
			// @Override
			// public Collection<?> caseGeneralOrdering(final GeneralOrdering object) {
			// return Collections.singleton(object.getBefore());
			// }
		});
	}

	public Collection<?> getTarget(final Element link) {
		// TODO: define target link mapping
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {
			// @Override
			// public Collection<?> caseGeneralOrdering(final GeneralOrdering object) {
			// return Collections.singleton(object.getAfter());
			// }
		});
	}
}
