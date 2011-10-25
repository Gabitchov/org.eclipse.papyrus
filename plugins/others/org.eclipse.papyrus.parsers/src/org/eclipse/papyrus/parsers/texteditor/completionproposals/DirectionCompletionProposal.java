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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * Completion proposal computer for direction.
 */
public class DirectionCompletionProposal implements ICompletionProposalComputer {

	/**
	 * Text inserted in the editor.
	 */
	final static public String[] directionStrings = { "in", "out", "inout", "return", };

	/**
	 * Text displayed in the information window.
	 */
	final static public String[] directionStringsInfo = { "in direction", "out direction", "inout direction",
			"return direction", };

	/**
	 * Text displayed in the completion area window.
	 */
	final static public String[] directionStringsName = { "in", "out", "inout", "return", };

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
		List<ICompletionProposal> list = new ArrayList<ICompletionProposal>();

		// adds each Completion proposal
		ICompletionProposal proposal = null;

		// adds all standard multiplicities (static strings...)
		for(int i = 0; i < directionStrings.length; i++) {
			if(directionStrings[i].startsWith(prefix)) {
				proposal = new CompletionProposal(directionStrings[i], documentOffset - prefix.length(), prefix
						.length()
						+ selectionRange, directionStrings[i].length(), null, directionStringsName[i], null,
						directionStringsInfo[i]);
				list.add(proposal);
			}
		}
		return list;
	}
}
