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
package org.eclipse.papyrus.uml.resourceloading.profile;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.modelsetquery.IFillableModelSetQueryAdapter;
import org.eclipse.papyrus.infra.core.modelsetquery.IModelSetQueryAdapter;
import org.eclipse.papyrus.infra.core.modelsetquery.impl.ModelSetQueryInitializer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategyExtension;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;


/**
 * The Class UMLProfileStrategyExtension that manages UML profile with the resource loading
 */
public class UMLProfileStrategyExtension implements ILoadingStrategyExtension {

	/**
	 * {@inheritDoc} Load a profile resource if it used in the model
	 */
	public boolean loadResource(ModelSet modelSet, URI uri) {
		Resource modelResource = UmlUtils.getUmlModel(modelSet).getResource();
		if(modelResource != null && UMLResource.FILE_EXTENSION.equals(modelResource.getURI().fileExtension())) {
			IFillableModelSetQueryAdapter adapter = null;
			for(Adapter a : modelSet.eAdapters()) {
				if(a instanceof IFillableModelSetQueryAdapter) {
					adapter = (IFillableModelSetQueryAdapter)a;
					break;
				}
			}
			if(adapter == null) {
				IModelSetQueryAdapter anAdapter = ModelSetQueryInitializer.createDefaultIModelSetQueryAdapter();
				if (anAdapter instanceof IFillableModelSetQueryAdapter) {
					modelSet.eAdapters().add((Adapter) anAdapter);
				}
			}
			if(!modelResource.getContents().isEmpty()) {
				if(adapter != null) {
					Collection<EObject> applications = null;
					if(!adapter.isAlreadyComputed(UMLPackage.Literals.PROFILE_APPLICATION)) {
						// set the profile applications in the cache at the first time
						applications = new HashSet<EObject>();
						// a profile application can only be stored in a package
						for(int i = 0; i < modelSet.getResources().size(); i++) {
							for(TreeIterator<EObject> j = EcoreUtil.getAllProperContents(modelSet.getResources().get(i), false); j.hasNext();) {
								EObject e = j.next();
								if(e instanceof Package) {
									applications.addAll(((Package)e).getProfileApplications());
								} else {
									j.prune();
								}
							}
						}
						adapter.addEntriesInCache(UMLPackage.Literals.PROFILE_APPLICATION, (HashSet<EObject>)applications);
					} else {
						// get the profile applications in the cache
						applications = adapter.getReachableObjectsOfType(modelResource.getContents().get(0), UMLPackage.Literals.PROFILE_APPLICATION);
					}
					if(applications != null) {
						// compare profile applications with the specified uri
						for(EObject profileApp : applications) {
							EObject profile = (EObject)profileApp.eGet(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE, false);
							if(profile != null) {
								URI trimFragment = uri.trimFragment();
								if(profile.eIsProxy()) {
									InternalEObject internal = (InternalEObject)profile;
									if(trimFragment.equals(internal.eProxyURI().trimFragment())) {
										return true;
									}
								} else if(profile instanceof Profile) {
									if(trimFragment.equals(((Profile)profile).eResource().getURI().trimFragment())) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

}
