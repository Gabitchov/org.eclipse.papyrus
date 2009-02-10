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
package org.eclipse.papyrus.parsers.texteditor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

/**
 * Completion processor for action language. <BR>
 * Main class to process the different completions given by the texteditor to
 * its user
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor
 * @see com.cea.actionlanguage.sharedresources.texteditor.IPortLabelKeywords
 */
public class LabelCompletionProcessor implements IContentAssistProcessor {

	/**
	 * 
	 */
	protected Map<String, Boolean> modifiersUsed; 

	/**
	 * 
	 */
	public LabelCompletionProcessor() {
		modifiersUsed = new HashMap<String, Boolean>();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	/**
	 * 
	 * 
	 * @param viewer 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset) {
		return new ICompletionProposal[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	/**
	 * 
	 * 
	 * @param viewer 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int documentOffset) {
		return new IContextInformation[0];
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	/**
	 * 
	 * 
	 * @return 
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { ':' };
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	/**
	 * 
	 * 
	 * @return 
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return new char[] { '#' };
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	/**
	 * 
	 * 
	 * @return 
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	/*
	 * (non-Javadoc) Method declared on IContentAssistProcessor
	 */
	/**
	 * 
	 * 
	 * @return 
	 */
	public String getErrorMessage() {
		return null;
	}

	/**
	 * when computing completion proposals, this method retrieves the string on
	 * which the user is computing proposals it checks recursively if the
	 * character at the precedent offset is also a part of the string (is a Java
	 * identifier).
	 * 
	 * @param viewer the text viewer where the current document is shown
	 * @param documentOffset the offset on which the end of the calculated string is
	 * 
	 * @return the string that will be completed
	 */
	public String getPrefix(ITextViewer viewer, int documentOffset) {
		try {
			if (documentOffset != 0) {
				char c = viewer.getDocument().getChar(documentOffset - 1);
				if (Character.isJavaIdentifierPart(c) || (c == '\'')) {
					return getPrefix(viewer, documentOffset - 1) + c;
				}
			}
		} catch (BadLocationException e) {
			return "";
		}
		return "";
	}

	/**
	 * when computing completion proposals, this method retrieves the string on
	 * which the user is computing proposals it checks recursively if the
	 * character at the precedent offset is also a part of the string (is a Java
	 * identifier or '<' for Undefined type).
	 * 
	 * @param viewer the text viewer where the current document is shown
	 * @param documentOffset the offset on which the end of the calculated string is
	 * 
	 * @return the string that will be completed
	 */
	public String getPrefixForType(ITextViewer viewer, int documentOffset) {
		try {
			if (documentOffset != 0) {
				char c = viewer.getDocument().getChar(documentOffset - 1);
				if (Character.isJavaIdentifierPart(c) || (c == '<')) {
					return getPrefixForType(viewer, documentOffset - 1) + c;
				}
			}
		} catch (BadLocationException e) {
			return "";
		}
		return "";
	}


	/**
	 * 
	 * 
	 * @param viewer 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public String getPrefixForMultiplicity(ITextViewer viewer, int documentOffset) {
		try {
			if (documentOffset != 0) {
				char c = viewer.getDocument().getChar(documentOffset - 1);
				if (Character.isJavaIdentifierPart(c) || (c == '[') || (c == '.')) {
					return getPrefixForMultiplicity(viewer, documentOffset - 1) + c;
				}
			}
		} catch (BadLocationException e) {
			return "";
		}
		return "";
	}
	
	/**
	 * 
	 * 
	 * @param viewer 
	 * @param selectionRange 
	 * @param context 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public Collection<ICompletionProposal> computeCompletions(
			ITextViewer viewer, int context, int documentOffset,
			int selectionRange) {
		return new Vector<ICompletionProposal>();
	}
	
	/**
	 * 
	 * 
	 * @param proposals 
	 * @param prefix 
	 * @param proposalsInfo 
	 * @param documentOffset 
	 * 
	 * @return 
	 */
	public Collection<ICompletionProposal> createCompletionProposals(String[] proposals, String[] proposalsInfo, String prefix, int documentOffset) {
        Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();
        for (int i = 0; i < proposals.length; i++) {
            // test if the proposal starts with the prefix given in parameter
            if(proposals[i].startsWith(prefix)) {
                v.add(new CompletionProposal(
                        proposals[i], 
                        documentOffset-prefix.length(), 
                        prefix.length(),
                        proposals[i].length(), 
                        null, 
                        proposals[i], 
                        null,
                        proposalsInfo[i]));
            }
        }
        return v;
    }
    
    /**
     * 
     * 
     * @param proposals 
     * @param proposalsName 
     * @param prefix 
     * @param proposalsInfo 
     * @param documentOffset 
     * 
     * @return 
     */
    public Collection<ICompletionProposal> createCompletionProposalsWithDifferentName(String[] proposals, String[] proposalsInfo, String[] proposalsName, String prefix, int documentOffset) {
        Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();
        for (int i = 0; i < proposals.length; i++) {
            // test if the proposal starts with the prefix given in parameter
            if(proposals[i].startsWith(prefix)) {
                
                v.add(new CompletionProposal(
                        proposals[i], 
                        documentOffset-prefix.length(), 
                        prefix.length(),
                        proposals[i].length(), 
                        null, 
                        proposalsName[i], 
                        null,
                        proposalsInfo[i]));
            }
        }
        return v;
    }
}