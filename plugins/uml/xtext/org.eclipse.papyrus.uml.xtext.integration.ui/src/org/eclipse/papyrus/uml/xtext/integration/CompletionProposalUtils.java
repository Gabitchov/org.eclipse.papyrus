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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.utils.DisplayUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * @author CEA LIST - Initial contribution and API
 */
public class CompletionProposalUtils {

	protected final static ILabelProvider labelProvider = DisplayUtils.getLabelProvider() ;
	
	/**
	 * Public Utility method for creating a completion proposal
	 * 
	 * @param namedElement The named element for which completion proposal must be created
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return completion proposal
	 */
	public static CustomCompletionProposal createCompletionProposal(NamedElement namedElement, 
														String completionString, 
														String displayString, 
														ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')' ;
		
		CustomCompletionProposal completionProposal = new CustomCompletionProposal(completionString, 	// String to be inserted 
				context.getOffset(),  							// Offset
				context.getSelectedText().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				labelProvider.getImage(namedElement)	,	// image
				" " + displayString,									// displayString
				null							,				// contextInformation
				additionalProposalInfo,							// additionalProposalInfo
				context);
		return completionProposal ;
	}
	
	/**
	 * Public Utility method for creating a completion proposal with replacement of prefix
	 * 
	 * @param namedElement The named element for which completion proposal must be created
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return completion proposal
	 */
	public static CustomCompletionProposal createCompletionProposalWithReplacementOfPrefix(NamedElement namedElement, 
														String completionString, 
														String displayString, 
														ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')' ;
		
		CustomCompletionProposal completionProposal = new CustomCompletionProposal(completionString, 	// String to be inserted 
				context.getOffset() - context.getPrefix().length(),  							// Offset
				context.getPrefix().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				labelProvider.getImage(namedElement)	,	// image
				" " + displayString,									// displayString
				null							,				// contextInformation
				additionalProposalInfo,							// additionalProposalInfo
				context);
		return completionProposal ;
	}
	
	/**
	 * Public Utility method for creating a completion proposal
	 * 
	 * @param completionString The actual completion string
	 * @param displayString The way the completion is displayed in the completion list
	 * @param context Some information related to the context of the completion
	 * @return completion proposal
	 */
	public static CustomCompletionProposal createCompletionProposal(String completionString, 
														String displayString, 
														ContentAssistContext context) {
		
		CustomCompletionProposal completionProposal = new CustomCompletionProposal(completionString, 	// String to be inserted 
				context.getOffset(),  							// Offset
				context.getSelectedText().length(),				// Replacement length
				completionString.length(),						// cursorPosition
				null	,										// image
				" " + displayString,							// displayString
				null							,				// contextInformation
				null,											// additionalProposalInfo
				context);
		return completionProposal ;
	}
	
	/**
	 * Public utility method that computes a qualified name, taking into account packages imported by the namespace model
	 * 
	 * @param namedElement 
	 * @param model 
	 * @return the qualified name label
	 */
	public static String getQualifiedNameLabelWithSufficientDepth(NamedElement namedElement, Namespace model) {
		String label = "" ;
		
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages()) ;
		
		List<Namespace> visitedNamespaces = new ArrayList<Namespace>() ;
		Namespace currentNamespace = namedElement.getNamespace() ;
		
		boolean rootFound = false ;
		boolean modelIsTheRoot = false ;
		
		while (currentNamespace != null && !rootFound) {
			visitedNamespaces.add(currentNamespace) ;
			if (importedPackages.contains(currentNamespace) || currentNamespace == model) {
				rootFound = true ;
				if (currentNamespace == model)
					modelIsTheRoot = true ;
			}
			Element owner = currentNamespace.getOwner() ;
			while (owner != null && !(owner instanceof Namespace))
				owner = owner.getOwner() ;
			
			currentNamespace = owner != null ? (Namespace)owner : null ;
		}
		
		for (int i = visitedNamespaces.size() - 1 - (modelIsTheRoot ? 1 : 0) ; i >= 0 ; i--) {
			label += visitedNamespaces.get(i).getName() + "::" ; 
		}
		
		return label + namedElement.getName() ;
	}
	
}
