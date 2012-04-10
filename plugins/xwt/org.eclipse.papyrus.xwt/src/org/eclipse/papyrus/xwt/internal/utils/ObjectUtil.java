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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.papyrus.xwt.XWT;

/**
 * Object Tools.
 * 
 * @author yyang (yves.yang@soyatec.com)
 * @version 1.0
 */
public class ObjectUtil {

	public static final Class<?>[] EMPTY = new Class[0];

	private ObjectUtil() {
	}

	public static Class<?> normalizedType(Class<?> type) {
		if(type == int.class) {
			return Integer.class;
		}
		if(type == double.class) {
			return Double.class;
		}
		if(type == float.class) {
			return Float.class;
		}
		if(type == boolean.class) {
			return Boolean.class;
		}
		return type;
	}

	public static boolean isAssignableFrom(Class<?> source, Class<?> target) {
		if(normalizedType(source) == normalizedType(target)) {
			return true;
		}
		return source.isAssignableFrom(target);
	}

	/**
	 * Find the compatible class. This includes superclasses, interfaces and so on.
	 * 
	 * @param clazz
	 *        the specified class.
	 * @return Returns the class array includes its superclasses, interfaces and itself.
	 */
	public static final Class<?>[] findCompatibleClasses(Class<?> clazz) {
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();

		// Add itself to list.
		classes.add(clazz);

		// Add primitive compatible type
		if(clazz == Boolean.class) {
			classes.add(boolean.class);
		} else if(clazz == Byte.class) {
			classes.add(byte.class);
		} else if(clazz == Short.class) {
			classes.add(short.class);
		} else if(clazz == Integer.class) {
			classes.add(int.class);
		} else if(clazz == Long.class) {
			classes.add(long.class);
		} else if(clazz == Float.class) {
			classes.add(float.class);
		} else if(clazz == Double.class) {
			classes.add(double.class);
		} else if(clazz == Character.class) {
			classes.add(char.class);
		} else if(clazz == boolean.class) {
			classes.add(Boolean.class);
		} else if(clazz == byte.class) {
			classes.add(Byte.class);
		} else if(clazz == short.class) {
			classes.add(Short.class);
		} else if(clazz == int.class) {
			classes.add(Integer.class);
		} else if(clazz == long.class) {
			classes.add(Long.class);
		} else if(clazz == float.class) {
			classes.add(Float.class);
		} else if(clazz == double.class) {
			classes.add(Double.class);
		} else if(clazz == char.class) {
			classes.add(Character.class);
		}

		// Add its interfaces
		findInterfaces(classes, clazz);

		// Add its superclasses
		findSuperClasses(classes, clazz);

		// At last, add Object class.
		classes.add(Object.class);

		return classes.toArray(EMPTY);
	}

	public static Object resolveValue(Object value, Class<?> targetType, Object defaultValue) {
		return resolveValue(value, value.getClass(), targetType, defaultValue);
	}

	public static Object resolveValue(Object value, Class<?> sourceType, Class<?> targetType, Object defaultValue) {
		IConverter converter = XWT.findConvertor(sourceType, targetType);
		if(converter != null) {
			return converter.convert(value);
		}
		return defaultValue;
	}

	/**
	 * Find compatible constructor for specified class.
	 * 
	 * @param clazz
	 *        the specified class.
	 * @param argumentTypes
	 *        constructor argument types.
	 * @return Returns constructor instance. If snot find, returns null.
	 */
	public static final Constructor<?> findConstructor(Class<?> clazz, Class<?>... argumentTypes) {

		Class<?>[][] classesArray = new Class[argumentTypes.length][];

		for(int i = 0, len = argumentTypes.length; i < len; i++) {
			Class<?>[] classes = findCompatibleClasses(argumentTypes[i]);
			classesArray[i] = classes;
		}

		int totalPossibles = 1;
		for(int i = 0; i < classesArray.length; i++) {
			totalPossibles *= classesArray[i].length;
		}

		List<Class<?>[]> classList = new ArrayList<Class<?>[]>(totalPossibles);
		computeArguments(classList, classesArray, new Class[classesArray.length], 0);

		for(Class<?>[] arguments : classList) {
			try {
				return clazz.getConstructor(arguments);
			} catch (NoSuchMethodException e) {
				continue;
			}
		}

		return null;
	}

	/**
	 * Find compatible public method for specified class.
	 * 
	 * @param clazz
	 *        the specified class.
	 * @param name
	 *        method name.
	 * @param argumentTypes
	 *        method argument types. If it is a null value, system will find method without argument types.
	 * @return Returns method instance. If not find, returns null.
	 */
	public static final Method findMethod(Class<?> clazz, String name, Class<?>... argumentTypes) {

		if(argumentTypes != null && argumentTypes.length > 0) {

			Class<?>[][] classesArray = new Class[argumentTypes.length][];

			for(int i = 0, len = argumentTypes.length; i < len; i++) {
				Class<?>[] classes = findCompatibleClasses(argumentTypes[i]);
				classesArray[i] = classes;
			}

			int totalPossibles = 1;
			for(int i = 0; i < classesArray.length; i++) {
				totalPossibles *= classesArray[i].length;
			}

			List<Class<?>[]> classList = new ArrayList<Class<?>[]>(totalPossibles);
			computeArguments(classList, classesArray, new Class[classesArray.length], 0);

			for(Class<?>[] arguments : classList) {
				try {
					return clazz.getDeclaredMethod(name, arguments);
				} catch (NoSuchMethodException e) {
					continue;
				}
			}
		} else {

			// find method without argument types;

			Method[] methods = clazz.getMethods();
			for(Method method : methods) {
				if(method.getName().equals(name)) {
					return method;
				}
			}
		}

		return null;
	}

	/**
	 * Find compatible method for specified class.
	 * 
	 * @param clazz
	 *        the specified class.
	 * @param name
	 *        method name.
	 * @param argumentTypes
	 *        method argument types. If it is a null value, system will find method without argument types.
	 * @return Returns method instance. If not find, returns null.
	 */
	public static final Method findDeclaredMethod(Class<?> clazz, String name, Class<?>... argumentTypes) {

		if(argumentTypes != null && argumentTypes.length > 0) {

			Class<?>[][] classesArray = new Class[argumentTypes.length][];

			for(int i = 0, len = argumentTypes.length; i < len; i++) {
				Class<?>[] classes = findCompatibleClasses(argumentTypes[i]);
				classesArray[i] = classes;
			}

			int totalPossibles = 1;
			for(int i = 0; i < classesArray.length; i++) {
				totalPossibles *= classesArray[i].length;
			}

			List<Class<?>[]> classList = new ArrayList<Class<?>[]>(totalPossibles);
			computeArguments(classList, classesArray, new Class[classesArray.length], 0);

			for(Class<?>[] arguments : classList) {
				try {
					return clazz.getDeclaredMethod(name, arguments);
				} catch (NoSuchMethodException e) {
					continue;
				}
			}
		} else {

			// find method without argument types;
			Method[] methods = clazz.getDeclaredMethods();
			for(Method method : methods) {
				if(method.getName().equals(name) && method.getParameterTypes().length == 0) {
					return method;
				}
			}
		}
		Class<?> superclass = clazz.getSuperclass();
		if(superclass != null) {
			return findDeclaredMethod(superclass, name, argumentTypes);
		}

		return null;
	}

	/**
	 * Find property getter method for specified class.
	 * 
	 * @param clazz
	 *        the specified class.
	 * @param name
	 *        property name
	 * @param type
	 *        property type. If it is a null value, system will find the suitable method.
	 * @return Returns method instance. If not find, returns null.
	 */
	public static final Method findGetter(Class<?> clazz, String name, Class<?> type) {
		if(name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid getter method name, null value found");
		}

		String getterName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);

		Method method;
		try {
			if(clazz.isEnum()) {
				method = clazz.getClass().getMethod(getterName, EMPTY);
			} else {
				method = clazz.getMethod(getterName, EMPTY);
			}
		} catch (NoSuchMethodException e1) {

			// :Check if it is a boolean getter
			getterName = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);
			try {
				method = clazz.getMethod(getterName, EMPTY);
				if(method.getReturnType() != Boolean.class && method.getReturnType() != boolean.class) {
					return null;
				}
			} catch (NoSuchMethodException e2) {
				method = findCaseIgnoreGetter(clazz, name, type);
			}
			// :~
		}

		if(type == null) {
			return method;
		} else {
			if(method != null) {
				Class<?> returnType = method.getReturnType();
				Class<?>[] types = findCompatibleClasses(type);
				for(Class<?> t : types) {
					if(t == returnType) {
						return method;
					}
				}
			}
		}

		return null;
	}

	private static Method findCaseIgnoreGetter(Class<?> clazz, String name, Class<?> type) {
		String getterName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
		String isName = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);

		for(Method element : clazz.getMethods()) {
			if(element.getParameterTypes().length != 0) {
				continue;
			}
			if(element.getName().equalsIgnoreCase(getterName)) {
				return element;
			}
			if(element.getName().equalsIgnoreCase(isName) && element.getReturnType() != Boolean.class && element.getReturnType() != boolean.class) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Find superclasses and add them to list.
	 */
	private static void findSuperClasses(Set<Class<?>> list, Class<?> clazz) {
		if(clazz != null) {
			Class<?> superClass = clazz.getSuperclass();

			if(superClass != Object.class) {
				list.add(superClass);

				findInterfaces(list, superClass);

				findSuperClasses(list, superClass);
			}
		}
	}

	/**
	 * Find interfaces and add them to list.
	 */
	private static void findInterfaces(Set<Class<?>> list, Class<?> clazz) {
		if(clazz != null) {
			Class<?>[] interfaces = clazz.getInterfaces();

			for(Class<?> interfac1 : interfaces) {
				list.add(interfac1);
				findInterfaces(list, interfac1);
			}
		}
	}

	/**
	 * Combine arithmetic.
	 */
	private static void computeArguments(List<Class<?>[]> list, Class<?>[][] arguments, Class<?>[] buffer, int start) {
		if(start >= arguments.length) {
			Class<?>[] classes = new Class<?>[arguments.length];
			for(int i = 0; i < arguments.length; ++i) {
				classes[i] = buffer[i];
			}
			list.add(classes);
			return;
		}

		for(int i = 0; i < arguments[start].length; ++i) {
			buffer[start] = arguments[start][i];
			computeArguments(list, arguments, buffer, start + 1);
		}
	}
}
