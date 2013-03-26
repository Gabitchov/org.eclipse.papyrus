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
package org.eclipse.papyrus.customization.properties.editor;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;


/**
 * A non-persistable editor input that is used to open an editor on a {@link Resource} that
 * has already been loaded in a {@link ResourceSet}.
 */
public class ResourceEditorInput extends URIEditorInput {

	private final Resource resource;

	private String name;

	public ResourceEditorInput(Resource resource) {
		this(resource, null);
	}

	public ResourceEditorInput(Resource resource, String name) {
		super(resource.getURI(), name);

		this.resource = resource;
		this.name = name;
	}

	public final Resource getResource() {
		return resource;
	}

	public boolean exists() {
		ResourceSet rset = resource.getResourceSet();

		// if the resource isn't in a resource set, assume that it cannot be properly
		// loaded/saved from persistent storage and, therefore, it doesn't exist
		return (rset != null) && rset.getURIConverter().exists(resource.getURI(), null);
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		if(name == null) {
			name = resource.getURI().lastSegment();
		}

		return name;
	}

	/**
	 * Unlike the superclass, I am not persistable because a {@link Resource} is a transient
	 * object.
	 * 
	 * @return {@code false}
	 */
	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return resource.getURI().toString();
	}

}
