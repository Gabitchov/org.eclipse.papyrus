/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal;

import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditorContainer;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;

public class ModelCellEditorContainer<T extends AbstractModelCellEditor> implements
		IModelCellEditorContainer<AbstractModelCellEditor> {

	private AbstractModelCellEditor modelCellEditor;
	private String bundleName;

	public String getBundleName() {
		return this.bundleName;
	}

	public AbstractModelCellEditor getModelCellEditor() {
		return this.modelCellEditor;
	}

	public void setBundleName(final String bundleName) {
		this.bundleName = bundleName;
	}

	public void setModelCellEditor(final AbstractModelCellEditor modelCellEditor) {
		this.modelCellEditor = modelCellEditor;

	}
}