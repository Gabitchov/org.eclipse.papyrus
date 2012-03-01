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
package org.eclipse.papyrus.infra.gmfdiag.common.listener;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;


public class CustomStyleListener extends AdapterImpl {

	private final Collection<String> styleNames;

	private final IChangeListener listener;

	private boolean disposed;

	private final EStructuralFeature listenedFeature;

	public CustomStyleListener(View source, EStructuralFeature listenedFeature, IChangeListener listener, String styleName) {
		this(source, listenedFeature, listener, Collections.singleton(styleName));
	}

	public CustomStyleListener(View source, IChangeListener listener, Collection<String> styleNames) {
		this(source, null, listener, styleNames);
	}

	public CustomStyleListener(View source, EStructuralFeature listenedFeature, IChangeListener listener, Collection<String> styleNames) {
		this.styleNames = styleNames;
		this.listener = listener;
		this.listenedFeature = listenedFeature;
		for(Object styleObject : source.getStyles()) {
			if(styleObject instanceof NamedStyle) {
				NamedStyle style = (NamedStyle)styleObject;
				if(styleNames.contains(style.getName())) {
					//FIXME: If a style's name is change, we won't be notified. We should probably listen on all styles
					style.eAdapters().add(this);
				}
			}
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		if(disposed) {
			((Notifier)notification.getNotifier()).eAdapters().remove(this);
			return;
		}

		if(notification.getFeature() == NotationPackage.eINSTANCE.getView_Styles()) {
			switch(notification.getEventType()) {
			case Notification.ADD:
				handleAdd((EObject)notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for(Object object : (List<?>)notification.getNewValue()) {
					handleAdd((EObject)object);
				}
				break;
			case Notification.REMOVE:
				handleRemove((EObject)notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for(Object object : (List<?>)notification.getOldValue()) {
					handleRemove((EObject)object);
				}
				break;
			}
		}

		if(notification.getFeature() == listenedFeature || listenedFeature == null) {
			if(notification.getNotifier() instanceof NamedStyle && styleNames.contains(((NamedStyle)notification.getNotifier()).getName())) {
				if(!notification.isTouch()) {
					listener.handleChange(null);
				}
			}
		}
	}

	private void handleRemove(EObject oldValue) {
		oldValue.eAdapters().remove(this);
		handleChange(oldValue);
	}

	private void handleAdd(EObject newValue) {
		newValue.eAdapters().add(this);
		handleChange(newValue);
	}

	private void handleChange(EObject value) {
		if(value instanceof NamedStyle) {
			if(styleNames.contains(((NamedStyle)value).getName())) {
				listener.handleChange(null);
				return;
			}
		}
	}

	public void dispose() {
		this.disposed = true;
	}

}
