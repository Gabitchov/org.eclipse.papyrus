/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.reverse.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.operations.TypeOperations;


/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Type#createAssociation(boolean, org.eclipse.uml2.uml.AggregationKind, java.lang.String, int, int, org.eclipse.uml2.uml.Type, boolean, org.eclipse.uml2.uml.AggregationKind, java.lang.String, int, int) <em>Create Association</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Type#getAssociations() <em>Get Associations</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Type#conformsTo(org.eclipse.uml2.uml.Type) <em>Conforms To</em>}</li>
 * </ul>
 * </p>
 *
 * @copyright copied from org.eclipse.uml2.uml.internal.operations.TypeOperations
 */
public class TypeOperationsEnhanced extends TypeOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeOperationsEnhanced() {
		super();
	}

	protected static Property setAssociationEnd(Property property,
			Association association, boolean isNavigable,
			AggregationKind aggregation) {
		
		Property associationEnd = property;

		associationEnd.setAggregation(aggregation);

		if (isNavigable) {
			association.getMemberEnds().add(associationEnd);
		}

		return associationEnd;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a(n) (binary) association between this type and the specified other type, with the specified navigabilities, aggregations, names, lower bounds, and upper bounds, and owned by this type's nearest package.
	 * @param type The receiving '<em><b>Type</b></em>' model object.
	 * @param end1IsNavigable The navigability for the first end of the new association.
	 * @param end1Aggregation The aggregation for the first end of the new association.
	 * @param end1Name The name for the first end of the new association.
	 * @param end1Lower The lower bound for the first end of the new association.
	 * @param end1Upper The upper bound for the first end of the new association.
	 * @param end1Type The type for the first end of the new association.
	 * @param end2IsNavigable The navigability for the second end of the new association.
	 * @param end2Aggregation The aggregation for the second end of the new association.
	 * @param end2Name The name for the second end of the new association.
	 * @param end2Lower The lower bound for the second end of the new association.
	 * @param end2Upper The upper bound for the second end of the new association.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static Association createAssociationFromProperty(Property property,
			boolean end1IsNavigable, AggregationKind end1Aggregation, 
			boolean end2IsNavigable, AggregationKind end2Aggregation,
			String end2Name, int end2Lower, int end2Upper) {
		return createAssociationFromProperty(property, end1IsNavigable, end1Aggregation,
				end2IsNavigable, end2Aggregation,
			end2Name, end2Lower, end2Upper, 
			UMLPackage.Literals.ASSOCIATION);
	}

	/**
	 * 
	 * @param property
	 * @param end1IsNavigable
	 * @param end1Aggregation
	 * @param end2IsNavigable
	 * @param end2Aggregation
	 * @param end2Name
	 * @param end2Lower
	 * @param end2Upper
	 * @param eClass
	 * @return
	 */
	protected static Association createAssociationFromProperty(Property property,
			boolean end1IsNavigable, AggregationKind end1Aggregation, 
			boolean end2IsNavigable, AggregationKind end2Aggregation,
			String end2Name, int end2Lower, int end2Upper, 
			 EClass eClass) {
		
		// Check if there the property is already part of an association
		if( property.getAssociation() != null ) {
			return property.getAssociation();
		}
		
		// Get owner (end2Type)	
		Type type;
		try {
			type = (Type)property.getOwner();
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Property's owner should be a Type");
		}

		Type end1Type = property.getType();
		// Validate end1 
		validateTypeAndBounds(end1Type, end2Lower, end2Upper);

		
		org.eclipse.uml2.uml.Package package_ = type.getNearestPackage();

		if (package_ == null) {
			throw new IllegalStateException();
		}

		if (end1Aggregation == null) {
			throw new IllegalArgumentException(String.valueOf(end1Aggregation));
		}

		if (end2Aggregation == null) {
			throw new IllegalArgumentException(String.valueOf(end2Aggregation));
		}

		Association association = (Association) package_.createOwnedType(null, eClass);
		association.setName("A_" + property.getName() + "_" + end2Name);
		
		// Set end1
//		createAssociationEnd(type, association, end1IsNavigable,
//			end1Aggregation, end1Name, end1Lower, end1Upper, end1Type);
		setAssociationEnd( property, association, end1IsNavigable,
				end1Aggregation);

		createAssociationEnd(end1Type, association, end2IsNavigable,
				end2Aggregation, end2Name, end2Lower, end2Upper, type);



		

		return association;
	}

} // TypeOperations