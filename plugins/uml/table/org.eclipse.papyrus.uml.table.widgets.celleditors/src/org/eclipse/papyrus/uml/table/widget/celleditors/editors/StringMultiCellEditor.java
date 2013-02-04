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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.editors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.core.composite.registries.ICompositeEditorFactoriesRegistry;
import org.eclipse.papyrus.uml.table.widget.celleditors.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A cell editor for String
 */
public class StringMultiCellEditor implements IModelCellEditor {

	/**
	 * The boolean composite
	 */
	private AbstractCellEditorComposite<String> composite = null;

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object,
	 *      org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject)
	 * 
	 *      {@inheritDoc}
	 */
	public Control activateCell(final Composite parent, final Object originalValue, final IModelCellEditHandler editHandler, final EStructuralFeature feature, final EObject source) {
		ICompositeEditorFactory<String> compositeEditorFactory = ICompositeEditorFactoriesRegistry.INSTANCE.getCompositeEditorFactory(String.class);
		this.composite = compositeEditorFactory.createCompositeEditor(parent, SWT.NONE);
		if(originalValue != null) {
			if(originalValue instanceof String) {
				this.composite.setValue((String)originalValue);
			} else {
				Activator.log.info("An instance of Integer was expected"); //$NON-NLS-1$
			}
		}
		this.composite.addCommitListener(new IListener() {

			public void handleEvent() {
				editHandler.commit();
			}
		});
		return this.composite;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#getValue()
	 * 
	 * @return
	 */
	public Object getValue() {
		if(this.composite != null) {
			return this.composite.getValue();
		}
		return null;
	}
}
