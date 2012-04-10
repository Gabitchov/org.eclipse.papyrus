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
package org.eclipse.papyrus.xwt.databinding;

import java.beans.BeanInfo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.core.internal.databinding.property.value.SimplePropertyObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;
import org.eclipse.papyrus.xwt.internal.databinding.menuitem.MenuItemEnabledObservableValue;
import org.eclipse.papyrus.xwt.internal.databinding.menuitem.MenuItemSelectionObservableValue;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class JFaceXWTDataBinding {

	static final String ENABLED = "enabled";

	static final String SELECTION = "selection";

	static final String TEXT = "text";

	public static final Class<?>[] CONTROL_ARGUMENT_TYPES = new Class[]{ Control.class };

	public static final Class<?>[] VIEWER_ARGUMENT_TYPES = new Class[]{ Viewer.class };

	static String[] VIEWERS_PROPERTIES = null;
	static {
		Method[] methods = ViewerProperties.class.getDeclaredMethods();
		VIEWERS_PROPERTIES = new String[methods.length];
		for(int i = 0; i < methods.length; i++) {
			VIEWERS_PROPERTIES[i] = methods[i].getName();
		}
	}

	public static boolean isViewerProperty(String propertyName) {
		for(String name : VIEWERS_PROPERTIES) {
			if(name.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}

	public static Class<?> getValueType(Class<?> type, String propertyName) {
		if(type == null || propertyName == null || propertyName.indexOf(".") != -1) {
			return null;
		}
		try {
			IMetaclass metaclass = XWT.getMetaclass(type);
			IProperty property = metaclass.findProperty(propertyName);
			if(property != null) {
				return property.getType();
			}
		} catch (Exception e) {
			LoggerManager.log(e);
		}
		return null;
	}

	public static Object getValue(Object target, String propertyName) {
		if(target == null || propertyName == null || propertyName.indexOf(".") != -1) {
			return target;
		}
		Class<?> type = target.getClass();
		try {
			BeanInfo beanInfo = java.beans.Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pd : propertyDescriptors) {
				if(propertyName.equalsIgnoreCase(pd.getName())) {
					Method readMethod = pd.getReadMethod();
					if(readMethod != null) {
						return readMethod.invoke(target);
					}
				}
			}
			Field[] fields = type.getDeclaredFields();
			for(Field field : fields) {
				if(propertyName.equalsIgnoreCase(field.getName())) {
					Object object = field.get(target);
					return object;
				}
			}
			return UserData.getLocalData(target, propertyName);
		} catch (Exception e) {
			LoggerManager.log(e);
		}
		return null;
	}

	public static void setValue(Object target, String propertyName, Object value) {
		Class<?> type = target.getClass();
		try {
			BeanInfo beanInfo = java.beans.Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pd : propertyDescriptors) {
				if(propertyName.equals(pd.getName())) {
					Method writeMethod = pd.getWriteMethod();
					if(writeMethod == null) {
						return;
					}
					if(!writeMethod.isAccessible()) {
						writeMethod.setAccessible(true);
					}
					Class<?>[] parameterTypes = writeMethod.getParameterTypes();
					Class targetType = parameterTypes[0];
					if(targetType != value.getClass()) {
						if(targetType.isEnum() && value instanceof String) {
							try {
								writeMethod.invoke(target, new Object[]{ Enum.valueOf(targetType, (String)value) });
								return;
							} catch (Exception e) {
							}
						}
						IConverter c = XWT.findConvertor(value.getClass(), targetType);
						if(c != null) {
							value = c.convert(value);
						}
					}
					writeMethod.invoke(target, new Object[]{ value });
					return;
				}
			}
			Field[] fields = type.getDeclaredFields();
			for(Field field : fields) {
				if(propertyName.equals(field.getName())) {
					if(!field.isAccessible()) {
						field.setAccessible(true);
					}
					Class fieldType = field.getType();
					if(fieldType.isEnum() && value instanceof String) {
						try {
							field.set(target, Enum.valueOf(fieldType, (String)value));
							return;
						} catch (Exception e) {
						}
					}
					IConverter c = XWT.findConvertor(value.getClass(), fieldType);
					if(c != null) {
						value = c.convert(value);
					}
					field.set(target, value);
					return;
				}
			}

			IMetaclass metaclass = XWT.getMetaclass(type);
			IProperty property = metaclass.findProperty(propertyName);
			if(property != null) {
				property.setValue(target, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isPropertyReadOnly(Class<?> type, String propertyName) {
		if(type == null || propertyName == null || propertyName.indexOf(".") != -1) {
			return true;
		}
		try {
			IMetaclass metaclass = XWT.getMetaclass(type);
			IProperty property = metaclass.findProperty(propertyName);
			if(property != null) {
				return property.isReadOnly();
			}
		} catch (Exception e) {
			LoggerManager.log(e);
		}
		return true;
	}


	public static boolean isBeanSupport(Object target) {
		Class<?> type = toType(target);
		Method method = null;
		try {
			try {
				method = type.getMethod("addPropertyChangeListener", new Class[]{ String.class, PropertyChangeListener.class });
			} catch (NoSuchMethodException e) {
				method = type.getMethod("addPropertyChangeListener", new Class[]{ PropertyChangeListener.class });
			}
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		}
		return method != null;
	}

	public static Class<?> toType(Object target) {
		Class<?> type = null;
		if(target instanceof IObservableValue) {
			IObservableValue value = (IObservableValue)target;
			Object valueType = value.getValueType();
			if(valueType instanceof Class<?>) {
				type = (Class<?>)valueType;
			}
		} else if(target instanceof Class<?>) {
			type = (Class<?>)target;
		} else {
			type = target.getClass();
		}
		if(type == null) {
			return Object.class;
		}
		return type;
	}

	public static boolean isValueProperty(Class<?> object, String propertyName) {
		if(propertyName == null) {
			return false;
		}

		if(Viewer.class.isAssignableFrom(object)) {
			return isViewerValueProperty(object, propertyName);
		} else if(MenuItem.class.isAssignableFrom(object)) {
			//
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=280157
			// testcase:
			// org.eclipse.papyrus.xwt.tests.databinding.bindcontrol.BindMenuItem
			//
			if(ENABLED.equalsIgnoreCase(propertyName)) {
				return true;
			} else if(SELECTION.equalsIgnoreCase(propertyName)) {
				return true;
			}
		}
		boolean isProperty = isControlValueProperty(object, propertyName);
		if(isProperty) {
			return true;
		}
		return false;
	}

	public static IObservable observeWidget(Object object, String propertyName, UpdateSourceTrigger updateSourceTrigger, int observedKind) {
		if(propertyName == null) {
			return null;
		}
		try {
			switch(observedKind) {
			case ScopeManager.AUTO:
				return observePropertyValue(object, propertyName, updateSourceTrigger);
			case ScopeManager.COLLECTION:
			case ScopeManager.SET:
			case ScopeManager.LIST:
				break;
			case ScopeManager.VALUE:
				return observePropertyValue(object, propertyName, updateSourceTrigger);
			default:
				break;
			}
		} catch (XWTException e) {
		}
		return null;
	}

	protected static IObservable observePropertyValue(Object object, String propertyName, UpdateSourceTrigger updateSourceTrigger) {
		if(object instanceof Viewer) {
			if("input".equals(propertyName)) {
				Viewer viewer = (Viewer)object;
				SimpleValueProperty property = (SimpleValueProperty)ViewerProperties.input();
				IObservableValue observableValue = new SimplePropertyObservableValue(XWT.getRealm(), viewer, property);
				return new TypedViewerObservableValueDecorator(observableValue, viewer);
			} else if("singleSelection".equals(propertyName)) {
				Viewer viewer = (Viewer)object;
				SimpleValueProperty property = (SimpleValueProperty)ViewerProperties.singleSelection();
				IObservableValue observableValue = new SimplePropertyObservableValue(XWT.getRealm(), viewer, property);
				return new TypedViewerObservableValueDecorator(observableValue, viewer);
			}
			return observePropertyValue((Viewer)object, propertyName, updateSourceTrigger);
		} else if(object instanceof MenuItem) {
			//
			// TODO https://bugs.eclipse.org/bugs/show_bug.cgi?id=280157
			// testcase:
			// org.eclipse.papyrus.xwt.tests.databinding.bindcontrol.BindMenuItem
			//
			if(ENABLED.equalsIgnoreCase(propertyName)) {
				return new MenuItemEnabledObservableValue((MenuItem)object);
			} else if(SELECTION.equalsIgnoreCase(propertyName)) {
				return new MenuItemSelectionObservableValue((MenuItem)object);
			}
		} else if(object instanceof Control) {
			return observePropertyValue((Control)object, propertyName, updateSourceTrigger);
		}
		return null;
	}

	protected static boolean isControlValueProperty(Class<?> type, String propertyName) {
		if(TEXT.equalsIgnoreCase(propertyName)) {
			if(Text.class.isAssignableFrom(type)) {
				return true;
			}
			// widget button is not supported at 3.4 version.
			if(SWT.getVersion() == 3449 && Button.class.isAssignableFrom(type)) {
				return false;
			}
		}
		String getterName = "observe" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
		Method method;
		try {
			method = SWTObservables.class.getMethod(getterName, CONTROL_ARGUMENT_TYPES);
			if(method == null) {
				for(Method element : SWTObservables.class.getMethods()) {
					if(element.getParameterTypes().length != 0) {
						continue;
					}
					if(element.getName().equalsIgnoreCase(getterName)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			throw new XWTException(e);
		}
		IMetaclass mateclass = XWT.getMetaclass(type);
		IProperty property = mateclass.findProperty(propertyName);
		if(property instanceof EventProperty) {
			return true;
		}
		return false;
	}

	protected static IObservableValue observePropertyValue(Control control, String propertyName, UpdateSourceTrigger updateSourceTrigger) {
		if(TEXT.equalsIgnoreCase(propertyName)) {
			if(control instanceof Text || control instanceof StyledText) {
				int event = SWT.None;
				switch(updateSourceTrigger) {
				case Default:
					event = SWT.FocusOut;
					break;
				case LostFocus:
					event = SWT.FocusOut;
					break;
				case PropertyChanged:
					event = SWT.Modify;
					break;
				default:
					throw new IllegalStateException("UpdateSourceTrigger of value " + updateSourceTrigger.name());
				}
				IObservableValue observableValue = SWTObservables.observeText(control, event);
				if(observableValue != null) {
					return observableValue;
				}
			}
			// widget button is not supported at 3.4 version.
			if(SWT.getVersion() == 3449 && control instanceof Button) {
				return null;
			}
			try {
				IObservableValue observableValue = SWTObservables.observeText(control);
				if(observableValue != null) {
					return observableValue;
				}
			} catch (IllegalArgumentException e) {
				throw new XWTException(e);
			}
		} else {
			if(propertyName == null) {
				return null;
			}
			String getterName = "observe" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
			Method method;
			try {
				method = SWTObservables.class.getMethod(getterName, CONTROL_ARGUMENT_TYPES);
				if(method == null) {
					for(Method element : SWTObservables.class.getMethods()) {
						if(element.getParameterTypes().length != 0) {
							continue;
						}
						if(element.getName().equalsIgnoreCase(getterName)) {
							method = element;
							break;
						}
					}
				}
				if(method != null) {
					IObservableValue observableValue = (IObservableValue)method.invoke(null, control);
					if(observableValue != null) {
						return observableValue;
					}
				}
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
		IMetaclass mateclass = XWT.getMetaclass(control);
		IProperty property = mateclass.findProperty(propertyName);
		if(property instanceof EventProperty) {
			return new EventPropertyObservableValue(control, (EventProperty)property);
		}
		return null;
	}

	protected static boolean isViewerValueProperty(Class<?> viewerType, String property) {
		String getterName = "observe" + property.substring(0, 1).toUpperCase() + property.substring(1);
		try {
			Method method = ViewersObservables.class.getMethod(getterName, VIEWER_ARGUMENT_TYPES);
			if(method == null) {
				for(Method element : ViewersObservables.class.getMethods()) {
					if(element.getParameterTypes().length != 0) {
						continue;
					}
					if(element.getName().equalsIgnoreCase(getterName)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			throw new XWTException(e);
		}
		return false;
	}

	protected static IObservable observePropertyValue(Viewer viewer, String property, UpdateSourceTrigger updateSourceTrigger) {
		String getterName = "observe" + property.substring(0, 1).toUpperCase() + property.substring(1);
		Method method;
		try {
			method = ViewersObservables.class.getMethod(getterName, VIEWER_ARGUMENT_TYPES);
			if(method == null) {
				for(Method element : ViewersObservables.class.getMethods()) {
					if(element.getParameterTypes().length != 0) {
						continue;
					}
					if(element.getName().equalsIgnoreCase(getterName)) {
						method = element;
						break;
					}
				}
			}
			if(method != null) {
				IObservable observableValue = (IObservable)method.invoke(null, viewer);
				if(observableValue != null) {
					return observableValue;
				}
			}
		} catch (Exception e) {
			throw new XWTException(e);
		}
		return null;
	}
}
