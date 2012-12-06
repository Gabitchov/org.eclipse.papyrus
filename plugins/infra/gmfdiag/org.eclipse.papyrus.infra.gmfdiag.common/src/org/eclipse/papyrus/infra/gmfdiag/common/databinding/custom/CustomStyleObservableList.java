/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom;

import java.util.Collection;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.listener.CustomStyleListener;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;


public class CustomStyleObservableList extends EMFObservableList implements IChangeListener {

	protected EClass eClass;

	protected EStructuralFeature feature;

	protected String styleName;

	protected View view;

	protected EditingDomain domain;

	protected CustomStyleListener listener;

	protected boolean styleExists;

	protected boolean changing = false;

	//Equals to concreteList
	protected IObservableList observableConcreteList;

	//	protected final List<?> transientList;

	public CustomStyleObservableList(View view, String styleName, EditingDomain domain, EClass eClass, EStructuralFeature feature) {
		super(getWrappedList(view, styleName, eClass, feature), domain, null, null);
		this.eClass = eClass;
		this.feature = feature;
		this.styleName = styleName;
		this.view = view;
		this.domain = domain;
		observableConcreteList = (IObservableList)concreteList;
		styleExists = isStyleCreated();

		view.eAdapters().add(listener = new CustomStyleListener(view, feature, this, styleName));
	}

	@Override
	public void commit(AbstractEditor editor) {
		changing = true;
		super.commit(editor);
		changing = false;
	}

	private boolean isStyleCreated() {
		return view.getNamedStyle(eClass, styleName) != null;
	}

	private static IObservableList getWrappedList(View view, String styleName, EClass eClass, EStructuralFeature feature) {
		NamedStyle style = view.getNamedStyle(eClass, styleName);

		if(style != null) {
			return EMFProperties.list(feature).observe(style);
		}

		//The style doesn't exist yet, we need to simulate it 
		//(With an empty list)
		return new WritableList();
	}

	@Override
	public Command getAddCommand(int index, Object value) {
		return new AddCustomStyleListValueCommand(domain, view, styleName, eClass, feature, value, index);
	}

	@Override
	public Command getAddCommand(Object value) {
		return new AddCustomStyleListValueCommand(domain, view, styleName, eClass, feature, value);
	}

	@Override
	public Command getAddAllCommand(Collection<?> values) {
		return new AddAllCustomStyleListValueCommand(domain, view, styleName, eClass, feature, values);
	}

	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		return new AddCustomStyleListValueCommand(domain, view, styleName, eClass, feature, values, index);
	}

	@Override
	public Command getRemoveCommand(Object value) {
		return new RemoveCustomStyleListValueCommand(domain, view, styleName, eClass, feature, value);
	}

	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		return new RemoveAllCustomStyleListValueCommand(domain, view, styleName, eClass, feature, values);
	}

	@Override
	public Command getSetCommand(int index, Object value) {
		return new SetCustomStyleListValueCommand(domain, view, styleName, eClass, feature, index, value);
	}

	public void handleChange(ChangeEvent event) {
		//If the ListValueStyle has been created or removed, we need to resync
		//the concrete list with it
		if(styleExists != (styleExists = isStyleCreated())) {
			observableConcreteList.dispose();
			concreteList = observableConcreteList = getWrappedList(view, styleName, eClass, feature);
		}

		//If this observable is not the source of the change, the wrapped
		//list should also be refreshed.
		if(!changing) {
			refreshCacheList();
		}
	}

	@Override
	public void dispose() {
		view.eAdapters().remove(listener);
		listener.dispose();
		listener = null;
		observableConcreteList.dispose();
		super.dispose();
	}
}
