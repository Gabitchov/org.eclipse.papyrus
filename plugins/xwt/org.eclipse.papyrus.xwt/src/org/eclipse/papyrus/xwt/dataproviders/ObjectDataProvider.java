/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *
 * Contributors:                                                               *
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.dataproviders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.databinding.JFaceXWTDataBinding;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class ObjectDataProvider extends AbstractDataProvider implements IObjectDataProvider {

	static DataModelService dataModelService = new DataModelService() {

		public Object toModelType(Object object) {
			return JFaceXWTDataBinding.toType(object);
		}

		public Object loadModelType(String className) {
			return XWT.getLoadingContext().loadClass(className);
		}

		public Object toModelPropertyType(Object type, String propertyName) {
			IMetaclass metaclass = XWT.getMetaclass(type);
			IProperty property = metaclass.findProperty(propertyName);

			if(property == null) {
				throw new XWTException(" Property \"" + propertyName + "\" is not found in the class " + metaclass.getType().getName());
			}
			return property.getType();
		}
	};

	private Object objectInstance;

	private Class<?> objectType;

	private String methodName;

	private List<Object> methodParameters;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#getMethodName()
	 */
	public String getMethodName() {
		return methodName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#getMethodParameters
	 * ()
	 */
	public List<Object> getMethodParameters() {
		return methodParameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#getObjectInstance()
	 */
	public Object getObjectInstance() {
		if(objectInstance == null && objectType != null) {
			try {
				objectInstance = objectType.newInstance();
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
		return objectInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#getObjectType()
	 */
	public Class<?> getObjectType() {
		if(objectType == null && objectInstance != null) {
			objectType = objectInstance.getClass();
		}
		return objectType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#setMethodName(java
	 * .lang.String)
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#setMethodParameters
	 * (java.util.List)
	 */
	public void setMethodParameters(List<Object> parameters) {
		this.methodParameters = parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#setObjectInstance
	 * (java.lang.Object)
	 */
	public void setObjectInstance(Object objectImstance) {
		this.objectInstance = objectImstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IObjectDataProvider#setObjectType(java
	 * .lang.Class)
	 */
	public void setObjectType(Class<?> objectType) {
		this.objectType = objectType;
	}

	protected Object getTarget() {
		Object target = getObjectInstance();
		if(target == null) {
			return null;
		}
		Class<?> targetType = getObjectType();
		Method method = null;
		if(methodName != null) {
			List<Class<?>> paras = new ArrayList<Class<?>>();
			if(methodParameters != null) {
				for(Object p : methodParameters) {
					paras.add(p.getClass());
				}
			}
			try {
				if(paras.isEmpty()) {
					method = targetType.getDeclaredMethod(methodName);
					return method.invoke(target);
				} else {
					method = targetType.getDeclaredMethod(methodName, paras.toArray(new Class<?>[paras.size()]));
					return method.invoke(target, methodParameters.toArray(new Object[methodParameters.size()]));
				}
			} catch (SecurityException e) {
			} catch (IllegalArgumentException e) {
			} catch (NoSuchMethodException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
		}
		return target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IDataProvider#getData(java.lang.String)
	 */
	public Object getData(String path) {
		if(path == null) {
			return getTarget();
		}
		return getData(getTarget(), path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IDataProvider#getData(java.lang.String)
	 */
	public Object getData(Object object, String path) {
		if(object instanceof IObservableValue) {
			object = ((IObservableValue)object).getValue();
		}
		if(path == null || path.trim().length() == 0 || path.equals(".")) {
			return JFaceXWTDataBinding.getValue(object, null);
		}
		int index = path.indexOf(".");
		while(index != -1 && object != null) {
			object = JFaceXWTDataBinding.getValue(object, path.substring(0, index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		return JFaceXWTDataBinding.getValue(object, path);
	}

	public void setData(Object object, String path, Object value) {
		if(object instanceof IObservableValue) {
			object = ((IObservableValue)object).getValue();
		}
		int index = path.indexOf(".");
		while(index != -1 && object != null) {
			object = JFaceXWTDataBinding.getValue(object, path.substring(0, index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		JFaceXWTDataBinding.setValue(object, path, value);
	}

	public void setData(String path, Object value) {
		setData(getTarget(), path, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.dataproviders.IDataProvider#getDataType(java.lang.
	 * String)
	 */
	public Class<?> getDataType(String path) {
		Object target = getTarget();
		if(target == null) {
			return null;
		}
		Class<?> type = JFaceXWTDataBinding.toType(target);
		if(path == null) {
			return type;
		}
		return JFaceXWTDataBinding.getValueType(type, path);
	}

	/**
	 * check if the property is read only
	 * 
	 * @param path
	 * @return
	 */
	public boolean isPropertyReadOnly(String path) {
		Object target = getTarget();
		if(target == null || path == null) {
			return true;
		}
		if(target instanceof IBinding) {
			target = ((IBinding)target).getValue(null);
		}
		Class<?> type = JFaceXWTDataBinding.toType(target);
		int index = path.indexOf(".");
		while(index != -1 && target != null) {
			type = JFaceXWTDataBinding.getValueType(type, path.substring(0, index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		return JFaceXWTDataBinding.isPropertyReadOnly(type, path);
	}

	@Override
	protected IObservableValue observeValue(Object bean, String propertyName) {
		if(JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeValue(XWT.getRealm(), bean, propertyName);
		}
		return PojoObservables.observeValue(XWT.getRealm(), bean, propertyName);
	}

	protected IObservableList observeList(Object bean, String propertyName) {
		if(JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeList(XWT.getRealm(), bean, propertyName);
		}
		return PojoObservables.observeList(XWT.getRealm(), bean, propertyName);
	}

	protected IObservableSet observeSet(Object bean, String propertyName) {
		if(JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeSet(XWT.getRealm(), bean, propertyName);
		}
		return PojoObservables.observeSet(XWT.getRealm(), bean, propertyName);
	}

	protected IObservableList observeDetailList(IObservableValue bean, Object elementType, String propertyName, Object propertyType) {
		if(JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeDetailList(bean, propertyName, (Class<?>)propertyType);
		}
		return PojoObservables.observeDetailList(bean, propertyName, (Class<?>)propertyType);
	}

	protected IObservableSet observeDetailSet(IObservableValue bean, Object elementType, String propertyName, Object propertyType) {
		if(JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeDetailSet(bean, propertyName, (Class<?>)propertyType);
		}
		return PojoObservables.observeDetailSet(bean, propertyName, (Class<?>)propertyType);
	}

	@Override
	protected IObservableValue observeDetailValue(IObservableValue master, Object elementType, String propertyName, Object propertyType) {
		Class<?> beanClass = (Class<?>)elementType;
		if(beanClass == null && master.getValueType() instanceof Class<?>) {
			beanClass = (Class<?>)master.getValueType();
		}
		if(JFaceXWTDataBinding.isBeanSupport(beanClass)) {
			return BeanProperties.value(beanClass, propertyName, (Class<?>)propertyType).observeDetail(master);
		}
		return PojoProperties.value(beanClass, propertyName, (Class<?>)propertyType).observeDetail(master);
	}

	public IValueProperty createValueProperty(Object type, String propertyName) {
		if(JFaceXWTDataBinding.isBeanSupport(type)) {
			return BeanProperties.value(JFaceXWTDataBinding.toType(type), propertyName);
		}
		return PojoProperties.value(JFaceXWTDataBinding.toType(type), propertyName);
	}

	public DataModelService getModelService() {
		return dataModelService;
	}
}
