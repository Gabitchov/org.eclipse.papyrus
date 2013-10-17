/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;
import org.eclipse.papyrus.sysml.diagram.parametric.factory.ParametricDiagramViewFactory;

public class ParametricDiagramViewProvider extends AbstractViewProvider {

		@Override
		protected boolean provides(CreateDiagramViewOperation operation) {
	
			if(ElementTypes.DIAGRAM_ID.equals(operation.getSemanticHint())) {
				return true;
			}
	
			return false;
		}
	
		@Override
		protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
			if(ElementTypes.DIAGRAM_ID.equals(diagramKind)) {
				return ParametricDiagramViewFactory.class;
			}
	
			Activator.log.error(new Exception("Could not create View."));
			return null;
		}
}

