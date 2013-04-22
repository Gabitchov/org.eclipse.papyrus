/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.sequence.ObservationLinkMetamodelType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomModelingAssistantProvider extends UMLModelingAssistantProvider {

	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DurationObservationEditPart) {
			//return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSource();
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(ObservationLinkMetamodelType.getInstance());
			return types;
		}
		if(sourceEditPart instanceof TimeObservationLabelEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(ObservationLinkMetamodelType.getInstance());
			return types;
		}
		return super.getRelTypesOnSource(source);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.providers.UMLModelingAssistantProvider#getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	@Override
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DurationObservationEditPart) {
			//return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(ObservationLinkMetamodelType.getInstance());
			return types;
		}
		if(sourceEditPart instanceof TimeObservationLabelEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(ObservationLinkMetamodelType.getInstance());
			return types;
		}
		return super.getRelTypesOnSourceAndTarget(source, target);
	}
}
