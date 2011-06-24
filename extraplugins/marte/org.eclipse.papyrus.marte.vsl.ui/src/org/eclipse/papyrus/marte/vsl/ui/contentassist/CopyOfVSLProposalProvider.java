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
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.extensions.VSLTypeInferenceUtil;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.AbstractVSLProposalProvider;
import org.eclipse.papyrus.marte.vsl.vSL.DataTypeName;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsName;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class CopyOfVSLProposalProvider extends AbstractVSLProposalProvider {

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
	
	/* *************************************************
	 * 
	 * Private utility method for sorting a list of NamedElement by kind and name
	 * 
	 **************************************************/
	
	protected List<NamedElement> sortByKindAndName(List<NamedElement> list) {
		List<NamedElement> sortedList = new ArrayList<NamedElement>() ;
		HashMap<EClass, List<NamedElement>> namedElementGroups = new HashMap<EClass, List<NamedElement>>() ;
		
		for (NamedElement n : list) {
			if (! namedElementGroups.containsKey(n.eClass())) {
				List<NamedElement> group = new ArrayList<NamedElement>() ;
				group.add(n) ;
				namedElementGroups.put(n.eClass(), group) ;
			}
			else {
				List<NamedElement> group = namedElementGroups.get(n.eClass()) ;
				boolean inserted = false ;
				for (int i = 0 ; inserted == false && i < group.size() ; i++) {
					if (group.get(i).getName().compareTo(n.getName()) > 0) {
						group.add(i, n) ;
						inserted = true ;
					}
				}
				if (!inserted) group.add(n) ;
				namedElementGroups.put(n.eClass(), group) ;
			}
		}
		
		for (EClass c : namedElementGroups.keySet()) {
			List<NamedElement> group = namedElementGroups.get(c) ;
			sortedList.addAll(group) ;
		}
		
		return sortedList ;
	}
	
	
	/* *************************************************
	 * 
	 * Custom completion for qualified names
	 * 
	 **************************************************/
	
	@Override
	public void completeQualifiedName_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		QualifiedName rule = model instanceof QualifiedName ? (QualifiedName) model : null ;
		List<NamedElement> visibleNamespaces = getVisibleNamespaces(rule) ;
		visibleNamespaces = this.sortByKindAndName(visibleNamespaces) ;
		for (EObject o : visibleNamespaces) {
			NamedElement namespace = (NamedElement) o ;
			if (namespace.getName().startsWith(context.getPrefix())) {
				String completionString = namespace.getName().substring(context.getPrefix().length()) + "::" ;
				String displayString = namespace.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(namespace, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisibleNamespaces(QualifiedName ctx) {
		List<NamedElement> allVisibleNamespaces = new ArrayList<NamedElement>() ;
		if (ctx != null) {
			Namespace nameSpace = ctx.getPath() ;
			for (NamedElement elem : nameSpace.getOwnedMembers()) {
				if (elem instanceof Classifier || elem instanceof Package)
					allVisibleNamespaces.add(elem) ;
			}
		}
		else {
			allVisibleNamespaces.add(VSLJavaValidator.getModel()) ; // TODO: Handle/store the highest possible root somewhere?
		}
		return allVisibleNamespaces ;
	}

	/* *************************************************
	 * 
	 * Custom completion for names
	 * 
	 **************************************************/
	
	@Override
	public void completeNameOrChoiceOrBehaviorCall_Id(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		NameOrChoiceOrBehaviorCall rule = model instanceof NameOrChoiceOrBehaviorCall ? (NameOrChoiceOrBehaviorCall) model : null ;
		List<NamedElement> visibleNames = getVisibleNames(rule, VSLContextUtil.getExpectedType(model)) ;
		visibleNames = this.sortByKindAndName(visibleNames) ;
		for (EObject o : visibleNames) {
			NamedElement namedElement = (NamedElement) o ;
			if (namedElement.getName().startsWith(context.getPrefix())) {
				String completionString = namedElement.getName().substring(context.getPrefix().length()) ;
				String displayString = namedElement.getName() ;
				if (namedElement instanceof TypedElement) {
					TypedElement typedElement = (TypedElement) namedElement ;
					displayString += typedElement.getType() != null ?
										" : " + typedElement.getType().getName():
										"" ;
				}
				ICompletionProposal completionProposal = createCompletionProposal(namedElement, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisibleNames(NameOrChoiceOrBehaviorCall ctx, Type expectedType) {
		List<NamedElement> allVisibleNames = new ArrayList<NamedElement>() ;
		
		if (ctx != null) {
			QualifiedName qualifiedName = ctx.getPath() ;
			if (qualifiedName != null) {
				while (qualifiedName.getRemaining() !=null) {
					qualifiedName = qualifiedName.getRemaining() ;
				}
			}
			if (qualifiedName == null || qualifiedName.getPath() == null)
				return allVisibleNames ;
			for (NamedElement elem : qualifiedName.getPath().getOwnedMembers()) {
				if (elem instanceof Property || elem instanceof EnumerationLiteral)
					allVisibleNames.add(elem) ;
			}
		}
		else {
			List<Element> contextHierarchy = new ArrayList<Element>() ;
			contextHierarchy.add(VSLJavaValidator.getContextElement()) ;
			Element tmpContext = VSLJavaValidator.getContextElement().getOwner() ;
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext) ;
				tmpContext = tmpContext.getOwner() ;
			}
			for (Element currentContext : contextHierarchy) {
				for (Element elem : currentContext.getOwnedElements()) {
					if (elem instanceof Property || elem instanceof EnumerationLiteral)
						allVisibleNames.add((NamedElement)elem) ;
				}
			}
			if (expectedType instanceof Enumeration) {
				allVisibleNames.addAll(((Enumeration)expectedType).getOwnedLiterals()) ;
			}
			//else if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType") != null) {
			//	allVisibleNames.addAll(((Classifier)expectedType).getAllAttributes()) ;
			//}
		}
		return allVisibleNames ;
	}
	
	
	/* *************************************************
	 * 
	 * Custom completion for instant observation names
	 * 
	 **************************************************/
	
	@Override
	public void completeInstantObsName_InstantId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		InstantObsName rule = model instanceof InstantObsName ? (InstantObsName) model : null ;
		List<NamedElement> visibleNames = getVisibleInstantObsNames(rule) ;
		visibleNames = this.sortByKindAndName(visibleNames) ;
		for (EObject o : visibleNames) {
			NamedElement namedElement = (NamedElement) o ;
			if (namedElement.getName().startsWith(context.getPrefix())) {
				String completionString = namedElement.getName().substring(context.getPrefix().length()) ;
				String displayString = namedElement.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(namedElement, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}		
	}
	
	private List<NamedElement> getVisibleInstantObsNames(InstantObsName ctx) {
		List<NamedElement> allVisibleNames = new ArrayList<NamedElement>() ;	
		if (ctx != null) {
			QualifiedName qualifiedName = ctx.getPath() ;
			if (qualifiedName != null) {
				while (qualifiedName.getRemaining() !=null) {
					qualifiedName = qualifiedName.getRemaining() ;
				}
				if (qualifiedName.getPath() == null)
					return allVisibleNames ;
				for (NamedElement elem : qualifiedName.getPath().getOwnedMembers()) {
					if (elem instanceof TimeObservation)
						allVisibleNames.add(elem) ;
				}
			}
			else {
				List<Element> contextHierarchy = new ArrayList<Element>() ;
				contextHierarchy.add(ctx.getContextElement()) ;
				Element tmpContext = ctx.getContextElement().getOwner() ;
				while (tmpContext != null) {
					contextHierarchy.add(0, tmpContext) ;
					tmpContext = tmpContext.getOwner() ;
				}
				for (Element currentContext : contextHierarchy) {
					for (Element elem : currentContext.getOwnedElements()) {
						if (elem instanceof TimeObservation) {
							allVisibleNames.add((NamedElement)elem) ;
						}
					}
				}
			}
		}
		else {
			List<Element> contextHierarchy = new ArrayList<Element>() ;
			contextHierarchy.add(VSLJavaValidator.getContextElement()) ;
			Element tmpContext = VSLJavaValidator.getContextElement().getOwner() ;
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext) ;
				tmpContext = tmpContext.getOwner() ;
			}
			for (Element currentContext : contextHierarchy) {
				for (Element elem : currentContext.getOwnedElements()) {
					if (elem instanceof TimeObservation) {
						allVisibleNames.add((NamedElement)elem) ;
					}
				}
			}
		}
		return allVisibleNames ;
	}
	
	/* *************************************************
	 * 
	 * Custom completion for duration observation names
	 * 
	 **************************************************/
	
	@Override
	public void completeDurationObsName_DurationId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		DurationObsName rule = model instanceof DurationObsName ? (DurationObsName) model : null ;
		List<NamedElement> visibleNames = getVisibleDurationObsNames(rule) ;
		visibleNames = this.sortByKindAndName(visibleNames) ;
		for (EObject o : visibleNames) {
			NamedElement namedElement = (NamedElement) o ;
			if (namedElement.getName().startsWith(context.getPrefix())) {
				String completionString = namedElement.getName().substring(context.getPrefix().length()) ;
				String displayString = namedElement.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(namedElement, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}		
	}
	
	private List<NamedElement> getVisibleDurationObsNames(DurationObsName ctx) {
		List<NamedElement> allVisibleNames = new ArrayList<NamedElement>() ;	
		if (ctx != null) {
			QualifiedName qualifiedName = ctx.getPath() ;
			if (qualifiedName != null) {
				while (qualifiedName.getRemaining() !=null) {
					qualifiedName = qualifiedName.getRemaining() ;
				}
				if (qualifiedName.getPath() == null)
					return allVisibleNames ;
				for (NamedElement elem : qualifiedName.getPath().getOwnedMembers()) {
					if (elem instanceof DurationObservation)
						allVisibleNames.add(elem) ;
				}
			}
			else {
				List<Element> contextHierarchy = new ArrayList<Element>() ;
				contextHierarchy.add(ctx.getContextElement()) ;
				Element tmpContext = ctx.getContextElement().getOwner() ;
				while (tmpContext != null) {
					contextHierarchy.add(0, tmpContext) ;
					tmpContext = tmpContext.getOwner() ;
				}
				for (Element currentContext : contextHierarchy) {
					for (Element elem : currentContext.getOwnedElements()) {
						if (elem instanceof DurationObservation) {
							allVisibleNames.add((NamedElement)elem) ;
						}
					}
				}
			}
		}
		else {
			List<Element> contextHierarchy = new ArrayList<Element>() ;
			contextHierarchy.add(VSLJavaValidator.getContextElement()) ;
			Element tmpContext = VSLJavaValidator.getContextElement().getOwner() ;
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext) ;
				tmpContext = tmpContext.getOwner() ;
			}
			for (Element currentContext : contextHierarchy) {
				for (Element elem : currentContext.getOwnedElements()) {
					if (elem instanceof DurationObservation) {
						allVisibleNames.add((NamedElement)elem) ;
					}
				}
			}
		}
		return allVisibleNames ;
	}
	
	/* *************************************************
	 * 
	 * Custom completion for data type names (used to type local variables)
	 * 
	 **************************************************/
	
	@Override
	public void completeDataTypeName_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		DataTypeName rule = model instanceof DataTypeName ? (DataTypeName) model : null ;
		List<NamedElement> visibleNamespaces = getVisibleDataTypes(rule) ;
		visibleNamespaces = this.sortByKindAndName(visibleNamespaces) ;
		for (EObject o : visibleNamespaces) {
			NamedElement namespace = (NamedElement) o ;
			if (namespace.getName().startsWith(context.getPrefix())) {
				String completionString = namespace.getName().substring(context.getPrefix().length()) ;
				String displayString = namespace.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(namespace, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisibleDataTypes(DataTypeName ctx) {
		List<NamedElement> allVisibleNames = new ArrayList<NamedElement>() ;
		if (ctx != null) {
			QualifiedName qualifiedName = ctx.getPath() ;
			if (qualifiedName != null) {
				while (qualifiedName.getRemaining() !=null) {
					qualifiedName = qualifiedName.getRemaining() ;
				}
				if (qualifiedName.getPath() == null)
					return allVisibleNames ;
				for (NamedElement elem : qualifiedName.getPath().getOwnedMembers()) {
					if (elem instanceof DataType)
						allVisibleNames.add(elem) ;
				}
			}
			else {
				List<Element> contextHierarchy = new ArrayList<Element>() ;
				contextHierarchy.add(ctx.getContextElement()) ;
				Element tmpContext = ctx.getContextElement().getOwner() ;
				while (tmpContext != null) {
					contextHierarchy.add(0, tmpContext) ;
					tmpContext = tmpContext.getOwner() ;
				}
				for (Element currentContext : contextHierarchy) {
					for (Element elem : currentContext.getOwnedElements()) {
						if (elem instanceof DataType) {
							allVisibleNames.add((NamedElement)elem) ;
						}
					}
				}
			}
		}
		else {
			List<Element> contextHierarchy = new ArrayList<Element>() ;
			contextHierarchy.add(VSLJavaValidator.getContextElement()) ;
			Element tmpContext = VSLJavaValidator.getContextElement().getOwner() ;
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext) ;
				tmpContext = tmpContext.getOwner() ;
			}
			for (Element currentContext : contextHierarchy) {
				for (Element elem : currentContext.getOwnedElements()) {
					if (elem instanceof DataType) {
						allVisibleNames.add((NamedElement)elem) ;
					}
				}
			}
		}
		return allVisibleNames ;
	}
	
	/* *************************************************
	 * 
	 * Custom completion for property call expressions
	 * 
	 **************************************************/
	
	@Override
	public void completePropertyCallExpression_Property(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		List<NamedElement> visibleProperties = getVisibleProperties(model) ;
		visibleProperties = this.sortByKindAndName(visibleProperties) ;
		for (EObject o : visibleProperties) {
			NamedElement namedElement = (NamedElement) o ;
			if (namedElement.getName().startsWith(context.getPrefix())) {
				String completionString = namedElement.getName().substring(context.getPrefix().length()) ;
				String displayString = namedElement.getName() ;
				if (namedElement instanceof TypedElement) {
					TypedElement typedElement = (TypedElement) namedElement ;
					displayString += typedElement.getType() != null ?
										" : " + typedElement.getType().getName():
										"" ;
				}
				ICompletionProposal completionProposal = createCompletionProposal(namedElement, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisibleProperties(EObject ctx) {

		List<NamedElement> allVisibleProperties = new ArrayList<NamedElement>() ;
				
		if (ctx instanceof PrimaryExpression) {
			ValueSpecification contextValueSpecification = ((PrimaryExpression)ctx).getPrefix() ;
			Type contextType = new VSLTypeInferenceUtil(null).typeOfValueSpecification(contextValueSpecification) ;
			if (contextType != null) {
				allVisibleProperties.addAll(((Classifier)contextType).getAllAttributes()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		else if (ctx instanceof PropertyCallExpression) {
			PropertyCallExpression parent = (PropertyCallExpression)ctx ;
			Type contextType = parent.getProperty() != null ? parent.getProperty().getType() : null ;
			if (contextType != null) {
				allVisibleProperties.addAll(((Classifier)contextType).getAllAttributes()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		else if (ctx instanceof OperationCallExpression) {
			OperationCallExpression parent = (OperationCallExpression)ctx ;
			Type contextType = parent.getOperation() != null ? parent.getOperation().getType() : null ;
			if (contextType != null) {
				allVisibleProperties.addAll(((Classifier)contextType).getAllAttributes()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		return allVisibleProperties;
	}
	
	/* *************************************************
	 * 
	 * Custom completion for operation call expressions
	 * 
	 **************************************************/
	
	@Override
	public void completeOperationCallExpression_Operation(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		List<NamedElement> visibleOperations = getVisibleOperations(model) ;
		visibleOperations = this.sortByKindAndName(visibleOperations) ;
		for (EObject o : visibleOperations) {
			NamedElement namedElement = (NamedElement) o ;
			if (namedElement.getName().startsWith(context.getPrefix())) {
				Operation operation = (Operation) namedElement ;
				String completionString = namedElement.getName().substring(context.getPrefix().length()) + "()" ;
				String displayString = namedElement.getName() + "()" ; // TODO
				displayString += operation.getType() != null ?
										" : " + operation.getType().getName():
										"" ;
				ICompletionProposal completionProposal = createCompletionProposal(namedElement, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisibleOperations(EObject ctx) {

		List<NamedElement> allVisibleOperations = new ArrayList<NamedElement>() ;
				
		if (ctx instanceof PrimaryExpression) {
			ValueSpecification contextValueSpecification = ((PrimaryExpression)ctx).getPrefix() ;
			Type contextType = new VSLTypeInferenceUtil(null).typeOfValueSpecification(contextValueSpecification) ;
			if (contextType != null) {
				allVisibleOperations.addAll(((Classifier)contextType).getAllOperations()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		else if (ctx instanceof PropertyCallExpression) {
			PropertyCallExpression parent = (PropertyCallExpression)ctx ;
			Type contextType = parent.getProperty() != null ? parent.getProperty().getType() : null ;
			if (contextType != null) {
				allVisibleOperations.addAll(((Classifier)contextType).getAllOperations()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		else if (ctx instanceof OperationCallExpression) {
			OperationCallExpression parent = (OperationCallExpression)ctx ;
			Type contextType = parent.getOperation() != null ? parent.getOperation().getType() : null ;
			if (contextType != null) {
				allVisibleOperations.addAll(((Classifier)contextType).getAllOperations()) ; //TODO: Take inheritance into account for nested scopes
			}
		}
		return allVisibleOperations;
	}

	
	/* *************************************************
	 * 
	 * Custom completion for ValueNamePair_property
	 * 
	 **************************************************/

	@Override
	public void completeValueNamePair_Property(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Type expectedType = VSLContextUtil.getExpectedType(model) ;
		List<NamedElement> filteredVisibleProperties = getVisiblePropertiesForValueNamePair(model, expectedType) ;
		EObject tmpContext = model ;
		while (tmpContext != null && !(tmpContext instanceof ListOfValueNamePairs)) {
			tmpContext = tmpContext.eContainer() ;
		}
		if (tmpContext != null) {
			for (ValueNamePair v : ((ListOfValueNamePairs)tmpContext).getValueNamePairs()) {
				filteredVisibleProperties.remove(v.getProperty()) ;
			}
		}
		filteredVisibleProperties = this.sortByKindAndName(filteredVisibleProperties) ;
		for (EObject o : filteredVisibleProperties) {
			NamedElement namespace = (NamedElement) o ;
			if (namespace.getName().startsWith(context.getPrefix())) {
				String completionString = namespace.getName().substring(context.getPrefix().length()) + " = ";
				String displayString = namespace.getName() + " = "; 
				ICompletionProposal completionProposal = createCompletionProposal(namespace, completionString, displayString, context) ;
				acceptor.accept(completionProposal) ;
			}
		}
	}
	
	private List<NamedElement> getVisiblePropertiesForValueNamePair(EObject rule, Type expectedType) {
		List<NamedElement> visibleProperties = new ArrayList<NamedElement>() ;
		if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null ||
				expectedType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") != null) {
			visibleProperties.addAll(((Classifier)expectedType).getAllAttributes()) ;
		}
		return visibleProperties ;
	}
}
