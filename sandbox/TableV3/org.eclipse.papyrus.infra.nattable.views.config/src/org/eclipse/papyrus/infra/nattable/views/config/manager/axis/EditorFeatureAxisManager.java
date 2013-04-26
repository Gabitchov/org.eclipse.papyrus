/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.views.config.manager.axis;

import java.util.List;

import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;

/**
 * The feature axis content provider for the ModelViews table
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorFeatureAxisManager extends AbstractAxisManager {

	@Override
	public synchronized void updateAxisContents() {
		final List<Object> elements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current instanceof IdAxis) {
				final String id = (String)current.getElement();
				if(id.startsWith(Utils.NATTABLE_EDITOR_PAGE_ID) && !elements.contains(id)) {
					elements.add(id);
				}
			}
		}
	}
}
