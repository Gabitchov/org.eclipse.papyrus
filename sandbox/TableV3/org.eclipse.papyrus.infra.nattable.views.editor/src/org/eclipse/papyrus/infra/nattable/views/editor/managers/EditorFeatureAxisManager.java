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
package org.eclipse.papyrus.infra.nattable.views.editor.managers;

import java.util.List;

import org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;

public class EditorFeatureAxisManager extends AbstractAxisManager {

	@Override
	public synchronized void updateAxisContents() {
		final List<Object> elements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current instanceof IdAxis) {
				final String id = (String)current.getElement();
				if(id.startsWith("nattable_editor_pages:/") && !elements.contains(id)) {
					elements.add(id);
				}
			}
		}
	}
}
