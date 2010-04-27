/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.resourceloading.umlprofile;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.ILoadingStrategyExtension;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The Class UMLProfileStrategyExtension that manages UML profile with the resource loading
 */
public class UMLProfileStrategyExtension implements ILoadingStrategyExtension {

	/**
	 * {@inheritDoc}
	 */
	public boolean loadResource(DiResourceSet diResourceSet, URI uri) {
		// TODO use type cache adapter
		boolean result = false;
		Resource modelResource = diResourceSet.getModelResource();
//		TypeCacheAdapter adapter = TypeCacheAdapter.getExistingtypeCacheAdapter(diResourceSet);
//		Collection<EObject> applications = adapter.getReachableObjectsOfType(null,UMLPackage.Literals.PROFILE_APPLICATION);
		if(modelResource.getContents().size() > 0) {
			EObject root = modelResource.getContents().get(0);
			if (root instanceof Package) {
				Package rootPackage = (Package)root;
				for (ProfileApplication profile : rootPackage.getProfileApplications()) {
					EObject proxy = (EObject)profile.eGet(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE,false);
					if (proxy != null && proxy.eIsProxy())
					{
						InternalEObject internal = (InternalEObject)proxy ;
						if (uri.trimFragment().equals(internal.eProxyURI()))
						{
							return true ;
						}
					}
				}
			}
		}
		return result;
	}

}
