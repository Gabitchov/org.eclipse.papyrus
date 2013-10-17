/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.views;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.SharedImages;
import org.eclipse.swt.graphics.Image;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the DIModel type. Enjoy.
 */
public class DIModel extends PlatformObject implements Adapter {

	private final CDOResource resource;

	public DIModel(CDOResource resource) {
		this.resource = resource;

		// ensure that I am the only adapter
		for(Iterator<Adapter> iter = resource.eAdapters().iterator(); iter.hasNext();) {

			if(iter.next() instanceof DIModel) {
				iter.remove();
			}
		}
		resource.eAdapters().add(this);
	}

	public final CDOResource getResource() {
		return resource;
	}

	public static DIModel getInstance(CDOResource resource, boolean create) {
		DIModel result = (DIModel)EcoreUtil.getExistingAdapter(resource, DIModel.class);

		if((result == null) && create) {
			result = new DIModel(resource);
		}

		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if((adapter == CDOResourceNode.class) || (adapter == CDOResource.class) || (adapter == CDOObject.class) || (adapter == EObject.class)) {
			return getResource();
		}

		return super.getAdapter(adapter);
	}

	public String getName() {
		return resource.getURI().trimFileExtension().lastSegment();
	}

	public Image getImage() {
		return SharedImages.getImage(Activator.ICON_PAPYRUS_MODEL);
	}

	public Object[] getChildren() {
		List<CDOResource> result = Lists.newArrayListWithExpectedSize(3);

		String name = getName();
		if(name != null) {
			Collection<? extends EObject> nodes;
			CDOResourceFolder folder = getResource().getFolder();
			if(folder != null) {
				nodes = folder.getNodes();
			} else {
				CDOResource root = getResource().cdoResource();
				if((root != null) && root.isRoot()) {
					nodes = root.getContents();
				} else {
					nodes = Collections.emptyList();
				}
			}

			for(CDOResource next : Iterables.filter(nodes, CDOResource.class)) {
				if(name.equals(next.getURI().trimFileExtension().lastSegment())) {

					result.add(next);
				}
			}
		}

		return result.toArray();
	}

	@Override
	public void notifyChanged(Notification notification) {
		// pass
	}

	@Override
	public Notifier getTarget() {
		return resource;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// pass
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DIModel.class;
	}
}
