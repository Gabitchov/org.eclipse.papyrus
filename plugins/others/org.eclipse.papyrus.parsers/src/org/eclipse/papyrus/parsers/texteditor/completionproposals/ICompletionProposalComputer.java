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

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * 
 */
public interface ICompletionProposalComputer {

	/** set of text completions */
	/** set of text completions information */
	/**
	 * set of text completions text.
	 * 
	 * @param selectionRange
	 * @param prefix
	 * @param documentOffset
	 * 
	 * @return
	 */

	// String[] proposals, String[] proposalsInfo, String prefix,
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix);

}
