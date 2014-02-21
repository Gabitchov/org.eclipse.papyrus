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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Facet is a virtual sub-type of an existing EClass. A Facet cannot be instantiated.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetElements <em>Facet Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetOperations <em>Facet Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getConformanceTypedElement <em>Conformance Typed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedFacets <em>Extended Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='( self.query.scope = self.facet.extendedMetaClass ) and ( self.query.name = self.name )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='self.conformanceQuery.scope = self.extendedMetaClass'"
 *        annotation="org.eclipse.ocl.ecore.OCL body='not(self.container().oclCastAs(FacetSet).facets->exists(f|f.extendedMetaClass.container() <> self.extendedMetaClass.container() ))'"
 * @generated
 */
public interface Facet extends EClassifier, DocumentedElement {
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
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet_ExtendedMetaclass()
	 * @model annotation="GenModel documentation='The \"extendedMetaclass\" reference references the virtually subtyped EClass.'"
	 * @generated
	 */
	EClass getExtendedMetaclass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Metaclass</em>' reference.
	 * @see #getExtendedMetaclass()
	 * @generated
	 */
	void setExtendedMetaclass(EClass value);

	/**
	 * Returns the value of the '<em><b>Facet Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This composite reference contains virtual attributes, references and operations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facet Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet_FacetElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<EStructuralFeature> getFacetElements();

	/**
	 * Returns the value of the '<em><b>Facet Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Operations</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet_FacetOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FacetOperation> getFacetOperations();

	/**
	 * Returns the value of the '<em><b>Conformance Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conformance Typed Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conformance Typed Element</em>' reference.
	 * @see #setConformanceTypedElement(ETypedElement)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet_ConformanceTypedElement()
	 * @model
	 * @generated
	 */
	ETypedElement getConformanceTypedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getConformanceTypedElement <em>Conformance Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conformance Typed Element</em>' reference.
	 * @see #getConformanceTypedElement()
	 * @generated
	 */
	void setConformanceTypedElement(ETypedElement value);

	/**
	 * Returns the value of the '<em><b>Extended Facets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Facets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Facets</em>' reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacet_ExtendedFacets()
	 * @model annotation="GenModel documentation='A facet can extend other facets. If A facet A can extend a facet B. In this case an eObject conforms to the facet A if it matches conformance evaluation of A and B. '"
	 * @generated
	 * @since 0.2
	 */
	EList<Facet> getExtendedFacets();

} // Facet
