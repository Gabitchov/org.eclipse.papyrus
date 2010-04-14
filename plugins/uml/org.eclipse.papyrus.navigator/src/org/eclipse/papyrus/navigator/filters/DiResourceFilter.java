/*******************************************************************************
 * Copyright (c) 2009 Atos Origin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos Origin - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.filters;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * Filter that hides/shows the di/uml/notation.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
public class DiResourceFilter extends ViewerFilter {

	/**
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof IFile) {
			IFile file = ((IFile)element);
			String ext = file.getFileExtension();
			if(DiResourceSet.NOTATION_FILE_EXTENSION.equalsIgnoreCase(ext)) {
				// Let see if the .di exists
				String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
				if(file.getParent().findMember(name + "." + DiResourceSet.DI_FILE_EXTENSION) != null) {
					return false;
				}
			}
		}
		return true;
	}
}
