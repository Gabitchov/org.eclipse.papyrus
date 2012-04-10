/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Brad Reynolds - bug 164247
 *     Brad Reynolds - bug 164134
 *     yves yang     - port to XWT
 *******************************************************************************/
package org.eclipse.papyrus.xwt.jface;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

/**
 * A label provider based on one or more observable maps that track attributes
 * that this label provider uses for display. Clients may customize by
 * subclassing and overriding {@link #getColumnText(Object, int)}, {@link #getColumnImage(Object, int)}, for tables or trees with columns, or by
 * implementing additional mixin interfaces for colors, fonts etc.
 * 
 * @since 1.1
 * 
 */
public class ObservableMapLabelProvider extends LabelProvider implements ILabelProvider, ITableLabelProvider {

	private final IObservableMap[] textMaps;

	private Viewer viewer;

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {

		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(ObservableMapLabelProvider.this, affectedElements.toArray());
			fireLabelProviderChanged(newEvent);
		}
	};

	/**
	 * @param textMaps
	 */
	public ObservableMapLabelProvider(Viewer viewer, IObservableSet domain, String[] propertyNames) {
		textMaps = new XWTObservableWrapper[propertyNames.length];

		for(int i = 0; i < textMaps.length; i++) {
			textMaps[i] = new XWTObservableWrapper(domain, viewer, propertyNames[i]);
			textMaps[i].addMapChangeListener(mapChangeListener);
		}
		this.viewer = viewer;
	}

	public void dispose() {
		for(int i = 0; i < textMaps.length; i++) {
			textMaps[i].removeMapChangeListener(mapChangeListener);
		}
		super.dispose();
	}

	public Image getImage(Object element) {
		return getColumnImage(element, 0);
	}

	public Image getColumnImage(Object element, int columnIndex) {
		if(columnIndex < textMaps.length) {
			Object result = textMaps[columnIndex].get(element);
			return JFacesHelper.getColumnImage(viewer, result, columnIndex);
		}
		return null;
	}

	public String getText(Object element) {
		return getColumnText(element, 0);
	}

	public String getColumnText(Object element, int columnIndex) {
		if(columnIndex < textMaps.length) {
			Object result = textMaps[columnIndex].get(element);
			return JFacesHelper.getColumnText(viewer, result, columnIndex);
		}
		return null;
	}
}
