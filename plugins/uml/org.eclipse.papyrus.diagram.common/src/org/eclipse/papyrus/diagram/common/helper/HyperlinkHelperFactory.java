/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.diagram.common.commands.DeleteHyperLinkDocumentCommand;
import org.eclipse.papyrus.diagram.common.commands.EmptyAllHyperLinkCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkException;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;

/**
 * The Class HyperlinkHelper, contains all methods to manipulate information about hyperlinks in a
 * model
 */
public class HyperlinkHelperFactory {

	protected ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers= new ArrayList<AbstractHyperLinkHelper>();

	
	public ArrayList<AbstractHyperLinkHelper> getHyperLinkHelpers() {
		return hyperLinkHelpers;
	}

	public HyperlinkHelperFactory(ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers){
		this.hyperLinkHelpers.clear();
		this.hyperLinkHelpers.addAll(hyperLinkHelpers);
	}

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
	 * @param isDefault
	 * 		  to set this hyperlink as default
	 * @return the adds the hyper link command
	 */
	public  Command getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, ArrayList<HyperlinkObject> hyperlinkObjects) throws HyperLinkException{
		CompoundCommand cmpCommand= new CompoundCommand();
		Iterator<HyperlinkObject> iterator= hyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iterator.next();
			RecordingCommand cmd=null;
			int i=0;
			while(cmd==null &&i<hyperLinkHelpers.size()){
				cmd= hyperLinkHelpers.get(i).getAddHyperLinkCommand(domain, object, hyperlinkObject);
				i++;
			}
			if( cmd==null){
				throw new HyperLinkException("Impossible to find a command to serialize " +hyperlinkObject);
			}
			cmpCommand.append(cmd);
		}
		return cmpCommand;

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
	 * Gets the allreferenced element.
	 * 
	 * @param object
	 *        the object where we look for information
	 * 
	 * @return the allreferenced
	 */
	public  ArrayList<?> getAllreferenced(EModelElement object) throws HyperLinkException{
		ArrayList<HyperlinkObject> result = new ArrayList<HyperlinkObject>();
		Iterator<EAnnotation> iter = object.getEAnnotations().iterator();
		while(iter.hasNext()) {
			EAnnotation currentAnnotation = iter.next();
			int i=0;
			HyperlinkObject hyperlinkObject=null;
			while(hyperlinkObject==null &&i<hyperLinkHelpers.size()){
				hyperlinkObject= hyperLinkHelpers.get(i).getHyperLinkObject(currentAnnotation);
				i++;
			}
			if(hyperlinkObject!=null){
				result.add(hyperlinkObject);}
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
