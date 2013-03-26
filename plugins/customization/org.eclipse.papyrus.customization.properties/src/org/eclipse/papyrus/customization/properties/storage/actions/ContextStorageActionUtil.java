/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factored out some methods from existing code for reuse (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.storage.actions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;


/**
 * Utility operations useful in the construction of context storage actions, especially copy.
 */
public class ContextStorageActionUtil {

	// not instantiable by clients
	private ContextStorageActionUtil() {
		super();
	}

	public static void initializeCopy(Context source, IProgressMonitor monitor) {
		monitor.beginTask(Messages.CopyContextAction_InitializingTheCopyOf + source.getName() + Messages.CopyContextAction_ThisMayTakeSomeTime, IProgressMonitor.UNKNOWN);
		//EcoreUtil.resolveAll(source); //This method is too expensive
		resolveAllResources(source); //Ignores the *.xwt files. We will copy them manually.
		monitor.done();
	}

	/**
	 * Lightweight method for loading a resource set
	 * This method ignores the *.xwt files, which do not contain any useful
	 * cross-reference (As they can only reference Environment files), and are
	 * really expensive to load.
	 */
	private static void resolveAllResources(Context source) {
		resolveAllResources(source, new HashSet<EObject>());
	}

	/**
	 * Lightweight method for loading a resource set
	 * This method ignores the *.xwt files, which do not contain any useful
	 * cross-reference (As they can only reference Environment files), and are
	 * really expensive to load.
	 */
	private static void resolveAllResources(EObject source, Set<EObject> visitedEObjects) {
		if(!visitedEObjects.add(source)) {
			return;
		}

		for(EReference reference : source.eClass().getEAllReferences()) {
			//Do not load *.xwt resources
			//These files do not contain any useful cross-reference, and are really expensive to load
			if(reference == ContextsPackage.eINSTANCE.getSection_Widget()) {
				continue;
			}

			Object value = source.eGet(reference);
			if(value instanceof EList) {
				for(Object object : (EList<?>)value) {
					if(object instanceof EObject) {
						resolveAllResources((EObject)object, visitedEObjects);
					}
				}
			} else if(value instanceof EObject) {
				resolveAllResources((EObject)value, visitedEObjects);
			}
		}
	}

	public static boolean isRelative(Resource base, Resource resource) {
		URI baseURI = base.getURI();
		URI resourceURI = resource.getURI();
		URI uri = resourceURI.deresolve(baseURI);
		if(uri.isRelative()) {
			if(!(uri.toString().startsWith("..") || uri.toString().startsWith("/"))) { //$NON-NLS-1$ //$NON-NLS-2$
				return true;
			}
		}
		return false;
	}

}
