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
package org.eclipse.papyrus.infra.table.common.hyperlink;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkEditorHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;


public class HyperLinkTableEditorHelper extends AbstractHyperLinkEditorHelper {

	@Override
	public HyperLinkEditor getHyperLinkObjectFor(Object object) {
		if(object instanceof PapyrusTableInstance) {
			return new HyperLinkEditor();
		}
		return null;
	}

	@Override
	public CreateEAnnotationCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperlinkObject) {
		if(hyperlinkObject instanceof HyperLinkEditor && hyperlinkObject.getObject() instanceof PapyrusTableInstance) {
			return new CreateHyperLinkTableCommand(domain, object, hyperlinkObject.getTooltipText(), ((PapyrusTableInstance)hyperlinkObject.getObject()).getName(), (EModelElement)hyperlinkObject.getObject(), hyperlinkObject.getIsDefault());
		} else {
			return null;
		}
	}


	@Override
	public HyperLinkEditor getHyperLinkObjectForEAnnotation(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(HyperLinkTableConstants.HYPERLINK_TABLE)) {
			HyperLinkEditor hyperLinkDiagram = new HyperLinkEditor();
			List<EObject> list = eAnnotation.getReferences();
			if(list.size() > 0) {
				if(eAnnotation.getReferences().get(0).eResource() != null) {
					hyperLinkDiagram.setObject(eAnnotation.getReferences().get(0));
					hyperLinkDiagram.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
					return hyperLinkDiagram;
				}
			}
		}
		return null;
	}
}
