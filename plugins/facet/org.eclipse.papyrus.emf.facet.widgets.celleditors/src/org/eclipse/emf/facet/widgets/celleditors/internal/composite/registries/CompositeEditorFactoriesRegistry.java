/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fabien Giquel (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *    Nicolas Guyomar (Mia-Software) - Bug 338826 - CompositeEditorFactoriesRegistry.getCompositeEditorFactory() should be parameterized 
 *    Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *    Nicolas Bros (Mia-Software) - Bug 341369 - CompositeEditorFactoriesRegistry : inverted type comparison
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.composite.registries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.core.internal.exported.AbstractRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.internal.Activator;

/**
 * Registry for composite editors extension point
 */
public class CompositeEditorFactoriesRegistry extends AbstractRegistry
		implements
		org.eclipse.emf.facet.widgets.celleditors.core.composite.registries.ICompositeEditorFactoriesRegistry,
		org.eclipse.emf.facet.widgets.celleditors.core.composite.registry.ICompositeEditorFactoriesRegistry {

	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.emf.facet.widgets.celleditors"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_NAME = "compositeEditorFactories"; //$NON-NLS-1$
	private final List<ICompositeEditorFactory<?>> compositeFactories;

	public CompositeEditorFactoriesRegistry() {
		this.compositeFactories = new ArrayList<ICompositeEditorFactory<?>>();
		initialize();
	}

	public boolean hasCompositeEditorFactory(final Class<?> type) {
		return getCompositeEditorFactory(type) != null;
	}

	public <T> ICompositeEditorFactory<T> getCompositeEditorFactory(final Class<T> type) {
		if (this.compositeFactories == null) {
			initialize();
		}

		final Class<?> objectType;
		if (type == byte.class) {
			objectType = Byte.class;
		} else if (type == short.class) {
			objectType = Short.class;
		} else if (type == int.class) {
			objectType = Integer.class;
		} else if (type == long.class) {
			objectType = Long.class;
		} else if (type == float.class) {
			objectType = Float.class;
		} else if (type == double.class) {
			objectType = Double.class;
		} else if (type == boolean.class) {
			objectType = Boolean.class;
		} else if (type == char.class) {
			objectType = Character.class;
		} else {
			objectType = type;
		}

		// choose the factory with the most "precise" type (lowest in the inheritance hierarchy)
		Class<?> mostPreciseType = null;
		ICompositeEditorFactory<T> mostPreciseFactory = null;
		for (ICompositeEditorFactory<?> factory : this.compositeFactories) {
			Class<?> handledType = factory.getHandledType();
			if (handledType != null && handledType.isAssignableFrom(objectType)) {
				if (mostPreciseType == null || mostPreciseType.isAssignableFrom(handledType)) {
					mostPreciseType = handledType;
					mostPreciseFactory = castMostPreciseFactory(factory);
				}
			}
		}
		return mostPreciseFactory;
	}

	// Only here to isolate the suppress warning
	@SuppressWarnings("unchecked")
	private <T> ICompositeEditorFactory<T> castMostPreciseFactory(final ICompositeEditorFactory<?> factory) {
		ICompositeEditorFactory<T> mostPreciseFactory;
		mostPreciseFactory = (ICompositeEditorFactory<T>) factory;
		return mostPreciseFactory;
	}

	@Override
	protected String getExtensionPointNamespace() {
		return CompositeEditorFactoriesRegistry.EXTENSION_POINT_NAMESPACE;
	}

	@Override
	protected String getExtensionPointName() {
		return CompositeEditorFactoriesRegistry.EXTENSION_POINT_NAME;
	}

	@Override
	protected void handleRootElement(final IConfigurationElement configurationElement) {
		ICompositeEditorFactory<?> factory;
		try {
			factory = (ICompositeEditorFactory<?>) configurationElement
					.createExecutableExtension(CompositeEditorFactoriesRegistry.CLASS_ATTRIBUTE);
			this.compositeFactories.add(factory);
		} catch (CoreException e) {
			Logger.logError(
					e,
					"A problem occured when instantiating a composite editor factory", Activator.getDefault()); //$NON-NLS-1$
		}
	}
}
