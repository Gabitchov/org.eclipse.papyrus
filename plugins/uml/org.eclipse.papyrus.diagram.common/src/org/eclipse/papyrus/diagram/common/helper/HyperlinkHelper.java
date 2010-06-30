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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.helper;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDiagramCommand;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDocumentCommand;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkWebCommand;
import org.eclipse.papyrus.diagram.common.commands.DeleteHyperLinkDiagramCommand;
import org.eclipse.papyrus.diagram.common.commands.DeleteHyperLinkDocumentCommand;
import org.eclipse.papyrus.diagram.common.commands.EmptyAllHyperLinkCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkDiagram;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkWeb;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkDocument;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;

/**
 * The Class HyperlinkHelper, contains all methods to manipulate information about hyperlinks in a
 * model
 */
public class HyperlinkHelper {

	/**
	 * Gets the adds the hyper link command.
	 * 
	 * @param domain
	 *        the domain to execute command
	 * @param object
	 *        the object where it is attached the information
	 * @param localization
	 *        the localization of the document
	 * @param tooltipText
	 *        the tooltip text
	 * 
	 * @return the adds the hyper link command
	 */
	public static RecordingCommand getAddHyperLinkDocumentCommand(TransactionalEditingDomain domain, EModelElement object, String tooltipText, String localization) {
		return new CreateHyperLinkDocumentCommand(domain, object, tooltipText, localization);
	}

	/**
	 * Gets the adds the document command.
	 * 
	 * @param domain
	 *        the domain to execute the command
	 * @param object
	 *        the object where it is attached the information
	 * @param link
	 *        the web link
	 * @param tooltiptext
	 *        the tooltip text
	 * 
	 * @return the adds the document command
	 */
	public static RecordingCommand getAddHyperLinkWebCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String link) {
		return new CreateHyperLinkWebCommand(domain, object, tooltiptext, link);
	}

	/**
	 * Gets the adds the hyper link diagam command.
	 * 
	 * @param domain
	 *        the domain to execute the command
	 * @param object
	 *        the object where it is attached the information
	 * @param tooltiptext
	 *        the tooltip text
	 * @param diagramName
	 *        the diagram name
	 * @param diagram
	 *        the diagram
	 * 
	 * @return the adds the hyper link diagram command
	 */
	public static RecordingCommand getAddHyperLinkDiagamCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String diagramName, EModelElement diagram) {
		return new CreateHyperLinkDiagramCommand(domain, object, tooltiptext, diagramName, diagram);
	}

	/**
	 * use to remove a hyperlink web or document
	 * 
	 * @param domain
	 *        the domain to execute the command
	 * @param object
	 *        the object where was attached the information
	 * @param localization
	 *        the localization or link
	 * 
	 * @return the removes the element command
	 */
	public static RecordingCommand getRemoveHyperlinkCommand(TransactionalEditingDomain domain, EModelElement object, String localization) {
		return new DeleteHyperLinkDocumentCommand(domain, object, localization);

	}

	/**
	 * Gets the removes the hyperlink diagram command.
	 * 
	 * @param domain
	 *        the domain to execute the commmand
	 * @param object
	 *        the object where the information is attached
	 * @param diagram
	 *        the diagram to remove
	 * 
	 * @return the removes the hyperlink diagram command
	 */
	// @unused
	public static RecordingCommand getRemoveHyperlinkDiagramCommand(TransactionalEditingDomain domain, EModelElement object, EModelElement diagram) {
		return new DeleteHyperLinkDiagramCommand(domain, object, diagram);

	}

	/**
	 * Gets the allreferenced element.
	 * 
	 * @param object
	 *        the object where we look for information
	 * @param hyperlinkKind
	 *        the hyperlink kind see {@link VisualInformationPapyrusConstant}
	 * 
	 * @return the allreferenced
	 */
	public static ArrayList<?> getAllreferenced(EModelElement object, String hyperlinkKind) {
		ArrayList<HyperlinkObject> result = new ArrayList<HyperlinkObject>();
		Iterator<EAnnotation> iter = object.getEAnnotations().iterator();
		while(iter.hasNext()) {
			EAnnotation currentAnnotation = iter.next();
			if(currentAnnotation.getSource().equals(hyperlinkKind)) {
				if(hyperlinkKind.equals(VisualInformationPapyrusConstant.HYPERLINK_DIAGRAM)) {
					HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
					EList<EObject>list=currentAnnotation.getReferences();
					if(list.size()>0){
						if(currentAnnotation.getReferences().get(0).eResource()!=null){
							hyperLinkDiagram.setDiagram((Diagram)currentAnnotation.getReferences().get(0));
							hyperLinkDiagram.setTooltipText(currentAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
							result.add(hyperLinkDiagram);
						}
					}
				} else if(hyperlinkKind.equals(VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT)) {
					HyperlinkDocument hyperLinkDocument = new HyperlinkDocument();
					hyperLinkDocument.setHyperlinkDocument(currentAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT_LOCALIZATION));
					hyperLinkDocument.setTooltipText(currentAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
					result.add(hyperLinkDocument);
				} else if(hyperlinkKind.equals(VisualInformationPapyrusConstant.HYPERLINK_WEB)) {
					HyperLinkWeb hyperLinkWeb = new HyperLinkWeb();
					hyperLinkWeb.setHyperLinkWeb(currentAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_WEB_LINK));
					hyperLinkWeb.setTooltipText(currentAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
					result.add(hyperLinkWeb);
				}
			}
		}

		return result;

	}

	/**
	 * Gets the empty all hyper link command. to clean all hyperlinks
	 * 
	 * @param domain
	 *        the domain to execute the command
	 * @param object
	 *        the object where is attached information
	 * 
	 * @return the empty all hyper link command
	 */
	public static EmptyAllHyperLinkCommand getEmptyAllHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object) {
		return new EmptyAllHyperLinkCommand(domain, object);
	}

}
