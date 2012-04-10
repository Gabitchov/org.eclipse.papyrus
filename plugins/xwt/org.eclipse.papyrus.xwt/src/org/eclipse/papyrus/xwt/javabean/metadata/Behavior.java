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
package org.eclipse.papyrus.xwt.javabean.metadata;

import org.eclipse.papyrus.xwt.metadata.IBehavior;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class Behavior implements IBehavior {

	private String name;

	protected int flags;

	public Behavior(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soyatec.xaswt.core.metadata.IBehavior#getName()
	 */
	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
