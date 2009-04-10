/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.filter;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter;
import org.eclipse.uml2.uml.Package;

public class AppliedProfileSectionFilter extends ShapeEditPartPropertySectionFilter {

	public boolean select(Object object) {		
		if (object instanceof ShapeEditPart) {
			if (((ShapeEditPart) object).resolveSemanticElement() != null && ((ShapeEditPart) object).resolveSemanticElement() instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}else if(object instanceof DiagramEditPart){
			DiagramEditPart diagramEditPart = (DiagramEditPart)object;
			if(diagramEditPart.resolveSemanticElement()!=null && diagramEditPart.resolveSemanticElement() instanceof org.eclipse.uml2.uml.Package){
				return true;
			}
			
		}else if(object instanceof Package){
			return true;
		}

		return false;
	}
}
