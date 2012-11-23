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

package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.commands.CreateHyperLinkDocumentCommand;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkDocument;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperlinkDocumentShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;



/**
 * this an helper to manage hyperlink document
 * 
 */
public class DocumentHyperLinkHelper extends AbstractHyperLinkHelper {


	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(HyperLinkConstants.HYPERLINK_DOCUMENT)) {
			HyperLinkDocument hyperLinkDocument = new HyperLinkDocument();
			hyperLinkDocument.setHyperlinkDocument(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_DOCUMENT_LOCALIZATION));
			hyperLinkDocument.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
			if(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION) != null) {
				boolean isDefaultNaviagation = Boolean.parseBoolean(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION));
				hyperLinkDocument.setIsDefault(isDefaultNaviagation);
			} else {
				hyperLinkDocument.setIsDefault(false);
			}

			return hyperLinkDocument;
		}

		return null;
	}

	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperlinkObject) {
		if(hyperlinkObject instanceof HyperLinkDocument) {
			HyperLinkDocument hyperLinkDocument = (HyperLinkDocument)hyperlinkObject;
			return new CreateHyperLinkDocumentCommand(domain, object, hyperLinkDocument.getTooltipText(), hyperLinkDocument.getHyperlinkDocument(), hyperlinkObject.getIsDefault());
		} else {
			return null;
		}
	}

	@Override
	public String getNameofManagedHyperLink() {
		return Messages.DocumentHyperLinkHelper_Document;
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, EObject aModel) {
		EditorHyperlinkDocumentShell editor = new EditorHyperlinkDocumentShell();
		editor.open();
		if(editor.getHyperlinkDocument() != null) {
			list.add(editor.getHyperlinkDocument());
		}

	}

	@Override
	public List<HyperLinkObject> getFilteredObject(List<HyperLinkObject> hyperlinkObjects) {
		ArrayList<HyperLinkObject> result = new ArrayList<HyperLinkObject>();
		Iterator<HyperLinkObject> iterator = hyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperLinkObject hyperlinkObject = iterator.next();
			if(hyperlinkObject instanceof HyperLinkDocument) {
				result.add(hyperlinkObject);
			}
		}
		return result;
	}
}
