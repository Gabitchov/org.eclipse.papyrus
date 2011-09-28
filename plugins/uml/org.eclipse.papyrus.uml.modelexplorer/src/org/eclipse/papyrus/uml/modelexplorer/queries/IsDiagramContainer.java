/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer.queries;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

public class IsDiagramContainer implements IJavaModelQuery<EObject, Boolean> {

	/** The list of open pages (diagrams) */
	protected IPageMngr pageMngr;

	public Boolean evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();

		// Walk on page (Diagram) references
		try {
			for(Object page : getPageMngr().allPages()) {
				if(!(page instanceof Diagram)) {
					continue;
				}
				// We have a GMF Diagram
				Diagram diagram = (Diagram)page;
				if(context.equals(diagram.getElement())) {
					diagrams.add(diagram);
					return true;
				}

			}
		} catch (ServiceException e) {
			throw new ModelQueryExecutionException("Enable to find the Services Registry");
		}
		return false;
	}

	public IPageMngr getPageMngr() throws ServiceException {
		if(pageMngr == null) {
			IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
			ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
			pageMngr = org.eclipse.papyrus.core.utils.ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
		}
		return pageMngr;
	}

}
