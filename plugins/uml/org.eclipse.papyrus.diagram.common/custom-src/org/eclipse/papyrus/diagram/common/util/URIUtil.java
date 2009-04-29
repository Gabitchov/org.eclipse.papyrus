/**
 * Copyright (c) 2006, 2007 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;

/**
 * @author dstadnik
 */
public class URIUtil {

	private URIUtil() {
	}

	public static IFile getFile(URI uri) {
		String fileName = uri.toFileString();
		if (fileName != null) {
			return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					new Path(fileName));
		}
		if (uri.toString().startsWith("platform:/resource")) { //$NON-NLS-1$
			String path = uri.toString().substring(
					"platform:/resource".length()); //$NON-NLS-1$
			IResource workspaceResource = ResourcesPlugin.getWorkspace()
					.getRoot().findMember(new Path(path));
			if (workspaceResource instanceof IFile) {
				return (IFile) workspaceResource;
			}
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param input
	 * @return
	 */
	public static URI getUri(IEditorInput input) {
		return getUri(input, null);
	}

	/**
	 * 
	 * 
	 * @param input
	 * @return
	 */
	public static URI getUri(IEditorInput input, String editorID) {
		String uriString = null;
		if (input instanceof URIEditorInput) {
			uriString = PathsUtil
					.getRelativeWorkspaceFromEditorInputWithFragment(input);
		} else {
			uriString = PathsUtil.getRelativeWorkspaceFromEditorInput(input);
			String fragment = MDTUtil.getLastOpenedDiagramPropertyForEditor(
					uriString, editorID);
			if (fragment != null) {
				uriString = URI.createURI(uriString).appendFragment(fragment)
						.toString();
			}
		}
		if (input != null) {
			URI uri = URI.createURI(uriString);
			if (uri.hasFragment()) {
				return uri;
			}
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new XMIResourceFactoryImpl());
			Resource resource = resourceSet.getResource(uri, true);
			Diagram diagram = MDTUtil.getFirstDiagramFromResource(resource);
			if (diagram != null) {
				String fragment = resource.getURIFragment(diagram);
				uri = uri.appendFragment(fragment);
			}
			return uri;
		}
		return null;
	}
}
