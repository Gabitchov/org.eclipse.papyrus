/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class UMLAbstractNavigatorItem extends PlatformObject {
	/**
	 * @generated
	 */
	static {
		@SuppressWarnings("rawtypes")
		final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
		final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
			public String getContributorId() {
				return "org.eclipse.papyrus.uml.diagram.clazz"; //$NON-NLS-1$
			}
		};
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof org.eclipse.papyrus.uml.diagram.clazz.navigator.UMLAbstractNavigatorItem && adapterType == ITabbedPropertySheetPageContributor.class) {
					return propertySheetPageContributor;
				}
				return null;
			}

			@SuppressWarnings("rawtypes")
			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, org.eclipse.papyrus.uml.diagram.clazz.navigator.UMLAbstractNavigatorItem.class);
	}
	/**
	 * @generated
	 */
	private Object myParent;

	/**
	 * @generated
	 */
	protected UMLAbstractNavigatorItem(Object parent) {
		myParent = parent;
	}

	/**
	 * @generated
	 */
	public Object getParent() {
		return myParent;
	}
}
