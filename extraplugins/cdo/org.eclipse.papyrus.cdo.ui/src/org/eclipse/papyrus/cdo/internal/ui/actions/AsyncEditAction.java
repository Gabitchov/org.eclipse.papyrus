/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.actions;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;

/**
 * This is the AsyncEditAction type. Enjoy.
 */
public abstract class AsyncEditAction<T> extends AsyncTransactionAction<T> {

	public AsyncEditAction(Class<? extends T> type, String text, String icon) {
		super(type, text, icon);
	}

	public AsyncEditAction(Class<? extends T> type, String text, ImageDescriptor icon) {
		super(type, text, icon);
	}

	@Override
	protected boolean updateSelection(org.eclipse.jface.viewers.IStructuredSelection selection) {
		boolean result = super.updateSelection(selection);

		if(result) {
			CDOObject cdoObject = getSelectedCDOObject();

			if((cdoObject == null) || CDOUtils.isReadOnly(cdoObject)) {
				result = false;
			}
		}

		return result;
	}

	protected CDOObject getSelectedCDOObject() {
		Object selection = getSelection();

		return CDOUtils.adapt(selection, CDOObject.class);
	}
}
