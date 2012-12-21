package org.eclipse.papyrus.qompass.designer.core.acceleo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;


public class EnumService {

	public static void init() {
		enumHash.clear();
	}

	/**
	 * Return qualified name of enum package which is used to prefix enumerations (namespace)
	 * 
	 * @param dummy
	 * @return
	 */
	public static String enumSvcPrefix() {
		return enumPkg.getQualifiedName();
	}

	public static String literalKey(Element dummy, String enumName, String literalKey) {
		String literal = "";
		if(literalKey.equals("Port")) {
			literal = "ID_" + TransformationContext.port.getName();
		}
		else if(literalKey.equals("Formal")) {
			literal = "ID_" + TransformationContext.formalParameter.getName();
		}
		else if(literalKey.equals("Instance")) {
			literal = "ID_" + TransformationContext.instance.getName();
		}
		else if(literalKey.equals("Interface")) {
			literal = "ID_" + TransformationContext.classifier.getName();
		}
		return literal(enumName, literal);
	}

	public static String quoteLiteral(Element dummy, String enumName, String literal) {
		return "\"" + literal(enumName, literal) + "\"";
	}

	/**
	 * Create a literal within an enumeration. Both, the literal and the enumeration may be an Acceleo template startiung with [
	 * 
	 * @param dummy
	 * @param enumName
	 *        the name of an enumeration
	 * @param literal
	 *        the name of a literal within that enumeration.
	 * @return
	 */
	public static String literal(String enumName, String literal) {
		// Acceleo does not expand parameters, so we do it here
		/*
		 * if(enumName.contains("[") && enumName.contains("/]")) {
		 * try {
		 * enumName = AcceleoDriver.bind(enumName, dummy);
		 * } catch (TransformationException e) {
		 * return e.toString();
		 * }
		 * }
		 * if(literal.contains("[") && enumName.contains("/]")) {
		 * try {
		 * literal = AcceleoDriver.bind(literal, dummy);
		 * } catch (TransformationException e) {
		 * return e.toString();
		 * }
		 * }
		 */
		Enumeration enumeration = enumHash.get(enumName);
		if(enumPkg == null) {
			return literal;
		}
		if(enumeration == null) {
			if(enumName.startsWith("L")) {
				// magic prefix for class local
				enumeration = (Enumeration)
					((Class)TransformationContext.classifier).createNestedClassifier(enumName, UMLPackage.eINSTANCE.getEnumeration());
			}
			else {
				enumeration = enumPkg.createOwnedEnumeration(enumName);
			}
			enumHash.put(enumName, enumeration);
		}
		if(enumeration.getOwnedLiteral(literal) == null) {
			enumeration.createOwnedLiteral(literal);
		}
		// declare a dependency to the enumeration from the current classifier 
		checkAndCreateDependency(TransformationContext.classifier, enumeration);

		return literal;
	}

	public static void checkAndCreateDependency(Classifier classifier, NamedElement target) {
		boolean found = false;
		for(Dependency dep : classifier.getClientDependencies()) {
			if(dep.getSuppliers().contains(target)) {
				found = true;
			}
		}
		if(!found) {
			classifier.createDependency(target);
		}
	}

	public static void createEnumPackage(Package root) {
		enumPkg = root.createNestedPackage("globalenums");
	}

	public static Package enumPkg;

	public static void createEnums() {

	}

	private static Map<String, Enumeration> enumHash = new HashMap<String, Enumeration>();
}
