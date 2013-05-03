/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.alf.ui.contentassist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.contentassist.CompletionProposalUtils;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
import org.eclipse.papyrus.uml.alf.scoping.AlfPartialScope;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.uml.alf.validation.typing.ErrorTypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.SignatureFacadeFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class AlfProposalProvider extends AbstractAlfProposalProvider {
	
	
	@Override
	public void completeLocalNameDeclarationStatement_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		AlfPartialScope scope = AlfScopeProvider.scopingTool.getVisibleClassifiers(model) ;
		new AlfCompletionProposalUtils().classifierProposals(scope, context, acceptor) ;
		super.completeLocalNameDeclarationStatement_Type(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeOperationCallExpression_OperationName(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		TypeExpression typeOfModel = null ;
		if (model instanceof SuffixExpression) {
			if (context.getPrefix().equals(""))
				typeOfModel = new TypeUtils().getTypeOfCandidateExpression(model) ;
			else
				typeOfModel = new TypeUtils((SuffixExpression)model).getTypeOfCandidateExpression(model.eContainer()) ;
		}
		else {
			typeOfModel = new TypeUtils().getTypeOfCandidateExpression(model) ;
		}
		if (typeOfModel == null || typeOfModel.getTypeFacade() instanceof ErrorTypeFacade)
			super.completeOperationCallExpression_OperationName(model, assignment, context,
				acceptor);
		else {
			new AlfCompletionProposalUtils().operationProposals(typeOfModel.getTypeFacade(), context, acceptor) ;
			super.completeOperationCallExpression_OperationName(model, assignment, context,	acceptor);
		}
	}
	

	@Override
	public void completePropertyCallExpression_PropertyName(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		TypeExpression typeOfModel = null ;
		if (model instanceof SuffixExpression) {
			if (context.getPrefix().equals(""))
				typeOfModel = new TypeUtils().getTypeOfCandidateExpression(model) ;
			else
				typeOfModel = new TypeUtils((SuffixExpression)model).getTypeOfCandidateExpression(model.eContainer()) ;
		}
		else {
			typeOfModel = new TypeUtils().getTypeOfCandidateExpression(model) ;
		}
		if (typeOfModel == null || typeOfModel.getTypeFacade() instanceof ErrorTypeFacade)
			super.completePropertyCallExpression_PropertyName(model, assignment, context,
				acceptor);
		else {
			new AlfCompletionProposalUtils().propertyProposals(typeOfModel.getTypeFacade(), context, acceptor) ;
			super.completePropertyCallExpression_PropertyName(model, assignment, context, acceptor);
		}
	}

	
	/**************************
	 * 
	 * Completion proposal utils
	 *
	 */
	private class AlfCompletionProposalUtils {
		
		public void classifierProposals(AlfPartialScope scope, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			for (List<EObject> scopingLevel : scope.getScopeDetails()) {
				String completionString = "" ;
				String displayString = "" ;
				Map<String, ICompletionProposal> completionProposals = new HashMap<String, ICompletionProposal>() ;
				ICompletionProposal proposal = null ;
				for (EObject visibleClassifier : scopingLevel) {					
					completionString = scope.getElementName(visibleClassifier) ;
					displayString = "" + completionString ;
					if (completionString.startsWith(context.getPrefix())) {
						completionString = completionString.substring(context.getPrefix().length()) ;
						if (completionProposals.get(displayString)==null) {
							completionProposals.put(displayString, proposal) ;
							proposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
							acceptor.accept(proposal) ;
						}
					}
				}
			}
		}
		
		public void operationProposals(TypeFacade f, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			Classifier c = f.extractActualType() ;
			String completionString = "" ;
			String displayString = "" ;
			Map<String, ICompletionProposal> completionProposals = new HashMap<String, ICompletionProposal>() ;
			ICompletionProposal proposal = null ;
			for (Operation o : c.getAllOperations()) {
				completionString = SignatureFacadeFactory.eInstance.createSignatureFacade(o).getLabel() ;
				displayString = "" + completionString ;
				if (completionString.startsWith(context.getPrefix())) {
					completionString = completionString.substring(context.getPrefix().length()) ;
					if (completionProposals.get(displayString)==null) {
						completionProposals.put(displayString, proposal) ;
						proposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
						acceptor.accept(proposal) ;
					}
				}
			}
		}
		
		public void propertyProposals(TypeFacade f, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			Classifier c = f.extractActualType() ;
			String completionString = "" ;
			String displayString = "" ;
			Map<String, ICompletionProposal> completionProposals = new HashMap<String, ICompletionProposal>() ;
			ICompletionProposal proposal = null ;
			for (Property p : c.getAllAttributes()) {
				displayString = p.getName() + " : " + (p.getType() == null ? "any" : p.getType().getName()) ;
				completionString = p.getName() ;
				if (completionString.startsWith(context.getPrefix())) {
					completionString = completionString.substring(context.getPrefix().length()) ;
					if (completionProposals.get(displayString)==null) {
						completionProposals.put(displayString, proposal) ;
						proposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
						acceptor.accept(proposal) ;
					}
				}
			}
		}
	}
	
}
