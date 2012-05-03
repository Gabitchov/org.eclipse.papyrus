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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.merger.internal.utils;

import org.eclipse.emf.common.notify.impl.AdapterImpl;


 /**
 * duplicate code from Efactory
 * This adapter will be used to remember the accurate position of an EObject in its target list.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class PositionAdapter extends AdapterImpl {

	/** The index at which we expect to find this object. */
	private final int expectedIndex;

	/**
	 * Creates our adapter.
	 * 
	 * @param index
	 *        The index at which we expect to find this object.
	 */
	public PositionAdapter(final int index) {
		this.expectedIndex = index;
	}

	/**
	 * Returns the index at which we expect to find this object.
	 * 
	 * @return The index at which we expect to find this object.
	 */
	public int getExpectedIndex() {
		return expectedIndex;
	}
}
