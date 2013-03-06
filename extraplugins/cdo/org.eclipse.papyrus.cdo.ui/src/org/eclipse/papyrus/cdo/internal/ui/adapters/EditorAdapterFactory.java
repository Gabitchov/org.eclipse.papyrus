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
package org.eclipse.papyrus.cdo.internal.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.papyrus.cdo.internal.ui.editors.DawnEditorAdapter;
import org.eclipse.ui.IEditorPart;

/**
 * This is the EditorAdapterFactory type. Enjoy.
 */
@SuppressWarnings("rawtypes")
public class EditorAdapterFactory
		implements IAdapterFactory {

	private final Class[] supported = {IDawnEditor.class};

	public EditorAdapterFactory() {
		super();
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		Object result = null;

		if (adapterType == IDawnEditor.class) {
			if (adaptableObject instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) adaptableObject;

				result = DawnEditorAdapter.getDawnEditor(editor);
			}
		}

		return result;
	}

	public Class[] getAdapterList() {
		return supported;
	}

}
