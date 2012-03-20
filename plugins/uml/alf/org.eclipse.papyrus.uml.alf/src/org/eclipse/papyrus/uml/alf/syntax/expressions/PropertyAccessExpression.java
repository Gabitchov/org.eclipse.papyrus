/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;

public class PropertyAccessExpression extends Expression {
	
	// Synthesized Properties
	public FeatureReference featureReference ; 
	
	// Derived Properties
	public ElementReference feature ; 
	
	//Constraints
	
	/*
	 * The assignments before the expression of the feature reference of a property access expression are the
	 * 	same as before the property access expression.
	 */
	public void checkPropertyAccessExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * The feature of a property access expression is the structural feature to which its feature reference
	 * 	resolves.
	 */
	public void checkPropertyAccessExpressionFeatureDerivation() {
		
	}
	
	/*
	 * The feature reference for a property access expression must resolve to a single structural feature.
	 */
	public void checkPropertyAccessExpressionFeatureResolution() {
		
	}
	
	/*
	 * The multiplicity upper bound of a property access expression is given by the product of the multiplicity
	 * 	upper bounds of the referenced feature and the target expression.
	 */
	public void checkPropertyAccessExpressionLowerDerivation() {
		
	}
	
	/*
	 * The type of a property access expression is the type of the referenced feature.
	 */
	public void checkPropertyAccessExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of a property access expression is given by the product of the multiplicity
	 * 	upper bounds of the referenced feature and the target expression.
	 */
	public void checkPropertyAccessExpressionUpperDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * The assignments after a property access expression are the same as those after the target expression of
	 * 	its feature reference.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
