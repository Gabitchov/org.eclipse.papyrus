/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.providers;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.messages.Messages;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;

/**
 * A label provider for EMF {@link Resource}s.
 */
public class ResourceFilteredLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	private ResourceManager images;

	public boolean accept(Object element) {
		return element instanceof Resource;
	}

	@Override
	public void dispose() {
		if(images != null) {
			images.dispose();
			images = null;
		}

		super.dispose();
	}

	@Override
	public String getText(Object element) {
		return (element instanceof Resource) ? getText((Resource)element) : super.getText(element);
	}

	protected String getText(Resource resource) {
		String result;

		URI uri = resource.getURI();

		if(uri.isPlatformResource()) {
			String ext = uri.fileExtension();
			if(ext == null) {
				result = NLS.bind(Messages.ResourceFilteredLabelProvider_workspace, uri.toPlatformString(true));
			} else {
				result = NLS.bind(Messages.ResourceFilteredLabelProvider_workspaceExt, uri.toPlatformString(true), uri.fileExtension());
			}
		} else if(uri.isFile()) {
			String ext = uri.fileExtension();
			if(ext == null) {
				result = NLS.bind(Messages.ResourceFilteredLabelProvider_local, uri.toFileString());
			} else {
				result = NLS.bind(Messages.ResourceFilteredLabelProvider_localExt, uri.toFileString(), uri.fileExtension());
			}
		} else if(uri.isHierarchical()) {
			result = NLS.bind(Messages.ResourceFilteredLabelProvider_system, uri.lastSegment());
		} else {
			result = NLS.bind(Messages.ResourceFilteredLabelProvider_systemExt, uri.toString());
		}

		return result;
	}

	@Override
	public Image getImage(Object element) {
		return (element instanceof Resource) ? getImage((Resource)element) : super.getImage(element);
	}

	protected Image getImage(Resource resource) {
		URI uri = resource.getURI();
		URIConverter converter = (resource.getResourceSet() == null) ? URIConverter.INSTANCE : resource.getResourceSet().getURIConverter();

		IContentType contentType = null;
		try {
			Map<String, ?> description = converter.contentDescription(uri, null);
			contentType = (description.get(ContentHandler.CONTENT_TYPE_PROPERTY) == null) ? null : Platform.getContentTypeManager().getContentType((String)description.get(ContentHandler.CONTENT_TYPE_PROPERTY));
		} catch (IOException e) {
			Activator.log.error(e);
		}

		IEditorDescriptor[] editors;
		if(contentType != null) {
			editors = PlatformUI.getWorkbench().getEditorRegistry().getEditors(uri.lastSegment(), contentType);
		} else {
			editors = PlatformUI.getWorkbench().getEditorRegistry().getEditors(uri.lastSegment());
		}

		ImageDescriptor result = null;
		for(int i = 0; (result == null) && (i < editors.length); i++) {
			result = editors[0].getImageDescriptor();
		}

		return convert(result);
	}

	protected Image convert(ImageDescriptor descriptor) {
		Image result = null;

		if(descriptor != null) {
			if(images == null) {
				images = new LocalResourceManager(JFaceResources.getResources());
			}

			result = (Image)images.get(descriptor);
		}

		return result;
	}
}
