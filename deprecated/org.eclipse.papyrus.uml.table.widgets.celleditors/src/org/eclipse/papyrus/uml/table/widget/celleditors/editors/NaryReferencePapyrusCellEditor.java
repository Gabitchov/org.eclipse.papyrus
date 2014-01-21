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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.NaryReferenceCellEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
import org.eclipse.papyrus.uml.table.widget.celleditors.utils.StereotypePropertyFacetElementUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * NAry editor for Papyrus. When the edited element is not an instance of Element, we call the default EMF-Facet editor
 * 
 * @author vl222926
 * 
 * @param <T>
 */
public class NaryReferencePapyrusCellEditor<T extends EObject> extends NaryReferenceCellEditor<T> {

	/** the dialog used for the selection */
	private MultipleValueSelectorDialog dialog;

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.NaryReferenceCellEditor#activateCell(org.eclipse.swt.widgets.Composite,
	 *      java.util.List, java.util.List, org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EStructuralFeature)
	 * 
	 * @param parent
	 * @param values
	 * @param availableValues
	 * @param editHandler
	 * @param source
	 * @param feature
	 * @return
	 */
	public Control activateCell(final Composite parent, final List<T> values, final List<T> availableValues, final IModelCellEditHandler editHandler, final EObject source, final EStructuralFeature feature) {
		if(!(source instanceof Element)) {
			return super.activateCell(parent, values, availableValues, editHandler, source, feature);
		} else {
			final Composite placeholderComposite = new Composite(parent, SWT.NONE);
			final EObject realSource = StereotypePropertyFacetElementUtils.getRealSource(source, feature);
			final EStructuralFeature realFeature = StereotypePropertyFacetElementUtils.getRealFeature(source, feature);
			final UMLContentProvider p;
			if(feature instanceof StereotypePropertyElement) {
				assert source instanceof Element;
				final Stereotype ste = StereotypePropertyUtils.getAppliedStereotype((Element)source, (StereotypePropertyElement)feature);
				p = new UMLContentProvider(realSource, realFeature, ste, source.eResource().getResourceSet());
			} else {
				p = new UMLContentProvider(source, feature, null, source.eResource().getResourceSet());
			}

			final String title = realFeature.getName();
			final boolean unique = realFeature.isUnique();
			final boolean ordered = realFeature.isOrdered();
			final int upperBound = realFeature.getUpperBound();
			final ReferenceSelector selector = new ReferenceSelector(unique);
			selector.setContentProvider(p);
			selector.setLabelProvider(new UMLLabelProvider());
			final Object value = (Collection<?>)realSource.eGet(realFeature);

			dialog = new MultipleValueSelectorDialog(Display.getCurrent().getActiveShell(), selector, title, unique, ordered, upperBound) {

				@Override
				protected void okPressed() {
					super.okPressed();
					editHandler.commit();
				}

				@Override
				public boolean close() {
					placeholderComposite.dispose();
					return super.close();
				}
			};
			dialog.setLabelProvider(new UMLLabelProvider());
			if(value != null && value instanceof Collection) {
				Collection<?> coll = (Collection<?>)value;
				if(!coll.isEmpty()) {
					dialog.setInitialSelections(coll.toArray());
				}
			}

			dialog.open();

			return placeholderComposite;
		}
	}


	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.NaryReferenceCellEditor#getValue()
	 * 
	 * @return
	 */
	@Override
	public List<T> getValue() {
		Object[] result;
		if(this.dialog == null) {
			return super.getValue();
		} else {
			result = dialog.getResult();
		}
		if(result == null) {
			return Collections.emptyList();
		}
		final List<T> values = new ArrayList<T>();
		for(final Object current : result) {
			values.add((T)current);
		}
		return values;

	}
}
