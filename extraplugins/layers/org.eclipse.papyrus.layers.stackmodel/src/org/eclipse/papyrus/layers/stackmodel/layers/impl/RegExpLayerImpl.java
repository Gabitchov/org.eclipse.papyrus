/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.EventLevel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener;
import org.eclipse.papyrus.layers.stackmodel.util.ObservableListView;

import com.google.common.eventbus.Subscribe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Exp Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#isDomainChangedEventDependant <em>Is Domain Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getDomainChangedEventLevel <em>Domain Changed Event Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#isDiagramChangedEventDependant <em>Is Diagram Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getDiagramChangedEventLevel <em>Diagram Changed Event Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#getExpressionContextObjectType <em>Expression Context Object Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegExpLayerImpl extends AbstractLayerImpl implements RegExpLayer {
	/**
	 * The default value of the '{@link #getExpr() <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected String expr = EXPR_EDEFAULT;
	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDomainChangedEventDependant() <em>Is Domain Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDomainChangedEventDependant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DOMAIN_CHANGED_EVENT_DEPENDANT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDomainChangedEventDependant() <em>Is Domain Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDomainChangedEventDependant()
	 * @generated
	 * @ordered
	 */
	protected boolean isDomainChangedEventDependant = IS_DOMAIN_CHANGED_EVENT_DEPENDANT_EDEFAULT;
	/**
	 * The default value of the '{@link #getDomainChangedEventLevel() <em>Domain Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainChangedEventLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EventLevel DOMAIN_CHANGED_EVENT_LEVEL_EDEFAULT = EventLevel.LEVEL1;
	/**
	 * The cached value of the '{@link #getDomainChangedEventLevel() <em>Domain Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainChangedEventLevel()
	 * @generated
	 * @ordered
	 */
	protected EventLevel domainChangedEventLevel = DOMAIN_CHANGED_EVENT_LEVEL_EDEFAULT;
	/**
	 * The default value of the '{@link #isDiagramChangedEventDependant() <em>Is Diagram Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiagramChangedEventDependant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DIAGRAM_CHANGED_EVENT_DEPENDANT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDiagramChangedEventDependant() <em>Is Diagram Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiagramChangedEventDependant()
	 * @generated
	 * @ordered
	 */
	protected boolean isDiagramChangedEventDependant = IS_DIAGRAM_CHANGED_EVENT_DEPENDANT_EDEFAULT;
	/**
	 * The default value of the '{@link #getDiagramChangedEventLevel() <em>Diagram Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramChangedEventLevel()
	 * @generated
	 * @ordered
	 */
	protected static final EventLevel DIAGRAM_CHANGED_EVENT_LEVEL_EDEFAULT = EventLevel.LEVEL1;
	/**
	 * The cached value of the '{@link #getDiagramChangedEventLevel() <em>Diagram Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramChangedEventLevel()
	 * @generated
	 * @ordered
	 */
	protected EventLevel diagramChangedEventLevel = DIAGRAM_CHANGED_EVENT_LEVEL_EDEFAULT;
	/**
	 * The default value of the '{@link #getExpressionContextObjectType() <em>Expression Context Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionContextObjectType()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_CONTEXT_OBJECT_TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExpressionContextObjectType() <em>Expression Context Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionContextObjectType()
	 * @generated
	 * @ordered
	 */
	protected String expressionContextObjectType = EXPRESSION_CONTEXT_OBJECT_TYPE_EDEFAULT;

	protected DiagramViewEventNotifier diagramViewEventNotifier;
	
	/**
	 * Expression matcher computing the expr, and firing events when the matching elements change.
	 */
	protected ExpressionMatcher expressionMatcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RegExpLayerImpl() {
		super();

		// Initialize expressionmatcher
		// The expression Macher use this class views list.
		// When expressionMatcher::refreshMatchingElements() is called, the provided list is refreshed.
		// So,  views is synchronized and events are fired.
		expressionMatcher = new ExpressionMatcher(getViews());
		resetExpressionMatcherRoots();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.REG_EXP_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpr() {
		return expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpr(String newExpr) {
		String oldExpr = expr;
		expr = newExpr;
		// Try to set the expression
		try {
			// Check synchro between RegExp::views and ExpressionMatcher::matchingElements
			// they can be unsync after the model was loaded by EMF
			checkViewsAndMatchingElementsSync();
			// First, reset expr roots. Do it because actually the roots are not properly set.
			resetExpressionMatcherRoots();
			// Change the expression, and recompute the matching elements.
			expressionMatcher.setExpression(newExpr);
			expressionMatcher.refreshMatchingElements();
		} catch (LayersException e) {
			// silently fails, but log the error.
			System.err.println( "Error - " + this.getClass().getSimpleName() + " - " + e.getMessage());
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__EXPR, oldExpr, expr));
	}

	/**
	 * Check synchro between RegExp::views and ExpressionMatcher::matchingElements
	 * they can be unsync after the model was loaded by EMF.
	 * <b>
	 * This method is used to correct the bug where both list are unsync after the model was loaded by EMF.
	 * @Deprecated Not needed anymore
	 */
	private void checkViewsAndMatchingElementsSync() {
		
//		// Check if both list have the same size.
//		// We don't to check the content, because we want a quick check
//		// Actually, unsync appear only after the model was reloded by EMF.
//		if( getViews().size() == expressionMatcher.getMatchingElements().size() ) {
//			// ok
//			return;
//		}
//		
//		// Sync is required
//		List<View> matchElements = expressionMatcher.getMatchingElements().getUnnotifyingList();
//		matchElements.clear();
//		matchElements.addAll(getViews());
		
	}

	/**
	 * OCL Condition computed from the expr.
	 */
	protected EObjectCondition  condition;
	protected OCL ocl;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDomainChangedEventDependant() {
		return isDomainChangedEventDependant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDomainChangedEventDependant(boolean newIsDomainChangedEventDependant) {
		boolean oldIsDomainChangedEventDependant = isDomainChangedEventDependant;
		isDomainChangedEventDependant = newIsDomainChangedEventDependant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT, oldIsDomainChangedEventDependant, isDomainChangedEventDependant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventLevel getDomainChangedEventLevel() {
		return domainChangedEventLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainChangedEventLevel(EventLevel newDomainChangedEventLevel) {
		EventLevel oldDomainChangedEventLevel = domainChangedEventLevel;
		domainChangedEventLevel = newDomainChangedEventLevel == null ? DOMAIN_CHANGED_EVENT_LEVEL_EDEFAULT : newDomainChangedEventLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL, oldDomainChangedEventLevel, domainChangedEventLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDiagramChangedEventDependant() {
		return isDiagramChangedEventDependant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDiagramChangedEventDependant(boolean newIsDiagramChangedEventDependant) {
		boolean oldIsDiagramChangedEventDependant = isDiagramChangedEventDependant;
		isDiagramChangedEventDependant = newIsDiagramChangedEventDependant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT, oldIsDiagramChangedEventDependant, isDiagramChangedEventDependant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventLevel getDiagramChangedEventLevel() {
		return diagramChangedEventLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramChangedEventLevel(EventLevel newDiagramChangedEventLevel) {
		EventLevel oldDiagramChangedEventLevel = diagramChangedEventLevel;
		diagramChangedEventLevel = newDiagramChangedEventLevel == null ? DIAGRAM_CHANGED_EVENT_LEVEL_EDEFAULT : newDiagramChangedEventLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL, oldDiagramChangedEventLevel, diagramChangedEventLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionContextObjectType() {
		return expressionContextObjectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionContextObjectType(String newExpressionContextObjectType) {
		String oldExpressionContextObjectType = expressionContextObjectType;
		expressionContextObjectType = newExpressionContextObjectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE, oldExpressionContextObjectType, expressionContextObjectType));
	}
		
	/**
	 * Listener on {@link ObservableListView} eventBus. This method is called each time a change occurs in the 
	 * result of the expression.
	 * When the result change, the list of attached views is updated accordingly.
	 * 
	 * 
	 * @param event
	 */
	@Subscribe
	public void expressionResultChanged( ObservableListView<View>.ObservableListEvent event) {
		
		System.out.println( this.getClass().getSimpleName() + ".expressionResultChanged()");
		if( ! event.getAddedElements().isEmpty()) {
			getViews().addAll(event.getAddedElements());
		}
		if( ! event.getRemovedElements().isEmpty()) {
			getViews().removeAll(event.getRemovedElements());
		}

	}
	
	/**
	 * This layer has just been added to a LayerStack.
	 * Set the root of the expression.
	 * Set the views to match the result of the expression.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#initLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)
	 *
	 * @param owningLayersStack
	 */
	@Override
	public void initLayer(LayersStack owningLayersStack) {
		super.initLayer(owningLayersStack);
		
		resetExpressionMatcherRoots();
		checkViewsAndMatchingElementsSync();
		
//		// Synchronize the layer views with the result of expressionMatcher.
//		// Try to minimize the number of events.
//		// For that, freeze temporarily the events from this layer
//		// Refresh the result and reset the views list while events are disabled.
//		boolean isDeliveringEvents = eDeliver();
//		eSetDeliver(false);
//		
//		expressionMatcher.refreshMatchingElements();
//		List<View> toAdd = expressionMatcher.getMatchingElements();
//		if( !toAdd.isEmpty() ) {
//			getViews().clear();
//		}
//		
//		// Reenable events 
//		eSetDeliver(true);
//		
//		// Set the views
//		
//		if( !toAdd.isEmpty() ) {
//		   getViews().addAll(expressionMatcher.getMatchingElements());
//		}
//		else {
//			// If there is nothing to add, clear the list, in order to send appropriate event.
//			getViews().clear();
//		}
		
		
	}
	
	/**
	 * Check if the associated Diagram has changed, and if true, change it in the ExpressionMatcher.
	 * This does not compute the result.
	 */
	private void resetExpressionMatcherRoots() {
	
		try {
			expressionMatcher.setSearchRoots( getLayersStack().getDiagram() );
		} catch (NotFoundException e) {
			// layerStack not found ==> no roots
			expressionMatcher.setSearchRoots( (List<EObject>)Collections.EMPTY_LIST);
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param newLayerParent 
	 * @generated NOT
	 * @deprecated not used
	 */
	public void activate(AbstractLayerOperator newLayerParent) {

//		LayersStack layersStack;
//		try {
//			layersStack = newLayerParent.getLayersStack();
//		} catch (NotFoundException e) {
//			// silently fails
//			return;
//		}
//		
//		// Listen on view events
//		if(diagramViewEventNotifier == null) {
//			diagramViewEventNotifier = new DiagramViewEventNotifier(layersStack.getDiagram());
//			return;
//		}
		
//		diagramViewEventNotifier.
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param oldParentLayer 
	 * @generated NOT
	 * @deprecated
	 */
	public void deactivate(AbstractLayerOperator oldParentLayer) {
		
//		if( oldParentLayer == null) {
//			return;
//		}
//		
//		LayersStack layersStack;
//		try {
//			layersStack = oldParentLayer.getLayersStack();
//		} catch (NotFoundException e) {
//			// silently fails
//			return;
//		}
//		
//		layersStack.getDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDerivedView(View view) throws LayersException {

		if(condition == null) {
			return false;
		}
		
		// Create the OCL statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(view), new WHERE(condition),
			new NullProgressMonitor());

		// Execute the OCL statement
		IQueryResult results = statement.execute();

		// the view is derived if the condition match the view.
		return !results.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Check if the view satisfy the expr condition.
	 * If the condition is satisfied, ensure that the view is attached.
	 * If the condition is not satisfied, ensure that the view is not attached.
	 * 
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void attachDerivedView(View view) throws LayersException {
		// TODO: implement this method
		if(condition == null) {
			return;
		}
		
		// Create the OCL statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(view), new WHERE(condition),
			new NullProgressMonitor());

		// Execute the OCL statement
		IQueryResult results = statement.execute();
		
		//
		if( ! results.isEmpty()) {
			// The condition is satisfied. Ensure the view is attached
			List<View> attachedViews = getViews();
			if (attachedViews.contains(view)) {
				return;
			}
			attachedViews.add(view);
		} 
		else {
			// The condition is not satisfied. Ensure the view is not attached.
			getViews().remove(view);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Attach each view that satisfy the condition.
	 * Detach each view that do not satisfy the condition.
	 * TODO rename to updateDerivedViews() ?
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void attachDerivedViews(EList<View> views) throws LayersException {

		if(condition == null) {
			return;
		}
		
		// Create the OCL statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(views), new WHERE(condition),
			new NullProgressMonitor());

		// Execute the OCL statement
		IQueryResult results = statement.execute();
		
		// viewsToCheck
		// attachedViews -- list of views that are attached
		//    -- getViews()
		// viewsToAttach -- list of views that should be attached
		//    -- query result
		// toAdd - views that are in viewsToAttach, but not in attachedViews
		//    -- 
		// toRemove - views that are in attachedViews, and viewsToCheck, but not in viewsToAttach
		
		// Compute views to add
		// This are views in the result, but not in the list of attached
		// viewsToAdd = results - getViews()
		List<View> viewsToAdd = new ArrayList<View>();
		List<View> attachedViews = getViews();
		for( Object o : results ) {
			View v = (View)o;
			if( !attachedViews.contains(v)) {
				viewsToAdd.add(v);
			}
		}
		
		// Compute views to remove
		// Their is two ways to compute it:
		//    - viewsToremove = diagramViews - results
		//    - or viewsToremove = getViews() - result  
		// Use the cheaper one.
		// The computed viewsToRemove list contains also views that are not in the layer,
		// But this is cheaper than checking for the existence.
		
		List<View> viewsToRemove = new ArrayList<View>();
		for( View v : (views.size()<getViews().size()?views:getViews()) ) {
			if( !results.contains(v)) {
				viewsToRemove.add(v);
			}
		}
		
		// Do operations
		getViews().removeAll(viewsToRemove);
		getViews().addAll(viewsToAdd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Update all views directly own by the diagram.
	 * 
	 * If a view satisfy the expr condition, attach it to the Layer.
	 * Remove all others view from the layer.
	 * <br>
	 * To avoid multiple events, we compute the list of views to remove from the layer, and the list
	 * of views to add to layer. Then, we preform two operations; removeAll(toRemove) and addAll(toAdd);
	 *
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void attachDerivedViews() throws LayersException {
		
		if(condition == null) {
			return;
		}
		
		// Check views from the diagram.
		@SuppressWarnings("unchecked")
		EList<View> diagramViews = (EList<View>)getLayersStack().getDiagram().getChildren();

		// Create the OCL statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(diagramViews), new WHERE(condition),
			new NullProgressMonitor());

		// Execute the OCL statement
		IQueryResult results = statement.execute();
		
		// Compute views to add
		// This are views in the result, but not in the list of attached
		// viewsToAdd = results - getViews()
		List<View> viewsToAdd = new ArrayList<View>();
		List<View> attachedViews = getViews();
		for( Object o : results ) {
			View v = (View)o;
			if( !attachedViews.contains(v)) {
				viewsToAdd.add(v);
			}
		}
		
		// Compute views to remove
		// Their is two ways to compute it:
		//    - viewsToremove = diagramViews - results
		//    - or viewsToremove = getViews() - result  
		// Use the cheaper one.
		// The computed viewsToRemove list contains also views that are not in the layer,
		// But this is cheaper than checking for the existence.
		
//		List<View> viewsToRemove = new ArrayList<View>();
//		for( View v : (views.size()<getViews().size()?views:getViews()) ) {
//			if( !results.contains(v)) {
//				viewsToRemove.add(v);
//			}
//		}
		
		// Do operations
		getViews().retainAll(results);
//		getViews().removeAll(viewsToRemove);
		getViews().addAll(viewsToAdd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<View> lookupDerivedViews(EList<View> views) throws LayersException {
//		if(condition == null) {
//			return EList.EMPTY_LIST;
//		}
//		
//		// Check views from the diagram.
//		@SuppressWarnings("unchecked")
//		EList<View> diagramViews = (EList<View>)getLayersStack().getDiagram().getChildren();
//
//		// Create the OCL statement
//		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
//			new FROM(diagramViews), new WHERE(condition),
//			new NullProgressMonitor());
//
//		// Execute the OCL statement
//		IQueryResult results = statement.execute();
//		return new ;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
				return getExpr();
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				return getLanguage();
			case LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT:
				return isDomainChangedEventDependant();
			case LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL:
				return getDomainChangedEventLevel();
			case LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT:
				return isDiagramChangedEventDependant();
			case LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL:
				return getDiagramChangedEventLevel();
			case LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE:
				return getExpressionContextObjectType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
				setExpr((String)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT:
				setIsDomainChangedEventDependant((Boolean)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL:
				setDomainChangedEventLevel((EventLevel)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT:
				setIsDiagramChangedEventDependant((Boolean)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL:
				setDiagramChangedEventLevel((EventLevel)newValue);
				return;
			case LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE:
				setExpressionContextObjectType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
				setExpr(EXPR_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT:
				setIsDomainChangedEventDependant(IS_DOMAIN_CHANGED_EVENT_DEPENDANT_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL:
				setDomainChangedEventLevel(DOMAIN_CHANGED_EVENT_LEVEL_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT:
				setIsDiagramChangedEventDependant(IS_DIAGRAM_CHANGED_EVENT_DEPENDANT_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL:
				setDiagramChangedEventLevel(DIAGRAM_CHANGED_EVENT_LEVEL_EDEFAULT);
				return;
			case LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE:
				setExpressionContextObjectType(EXPRESSION_CONTEXT_OBJECT_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
				return EXPR_EDEFAULT == null ? expr != null : !EXPR_EDEFAULT.equals(expr);
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT:
				return isDomainChangedEventDependant != IS_DOMAIN_CHANGED_EVENT_DEPENDANT_EDEFAULT;
			case LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL:
				return domainChangedEventLevel != DOMAIN_CHANGED_EVENT_LEVEL_EDEFAULT;
			case LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT:
				return isDiagramChangedEventDependant != IS_DIAGRAM_CHANGED_EVENT_DEPENDANT_EDEFAULT;
			case LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL:
				return diagramChangedEventLevel != DIAGRAM_CHANGED_EVENT_LEVEL_EDEFAULT;
			case LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE:
				return EXPRESSION_CONTEXT_OBJECT_TYPE_EDEFAULT == null ? expressionContextObjectType != null : !EXPRESSION_CONTEXT_OBJECT_TYPE_EDEFAULT.equals(expressionContextObjectType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.REG_EXP_LAYER___ACTIVATE__ABSTRACTLAYEROPERATOR:
				activate((AbstractLayerOperator)arguments.get(0));
				return null;
			case LayersPackage.REG_EXP_LAYER___DEACTIVATE__ABSTRACTLAYEROPERATOR:
				deactivate((AbstractLayerOperator)arguments.get(0));
				return null;
			case LayersPackage.REG_EXP_LAYER___IS_DERIVED_VIEW__VIEW:
				try {
					return isDerivedView((View)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.REG_EXP_LAYER___ATTACH_DERIVED_VIEW__VIEW:
				try {
					attachDerivedView((View)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.REG_EXP_LAYER___ATTACH_DERIVED_VIEWS__ELIST:
				try {
					attachDerivedViews((EList<View>)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.REG_EXP_LAYER___ATTACH_DERIVED_VIEWS:
				try {
					attachDerivedViews();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.REG_EXP_LAYER___LOOKUP_DERIVED_VIEWS__ELIST:
				try {
					return lookupDerivedViews((EList<View>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expr: ");
		result.append(expr);
		result.append(", language: ");
		result.append(language);
		result.append(", isDomainChangedEventDependant: ");
		result.append(isDomainChangedEventDependant);
		result.append(", domainChangedEventLevel: ");
		result.append(domainChangedEventLevel);
		result.append(", isDiagramChangedEventDependant: ");
		result.append(isDiagramChangedEventDependant);
		result.append(", diagramChangedEventLevel: ");
		result.append(diagramChangedEventLevel);
		result.append(", expressionContextObjectType: ");
		result.append(expressionContextObjectType);
		result.append(')');
		return result.toString();
	}

	/**
	 * Called by the observers when a view is added.
	 * @param view
	 */
	protected void viewAdded( View view) {
		
	}
	
	/**
	 * Called by the observers when a view is removed.
	 * @param view
	 */
	protected void viewRemoved( View view) {
		
	}
	
//	public class ViewEventAdapter extends {
//		
//	}
	
	public class DiagramViewEventListener implements IDiagramViewEventListener {

	@Override
	public void diagramViewAdded(Notification msg) {
		viewAdded((View)msg.getNewValue());
		
	}

	@Override
	public void diagramViewRemoved(Notification msg) {
		viewRemoved((View)msg.getNewValue());
	}
		
	}
	
} //RegExpLayerImpl
