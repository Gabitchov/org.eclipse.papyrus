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
package org.eclipse.papyrus.infra.nattable.common.solver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.nattable.common.manager.ICellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

//FIXME : should implements ICrossValueSolver?
public class CellManagerFactory {

	public static final String CLASS_MANAGER = "manager"; //$NON-NLS-1$

	public static final String ORDER = "order"; //$NON-NLS-1$

	public static final String SOLVER_ID = "id"; //$NON-NLS-1$

	//	private final Map<String, Class<IAxisManager>> map;

	private final Collection<ICellManager> solvers;

	private final Map<Integer, ICellManager> managersMap;

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.common.cellmanager"; //$NON-NLS-1$

	public static final CellManagerFactory INSTANCE = new CellManagerFactory();

	private CellManagerFactory() {
		this.solvers = new ArrayList<ICellManager>();
		this.managersMap = new TreeMap<Integer, ICellManager>();
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(final IConfigurationElement iConfigurationElement : configElements) {

			final String id = iConfigurationElement.getAttribute(SOLVER_ID);
			final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER));
			try {

				//to avoid pb when the provided class in not this plugin!
				final ICellManager solver = (ICellManager)iConfigurationElement.createExecutableExtension(CLASS_MANAGER);
				this.managersMap.put(order, solver);
				this.solvers.add(solver);
			} catch (final CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Object getCrossValue(final Object obj1, final Object obj2) {
		final ICellManager cellManager = getCrossValueSolver(obj1, obj2);
		if(cellManager != null) {
			return cellManager.getValue(obj1, obj2);
		}
		//FIXME should return a specific error or a message?
		return null;
	}

	private ICellManager getCrossValueSolver(final Object obj1, final Object obj2) {
		for(final Integer integer : this.managersMap.keySet()) {
			ICellManager current = this.managersMap.get(integer);
			//			for(final ICellManager current : this.solvers) {
			if(current.handles(obj1, obj2)) {
				return current;
			}
			//			}
		}
		//FIXME should return a specific error or a message?
		return null;
	}

	public boolean isCellEditable(final Object obj1, final Object obj2) {
		final ICellManager cellManager = getCrossValueSolver(obj1, obj2);
		if(cellManager != null) {
			return cellManager.isCellEditable(obj1, obj2);
		}
		return false;

	}
	
	public void setCellValue(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue){
		final ICellManager cellManager = getCrossValueSolver(obj1, obj2);
		if(cellManager!=null){
			cellManager.setValue(domain, obj1, obj2, newValue);
		}
	}
	
//	public ICellEditor getCellEditor (final Table table, final Object obj1, final Object obj2){
//		final ICellManager cellManager = getCrossValueSolver(obj1, obj2);
//		if(cellManager!=null){
//			return cellManager.getCellEditor(table, obj1);
//		}
//		return null;
//	}
}
