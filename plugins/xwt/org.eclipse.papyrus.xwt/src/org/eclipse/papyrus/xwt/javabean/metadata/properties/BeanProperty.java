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

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.annotation.Containment;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;

public class BeanProperty extends AbstractProperty {

	protected PropertyDescriptor descriptor;

	private boolean containment = false;

	public BeanProperty(PropertyDescriptor descriptor) {
		this(descriptor, ILoadingType.DEFAULT);
	}

	public BeanProperty(PropertyDescriptor descriptor, ILoadingType loadingType) {
		super(descriptor.getName(), descriptor.getPropertyType(), loadingType);
		this.descriptor = descriptor;

		Method readMethod = descriptor.getReadMethod();
		if(readMethod != null) {
			Annotation annotation = readMethod.getAnnotation(Containment.class);
			if(annotation != null) {
				containment = true;
			}
		}
		Method writeMethod = descriptor.getWriteMethod();
		if(writeMethod != null) {
			Annotation annotation = writeMethod.getAnnotation(Containment.class);
			if(annotation != null) {
				containment = true;
			}
		}
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if(descriptor != null && descriptor.getWriteMethod() != null) {
			Method writeMethod = descriptor.getWriteMethod();
			// Bug of invoke boolean value.
			Class<?>[] parameterTypes = writeMethod.getParameterTypes();
			if(parameterTypes.length == 1) {
				Class<?> type = parameterTypes[0];
				Class<?> propertyType = getType();
				if(propertyType != Object.class) {
					type = propertyType;
				}
				if(!ObjectUtil.isAssignableFrom(IBinding.class, propertyType)) {
					if(value != null && type != value.getClass()) {
						value = ObjectUtil.resolveValue(value, type, value);
					}
				}

				Object oldValue = null;
				Method readMethod = descriptor.getReadMethod();
				if(readMethod != null) {
					oldValue = readMethod.invoke(target);
				}

				if(value == null && type != null && UserData.getWidget(target) != null) {
					if(type == String.class) {
						value = "";
					} else if(type == Boolean.class) {
						value = false;
					}
				}

				if(oldValue != value) {
					writeMethod.setAccessible(true);
					try {
						writeMethod.invoke(target, value);
						fireSetPostAction(target, this, value);
					} catch (IllegalArgumentException e) {
						if(value == null) {
							throw new XWTException("Property type " + getName() + " of " + target.getClass().getName() + " cannot be null.", e);
						}
						throw new XWTException("Property type " + getName() + " of " + target.getClass().getName() + " is mismatch with " + value.getClass().getName() + " expected type is " + parameterTypes[0].getName(), e);
					} catch (InvocationTargetException e) {
						throw new XWTException("Problem of invoke " + getName() + " of " + target.getClass().getName() + " with a value of type " + value.getClass().getName(), e);
					}
				}
			}
		}
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if(descriptor != null && descriptor.getReadMethod() != null) {
			Method readMethod = descriptor.getReadMethod();
			readMethod.setAccessible(true);
			return readMethod.invoke(target);
		}
		return null;
	}

	@Override
	public boolean isDefault() {
		return true;
	}

	public boolean isContainement() {
		return containment;
	}

	public boolean isReadOnly() {
		return descriptor.getWriteMethod() == null;
	}
}
