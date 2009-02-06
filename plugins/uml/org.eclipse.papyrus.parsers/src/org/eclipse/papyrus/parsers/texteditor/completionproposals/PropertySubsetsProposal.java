/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.completionproposals;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.umlutils.Property;



/**
 * Completion proposal computer for multiplicity strings.
 */
public class PropertySubsetsProposal implements ICompletionProposalComputer {

	/**
	 * 
	 * 
	 * @param property 
	 */
	public PropertySubsetsProposal(Property property) {
		this.property = property;
	}

	/**
	 * 
	 */
	private Property property;

	/**
	 * 
	 * 
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * 
	 * 
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

	/* (non-Javadoc)
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.completionproposals.ICompletionProposalComputer#generateCompletionProposals(int, int, java.lang.String)
	 */
	/**
	 * 
	 * 
	 * @param selectionRange 
	 * @param prefix 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();

		Iterator<Property> it = property.getSubsettablesProperties().iterator();
		while (it.hasNext()) {
			Property prop = it.next();
			String name = prop.getName();

			if(name.startsWith(prefix)) {
				v.add(new CompletionProposal(
						prop.getName(),
						documentOffset-prefix.length(),
						prefix.length()+selectionRange,
						prop.getName().length(),
						null,
						prop.getName(),
						null,
						prop.getQualifiedName()
				));
			}
		}
		return v;
	}
}
