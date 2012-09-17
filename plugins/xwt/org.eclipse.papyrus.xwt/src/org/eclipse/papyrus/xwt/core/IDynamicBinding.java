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
package org.eclipse.papyrus.xwt.core;

import org.eclipse.papyrus.xwt.databinding.IBindingContext;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface IDynamicBinding extends IBinding {

	Object createBoundSource();

	void setControl(Object control);

	Object getControl();

	void setHost(Object control);

	Object getHost();


	void setType(String type);

	String getType();

	boolean isSourceControl();

	/**
	 * Returns the {@link BindingContext} associated with this binding
	 * 
	 * @return the {@link BindingContext}
	 */
	IBindingContext getBindingContext();

	/**
	 * Sets the {@link BindingContext} this binding is associated with
	 * 
	 * @param dataBindingContext
	 */
	void setBindingContext(IBindingContext dataBindingContext);
}
