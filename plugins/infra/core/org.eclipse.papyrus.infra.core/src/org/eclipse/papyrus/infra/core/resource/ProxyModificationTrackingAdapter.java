/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This adapter handles "modified" flag of resources for tricky cases :
 * 
 * - when there is a change in an URI all the resources containing a proxy
 * 	 to the modified resource should be marked as modified
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

		if (notifier instanceof Resource) {
			Resource r = (Resource)notifier;

			if (n.getEventType() == Notification.SET && n.getFeatureID(Resource.class) == Resource.RESOURCE__URI) {
				r.setModified(true);

				TreeIterator<Object> properContents = EcoreUtil.getAllProperContents(r, true);
				while(properContents.hasNext()) {
					Object obj = properContents.next();
					if (obj instanceof EObject) {
						EObject eObj = (EObject) obj;
						Collection<Setting> references = getUsages(eObj);
						for (Setting setting : references) {
							EStructuralFeature f = setting.getEStructuralFeature();
							if(setting.getEObject() != null && !f.isDerived() && !f.isTransient()) {
								Resource refResource = setting.getEObject().eResource();
								if(refResource != null) {
									refResource.setModified(true);
								}
							}
						}
					}
				}

			} else {
				List objects = new ArrayList();
				if (n.getEventType() == Notification.ADD_MANY) {
					objects = (List<?>)n.getNewValue();
				} else if(n.getEventType() == Notification.REMOVE_MANY) {
					objects = (List<?>)n.getOldValue();
				} else if(n.getEventType() == Notification.ADD) {
					objects.add(n.getNewValue());
				} else if(n.getEventType() == Notification.REMOVE) {
					objects.add(n.getOldValue());
				}

				for (Object o : objects) {
					if (o instanceof EObject) {
						EObject parentEObj = ((EObject)o).eContainer();
						if (parentEObj != null && parentEObj.eResource() != null) {
							parentEObj.eResource().setModified(true);
						}
					}
				}
			}
		}
		
		super.notifyChanged(n);
	}

	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<Setting> getUsages(EObject source) {
		if(source == null) {
			return Collections.emptyList();
		}

		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if(crossReferencer == null) {
			// try to register a cross referencer at the highest level
			crossReferencer = new ECrossReferenceAdapter();
			if(source.eResource() != null) {
				if(source.eResource().getResourceSet() != null) {
					crossReferencer.setTarget(source.eResource().getResourceSet());
				} else {
					crossReferencer.setTarget(source.eResource());
				}
			} else {
				crossReferencer.setTarget(source);
			}
		}

		return crossReferencer.getInverseReferences(source, true);
	}
}
