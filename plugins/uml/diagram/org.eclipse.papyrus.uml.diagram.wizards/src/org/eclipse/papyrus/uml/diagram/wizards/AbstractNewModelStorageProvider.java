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
package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Partial implementation of the {@link INewModelStorageProvider} protocol.
 */
public abstract class AbstractNewModelStorageProvider
		implements INewModelStorageProvider {

	public void init(CreateModelWizard wizard, IStructuredSelection selection) {
		// pass
	}

	public IStatus validateDiagramCategories(String... newCategories) {
		return Status.OK_STATUS;
	}

	/**
	 * Creates an {@link IFileEditorInput} for workspace resource URIs, or an
	 * {@link URIEditorInput} otherwise.
	 */
	public IEditorInput createEditorInput(URI uri) {
		if (uri.isPlatformResource()) {
			return new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(uri.toPlatformString(true))));
		} else {
			return new URIEditorInput(uri);
		}
	}

	public ISelectProviderPart createSelectProviderPart() {
		return null;
	}
}
