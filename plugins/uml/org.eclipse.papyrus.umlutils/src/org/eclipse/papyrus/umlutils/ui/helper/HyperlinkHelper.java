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
package org.eclipse.papyrus.umlutils.ui.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.command.CreateHyperLinkCommand;
import org.eclipse.papyrus.umlutils.ui.command.DeleteHyperLinkCommand;

/**
 * The Class HyperlinkHelper.
 */
public class HyperlinkHelper {

	/**
	 * Gets the adds the hyper link command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param localization
	 *            the localization
	 * 
	 * @return the adds the hyper link command
	 */
	public static RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object,
			String localization) {
		return new CreateHyperLinkCommand(domain, object, VisualInformationPapyrusConstant.HYPERLINK_ONLY, localization);
	}

	/**
	 * Gets the adds the document command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param localization
	 *            the localization
	 * 
	 * @return the adds the document command
	 */
	public static RecordingCommand getAddDocumentCommand(TransactionalEditingDomain domain, EModelElement object,
			String localization) {
		return new CreateHyperLinkCommand(domain, object, VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT,
				localization);
	}

	/**
	 * Gets the removes the element command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param localization
	 *            the localization
	 * 
	 * @return the removes the element command
	 */
	public static RecordingCommand getRemoveElementCommand(TransactionalEditingDomain domain, EModelElement object,
			String localization) {
		return new DeleteHyperLinkCommand(domain, object, localization);

	}

	/**
	 * Gets the allreferenced element.
	 * 
	 * @param object
	 *            the object
	 * @param hyperlinkKind
	 *            the hyperlink kind
	 * 
	 * @return the allreferenced
	 */
	protected static ArrayList<String> getAllreferenced(EModelElement object, String hyperlinkKind) {
		ArrayList<String> result = new ArrayList<String>();
		EAnnotation eAnnotation = object.getEAnnotation(VisualInformationPapyrusConstant.HYPERLINK);
		if (eAnnotation != null) {
			Iterator<Entry<String, String>> iteratorEntry = eAnnotation.getDetails().iterator();
			while (iteratorEntry.hasNext()) {
				Map.Entry<java.lang.String, java.lang.String> currentEntry = (Map.Entry<java.lang.String, java.lang.String>) iteratorEntry
						.next();
				if (currentEntry.getValue().equals(hyperlinkKind)) {
					result.add(currentEntry.getKey());
				}
			}
		}
		return result;

	}

	/**
	 * Gets the all referenced document attached to the object.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the allreferenced document
	 */
	public static ArrayList<String> getAllreferencedDocument(EModelElement object) {
		return getAllreferenced(object, VisualInformationPapyrusConstant.HYPERLINK_DOCUMENT);
	}

	/**
	 * Gets the all hyper link attached to the object.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the all hyper link
	 */
	public static ArrayList<String> getAllHyperLink(EModelElement object) {
		return getAllreferenced(object, VisualInformationPapyrusConstant.HYPERLINK_ONLY);
	}

}
