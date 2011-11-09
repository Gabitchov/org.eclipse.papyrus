/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:tristan.faure@atos.net">Tristan FAURE</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.resources.refactoring.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.ui.ide.IDE;



/**
 * Default Implementation of {@link IScopeChooser}
 * 
 * @author tfaure
 */
public abstract class ScopeChooser implements IScopeChooser {

	private final String description;

	private final String label;

	public ScopeChooser(String label, String formDescription) {
		this.label = label;
		this.description = formDescription;

	}

	public String getName() {
		return label;
	}

	public String getDescription() {
		return description;
	}



	public static class ScopeChooserVisitor implements IResourceVisitor {

		private List<IFile> files = new LinkedList<IFile>();

		public boolean visit(IResource resource) throws CoreException {
			if(resource instanceof IFile) {
				IFile file = (IFile)resource;
				if(isXMI(file)) {
					files.add(file);
				}
				return false;
			}
			return true;
		}

		/**
		 * Determine if the given file is an XMI some specific code has been set for notation and di
		 * 
		 * @param f
		 * @return
		 */
		public boolean isXMI(IFile f) {
			URI uri = URI.createPlatformResourceURI(f.getFullPath().toString(), true);
			IContentType contentType = IDE.getContentType(f);
			Registry instance = Resource.Factory.Registry.INSTANCE;
			Object old = instance.getContentTypeToFactoryMap().get(Resource.Factory.Registry.DEFAULT_CONTENT_TYPE_IDENTIFIER);
			Object old2 = instance.getExtensionToFactoryMap().get(Resource.Factory.Registry.DEFAULT_EXTENSION);
			instance.getContentTypeToFactoryMap().put(Resource.Factory.Registry.DEFAULT_CONTENT_TYPE_IDENTIFIER, null);
			instance.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, null);
			boolean result = (f != null && contentType != null && (Resource.Factory.Registry.INSTANCE.getFactory(uri, contentType.getId()) != null || "notation".equals(f.getFileExtension()) || "di".equals(f.getFileExtension())));
			instance.getContentTypeToFactoryMap().put(Resource.Factory.Registry.DEFAULT_CONTENT_TYPE_IDENTIFIER, old);
			instance.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, old2);
			return result;
		}

		public List<IFile> getFiles() {
			return files;
		}

	}

}
