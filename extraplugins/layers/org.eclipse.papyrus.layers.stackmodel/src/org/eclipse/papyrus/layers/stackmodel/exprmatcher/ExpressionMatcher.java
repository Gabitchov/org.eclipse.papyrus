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
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.papyrus.layers.stackmodel.util.Collections3;
import org.eclipse.papyrus.layers.stackmodel.util.ObservableListView;

/**
 * This class evaluate its associated expression against the associated models.
 * It provide a list of elements matching the expression in the model.
 * The list of matching elements is synchronized by the matcher. The list can be provided  at construction 
 * time. The ExpressinMatcher takes care to minimize the number of write to the underlying list of matching elements.
 * Usually, there is two writes (see {@link Collections3#resetListTo(Collection, Collection)}.
 * <br>
 * It is possible to be inform of changes in the underlying list by wrapping it in an {@link ObservableListView}.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class ExpressionMatcher implements IValueChangedEventListener {

	protected String expression="";
	
	/**
	 * List of element matching the expression.
	 * This class maintains the list.
	 */
	protected List<View> matchingElements;
	
	/**
	 * List of element used as starting point for search.
	 */
	protected List<EObject> searchRoots;
	
	/**
	 * OCL Condition computed from the expr.
	 */
	protected EObjectCondition  condition;
	protected OCL ocl;
	

	/**
	 * 
	 * Constructor.
	 *
	 */
	public ExpressionMatcher() {
		this.expression = "";
		this.searchRoots = Collections.emptyList();
		// init matchingElements
		matchingElements = new ArrayList<View>();
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param searchRoots
	 * @throws LayersException
	 */
	public ExpressionMatcher(List<View> matchingElementsList) {
		this.expression = "";
		this.searchRoots = Collections.emptyList();
		// init matchingElements
		matchingElements = matchingElementsList;
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param searchRoots
	 * @throws LayersException
	 */
//	public ExpressionMatcher(List<EObject> searchRoots) {
//		this.expression = "";
//		setSearchRoots(searchRoots);
//		// init matchingElements
//		matchingElements = new ObservableListView<View>(new ArrayList<View>());
//	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param searchRoot
	 * @throws LayersException
	 */
	public ExpressionMatcher(EObject searchRoot) {
		this.expression = "";
		setSearchRoots(Collections.singletonList(searchRoot));
		// init matchingElements
		matchingElements = new ArrayList<View>();
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
		matchingElements = new ArrayList<View>();
		
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
	public ExpressionMatcher(String expression, List<View> matchingElementsList, List<EObject> searchRoots) throws LayersException {
		this.searchRoots = searchRoots;
		matchingElements = matchingElementsList;
		
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
	 * Constructor.
	 *
	 * @param expression
	 * @param searchRoots
	 * @throws LayersException If the Condition can't be computed from the expression.
	 */
	public ExpressionMatcher(String expression, List<View> matchingElementsList, EObject searchRoot) throws LayersException {
		this(expression, matchingElementsList, Collections.singletonList(searchRoot));
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
	@SuppressWarnings("unchecked")
	private void resetMatchingElements(Collection<?> newElements) {
		
		Collections3.resetListTo(matchingElements, (Collection<View>)newElements);
//		matchingElements.resetTo((Collection<View>)newElements);
		
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
	public List<View> getMatchingElements() {
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
		
		// Remove any existing observers
			removeSearchRootsObservers();
		
		if( searchRoots == null) {
			searchRoots = Collections.emptyList();
		}
		this.searchRoots = searchRoots;
		// add observers on roots changes
			addSearchRootsObservers();
		
		// Do not refresh. Let user do it.
	}

	/**
	 * 
	 * @param searchRoots
	 */
	public void setSearchRoots(EObject searchRoot) {
		if( searchRoot == null) {
			// Remove any existing observers
			removeSearchRootsObservers();
			searchRoots = Collections.emptyList();
			return;
		}

		setSearchRoots( Collections.singletonList(searchRoot) );
	}

	/**
	 * Observes all searchRoots for changes. If a change occurs, refresh the matching elements.
	 * 
	 */
	protected void addSearchRootsObservers() {
		
		if( searchRoots == null) {
			return;
		}

		
		for( EObject root : searchRoots) {
		  ValueChangedEventNotifier notifier = ValueChangedEventNotifierFactory.instance.adapt(root);
		  notifier.addEventListener(this);
		}
	}
	
	/**
	 * Observes all searchRoots for changes. If a change occurs, refresh the matching elements.
	 * 
	 */
	protected void removeSearchRootsObservers() {
		
		if( searchRoots == null) {
			return;
		}
		
		for( EObject root : searchRoots) {
		  ValueChangedEventNotifier notifier = ValueChangedEventNotifierFactory.instance.adapt(root);
		  notifier.removeEventListener(this);
		}
	}

	/** 
	 * Called when a value change in one of the elements of the observed  roots.
	 * @param msg
	 */
	@Override
	public void valueChanged(Notification msg) {
		refreshMatchingElements();
	}
	
	
}
