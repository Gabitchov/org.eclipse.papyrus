/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

package org.eclipse.papyrus.diagram.common.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDiagramCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkDiagram;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;

/**
 * this is an helper to manager hyperlink Diagram 
 */
public class DiagramHyperLinkHelper extends AbstractHyperLinkHelper {

	@Override
	public HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(VisualInformationPapyrusConstant.HYPERLINK_DIAGRAM)) {
			HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
			EList<EObject> list = eAnnotation.getReferences();
			if(list.size() > 0) {
				if(eAnnotation.getReferences().get(0).eResource() != null) {
					hyperLinkDiagram.setDiagram((Diagram)eAnnotation.getReferences().get(0));
					hyperLinkDiagram.setTooltipText(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
					if(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION)!=null){
						boolean isDefaultNaviagation=Boolean.getBoolean(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION));
						hyperLinkDiagram.setIsDefault(isDefaultNaviagation);
					}
					else{
						hyperLinkDiagram.setIsDefault(false);
					}
					return hyperLinkDiagram;
				}
			}
		}
		return null;
	}
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject) {
		if( hyperlinkObject instanceof HyperLinkDiagram){
			HyperLinkDiagram hyperLinkDiagram= (HyperLinkDiagram)hyperlinkObject;
			return new CreateHyperLinkDiagramCommand(domain, object, hyperLinkDiagram.getTooltipText(), hyperLinkDiagram.getDiagram().getName(),  hyperLinkDiagram.getDiagram(),hyperLinkDiagram.getIsDefault());
		}
		else{return null;}
	}

}
