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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor;
import org.eclipse.emf.facet.widgets.nattable.workbench.editor.TableEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractNattableEditor extends NatTableEditor {

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

		//		fillTable();

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
	 * Iterate over current selection and build a list of the {@link Eobject} contained in
	 * the selection.
	 * 
	 * @return the currently selected {@link EObject}
	 */
	protected List<EObject> getSelectedElements() {
		List<EObject> eObjects = new ArrayList<EObject>();

		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IGraphicalEditPart) {
					IGraphicalEditPart part = (IGraphicalEditPart)object;
					EObject current = (EObject)part.getAdapter(EObject.class);
					if(current != null) {
						eObjects.add(current);
					}
				}
			}

		} else if(selection instanceof IGraphicalEditPart) {
			//TODO
			//			eObjects.add((IGraphicalEditPart)selection);
		}

		return eObjects;
	}

	//	/**
	//	 * Fill the table with the current selection
	//	 * TODO : should not be exists
	//	 */
	//	protected void fillTable() {
	//		for(EObject eObject : getSelectedElements()) {
	//			//			if(!rawModel.getTableConfiguration().getCanBePresentedInTheTable())
	//			if(!rawModel.getElements().contains(eObject)) {
	//				Row row = TableinstanceFactory.eINSTANCE.createRow();
	//				row.setElement(eObject);
	//				rawModel.getRows().add(row);
	//			}
	//		}
	//	}

}
