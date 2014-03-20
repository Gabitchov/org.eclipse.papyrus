/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - support adapter instead of custom resource impl (CDO)
 *  Christian W. Damus (CEA) - bug 429422
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ModelCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ProjectCSSEngine;

/**
 * A GMF Resource with CSS support
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("restriction")
public class CSSNotationResource extends GMFResource {

	private ExtendedCSSEngine modelEngine;

	private ExtendedCSSEngine projectEngine;

	private Adapter disposeListener;

	public CSSNotationResource(URI uri) {
		super(uri);
	}

	public ExtendedCSSEngine getModelEngine() {
		if(modelEngine == null) {
			// Create a CSSEngine and listen to modifications on the
			// resourceSet,
			// to know when this resource is disposed
			modelEngine = new ModelCSSEngine(this);
			getResourceSet().eAdapters().add(disposeListener = new ResourceDisposeListener());
		}
		return modelEngine;
	}

	public ExtendedCSSEngine getProjectEngine() {
		if(projectEngine == null) {
			projectEngine = ProjectCSSEngine.createEngine(this);
		}

		return projectEngine;
	}

	public static ExtendedCSSEngine getEngine(Resource resource) {
		ExtendedCSSEngine result = null;

		if(resource instanceof CSSNotationResource) {
			result = ((CSSNotationResource)resource).getModelEngine();
		} else if("notation".equals(resource.getURI().fileExtension())) {
			CSSNotationResourceAdapter adapter = (CSSNotationResourceAdapter)EcoreUtil.getExistingAdapter(resource, ExtendedCSSEngine.class);

			if(adapter == null) {
				// is the resource set a ModelSet that has the CSS notation
				// model associated?
				ResourceSet resourceSet = resource.getResourceSet();
				if((resourceSet instanceof ModelSet) && (((ModelSet)resourceSet).getModel(NotationModel.MODEL_ID) instanceof CSSNotationModel)) {

					adapter = new CSSNotationResourceAdapter();
					resource.eAdapters().add(adapter);
				}
			}

			if(adapter != null) {
				result = adapter.getEngine();
			}
		}

		return result;
	}

	public static boolean isCSSEnabled(Resource resource) {
		// while a resource is loading, we don't want to poke its CSS style
		// annotations
		return (resource != null) && !((Resource.Internal)resource).isLoading() && (getEngine(resource) != null);
	}

	/**
	 * Dispose the CSS Engine and stops listening on the ResourceSet
	 * 
	 * @param notifier
	 */
	private void disposeEngine(Object notifier) {
		// notifier is the owning resourceSet
		if(modelEngine != null) {
			modelEngine.dispose();
			modelEngine = null;
			// Stop listening on the resourceSet
			((ResourceSet)notifier).eAdapters().remove(disposeListener);
		}

		if(projectEngine != null) {
			projectEngine.dispose();
			projectEngine = null;
		}
	}

	private class ResourceDisposeListener extends AdapterImpl {

		@Override
		public void notifyChanged(Notification notification) {
			// If this resource is removed from the resourceSet, dispose the
			// CSSEngine
			// and stop listening on the resourceSet
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
