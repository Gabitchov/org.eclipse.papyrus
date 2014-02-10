/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 */
package org.eclipse.emf.facet.efacet.core.internal.serialization;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

/**
 * Factory to create {@link ILinkToExtendedEObjectReference} adapters.
 *
 */
public interface ILinkToExtendedEObjectReferenceAdapterFactory extends AdapterFactory {

	/**
	 * Singleton {@link LinkToExtendedEObjectReferenceAdapterFactory}
	 */
	public static ILinkToExtendedEObjectReferenceAdapterFactory INSTANCE = new LinkToExtendedEObjectReferenceAdapterFactory();

	/**
	 * This method returns <code>true</code> if this factory is a factory for the given type
	 * {@link Object}, or <code>false</code> otherwise
	 */
	public boolean isFactoryForType(final Object type);

	/**
	 * Creates a new instance of Adapter for the given {@link Notifier}
	 */
	public Adapter createAdapter(final Notifier target);

}
