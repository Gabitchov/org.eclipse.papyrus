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
 * UI property
 * 
 * @author yyang
 */
public interface IProperty extends IBehavior {

	IProperty[] EMPTY_ARRAY = new IProperty[]{};

	public Class<?> getType();

	public void setType(Class<?> type);

	/**
	 * Can generate event
	 * 
	 * @return
	 */
	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException;

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException;

	public void addSetPostAction(ISetPostAction setPostAction);

	public void removeSetPostAction(ISetPostAction setPostAction);

	public boolean isDefault();

	public boolean isContainement();

	public boolean isReadOnly();

	/**
	 * use the value ad parent for the children. Table.table, Form.setHeadClient etc
	 * 
	 * @return
	 */
	public boolean isValueAsParent();

	public ILoadingType getLoadingType();
}
