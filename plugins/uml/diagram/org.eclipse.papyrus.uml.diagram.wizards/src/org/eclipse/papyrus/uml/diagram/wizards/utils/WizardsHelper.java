/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * The Class WizardsHelper.
 */
public class WizardsHelper {

	/**
	 * Gets the file name without extension.
	 * 
	 * @param path
	 *        the path of the file
	 * @return the file name without extension
	 */
	public static String getFileNameWithoutExtension(String path) {
		if(path != null) {
			String[] pathParts = path.split("/"); //$NON-NLS-1$
			String fileName = pathParts[pathParts.length - 1];
			int index = fileName.lastIndexOf('.');
			if(index > 0 && index <= fileName.length() - 2) {
				// System.out.println("Filename without Extension: "
				// + fileName.substring(0, index));
				return fileName.substring(0, index);
			}
		}
		return null;
	}

	public static <T> T adapt(Object obj, Class<T> type) {
		T result = null;

		if(type.isInstance(obj)) {
			result = type.cast(obj);
		} else if(obj instanceof IAdaptable) {
			Object adapter = ((IAdaptable)obj).getAdapter(type);
			if(type.isInstance(adapter)) {
				result = type.cast(adapter);
			}
		}

		return result;
	}

	/**
	 * Returns the first file from the given selection.
	 * 
	 * @param selection
	 *        the selection
	 * @return the selected file
	 */
	public static IFile getSelectedFile(IStructuredSelection selection) {
		if((selection != null) && !selection.isEmpty()) {
			return adapt(selection.getFirstElement(), IFile.class);
		}
		return null;
	}

	/**
	 * Returns the URI of the first resource or file from the given selection.
	 * 
	 * @param selection
	 *        the selection
	 * @return the URI of the selected resource
	 */
	public static URI getSelectedResourceURI(IStructuredSelection selection) {
		if((selection != null) && !selection.isEmpty()) {
			IFile file = adapt(selection.getFirstElement(), IFile.class);
			if(file != null) {
				return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			}

			//FIXME: See bug 404922. Disable the resource resolution support until the wizard forces the target folder for the di model.

			//			Resource resource = adapt(selection.getFirstElement(), Resource.class);
			//			if(resource == null) {
			//				EObject object = adapt(selection.getFirstElement(), EObject.class);
			//				if(object != null) {
			//					resource = object.eResource();
			//				}
			//			}
			//
			//			if(resource != null) {
			//				return resource.getURI();
			//			}
		}
		return null;
	}
}
