/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE - tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.table.common.adapters;

import java.util.Collection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenable;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenableWithContainer;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


public class TableAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IOpenable.class) {
			if (adaptableObject instanceof PapyrusTableInstance){
				PapyrusTableInstance papyrusTableInstance = (PapyrusTableInstance)adaptableObject;
				return new IOpenableWithContainer.Openable(adaptableObject,papyrusTableInstance.getTable().getContext());
			}
			if (adaptableObject instanceof TableInstance2){
				TableInstance2 instance = (TableInstance2)adaptableObject;
				Collection<Setting> usages = PapyrusEcoreUtils.getUsages(instance);
				Predicate<Setting> p = new Predicate<EStructuralFeature.Setting>() {

					public boolean apply(EStructuralFeature.Setting arg0) {
						return arg0.getEObject() instanceof PapyrusTableInstance;
					}
				};
				Function<Setting, IOpenable> f = new Function<EStructuralFeature.Setting, IOpenable>() {
					public IOpenable apply(Setting arg0) {
						PapyrusTableInstance tab = (PapyrusTableInstance)arg0.getEObject();
						return new IOpenableWithContainer.Openable(arg0.getEObject(),tab.getTable().getContext());
					}
				};
				return Iterables.transform(Iterables.filter(usages, p),f).iterator().next();
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{IOpenable.class};
	}

}
