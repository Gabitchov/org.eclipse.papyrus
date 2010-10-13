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
package org.eclipse.papyrus.property.editor.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider;
import org.eclipse.papyrus.property.editor.xtext.ui.contributions.UMLPropertyEditorPropertyUtil;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.property.editor.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package ;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;


/**
 * Customization of the default ProposalProvider of the textual property editor
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */

public class UmlPropertyProposalProvider extends AbstractUmlPropertyProposalProvider {

	private ILabelProvider labelProvider = DisplayUtils.getLabelProvider() ;
	
	/** 
	 * Provides custom completion for the specifying the type of a property
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completePropertyRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completePropertyRule_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// the customization consists in proposing nothing. Proposals are handled by other methods.
		List<Classifier> allClassifiers = new ArrayList<Classifier>() ;
		allClassifiers.addAll(getRecursivelyOwnedClassifiers(UmlPropertyJavaValidator.getModel())) ;
		allClassifiers.addAll(getRecursivelyImportedClassifiers(UmlPropertyJavaValidator.getModel())) ;
		for (Classifier c : allClassifiers) {
			if (c.getName().contains(context.getPrefix())) {
				String displayString = c.getQualifiedName() ;
				String completionString = UMLPropertyEditorPropertyUtil.getTypeLabel(c) ;
				ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(c, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}

	/**
	 * Provides custom completion for the root element in a qualified name
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Path(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		Namespace root = UmlPropertyJavaValidator.getModel() ;
		
		if (root == null)
			return ;
		
		// first accept the root Model
		String completionString = root.getName() + "::";
		String displayString = root.getName() + "::";
		//String displayString = c.getName() ;
		ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(root, completionString, displayString, context) ;
		acceptor.accept(completionProposal) ;
		
		// then accepts all packages imported by Model
		List<Package> importedPackages = root.getImportedPackages() ;
		for (Package p : importedPackages) {
			if (p.getName().startsWith(context.getPrefix())) {
				completionString = p.getName().substring(context.getPrefix().length()) + "::";
				displayString = p.getName() + "::";
				//String displayString = c.getName() ;
				completionProposal = createCompletionProposal(root, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
		
	}

	/** 
	 * Provides custom completion for specifying the type of a property, taking into account the path if the name is qualified
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
			
		Package namespace = UmlPropertyJavaValidator.getContextElement().getNearestPackage() ;
		if (model instanceof TypeRule) {
			TypeRule typeRule = (TypeRule)model ;
			QualifiedName path = typeRule.getPath() ;
			while (path.getRemaining() != null) {
				path = path.getRemaining() ;
			}
			namespace = (Package)path.getPath() ;
		}
		else if (! (model instanceof PropertyRule))
			return ;
		for (NamedElement n : namespace.getOwnedMembers()) {
			if (n instanceof Classifier) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length()) ;
					String displayString = n.getName() ;
					//String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
		
		//super.completeTypeRule_Type(model, assignment, context, acceptor) ;
	}

	
	
	/**
	 * Provides custom completion for a path in a qualified name
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Path(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		//The customization consists in proposing nothing. Proposals are already handled by other methods
	}

	/**
	 * Provides custom completion for a path, taking into account the path which has already been specified
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeQualifiedName_Remaining(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeQualifiedName_Remaining(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		QualifiedName path = (QualifiedName) model ;
		for (NamedElement n : path.getPath().getOwnedMembers()) {
			if (n instanceof Package) {
				if (n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length()) + "::";
					String displayString = n.getName() + "::";
					//String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
		for (Package p : path.getPath().getImportedPackages()) {
			if (p.getName().startsWith(context.getPrefix())) {
				String completionString = p.getName().substring(context.getPrefix().length()) + "::";
				String displayString = p.getName() + "::";
				//String displayString = c.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(p, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	
	
	/**
	 * Provides custom completion for keywords, in the context of "modifiers" specification
	 * 
	 * @see org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider#completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		EObject model = contentAssistContext.getCurrentModel() ;
		if (! (model instanceof ModifiersRule)) {
			super.completeKeyword(keyword, contentAssistContext, acceptor);
			return ;
		}
		ModifiersRule modifiersRule = (ModifiersRule)model ;
		boolean isOrdered = false ;
		boolean isReadOnly = true ;
		boolean isUnion = false ;
		boolean isUnique = false ;
		for (ModifierSpecification spec : modifiersRule.getValues()) {
			if (spec.getValue() != null) {
				switch (spec.getValue()) {
				case ORDERED:
					isOrdered = true ;
					break;
				case READ_ONLY:
					isReadOnly = ! isReadOnly ;
					break;
				case UNION:
					isUnion = true ;
					break ;
				case UNIQUE:
					isUnique = true ;
					break ;
				default:
					break;
				}
			}
		}
		String value = keyword.getValue() ;
		if (value.equals("ordered")) {
			if (!isOrdered)
				super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
		else if (value.equals("readOnly")) {
			if (!isReadOnly)
				super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
		else if (value.equals("unique")) {
			if (!isUnique)
				super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
		else if (value.equals("union")) {
			if (!isUnion)
				super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
		else
			super.completeKeyword(keyword, contentAssistContext, acceptor);
	}
	
	@Override
	public void complete_MultiplicityRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		String one = "[1]" ;
		String one_star = "[1..*]" ;
		String star = "[*]" ;
		
		String prefix = context.getPrefix() ;
		
		String completionString = "" ;
		String displayString = "";
		//String displayString = c.getName() ;
		ICompletionProposal completionProposal = null ;
		
		completionString = "" + one.substring(context.getPrefix().length()) ;
		displayString = "" + one ;
		completionProposal = createCompletionProposal(completionString, displayString, context) ;
		acceptor.accept(completionProposal) ;
		
		completionString = "" + one_star.substring(context.getPrefix().length()) ;
		displayString = "" + one_star + "     ";
		completionProposal = createCompletionProposal(completionString, displayString, context) ;
		acceptor.accept(completionProposal) ;
		
		completionString = "" + star.substring(context.getPrefix().length()) ;
		displayString = "" + star ;
		completionProposal = createCompletionProposal(completionString, displayString, context) ;
		acceptor.accept(completionProposal) ;
	}
	
	@Override
	public void completeMultiplicityRule_Bounds(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		
		if (!(model instanceof MultiplicityRule))
			return ;
		
		MultiplicityRule multiplicityRule = (MultiplicityRule)model ;
		
		if (multiplicityRule.getBounds().size() == 2) {
			String value = multiplicityRule.getBounds().get(1).getValue() ;
			try {	
				Integer.valueOf(value) ;
			}
			catch(Exception e) {
				if (! multiplicityRule.getBounds().get(0).getValue().equals("*") && ! multiplicityRule.getBounds().get(1).getValue().equals("*")) {
					String completionString = "*" ;
					String displayString = "*";
					ICompletionProposal completionProposal = createCompletionProposal(completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
	}
	
	/* ******************************************************************************
	 * Utility methods
	 ********************************************************************************/

	/**
	 * Private Utility method for creating a completion proposal
	 * 
	 * @param namedElement The named element for which completion proposal must be created
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposal(NamedElement namedElement, 
														String completionString, 
														String displayString, 
														ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')' ;
		
		ICompletionProposal completionProposal = new CompletionProposal(completionString, 	// String to be inserted 
				context.getOffset(),  							// Offset
				context.getSelectedText().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				labelProvider.getImage(namedElement)	,	// image
				" " + displayString,									// displayString
				null							,				// contextInformation
				additionalProposalInfo							// additionalProposalInfo
				);
		return completionProposal ;
	}
	
	/**
	 * Private Utility method for creating a completion proposal with replacement of prefix
	 * 
	 * @param namedElement The named element for which completion proposal must be created
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposalWithReplacementOfPrefix(NamedElement namedElement, 
														String completionString, 
														String displayString, 
														ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')' ;
		
		ICompletionProposal completionProposal = new CompletionProposal(completionString, 	// String to be inserted 
				context.getOffset() - context.getPrefix().length(),  							// Offset
				context.getPrefix().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				labelProvider.getImage(namedElement)	,	// image
				" " + displayString,									// displayString
				null							,				// contextInformation
				additionalProposalInfo							// additionalProposalInfo
				);
		return completionProposal ;
	}
	
	/**
	 * Private Utility method for creating a completion proposal
	 * 
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return
	 */
	protected ICompletionProposal createCompletionProposal(String completionString, 
														String displayString, 
														ContentAssistContext context) {
		
		ICompletionProposal completionProposal = new CompletionProposal(completionString, 	// String to be inserted 
				context.getOffset(),  							// Offset
				context.getSelectedText().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				null	,										// image
				" " + displayString,							// displayString
				null							,				// contextInformation
				null											// additionalProposalInfo
				);
		return completionProposal ;
	}
	
	/**
	 * Utility methods wich returns the list of classifiers that are directly or indirectly owned by a context namespace
	 * 
	 * @param context The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the context namespace
	 */
	private List<Classifier> getRecursivelyOwnedClassifiers(Namespace context) {
		List<Classifier> recursivelyOwnedClassifiers = new ArrayList<Classifier>();
		
		List<Element> allOwnedElements = context.getOwnedElements() ;
		for (Element e : allOwnedElements) {
			if (e instanceof Classifier)
				recursivelyOwnedClassifiers.add((Classifier)e) ;
			else if (e instanceof Package)
				recursivelyOwnedClassifiers.addAll(getRecursivelyOwnedClassifiers((Package)e)) ;
		}
		
		return recursivelyOwnedClassifiers ;
	}
	
	/**
	 * Utility methods which returns the list of classifiers that are directly or indirectly owned by the namespaces imported by a context namespace
	 * 
	 * @param context The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the namespaces imported by the context namespace
	 */
	private List<Classifier> getRecursivelyImportedClassifiers(Namespace context) {
		List<Classifier> recursivelyImportedClassifiers = new ArrayList<Classifier>() ;
		
		List<Package> importedPackages = context.getImportedPackages() ;
		for (Package p : importedPackages) {
			recursivelyImportedClassifiers.addAll(getRecursivelyOwnedClassifiers(p)) ;
		}
		
		return recursivelyImportedClassifiers ;
	}
	
}
