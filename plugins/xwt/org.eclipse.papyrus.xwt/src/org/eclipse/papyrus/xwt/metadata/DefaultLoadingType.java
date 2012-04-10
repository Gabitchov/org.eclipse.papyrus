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
package org.eclipse.papyrus.xwt.metadata;

public class DefaultLoadingType implements ILoadingType {

	private IValueLoading valueLoading;

	private IProperty[] properties;

	public DefaultLoadingType(IValueLoading valueLoading, IProperty[] properties) {
		this.valueLoading = valueLoading;
		this.properties = properties;
	}

	public IValueLoading getValueLoading() {
		return valueLoading;
	}

	public IProperty[] getDependencies() {
		return properties;
	}
}
