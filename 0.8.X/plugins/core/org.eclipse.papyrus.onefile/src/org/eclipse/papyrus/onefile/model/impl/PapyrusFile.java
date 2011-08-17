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
package org.eclipse.papyrus.onefile.model.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.onefile.utils.Utils;
import org.eclipse.swt.graphics.Image;

/**
 * Default Implementation of {@link IPapyrusFile}
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class PapyrusFile implements IPapyrusFile {

	private final IFile file;
	private final List<IFile> files = new LinkedList<IFile>();

	public PapyrusFile(IFile file) {
		this.file = file;
		try {
			for (IResource res : file.getParent().members()) {
				if (res instanceof IFile
						&& !Utils.isDi((IFile) res)
						&& Utils.withoutFileExtension(file).equals(
								Utils.withoutFileExtension(res))) {
					files.add((IFile) res);
				}
			}
		} catch (CoreException e) {
		}
	}

	public IFile getMainFile() {
		return file;
	}

	public IResource[] getAssociatedResources() {
		ArrayList<IResource> list = new ArrayList<IResource>(files.size() + 1);
		list.add(file);
		list.addAll(files);
		return list.toArray(new IResource[] {});
	}

	public String getLabel() {
		return file.getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PapyrusFile) {
			PapyrusFile papy = (PapyrusFile) obj;
			return getMainFile().equals(papy.getMainFile());
		}
		return super.equals(obj);
	}

	public IProject getProject() {
		return file.getProject();
	}

	public IContainer getParent() {
		return file.getParent();
	}

	public String getName() {
		return file.getName();
	}

	public String getText() {
		return getName().substring(0, getName().lastIndexOf('.'));
	}

	public Image getImage() {
		return PapyrusImageUtils.getDefaultIcon();
	}

}
