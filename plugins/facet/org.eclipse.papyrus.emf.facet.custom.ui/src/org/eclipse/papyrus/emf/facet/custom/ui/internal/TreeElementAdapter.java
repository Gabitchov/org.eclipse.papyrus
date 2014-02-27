/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 386387 - [CustomizedTreeContentProvider] The TreeElements are not preserved between two calls to getElements()
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exception.CustomizedContentProviderRuntimeException;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EAttributeTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement;

public class TreeElementAdapter implements Adapter {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
		.getDefault());

	private final EObjectTreeElement treeElement;

	public TreeElementAdapter(final EObjectTreeElement treeElement) {
		this.treeElement = treeElement;
	}

	public void notifyChanged(final Notification notification) {
		DebugUtils.debug(DEBUG,
			"Modified element=" + this.treeElement.getEObject()); //$NON-NLS-1$
		DebugUtils.debug(DEBUG,
			"Notification feature=" + notification.getFeature()); //$NON-NLS-1$
		for (Object subElement : this.treeElement
			.getSfTreeElmement()) {
			if( subElement instanceof EStructuralFeatureTreeElement){
				final EStructuralFeature feature = getSF((EStructuralFeatureTreeElement)subElement);
			if (feature.equals(notification.getFeature())) {
				((EStructuralFeatureTreeElement)subElement).getReferedEObjectTE().clear();
				DebugUtils.debug(
					DEBUG,
					NLS.bind(
						"Cleanning= {0}::{1}", //$NON-NLS-1$
						feature.getContainerClass().getName(),
						feature.getName()));
			}
		}
	}
}

private static EStructuralFeature getSF(
	final EStructuralFeatureTreeElement structFeatuteTE) {
	EStructuralFeature result;
	if (structFeatuteTE instanceof EAttributeTreeElement) {
		final EAttributeTreeElement eAttributeTE = (EAttributeTreeElement) structFeatuteTE;
		result = eAttributeTE.getEAttribute();
	} else if (structFeatuteTE instanceof EReferenceTreeElement) {
		final EReferenceTreeElement eReferenceTE = (EReferenceTreeElement) structFeatuteTE;
		result = eReferenceTE.getEReference();
	} else {
		throw new CustomizedContentProviderRuntimeException(
			"Illegal agrument: " + structFeatuteTE); //$NON-NLS-1$
	}
	return result;
}

public Notifier getTarget() {
	return null;
}

public void setTarget(final Notifier newTarget) {
	// Nothing to do
}

public boolean isAdapterForType(final Object type) {
	return false;
}

}
