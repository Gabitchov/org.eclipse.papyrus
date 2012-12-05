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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkEditorHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


public class HyperLinkDiagramEditorHelper extends AbstractHyperLinkEditorHelper {

	@Override
	public HyperLinkEditor getHyperLinkObjectFor(Object object) {
		if(object instanceof Diagram) {
			return new HyperLinkDiagram();
		}
		return null;
	}


	@Override
	public CreateEAnnotationCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperlinkObject) {
		if(hyperlinkObject instanceof HyperLinkDiagram) {
			HyperLinkDiagram hyperLinkDiagram = (HyperLinkDiagram)hyperlinkObject;
			return new CreateHyperLinkDiagramCommand(domain, object, hyperLinkDiagram.getTooltipText(), ((Diagram)hyperLinkDiagram.getObject()).getName(), (EModelElement)hyperLinkDiagram.getObject(), hyperLinkDiagram.getIsDefault());
		} else {
			return null;
		}
	}


	@Override
	public HyperLinkEditor getHyperLinkObjectForEAnnotation(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(HyperLinkDiagramConstants.HYPERLINK_DIAGRAM)) {
			HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
			EList<EObject> list = eAnnotation.getReferences();
			if(list.size() > 0) {
				if(eAnnotation.getReferences().get(0).eResource() != null) {
					hyperLinkDiagram.setDiagram((Diagram)eAnnotation.getReferences().get(0));
					hyperLinkDiagram.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
					if(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION) != null) {
						String stringboolean = eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION);
						boolean isDefaultNaviagation = Boolean.parseBoolean(stringboolean);
						hyperLinkDiagram.setIsDefault(isDefaultNaviagation);
					} else {
						hyperLinkDiagram.setIsDefault(false);
					}
					return hyperLinkDiagram;
				}
			}
		}
		return null;
	}
}
