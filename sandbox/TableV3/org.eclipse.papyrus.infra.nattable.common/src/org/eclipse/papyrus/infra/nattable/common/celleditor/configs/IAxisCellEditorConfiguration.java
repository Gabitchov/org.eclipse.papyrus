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
package org.eclipse.papyrus.infra.nattable.common.celleditor.configs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;

/**
 * 
 * This interface declares the methods used to get the element for the configuration of celleditors when they are declared by axis
 * 
 */
public interface IAxisCellEditorConfiguration {

	/**
	 * 
	 * @param provider
	 *        the label provider to use
	 * @return
	 *         the display converter
	 */
	public IDisplayConverter getDisplayConvert(final ILabelProvider provider);

	/**
	 * 
	 * @return
	 *         the cell painter for the editor
	 */
	public ICellPainter getCellPainter();

	/**
	 * 
	 * @param axisElement
	 *        the edited element axis
	 * @param elementProvider
	 * @return
	 */
	public ICellEditor getICellEditor(Object axisElement, ITableAxisElementProvider elementProvider);

	/**
	 * 
	 * @return the edited type
	 */
	public Object getEditedType();

	/**
	 * 
	 * @return
	 *         the display mode to use for the editor
	 */
	public String getDisplayMode();

	/**
	 * 
	 * @return
	 *         <code>true</code> if the editor allows to edit a list of value
	 */
	public boolean isMany();

	/**
	 * 
	 * @return
	 *         the id of the editor
	 */
	public String getEditorId();

	/**
	 * 
	 * @return
	 *         the id to use to tag the cell
	 */
	public String getConfigCellId();

	/**
	 * the data validator
	 */
	public IDataValidator getDataValidator();

	/**
	 * 
	 * @return
	 *         the description for the editor (should be used by the preferences)
	 */
	public String getEditorDescription();


}
