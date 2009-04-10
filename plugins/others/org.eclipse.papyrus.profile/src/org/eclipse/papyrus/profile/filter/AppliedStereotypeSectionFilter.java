/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.profile.filter;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter;
import org.eclipse.uml2.uml.Element;

/**
 * This filter is used to check if stereotypes are applicable on the selected Element.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class AppliedStereotypeSectionFilter extends ShapeEditPartPropertySectionFilter {

	public boolean select(Object object) {		
		if (object instanceof ShapeEditPart) {
			if (((ShapeEditPart) object).resolveSemanticElement() != null && ((ShapeEditPart) object).resolveSemanticElement() instanceof org.eclipse.uml2.uml.Element) {
				return true;
			}
		} else if(object instanceof DiagramEditPart){
			DiagramEditPart diagramEditPart = (DiagramEditPart)object;
			if(diagramEditPart.resolveSemanticElement()!=null && diagramEditPart.resolveSemanticElement() instanceof Element){
				return true;
			}		
		}else if(object instanceof Element){
			return true;
		}
		return false;
	}
}
