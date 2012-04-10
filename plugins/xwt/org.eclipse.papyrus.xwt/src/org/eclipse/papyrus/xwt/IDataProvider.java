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
package org.eclipse.papyrus.xwt;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.property.value.IValueProperty;

/**
 * A Data Binding provider defines the nature of Data Binding such as Bean Object Binding, EMF Object Binding, XML data Binding or Data Base binding
 * 
 * @author yyang
 */
public interface IDataProvider {

	/**
	 * Return the data of the provider, this value can be not used for databindings.
	 * 
	 * @param path
	 * @return
	 */
	Object getData(String path);

	/**
	 * Return the data of the provider, this value can be not used for databindings.
	 * 
	 * @param path
	 * @return
	 */
	Object getData(Object target, String path);

	/**
	 * Return the data of the provider, this value can be not used for databindings.
	 * 
	 * @param path
	 * @return
	 */
	void setData(String path, Object value);

	/**
	 * Return the data of the provider, this value can be not used for databindings.
	 * 
	 * @param path
	 * @return
	 */
	void setData(Object target, String path, Object value);

	/**
	 * Return the data type of the provider.lue
	 * 
	 * @param path
	 * @return
	 */
	Object getDataType(String path);

	/**
	 * check if the property is read only.
	 * 
	 * @param path
	 * @return
	 */
	boolean isPropertyReadOnly(String path);

	Object getProperty(String property);

	void setProperty(String property, Object object);

	boolean hasProperty(String property);

	void removeProperty(String property);

	IObservable observe(Object data, String path, Object targetType, int observeKind);

	IValueProperty createValueProperty(Object type, String fullPath);

	interface DataModelService {

		/**
		 * get the type of this object
		 * 
		 * @param object
		 * @return
		 */
		Object toModelType(Object object);

		Object loadModelType(String typeName);

		Object toModelPropertyType(Object object, String propertyName);
	}

	DataModelService getModelService();

}
