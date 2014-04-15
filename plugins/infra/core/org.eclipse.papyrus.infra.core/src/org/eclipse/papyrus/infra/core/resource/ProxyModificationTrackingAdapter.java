/*****************************************************************************
 * Copyright (c) 2013, 2014 Atos, CEA, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 432753
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.utils.EMFHelper;

/**
 * This adapter handles "modified" flag of resources for tricky cases :
 * 
 * - when there is a change in an URI all the resources containing a proxy
 * 	 to the modified resource should be marked as modified
 * 
 * - when adding/removing objects from resources they should be marked as modified,
 *   and all the resources containing a proxy too
 * 
 * - when doing control/uncontrol operations the resource of the parent object
 * 	 should be marked as modified
 * 
 * @author mvelten
 *
 */
public class ProxyModificationTrackingAdapter extends EContentAdapter {

	@Override
	protected void setTarget(Resource target) {
		basicSetTarget(target);
	}

	@Override
	protected void unsetTarget(Resource target) {
		basicUnsetTarget(target);
	}

	@Override
	protected void setTarget(EObject target) {
	}

	@Override
	protected void unsetTarget(EObject target) {
	}

	@Override
	public void notifyChanged(Notification n) {
		Object notifier = n.getNotifier();

		if(notifier instanceof Resource.Internal) {
			Resource.Internal r = (Resource.Internal)notifier;

			if (n.getEventType() == Notification.SET && n.getFeatureID(Resource.class) == Resource.RESOURCE__URI) {
				r.setModified(true);

				TreeIterator<Object> properContents = EcoreUtil.getAllProperContents(r, false);
				while(properContents.hasNext()) {
					Object obj = properContents.next();
					if (obj instanceof EObject) {
						setReferencingResourcesAsModified((EObject)obj);
					}
				}

			} else {
				List objects = new ArrayList();

				switch(n.getEventType()) {
				case Notification.ADD_MANY:
					objects = (List<?>)n.getNewValue();
					break;
				case Notification.REMOVE_MANY:
					objects = (List<?>)n.getOldValue();
					break;
				case Notification.ADD:
					objects.add(n.getNewValue());
					break;
				case Notification.REMOVE:
					objects.add(n.getOldValue());
					break;
				}

				if(r.isLoaded() && !r.isLoading()) {
					if(!objects.isEmpty()) {
						r.setModified(true);
					}

					for(Object o : objects) {
						if(o instanceof EObject) {
							TreeIterator<Object> properContents = EcoreUtil.getAllProperContents((EObject)o, false);
							while(properContents.hasNext()) {
								Object obj = properContents.next();
								if(obj instanceof EObject) {
									setReferencingResourcesAsModified((EObject)obj);
								}
							}
						}
					}
				}
			}
		}

		super.notifyChanged(n);
	}

	protected void setReferencingResourcesAsModified(EObject eObj) {
		Collection<Setting> references = EMFHelper.getUsages(eObj);
		for (Setting setting : references) {
			EStructuralFeature f = setting.getEStructuralFeature();
			if(setting.getEObject() != null && !f.isDerived() && !f.isTransient()) {
				Resource.Internal refResource = (org.eclipse.emf.ecore.resource.Resource.Internal)setting.getEObject().eResource();
				if(refResource != null && !refResource.isLoading()) {
					refResource.setModified(true);
				}
			}
		}
	}
}
