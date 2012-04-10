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

import java.net.URL;
import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.papyrus.xwt.internal.xml.DocumentObject;

/**
 * Shared constants
 * 
 * @author yyang
 */
public interface IConstants {

	public final String XAML_X_KEY = "Key";

	public final String XAML_X_TYPE = "Type";

	public final String XAML_X_TARGET_TYPE = "TargetType";

	public final String XAML_X_TYPE_NAME = "TypeName";

	public final String XAML_CLR_ASSEMBLY = "assembly=";

	public final String XAML_X_STATIC = "Static";

	public final String XAML_X_STATIC_MEMBER = "Member";

	public final String XAML_X_ARRAY = "Array";

	public final String XAML_X_CLASS = "Class";

	public final String XAML_X_CLASS_FACTORY = "ClassFactory";

	public final String XAML_X_NAME = "Name";

	public final String XAML_X_NULL = "Null";

	public final String XAML_X_SHARED = "Shared";

	public final String XAML_DATA_CONTEXT = "DataContext";

	public final String XAML_BINDING_CONTEXT = "BindingContext";

	public final String XAML_RENDER_TRANSFORM = "RenderTransform";

	public final String XAML_RENDER_TRANSFORM_ORIGIN = "RenderTransformOrigin";

	public final String XAML_TRIGGERS = "Triggers";

	public final String XAML_STYLE = "Style";

	public final String XAML_COMMAND = "Command";

	public final String XAML_CLR_NAMESPACE_PROTO = "clr-namespace:";

	public final String XAML_RESOURCES = "Resources";

	public final String XAML_STATICRESOURCES = "StaticResource";

	public final String XAML_DYNAMICRESOURCES = "DynamicResource";

	public final String XAML_BINDING = "Binding";

	public final String XML_NS = "xmlns";

	public static final String XWT_NAMESPACE = "http://www.eclipse.org/xwt/presentation";

	public static final String XWT_X_NAMESPACE = "http://www.eclipse.org/xwt";

	public static final String XWT_EXTENSION = "xwt";

	public static final String XWT_EXTENSION_SUFFIX = "." + XWT_EXTENSION;

	public static final Enumeration<URL> EMPTY_ENUMERATION = new Enumeration<URL>() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Enumeration#hasMoreElements()
		 */
		public boolean hasMoreElements() {
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Enumeration#nextElement()
		 */
		public URL nextElement() {
			return null;
		}
	};

	public static final ResourceBundle EMPTY_RESOURCE_BUNDLE = new ListResourceBundle() {

		private Object[][] EMPTY = new Object[0][0];

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.ListResourceBundle#getContents()
		 */
		@Override
		protected Object[][] getContents() {
			return EMPTY;
		}
	};

	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	public static final DocumentObject[] EMPTY_DOCOBJ_ARRAY = new DocumentObject[0];
}
