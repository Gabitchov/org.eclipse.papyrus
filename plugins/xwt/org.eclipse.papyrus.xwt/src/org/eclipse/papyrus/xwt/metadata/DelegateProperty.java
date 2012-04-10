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

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * Facility class to override the default behavior
 * 
 * @author yyang
 */
public class DelegateProperty implements IProperty {

	protected IProperty delegate;

	protected ILoadingType loadingType;

	public DelegateProperty(IProperty delegate) {
		this(delegate, ILoadingType.DEFAULT);
	}

	public DelegateProperty(ILoadingType loadingType) {
		this(null, loadingType);
	}

	public DelegateProperty(IProperty delegate, ILoadingType loadingType) {
		this.delegate = delegate;
		this.loadingType = loadingType;
	}

	public void addSetPostAction(ISetPostAction setPostAction) {
		this.delegate.addSetPostAction(setPostAction);
	}

	public Class<?> getType() {
		return this.delegate.getType();
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return this.delegate.getValue(target);
	}

	public boolean isDefault() {
		return false;
	}

	public boolean isContainement() {
		return false;
	}

	public void removeSetPostAction(ISetPostAction setPostAction) {
		this.delegate.removeSetPostAction(setPostAction);
	}

	public boolean isReadOnly() {
		return this.delegate.isReadOnly();
	}

	public void setType(Class<?> type) {
		this.delegate.setType(type);
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		this.delegate.setValue(target, value);
	}

	public String getName() {
		return this.delegate.getName();
	}

	public void setName(String name) {
		this.delegate.setName(name);
	}

	public IProperty getDelegate() {
		return delegate;
	}

	public void setDelegate(IProperty delegate) {
		this.delegate = delegate;
	}

	public boolean isValueAsParent() {
		return this.delegate.isValueAsParent();
	}

	public ILoadingType getLoadingType() {
		return loadingType;
	}
}
