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
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDocumentCommand;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkWebCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.EditorHyperlinkWebShell;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkWeb;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkDocument;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.uml2.uml.Package;

/**
 * this is an helper to manager hyperlink web
 * @author PT202707
 *
 */
public class WebHyperLinkHelper extends AbstractHyperLinkHelper {

	@Override
	public HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(VisualInformationPapyrusConstant.HYPERLINK_WEB)) {
			HyperLinkWeb hyperLinkWeb = new HyperLinkWeb();
			hyperLinkWeb.setHyperLinkWeb(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_WEB_LINK));
			hyperLinkWeb.setTooltipText(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
			if(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION)!=null){
				boolean isDefaultNaviagation=Boolean.parseBoolean(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION));
				hyperLinkWeb.setIsDefault(isDefaultNaviagation);
			}
			else{
				hyperLinkWeb.setIsDefault(false);
			}

			return hyperLinkWeb;
		}

		return null;
	}
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject) {
		if( hyperlinkObject instanceof HyperLinkWeb){
			HyperLinkWeb hyperLinkWeb= (HyperLinkWeb)hyperlinkObject;
			return new CreateHyperLinkWebCommand(domain, object, hyperLinkWeb.getTooltipText(), hyperLinkWeb.getHyperLinkWeb(),hyperlinkObject.getIsDefault());
		}
		else{return null;}
	}
	@Override
	public String getNameofManagedHyperLink() {
		return "Web";
	}
	@Override
	public void executeNewMousePressed(List<HyperlinkObject> list, Package amodel) {
		EditorHyperlinkWebShell editor = new EditorHyperlinkWebShell();
		editor.open();
		if(editor.getHyperLinkWeb() != null) {
			list.add(editor.getHyperLinkWeb());
		}
		
	}
	@Override
	public ArrayList<HyperlinkObject> getFilteredObject(List<HyperlinkObject> hyperlinkObjects) {
		ArrayList<HyperlinkObject> result= new ArrayList<HyperlinkObject>();
		Iterator<HyperlinkObject> iterator= hyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iterator.next();
			if(hyperlinkObject instanceof HyperLinkWeb){
				result.add(hyperlinkObject);
			}
		}
		return result;
	}

}
