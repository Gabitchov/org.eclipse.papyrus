/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.nattable.parsers;

import java.util.Iterator;

/**
 * Represents an iterator over rows in a CSV document
 * 
 * @author Laurent Wouters
 */
public abstract class RowIterator implements Iterator<CellIterator> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
