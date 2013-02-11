/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.provider;


public class CrossData {

	private final Object object1;

	private final Object object2;

	public CrossData(final Object object1, final Object object2) {
		this.object1 = object1;
		this.object2 = object2;
	}

	public Object getObject1() {
		return this.object1;
	}

	public Object getObject2() {
		return this.object2;
	}

}
