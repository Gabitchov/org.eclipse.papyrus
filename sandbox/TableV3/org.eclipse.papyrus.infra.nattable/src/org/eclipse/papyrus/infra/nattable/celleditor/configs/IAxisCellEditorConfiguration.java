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
package org.eclipse.papyrus.infra.nattable.celleditor.configs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * This interface declares the methods used to get the element for the configuration of celleditors when they are declared by axis
 * 
 */
public interface IAxisCellEditorConfiguration {

	/**
	 * 
	 * @param axisElement
	 *        TODO
	 * @param table
	 *        TODO
	 * @param provider
	 *        the label provider to use
	 * @return
	 *         the display converter
	 */
	public IDisplayConverter getDisplayConvert(Object axisElement, Table table, final ILabelProvider provider);

	/**
	 * 
	 * @param table
	 *        TODO
	 * @param axisElement
	 *        TODO
	 * @return
	 *         the cell painter for the editor
	 */
	public ICellPainter getCellPainter(Table table, Object axisElement);

	/**
	 * 
	 * @param table
	 *        TODO
	 * @param axisElement
	 *        the edited element axis
	 * @param elementProvider
	 * @return
	 */
	public ICellEditor getICellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider);


	/**
	 * 
	 * @param table
	 *        TODO
	 * @param axisElement
	 *        TODO
	 * @return
	 *         the display mode to use for the editor
	 */
	public String getDisplayMode(Table table, Object axisElement);

	/**
	 * 
	 * @return
	 *         the id of the editor
	 */
	//FIXME should be renamed into getEditorConfigId
	public String getEditorId();

	/**
	 * 
	 * @return
	 *         the id to use to tag the cell
	 */
	public String getConfigCellId();//FIXME : shoudl be removed!

	/**
	 * the data validator
	 * 
	 * @param table
	 *        TODO
	 * @param axisElement
	 *        TODO
	 */
	public IDataValidator getDataValidator(Table table, Object axisElement);

	/**
	 * 
	 * @return
	 *         the description for the editor (should be used by the preferences)
	 */
	public String getEditorDescription();

	/**
	 * 
	 * @param table
	 *        the table
	 * @param object
	 *        an object
	 * @return
	 *         <code>true</code> if the cell editor configuration is able to manage the object
	 */
	public boolean handles(Table table, Object object);
}
