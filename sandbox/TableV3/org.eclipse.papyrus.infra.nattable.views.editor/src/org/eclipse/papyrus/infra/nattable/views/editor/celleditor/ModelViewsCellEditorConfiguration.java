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
package org.eclipse.papyrus.infra.nattable.views.editor.celleditor;

import org.eclipse.papyrus.infra.emf.nattable.editors.EStructuralFeatureEditorConfig;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.views.editor.NattablePageEditor;
import org.eclipse.papyrus.infra.nattable.views.editor.utils.Utils;


/**
 * The cell editor configuration for the table model views
 * 
 * @author Vincent Lorenzo
 * 
 */
public class ModelViewsCellEditorConfiguration extends EStructuralFeatureEditorConfig {

	public static final String CONFIG_EDITOR_ID = "MODEL_VIEW_CELL_EDITOR_ID";

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.editors.EStructuralFeatureEditorConfig#getFeatureIdentifier(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	protected int getFeatureIdentifier(Table table, Object axisElement) {
		if(((String)axisElement).equals(Utils.NATTABLE_EDITOR_PAGE_ID + Utils.VIEW_CONTEXT)) {
			return SINGLE_EMF_REFERENCE;
		} else if(((String)axisElement).equals(Utils.NATTABLE_EDITOR_PAGE_ID + Utils.VIEW_IS_OPEN)) {
			return SINGLE_BOOLEAN;
		} else if(((String)axisElement).equals(Utils.NATTABLE_EDITOR_PAGE_ID + Utils.VIEW_NAME)) {
			return SINGLE_STRING;
		} else if(((String)axisElement).equals(Utils.NATTABLE_EDITOR_PAGE_ID + Utils.VIEW_EDITOR_TYPE)) {
			return SINGLE_STRING;
		}
		return UNKNOWN_TYPE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.editors.EStructuralFeatureEditorConfig#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public boolean handles(Table table, Object axisElement) {
		if(table.getEditorConfiguration().getType().equals(NattablePageEditor.EDITOR_TYPE)) {
			return axisElement instanceof String && ((String)axisElement).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID);
		}
		return false;
	}

	@Override
	public String getEditorId() {
		return CONFIG_EDITOR_ID;
	}
}
