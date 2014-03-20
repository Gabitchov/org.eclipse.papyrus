/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *    Gregoire Dupe (Mia-Software) - Bug 385292 - [CustomizedTreeContentProvider] StackOverFlow when refreshing a TreeViewer with ICustomizedTreeContentProvider
 *    Gregoire Dupe (Mia-Software) - Bug 386387 - [CustomizedTreeContentProvider] The TreeElements are not preserved between two calls to getElements()
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.ui.IContentPropertiesHandler;
import org.eclipse.papyrus.emf.facet.custom.ui.IContentPropertiesHandlerFactory;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedContentProvider;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedTreeContentProvider;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EAttributeTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyFactory;

@SuppressWarnings("deprecation")
// @SuppressWarnings("deprecation") : Bug 380229 - [deprecated] ICustomizedContentProvider
public class CustomizedTreeContentProvider implements ICustomizedTreeContentProvider, ICustomizedContentProvider {

	private final ICustomizationManager customManager;
	private final IContentPropertiesHandler contentHandler;
	private Object previousInput;
	private Object[] rootElements;

	private final Map<EObjectCacheElement, TreeElement> cache;

	private class EObjectCacheElement {

		//Not null
		private final EObject element;

		//May be null
		private final TreeElement parent;

		public EObjectCacheElement(EObject element, TreeElement parent) {
			this.element = element;
			this.parent = parent;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			result = prime * result + ((parent == null) ? 0 : parent.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof EObjectCacheElement)) {
				return false;
			}
			EObjectCacheElement other = (EObjectCacheElement)obj;
			if(!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if(element == null) {
				if(other.element != null) {
					return false;
				}
			} else if(!element.equals(other.element)) {
				return false;
			}
			if(parent == null) {
				if(other.parent != null) {
					return false;
				}
			} else if(!parent.equals(other.parent)) {
				return false;
			}
			return true;
		}

		private CustomizedTreeContentProvider getOuterType() {
			return CustomizedTreeContentProvider.this;
		}
	}

	public CustomizedTreeContentProvider(final ICustomizationManager customManager) {
		this.customManager = customManager;
		this.contentHandler = IContentPropertiesHandlerFactory.DEFAULT.createIContentPropertiesHandler(customManager);
		this.cache = new HashMap<EObjectCacheElement, TreeElement>();
	}

	protected Object[] getRootElements(final Object inputElement) {
		Object[] result;
		if (inputElement == null) {
			result = new Object[0];
		} else if (inputElement instanceof EObject) {
			result = new EObject[] { (EObject) inputElement };
		} else if (inputElement instanceof Collection<?>) {
			result = ((Collection<?>) inputElement).toArray();
		} else if (inputElement instanceof EObject[]) {
			result = (EObject[]) inputElement;
		} else {
			throw new IllegalArgumentException("Unhandled input element type: " + inputElement.getClass().getSimpleName()); //$NON-NLS-1$
		}
		return result;
	}

	public Object[] getElements(final Object inputElement) {
		Object[] result;
		if (this.previousInput == inputElement) {
			result = this.rootElements;
		} else {
			this.previousInput = inputElement;
			final Object[] elements = getRootElements(inputElement);
			final List<Object> elementList = new ArrayList<Object>();
			for (final Object element : elements) {
				if (!isVisible(element, null)) {
					continue;
				}
				if (element instanceof EObject) {
					final EObjectTreeElement eObjectProxy = createEObjectProxy(element, null);
					elementList.add(eObjectProxy);
				} else {
					elementList.add(element);
				}
			}
			result = elementList.toArray();
			this.rootElements = result;
		}
		return result;
	}

	protected static EObjectTreeElement createEObjectProxy(final Object element, final TreeElement parent) {
		final EObject eObject = (EObject)element;
		final EObjectTreeElement eObjectProxy = TreeproxyFactory.eINSTANCE.createEObjectTreeElement();
		eObjectProxy.setEObject(eObject);
		return eObjectProxy;
	}

	public Object[] getChildren(final Object parentElement) {
		Object[] result;
		if (parentElement == null) {
			result = new Object[0];
		} else if (parentElement instanceof EObjectTreeElement) {
			final EObjectTreeElement eObjectProxy = (EObjectTreeElement) parentElement;
			result = getChildren(eObjectProxy);
		} else if (parentElement instanceof EAttributeTreeElement) {
			final EAttributeTreeElement attributeProxy = (EAttributeTreeElement) parentElement;
			result = getChildren(attributeProxy);
		} else if (parentElement instanceof EReferenceTreeElement) {
			final EReferenceTreeElement referenceProxy = (EReferenceTreeElement) parentElement;
			result = getChildren(referenceProxy);
		} else {
			Logger.logError("Unknown element in tree: " + parentElement.getClass(), Activator.getDefault()); //$NON-NLS-1$
			result = new Object[0];
		}
		return result;
	}

	public Object[] getChildren(final EObjectTreeElement treeElement) {
		final ArrayList<Object> children = new ArrayList<Object>();
		children.addAll(createAttributes(treeElement));
		children.addAll(createReferences(treeElement));
		return children.toArray();
	}

	public Object[] getChildren(final EAttributeTreeElement attributeProxy) {
		final List<Object> children = new ArrayList<Object>();
		final EAttribute eAttribute = attributeProxy.getEAttribute();
		if (eAttribute.isMany()) {
			final TreeElement parent = attributeProxy.getParent();
			if (!(parent instanceof EObjectTreeElement)) {
				throw new IllegalStateException("An attribute should appear only under a model element"); //$NON-NLS-1$
			}
			final EObjectTreeElement parentProxy = (EObjectTreeElement) parent;
			final EObject eObject = parentProxy.getEObject();

			try {
				final IFacetManager facetManager = this.customManager.getFacetManager();
				final List<Object> result = facetManager.getOrInvokeMultiValued(eObject, eAttribute, null);
				for (final Object object : result) {
					if (object instanceof EObject) {
						final EObject childEObject = (EObject) object;
						children.add(createEObjectProxy(childEObject, attributeProxy));
					}
					children.add(object);
				}
			} catch (final FacetManagerException e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
		return children.toArray();
	}

	public Object[] getChildren(final EReferenceTreeElement referenceProxy) {
		List<? extends Object> result;
		final EReference eReference = referenceProxy.getEReference();
		final TreeElement parent = referenceProxy.getParent();
		if (!(parent instanceof EObjectTreeElement)) {
			throw new IllegalStateException("A reference should appear only under a model element"); //$NON-NLS-1$
		}
		final EObjectTreeElement parentProxy = (EObjectTreeElement) parent;
		final EObject eObject = parentProxy.getEObject();
		if (eReference.isMany()) {
			result = getMultiValuedReferenceChildren(eReference, eObject, referenceProxy);
		} else {
			final Object child = getSingleValuedReferenceChild(eReference, eObject, referenceProxy);
			if (child == null) {
				result = Collections.emptyList();
			} else {
				result = Collections.singletonList(child);
			}
		}
		return result.toArray();
	}

	private TreeElement getSingleValuedReferenceChild(final EReference eReference,
		final EObject eObject, final EReferenceTreeElement parent) {
		TreeElement child = null;
		if (parent.getReferedEObjectTE() == null || parent.getReferedEObjectTE().size() == 0) {
			try {
				final IFacetManager facetManager = this.customManager
					.getFacetManager();
				final EObject referedEObject = facetManager.getOrInvoke(
					eObject, eReference, EObject.class);
				if (referedEObject != null) {
					child = createEObjectProxy(referedEObject, parent);
				}
			} catch (final FacetManagerException e) {
				Logger.logError(e, Activator.getDefault());
			}
		} else {
			child = parent.getReferedEObjectTE().get(0);
		}
		return child;
	}

	private List<EObjectTreeElement> getMultiValuedReferenceChildren(
		final EReference eReference, final EObject eObject,
		final EReferenceTreeElement parent) {
		List<EObjectTreeElement> children = new ArrayList<EObjectTreeElement>();
		if (parent.getReferedEObjectTE() == null || parent.getReferedEObjectTE().size() == 0) {
			try {
				final IFacetManager facetManager = this.customManager
					.getFacetManager();
				final List<Object> result = facetManager
					.getOrInvokeMultiValued(eObject, eReference, null);
				for (final Object object : result) {
					if (object instanceof EObject) {
						final EObject childEObject = (EObject) object;
						children.add(createEObjectProxy(childEObject, parent));
					}
				}
			} catch (final FacetManagerException e) {
				Logger.logError(e, Activator.getDefault());
			}
		} else {
			children = parent.getReferedEObjectTE();
		}
		return children;
	}



	private Collection<EAttributeTreeElement> createAttributeProxies(final List<EAttribute> allAttributes, final EObjectTreeElement parent) {
		final EObject eObject = parent.getEObject();
		final List<EAttributeTreeElement> result = new ArrayList<EAttributeTreeElement>();
		for (final EAttribute eAttribute : allAttributes) {
			if (isVisible(eObject, eAttribute)) {
				final EAttributeTreeElement attributeProxy = TreeproxyFactory.eINSTANCE.createEAttributeTreeElement();
				attributeProxy.setEAttribute(eAttribute);
				attributeProxy.setParent(parent);
				result.add(attributeProxy);
			}
		}
		return result;
	}



	private  Collection<? extends Object> createReferenceProxies(final List<EReference> allReferences, final EObjectTreeElement parent) {
		final EObject eObject = parent.getEObject();
		final List<EReferenceTreeElement> result = new ArrayList<EReferenceTreeElement>();
		for (final EReference eReference : allReferences) {
			if (isVisible(eObject, eReference)) {
				if(!(collapseLink(eObject, eReference))) {
					final EReferenceTreeElement referenceProxy = TreeproxyFactory.eINSTANCE.createEReferenceTreeElement();
					referenceProxy.setEReference(eReference);
					referenceProxy.setParent(parent);
					result.add(referenceProxy);
				}
				else{
					System.err.println("Do not Create an eReference"+ eReference+" create directly its childreen");
				}

			}
		}
		return result;
	}

	public Object getParent(final Object element) {
		Object result = null;
		if (element instanceof TreeElement) {
			final TreeElement treeElement = (TreeElement) element;
			result = treeElement.eContainer();
		}
		return result;
	}

	public boolean hasChildren(final Object element) {
		return getChildren(element).length > 0;
	}



	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// nothing to do
	}

	public ICustomizationManager getCustomizationManager() {
		return this.customManager;
	}

	public boolean isVisible(final Object object, final ETypedElement eTypedElement) {
		Boolean result = Boolean.TRUE;
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			try {
				result = this.customManager.getCustomValueOf(eObject, eTypedElement, this.contentHandler.getIsVisible(), Boolean.class);
			} catch (final CustomizationException e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
		return result.booleanValue();
	}

	private boolean collapseLink(final Object object, final EReference eTypedElement) {
		Boolean result = Boolean.TRUE;
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			try {
				result = this.customManager.getCustomValueOf(eObject, eTypedElement, this.contentHandler.getCollapseLink(), Boolean.class);
			} catch (final CustomizationException e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
		return result.booleanValue();
	}



	private Collection<? extends Object> createReferences(final EObjectTreeElement treeElement) {
		final EObject eObject = treeElement.getEObject();
		final EClass eClass = eObject.eClass();
		final IFacetManager facetManager = this.customManager.getFacetManager();
		final List<EReference> allReferences = new ArrayList<EReference>();
		allReferences.addAll(eClass.getEAllReferences());
		try {
			final Set<EReference> facetReferences = FacetUtils.getETypedElements(eObject, EReference.class, facetManager);
			allReferences.addAll(facetReferences);
		} catch (final FacetManagerException e) {
			Logger.logError(e, Activator.getDefault());
		}

		Collection<Object> result = new LinkedList<Object>();

		for(EReference reference : allReferences) {
			if(isVisible(eObject, reference)) {
				if(collapseLink(eObject, reference)) {
					if(reference.getUpperBound() != 1) {
						result.addAll(getMultiValuedReferenceChildren(reference, eObject, treeElement));
					} else {
						Object child = getSingleValuedReferenceChild(reference, eObject, treeElement);
						if(child != null) {
							result.add(child);
						}
					}
				} else {
					result.add(getEReferenceProxy(reference, treeElement));
				}
			}
		}

		return result;
	}

	private Collection<? extends Object> createAttributes(final EObjectTreeElement treeElement) {
		final EObject eObject = treeElement.getEObject();
		final EClass eClass = eObject.eClass();
		final IFacetManager facetManager = this.customManager.getFacetManager();
		final List<EAttribute> allAttributes = new ArrayList<EAttribute>();
		allAttributes.addAll(eClass.getEAllAttributes());
		try {
			final Set<EAttribute> facetAttributes = FacetUtils.getETypedElements(eObject, EAttribute.class, facetManager);
			allAttributes.addAll(facetAttributes);
		} catch (final FacetManagerException e) {
			Logger.logError(e, Activator.getDefault());
		}


		List<TreeElement> result = new LinkedList<TreeElement>();
		for(EAttribute eAttribute : allAttributes) {
			if(isVisible(eObject, eAttribute)) {
				TreeElement eAttributeTreeElement = getEAttributeProxy(eAttribute, treeElement);
				if(eAttributeTreeElement != null) {
					result.add(eAttributeTreeElement);
				}
			}
		}
		return result;
	}



	private EReferenceTreeElement createReferenceProxy(final EReference reference, final EObjectTreeElement parent) {
		final EObject eObject = parent.getEObject();
		if(isVisible(eObject, reference)) {
			final EReferenceTreeElement referenceProxy = TreeproxyFactory.eINSTANCE.createEReferenceTreeElement();
			referenceProxy.setEReference(reference);
			referenceProxy.setParent(parent);
			return referenceProxy;
		}
		return null;
	}

	private EAttributeTreeElement createAttributeProxy(final EAttribute attribute, final EObjectTreeElement parent) {
		final EObject eObject = parent.getEObject();
		if(isVisible(eObject, attribute)) {
			final EAttributeTreeElement attributeProxy = TreeproxyFactory.eINSTANCE.createEAttributeTreeElement();
			attributeProxy.setEAttribute(attribute);
			attributeProxy.setParent(parent);
			return attributeProxy;
		}
		return null;
	}

	private Object getSingleValuedReferenceChild(final EReference eReference, final EObject eObject, final TreeElement parent) {
		Object child = null;
		try {
			final IFacetManager facetManager = this.customManager.getFacetManager();
			final Object result = facetManager.getOrInvoke(eObject, eReference, null);
			if(result instanceof EObject) {
				final EObject childEObject = (EObject)result;
				child = getEObjectProxy(childEObject, parent);
			}
		} catch (final FacetManagerException e) {
			Logger.logError(e, Activator.getDefault());
		}
		return child;
	}

	private List<Object> getMultiValuedReferenceChildren(final EReference eReference, final EObject eObject, final TreeElement parent) {
		final List<Object> children = new ArrayList<Object>();
		try {
			final IFacetManager facetManager = this.customManager.getFacetManager();
			final List<Object> result = facetManager.getOrInvokeMultiValued(eObject, eReference, null);
			for(final Object object : result) {
				if(object instanceof EObject) {
					final EObject childEObject = (EObject)object;
					children.add(getEObjectProxy(childEObject, parent));
				}
			}
		} catch (final FacetManagerException e) {
			Logger.logError(e, Activator.getDefault());
		}
		return children;
	}

	protected EObjectTreeElement getEObjectProxy(final Object element, final TreeElement parent) {
		EObjectCacheElement cacheElement = new EObjectCacheElement((EObject)element, parent);
		if(!(cache.containsKey(cacheElement))) {
			cache.put(cacheElement, createEObjectProxy(element, parent));
		}
		return (EObjectTreeElement)cache.get(cacheElement);
	}

	protected EAttributeTreeElement getEAttributeProxy(final Object element, final TreeElement parent) {
		EObjectCacheElement cacheElement = new EObjectCacheElement((EObject)element, parent);
		if(!(cache.containsKey(cacheElement))) {
			cache.put(cacheElement, createAttributeProxy((EAttribute)element, (EObjectTreeElement)parent));
		}
		return (EAttributeTreeElement)cache.get(cacheElement);
	}

	protected EReferenceTreeElement getEReferenceProxy(final Object element, final EObjectTreeElement parent) {
		EObjectCacheElement cacheElement = new EObjectCacheElement((EObject)element, parent);
		if(!(cache.containsKey(cacheElement))) {
			cache.put(cacheElement, createReferenceProxy((EReference)element, parent));
		}
		return (EReferenceTreeElement)cache.get(cacheElement);
	}

	public void dispose() {
		cache.clear();
	}
}
