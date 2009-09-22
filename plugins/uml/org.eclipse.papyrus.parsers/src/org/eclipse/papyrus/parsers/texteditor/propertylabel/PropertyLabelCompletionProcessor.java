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
package org.eclipse.papyrus.parsers.texteditor.propertylabel;

import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.antlr.PropertyLabelLexer;
import org.eclipse.papyrus.parsers.antlr.PropertyLabelParser;
import org.eclipse.papyrus.parsers.texteditor.LabelCompletionProcessor;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.DefaultValueCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.DerivedPropertyCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.MultiplicityCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.NameCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.PropertyModifierProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.PropertyModifiersProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.PropertyRedefineProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.PropertySubsetsProposal;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.TypeCompletionProposalComputer;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.VisibilityCompletionProposal;
import org.eclipse.papyrus.parsers.util.SimpleStringErrorReporter;
import org.eclipse.uml2.uml.Property;

/**
 * Completion processor for action language. <BR>
 * Main class to process the different completions given by the texteditor to its user
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor
 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor
 * @see com.cea.actionlanguage.sharedresources.texteditor.IPropertyLabelKeywords
 */
public class PropertyLabelCompletionProcessor extends LabelCompletionProcessor implements IContext {

	/**
	 * 
	 */
	private Property property;

	/**
	 * 
	 */
	private Map<String, Boolean> modifiersUsed;

	/**
	 * 
	 * 
	 * @param property
	 */
	public PropertyLabelCompletionProcessor(Property property) {
		this.property = property;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.LabelCompletionProcessor
	 * #computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	/**
	 * 
	 * 
	 * @param viewer
	 * @param documentOffset
	 * 
	 * @return
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		String text;
		String prefix = "";
		PropertyLabelLexer lexer = null;
		PropertyLabelParser parser = null;
		Collection<ICompletionProposal> result = null;
		int selectionRange = 0;

		try {
			text = viewer.getDocument().get(0, documentOffset);

			lexer = new PropertyLabelLexer(new ANTLRStringStream(text));
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			parser = new PropertyLabelParser(tokens, property, new SimpleStringErrorReporter());
			parser.setValidation(true);
			selectionRange = viewer.getSelectedRange().y;
			parser.label();
			modifiersUsed = parser.getModifiersUsed();
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			// e.printStackTrace();
			modifiersUsed = parser.getModifiersUsed();
			prefix = getPrefix(viewer, documentOffset);
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		} catch (RecognitionException e) {
			modifiersUsed = parser.getModifiersUsed();
			prefix = getPrefix(viewer, documentOffset);
			result = computeCompletions(viewer, parser.getContext(), documentOffset, selectionRange);
		}

		return result.toArray(new ICompletionProposal[] {});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.classdiagram.parsers.texteditor.LabelCompletionProcessor
	 * #computeCompletions(org.eclipse.jface.text.ITextViewer, int, int, int)
	 */
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
	@Override
	public Collection<ICompletionProposal> computeCompletions(ITextViewer viewer, int context, int documentOffset,
			int selectionRange) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();
		PropertyModifierProposal modifierProposalComputer = new PropertyModifierProposal();
		;
		modifierProposalComputer.setModifiersUsed(modifiersUsed);

		String prefix = getPrefix(viewer, documentOffset);
		switch (context) {

		// DEFAULT : visibility, isDerived or name
		case IContext.DEFAULT:
			v.addAll(new VisibilityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			v.addAll(new DerivedPropertyCompletionProposal().generateCompletionProposals(documentOffset,
					selectionRange, prefix));
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// VISIBILITY : isDerived or name
		case IContext.VISIBILITY:
			v.addAll(new DerivedPropertyCompletionProposal().generateCompletionProposals(documentOffset,
					selectionRange, prefix));
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// IS_DERIVED: name
		case IContext.IS_DERIVED:
			v.addAll(new NameCompletionProposal().generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// NAME: either ':' or ":undefined"
		case IContext.NAME:
			v.addAll(createCompletionProposalsWithDifferentName(new String[] { ": ", ": <Undefined>" }, new String[] {
					"Property type", "Undefined property type" }, new String[] { ": <Type Name>", ": <Undefined>" },
					"", documentOffset));
			break;

		// PROPERTY TYPE (after ":") model types or undefined
		case IContext.AFTER_COLON:
			// create properties visible in the model
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			// generate completion for TypeUtil
			TypeCompletionProposalComputer computer = new TypeCompletionProposalComputer();
			computer.setElement(property);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// MULTIPLICITY: multiplicity or default value or property modifiers
		case IContext.PROPERTY_TYPE:
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			computer = new TypeCompletionProposalComputer();
			computer.setElement(property);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			// v.addAll(new
			// MultiplicityCompletionProposal().generateCompletionProposals(documentOffset,
			// selectionRange,
			// prefix));
			// v.addAll(new
			// DefaultValueCompletionProposal().generateCompletionProposals(documentOffset,
			// selectionRange,
			// prefix));
			// v.addAll(new PropertyModifiersProposal()
			// .generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// IN_MULTIPLICITY(after '['): does nothing
		case IContext.MULTIPLICITY:
			// create properties visible in the model
			// specific prefix for type... ('<' possible at the beginning)
			prefix = getPrefixForType(viewer, documentOffset);
			// generate completion for TypeUtil
			computer = new TypeCompletionProposalComputer();
			computer.setElement(property);
			v.addAll(computer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			v.addAll(new MultiplicityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			v.addAll(new DefaultValueCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			v.addAll(new PropertyModifiersProposal()
					.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// : default value or property modifiers
		case IContext.IN_MULTIPLICITY:
			prefix = getPrefixForMultiplicity(viewer, documentOffset);
			v.addAll(new MultiplicityCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			break;

		// AFTER_MULTIPLICITY(after ']')
		case IContext.AFTER_MULTIPLICITY:
			v.addAll(new DefaultValueCompletionProposal().generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			v.addAll(new PropertyModifiersProposal()
					.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		// DEFAULT_VALUE: property modifiers
		case IContext.DEFAULT_VALUE:
			v.addAll(new PropertyModifiersProposal()
					.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		case IContext.PROPERTY_MODIFIERS:
			v.addAll(modifierProposalComputer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		case IContext.PROPERTY_MODIFIER:
			v.addAll(modifierProposalComputer.generateCompletionProposals(documentOffset, selectionRange, prefix));
			break;

		case IContext.SUBSET_PROPERTY:
			v.addAll(new PropertySubsetsProposal(property).generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			break;

		case IContext.REDEFINE_PROPERTY:
			v.addAll(new PropertyRedefineProposal(property).generateCompletionProposals(documentOffset, selectionRange,
					prefix));
			break;
		default:
			break;

		}

		return v;
	}
}