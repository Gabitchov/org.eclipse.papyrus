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
package org.eclipse.papyrus.infra.nattable.manager.table;

import java.util.List;


/**
 * This interface is used to get the elements on the axis
 * 
 * @author vl222926
 * 
 */
public interface ITableAxisElementProvider {

	/**
	 * 
	 * @return
	 *         the list of the elements displayed on columns
	 */
	public List<Object> getColumnElementsList();

	/**
	 * 
	 * @return
	 *         the list of the elements displayed on rows
	 */
	public List<Object> getRowElementsList();

	/**
	 * 
	 * @param index
	 *        the index of the wanted element
	 * @return
	 *         the column element for this index or <code>null</code>
	 */
	public Object getColumnElement(int index);

	/**
	 * 
	 * @param index
	 *        the index of the wanted element
	 * @return
	 *         the row element for this index or <code>null</code>
	 */
	public Object getRowElement(int index);

}
