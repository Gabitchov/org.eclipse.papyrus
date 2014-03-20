/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.util;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @since 0.3
 */
public final class EditingUtil {

	private EditingUtil() {
		// Hidden constructor.
	}

	/**
	 * Return the current editing domain.
	 * 
	 * @return the current editing domain.
	 */
	public static EditingDomain getEditingDomain() {
		// Retrieve the editor
		final IWorkbenchPart editor = PlatformUI.getWorkbench()
				.getWorkbenchWindows()[0].getPages()[0].getActivePart();
		// Retrieve the editing domain
		final IEditingDomainProvider edProvider = (IEditingDomainProvider) editor
				.getAdapter(IEditingDomainProvider.class);
		EditingDomain editingDomain = null;
		if (edProvider != null) {
			editingDomain = edProvider.getEditingDomain();
		}
		return editingDomain;
	}

	/**
	 * Create and return a new {@link Resource}.
	 * 
	 * @return the new {@link Resource}.
	 */
	public static Resource createDefaultResource(final File file) {
		return getEditingDomain().getResourceSet().createResource(
				URI.createFileURI(file.getPath()));
	}
}
