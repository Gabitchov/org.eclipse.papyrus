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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.axis;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager;
import org.eclipse.papyrus.uml.tools.adapters.PapyrusUMLDerivedSubsetAdapter;

/**
 * *
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractUMLSynchronizedOnFeatureAxisManager extends AbstractSynchronizedOnEStructuralFeatureAxisManager {


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractUMLSynchronizedOnFeatureAxisManager#addContextFeatureValueListener()
	 * 
	 */
	@Override
	protected void addContextFeatureValueListener() {
		//see bug Bug 394623
		this.featureListener = new PapyrusUMLDerivedSubsetAdapter() {//this listener allows to receive notification from some derived UML Feature

			@Override
			public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
				if(getListenFeatures().contains(derivedUnion)) {
					featureValueHasChanged(notification);
				}
			}

			@Override
			public void notifyChanged(Notification msg) {
				if(getListenFeatures().contains(msg.getFeature())) {
					featureValueHasChanged(msg);
				}
				super.notifyChanged(msg);
			};

		};
		getTableContext().eAdapters().add(this.featureListener);
	}


}
