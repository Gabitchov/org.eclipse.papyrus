/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.papyrus.core.ui.IRevealSemanticElement;

/**
 /**
 * 
 * This GMF editor contains a methods in order to reveal visual element from a list of semantic element.
 *
 */

public class SynchronizableGmfDiagramEditor extends DiagramDocumentEditor implements IRevealSemanticElement {

	public SynchronizableGmfDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
	}


	/**
	 * reveal all editpart that represent an element in the given list.
	 * @see org.eclipse.papyrus.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	 * 
	 */
	public void revealSemanticElement(List<?> elementList) {
		//create an instance that can get semantic element from gmf
		SemanticFromGMFElement semanticFromGMFElement= new SemanticFromGMFElement();

		// get the graphical viewer
		GraphicalViewer graphicalViewer =getGraphicalViewer() ;
		if( graphicalViewer!=null){

			//look for among all edit part if the semantic is contained in the list
			Iterator<?> iter=graphicalViewer.getEditPartRegistry().values().iterator();
			IGraphicalEditPart researchedEditPart=null;
			while(iter.hasNext()&& researchedEditPart==null) {
				Object currentEditPart = (Object)iter.next();
				//look for only among IPrimary editpart to avoid compartment and labels of links
				if(currentEditPart instanceof IPrimaryEditPart){
					if(elementList.contains(semanticFromGMFElement.getSemanticElement(currentEditPart))){
						researchedEditPart=((IGraphicalEditPart)currentEditPart);}
				}

			}
			//an editpart has been found so put selection on it.
			if(researchedEditPart!=null){
				graphicalViewer.select(researchedEditPart);
			}
		}
	}

}
