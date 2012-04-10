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

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.ILoadingContext;

public class NamespaceHelper {

	static public Class<?> loadCLRClass(ILoadingContext loadingContext, String name, String namespace) throws ClassNotFoundException {
		// xmlns:custom="clr-namespace:SDKSample;assembly=SDKSampleLibrary"
		if(namespace.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
			String contentSegment = namespace.substring(IConstants.XAML_CLR_NAMESPACE_PROTO.length());
			String packageName = contentSegment;
			String assembly = null;
			int index = contentSegment.indexOf(";");
			if(index != -1) {
				packageName = contentSegment.substring(0, index);
				contentSegment = contentSegment.substring(index + 1);
				if(contentSegment.startsWith(IConstants.XAML_CLR_ASSEMBLY)) {
					assembly = contentSegment.substring(IConstants.XAML_CLR_ASSEMBLY.length());
				} else {
					throw new IllegalStateException(IConstants.XAML_CLR_ASSEMBLY);
				}
			}
			if(assembly != null) {
				// TODO Load jar using URLClassLoader
			}
			if(packageName != null && packageName.length() > 0) {
				name = packageName + "." + name;
			}
			return ClassLoaderUtil.loadClass(loadingContext, name);
		}
		return null;
	}
}
