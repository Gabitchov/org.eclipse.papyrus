/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * This is the PapyrusRepositoryWorkbenchAdapter type. Enjoy.
 */
public class PapyrusRepositoryWorkbenchAdapter
		implements IWorkbenchAdapter {

	private static final Object[] NOTHING = {};

	public PapyrusRepositoryWorkbenchAdapter() {
		super();
	}

	public Object[] getChildren(Object o) {
		return (o instanceof IContainer<?>)
			? ((IContainer<?>) o).getElements()
			: NOTHING;
	}

	public ImageDescriptor getImageDescriptor(Object object) {
		ImageDescriptor result = null;

		if (object instanceof IPapyrusRepository) {
			boolean open = ((IPapyrusRepository) object).isConnected();
			result = Activator.getIcon(open
				? Activator.ICON_OPEN_REPOSITORY
				: Activator.ICON_CLOSED_REPOSITORY);
		}

		return result;
	}

	public String getLabel(Object o) {
		String result = null;

		if (o instanceof IPapyrusRepository) {
			result = ((IPapyrusRepository) o).getName();
		}

		return result;
	}

	public Object getParent(Object o) {
		return null;
	}

	//
	// Nested types
	//
	
	@SuppressWarnings("rawtypes")
	public static class Factory
			implements IAdapterFactory {

		private final Class[] supported = {IWorkbenchAdapter.class};

		public Object getAdapter(Object adaptableObject, Class adapterType) {
			Object result = null;

			if (adaptableObject instanceof IPapyrusRepository) {
				result = new PapyrusRepositoryWorkbenchAdapter();
			}

			return result;
		}

		public Class[] getAdapterList() {
			return supported;
		}
	}
}
