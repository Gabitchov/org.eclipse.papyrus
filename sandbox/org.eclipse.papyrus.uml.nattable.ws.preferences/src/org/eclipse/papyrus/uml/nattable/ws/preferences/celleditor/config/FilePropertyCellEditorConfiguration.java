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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.ws.preferences.celleditor.config;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.nattable.ws.preferences.utils.Constants;



public class FilePropertyCellEditorConfiguration extends EStructuralFeatureEditorConfig {

	@Override
	public ICellEditor getICellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider) {
		return super.getICellEditor(table, axisElement, elementProvider);
	}

	@Override
	public String getEditorId() {
		return super.getEditorId();
	}

	@Override
	protected IComboBoxDataProvider getComboDataProvider(Table table, Object axisElement, ITableAxisElementProvider elementProvider) {
		return super.getComboDataProvider(table, axisElement, elementProvider);
	}

	@Override
	public IDisplayConverter getDisplayConvert(Object axisElement, Table table, ILabelProvider provider) {
		return super.getDisplayConvert(axisElement, table, provider);
	}

	@Override
	public ICellPainter getCellPainter(Table table, Object axisElement) {
		return super.getCellPainter(table, axisElement);
	}

	@Override
	public String getDisplayMode(Table table, Object axisElement) {
		return super.getDisplayMode(table, axisElement);
	}

	@Override
	public IDataValidator getDataValidator(Table table, Object axisElement) {
		return super.getDataValidator(table, axisElement);
	}

	@Override
	public boolean handles(Table table, Object axisElement) {
		return axisElement instanceof String && ((String)axisElement).startsWith(Constants.PROPERTY_PREFIX);
	}

	@Override
	protected int getFeatureIdentifier(Table table, Object axisElement) {
		return SINGLE_STRING;
		//		return super.getFeatureIdentifier(table, axisElement);
	}

	@Override
	public String getEditorDescription() {
		return super.getEditorDescription();
	}



}
