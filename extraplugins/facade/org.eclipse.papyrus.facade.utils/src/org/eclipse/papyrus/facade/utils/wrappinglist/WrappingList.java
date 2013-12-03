/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.utils.wrappinglist;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.facade.utils.RepresentingElement;


public interface WrappingList<E extends RepresentingElement> extends EList<E> {

	public void notWrappingAdd(E object);

	public E notWrappingRemove(E object);

	public void silentAdd(int i, E object);

	public E silentRemove(int index);


}
