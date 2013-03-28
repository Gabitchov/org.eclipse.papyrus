/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.axis;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider;

/**
 * 
 * @author Camille Letavernier
 * 
 */
public class SynchronizedFeatureValueAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	@Override
	public void init(INattableModelManager manager, String managerId, Table table, AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, managerId, table, provider, mustRefreshOnAxisChanges);
	}

	@Override
	public synchronized void updateAxisContents() {
		EStructuralFeature synchronizedFeature = ((EMFFeatureValueAxisProvider)getRepresentedContentProvider()).getListenFeature();

		List<Object> theList = getTableManager().getElementsList(getRepresentedContentProvider());
		theList.clear();
		theList.addAll((List<?>)this.getTable().getContext().eGet(synchronizedFeature));
	}

}
