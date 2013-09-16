/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ModelCSSEngine;

/**
 * An adapter that adds CSS support to arbitrary resource implementations. It is an
 * alternative to the use of {@link CSSNotationResource}.
 * 
 * @see CSSNotationResource
 */
@SuppressWarnings("restriction")
public class CSSNotationResourceAdapter extends AdapterImpl {

	private ExtendedCSSEngine engine;

	public ExtendedCSSEngine getEngine() {
		if(engine == null) {
			//Create a CSSEngine and listen to modifications on the resourceSet,
			//to know when this resource is disposed
			engine = new ModelCSSEngine(getResource());
		}

		return engine;
	}

	/**
	 * Dispose the CSS Engine and stops listening on the ResourceSet
	 * 
	 * @param notifier
	 */
	private void disposeEngine() {
		//notifier is the owning resourceSet
		if(engine != null) {
			engine.dispose();
			engine = null;
		}
	}

	Resource getResource() {
		return (Resource)getTarget();
	}

	@Override
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();

		if((notifier == getResource()) && (notification.getFeatureID(Resource.class) == Resource.RESOURCE__RESOURCE_SET) && (notification.getNewValue() == null)) {
			//If this resource is removed from the resourceSet, dispose the CSSEngine
			//and stop listening on the resourceSet
			disposeEngine();
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ExtendedCSSEngine.class;
	}
}
