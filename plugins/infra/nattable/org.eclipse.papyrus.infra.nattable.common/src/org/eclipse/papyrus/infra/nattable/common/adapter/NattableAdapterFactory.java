/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenableWithContainer;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

@SuppressWarnings("rawtypes")
public class NattableAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IOpenable.class) {
			if(adaptableObject instanceof Table) {
				Table table = (Table)adaptableObject;
				return new IOpenableWithContainer.Openable(adaptableObject, table.getContext());
			}
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[]{ IOpenable.class };
	}


}
