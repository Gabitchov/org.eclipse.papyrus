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
 * Completion proposal computer for visibilities.
 */
public class VisibilityCompletionProposal implements ICompletionProposalComputer {

	/**
	 * Text inserted in the editor.
	 */
	final static public String[] visibilityStrings = { "+", "-", "#", "~", };

	/**
	 * Text displayed in the information window.
	 */
	final static public String[] visibilityStringsInfo = { "Public visibility", "Private visibility",
			"Protected visibility", "Package visibility", };

	/**
	 * Text displayed in the completion area window.
	 */
	final static public String[] visibilityStringsName = { "+", "-", "#", "~", };

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

		// adds all standard multiplicities (static strings...)
		for(int i = 0; i < visibilityStrings.length; i++) {
			if(visibilityStrings[i].startsWith(prefix)) {
				proposal = new CompletionProposal(visibilityStrings[i], documentOffset - prefix.length(), prefix
						.length()
						+ selectionRange, visibilityStrings[i].length(), null, visibilityStringsName[i], null,
						visibilityStringsInfo[i]);
				v.add(proposal);
			}
		}
		return v;
	}
}
