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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.internal.core.Core;
import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class JFacesHelper {

	public static Class<?>[] getSupportedElements() {
		return JFACES_SUPPORTED_ELEMENTS;
	}

	public static boolean isViewer(Object obj) {
		if(JFACES_VIEWER == null || obj == null)
			return false;
		return JFACES_VIEWER.isAssignableFrom(obj.getClass());
	}

	public static Control getControl(Object obj) {
		if(!isViewer(obj))
			throw new XWTException("Expecting a JFaces viewer:" + obj);
		try {
			Method method = JFACES_VIEWER.getMethod("getControl");
			return (Control)method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Class<?>[] JFACES_SUPPORTED_ELEMENTS;

	private static Class<?> JFACES_VIEWER;

	static {
		List<Class<?>> collector = new ArrayList<Class<?>>();
		try {

			JFACES_VIEWER = Class.forName("org.eclipse.jface.viewers.Viewer");
			String[] jfaceClasses = new String[]{ "org.eclipse.jface.viewers.ComboViewer", "org.eclipse.jface.viewers.ListViewer", "org.eclipse.jface.viewers.TreeViewer", "org.eclipse.jface.viewers.TableViewer", "org.eclipse.jface.viewers.TableTreeViewer", "org.eclipse.jface.viewers.CheckboxTableViewer", "org.eclipse.jface.viewers.CheckboxTreeViewer",
				// Dialogs
			"org.eclipse.jface.dialogs.TrayDialog", "org.eclipse.jface.dialogs.TitleAreaDialog",
				// Add CellEditors for JFave Viewers.
			"org.eclipse.jface.viewers.CellEditor", "org.eclipse.jface.viewers.ComboBoxViewerCellEditor", TextCellEditor.class.getName(), CheckboxCellEditor.class.getName() };
			for(String clazz : jfaceClasses) {
				try {
					collector.add(Class.forName(clazz));
				} catch (Throwable e) {
					System.out.println("No JFaces support for " + clazz);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No JFaces support");
		}
		JFACES_SUPPORTED_ELEMENTS = collector.toArray(new Class[collector.size()]);
	}

	public static String[] getViewerProperties(Viewer viewer) {
		if(viewer instanceof ColumnViewer) {
			ColumnViewer columnViewer = (ColumnViewer)viewer;
			Object[] properties = columnViewer.getColumnProperties();
			String[] propertyNames = Core.EMPTY_STRING_ARRAY;
			if(properties != null) {
				int size = 0;
				for(int i = 0; i < properties.length; i++) {
					if(properties[i] != null) {
						size++;
					}
				}

				propertyNames = new String[size];
				for(int i = 0, j = 0; i < properties.length; i++) {
					if(properties[i] != null) {
						propertyNames[j++] = properties[i].toString();
					}
				}
			}
			if(propertyNames.length != 0) {
				return propertyNames;
			}
		}
		String path = (String)UserData.getLocalData(viewer, IUserDataConstants.XWT_PROPERTY_DATA_KEY);
		if(path != null) {
			return new String[]{ path };
		}
		return Core.EMPTY_STRING_ARRAY;
	}

	public static Object getColumnObject(Object element, int columnIndex, Object[] properties) {
		if(element == null) {
			return null;
		}
		Object dataContext = element;

		if(properties != null && columnIndex < properties.length) {
			Object propertyElement = properties[columnIndex];
			if(propertyElement != null) {
				String propertyName = propertyElement.toString();
				if(propertyName != null) {
					try {
						IMetaclass metaclass = XWT.getMetaclass(dataContext);
						IProperty property = metaclass.findProperty(propertyName.toLowerCase());
						if(property != null) {
							dataContext = property.getValue(dataContext);
							if(dataContext != null) {
								Class<?> type = dataContext.getClass();
								Class<?> propertyType = property.getType();
								if(propertyType != null && !propertyType.isAssignableFrom(type)) {
									dataContext = ObjectUtil.resolveValue(dataContext, type, propertyType, dataContext);
								}
							}
						}
					} catch (Exception e) {
						throw new XWTException(e);
					}
				}
			}
		}
		return dataContext;
	}

	public static String getColumnText(Viewer viewer, Object element, int columnIndex) {
		String[] propertyNames = JFacesHelper.getViewerProperties(viewer);
		return getColumnText(viewer, element, columnIndex, propertyNames);
	}

	public static String getColumnText(Viewer viewer, Object element, int columnIndex, Object[] properties) {
		Object value = getColumnObject(element, columnIndex, properties);

		try {
			if(viewer instanceof TableViewer) {
				Table table = ((TableViewer)viewer).getTable();
				TableColumn[] columns = table.getColumns();
				TableColumn column = columns[columnIndex];
				if(UserData.hasLocalData(column, IUserDataConstants.XWT_PROPERTY_ITEM_TEXT_KEY)) {
					Object userDataValue = UserData.getLocalData(column, IUserDataConstants.XWT_PROPERTY_ITEM_TEXT_KEY);
					if(userDataValue instanceof IBinding) {
						IBinding binding = (IBinding)userDataValue;
						binding.reset();
						UserData.setDataContext(column, value);
						value = binding.getValue(null);
					} else {
						value = userDataValue;
					}
				} else if(UserData.hasLocalData(column, IUserDataConstants.XWT_PROPERTY_ITEM_IMAGE_KEY)) {
					return null;
				}
			}
		} catch (Exception e) {
			throw new XWTException(e);
		}
		if(value != null) {
			return value.toString();
		}
		return "";
	}

	public static Image getColumnImage(Viewer viewer, Object element, int columnIndex) {
		String[] propertyNames = JFacesHelper.getViewerProperties(viewer);
		return getColumnImage(viewer, element, columnIndex, propertyNames);
	}

	public static Image getColumnImage(Viewer viewer, Object element, int columnIndex, Object[] properties) {
		Object value = getColumnObject(element, columnIndex, properties);
		if(value == null) {
			return null;
		}
		try {
			if(viewer instanceof TableViewer) {
				Table table = ((TableViewer)viewer).getTable();
				TableColumn[] columns = table.getColumns();
				TableColumn column = columns[columnIndex];
				if(UserData.hasLocalData(column, IUserDataConstants.XWT_PROPERTY_ITEM_IMAGE_KEY)) {
					Object userDataValue = UserData.getLocalData(column, IUserDataConstants.XWT_PROPERTY_ITEM_IMAGE_KEY);
					if(userDataValue instanceof IBinding) {
						IBinding binding = (IBinding)userDataValue;
						binding.reset();
						UserData.setDataContext(column, value);
						value = binding.getValue(null);
					} else {
						value = userDataValue;
					}
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			throw new XWTException(e);
		}
		if(value instanceof IObservableValue) {
			IObservableValue observableValue = (IObservableValue)value;
			value = observableValue.getValue();
		}
		if(value instanceof Image) {
			return (Image)value;
		} else if(value != null) {
			value = ObjectUtil.resolveValue(value, Image.class, value);
			if(value == null) {
				return null;
			}
			if(value instanceof Image) {
				return (Image)value;
			}
			throw new XWTException("Converter from " + value.getClass() + " to Image is missing.");
		}
		return null;
	}
}
