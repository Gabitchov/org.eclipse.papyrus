/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.tabbedproperties.appearance;

import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;

/**
 * Filter for the {@link SwitchSegmentDirectionSection} section
 */
public class SwitchSegmentDirectionSectionFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object object) {
		return object instanceof ForkNodeEditPart || object instanceof JoinNodeEditPart;
	}

}
