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
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.xwt.javabean.metadata.Behavior;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.papyrus.xwt.metadata.ISetPostAction;

public abstract class AbstractProperty extends Behavior implements IProperty {

	static final int VALUE_AS_PARENT = 1 << 1;

	protected Collection<ISetPostAction> setPostActions = Collections.emptyList();

	private Class<?> type;

	protected ILoadingType loadingType;

	public AbstractProperty(String name, Class<?> type) {
		this(name, type, ILoadingType.DEFAULT);
	}

	public AbstractProperty(String name, Class<?> type, ILoadingType loadingType) {
		super(name);
		setType(type);
		this.loadingType = loadingType;
	}

	public void addSetPostAction(ISetPostAction setPostAction) {
		if(setPostActions == Collections.EMPTY_LIST) {
			setPostActions = new ArrayList<ISetPostAction>();
		}
		if(!setPostActions.contains(setPostAction)) {
			setPostActions.add(setPostAction);
		}
	}

	public void removeSetPostAction(ISetPostAction setPostAction) {
		setPostActions.remove(setPostAction);
	}

	protected void fireSetPostAction(Object target, IProperty property, Object value) {
		for(ISetPostAction setPostAction : setPostActions) {
			setPostAction.action(target, property, value);
		}
	}

	public boolean isDefault() {
		return false;
	}

	public boolean isContainement() {
		return false;
	}

	public boolean isReadOnly() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.metadata.IProperty#setType(java.lang.Class)
	 */
	public void setType(Class<?> type) {
		if(type == boolean.class) {
			type = Boolean.class;
		} else if(type == int.class) {
			type = Integer.class;
		} else if(type == long.class) {
			type = Long.class;
		} else if(type == char.class) {
			type = Character.class;
		} else if(type == float.class) {
			type = Float.class;
		} else if(type == double.class) {
			type = Double.class;
		} else if(type == byte.class) {
			type = Byte.class;
		} else if(type == short.class) {
			type = Short.class;
		}
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.metadata.IProperty#getType()
	 */
	public Class<?> getType() {
		return type;
	}

	public boolean isValueAsParent() {
		return (flags & VALUE_AS_PARENT) == VALUE_AS_PARENT;
	}

	public void setValueAsParent(boolean value) {
		flags |= VALUE_AS_PARENT;
	}

	public ILoadingType getLoadingType() {
		return loadingType;
	}
}
