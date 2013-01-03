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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorItem extends UMLAbstractNavigatorItem {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(final Object adaptableObject, final Class adapterType) {
				if (adaptableObject instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorItem
						&& (adapterType == View.class || adapterType == EObject.class)) {
					return ((org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorItem) adaptableObject).getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private final View myView;

	/**
	 * @generated
	 */
	private boolean myLeaf = false;

	/**
	 * @generated
	 */
	public UMLNavigatorItem(final View view, final Object parent, final boolean isLeaf) {
		super(parent);
		this.myView = view;
		this.myLeaf = isLeaf;
	}

	/**
	 * @generated
	 */
	public View getView() {
		return this.myView;
	}

	/**
	 * @generated
	 */
	public boolean isLeaf() {
		return this.myLeaf;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorItem) {
			return EcoreUtil.getURI(getView()).equals(EcoreUtil.getURI(((org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorItem) obj).getView()));
		}
		return super.equals(obj);
	}

	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
		return EcoreUtil.getURI(getView()).hashCode();
	}

}
