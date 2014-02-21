/**
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exported.IResolver;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exported.IResolverManager;
import org.eclipse.papyrus.emf.facet.util.core.Logger;

public class ResolverManager implements IResolverManager {

	private static final String ATT_NAME = "class"; //$NON-NLS-1$
	private static final String EXT_POINT_ID = "org.eclipse.papyrus.emf.facet.efacet.core.internal.resolver"; //$NON-NLS-1$
	private final List<IResolver> resolvers = new ArrayList<IResolver>();

	public ResolverManager() {
		final IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ResolverManager.EXT_POINT_ID);
		for (IConfigurationElement config : configs) {
			try {
				final Object object = config
						.createExecutableExtension(ResolverManager.ATT_NAME);
				if (object instanceof IResolver) {
					final IResolver resolver = (IResolver) object;
					this.resolvers.add(resolver);
				}
			} catch (CoreException e) {
				Logger.logError(e, Activator.getDefault());
			}

		}
	}

	public <T> T resolve(final Object object, final Class<T> aClass) {
		T result = null;
		for (IResolver resolver : this.resolvers) {
			if (resolver.canHandle(object)) {
				try {
					result = resolver.resolve(object, aClass);
				} catch (ClassCastException e) {
					Logger.logWarning(e, Activator.getDefault());
					// Nothing to: we will try with an other resolver or return
					// null
				}
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	public <T> List<T> selectionPropagation(final Object selectedObject,
			final Class<T> aClass) {
		@SuppressWarnings("unchecked")
		// @SuppressWarnings("unchecked") The untyped list is an definitely
		// empty list.
		List<T> result = Collections.EMPTY_LIST;
		for (IResolver resolver : this.resolvers) {
			if (resolver.canHandle(selectedObject)) {
				try {
					result = resolver.selectionPropagation(selectedObject,
							aClass);
				} catch (ClassCastException e) {
					Logger.logWarning(e, Activator.getDefault());
					// Nothing to: we will try with an other resolver or return
					// null
				}
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	public <T> T selectionRoot(final Object selectedObject,
			final Class<T> aClass) {
		T result = null;
		for (IResolver resolver : this.resolvers) {
			if (resolver.canHandle(selectedObject)) {
				try {
					result = resolver.selectionRoot(selectedObject,
							aClass);
				} catch (ClassCastException e) {
					Logger.logWarning(e, Activator.getDefault());
					// Nothing to: we will try with an other resolver or return
					// null
				}
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

}
