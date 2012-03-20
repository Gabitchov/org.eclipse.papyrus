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

public class FeatureLeftHandSide extends LeftHandSide {

	// Synthesized Properties
	public FeatureReference feature ;
	
	// Constraints
	
	/*
	 * The assignments after a feature left-hand side are the assignments after the expression of the feature
	 * 	reference or, if there is an index, those after the index expression.
	 */
	public void checkFeatureLeftHandSideAssignmentAfterDerivation() {
		
	}
	
	/*
	 * The assignments before the expression of the feature reference of a feature left-hand side are the
	 * 	assignments before the feature left-hand side.
	 */
	public void checkFeatureLeftHandSideAssignmentBeforeDerivation() {
		
	}
	
	/*
	 * If a feature left-hand side has an index, then the assignments before the index expression are the
	 * 	assignments after the expression of the feature reference.
	 */
	public void checkFeatureLeftHandSideAssignmentsBefore() {
		
	}
	
	/*
	 * The expression of the feature reference of a feature left-hand side must have a multiplicity upper bound
	 * 	of 1.
	 */
	public void checkFeatureLeftHandSideFeatureExpression() {
		
	}
	
}
