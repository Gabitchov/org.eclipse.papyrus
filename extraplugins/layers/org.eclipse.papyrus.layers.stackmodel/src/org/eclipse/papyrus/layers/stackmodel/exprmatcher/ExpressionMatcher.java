/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.util.NotyfyingList;

import com.google.common.collect.Lists;

/**
 * This class evaluate its associated expression against the associated models.
 * It provide a list of elements matching the expression in the model.
 * It fire some events when the list of matching elements change.
 * The expression is evaluated  each time a change impacting the result occurs in the model.
 * 
 * It maybe necessary to adjust the listeners on model changes to improve performances.
 * 
 * @author cedric dumoulin
 *
 */
public class ExpressionMatcher {

	protected String expression="";
	
	/**
	 * List of element matching the expression.
	 * This class maintains the list.
	 */
	protected NotyfyingList<View> matchingElements;
	
	/**
	 * List of element used as starting point for search.
	 */
	protected List<EObject> searchRoots;
	
	/**
	 * OCL Condition computed from the expr.
	 */
	protected EObjectCondition  condition;
	protected OCL ocl;
	

	public ExpressionMatcher() {
		this.expression = "";
		this.searchRoots = Collections.emptyList();
		// init matchingElements
		matchingElements = new NotyfyingList<View>(new ArrayList<View>());
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param searchRoots
	 * @throws LayersException
	 */
	public ExpressionMatcher(List<EObject> searchRoots) {
		this.expression = "";
		this.searchRoots = searchRoots;
		// init matchingElements
		matchingElements = new NotyfyingList<View>(new ArrayList<View>());
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param searchRoot
	 * @throws LayersException
	 */
	public ExpressionMatcher(EObject searchRoot) {
		this(Collections.singletonList(searchRoot));
	}
	
	/**
	 * Constructor.
	 *
	 * @param expression
	 * @param searchRoots
	 * @throws LayersException If the Condition can't be computed from the expression.
	 */
	public ExpressionMatcher(String expression, List<EObject> searchRoots) throws LayersException {
		this.searchRoots = searchRoots;
		matchingElements = new NotyfyingList<View>(new ArrayList<View>());
		
		// compute expr
		setExpression(expression);
	}

	/**
	 * Constructor.
	 *
	 * @param expression
	 * @param searchRoots
	 * @throws LayersException If the Condition can't be computed from the expression.
	 */
	public ExpressionMatcher(String expression, EObject searchRoot) throws LayersException {
		this(expression, Collections.singletonList(searchRoot));
	}

	/**
	 * Compute the condition from the expr.
	 */
	private void computeCondition() throws LayersException {
		// silently fails if the expr is not set.
		if( getExpression() == null || getExpression().length() == 0) {
			return;
		}
		
		if( ocl == null) {
		  ocl = OCL.newInstance();
		}
		// Create the condition
		try {
			// If the 3rd args is null, this is a context free condition.
			
			condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    ocl.getEnvironment(),
//			    "self.oclIsKindOf(Shape)",
//			    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//				    "self.oclAsType(Shape).visible = true",
				    getExpression(),
				    NotationPackage.Literals.VIEW
//				    null
				    );
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			condition = null;
			throw new LayersException("Can't parse expression : " + e.getMessage(), e);
		}
		
	}

	/**
	 * Recompute the matching elements.
	 * This lead to firing Events (added and removed)
	 */
	public void refreshMatchingElements() {
		

		if( condition == null) {
			// If the condition is not set, the list should be empty
			if( !getMatchingElements().isEmpty()) {
				resetMatchingElements( Collections.EMPTY_LIST);
			}
			return;
		}
		
		// Create the OCL statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(getSearchRoots()), new WHERE(condition),
			new NullProgressMonitor());

		// Execute the OCL statement
		IQueryResult results = statement.execute();

		/**
		 * Reset the matching elements with the new result.
		 */
		resetMatchingElements( results);
	}
	
	/**
	 * Reset the {@link #matchingElements} and let it contain the specified collection.
	 * This fire added and removed events.
	 * 
	 * @param results
	 */
	private void resetMatchingElements(Collection<?> newElements) {
		
		matchingElements.resetTo((Collection<View>)newElements);
		
//		// Compute views to add
//		// This are views in the newElements, but not in the actual list of matchingElement
//		// viewsToAdd = results - getViews()
//		List<View> viewsToAdd = new ArrayList<View>();
//		for( Object o : newElements ) {
//			View v = (View)o;
//			if( !getMatchingElements().contains(v)) {
//				viewsToAdd.add(v);
//			}
//		}
//		
//		// Compute views to remove
//		// Their is two ways to compute it:
//		//    - viewsToremove = diagramViews - results
//		//    - or viewsToremove = getViews() - result  
//		// Use the cheaper one.
//		// The computed viewsToRemove list contains also views that are not in the layer,
//		// But this is cheaper than checking for the existence.
//		
////		List<View> viewsToRemove = new ArrayList<View>();
////		for( View v : (views.size()<getViews().size()?views:getViews()) ) {
////			if( !results.contains(v)) {
////				viewsToRemove.add(v);
////			}
////		}
//		
//		// Do operations
//		getMatchingElements().retainAll(newElements);
////		getViews().removeAll(viewsToRemove);
//		getMatchingElements().addAll(viewsToAdd);
		
	}

	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}


	/**
	 * @param expression the expression to set
	 * @throws LayersException If the Condition can't be computed from the expression.
	 */
	public void setExpression(String expression) throws LayersException {
		
		if( expression == null || expression.length() == 0 ) {
			// standardize noop expr
			expression = "";
		}
		if( expression.equals(this.expression)) {
			return;
		}
		
		this.expression = expression;
		
		computeCondition();
		refreshMatchingElements();
	}


	/**
	 * @return the matchingElements
	 */
	public NotyfyingList<View> getMatchingElements() {
		return matchingElements;
	}


	/**
	 * @return the searchRoots
	 */
	public List<EObject> getSearchRoots() {
		return searchRoots;
	}

	/**
	 * 
	 * @param searchRoots
	 */
	public void setSearchRoots(List<EObject> searchRoots) {
		if( searchRoots == null) {
			searchRoots = Collections.emptyList();
		}
		this.searchRoots = searchRoots;
		// Do not refresh. Let user do it.
	}

	/**
	 * 
	 * @param searchRoots
	 */
	public void setSearchRoots(EObject searchRoot) {
		if( searchRoot == null) {
			searchRoots = Collections.emptyList();
			return;
		}

		setSearchRoots( Collections.singletonList(searchRoot) );
	}

	
}
