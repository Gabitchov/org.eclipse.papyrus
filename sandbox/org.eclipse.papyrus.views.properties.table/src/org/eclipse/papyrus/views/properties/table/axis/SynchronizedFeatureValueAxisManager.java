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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;

/**
 * 
 * @author Camille Letavernier
 * 
 */
public class SynchronizedFeatureValueAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	public static final String AXIS_MANAGER_ID = "org.eclipse.papyrus.emf.nattable.synchronized.featurevalue.axis.manager"; //$NON-NLS-1$

	@Override
	public synchronized void updateAxisContents() {

		EStructuralFeatureValueFillingConfiguration config = null;
		for(final IAxisConfiguration current : this.rep.getSpecificAxisConfigurations()) {
			if(current instanceof EStructuralFeatureValueFillingConfiguration) {
				config = (EStructuralFeatureValueFillingConfiguration)current;
				break;
			}
		}

		EStructuralFeature synchronizedFeature = config.getListenFeature();

		List<Object> theList = getTableManager().getElementsList(getRepresentedContentProvider());
		theList.clear();
		theList.addAll((List<?>)this.getTable().getContext().eGet(synchronizedFeature));
	}

}
