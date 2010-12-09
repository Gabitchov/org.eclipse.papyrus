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
package org.eclipse.papyrus.marte.vsl.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class VSLContextUtil {
	
	public static final VSLContextUtil eInstance = new VSLContextUtil() ; 
	
	/**
	 * @param rule
	 * @return
	 */
	public static Type getExpectedType(EObject rule) {
		
	  	java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getMethod("getExpectedType",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getExpectedType() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Type) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		return null ;
       	}
	}
	
	
	/**
	 * @param rule
	 * @return
	 */
	public static Namespace getModel(EObject rule) {
		java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getMethod("getModel",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getModel() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Namespace) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		return null ;
       	}
	}
	
	/**
	 * @param rule
	 * @return
	 */
	public static Element getContextElement(EObject rule) {
		java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getDeclaredMethod("getContextElement",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getContextElement() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Element) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		e.printStackTrace() ;
       		return null ;
       	}
	}

	/**
	 * @param rule
	 * @param filter
	 * @return
	 */
	public static EObject getFilteredParentRule(EObject rule, Object metaclassFilter) {
		MetaclassFilter filter = null ;
		if (metaclassFilter instanceof EClass)
			filter = eInstance.new MetaclassFilter((EClass)metaclassFilter) ;
		else if (metaclassFilter instanceof EClass[])
			filter = eInstance.new MetaclassFilter((EClass[])metaclassFilter) ;
		
		if (filter == null)
			return null ;
		
		if (rule != null) {
			EObject container = rule.eContainer() ;
			while (container != null && !(filter.isInstance(container))) {
				container = container.eContainer() ;
			}
			if (container != null)
				return container ;
		}
		return null ;
	}
	
	public class MetaclassFilter {
		private EClass[] filters ;
		
		public MetaclassFilter(EClass[] filters) {
			this.filters = filters ;
		}
		
		public MetaclassFilter(EClass filter) {
			this(new EClass[]{filter} ) ;
		}
		
		public boolean isInstance(EObject eObject) {
			for (EClass eClass : filters) {
				if (eClass.isInstance(eObject))
					return true ;
			}
			return false ;
		}
	}
	
	/**
	 * @param visited
	 * @return
	 */
	public static boolean isAChoiceType(Classifier visited) {
		if (visited.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType") != null) {
			return true ;
		}
		return false;
	}


	/**
	 * @param visited
	 * @return
	 */
	public static List<NamedElement> getChoiceAttribs(Classifier visited) {
		List<NamedElement> choiceAttribs = new ArrayList<NamedElement>() ;
		Stereotype tupleStereotype = visited.
								getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType") ;
		if (tupleStereotype != null) {
			EObject stereotypeApplication = visited.getStereotypeApplication(tupleStereotype) ;
			EStructuralFeature choiceAttrib = stereotypeApplication.eClass().getEStructuralFeature("choiceAttrib") ;
			List<Property> attribCollection = (List<Property>) stereotypeApplication.eGet(choiceAttrib) ;
			if (attribCollection.isEmpty()) { // all the attributes of "visited" represent choice attributes
				choiceAttribs.addAll(visited.getAttributes()) ;
			}
		}
		return choiceAttribs;
	}


	public static boolean isATupleType(Classifier visited) {
		if (visited.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null) {
			return true ;
		}
		else if (visited.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") != null) {
			return true ;
		}
		return false;
	}


	public static List<NamedElement> getTupleAttribs(Classifier visited) {
		List<NamedElement> tupleAttribs = new ArrayList<NamedElement>() ;
		Stereotype tupleStereotype = visited.
								getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") ;
		if (tupleStereotype != null) {
			EObject stereotypeApplication = visited.getStereotypeApplication(tupleStereotype) ;
			EStructuralFeature choiceAttrib = stereotypeApplication.eClass().getEStructuralFeature("tupleAttrib") ;
			List<Property> attribCollection = (List<Property>) stereotypeApplication.eGet(choiceAttrib) ;
			if (attribCollection.isEmpty()) { // all the attributes of "visited" represent choice attributes
				tupleAttribs.addAll(visited.getAttributes()) ;
			}
		}
		else { // see if NfpType is applied
			Stereotype nfpStereotype = visited.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") ;
			if (nfpStereotype != null) {
				tupleAttribs.addAll(visited.getAttributes()) ;
			}
		}
		for (Classifier general : visited.getGenerals()) {
			if (isATupleType(general))
				tupleAttribs.addAll(getTupleAttribs(general)) ;
		}
		return tupleAttribs;
	}
	
	public static boolean isACollectionType(Classifier visited) {
		if (visited.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") != null) {
			return true ;
		}
		return false;
	}
	
	public static NamedElement getCollectionAttrib(Classifier visited) {
		NamedElement collectionAttrib = null ;
		Stereotype collectionStereotype = visited.
								getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") ;
		if (collectionStereotype != null) {
			EObject stereotypeApplication = visited.getStereotypeApplication(collectionStereotype) ;
			EStructuralFeature collectionAttribFeature = stereotypeApplication.eClass().getEStructuralFeature("collectionAttrib") ;
			collectionAttrib = (Property) stereotypeApplication.eGet(collectionAttribFeature) ;
		}
		return collectionAttrib;
	}
	
	public static boolean isAnIntervalType(Classifier visited) {
		if (visited.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType") != null) {
			return true ;
		}
		return false;
	}
	
	public static NamedElement getIntervalAttrib(Classifier visited) {
		NamedElement intervalAttrib = null ;
		Stereotype intervalStereotype = visited.
								getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType") ;
		if (intervalStereotype != null) {
			EObject stereotypeApplication = visited.getStereotypeApplication(intervalStereotype) ;
			EStructuralFeature intervalAttribFeature = stereotypeApplication.eClass().getEStructuralFeature("intervalAttrib") ;
			intervalAttrib = (Property) stereotypeApplication.eGet(intervalAttribFeature) ;
		}
		return intervalAttrib;
	}
}
