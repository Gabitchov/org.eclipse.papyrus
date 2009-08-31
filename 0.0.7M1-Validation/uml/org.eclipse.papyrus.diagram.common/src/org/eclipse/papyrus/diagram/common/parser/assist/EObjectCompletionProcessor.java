/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parser.assist;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.contentassist.IContentAssistSubjectControl;
import org.eclipse.jface.contentassist.ISubjectControlContentAssistProcessor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;

/**
 * Computes completion proposals for given context EObject.
 * 
 * Intended to be used in case if the whole set of proposals does not depend on the suggested prefix
 * text and only filtering by given string prefix is required to compute the result list.
 */
public abstract class EObjectCompletionProcessor implements IContentAssistProcessor,
		ISubjectControlContentAssistProcessor {

	private static final ICompletionProposal[] NO_PROPOSALS = new ICompletionProposal[0];

	private static final IContextInformation[] NO_CONTEXTS = new IContextInformation[0];

	private EObject myContext;

	protected abstract Iterable<String> computeContextProposals(EObject context);

	public void setContext(EObject context) {
		myContext = context;
	}

	public ICompletionProposal[] computeCompletionProposals(IContentAssistSubjectControl subjectControl, int offset) {
		if (myContext == null) {
			return NO_PROPOSALS;
		}
		Point selection = subjectControl.getSelectedRange();
		int selectionStart = selection.x;
		int selectionLength = selection.y;
		String prefix = getPrefix(subjectControl, selectionStart);
		int prefixLength = prefix.length();

		List<ICompletionProposal> result = new LinkedList<ICompletionProposal>();
		for (String next : computeContextProposals(myContext)) {
			if (next == null || !next.startsWith(prefix)) {
				continue;
			}
			ICompletionProposal proposal = new CompletionProposal(next, selectionStart - prefixLength, selectionLength
					+ prefixLength, next.length(), null, next, null, null);
			result.add(proposal);
		}
		return result.toArray(NO_PROPOSALS);
	}

	public IContextInformation[] computeContextInformation(IContentAssistSubjectControl contentAssistSubjectControl,
			int documentOffset) {
		return NO_CONTEXTS;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		throw new UnsupportedOperationException("use ISubjectControlContentAssistProcessor instead");
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return NO_CONTEXTS;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

	private String getPrefix(IContentAssistSubjectControl subjectControl, int offset) {
		IDocument doc = subjectControl.getDocument();
		if (doc == null || offset > doc.getLength()) {
			throw new IllegalStateException("Bad content assist subject control: " + doc);
		}
		try {
			return doc.get(0, offset);
		} catch (BadLocationException e) {
			throw new IllegalStateException(e);
		}
	}

}
