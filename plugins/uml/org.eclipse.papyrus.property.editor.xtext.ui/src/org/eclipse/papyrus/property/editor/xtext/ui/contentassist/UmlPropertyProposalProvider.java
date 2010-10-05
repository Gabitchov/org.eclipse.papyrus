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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider;
import org.eclipse.papyrus.property.editor.xtext.ui.contributions.UMLPropertyEditorPropertyUtil;
import org.eclipse.papyrus.property.editor.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package ;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlPropertyProposalProvider extends AbstractUmlPropertyProposalProvider {

	private ILabelProvider labelProvider = DisplayUtils.getLabelProvider() ;
	
	/* *************************************************
	 * 
	 * Private Utility method for creating a completion proposal
	 * 
	 **************************************************/
	
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

	@Override
	public void completePropertyRule_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Namespace root = UmlPropertyJavaValidator.getModel() ;
		
		if (root == null)
			return ;
		
		// first retrieve all types directly or indirectly owned by the root
		List<Classifier> allAccessibleClassifiers = new ArrayList<Classifier>() ;
		
		allAccessibleClassifiers.addAll(getRecursivelyOwnedClassifiers(root)) ;
		allAccessibleClassifiers.addAll(getRecursivelyImportedClassifiers(root)) ;
		
		Map<Classifier, String> stringProposals = new HashMap<Classifier, String>() ;
		
		for (Classifier c : allAccessibleClassifiers) {
			stringProposals.put(c, UMLPropertyEditorPropertyUtil.getTypeLabel(c)) ;
		}

		for (Classifier c : allAccessibleClassifiers) {
			if (stringProposals.get(c).startsWith(context.getPrefix())) {
				String completionString = stringProposals.get(c).substring(context.getPrefix().length()) ;
				String displayString = stringProposals.get(c) ;
				//String displayString = c.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(c, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
		
	}

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
	
	private List<Classifier> getRecursivelyImportedClassifiers(Namespace context) {
		List<Classifier> recursivelyImportedClassifiers = new ArrayList<Classifier>() ;
		
		List<Package> importedPackages = context.getImportedPackages() ;
		for (Package p : importedPackages) {
			recursivelyImportedClassifiers.addAll(getRecursivelyOwnedClassifiers(p)) ;
		}
		
		return recursivelyImportedClassifiers ;
	}
	
}
