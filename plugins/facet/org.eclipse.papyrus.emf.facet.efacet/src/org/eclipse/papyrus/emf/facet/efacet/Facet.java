/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 *  
 */
package org.eclipse.papyrus.emf.facet.efacet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A facet is a virtual sub type of an existing EClass. A Facet cannot be instantiated.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetSet <em>Facet Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getConformanceQuery <em>Conformance Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetElements <em>Facet Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getFacet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='( self.query.scope = self.facet.extendedMetaClass ) and ( self.query.name = self.name )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='self.conformanceQuery.scope = self.extendedMetaClass'"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface Facet extends EClassifier {
	/**
	 * Returns the value of the '<em><b>Facet Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet#getFacets <em>Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Set</em>' container reference.
	 * @see #setFacetSet(FacetSet)
	 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getFacet_FacetSet()
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet#getFacets
	 * @model opposite="facets" transient="false"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	FacetSet getFacetSet();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetSet <em>Facet Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Set</em>' container reference.
	 * @see #getFacetSet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setFacetSet(FacetSet value);

	/**
	 * Returns the value of the '<em><b>Conformance Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conformance Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conformance Query</em>' containment reference.
	 * @see #setConformanceQuery(Query)
	 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getFacet_ConformanceQuery()
	 * @model containment="true"
	 *        annotation="GenModel documentation='The \"conformanceQuery\" references points to the ModelQuery class. The model queries pointed to by the \"conformanceQuery\" reference must return a Boolean. Those queries are used to specify how to decide whether an instance conforms to a facet. If the \"conditionQuery\" is empty then all the instances of the class referred to by the facet instance through the eSuperType reference conform to this facet. '"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	Query getConformanceQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getConformanceQuery <em>Conformance Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conformance Query</em>' containment reference.
	 * @see #getConformanceQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setConformanceQuery(Query value);

	/**
	 * Returns the value of the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Metaclass</em>' reference.
	 * @see #setExtendedMetaclass(EClass)
	 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getFacet_ExtendedMetaclass()
	 * @model annotation="GenModel documentation='The \"extendedMetaclass\" reference references the virtually subtyped EClass.'"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getExtendedMetaclass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Metaclass</em>' reference.
	 * @see #getExtendedMetaclass()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setExtendedMetaclass(EClass value);

	/**
	 * Returns the value of the '<em><b>Facet Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.efacet.FacetElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This composite reference contains virtual attributes, references and operations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facet Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getFacet_FacetElements()
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement#getFacet
	 * @model opposite="facet" containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<FacetElement> getFacetElements();

} // Facet
