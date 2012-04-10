/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.collection.CollectionViewSource;
import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.papyrus.xwt.jface.DefaultViewerLabelProvider;
import org.eclipse.papyrus.xwt.jface.JFacesHelper;
import org.eclipse.papyrus.xwt.jface.ObservableMapLabelProvider;
import org.eclipse.papyrus.xwt.jface.ObservableTreeContentProvider;
import org.eclipse.papyrus.xwt.metadata.DelegateProperty;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;
import org.eclipse.papyrus.xwt.metadata.IProperty;

/**
 * Handle manually the type conversion. Maybe it can be done using the
 * IConverter. Only the type of IProperty should be IObservableCollection
 * 
 * @author yyang
 * 
 */
public class InputBeanProperty extends DelegateProperty {

	//	public InputBeanProperty(IProperty delegate) {
	//		super(delegate);
	//	}

	public InputBeanProperty(IProperty delegate, ILoadingType loadingType) {
		super(delegate, loadingType);
	}

	@Override
	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if(value == null) {
			return;
		}

		if(value instanceof Class<?>) {
			Class<?> type = (Class<?>)value;
			if(type.isEnum()) {
				value = new WritableList(XWT.getRealm(), Arrays.asList(type.getEnumConstants()), type);
			}
		}

		Class<?> elementType = getElementType();
		if(value.getClass().isArray()) {
			elementType = value.getClass().getComponentType();
		}
		if(value instanceof IObservableList) {
			IObservableList list = (IObservableList)value;
			Object listElementType = list.getElementType();
			if(listElementType instanceof Class<?>) {
				elementType = (Class<?>)listElementType;
			}
		} else if(elementType == Object.class && value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>)value;
			for(Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
				Object object = (Object)iterator.next();
				if(object != null) {
					elementType = object.getClass();
					break;
				}
			}
		}

		if(target instanceof ContentViewer) {
			ContentViewer viewer = (ContentViewer)target;

			String[] propertyNames = JFacesHelper.getViewerProperties(viewer);
			if(target instanceof AbstractTreeViewer) {
				IContentProvider contentProvider = (IContentProvider)viewer.getContentProvider();
				if(contentProvider instanceof ObservableTreeContentProvider) {
					ObservableTreeContentProvider xwtContentProvider = (ObservableTreeContentProvider)contentProvider;
					xwtContentProvider.updateContext(viewer, value);
				}
				if(contentProvider instanceof ObservableTreeContentProvider) {
					ObservableTreeContentProvider listContentProvider = (ObservableTreeContentProvider)contentProvider;
					viewer.setLabelProvider(new ObservableMapLabelProvider(viewer, listContentProvider.getKnownElements(), propertyNames));
				}
			} else {
				IContentProvider contentProvider = viewer.getContentProvider();
				if(value instanceof List<?> || value.getClass().isArray()) {
					if(contentProvider == null) {
						contentProvider = new ObservableListContentProvider();
						viewer.setContentProvider(contentProvider);
					}
					if(propertyNames != null && propertyNames.length > 0 && hasDefaultLabelProvider(viewer) && contentProvider instanceof ObservableListContentProvider) {
						ObservableListContentProvider listContentProvider = (ObservableListContentProvider)contentProvider;
						viewer.setLabelProvider(new ObservableMapLabelProvider(viewer, listContentProvider.getKnownElements(), propertyNames));
					}
				} else if(value instanceof Set<?>) {
					if(contentProvider == null) {
						contentProvider = new ObservableSetContentProvider();
						viewer.setContentProvider(contentProvider);
					}
					if(propertyNames != null && propertyNames.length > 0 && hasDefaultLabelProvider(viewer) && contentProvider instanceof ObservableSetContentProvider) {
						ObservableSetContentProvider setContentProvider = (ObservableSetContentProvider)contentProvider;
						viewer.setLabelProvider(new ObservableMapLabelProvider(viewer, setContentProvider.getKnownElements(), propertyNames));
					}
				}
			}
		}
		if(value instanceof CollectionViewSource) {
			value = ((CollectionViewSource)value).getView();
		} else if((value instanceof Collection<?>) && !(value instanceof IObservableCollection)) {
			value = ObjectUtil.resolveValue(value, IObservableCollection.class, value);
		}
		super.setValue(target, value);
	}

	protected boolean hasDefaultLabelProvider(ContentViewer viewer) {
		IBaseLabelProvider labelProvider = viewer.getLabelProvider();
		return (labelProvider == null || labelProvider.getClass() == DefaultViewerLabelProvider.class);
	}

	protected Class<?> getElementType() {
		IProperty property = getDelegate();
		Class<?> type = property.getType();
		if(type == null) {
			return Object.class;
		}
		if(type.isArray()) {
			return type.getComponentType();
		}
		return Object.class;
	}
}
