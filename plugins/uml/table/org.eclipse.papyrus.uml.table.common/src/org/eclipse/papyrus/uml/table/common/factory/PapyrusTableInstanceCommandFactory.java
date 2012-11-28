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
package org.eclipse.papyrus.uml.table.common.factory;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;


public class PapyrusTableInstanceCommandFactory {

	private PapyrusTableInstanceCommandFactory(){
		//to prevent instanciation
	}
	
	
	//adapted code from NattableWidget#addRows
	public static Command getAddRowCommand(final List<EObject> newElements, final TableInstance tableInstance, final NatTableWidget widget){
		CompoundCommand addRowCommand = org.eclipse.emf.facet.widgets.nattable.internal.TableInstanceCommandFactory.createAddRowsCommand(newElements, widget);
		if (tableInstance instanceof TableInstance2) {
			TableInstance2 tableInstance2 = (TableInstance2) tableInstance;
			try {
				widget.getFacetContext().clear();
				widget.getFacetContext().addFacets(tableInstance2.getFacets2());
				Command setFacetsCommand = org.eclipse.emf.facet.widgets.nattable.internal.TableInstanceCommandFactory.createSetFacetsCommand(
						tableInstance2.getFacets2(), newElements, widget);
				if (setFacetsCommand != null && setFacetsCommand.canExecute()) {
					addRowCommand.append(setFacetsCommand);
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		Command loadCustomizationCommand = org.eclipse.emf.facet.widgets.nattable.internal.TableInstanceCommandFactory.createLoadCustomizationsCommand(tableInstance.getCustomizations(), widget);
		if (loadCustomizationCommand != null && loadCustomizationCommand.canExecute()) {
			addRowCommand.append(loadCustomizationCommand);
		}
		return addRowCommand;
	}
}
