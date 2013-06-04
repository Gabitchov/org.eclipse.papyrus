/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class AppliedStereotypePropertyEditorUtil {


	private static final String COMA = ",";

	private static final String QUOTE = "\"";

	private static final String VALUE_NULL = "= null";

	private static final String EQUAL = "=";

	private static final String BRAKET_END = "}";

	private static final String HOOK_END = "]";

	private static final String BRACKET_BEGIN = "{";

	private static final String HOOK_BEGIN = "[";

	/**
	 * this method is used to display the content of stereotype application property to be edited
	 * 
	 * @param appliedStereotypeProperty
	 * @return a string
	 */
	public static String getLabel(AppliedStereotypeProperty appliedStereotypeProperty) {

		final Property property = appliedStereotypeProperty.getStereotypeProperty();
		final Stereotype stereotype = appliedStereotypeProperty.getStereotype();
		final Element umlElement = appliedStereotypeProperty.getBaseElement();


		String result = StereotypeUtil.displayPropertyValueToEdit(stereotype, property, umlElement, "");

		//first replace [ by {
		result = result.replace(HOOK_BEGIN, BRACKET_BEGIN);
		result = result.replace(HOOK_END, BRAKET_END);
		if(!(result.contains(EQUAL))) {
			result = result + VALUE_NULL;
		}
		
		if( result.contains(VALUE_NULL)){
			return result;
		
		}
		  if(("Integer".equals(property.getType().getName()))){
			  result = result.replace("\"", "");
		  }
		  if(("Boolean".equals(property.getType().getName()))){
			  result = result.replace("\"", "");
		  }

		return result;
	}

	/**
	 * a method used to construct a qualified name from a alf name expression
	 * 
	 * @param nameExpression
	 * @return a string that the qualified name
	 */
	public static String getQualifiedName(NameExpression nameExpression) {
		String nameSpace = "";
		Iterator<UnqualifiedName> iter = nameExpression.getPath().getNamespace().iterator();
		while(iter.hasNext()) {
			UnqualifiedName unqualifiedName = iter.next();
			nameSpace = nameSpace + unqualifiedName.getName() + "::";

		}
		nameSpace = nameSpace + nameExpression.getId();
		return nameSpace;
	}

	/**
	 * get a list of all possible object in a model that can be a value for a Applied stereotype property
	 * 
	 * @param appliedStereotypeProperty
	 * @return an array of object
	 */
	public static Object[] getPossibleElements(AppliedStereotypeProperty appliedStereotypeProperty) {
		EStructuralFeature foundStructuralFeature = null;
		Iterator<EStructuralFeature> iterator = appliedStereotypeProperty.getStereotypeApplication().eClass().getEAllStructuralFeatures().iterator();
		while(iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = iterator.next();
			if(eStructuralFeature.getName().equals(appliedStereotypeProperty.getStereotypeProperty().getName())) {
				foundStructuralFeature = eStructuralFeature;
			}
		}

		UMLContentProvider umlContentProvider = new UMLContentProvider(appliedStereotypeProperty.getStereotypeApplication(), foundStructuralFeature, appliedStereotypeProperty.getStereotype());
		HierarchicToFlatContentProvider treeToFlatContentProvider = new HierarchicToFlatContentProvider(umlContentProvider);
		return treeToFlatContentProvider.getElements();
	}

	/**
	 * get the stereotype application that is link to the base element represented by the name expression from a list
	 * 
	 * @param nameExpression
	 * @param result
	 *        a list of object
	 * @return may return null
	 */
	public static EObject getApplicationStereotypeFor(NameExpression nameExpression, Object[] result) {
		String qn = AppliedStereotypePropertyEditorUtil.getQualifiedName(nameExpression);
		EObject foundStereotypeApplication = null;
		//look for object
		for(int i = 0; i < result.length; i++) {
			if(result[i] instanceof EObject && UMLUtil.getBaseElement((EObject)result[i]) != null) {
				if(((NamedElement)UMLUtil.getBaseElement((EObject)result[i])).getQualifiedName().equals(qn)) {
					foundStereotypeApplication = (EObject)result[i];
				}
			}

		}
		return foundStereotypeApplication;
	}

	/**
	 * get the element that is represented by the name expression from a list
	 * 
	 * @param nameExpression
	 * @param result
	 *        a list of object
	 * @return may return null
	 */
	public static EObject getNamedElementFor(NameExpression nameExpression, Object[] result) {
		String qn = AppliedStereotypePropertyEditorUtil.getQualifiedName(nameExpression);
		EObject foundStereotypeApplication = null;
		//look for object
		for(int i = 0; i < result.length; i++) {
			if(result[i] instanceof NamedElement && ((NamedElement)result[i]).getQualifiedName().equals(qn)) {
				foundStereotypeApplication = (NamedElement)result[i];
			}
		}
		return foundStereotypeApplication;
	}

	public static ArrayList<INTEGER_LITERAL> get_INTEGER(EObject xtextObject) {
		ArrayList<INTEGER_LITERAL> result = new ArrayList<INTEGER_LITERAL>();
		TreeIterator<EObject> iterator = xtextObject.eAllContents();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof INTEGER_LITERAL) {
				result.add((INTEGER_LITERAL)eObject);
			}
		}

		return result;
	}

	public static ArrayList<BOOLEAN_LITERAL> get_BOOLEAN(EObject xtextObject) {
		ArrayList<BOOLEAN_LITERAL> result = new ArrayList<BOOLEAN_LITERAL>();
		TreeIterator<EObject> iterator = xtextObject.eAllContents();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof BOOLEAN_LITERAL) {
				result.add((BOOLEAN_LITERAL)eObject);
			}
		}

		return result;
	}

	public static ArrayList<STRING_LITERAL> get_STRING(EObject xtextObject) {
		ArrayList<STRING_LITERAL> result = new ArrayList<STRING_LITERAL>();
		TreeIterator<EObject> iterator = xtextObject.eAllContents();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof STRING_LITERAL) {
				result.add((STRING_LITERAL)eObject);
			}
		}

		return result;
	}
}
