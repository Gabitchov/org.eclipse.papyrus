/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.xtext.widgets.editor;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.papyrus.infra.xtext.widgets.Activator;
import org.eclipse.papyrus.infra.xtext.widgets.adapter.IXtextAdapter;
import org.eclipse.papyrus.infra.xtext.widgets.embedded.EmbeddedXtextEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class ReferenceXtextEditor extends AbstractValueEditor implements IChangeListener {

	protected EmbeddedXtextEditor editor;

	protected String xtextAdapterClassName;

	protected IXtextAdapter adapter;

	public ReferenceXtextEditor(Composite parent, int style) {
		super(parent, style);
	}

	public void setAdapter(String xtextAdapterClassName) {
		this.xtextAdapterClassName = xtextAdapterClassName;
		try {
			Class<? extends IXtextAdapter> xtextAdapterClass = Class.forName(xtextAdapterClassName).asSubclass(IXtextAdapter.class);
			IXtextAdapter xtextAdapter = xtextAdapterClass.newInstance();
			editor = new EmbeddedXtextEditor(this, xtextAdapter.getInjector(), SWT.None);
		} catch (ClassNotFoundException e) {
			Activator.log.error(e);
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
	}

	public String getAdapter() {
		return xtextAdapterClassName;
	}

	@Override
	protected void doBinding() {
		if(editor != null && modelProperty != null) {
			modelProperty.addChangeListener(this);
		}
	}

	@Override
	public void dispose() {
		if(modelProperty != null) {
			modelProperty.removeChangeListener(this);
		}
	}

	@Override
	public Object getValue() {
		return editor.getResource().getContents().get(0);
	}

	@Override
	public Object getEditableType() {
		return EObject.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		//TODO
	}

	@Override
	public boolean isReadOnly() {
		return false; //TODO
	}

	public void handleChange(ChangeEvent event) {
		editor.update(adapter.getText((EObject)modelProperty.getValue()));
	}

	@Override
	public void setToolTipText(String text) {
		//TODO
	}

}
