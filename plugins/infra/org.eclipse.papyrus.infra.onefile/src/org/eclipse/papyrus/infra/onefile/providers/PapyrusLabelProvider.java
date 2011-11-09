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
package org.eclipse.papyrus.infra.onefile.providers;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.swt.graphics.Image;

/**
 * Label Provider for Papyrus Model Elements
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class PapyrusLabelProvider implements ILabelProvider {

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	public Image getImage(Object element) {
		if (element instanceof IPapyrusFile) {
			IPapyrusFile papyFile = (IPapyrusFile) element;
			return papyFile.getImage();
		}
		if (element instanceof ISubResourceFile) {
			return ((ISubResourceFile) element).getImage();
		}
		return null;
	}

	public String getText(Object element) {
		if (element instanceof IPapyrusFile) {
			IPapyrusFile papyFile = (IPapyrusFile) element;
			return papyFile.getText();
		}
		if (element instanceof ISubResourceFile) {
			return ((ISubResourceFile) element).getText();
		}
		if (element instanceof IResource) {
			return ((IResource) element).getName();
		}
		return null;
	}

}
