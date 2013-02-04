/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDomainNavigatorItem extends PlatformObject {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[]{ EObject.class, IPropertySource.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(final Object adaptableObject, final Class adapterType) {
				if(adaptableObject instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem) {
					final org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem domainNavigatorItem = (org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem)adaptableObject;
					final EObject eObject = domainNavigatorItem.getEObject();
					if(adapterType == EObject.class) {
						return eObject;
					}
					if(adapterType == IPropertySource.class) {
						return domainNavigatorItem.getPropertySourceProvider().getPropertySource(eObject);
					}
				}

				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private final Object myParent;

	/**
	 * @generated
	 */
	private final EObject myEObject;

	/**
	 * @generated
	 */
	private final IPropertySourceProvider myPropertySourceProvider;

	/**
	 * @generated
	 */
	public UMLDomainNavigatorItem(final EObject eObject, final Object parent, final IPropertySourceProvider propertySourceProvider) {
		this.myParent = parent;
		this.myEObject = eObject;
		this.myPropertySourceProvider = propertySourceProvider;
	}

	/**
	 * @generated
	 */
	public Object getParent() {
		return this.myParent;
	}

	/**
	 * @generated
	 */
	public EObject getEObject() {
		return this.myEObject;
	}

	/**
	 * @generated
	 */
	public IPropertySourceProvider getPropertySourceProvider() {
		return this.myPropertySourceProvider;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem) {
			return EcoreUtil.getURI(getEObject()).equals(EcoreUtil.getURI(((org.eclipse.papyrus.uml.diagram.timing.navigator.UMLDomainNavigatorItem)obj).getEObject()));
		}
		return super.equals(obj);
	}

	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
		return EcoreUtil.getURI(getEObject()).hashCode();
	}

}
