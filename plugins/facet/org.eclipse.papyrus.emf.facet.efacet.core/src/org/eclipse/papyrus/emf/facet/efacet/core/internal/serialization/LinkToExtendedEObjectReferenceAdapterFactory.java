/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal.serialization;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class LinkToExtendedEObjectReferenceAdapterFactory extends AdapterFactoryImpl implements ILinkToExtendedEObjectReferenceAdapterFactory {

	@Override
	public boolean isFactoryForType(final Object type) {
		return type == ILinkToExtendedEObjectReference.class;
	}

	@Override
	public Adapter createAdapter(final Notifier target) {
		return new LinkToExtendedEObjectReferenceAdapter();
	}

}
