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
package org.eclipse.papyrus.customization.properties.storage.actions.workspace;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.customization.properties.storage.actions.AbstractContextStorageActionProvider;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextDeleteAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextEditAction;
import org.eclipse.papyrus.views.properties.contexts.Context;


/**
 * This is the WorkspaceContextStorageActionProvider type. Enjoy.
 */
public class WorkspaceContextStorageActionProvider extends AbstractContextStorageActionProvider {

	public WorkspaceContextStorageActionProvider() {
		super();
	}

	public boolean providesFor(Context context) {
		Resource resource = context.eResource();
		return (resource != null) && resource.getURI().isPlatformResource() || resource.getURI().isFile();
	}

	protected IContextCopyAction createContextCopyAction() {
		return new WorkspaceContextCopyAction();
	}

	protected IContextEditAction createContextEditAction() {
		return new WorkspaceContextEditAction();
	}

	protected IContextDeleteAction createContextDeleteAction() {
		return new WorkspaceContextDeleteAction();
	}

}
