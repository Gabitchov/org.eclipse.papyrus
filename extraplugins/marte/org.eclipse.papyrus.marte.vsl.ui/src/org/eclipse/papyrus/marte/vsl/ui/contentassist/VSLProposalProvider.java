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
package org.eclipse.papyrus.marte.vsl.ui.contentassist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.contentassist.CompletionProposalUtils;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.scoping.VSLScopeProvider;
import org.eclipse.papyrus.marte.vsl.scoping.visitors.ScopingVisitors;
import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsName;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.VSLValidationResult;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class VSLProposalProvider extends AbstractVSLProposalProvider {

	@Override
	public void completeExpression_Exp(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeAndOrXorExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		if (model instanceof AndOrXorExpression) {
			AndOrXorExpression exp = (AndOrXorExpression)model ;
			List<EqualityExpression> nestedExpressions = exp.getExp() ;
			if (nestedExpressions.size() >= 2) {
				VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkEqualityExpression(nestedExpressions.get(nestedExpressions.size()-2)) ;
				Classifier specifiedType = (Classifier)validationResult.inferedType() ;
				String operator = exp.getOp().get(nestedExpressions.size()-2) ;
				if (VSLJavaValidator.binaryOpTypeBinding.get(operator) != null && VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType) != null) {
					for (Type possibleType : VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType)) {
						Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)possibleType) ;
						for (String s : allProposals.keySet()) {
							if (s.startsWith(context.getPrefix())) {
								String completionString ;
								String displayString ;
								ICompletionProposal completionProposal = null ;
								if (allProposals.get(s) == null) {
									completionString = s.substring(context.getPrefix().length()) ;
									displayString = s ;
									completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
								}
								else {
									if (! s.contains("|")) {
										completionString = s ;
										displayString = s ;
									}
									else {
										completionString = s.substring(0, s.indexOf("|")) ;
										displayString = s.substring(s.indexOf("|") + 1) ;
									}
									completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
								}
								acceptor.accept(completionProposal) ;
							}
						}
					}
				}
			}
		}
		else
			super.completeAndOrXorExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeAndOrXorExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeAndOrXorExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeEqualityExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EqualityExpression) {
			EqualityExpression exp = (EqualityExpression)model ;
			List<RelationalExpression> nestedExpressions = exp.getExp() ;
			if (nestedExpressions.size() >= 2) {
				VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkRelationalExpression(nestedExpressions.get(nestedExpressions.size()-2)) ;
				Classifier specifiedType = (Classifier)validationResult.inferedType() ;
				String operator = exp.getOp().get(nestedExpressions.size()-2) ;
				if (VSLJavaValidator.binaryOpTypeBinding.get(operator) != null && VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType) != null) {
					for (Type possibleType : VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType)) {
						Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)possibleType) ;
						for (String s : allProposals.keySet()) {
							if (s.startsWith(context.getPrefix())) {
								String completionString ;
								String displayString ;
								ICompletionProposal completionProposal = null ;
								if (allProposals.get(s) == null) {
									completionString = s.substring(context.getPrefix().length()) ;
									displayString = s ;
									completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
								}
								else {
									if (! s.contains("|")) {
										completionString = s ;
										displayString = s ;
									}
									else {
										completionString = s.substring(0, s.indexOf("|")) ;
										displayString = s.substring(s.indexOf("|") + 1) ;
									}
									completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
								}
								acceptor.accept(completionProposal) ;
							}
						}
					}
				}
			}
		}
		else
			super.completeEqualityExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeEqualityExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeEqualityExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeRelationalExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof RelationalExpression) {
			RelationalExpression exp = (RelationalExpression)model ;
			List<ConditionalExpression> nestedExpressions = exp.getExp() ;
			if (nestedExpressions.size() >= 2) {
				VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkConditionalExpression(nestedExpressions.get(nestedExpressions.size()-2)) ;
				Classifier specifiedType = (Classifier)validationResult.inferedType() ;
				String operator = exp.getOp().get(nestedExpressions.size()-2) ;
				if (VSLJavaValidator.binaryOpTypeBinding.get(operator) != null && VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType) != null) {
					for (Type possibleType : VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType)) {
						Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)possibleType) ;
						for (String s : allProposals.keySet()) {
							if (s.startsWith(context.getPrefix())) {
								String completionString ;
								String displayString ;
								ICompletionProposal completionProposal = null ;
								if (allProposals.get(s) == null) {
									completionString = s.substring(context.getPrefix().length()) ;
									displayString = s ;
									completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
								}
								else {
									if (! s.contains("|")) {
										completionString = s ;
										displayString = s ;
									}
									else {
										completionString = s.substring(0, s.indexOf("|")) ;
										displayString = s.substring(s.indexOf("|") + 1) ;
									}
									completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
								}
								acceptor.accept(completionProposal) ;
							}
						}
					}
				}
			}	
		}
		else 
			super.completeRelationalExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeRelationalExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeRelationalExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeConditionalExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeConditionalExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeConditionalExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeConditionalExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeAdditiveExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AdditiveExpression) {
			AdditiveExpression exp = (AdditiveExpression)model ;
			List<MultiplicativeExpression> nestedExpressions = exp.getExp() ;
			if (nestedExpressions.size() >= 2) {
				VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkMultiplicativeExpression(nestedExpressions.get(nestedExpressions.size()-2)) ;
				Classifier specifiedType = (Classifier)validationResult.inferedType() ;
				String operator = exp.getOp().get(nestedExpressions.size()-2) ;
				if (VSLJavaValidator.binaryOpTypeBinding.get(operator) != null && VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType) != null) {
					for (Type possibleType : VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType)) {
						Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)possibleType) ;
						for (String s : allProposals.keySet()) {
							if (s.startsWith(context.getPrefix())) {
								String completionString ;
								String displayString ;
								ICompletionProposal completionProposal = null ;
								if (allProposals.get(s) == null) {
									completionString = s.substring(context.getPrefix().length()) ;
									displayString = s ;
									completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
								}
								else {
									if (! s.contains("|")) {
										completionString = s ;
										displayString = s ;
									}
									else {
										completionString = s.substring(0, s.indexOf("|")) ;
										displayString = s.substring(s.indexOf("|") + 1) ;
									}
									completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? ((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null : null, completionString, displayString, context) ;
								}
								acceptor.accept(completionProposal) ;
							}
						}
					}
				}
			}
		}
		else
			super.completeAdditiveExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeAdditiveExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeAdditiveExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeMultiplicativeExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof MultiplicativeExpression) {
			MultiplicativeExpression exp = (MultiplicativeExpression)model ;
			List<UnaryExpression> nestedExpressions = exp.getExp() ;
			if (nestedExpressions.size() >= 1) {
				VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkUnaryExpression(nestedExpressions.get(nestedExpressions.size()-1)) ;
				Classifier specifiedType = (Classifier)validationResult.inferedType() ;
				String operator = exp.getOp().get(exp.getOp().size() == 0 ? 0 : nestedExpressions.size()-1) ;
				for (Type possibleType : VSLJavaValidator.binaryOpTypeBinding.get(operator).get(specifiedType)) {
					Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)possibleType) ;
					for (String s : allProposals.keySet()) {
						if (s.startsWith(context.getPrefix())) {
							String completionString ;
							String displayString ;
							ICompletionProposal completionProposal = null ;
							if (allProposals.get(s) == null) {
								completionString = s.substring(context.getPrefix().length()) ;
								displayString = s ;
								completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
							}
							else {
								if (! s.contains("|")) {
									completionString = s ;
									displayString = s ;
								}
								else {
									completionString = s.substring(0, s.indexOf("|")) ;
									displayString = s.substring(s.indexOf("|") + 1) ;
								}
								completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
							}
							acceptor.accept(completionProposal) ;
						}
					}
				}
			}
		}
		else
			super.completeMultiplicativeExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completeMultiplicativeExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeMultiplicativeExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeUnaryExpression_Op(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeUnaryExpression_Op(model, assignment, context, acceptor);
	}

	@Override
	public void completeUnaryExpression_Unary(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeUnaryExpression_Unary(model, assignment, context, acceptor);
	}

	@Override
	public void completeUnaryExpression_Exp(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeUnaryExpression_Exp(model, assignment, context, acceptor);
	}

	@Override
	public void completePrimaryExpression_Prefix(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completePrimaryExpression_Prefix(model, assignment, context, acceptor);
	}

	@Override
	public void completePrimaryExpression_Suffix(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completePrimaryExpression_Suffix(model, assignment, context, acceptor);
	}

	@Override
	public void completePropertyCallExpression_Property(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Classifier classifierForScoping ;
		if (model instanceof PrimaryExpression) {
			classifierForScoping = VSLScopeProvider.eInstance.new ScopingHelper(((PrimaryExpression)model).getPrefix()).getClassifierForScoping() ;
		}
		else {
			classifierForScoping = VSLScopeProvider.eInstance.new ScopingHelper(model).getClassifierForScoping() ;
		}
		List<Property> allProperties = new ArrayList<Property>() ;
		if (classifierForScoping != null) {
			for (Feature f : classifierForScoping.allFeatures()) {
				if (f instanceof Property)
					allProperties.add((Property)f) ;
			}
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(allProperties) ;	
		IScope scope = new SimpleScope(iterableIEobjectDescription) ;
		for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
			if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String displayString = eobjectDescription.getName() + " : " + (((Property)eobjectDescription.getEObjectOrProxy()).getType() != null ? ((Property)eobjectDescription.getEObjectOrProxy()).getType().getName() : "<Undefined>") ;
				String completionString = eobjectDescription.getName().getLastSegment() ;
				ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}

	@Override
	public void completePropertyCallExpression_Suffix(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completePropertyCallExpression_Suffix(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeOperationCallExpression_Operation(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Classifier classifierForScoping ;
		if (model instanceof PrimaryExpression) {
			classifierForScoping = VSLScopeProvider.eInstance.new ScopingHelper(((PrimaryExpression)model).getPrefix()).getClassifierForScoping() ;
		}
		else {
			classifierForScoping = VSLScopeProvider.eInstance.new ScopingHelper(model).getClassifierForScoping() ;
		}
		List<Operation> allOperations = new ArrayList<Operation>() ;
		if (classifierForScoping != null) {
			for (Feature f : classifierForScoping.allFeatures()) {
				if (f instanceof Operation) {
					Operation o = (Operation)f ;
					if (o.getType() != null &&
						!(o.getName().equals("<")
						  || o.getName().equals(">")
						  || o.getName().equals("<=")
						  || o.getName().equals(">=")
						  || o.getName().equals("==")
						  || o.getName().equals("<>")
						  || o.getName().equals("+")
						  || o.getName().equals("-")
						  || o.getName().equals("*")
						  || o.getName().equals("/")
						  || o.getName().equals("^"))) {
						allOperations.add(o) ;
					}
				}
			}
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(allOperations) ;	
		IScope scope = new SimpleScope(iterableIEobjectDescription) ;
		for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
			if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				Operation calledOperation = (Operation)eobjectDescription.getEObjectOrProxy() ;
				String displayString = VSLProposalUtils.buildDisplayStringForOperationCall(calledOperation) ;
				String completionString = VSLProposalUtils.buildCompletionStringForOperationCall(calledOperation) ;
				ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}

	@Override
	public void completeOperationCallExpression_Arguments(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		if (! (model instanceof OperationCallExpression))
			return ;
		
		Operation calledOperation = ((OperationCallExpression)model).getOperation() ;
		if (calledOperation != null) {
			Parameter firstParameter = null ;
			Iterator<Parameter> allParameters = calledOperation.getOwnedParameters().iterator() ;
			while (allParameters.hasNext() && firstParameter == null) {
				Parameter currentParam = allParameters.next() ;
				if (currentParam.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
					firstParameter = currentParam ;
			}
			if (firstParameter != null) {
				Classifier expectedType = (Classifier)firstParameter.getType() ;
				Map<String, Element> allProposals = VSLProposalUtils.buildProposalForType(expectedType) ;
				for (String s : allProposals.keySet()) {
					if (s.startsWith(context.getPrefix())) {
						String completionString ;
						String displayString ;
						ICompletionProposal completionProposal = null ;
						if (allProposals.get(s) == null) {
							completionString = s.substring(context.getPrefix().length()) ;
							displayString = s ;
							completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
						}
						else {
							if (! s.contains("|")) {
								completionString = s ;
								displayString = s ;
							}
							else {
								completionString = s.substring(0, s.indexOf("|")) ;
								displayString = s.substring(s.indexOf("|") + 1) ;
							}
							completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
						}
						acceptor.accept(completionProposal) ;
					}
				}
			}
		}
	}

	@Override
	public void completeOperationCallExpression_Suffix(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeOperationCallExpression_Suffix(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeNameOrChoiceOrBehaviorCall_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeNameOrChoiceOrBehaviorCall_Path(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeNameOrChoiceOrBehaviorCall_Id(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof NameOrChoiceOrBehaviorCall  && ((NameOrChoiceOrBehaviorCall)model).getPath() != null) {
			IScope scope = VSLScopeProvider.eInstance.scope_NameOrChoiceOrBehaviorCall_id((NameOrChoiceOrBehaviorCall)model, VSLPackage.eINSTANCE.getNameOrChoiceOrBehaviorCall_Id()) ;
			for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
				if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					boolean goOn = true;
					if (eobjectDescription.getEObjectOrProxy() instanceof Behavior) {
						Behavior behavior = (Behavior)eobjectDescription.getEObjectOrProxy() ;
						boolean behaviorHasAReturnType = false ;
						for (Parameter p : behavior.getOwnedParameters()) {
							if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
								behaviorHasAReturnType = true ;
						}
						goOn = behaviorHasAReturnType ;
					}
					if (goOn) {
						String displayString = eobjectDescription.getName().getLastSegment() ;
						String completionString = eobjectDescription.getName().getLastSegment() ;
						if (eobjectDescription.getEObjectOrProxy() instanceof Behavior) {
							displayString = VSLProposalUtils.buildDisplayStringForBehaviorCall((Behavior)eobjectDescription.getEObjectOrProxy()) ;
							completionString = VSLProposalUtils.buildCompletionStringForBehaviorCall((Behavior)eobjectDescription.getEObjectOrProxy()) ;
						}
						ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
						acceptor.accept(completionProposal) ;
					}
				}
			}
		}
		else {
			// ignore. Already handled by other rules.
		}
	}

	@Override
	public void completeNameOrChoiceOrBehaviorCall_Arguments(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (! (model instanceof NameOrChoiceOrBehaviorCall))
			return ;
		
		NamedElement cddBehavior = ((NameOrChoiceOrBehaviorCall)model).getId() ;
		if (cddBehavior == null || !(cddBehavior instanceof Behavior))
			return ;
		Behavior calledBehavior = (Behavior)cddBehavior ;
		
		if (calledBehavior != null) {
			Parameter firstParameter = null ;
			Iterator<Parameter> allParameters = calledBehavior.getOwnedParameters().iterator() ;
			while (allParameters.hasNext() && firstParameter == null) {
				Parameter currentParam = allParameters.next() ;
				if (currentParam.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
					firstParameter = currentParam ;
			}
			if (firstParameter != null) {
				Classifier expectedType = (Classifier)firstParameter.getType() ;
				Map<String, Element> allProposals = VSLProposalUtils.buildProposalForType(expectedType) ;
				for (String s : allProposals.keySet()) {
					if (s.startsWith(context.getPrefix())) {
						String completionString ;
						String displayString ;
						ICompletionProposal completionProposal = null ;
						if (allProposals.get(s) == null) {
							completionString = s.substring(context.getPrefix().length()) ;
							displayString = s ;
							completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
						}
						else {
							if (! s.contains("|")) {
								completionString = s ;
								displayString = s ;
							}
							else {
								completionString = s.substring(0, s.indexOf("|")) ;
								displayString = s.substring(s.indexOf("|") + 1) ;
							}
							completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
						}
						acceptor.accept(completionProposal) ;
					}
				}
			}
		}
	}

	@Override
	public void completeQualifiedName_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// ignore. Treated by qualifiedName_Remaining, or the context rule.

	}

	@Override
	public void completeQualifiedName_Remaining(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof QualifiedName) {
			IScope scope = VSLScopeProvider.eInstance.scope_QualifiedName_remaining((QualifiedName)model, VSLPackage.eINSTANCE.getQualifiedName_Remaining()) ;
			for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
				if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					String displayString = eobjectDescription.getName() + "::";
					String completionString = eobjectDescription.getName() + "::";
					ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
		else {
			// ignore. Should already be treated by the context rule
		}
	}

	@Override
	public void completeInterval_IsLowerIncluded(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		//super.completeInterval_IsLowerIncluded(model, assignment, context, acceptor);
	}

	@Override
	public void completeInterval_Lower(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeInterval_Lower(model, assignment, context, acceptor);
	}

	@Override
	public void completeInterval_Upper(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeInterval_Upper(model, assignment, context, acceptor);
	}

	@Override
	public void completeInterval_IsUpperIncluded(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		//super.completeInterval_IsUpperIncluded(model, assignment, context, acceptor);
	}

	@Override
	public void completeCollectionOrTuple_ListOfValues(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeCollectionOrTuple_ListOfValues(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeTuple_ListOfValueNamePairs(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeTuple_ListOfValueNamePairs(model, assignment, context, acceptor);
	}

	@Override
	public void completeListOfValues_Values(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof OperationCallExpression || model instanceof NameOrChoiceOrBehaviorCall || model instanceof CollectionOrTuple)
			return ; // already treated by other cases
		
		INode node = context.getCurrentNode() ;
		IDocument document = context.getViewer().getDocument() ;
		char startChar = ' ' ;
		char openingListChar = ' ';
		int rule = -1 ; // 0 => OperationCall, 1 => BehaviorCall, 2 => CollectionOrTuple
		if (model.eContainer() instanceof OperationCallExpression) {
			startChar = '.' ;
			openingListChar = '(' ;
			rule = 0 ;
		}
		else if (model.eContainer() instanceof NameOrChoiceOrBehaviorCall) {
			startChar = ' ' ;
			openingListChar = '(' ;
			rule = 1 ;
		}
		else if (model.eContainer() instanceof CollectionOrTuple) {
			startChar = ' ' ;
			openingListChar = '{' ;
			rule = 2 ;
		}
		try {
			Classifier expectedType = null ;
			char[] completePrefix = document.get(0, node.getOffset()).toCharArray() ;
			boolean dotCallFound = false ;
			boolean openingListCharFound = false ;
			int i = completePrefix.length - 1 ;
			int positionInTheList = 0 ;
			int closingCharacters = 0 ;
			while (i > 0 && !dotCallFound) {
				char currentChar = completePrefix[i] ;
				if (currentChar == '(' || currentChar == '{') {
					if (closingCharacters != 0)
						closingCharacters-- ;
					else
						openingListCharFound = true ;
				}
				else if (currentChar == ')' || currentChar == '}')
					closingCharacters ++ ;
				else if (currentChar == ',') {
					//if ()
					if (closingCharacters == 0)
						positionInTheList ++ ;
				}
				else if (currentChar == startChar && openingListCharFound) {
					dotCallFound = true ;
				}
				i-- ;
			}
			if (openingListCharFound) {
				switch (rule) {
				case 0: // OperationCall
					OperationCallExpression callOp = (OperationCallExpression) model.eContainer() ;
					if (callOp.getOperation() == null || callOp.getOperation().getOwnedParameters() == null)
						return ;
					List<Parameter> operationParameters = new ArrayList<Parameter>() ;
					for (Parameter p : callOp.getOperation().getOwnedParameters()) {
						if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
							operationParameters.add(p) ;
					}
					if (positionInTheList < operationParameters.size()) {
						expectedType = (Classifier)operationParameters.get(positionInTheList).getType() ;
					}
					break;
				case 1: // BehaviorCall
					NameOrChoiceOrBehaviorCall callBehav = (NameOrChoiceOrBehaviorCall) model.eContainer() ;
					NamedElement cddBehavior = callBehav.getId() ;
					if (cddBehavior instanceof Behavior) {
						Behavior behavior = (Behavior)cddBehavior ;
						if (behavior.getOwnedParameters()== null)
							return ;
						List<Parameter> behaviorParameters = new ArrayList<Parameter>() ;
						for (Parameter p : behavior.getOwnedParameters()) {
							if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
								behaviorParameters.add(p) ;
						}
						if (positionInTheList < behaviorParameters.size()) {
							expectedType = (Classifier)behaviorParameters.get(positionInTheList).getType() ;
						}
					}
					break;
				case 2: // CollectionOrTuple
					// TODO
					break;
				default:
					break;
				}
				if (expectedType != null) {
					Map<String, Element> allProposals = VSLProposalUtils.buildProposalForType(expectedType) ;
					for (String s : allProposals.keySet()) {
						if (s.startsWith(context.getPrefix())) {
							String completionString ;
							String displayString ;
							ICompletionProposal completionProposal = null ;
							if (allProposals.get(s) == null) {
								completionString = s.substring(context.getPrefix().length()) ;
								displayString = s ;
								completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
							}
							else {
								if (! s.contains("|")) {
									completionString = s ;
									displayString = s ;
								}
								else {
									completionString = s.substring(0, s.indexOf("|")) ;
									displayString = s.substring(s.indexOf("|") + 1) ;
								}
								completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
							}
							acceptor.accept(completionProposal) ;
						}
					}
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace() ;
		}
		//super.completeListOfValues_Values(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeListOfValueNamePairs_ValueNamePairs(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeListOfValueNamePairs_ValueNamePairs(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeValueNamePair_Property(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// First retrieves all the properties available for the context type, in the case where the context type is a tuple or nfp type
		Classifier classifierForScoping = VSLScopeProvider.eInstance.new ScopingHelper(model).getClassifierForScoping() ;
		if (! VSLContextUtil.isATupleType(classifierForScoping))
			// TMP solution. Forces the classifier for scoping to be nfp_duration
			classifierForScoping = (Classifier)VSLJavaValidator._nfp_duration;
		List<Property> allProperties = new ArrayList<Property>() ;
		for (Feature f : classifierForScoping.allFeatures()) {
			if (f instanceof Property)
				allProperties.add((Property)f) ;
		}
		
		// Removes already specified properties from the context ListOfValueNamePairs
		List<Property> allReadySpecifiedProperties = new ArrayList<Property>() ;
		EObject cddContextListOfValueNamePairs = model ;
		if (cddContextListOfValueNamePairs instanceof Tuple) {
			cddContextListOfValueNamePairs = ((Tuple)cddContextListOfValueNamePairs).getListOfValueNamePairs() ;
		}
		while (cddContextListOfValueNamePairs != null && ! (cddContextListOfValueNamePairs instanceof ListOfValueNamePairs)) {
			cddContextListOfValueNamePairs = cddContextListOfValueNamePairs.eContainer() ;
		}
		if (cddContextListOfValueNamePairs != null) {
			ListOfValueNamePairs listOfValueNamePairs = (ListOfValueNamePairs)cddContextListOfValueNamePairs ;
			for (ValueNamePair valueNamePair : listOfValueNamePairs.getValueNamePairs()) {
				if (valueNamePair.getProperty() != null)
					allReadySpecifiedProperties.add(valueNamePair.getProperty()) ;
			}
		}
		allProperties.removeAll(allReadySpecifiedProperties) ;
		
		// Then builds the proposal list
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(allProperties) ;	
		IScope scope = new SimpleScope(iterableIEobjectDescription) ;
		for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
			if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String displayString = eobjectDescription.getName() + " = ";
				String completionString = eobjectDescription.getName() + " = ";
				ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
		//super.completeValueNamePair_Property(model, assignment, context, acceptor);
	}

	@Override
	public void completeValueNamePair_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model == null || !(model instanceof ValueNamePair))
			return ;
		ValueNamePair valueNamePairRuleRule = (ValueNamePair)model ;
		
		if (valueNamePairRuleRule.getProperty() == null || valueNamePairRuleRule.getProperty().getType() == null)
			return ;
		
		Property p = valueNamePairRuleRule.getProperty() ;
		
		Map<String,Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)p.getType()) ;
		for (String s : allProposals.keySet()) {
			if (s.startsWith(context.getPrefix())) {
				String completionString ;
				String displayString ;
				ICompletionProposal completionProposal = null ;
				if (allProposals.get(s) == null) {
					completionString = s.substring(context.getPrefix().length()) ;
					displayString = s ;
					completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context) ;
				}
				else {
					if (! s.contains("|")) {
						completionString = s ;
						displayString = s ;
					}
					else {
						completionString = s.substring(0, s.indexOf("|")) ;
						displayString = s.substring(s.indexOf("|") + 1) ;
					}
					completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(((allProposals.get(s) != null) && (allProposals.get(s) instanceof NamedElement)) ? (NamedElement)allProposals.get(s) : null, completionString, displayString, context) ;
				}
				acceptor.accept(completionProposal) ;
			}
		}
	}

	@Override
	public void completeInstantObsExpression_Id(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		for (Element e : ScopingVisitors.recursivelyownedAndImportedInstantObservations.visit(VSLJavaValidator.getModel())) {
			TimeObservation t = (TimeObservation)e ;
			if (t.getName().toLowerCase().contains((context.getPrefix().toLowerCase()))) {
				String displayString = t.getQualifiedName() ;
				String completionString = CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(t, VSLJavaValidator.getModel()) ;
				ICompletionProposal proposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(t, completionString, displayString, context) ;
				acceptor.accept(proposal) ;
			}
		}
	}

	@Override
	public void completeInstantObsExpression_Index(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeInstantObsExpression_Index(model, assignment, context, acceptor);
	}

	@Override
	public void completeInstantObsExpression_Condition(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeInstantObsExpression_Condition(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeInstantObsName_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// ignore. already treated by InstantObsExpression
	}

	@Override
	public void completeInstantObsName_InstantId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof InstantObsName) {
			IScope scope = VSLScopeProvider.eInstance.scope_InstantObsName_instantId((InstantObsName)model, VSLPackage.eINSTANCE.getInstantObsName_InstantId()) ;
			for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
				if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					String displayString = eobjectDescription.getName().getLastSegment() ;
					String completionString = eobjectDescription.getName().getLastSegment() ;
					ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
		else {
			// ignore. Already treated by rule InstantObsExpression_ID
		}
	}

	@Override
	public void completeDurationObsExpression_Id(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		for (Element e : ScopingVisitors.recursivelyownedAndImportedDurationObservations.visit(VSLJavaValidator.getModel())) {
			DurationObservation d = (DurationObservation)e ;
			if (d.getName().toLowerCase().contains((context.getPrefix().toLowerCase()))) {
				String displayString = d.getQualifiedName() ;
				String completionString = CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(d, VSLJavaValidator.getModel()) ;
				ICompletionProposal proposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(d, completionString, displayString, context) ;
				acceptor.accept(proposal) ;
			}
		}
	}

	@Override
	public void completeDurationObsExpression_Index(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeDurationObsExpression_Index(model, assignment, context, acceptor);
	}

	@Override
	public void completeDurationObsExpression_Condition(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeDurationObsExpression_Condition(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeDurationObsName_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeDurationObsName_Path(model, assignment, context, acceptor);
	}

	@Override
	public void completeDurationObsName_DurationId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof DurationObsName) {
			IScope scope = VSLScopeProvider.eInstance.scope_DurationObsName_durationId((DurationObsName)model, VSLPackage.eINSTANCE.getDurationObsName_DurationId()) ;
			for (IEObjectDescription eobjectDescription : scope.getAllElements()) {
				if (eobjectDescription.getName().getLastSegment().toLowerCase().contains(context.getPrefix().toLowerCase())) {
					String displayString = eobjectDescription.getName().getLastSegment() ;
					String completionString = eobjectDescription.getName().getLastSegment() ;
					ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)eobjectDescription.getEObjectOrProxy(), completionString, displayString, context) ;
					acceptor.accept(completionProposal) ;
				}
			}
		}
		else {
			// ignore. Already treated by rule DurationObsExpression_ID
		}
	}

	@Override
	public void completeJitterExp_FirstInstant(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (!context.getPrefix().equals("@")) {
			String displayString = "@" ;
			String completionString = "@" ;
			ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(null, completionString, displayString, context) ;
			acceptor.accept(completionProposal) ;
		}
	}

	@Override
	public void completeJitterExp_SecondInstant(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (!context.getPrefix().equals("@")) {
			String displayString = "@" ;
			String completionString = "@" ;
			ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(null, completionString, displayString, context) ;
			acceptor.accept(completionProposal) ;
		}
	}

	@Override
	public void completeVariableDeclaration_VariableDeclaration(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeVariableDeclaration_VariableDeclaration(model, assignment,
				context, acceptor);
	}

	@Override
	public void completeVariableDeclaration_Name(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeVariableDeclaration_Name(model, assignment, context, acceptor);
	}

	@Override
	public void completeVariableDeclaration_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeVariableDeclaration_Type(model, assignment, context, acceptor);
	}

	@Override
	public void completeVariableDeclaration_InitValue(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeVariableDeclaration_InitValue(model, assignment, context,
				acceptor);
	}

	@Override
	public void completeDataTypeName_Path(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeDataTypeName_Path(model, assignment, context, acceptor);
	}

	@Override
	public void completeDataTypeName_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeDataTypeName_Type(model, assignment, context, acceptor);
	}

	@Override
	public void completeIntegerLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeIntegerLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeUnlimitedLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeUnlimitedLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeRealLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeRealLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeDateTimeLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeDateTimeLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeBooleanLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeBooleanLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeNullLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeNullLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeDefaultLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeDefaultLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void completeStringLiteralRule_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.completeStringLiteralRule_Value(model, assignment, context, acceptor);
	}

	@Override
	public void complete_Expression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.complete_Expression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_AndOrXorExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.complete_AndOrXorExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_EqualityExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// Auto-generated method stub
		super.complete_EqualityExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RelationalExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_RelationalExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_ConditionalExpression(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_ConditionalExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_AdditiveExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_AdditiveExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_MultiplicativeExpression(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_MultiplicativeExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_UnaryExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_UnaryExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_PrimaryExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_PrimaryExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_ValueSpecification(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_ValueSpecification(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_SuffixExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_SuffixExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_PropertyCallExpression(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_PropertyCallExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_OperationCallExpression(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_OperationCallExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_Literal(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_Literal(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_NameOrChoiceOrBehaviorCall(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		//super.complete_NameOrChoiceOrBehaviorCall(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_QualifiedName(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_QualifiedName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_Interval(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_Interval(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_CollectionOrTuple(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_CollectionOrTuple(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_Tuple(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_Tuple(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_ListOfValues(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_ListOfValues(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_ListOfValueNamePairs(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_ListOfValueNamePairs(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_ValueNamePair(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_ValueNamePair(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_TimeExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_TimeExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_InstantObsExpression(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_InstantObsExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_InstantObsName(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		
		super.complete_InstantObsName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DurationObsExpression(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DurationObsExpression(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DurationObsName(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DurationObsName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_JitterExp(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_JitterExp(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_VariableDeclaration(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_VariableDeclaration(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_VariableDirectionKind(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_VariableDirectionKind(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DataTypeName(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DataTypeName(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_NumberLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_NumberLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_IntegerLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_IntegerLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_IntegerLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_IntegerLiteral(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_UnlimitedLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_UnlimitedLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RealLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_RealLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RealLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_RealLiteral(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DateTimeLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DateTimeLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DateTimeLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DateTimeLiteral(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_BooleanLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_BooleanLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_BooleanLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_BooleanLiteral(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_NullLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_NullLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_NullLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_NullLiteral(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_DefaultLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_DefaultLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_StringLiteralRule(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.complete_StringLiteralRule(model, ruleCall, context, acceptor);
	}

	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		if (!contentAssistContext.getPrefix().equals("")) {
			if (keyword.getValue().startsWith(contentAssistContext.getPrefix()))
				super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}

	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// super.complete_STRING(model, ruleCall, context, acceptor);
	}
	
}
