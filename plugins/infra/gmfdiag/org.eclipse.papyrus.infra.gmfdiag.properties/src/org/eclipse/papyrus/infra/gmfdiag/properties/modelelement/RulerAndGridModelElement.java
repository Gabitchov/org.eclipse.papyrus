/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.LineStyleLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.UnitsLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.BooleanDiagramViewObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.DoubleDiagramViewObservaleValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.IntegerDiagramViewObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.RulersUnitObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.properties.util.RulersAndGridPropertyConstants;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;

/**
 * 
 * @author vl222926
 *         This class provides the ModelElement for the property view
 */
@SuppressWarnings("restriction")
//suppress the warning for WorkspaceViewerProperties
public class RulerAndGridModelElement extends AbstractModelElement {



	/**
	 * the diagram for which we are editing preferences
	 */
	private Diagram diagram;

	/**
	 * the edited preference store
	 */
	private IPreferenceStore store;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 *        the diagram for which we are editing preferences
	 * @param domain
	 *        the editing domain
	 * @param context
	 *        the data context
	 * @param preferenceStore
	 *        the edited preference store
	 */
	public RulerAndGridModelElement(final Diagram view, final EditingDomain domain, final DataContextElement context, final IPreferenceStore preferenceStore) {
		this.diagram = view;
		this.store = preferenceStore;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		this.diagram = null;
		this.store = null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#doGetObservable(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	protected IObservable doGetObservable(final String propertyPath) {
		IObservable observable = null;
		if(RulersAndGridPropertyConstants.GRID_IS_DISPLAYING_GRID.equals(propertyPath)) {
			observable = new BooleanDiagramViewObservableValue(this.diagram, WorkspaceViewerProperties.VIEWGRID, this.store);
		}
		if(RulersAndGridPropertyConstants.RULERS_IS_DISPLAYING_RULER.equals(propertyPath)) {
			observable = new BooleanDiagramViewObservableValue(this.diagram, WorkspaceViewerProperties.VIEWRULERS, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_IS_IN_FRONT.equals(propertyPath)) {
			observable = new BooleanDiagramViewObservableValue(diagram, WorkspaceViewerProperties.GRIDORDER, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_COLOR.equals(propertyPath)) {
			observable = new IntegerDiagramViewObservableValue(diagram, WorkspaceViewerProperties.GRIDLINECOLOR, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_STYLE.equals(propertyPath)) {
			observable = new IntegerDiagramViewObservableValue(diagram, WorkspaceViewerProperties.GRIDLINESTYLE, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_SPACING.equals(propertyPath)) {
			observable = new DoubleDiagramViewObservaleValue(diagram, WorkspaceViewerProperties.GRIDSPACING, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_IS_SNAP_TO_GRID.equals(propertyPath)) {
			observable = new BooleanDiagramViewObservableValue(this.diagram, WorkspaceViewerProperties.SNAPTOGRID, this.store);
		}
		if(RulersAndGridPropertyConstants.GRID_IS_SNAP_TO_SHAPE.equals(propertyPath)) {
			observable = new BooleanDiagramViewObservableValue(this.diagram, WorkspaceViewerProperties.SNAPTOGEOMETRY, this.store);
		}
		if(RulersAndGridPropertyConstants.RULERS_UNITS.equals(propertyPath)) {
			observable = new RulersUnitObservableValue(diagram, this.store);
		}
		return observable;
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#getContentProvider(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(RulersAndGridPropertyConstants.GRID_STYLE.equals(propertyPath)) {
			return new StaticContentProvider(new Object[]{ Graphics.LINE_DASH, Graphics.LINE_DASHDOT, Graphics.LINE_DASHDOTDOT, Graphics.LINE_DOT, Graphics.LINE_SOLID, Graphics.LINE_CUSTOM });
		}
		if(RulersAndGridPropertyConstants.RULERS_UNITS.equals(propertyPath)) {
			return new StaticContentProvider(new Object[]{ RulerProvider.UNIT_INCHES, RulerProvider.UNIT_CENTIMETERS, RulerProvider.UNIT_PIXELS });
		}
		return super.getContentProvider(propertyPath);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#getLabelProvider(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public ILabelProvider getLabelProvider(final String propertyPath) {
		if(RulersAndGridPropertyConstants.GRID_STYLE.equals(propertyPath)) {
			return new LineStyleLabelProvider();
		}
		if(RulersAndGridPropertyConstants.RULERS_UNITS.equals(propertyPath)) {
			return new UnitsLabelProvider();
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#isMandatory(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public boolean isMandatory(final String propertyPath) {
		if(RulersAndGridPropertyConstants.GRID_STYLE.equals(propertyPath) || RulersAndGridPropertyConstants.RULERS_UNITS.equals(propertyPath)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#forceRefresh(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public boolean forceRefresh(final String propertyPath) {
		return true;
	}
}
