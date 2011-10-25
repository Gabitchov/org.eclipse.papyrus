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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.scoping.VSLScopeProvider;
import org.eclipse.papyrus.marte.vsl.scoping.visitors.ScopingVisitors;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.scoping.IScope;

public class VSLProposalUtils {

	public static Map<String, Element> buildProposalForType(Classifier classifier, MultiplicityElement elem) {
		Map<String, Element> allProposals = buildProposalForType(classifier) ;
		if (elem.upperBound() == 1)
			return allProposals ;
		Map<String, Element> allProposalsWithAccountForMultiplicity = new HashMap<String, Element>() ;
		for (String s : allProposals.keySet()) {
			String displayString ;
			if (! s.contains("|")) {
				displayString = s ;
			}
			else {
				String[] splitted = s.split("|") ;
				displayString = splitted[0] ;
			}
			
			String newProposal = "{" + displayString + "/* , " + displayString + " */ }" ;
			allProposalsWithAccountForMultiplicity.put(newProposal, allProposals.get(s)) ;
		}
		return allProposalsWithAccountForMultiplicity ;
	}
	
	public static Map<String, Element> buildProposalForType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		
		if (VSLContextUtil.isATupleType(classifier)) {
			allProposals.putAll(buildProposalForTupleType(classifier)) ;
		}
		else if (VSLContextUtil.isAChoiceType(classifier)) {
			allProposals.putAll(buildProposalForChoiceType(classifier)) ;
		}
		else if (VSLContextUtil.isACollectionType(classifier)) {
			allProposals.putAll(buildProposalForCollectionType(classifier)) ;
		}
		else if (classifier instanceof Enumeration) {
			allProposals.putAll(buildProposalForEnumeration(classifier)) ;
		}
		else if (classifier instanceof PrimitiveType) {
			allProposals.putAll(buildProposalForPrimitiveType(classifier)) ;
		}
		else if (classifier instanceof Stereotype) {
			allProposals.putAll(buildProposalForStereotype(classifier)) ;
		}
		else if (classifier instanceof org.eclipse.uml2.uml.Class) {
			allProposals.putAll(buildProposalForMetaclass(classifier)) ;
		}
		else {
			allProposals.put("/* " + classifier.getName() + "*/", null) ;
		}
		
		Map<String, Element> crossReferences = new HashMap<String, Element>() ;
		crossReferences.putAll(buildProposalForMetaclass(UMLPackage.eINSTANCE.getBehavior())) ;
		
		List<String> proposalsToBeRemoved = new ArrayList<String>() ;
		for (String key : crossReferences.keySet()) {
			Type behaviorReturnType = null ;
			Behavior behavior = (Behavior)crossReferences.get(key); ;
			for (Parameter p : behavior.getOwnedParameters()) {
				if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
					behaviorReturnType = p.getType() ;
			}
			if (behaviorReturnType == null)
				proposalsToBeRemoved.add(key) ;
			else if ((classifier.getName().equals("Integer") || classifier.getName().equals("Boolean") || classifier.getName().equals("String"))
				 && !behaviorReturnType.getName().equals(classifier.getName())) {
					proposalsToBeRemoved.add(key) ;
			}
			else if (! behaviorReturnType.conformsTo(classifier))
				proposalsToBeRemoved.add(key) ;
		}
		
		for (String key : proposalsToBeRemoved)
			crossReferences.remove(key) ;
		
		for (String key : crossReferences.keySet()) {
			Behavior calledBehavior = (Behavior)crossReferences.get(key) ;
			allProposals.put(buildCompletionStringForBehaviorCall(calledBehavior) + "|" + buildDisplayStringForBehaviorCall(calledBehavior), calledBehavior) ;
		}
		
		// if the global context element is nested inside a classifier:
		// - retrieves the classifier, and gets all its owned and inherited attributes
		Element context = VSLJavaValidator.getContextElement() ;
		while (context != null && !(context instanceof Classifier)) {
			context = context.getOwner();
		}
		if (context != null && context instanceof Classifier) {
			List<Property> allProperties = ((Classifier)context).getAllAttributes() ;
			for (Property p : allProperties) {
				List<Classifier> classifiers = new ArrayList<Classifier>() ;
				//classifiers.add((Classifier)p.getType()) ;
				FeatureTree tree = new FeatureTree(p, classifiers) ;
				if (tree.canClassifierBeReached(classifier)) {
					allProposals.put(p.getName(),p ) ;
				}
			}
		}
		
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForTupleType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		String proposal = "" ;
		proposal += "{" ;
		Property p = null ;
		Property propertyValue = null ;
		Property propertyUnit = null ;
		boolean first = true ;
		for (NamedElement n : VSLContextUtil.getTupleAttribs(classifier)) {
			p = (Property)n ;
			if (p.getType() != null && !p.getType().getName().equalsIgnoreCase("VSL_Expression")) {
				if (! first)
					proposal += ", " ;
				else 
					first = false ;
				proposal += p.getName() + " = /" ;
				if (p.getName().equals("value"))
					propertyValue = p ;
				else if (p.getName().equals("unit")) 
					propertyUnit = p ;
			}
		}
		if (propertyUnit != null && propertyValue != null) {
			// This is a nfp type. Builds a short proposal with only value and unit, since these properties are more commonly used
			String shortProposal = "{unit = /, value = /}" ;
			allProposals.put(shortProposal, null) ;
		}
		proposal += "}" ;
		allProposals.put(proposal, null) ;
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForChoiceType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		Property p = null ;
		for (NamedElement n : VSLContextUtil.getChoiceAttribs(classifier)) {
			p = (Property)n ;
			String choiceProposal = p.getName() + "(" ;
			Map<String, Element> nestedProposals = buildProposalForType((Classifier)p.getType()) ;
			for (String nestedProposal : nestedProposals.keySet()) {
				allProposals.put(choiceProposal + nestedProposal + ")", null) ;
			}
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForCollectionType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		Property p = null ;
		if (VSLContextUtil.getCollectionAttrib(classifier) != null)
			p = (Property) VSLContextUtil.getCollectionAttrib(classifier);
		if (p.getType() != null) {
			Map<String, Element> nestedProposals = buildProposalForType((Classifier)p.getType()) ;
			for (String nestedProposal : nestedProposals.keySet()) {
				allProposals.put("{" + nestedProposal + "}", null) ;
			}
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForEnumeration(Classifier classifier) {
		HashMap<String, Element> allProposals = new HashMap<String, Element>() ;
		for (EnumerationLiteral n : ((Enumeration)classifier).getOwnedLiterals()) {
			allProposals.put(n.getName(), n) ;
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForPrimitiveType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		if (classifier.getName().contains("Integer")) {
			allProposals.put("1", null) ;
		}
		else if (classifier.getName().contains("Real")) {
			allProposals.put("1.0", null) ;
		}
		else if (classifier.getName().contains("Natural")) {
			allProposals.put("*", null) ;
		}
		else if (classifier.getName().contains("DateTime")) {
			Date currentDate = new Date() ;
			String year = "" + (currentDate.getYear()+1900) ;
			String month = "" + currentDate.getMonth() ; if (month.length() == 1) month = "0" + month ;
			String day = "" ;
			switch (currentDate.getDay()) {
			case 0:
				day += "Sun" ;
				break;
			case 1:
				day += "Mon" ;
				break;
			case 2:
				day += "Tue" ;
				break;
			case 3:
				day += "Wed" ;
				break;
			case 4:
				day += "Thu" ;
				break;
			case 5:
				day += "Fri" ;
				break;
			default:
				day += "Sat" ;
				break;
			}
			String dayOfMonth = "" + currentDate.getDate() ; if (dayOfMonth.length() == 1) dayOfMonth = "0" + dayOfMonth ;
			String hour = "" + currentDate.getHours() ; if (hour.length() == 1) hour = "0" + hour ;
			String minute = "" + currentDate.getMinutes() ; if (minute.length() == 1) minute = "0" + minute ;
			String second = "" + currentDate.getSeconds() ; if (second.length() == 1) second = "0" + second ;
			String centi = "00" ;
			
			String dateString = year + "/" + month + "/" + dayOfMonth ; // opt1
			String dateString_dayString = dateString + " " + day ; // opt2
			String timeString = hour + ":" + minute + ":" + second ; // opt3
			String timeString_dateString_dayString = timeString + " " + dateString + " " + day ; //opt4
			String timeString_dayString = timeString + " " + day ; //opt5
			String timeString_dateString = timeString + " " + dateString ; //opt6
			String dayString = day ; //opt7
			
			allProposals.put(timeString_dateString_dayString, null) ;
			allProposals.put(timeString_dayString, null) ;
			allProposals.put(timeString_dateString, null) ;
			allProposals.put(timeString, null) ;
			allProposals.put(dateString_dayString, null) ;
			allProposals.put(dateString, null) ;
			allProposals.put(dayString, null) ;
			
//			<datetime-literal> ::= (<date-string> [<daystring>] ) | ( <time-string> [<datestring>]
//			[<day-string>] ) | ( <day-string> )
//			<time-string> ::= <hr> [':' <min> [':' <sec> [':' <centisec>] ] ]
//			<hr> ::= '00'..'23'
//			<min> ::= '00'..'59'
//			<sec> ::= '00'..'59'
//			<centisec> ::= '00'..'99'
//			<date-string> ::= <year> '/' <mon> '/' <day-of-mon>
//			<year> ::= '0000'..'9999'
//			<mon> ::= '01'..'12'
//			<day-of-mon> ::= '01'..'31'
//			<day-string> ::= 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun'
		}
		else if (classifier.getName().contains("Boolean")) {
			allProposals.put("true", null) ;
			allProposals.put("false", null) ;
		}
		else if (classifier.getName().contains("String")) {
			allProposals.put("\"value\"", null) ;
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForStereotype(Classifier classifier) {
		List<Element> allElements = new ArrayList<Element>() ;
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		allElements.addAll(new ScopingVisitors.Visitor_GetRecursivelyOwnedAndImportedStereotypeInstances().visit(VSLJavaValidator.getModel(), (Stereotype)classifier)) ;
		for (Element c : allElements) {
			if (c instanceof NamedElement) {
				allProposals.put(getNameLabel((NamedElement)c), c);
			}
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForMetaclass(Classifier classifier) {
		List<Element> allElements = new ArrayList<Element>() ;
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		allElements.addAll(new ScopingVisitors.Visitor_GetRecursivelyOwnedAndImportedMetaclassInstances().visit(VSLJavaValidator.getModel(), (org.eclipse.uml2.uml.Class)classifier)) ;
		for (Element c : allElements) {
			if (c instanceof NamedElement) {
				allProposals.put(getNameLabel((NamedElement)c), c);
			}
		}
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForMetaclass(EClass metaclass) {
		List<Element> allElements = new ArrayList<Element>() ;
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		allElements.addAll(new ScopingVisitors.Visitor_GetRecursivelyOwnedAndImportedMetaclassInstances().visit(VSLJavaValidator.getModel(), metaclass)) ;
		for (Element c : allElements) {
			if (c instanceof NamedElement) {
				allProposals.put(getNameLabel((NamedElement)c), c);
			}
		}
		return allProposals ;
	}
	
	public static String getNameLabel(NamedElement elem) {
		String label = "" ;
		
		Namespace model = VSLJavaValidator.getModel() ;
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages()) ;
		
		List<Namespace> visitedNamespaces = new ArrayList<Namespace>() ;
		Namespace currentNamespace = elem.getNamespace() ;
		
		boolean rootFound = false ;
		
		while (currentNamespace != null && !rootFound) {
			visitedNamespaces.add(currentNamespace) ;
			if (importedPackages.contains(currentNamespace) || currentNamespace == model) {
				rootFound = true ;
			}
			Element owner = currentNamespace.getOwner() ;
			
			currentNamespace = owner != null ? (Namespace)owner : null ;
		}
		
		for (int i = visitedNamespaces.size() - 1 ; i >= 0 ; i--) {
			label += visitedNamespaces.get(i).getName() + "::" ; 
		}
		
		return label + elem.getName() ;
	}
	
	public static String buildDisplayStringForBehaviorCall(Behavior calledBehavior) {
		String label = calledBehavior.getName() + "(" ;
		String returnTypeName = "" ;
		List<String> parameterLabels = new ArrayList<String>() ;
		for (Parameter p : calledBehavior.getOwnedParameters()) {
			if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				returnTypeName = p.getType().getName() ;
			}
			else {
				String parameterLabel = "" ;
				switch (p.getDirection()) {
				case IN_LITERAL:
					parameterLabel += "in " ;
					break;
				case OUT_LITERAL:
					parameterLabel += "out " ;
					break;
				case INOUT_LITERAL:
					parameterLabel += "inout " ;
					break;
				default:
					break;
				}
				parameterLabel += p.getName() + " : " + p.getType().getName() ;
				parameterLabels.add(parameterLabel) ;
			}
		}
		boolean first = true ;
		for (String parameterLabel : parameterLabels) {
			if (!first)
				label += ", " ;
			else
				first = false ;
			label += parameterLabel ;
		}
		
		return label + ") : " + returnTypeName ;
	}
	
	public static String buildCompletionStringForBehaviorCall(Behavior calledBehavior) {
		String label = calledBehavior.getName() + "(" ;
		List<String> parameterLabels = new ArrayList<String>() ;
		for (Parameter p : calledBehavior.getOwnedParameters()) {
			if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				// ignore
			}
			else {
				parameterLabels.add(p.getName()) ;
			}
		}
		boolean first = true ;
		for (String parameterLabel : parameterLabels) {
			if (!first)
				label += ", " ;
			else
				first = false ;
			label += parameterLabel ;
		}
		
		return label + ")" ;
	}
	
	public static String buildDisplayStringForOperationCall(Operation calledOperation) {
		String label = calledOperation.getName() + "(" ;
		String returnTypeName = "" ;
		List<String> parameterLabels = new ArrayList<String>() ;
		for (Parameter p : calledOperation.getOwnedParameters()) {
			if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				returnTypeName = p.getType().getName() ;
			}
			else {
				String parameterLabel = "" ;
				switch (p.getDirection()) {
				case IN_LITERAL:
					parameterLabel += "in " ;
					break;
				case OUT_LITERAL:
					parameterLabel += "out " ;
					break;
				case INOUT_LITERAL:
					parameterLabel += "inout " ;
					break;
				default:
					break;
				}
				parameterLabel += p.getName() + " : " + p.getType().getName() ;
				parameterLabels.add(parameterLabel) ;
			}
		}
		boolean first = true ;
		for (String parameterLabel : parameterLabels) {
			if (!first)
				label += ", " ;
			else
				first = false ;
			label += parameterLabel ;
		}
		
		return label + ") : " + returnTypeName ;
	}
	
	public static String buildCompletionStringForOperationCall(Operation calledOperation) {
		String label = calledOperation.getName() + "(" ;
		List<String> parameterLabels = new ArrayList<String>() ;
		for (Parameter p : calledOperation.getOwnedParameters()) {
			if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				// ignore
			}
			else {
				parameterLabels.add(p.getName()) ;
			}
		}
		boolean first = true ;
		for (String parameterLabel : parameterLabels) {
			if (!first)
				label += ", " ;
			else
				first = false ;
			label += parameterLabel ;
		}
		
		return label + ")" ;
	}
}
