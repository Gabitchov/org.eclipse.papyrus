/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.wizard.widget;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class ExtensionFilter extends ViewerFilter {

	private Set<String> extensions;

	public ExtensionFilter(String[] extensions) {
		this.extensions = new HashSet<String>(Arrays.asList(extensions));
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof IFile) {
			IFile file = (IFile)element;
			for(String ext : extensions) {
				if(file.getFullPath().toString().endsWith(ext)) {
					return true;
				}
			}
		} else if(element instanceof IProject || element instanceof IFolder) {
			return true;
		}

		return false;
	}

}
