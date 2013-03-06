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
package org.eclipse.papyrus.cdo.internal.ui.providers;

import static org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper.getPapyrusModelFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;
import org.eclipse.papyrus.cdo.internal.ui.util.CompositeLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * This is the ModelImportNodeLabelProvider type. Enjoy.
 */
public class ModelImportNodeLabelProvider
		implements ILabelProvider {

	private ILabelProvider delegate = new CompositeLabelProvider(
		new PapyrusElementLabelProvider(), new WorkbenchLabelProvider());

	public ModelImportNodeLabelProvider() {
		super();
	}

	public Image getImage(Object element) {
		Image result = null;
		IModelImportNode model = getModelImportNode(element);

		if (model != null) {
			result = delegate.getImage(getWorkbenchObject(model));
		}

		return result;
	}

	protected IModelImportNode getModelImportNode(Object element) {
		return (element instanceof IModelImportNode)
			? (IModelImportNode) element
			: null;
	}

	public String getText(Object element) {
		String result = null;
		IModelImportNode model = getModelImportNode(element);

		if (model != null) {
			result = delegate.getText(getWorkbenchObject(model));

			if (result == null) {
				result = model.getPrimaryResourceURI().trimFileExtension()
					.lastSegment();
			}
		}

		return result;
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void dispose() {
		delegate.dispose();
	}

	public void addListener(ILabelProviderListener listener) {
		delegate.addListener(listener);
	}

	public void removeListener(ILabelProviderListener listener) {
		delegate.removeListener(listener);
	}

	Object getWorkbenchObject(IModelImportNode element) {
		Object result = element;

		URI uri = element.getPrimaryResourceURI();
		if (uri.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(uri.toPlatformString(true)));

			if ((file != null) && getPapyrusModelFactory().isDi(file)) {
				result = getPapyrusModelFactory().createIPapyrusFile(file);
			} else {
				result = file;
			}
		}

		return result;
	}
}