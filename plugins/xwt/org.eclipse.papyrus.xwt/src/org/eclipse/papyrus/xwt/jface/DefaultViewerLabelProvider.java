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
package org.eclipse.papyrus.xwt.jface;

import org.eclipse.jface.viewers.AbstractTableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.internal.core.Core;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.PropertiesConstants;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class DefaultViewerLabelProvider implements ITableLabelProvider, ILabelProvider {

	private Viewer viewer;

	protected String bindingPath;

	private IProperty columnsProperty;

	public DefaultViewerLabelProvider(Viewer viewer) {
		this.viewer = viewer;
	}

	public String getBindingPath() {
		return bindingPath;
	}

	public void setBindingPath(String bindingPath) {
		this.bindingPath = bindingPath;
	}

	protected IProperty getColumnsProperty() {
		if(columnsProperty == null) {
			IMetaclass metaclass = XWT.getMetaclass(viewer.getClass());
			columnsProperty = metaclass.findProperty(PropertiesConstants.PROPERTY_COLUMNS);
			if(columnsProperty == null) {
				throw new XWTException("Columns property is not found.");
			}
		}
		return columnsProperty;
	}

	protected Viewer getViewer() {
		return viewer;
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	public Image getImage(Object element) {
		return getColumnImage(element, 0);
	}

	public String getText(Object dataContext) {
		return getColumnText(dataContext, 0);
	}

	public String getColumnText(Object element, int columnIndex) {
		return JFacesHelper.getColumnText(getViewer(), element, columnIndex, getPaths());
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return JFacesHelper.getColumnImage(getViewer(), element, columnIndex, getPaths());
	}

	protected Object[] getPaths() {
		Viewer viewer = getViewer();
		if(viewer instanceof AbstractTableViewer) {
			Object[] objects = ((AbstractTableViewer)getViewer()).getColumnProperties();
			for(int i = 0; i < objects.length; i++) {
				if((objects[i] == null)) {
					objects[i] = getBindingPath();
				}
			}
			return objects;
		}
		String path = bindingPath;
		if(path == null) {
			path = (String)UserData.getLocalData(getViewer(), IUserDataConstants.XWT_PROPERTY_DATA_KEY);
		}
		if(path == null) {
			return Core.EMPTY_ARRAY;
		}
		return new String[]{ path };
	}
}
