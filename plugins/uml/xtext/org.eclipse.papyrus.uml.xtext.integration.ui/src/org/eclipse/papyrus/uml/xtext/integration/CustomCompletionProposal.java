/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.xtext.integration;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * @author CEA LIST - Initial contribution and API
 */
public class CustomCompletionProposal implements ICompletionProposal, ICompletionProposalExtension {

	private CompletionProposal completionProposal ;
	private int fReplacementOffset ;
	private ContentAssistContext fContentAssistContext ;
	private String fReplacementString ;

	/**
	 * @param replacementString 
	 * @param replacementOffset 
	 * @param replacementLength 
	 * @param cursorPosition 
	 * @param image 
	 * @param displayString 
	 * @param contextInformation 
	 * @param additionalProposalInfo 
	 * @param contentAssistContext 
	 *
	 */
	public CustomCompletionProposal (String replacementString,
									 int replacementOffset,
									 int replacementLength,
									 int cursorPosition,
									 Image image,
									 String displayString,
									 IContextInformation contextInformation,
									 String additionalProposalInfo,
									 ContentAssistContext contentAssistContext) {
		completionProposal = new CompletionProposal(replacementString, 
													replacementOffset, 
													replacementLength, 
													cursorPosition, 
													image, 
													displayString, 
													contextInformation, 
													additionalProposalInfo) ;
		fReplacementOffset = replacementOffset ; 
		fReplacementString = replacementString ;
		fContentAssistContext = contentAssistContext ;
	}
	
	public void apply(IDocument document, char trigger, int offset) {
		try {
			int length = 0 ;
			if (offset != fReplacementOffset)
				length = offset - fReplacementOffset ;
			else
				length = fContentAssistContext.getSelectedText().length() ;
			document.replace(fReplacementOffset , 
							length, 
							fReplacementString) ;
		}
		catch (BadLocationException e) {
			// ignore
		}
	}

	public boolean isValidFor(IDocument document, int offset) {
		try {
			int length = offset - fReplacementOffset ;
			return completionProposal.getDisplayString().toLowerCase().contains(document.get(fReplacementOffset, length).toLowerCase()) ;
		}
		catch (BadLocationException e) {
			// ignore
		}
		return false;
	}

	public char[] getTriggerCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getContextInformationPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void apply(IDocument document) {
		// TODO Auto-generated method stub
		
	}

	public Point getSelection(IDocument document) {
		return completionProposal.getSelection(document);
	}

	public String getAdditionalProposalInfo() {
		return completionProposal.getAdditionalProposalInfo();
	}

	public String getDisplayString() {
		return completionProposal.getDisplayString();
	}

	public Image getImage() {
		return completionProposal.getImage();
	}

	public IContextInformation getContextInformation() {
		return completionProposal.getContextInformation();
	}

}
