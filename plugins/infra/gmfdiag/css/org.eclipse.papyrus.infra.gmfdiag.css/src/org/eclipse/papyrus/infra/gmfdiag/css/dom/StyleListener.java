/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.dom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * A Listener for notation and semantic properties changes
 * 
 * @author Camille Letavernier
 */
public class StyleListener extends AdapterImpl {

	private final GMFElementAdapter elementAdapter;

	/**
	 * Constructor
	 * 
	 * @param elementAdapter
	 *        The GMFElementAdapter to listen to
	 */
	public StyleListener(GMFElementAdapter elementAdapter) {
		this.elementAdapter = elementAdapter;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if(notification.isTouch()) {
			return;
		}

		if(notification.getFeature() == NotationPackage.eINSTANCE.getView_Element()) {
			if(notification.getNewValue() == null) {
				elementAdapter.notationElementDisposed();
			} else {
				elementAdapter.semanticElementChanged();
			}
			return;
		}

		if(notification.getNotifier() == elementAdapter.getNotationElement()) {
			elementAdapter.notationPropertyChanged();
			return;
		}

		if(notification.getNotifier() == elementAdapter.getSemanticElement()) {
			elementAdapter.semanticPropertyChanged();
			return;
		}
	}
}
