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
package org.eclipse.papyrus.xwt.javabean;

import java.util.HashMap;

import org.eclipse.core.databinding.conversion.IConverter;

public class ValueConvertorRegister {

	static protected HashMap<Class<?>, HashMap<Class<?>, IConverter>> register = new HashMap<Class<?>, HashMap<Class<?>, IConverter>>();

	public void register(Class<?> source, Class<?> target, IConverter converter) {
		HashMap<Class<?>, IConverter> convertors = register.get(source);
		if(convertors == null) {
			convertors = new HashMap<Class<?>, IConverter>();
			register.put(source, convertors);
		}
		convertors.put(target, converter);
	}

	public IConverter findConverter(Class<?> source, Class<?> target) {
		HashMap<Class<?>, IConverter> convertors = register.get(source);
		if(convertors == null) {
			if(source.isEnum()) {
				convertors = register.get(Enum.class);
				if(convertors == null) {
					return null;
				}
			} else {
				Class<?>[] interfacees = source.getInterfaces();
				for(Class<?> class1 : interfacees) {
					IConverter converter = findConverter(class1, target);
					if(converter != null) {
						return converter;
					}
				}
				Class<?> superclass = source.getSuperclass();
				if(superclass != null) {
					IConverter converter = findConverter(superclass, target);
					if(converter != null) {
						return converter;
					}
				}
				return null;
			}
		}
		return findConverter(convertors, target);
	}

	private IConverter findConverter(HashMap<Class<?>, IConverter> convertors, Class<?> current) {
		IConverter converter = convertors.get(current);
		if(converter == null) {
			if(current.isEnum()) {
				converter = convertors.get(Enum.class);
			}
		}
		if(converter == null) {
			Class<?> superclass = current.getSuperclass();
			if(superclass == null && current != Object.class) {
				superclass = Object.class;
			}
			if(superclass != null) {
				converter = findConverter(convertors, superclass);
			}
		}
		return converter;
	}
}
