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
package org.eclipse.papyrus.xwt.internal.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.ILoadingContext;
import org.eclipse.papyrus.xwt.internal.xml.DocumentObject;
import org.eclipse.papyrus.xwt.internal.xml.Element;

public class ClassLoaderUtil {

	static final String[] DefaultPackages = new String[]{
	/*
	 * UIElement.class.getPackage().getName(), Validation.class.getPackage().getName(), Timeline.class.getPackage().getName(),
	 * Binding.class.getPackage().getName(),
	 */};

	static public Class<?> loadClass(ILoadingContext loadingContext, String className) {
		Class<?> type = doLoadClass(loadingContext, className);
		if(type != null) {
			return type;
		}
		int index = className.indexOf('.');
		if(index == -1) {
			for(String packageName : DefaultPackages) {
				type = doLoadClass(loadingContext, packageName + "." + className);
				if(type != null) {
					return type;
				}
			}
		}
		return null;
	}

	private static Class<?> doLoadClass(ILoadingContext loadingContext, String className) {
		Class<?> type = loadingContext.loadClass(className);
		if(type != null) {
			return type;
		}
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e1) {
		}
		return null;
	}

	static public Object loadMember(ILoadingContext loadingContext, String className, String memberName, boolean raiseException) {
		Class<?> type = loadClass(loadingContext, className);
		return loadMember(loadingContext, type, memberName, raiseException);
	}

	static public Object loadMember(ILoadingContext loadingContext, Class<?> type, String memberName, boolean raiseException) {

		try {
			Field field = type.getField(memberName);
			if(raiseException && !Modifier.isStatic(field.getModifiers())) {
				throw new IllegalStateException(type.getName() + "." + memberName + " is not static member.");
			}
			return field.get(null);
		} catch (Exception e) {
			if(e instanceof NoSuchFieldException) {
				Method method = ObjectUtil.findGetter(type, memberName, null);
				if(raiseException && (method == null || !Modifier.isStatic(method.getModifiers()))) {
					throw new IllegalStateException(type.getName() + "." + memberName + " is not static member.");
				}
				try {
					return method.invoke(null);
				} catch (Exception exception) {
					e = exception;
				}
			}
			if(raiseException) {
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

	static public Object loadStaticMember(ILoadingContext loadingContext, Element element) {
		String name = element.getName();
		String namespace = element.getNamespace();
		Object value = doLoadMember(loadingContext, name, namespace);
		if(value != null) {
			return value;
		}
		String content = element.getContent();
		if(content == null) {
			DocumentObject member = element.getAttribute(IConstants.XWT_NAMESPACE, IConstants.XAML_X_STATIC_MEMBER);
			if(member == null) {
				member = element;
			}
			if(member != null) {
				content = member.getContent();
				if(content == null) {
					for(DocumentObject documentObject : member.getChildren()) {
						String ns = documentObject.getNamespace();
						String n = documentObject.getName();
						return doLoadMember(loadingContext, n, ns);
					}
				}
			}
		} else {
			if(IConstants.XAML_X_STATIC.equals(name) && IConstants.XWT_X_NAMESPACE.equals(namespace)) {
				namespace = IConstants.XWT_NAMESPACE;
				return doLoadMember(loadingContext, content, namespace);
			}
		}
		// TODO
		return null;
	}

	protected static Object doLoadMember(ILoadingContext loadingContext, String name, String namespace) {
		int lastIndex = name.lastIndexOf('.');
		if(lastIndex == -1) {
			throw new IllegalStateException("Separator '.' is missing in:" + name);
		}
		String className = name.substring(0, lastIndex);
		String memberName = name.substring(lastIndex + 1);

		try {
			Class<?> type = NamespaceHelper.loadCLRClass(loadingContext, className, namespace);
			if(type != null) {
				return ClassLoaderUtil.loadMember(loadingContext, type, memberName, true);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
