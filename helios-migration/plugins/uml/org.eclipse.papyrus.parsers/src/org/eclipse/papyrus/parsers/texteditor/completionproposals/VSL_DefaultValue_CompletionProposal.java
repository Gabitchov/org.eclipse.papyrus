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
import org.eclipse.papyrus.parsers.messages.NFPMessages;

public class VSL_DefaultValue_CompletionProposal implements ICompletionProposalComputer {

	/** Text inserted in the editor */
	final static private String[] TVL_DefaultValue_Strings = { "-", };

	/** Text displayed in the information window */
	final static private String[] TVL_DefaultValue_StringsInfo = { NFPMessages.DefaultValue_StringsInfo, };

	/** Text displayed in the completion area window */
	final static private String[] TVL_DefaultValue_StringName = { NFPMessages.DefaultValue_StringName, };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.classdiagram.parsers.texteditor.completionproposals.ICompletionProposalComputer
	 * #generateCompletionProposals(int, int, java.lang.String)
	 */
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();

		// adds each Completion proposal
		ICompletionProposal proposal = null;

		// adds all name (static strings...)
		for(int i = 0; i < TVL_DefaultValue_Strings.length; i++) {
			if(TVL_DefaultValue_Strings[i].startsWith(prefix)) {
				proposal = new CompletionProposal(TVL_DefaultValue_Strings[i], documentOffset - prefix.length(), prefix
						.length()
						+ selectionRange, TVL_DefaultValue_Strings[i].length(), null, TVL_DefaultValue_StringName[i],
						null, TVL_DefaultValue_StringsInfo[i]);
				v.add(proposal);
			}
		}

		return v;
	}
}
