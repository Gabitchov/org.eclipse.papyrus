/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Javier Muñoz (Integranova) - Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.navigator.providers.GroupableTreeArrayContentProvider;
import org.eclipse.papyrus.navigator.providers.PackagingNode;

/**
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class GroupableAdapterFactory extends AdapterFactoryImpl {

	/** The supported types. */
	private final Collection<Object> supportedTypes = new ArrayList<Object>();

	private final AdapterFactory wrappedAdapterFactory;

	public GroupableAdapterFactory(AdapterFactory factory) {
		wrappedAdapterFactory = factory;
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(ITableItemLabelProvider.class);
	}

	@Override
	public Object adapt(Object target, Object type) {
		if((target instanceof EObject) || (target instanceof PackagingNode)) {
			return new GroupableTreeArrayContentProvider(this, wrappedAdapterFactory);
		} else {
			return this.wrappedAdapterFactory.adapt(target, type);
		}
	}

	@Override
	public Adapter adapt(Notifier target, Object type) {

		return (Adapter)adapt((Object)target, type);
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return (((type instanceof EObject) || (type instanceof PackagingNode) || supportedTypes.contains(type)) && (!(type instanceof View))) || this.wrappedAdapterFactory.isFactoryForType(type);
	}

}
