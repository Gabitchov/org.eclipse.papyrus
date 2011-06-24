/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.collaborationuselabel;

import java.util.Collection;
import java.util.Vector;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.antlr.CollaborationUseLabelLexer;
import org.eclipse.papyrus.parsers.antlr.CollaborationUseLabelParser;
import org.eclipse.papyrus.parsers.texteditor.LabelCompletionProcessor;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.CollaborationCompletionProposalComputer;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.NameCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.VisibilityCompletionProposal;
import org.eclipse.papyrus.parsers.util.SimpleStringErrorReporter;
import org.eclipse.uml2.uml.CollaborationUse;

/**
 * Completion processor for action language. <BR>
 * Main class to process the different completions given by the texteditor to its user
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor
 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor
 * @see com.cea.actionlanguage.sharedresources.texteditor.IPropertyLabelKeywords
 */
public class CollaborationUseLabelCompletionProcessor extends LabelCompletionProcessor implements IContext {

	/** The {@link CollaborationUse} to modify */
	private CollaborationUse collaborationUse;

	/**
	 * Constructor
	 * 
	 * @param collaborationUse
	 *        the parsed {@link CollaborationUse}
	 */
	public CollaborationUseLabelCompletionProcessor(CollaborationUse collaborationUse) {
		this.collaborationUse = collaborationUse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.LabelCompletionProcessor
	 * #computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	/**
	 * This method computes completion proposal for currently edited CollaborationUse label.
	 * 
	 * @param viewer
	 * @param documentOffset
	 * 
	 * @return completion proposals
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		String text;
		CollaborationUseLabelLexer lexer = null;
		CollaborationUseLabelParser parser = null;
		Collection<ICompletionProposal> result = null;
		int selectionRange = 0;

		try {
			text = viewer.getDocument().get(0, documentOffset);

			lexer = new CollaborationUseLabelLexer(new ANTLRStringStream(text));
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			parser = new CollaborationUseLabelParser(tokens, collaborationUse, new SimpleStringErrorReporter());
			parser.setValidation(true);
			selectionRange = viewer.getSelectedRange().y;
			parser.label();

			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (BadLocationException e) {

		} catch (RuntimeException e) {
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (RecognitionException e) {
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		}

		return result.toArray(new ICompletionProposal[]{});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.LabelCompletionProcessor
	 * #computeCompletions(org.eclipse.jface.text.ITextViewer, int, int, int)
	 */
	/**
	 * Compute completion possibilities depending on existing edited label (prefix, it may not be
	 * complete).
	 * 
	 * @param viewer
	 * @param selectionRange
	 * @param context
	 * @param documentOffset
	 * 
	 * @return
	 */
	@Override
	public Collection<ICompletionProposal> computeCompletions(ITextViewer viewer, int context, int documentOffset,
			int selectionRange) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();

		String prefix = getPrefix(viewer, documentOffset);
		switch(context) {

		// DEFAULT : visibility or name
		case IContext.DEFAULT:
			v.addAll(new VisibilityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// VISIBILITY : name
		case IContext.VISIBILITY:
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// NAME: either ':' or ":undefined"
		case IContext.NAME:
			v.addAll(createCompletionProposalsWithDifferentName(new String[]{ ": ", ": <Undefined>" }, new String[]{
					"CollaborationUse type", "Undefined CollaborationUse type" }, new String[]{
					": <Collaboration Name>", ": <Undefined>" }, "", documentOffset));
			break;

		// PROPERTY TYPE (after ":") model types or undefined
		case IContext.AFTER_COLON:
			// create properties visible in the model
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			// generate completion for TypeUtil
			CollaborationCompletionProposalComputer computer = new CollaborationCompletionProposalComputer();
			computer.setElement(collaborationUse);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// MULTIPLICITY: multiplicity or default value or property modifiers
		case IContext.COLLABORATION_USE_TYPE:
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			computer = new CollaborationCompletionProposalComputer();
			computer.setElement(collaborationUse);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;
		default:
			break;
		}

		return v;
	}
}
