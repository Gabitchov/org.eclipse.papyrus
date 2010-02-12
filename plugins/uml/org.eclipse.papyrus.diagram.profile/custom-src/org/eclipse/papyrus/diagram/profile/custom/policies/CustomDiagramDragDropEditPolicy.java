/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor common behavior in CommonDiagramDragDropEditPolicy
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.profile.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/**
	 * Instantiates a new custom diagram drag drop edit policy with the right link mapping helper
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(ClassLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	//	@Override
	//	public Command getCommand(Request request) {
	//				if(request instanceof ChangeBoundsRequest) {
	//					if((((ChangeBoundsRequest)request).getEditParts().get(0) instanceof MetaclassEditPart) || (((ChangeBoundsRequest)request).getEditParts().get(0) instanceof MetaclassEditPartCN)) {
	//						d.mes(request.getType().toString());
	//						if(request.getType().equals(RequestConstants.REQ_DROP)) {
	//							Command cmd = super.getCommand(request);
	//							if(cmd.canExecute()) {
	//								d.mes("OK");
	//								cmd.execute();
	//							}
	//							//return super.getCommand(request);
	//							return null;
	//						}
	//						if(request.getType().equals(RequestConstants.REQ_MOVE)) {
	//							//return super.getCommand(request);
	//							return null;
	//						}
	//						if(request.getType().equals(RequestConstants.REQ_MOVE_CHILDREN)) {
	//							//	return super.getCommand(request);
	//							return null;
	//		
	//						}
	//						//return super.getCommand(request);
	//						return null;
	//					}
	//				}
	//		return super.getCommand(request);
	//	}
}
