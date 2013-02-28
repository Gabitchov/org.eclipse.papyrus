/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

/**
 * Default implementation of {@link ISubResourceFile}
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class SubResourceFile implements ISubResourceFile {

	private IPapyrusFile parent;

	private final IFile subResource;

	public SubResourceFile(IPapyrusFile papy, IFile r) {
		this.parent = papy;
		this.subResource = r;

	}

	public IProject getProject() {
		return subResource.getProject();
	}

	@Override
	public String toString() {
		String fileExtension = subResource.getFileExtension();
		return fileExtension != null ? fileExtension : subResource.getName();
	}

	public IFile getFile() {
		return subResource;
	}

	public Image getImage() {
		Image image = JFaceResources.getImage(getFile().getFileExtension());
		if(image == null) {
			ImageDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(getFile().getName());
			JFaceResources.getImageRegistry().put(getFile().getFileExtension(), desc);
		}
		return JFaceResources.getImage(getFile().getFileExtension());
	}

	public String getText() {
		return toString();
	}

	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	public IPapyrusFile getParent() {
		return parent;
	}

}
