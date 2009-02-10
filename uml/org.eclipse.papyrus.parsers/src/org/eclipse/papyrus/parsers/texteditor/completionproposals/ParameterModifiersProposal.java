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
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;


/**
 * Completion proposal computer for parameter modifiers strings.
 */
public class ParameterModifiersProposal implements ICompletionProposalComputer {

	/**
	 * 
	 */
	private static final String EMPTY_MODIFIERS = "{}";



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

		// first, add [] ans set the cursor after left curly
		if(EMPTY_MODIFIERS.startsWith(prefix)) {
			proposal = new CompletionProposal(EMPTY_MODIFIERS, documentOffset-prefix.length(), prefix.length()+selectionRange, 1, null, "{ <ParameterModifiers> }", null, "Parameter modifiers");
			v.add(proposal);
		}

		return v;
	}
}
