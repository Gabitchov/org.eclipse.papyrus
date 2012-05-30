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
package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ModelCSSEngine;

/**
 * A GMF Resource with CSS support
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("restriction")
public class CSSNotationResource extends GMFResource {

	private ExtendedCSSEngine engine;

	private Adapter disposeListener;

	public CSSNotationResource(URI uri) {
		super(uri);
	}

	public ExtendedCSSEngine getEngine() {
		if(engine == null) {
			//Create a CSSEngine and listen to modifications on the resourceSet,
			//to know when this resource is disposed
			engine = new ModelCSSEngine(this);
			getResourceSet().eAdapters().add(disposeListener = new ResourceDisposeListener());
		}
		return engine;
	}

	/**
	 * Dispose the CSS Engine and stops listening on the ResourceSet
	 * 
	 * @param notifier
	 */
	private void disposeEngine(Object notifier) {
		//notifier is the owning resourceSet
		if(engine != null) {
			engine.dispose();
			engine = null;
			//Stop listening on the resourceSet
			((ResourceSet)notifier).eAdapters().remove(disposeListener);
		}
	}

	private class ResourceDisposeListener extends AdapterImpl {

		@Override
		public void notifyChanged(Notification notification) {
			//If this resource is removed from the resourceSet, dispose the CSSEngine
			//and stop listening on the resourceSet
			switch(notification.getEventType()) {
			case Notification.REMOVE_MANY:
				for(Object oldValue : (Collection<?>)notification.getOldValue()) {
					if(oldValue == CSSNotationResource.this) {
						disposeEngine(notification.getNotifier());
					}
				}
				break;
			case Notification.REMOVE:
				if(notification.getOldValue() == CSSNotationResource.this) {
					disposeEngine(notification.getNotifier());
				}
				break;
			}
		}
	}
}
