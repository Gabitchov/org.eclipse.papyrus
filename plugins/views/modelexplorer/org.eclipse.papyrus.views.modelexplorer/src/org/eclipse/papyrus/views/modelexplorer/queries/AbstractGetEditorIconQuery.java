/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistryExtended;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;

/**
 *
 * An abstract class to get the iconRegistery
 *
 */
public abstract class AbstractGetEditorIconQuery {//we don't need to implements IJavaModelQuery  here

	/**
	 * the icon registry
	 */
	private static IPageIconsRegistry editorRegistry;

	/**
	 * Get the EditorRegistry used to create editor instances. This default
	 * implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 *
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected IPageIconsRegistryExtended getEditorRegistry(EObject context) {
		try {
			return (IPageIconsRegistryExtended)ServiceUtilsForEObject.getInstance().getService(IPageIconsRegistry.class, context);
		} catch (Exception ex) {
			//Skip
		}
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry(context);
		}
		if(!(editorRegistry instanceof IPageIconsRegistryExtended)) {
			throw new RuntimeException("The editor registry do not implement IPageIconsRegistryExtended");////$NON-NLS-1$
		}
		return (IPageIconsRegistryExtended)editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 *
	 * @return the EditorRegistry for nested editor descriptors
	 */
	protected IPageIconsRegistry createEditorRegistry(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getService(IPageIconsRegistry.class, context);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}
}
