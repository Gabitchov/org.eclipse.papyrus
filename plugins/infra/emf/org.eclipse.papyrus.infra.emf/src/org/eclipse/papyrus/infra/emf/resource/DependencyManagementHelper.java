/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A Helper to edit dependencies (URIs) between EMF Resources
 * 
 * It replaces all references from a Resource A to a Resource B with references from A to B'
 * 
 * B and B' must be "equivalent" (e.g. B is a copy of B' with or without modifications).
 * 
 * @author Camille Letavernier
 * 
 */
public class DependencyManagementHelper {

	/**
	 * Replaces all references (dependencies) in the "fromResources" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: fromResources.replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 *        Must not be null
	 * @param fromResources
	 *        The list of resources to edit. Only the objects of these resources will be modified.
	 *        Must not be empty
	 * @param editingDomain
	 *        The editing domain. May be null.
	 * 
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, Collection<Resource> fromResources, EditingDomain editingDomain) {
		if(fromResources == null || fromResources.isEmpty()) {
			throw new IllegalArgumentException("There is no resource to modify"); //$NON-NLS-1$
		}

		Collection<Replacement> replacements = new LinkedList<Replacement>();

		for(Resource currentResource : fromResources) {
			if(currentResource == null) {
				continue;
			}

			if(EMFHelper.isReadOnly(currentResource, editingDomain)) {
				continue;
			}

			replacements.addAll(updateDependencies(uriToReplace, targetURI, currentResource, editingDomain));
		}

		return replacements;
	}

	/**
	 * Replaces all references (dependencies) in the "fromResources" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: fromResources.replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 *        Must not be null
	 * @param fromResource
	 *        The resource to edit. Only the objects of this resource will be modified.
	 *        Must not be null
	 * @param editingDomain
	 *        The editing domain. May be null.
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, Resource fromResource, EditingDomain editingDomain) {
		if(uriToReplace == null) {
			throw new IllegalArgumentException("There is no URI to replace"); //$NON-NLS-1$
		}

		if(targetURI == null) {
			throw new IllegalArgumentException("There is no target URI"); //$NON-NLS-1$
		}

		if(uriToReplace.equals(targetURI)) {
			throw new IllegalArgumentException("The source and target URIs are identical"); //$NON-NLS-1$
		}

		if(fromResource == null) {
			throw new IllegalArgumentException("The edited resource must not be null"); //$NON-NLS-1$
		}

		Iterator<EObject> allContentsIterator = fromResource.getAllContents();

		Collection<Replacement> replacements = new LinkedList<Replacement>();

		while(allContentsIterator.hasNext()) {
			EObject eObject = allContentsIterator.next();

			for(EReference reference : eObject.eClass().getEAllReferences()) {
				if(reference.isContainment()) {
					continue;
				}

				if(!reference.isChangeable()) {
					continue;
				}

				Object value = eObject.eGet(reference);
				if(value instanceof EObject) {
					EObject eObjectToReplace = (EObject)value;

					EObject newEObject = checkAndReplace(eObjectToReplace, uriToReplace, targetURI);
					if(newEObject == null) {
						continue;
					}

					try {
						//System.out.println("Replace " + EcoreUtil.getURI(eObjectToReplace) + " with " + EcoreUtil.getURI(newEObject));
						eObject.eSet(reference, newEObject);
						replacements.add(new ReplacementImpl(eObject, reference, eObjectToReplace, newEObject));
					} catch (Exception ex) {
						Activator.log.error(ex);
					}

				} else if(value instanceof Collection<?>) {
					Map<EObject, EObject> previousToNewValue = new HashMap<EObject, EObject>();

					Collection<?> collection = (Collection<?>)value;

					for(Object collectionElement : (Collection<?>)value) {
						if(collectionElement instanceof EObject) {
							EObject eObjectToReplace = (EObject)collectionElement;
							EObject newEObject = checkAndReplace(eObjectToReplace, uriToReplace, targetURI);
							if(newEObject == null) {
								continue;
							}

							//System.out.println("Replace " + EcoreUtil.getURI(eObjectToReplace) + " with " + EcoreUtil.getURI(newEObject));
							previousToNewValue.put(eObjectToReplace, newEObject);
						}
					}

					if(previousToNewValue.isEmpty()) {
						continue;
					}

					if(collection instanceof EStructuralFeature.Setting) {
						EStructuralFeature.Setting setting = (EStructuralFeature.Setting)collection;
						for(Map.Entry<EObject, EObject> entry : previousToNewValue.entrySet()) {
							EcoreUtil.replace(setting, entry.getKey(), entry.getValue());
							replacements.add(new ReplacementImpl(eObject, reference, entry.getKey(), entry.getValue()));
						}
					}
				}
			}
		}

		return replacements;
	}

	/**
	 * Replaces the EObject (Which may be a proxy) by its equivalent in the given Resource's URI.
	 * Returns null if the "currentValueToReplace" doesn't belong to the resource represented by "uriToReplace".
	 * 
	 * @param currentValueToReplace
	 *        The current value, to be replaced. May be a proxy
	 * @param uriToReplace
	 *        The URI of the resource to be replaced.
	 * @param targetURI
	 *        The URI of the target resource (Which will contain the resulting EObject).
	 *        The resource doesn't need to exist (and won't be created). If it doesn't exist, this method will return a Proxy
	 * @return
	 *         The EObject equivalent to the replaced EObject, in the target resource.
	 */
	private static EObject checkAndReplace(EObject currentValueToReplace, URI uriToReplace, URI targetURI) {
		URI eObjectURIToReplace = EcoreUtil.getURI(currentValueToReplace);
		URI resourceURI = eObjectURIToReplace.trimFragment();

		if(!uriToReplace.equals(resourceURI)) {
			return null;
		}

		return replace(currentValueToReplace, targetURI);
	}

	/**
	 * Replaces the EObject (Which may be a proxy) by its equivalent in the given Resource's URI.
	 * 
	 * @param currentValueToReplace
	 *        The current value, to be replaced. May be a proxy
	 * @param targetURI
	 *        The URI of the target resource (Which will contain the resulting EObject).
	 *        The resource doesn't need to exist (and won't be created). If it doesn't exist, this method will return a Proxy
	 * @return
	 *         The EObject equivalent to the replaced EObject, in the target resource.
	 */
	public static EObject replace(EObject currentValueToReplace, URI targetURI) {
		URI eObjectURIToReplace = EcoreUtil.getURI(currentValueToReplace);

		EClass targetEClass = currentValueToReplace.eClass();

		InternalEObject proxyEObject;

		//Try to instantiate the Proxy from the same EClass.
		EObject newEObject = targetEClass.getEPackage().getEFactoryInstance().create(targetEClass);
		if(newEObject instanceof InternalEObject) {
			proxyEObject = (InternalEObject)newEObject;
		} else {
			//If the result is not an InternalEObject, create a basic EObject instead
			proxyEObject = new DynamicEObjectImpl(targetEClass);
		}

		String eObjectFragment = eObjectURIToReplace.fragment();
		URI eObjectURI = targetURI.appendFragment(eObjectFragment);
		proxyEObject.eSetProxyURI(eObjectURI);

		return proxyEObject;
	}

	/**
	 * Replaces all references (dependencies) in the "resourceSet" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: resourceSet.getResources().replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 *        Must not be null
	 * @param resourceSet
	 *        The resourceSet to edit. Its resources will be modified.
	 * @param editingDomain
	 *        The editing domain. May be null.
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, ResourceSet resourceSet, EditingDomain editingDomain) {
		Set<Resource> resourcesToEdit = new HashSet<Resource>(resourceSet.getResources());
		Resource resourceToReplace = resourceSet.getResource(uriToReplace, false);
		if(resourceToReplace != null) {
			resourcesToEdit.remove(resourceToReplace);
		}
		return updateDependencies(uriToReplace, targetURI, resourcesToEdit, editingDomain);
	}

	/**
	 * Replaces all references (dependencies) in the "fromResources" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: fromResources.replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 *        Must not be null
	 * @param fromResource
	 *        The resource to edit. Only the objects of this resource will be modified.
	 *        Must not be null
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, Collection<Resource> fromResources) {
		return updateDependencies(uriToReplace, targetURI, fromResources, null);
	}

	/**
	 * Replaces all references (dependencies) in the "fromResource" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: fromResource.replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 *        Must not be null
	 * @param fromResource
	 *        The resource to edit. Only the objects of this resource will be modified.
	 *        Must not be null
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, Resource fromResource) {
		return updateDependencies(uriToReplace, targetURI, fromResource, null);
	}

	/**
	 * Replaces all references (dependencies) in the "resourceSet" to the "uriToReplace" URI, with the "targetURI"
	 * 
	 * Simplified pseudo code algorithm: resourceSet.getResources().replaceAll(uriToReplace, targetURI)
	 * 
	 * @param uriToReplace
	 *        The URI of the resource which initially contains the referenced elements. May or may not exist.
	 *        Must not be null
	 * @param targetURI
	 *        The URI of the resource which contains the newly referenced elements.
	 *        May or may not exist. In the later case, the values will be proxies to the un-existing target URI
	 * @param resourceSet
	 *        The resourceSet to edit. Its resources will be modified.
	 * @return
	 *         The collection of replacements
	 */
	public static Collection<Replacement> updateDependencies(URI uriToReplace, URI targetURI, ResourceSet resourceSet) {
		Set<Resource> resourcesToEdit = new HashSet<Resource>(resourceSet.getResources());
		resourcesToEdit.remove(resourceSet.getResource(uriToReplace, false));
		return updateDependencies(uriToReplace, targetURI, resourcesToEdit, null);
	}

	private static class ReplacementImpl implements Replacement {

		private EObject parent;

		private EStructuralFeature property;

		private EObject oldValue;

		private EObject newValue;

		public ReplacementImpl(EObject parent, EStructuralFeature property, EObject oldValue, EObject newValue) {
			this.parent = parent;
			this.property = property;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}

		public EObject getEObject() {
			return parent;
		}

		public EStructuralFeature getEStructuralFeature() {
			return property;
		}

		public EObject get(boolean resolve) {
			if(resolve && newValue != null && newValue.eIsProxy()) {
				newValue = EcoreUtil.resolve(newValue, parent);
			}

			return newValue;
		}

		public void set(Object newValue) {
			throw new UnsupportedOperationException();
		}

		public boolean isSet() {
			return newValue != null;
		}

		public void unset() {
			throw new UnsupportedOperationException();
		}

		public EObject getOldValue() {
			return oldValue;
		}

		@Override
		public String toString() {
			return String.format("%s replaced with %s", EcoreUtil.getURI(oldValue), EcoreUtil.getURI(newValue));
		}
	}

}
