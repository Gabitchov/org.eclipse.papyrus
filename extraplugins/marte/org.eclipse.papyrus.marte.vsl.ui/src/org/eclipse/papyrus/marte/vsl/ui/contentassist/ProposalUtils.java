package org.eclipse.papyrus.marte.vsl.ui.contentassist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.scoping.visitors.ScopingVisitors;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class ProposalUtils {

	public static Map<String, Element> buildProposalForType(Classifier classifier, MultiplicityElement elem) {
		Map<String, Element> allProposals = buildProposalForType(classifier) ;
		if (elem.upperBound() == 1)
			return allProposals ;
		Map<String, Element> allProposalsWithAccountForMultiplicity = new HashMap<String, Element>() ;
		for (String s : allProposals.keySet()) {
			String newProposal = "{" + s + "/* , " + s + " */ }" ;
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
			allProposals.put("/* No proposal for this kind of type */", null) ;
		}
		
		return allProposals ;
	}
	
	protected static Map<String, Element> buildProposalForTupleType(Classifier classifier) {
		Map<String, Element> allProposals = new HashMap<String, Element>() ;
		String proposal = "" ;
		proposal += "{" ;
		Property p = null ;
		boolean first = true ;
		for (NamedElement n : VSLContextUtil.getTupleAttribs(classifier)) {
			p = (Property)n ;
			if (p.getType() != null && !p.getType().getName().equalsIgnoreCase("VSL_Expression")) {
				if (! first)
					proposal += ", " ;
				else 
					first = false ;
				proposal += p.getName() + " = /" ;
			}
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
}
