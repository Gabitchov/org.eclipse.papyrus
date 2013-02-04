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
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public abstract class UMLAbstractNavigatorItem extends PlatformObject {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[]{ ITabbedPropertySheetPageContributor.class };
		final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {

			public String getContributorId() {
				return "org.eclipse.papyrus.uml.diagram.timing"; //$NON-NLS-1$
			}
		};
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(final Object adaptableObject, final Class adapterType) {
				if(adaptableObject instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLAbstractNavigatorItem && adapterType == ITabbedPropertySheetPageContributor.class) {
					return propertySheetPageContributor;
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, org.eclipse.papyrus.uml.diagram.timing.navigator.UMLAbstractNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private final Object myParent;

	/**
	 * @generated
	 */
	protected UMLAbstractNavigatorItem(final Object parent) {
		this.myParent = parent;
	}

	/**
	 * @generated
	 */
	public Object getParent() {
		return this.myParent;
	}

}
