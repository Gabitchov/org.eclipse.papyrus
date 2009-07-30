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
 * Completion proposal computer for multiplicity strings.
 */
public class MultiplicityCompletionProposal implements ICompletionProposalComputer {

	/**
	 * 
	 */
	private static final String EMPTY_MULTIPLICITY = "[]";

	/**
	 * Text inserted in the editor.
	 */
	final static private String[] multiplicityStrings = { "[0..1] ", "[0..*] ", "[1] ", "[1..*] ", };

	/**
	 * Text displayed in the information window.
	 */
	final static private String[] multiplicityStringsInfo = { "Multiplicity: [0..1]", "Multiplicity: [0..*]",
			"Multiplicity: [1]", "Multiplicity: [1..*]", };

	/**
	 * Text displayed in the completion area window.
	 */
	final static private String[] multiplicityStringName = { "[0..1]", "[0..*]", "[1]", "[1..*]", };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.classdiagram.parsers.texteditor.completionproposals.ICompletionProposalComputer
	 * #generateCompletionProposals(int, int, java.lang.String)
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
		if (EMPTY_MULTIPLICITY.startsWith(prefix)) {
			proposal = new CompletionProposal(EMPTY_MULTIPLICITY, documentOffset - prefix.length(), prefix.length()
					+ selectionRange, 1, null, "[m..n]", null, "Multiplicity");
			v.add(proposal);
		}

		// adds all standard multiplicities (static strings...)
		for (int i = 0; i < multiplicityStrings.length; i++) {
			if (multiplicityStrings[i].startsWith(prefix)) {
				proposal = new CompletionProposal(multiplicityStrings[i], documentOffset - prefix.length(), prefix
						.length()
						+ selectionRange, multiplicityStrings[i].length(), null, multiplicityStringName[i], null,
						multiplicityStringsInfo[i]);
				v.add(proposal);
			}
		}
		return v;
	}
}
