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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLModelingAssistantProvider;

/**
 * this is a custom assistant for editpart
 * I overload possible shorcut that can be created
 * 
 */
public class CUMLModelingAssitantProvider extends UMLModelingAssistantProvider {

	@SuppressWarnings("rawtypes")
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof ModelEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(20);
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.Comment_2012);
			//types.add(UMLElementTypes.Diagram_2016);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			//types.add(UMLElementTypes.NamedElement_2097);
			//types.add(UMLElementTypes.NamedElement_2098);
			return types;
		} else {
			return super.getTypesForPopupBar(host);
		}
	}
}
