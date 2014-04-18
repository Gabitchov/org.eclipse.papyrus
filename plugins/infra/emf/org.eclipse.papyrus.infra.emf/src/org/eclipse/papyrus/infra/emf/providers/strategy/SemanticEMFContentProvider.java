/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410346
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers.strategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.CustomizedTreeContentProvider;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;


public class SemanticEMFContentProvider extends CustomizedTreeContentProvider implements IAdaptableContentProvider, IHierarchicContentProvider, IStaticContentProvider {

	protected EObject[] roots;

	protected List<?> metaclasses = new LinkedList<Object>();

	protected List<?> notWantedMetaclasses = new LinkedList<Object>();

	protected EObject eObject;

	protected EStructuralFeature feature;

	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	protected SemanticEMFContentProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

	public SemanticEMFContentProvider(EObject editedEObject, EStructuralFeature feature, EObject[] roots, ICustomizationManager customizationManager) {
		super(customizationManager);
		this.roots = roots;

		configureMetaclasses(feature);

		this.eObject = editedEObject;
		this.feature = feature;
	}

	public SemanticEMFContentProvider(EObject editedEObject, EStructuralFeature feature, EObject[] roots) {
		this(editedEObject, feature, roots, Activator.getDefault().getCustomizationManager());
	}

	protected void configureMetaclasses(EStructuralFeature feature) {
		if(feature != null) {
			setWantedMetaclasses(Collections.singletonList(feature.getEType()));
		}
	}

	public SemanticEMFContentProvider(EObject editedEObject, EStructuralFeature feature) {
		this(editedEObject, feature, findRoots(editedEObject));
	}

	public SemanticEMFContentProvider(EObject[] roots) {
		this(null, null, roots);
	}

	public SemanticEMFContentProvider(EObject[] roots, ICustomizationManager customizationManager) {
		this(null, null, roots, customizationManager);
	}

	public SemanticEMFContentProvider(ResourceSet root) {
		this(null, null, root);
	}

	public SemanticEMFContentProvider(EObject editedEObject, EStructuralFeature feature, ResourceSet root) {
		this(editedEObject, feature, getRoots(root));
	}
	
	@Override
	public void dispose() {
		try {
			// Because we created this adapter factory, we must dispose it
			if(factory instanceof IDisposable) {
				((IDisposable)factory).dispose();
			}
		} finally {
			super.dispose();
		}
	}

	protected static EObject[] getRoots(ResourceSet root) {
		List<EObject> roots = new LinkedList<EObject>();
		if(root != null) {
			for(Resource resource : root.getResources()) {
				roots.addAll(resource.getContents());
			}
		}
		return roots.toArray(new EObject[roots.size()]);
	}

	protected static EObject[] findRoots(EObject source) {

		//The EObject is not contained in a resource : we return the top-level EObject
		if(source.eResource() == null) {
			while(source.eContainer() != null) {
				source = source.eContainer();
			}

			return new EObject[]{ source };
		}

		//The resource is not contained in a resource set : we return the resource's contents
		if(source.eResource().getResourceSet() == null) {
			return source.eResource().getContents().toArray(new EObject[0]);
		}

		//We have a full resourceSet : we return its contents
		return getRoots(source.eResource().getResourceSet());
	}

	@Override
	public EObject[] getRootElements(final Object inputElement) {
		return roots;
	}

	public Object getAdaptedValue(Object containerElement) {
		return EMFHelper.getEObject(containerElement);
	}

	@Override
	public boolean hasChildren(Object parent) {
		//May be expensive
		Object[] children = getChildren(parent);
		return children != null && children.length > 0;
	}

	public boolean isValidValue(Object containerElement) {
		// get the semantic object form the element
		Object semanticObject = getAdaptedValue(containerElement);

		//return false for EReference and non-semantic objects
		if(semanticObject instanceof EReference || semanticObject == null) {
			return false;
		}

		//Tests whether the element is compatible with at least one metaclass
		if(metaclasses != null && !metaclasses.isEmpty()) {
			boolean compatible = false;

			for(Object metaclass : metaclasses) {
				if(isCompatibleMetaclass(containerElement, metaclass)) {
					compatible = true;
					break;
				}
			}

			if(!compatible) {
				return false;
			}
		}

		//If the element is compatible with at least one metaclass from notWanted, then it is not valid
		for(Object metaclass : notWantedMetaclasses) {
			if(isCompatibleMetaclass(containerElement, metaclass)) {
				return false;
			}
		}			

		return true;
	}

	protected boolean isCompatibleMetaclass(Object containerElement, Object metaclass) {
		if(metaclass instanceof EClassifier) {
			Object semanticElement = getAdaptedValue(containerElement);
			return ((EClassifier)metaclass).isInstance(semanticElement);
		}
		return false;
	}

	public void setWantedMetaclasses(List<?> metaclasses) {
		this.metaclasses = metaclasses;
	}

	public void setNotWantedMetaclasses(List<?> notWantedMetaclasses) {
		assert notWantedMetaclasses != null : "notWantedMetaclasses must be not null"; //$NON-NLS-1$
		this.notWantedMetaclasses = notWantedMetaclasses;
	}

	public Object[] getElements() {
		return super.getElements(null);
	}

	public List<?> getWantedMetaclasses() {
		return metaclasses;
	}

	public List<?> getNotWantedMetaclasses() {
		return notWantedMetaclasses;
	}
}
