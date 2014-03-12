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
package org.eclipse.papyrus.uml.nattable.converter.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;


public class ConvertAllTablesHandler extends ConvertOldTableHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.converter.handlers.ConvertOldTableHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		Object selection = ((IEvaluationContext)evaluationContext).getDefaultVariable();
		List<PapyrusTableInstance> allPapyrusTableInstances = new ArrayList<PapyrusTableInstance>();
		if(selection instanceof List<?>) {
			List<?> list = (List<?>)selection;
			Iterator<?> iter = list.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				EObject eobject = EMFHelper.getEObject(selection);
				if(eobject != null) {
					final IPageManager manager = getPageManager(eobject);
					for(final Object page : manager.allPages()) {
						if(page instanceof PapyrusTableInstance) {
							allPapyrusTableInstances.add((PapyrusTableInstance)page);
						}
					}
				}
			}
		}
		this.oldPapyrusTableInstance = allPapyrusTableInstances;
		setBaseEnabled(!this.oldPapyrusTableInstance.isEmpty());
	}
}
