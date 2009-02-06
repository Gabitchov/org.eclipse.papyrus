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

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;


/**
 * Completion proposal computer for property modifiers strings.
 */
public class PropertyModifierProposal implements ICompletionProposalComputer {

	// vector that keeps modifiers already used (used for completion)
	/**
	 * 
	 */
	public Map<String, Boolean> modifiersUsed; 

	/**
	 * 
	 * 
	 * @return the modifiersUsed
	 */
	public Map<String, Boolean> getModifiersUsed() {
		return modifiersUsed;
	}

	/**
	 * 
	 * 
	 * @param modifiersUsed the modifiersUsed to set
	 */
	public void setModifiersUsed(Map<String, Boolean> modifiersUsed) {
		this.modifiersUsed = modifiersUsed;
	}

	/**
	 * Text inserted in the editor.
	 */
	final static public String[] modifiersStrings = {
		"readOnly",
		"union",
		"ordered",
		"unique",
		"nonunique",
		"subsets ",
		"redefines ", 
	};

	/**
	 * Text displayed in the information window.
	 */
	final static public String[] modifiersStringsInfo = {
		"ReadOnly property",
		"Specifies whether the property is derived as\n " +
		"the union of all of the properties that are\n" +
		"constrained to subset it. ",
		"ordered collection property",
		"No duplicates allowed in the collection",
		"Duplicates allowed in the collection",
		"Property subset",
		"Property redefinition",
	}; 

	/**
	 * Text displayed in the completion area window.
	 */
	final static public String[] modifiersStringsName = {
		"readOnly",
		"union",
		"ordered",
		"unique",
		"nonunique",
		"subsets <PropertyName>",
		"redefines <PropertyName>",
	};

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

		// adds each Completion proposal
		ICompletionProposal proposal = null;

		// adds all standard multiplicities (static strings...)
		for(int i=0; i < modifiersStrings.length; i++) {
			// test if this modifier is valid (already used or othe contrary has alreday been used.
			if(!modifiersUsed.get(modifiersStrings[i])) { 
				if(modifiersStrings[i].startsWith(prefix)) {
					proposal = new CompletionProposal(
							modifiersStrings[i],
							documentOffset-prefix.length(),
							prefix.length()+selectionRange,
							modifiersStrings[i].length(),
							null,
							modifiersStringsName[i],
							null,
							modifiersStringsInfo[i]);
					v.add(proposal);
				}
			}
		}
		return v;
	}
}
