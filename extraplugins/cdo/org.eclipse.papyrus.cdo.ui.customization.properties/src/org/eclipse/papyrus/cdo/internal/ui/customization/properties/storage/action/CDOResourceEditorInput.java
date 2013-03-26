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
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.action;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.customization.properties.editor.ResourceEditorInput;


/**
 * This is the CDOResourceEditorInput type. Enjoy.
 */
public class CDOResourceEditorInput extends ResourceEditorInput {

	public CDOResourceEditorInput(Resource resource) {
		super(resource);
	}

	public CDOResourceEditorInput(Resource resource, String name) {
		super(resource, name);
	}

	@Override
	public String getToolTipText() {
		String result;

		if(getResource() instanceof CDOResourceNode) {
			// a more user-friendly representation than the URI
			result = ((CDOResourceNode)getResource()).getPath();
		} else {
			result = super.getToolTipText();
		}

		return result;
	}
}
