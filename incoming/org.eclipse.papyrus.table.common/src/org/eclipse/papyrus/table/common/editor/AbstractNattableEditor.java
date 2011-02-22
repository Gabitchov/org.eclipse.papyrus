/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.table.common.editor;

import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.table.common.internal.TableEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractNattableEditor extends org.eclipse.papyrus.table.common.internal.NatTableEditor {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected TableInstance rawModel;

	/** key to get the name of the editor */
	public static final String NAME_KEY = "NAME"; //$NON-NLS-1$

	/** key to get the type of the editor */
	public static final String TYPE_KEY = "TYPE"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractNattableEditor(ServicesRegistry servicesRegistry, TableInstance rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;

	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		TableEditorInput tableEditorInput = new TableEditorInput(rawModel, getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);

		Object param = rawModel.getParameter();
		if(param instanceof Map<?, ?>) {
			setPartName((String)((Map<?, ?>)rawModel.getParameter()).get(NAME_KEY));
		}

		super.init(site, tableEditorInput);
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	@Override
	public EditingDomain getEditingDomain() {
		// TODO Auto-generated method stub
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	@Override
	public Object getAdapter(final Class adapter) {
		return super.getAdapter(adapter);
	}
}
