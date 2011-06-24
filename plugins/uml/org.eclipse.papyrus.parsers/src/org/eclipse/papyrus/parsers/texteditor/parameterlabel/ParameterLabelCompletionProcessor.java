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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.antlr.ParameterLabelLexer;
import org.eclipse.papyrus.parsers.antlr.ParameterLabelParser;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration;
import org.eclipse.papyrus.parsers.texteditor.LabelCompletionProcessor;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration.ICompletionFilter;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.DefaultValueCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.DirectionCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.MultiplicityCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.NameCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.ParameterModifierProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.ParameterModifiersProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.TypeCompletionProposalComputer;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.VisibilityCompletionProposal;
import org.eclipse.papyrus.parsers.util.SimpleStringErrorReporter;
import org.eclipse.uml2.uml.Parameter;

/**
 * Completion processor for action language. <BR>
 * Main class to process the different completions given by the texteditor to its user
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor
 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor
 * @see com.cea.actionlanguage.sharedresources.texteditor.IPropertyLabelKeywords
 */
public class ParameterLabelCompletionProcessor extends LabelCompletionProcessor implements IContext {

	/** The completion filter. */
	private final ICompletionFilter completionFilter;

	/** The {@link Parameter} to modify */
	private Parameter parameter;

	/** The modifiers used. */
	private Map<String, Boolean> modifiersUsed;

	/**
	 * Constructor
	 * 
	 * @param parameter
	 *        the parsed {@link Parameter}
	 */
	public ParameterLabelCompletionProcessor(Parameter parameter) {
		this.parameter = parameter;
		this.completionFilter = new CompletionFilterSourceViewerConfiguration.NullCompletionFilter();
	}

	/**
	 * The Constructor.
	 * 
	 * @param property
	 *        the property
	 * @param iCompletionFilter
	 *        the i completion filter
	 */
	public ParameterLabelCompletionProcessor(Parameter parameter, ICompletionFilter iCompletionFilter) {
		this.parameter = parameter;
		this.completionFilter = iCompletionFilter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.LabelCompletionProcessor
	 * #computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	/**
	 * This method computes completion proposal for currently edited Parameter label.
	 * 
	 * @param viewer
	 * @param documentOffset
	 * 
	 * @return completion proposals
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		String text;
		String prefix = "";
		ParameterLabelLexer lexer = null;
		ParameterLabelParser parser = null;
		Collection<ICompletionProposal> result = null;
		int selectionRange = 0;

		try {
			text = viewer.getDocument().get(0, documentOffset);
			lexer = new ParameterLabelLexer(new ANTLRStringStream(text));
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			parser = new ParameterLabelParser(tokens, parameter, new SimpleStringErrorReporter());
			parser.setValidation(true);
			selectionRange = viewer.getSelectedRange().y;
			parser.label();
			modifiersUsed = parser.getModifiersUsed();
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			modifiersUsed = parser.getModifiersUsed();
			prefix = getPrefix(viewer, documentOffset);
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (RecognitionException e) {
			modifiersUsed = parser.getModifiersUsed();
			prefix = getPrefix(viewer, documentOffset);
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
	public Collection<ICompletionProposal> computeCompletions(ITextViewer viewer, int context, int documentOffset, int selectionRange) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();
		ParameterModifierProposal modifierProposalComputer = new ParameterModifierProposal();
		modifierProposalComputer.setModifiersUsed(modifiersUsed);

		String prefix = getPrefix(viewer, documentOffset);
		switch(context) {

		// DEFAULT : visibility or direction or name
		case IContext.DEFAULT:
			v.addAll(new VisibilityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new DirectionCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// VISIBILITY : direction or name
		case IContext.VISIBILITY:
			v.addAll(new DirectionCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// DIRECTION : name
		case IContext.DIRECTION:
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// NAME: either ':' or ":undefined"
		case IContext.NAME:
			v.addAll(createCompletionProposalsWithDifferentName(new String[]{ ": ", ": <Undefined>" }, new String[]{ "Parameter type", "Undefined Parameter type" }, new String[]{ ": <Type Name>", ": <Undefined>" }, "", documentOffset));
			break;

		// PROPERTY TYPE (after ":") model types or undefined
		case IContext.AFTER_COLON:
			// create properties visible in the model
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			// generate completion for TypeUtil
			TypeCompletionProposalComputer computer = new TypeCompletionProposalComputer(completionFilter, IContext.AFTER_COLON);
			computer.setElement(parameter);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// MULTIPLICITY: multiplicity or default value or property modifiers
		case IContext.PARAMETER_TYPE:
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			computer = new TypeCompletionProposalComputer(completionFilter, IContext.PARAMETER_TYPE);
			computer.setElement(parameter);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// IN_MULTIPLICITY(after '['): does nothing
		case IContext.MULTIPLICITY:
			// create properties visible in the model
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			// generate completion for TypeUtil
			computer = new TypeCompletionProposalComputer(completionFilter, IContext.AFTER_COLON);
			computer.setElement(parameter);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new MultiplicityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new DefaultValueCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new ParameterModifiersProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// : default value or property modifiers
		case IContext.IN_MULTIPLICITY:
			prefix = getPrefixForMultiplicity(viewer, documentOffset);
			v.addAll(new MultiplicityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// AFTER_MULTIPLICITY(after ']')
		case IContext.AFTER_MULTIPLICITY:
			v.addAll(new DefaultValueCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new ParameterModifiersProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// DEFAULT_VALUE: property modifiers
		case IContext.DEFAULT_VALUE:
			v.addAll(new ParameterModifiersProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		case IContext.PARAMETER_MODIFIERS:
			v.addAll(modifierProposalComputer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		case IContext.PARAMETER_MODIFIER:
			v.addAll(modifierProposalComputer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;
		default:
			break;
		}

		return v;
	}
}
