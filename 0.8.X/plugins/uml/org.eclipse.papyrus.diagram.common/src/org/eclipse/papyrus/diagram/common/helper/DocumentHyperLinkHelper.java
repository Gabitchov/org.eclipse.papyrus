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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDocumentCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.EditorHyperlinkDocumentShell;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkWeb;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkDocument;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.uml2.uml.Package;


/**
 * this an helper to manage hyperlink document
 *
 */
public class DocumentHyperLinkHelper extends AbstractHyperLinkHelper {

	@Override
	public HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT)) {
			HyperlinkDocument hyperLinkDocument = new HyperlinkDocument();
			hyperLinkDocument.setHyperlinkDocument(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT_LOCALIZATION));
			hyperLinkDocument.setTooltipText(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
			if(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION)!=null){
				boolean isDefaultNaviagation=Boolean.parseBoolean(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION));
				hyperLinkDocument.setIsDefault(isDefaultNaviagation);
			}
			else{
				hyperLinkDocument.setIsDefault(false);
			}

			return hyperLinkDocument;
		}

		return null;
	}
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject) {
		if( hyperlinkObject instanceof HyperlinkDocument){
			HyperlinkDocument hyperLinkDocument= (HyperlinkDocument)hyperlinkObject;
			return new CreateHyperLinkDocumentCommand(domain, object, hyperLinkDocument.getTooltipText(), hyperLinkDocument.getHyperlinkDocument(),hyperlinkObject.getIsDefault());
		}
		else{return null;}
	}
	@Override
	public String getNameofManagedHyperLink() {
		return "Document";
	}
	@Override
	public void executeNewMousePressed(List<HyperlinkObject> list, org.eclipse.uml2.uml.Package amodel) {
		EditorHyperlinkDocumentShell editor = new EditorHyperlinkDocumentShell();
		editor.open();
		if(editor.getHyperlinkDocument() != null) {
			list.add(editor.getHyperlinkDocument());
		}

	}
	
	@Override
	public ArrayList<HyperlinkObject> getFilteredObject(List<HyperlinkObject> hyperlinkObjects) {
		ArrayList<HyperlinkObject> result= new ArrayList<HyperlinkObject>();
		Iterator<HyperlinkObject> iterator= hyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iterator.next();
			if(hyperlinkObject instanceof HyperlinkDocument){
				result.add(hyperlinkObject);
			}
		}
		return result;
	}
}
