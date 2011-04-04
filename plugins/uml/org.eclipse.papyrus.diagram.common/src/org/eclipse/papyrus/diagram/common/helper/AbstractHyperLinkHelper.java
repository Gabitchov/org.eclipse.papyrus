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
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.uml2.uml.Package;


/**
 * this class is an abstract use to serialize and deserialize a HyperLink Object
 *
 */
public abstract class AbstractHyperLinkHelper {
	
	/**
	 * 
	 * @return as string of the kind of hyperlink to display
	 */
	public abstract String getNameofManagedHyperLink();
	/**
	 * this method is called in order to create an hyperlinkObject and add into a given hyperlinkObject list
	 * @param list a list of hyperlink Object
	 * @param amodel the root model
	 */
	public abstract void executeNewMousePressed(List<HyperlinkObject> list, org.eclipse.uml2.uml.Package amodel);
	/**
	 *this method is called in order to edit an hyperlinkObject and add into a given hyperlinkObject list
	 * @param list a list of hyperlink Object
	 * @param amodel the root model
	 * @param hyperlinkObject the hyperlinkObject to edit
	 */
	public  void executeEditMousePressed(List<HyperlinkObject> list, HyperlinkObject hyperlinkObject,Package amodel){
		hyperlinkObject.executeEditMousePressed(list, amodel);
	}
	/**
	 * this method is called when the element is selected an clicked in order to open a diagram in the case of hyperlink diagram
	 * @param hyperlinkObject  the hyperlink object that is selected
	 */
	public void executeSelectPressed(HyperlinkObject hyperlinkObject){
		hyperlinkObject.executeSelectPressed();
	}
	
	/**
	 * from a list of hyperlinks, it return a list of hyperlink with the same kind.
	 * for example return a list of diagramhyperlink
	 * @param hyperlinkObjects the list of hyperlinkobjects
	 * @return a list of hyperlink object with the same kind 
	 */
	public abstract ArrayList<HyperlinkObject> getFilteredObject(List<HyperlinkObject> hyperlinkObjects);

	/**
	 * 
	 * @param eAnnotation that represents a hyperlink object
	 * @return the hyperlink object from the eannotation
	 */
	public  abstract HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation);
	
	
	/**
	 * get a command to serailize a hyperlink object
	 * @param domain the editing domain
	 * @param object the EModelElement to which the hyperlink as attached
	 * @param hyperlinkObject the hyperlinkObject to serailize
	 * @return the command in charge of the serialization
	 */
	public abstract RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject);
}
