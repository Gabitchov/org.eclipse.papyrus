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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
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

	public CustomizedTreeContentProvider(final ICustomizationManager customManager) {
		this.customManager = customManager;
		this.contentHandler = IContentPropertiesHandlerFactory.DEFAULT.createIContentPropertiesHandler(customManager);
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

	protected static EObjectTreeElement createEObjectProxy(
			final Object element, final EStructuralFeatureTreeElement parent) {
		final EObject eObject = (EObject) element;
		final EObjectTreeElement eObjectProxy = TreeproxyFactory.eINSTANCE.createEObjectTreeElement();
		eObjectProxy.setEObject(eObject);
		eObjectProxy.setParent(parent);
		eObject.eAdapters().add(new TreeElementAdapter(eObjectProxy));
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

	private Object[] getChildren(final EObjectTreeElement treeElement) {
		List<EStructuralFeatureTreeElement> children = treeElement.getSfTreeElmement();
		if (children == null || children.isEmpty()) {
			children = new ArrayList<EStructuralFeatureTreeElement>();
			children.addAll(createAttributes(treeElement));
			children.addAll(createReferences(treeElement));
		}
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

	private Collection<EAttributeTreeElement> createAttributes(final EObjectTreeElement treeElement) {
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
		return createAttributeProxies(allAttributes, treeElement);
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

	private Collection<EReferenceTreeElement> createReferences(final EObjectTreeElement treeElement) {
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
		return createReferenceProxies(allReferences, treeElement);
	}

	private Collection<EReferenceTreeElement> createReferenceProxies(final List<EReference> allReferences, final EObjectTreeElement parent) {
		final EObject eObject = parent.getEObject();
		final List<EReferenceTreeElement> result = new ArrayList<EReferenceTreeElement>();
		for (final EReference eReference : allReferences) {
			if (isVisible(eObject, eReference)) {
				final EReferenceTreeElement referenceProxy = TreeproxyFactory.eINSTANCE.createEReferenceTreeElement();
				referenceProxy.setEReference(eReference);
				referenceProxy.setParent(parent);
				result.add(referenceProxy);
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

	public void dispose() {
		// nothing to do
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
}
