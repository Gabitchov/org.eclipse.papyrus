/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.UnaryReferenceCellEditor;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.TreeToFlatContentProvider;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
import org.eclipse.papyrus.uml.table.widget.celleditors.composite.UnaryReferencePapyrusCellEditorComposite;
import org.eclipse.papyrus.uml.table.widget.celleditors.utils.StereotypePropertyFacetElementUtils;
import org.eclipse.papyrus.uml.table.widget.celleditors.utils.NoReferencedElement;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * @This cell editor is declared on UML element AND on EObject (for StereotypeFacetPropertyReference
 * 
 */
public class UnaryReferencePapyrusCellEditor extends UnaryReferenceCellEditor {


	private AbstractCellEditorComposite<EObject> cellEditorComposite;


	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object,
	 *      org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param parent
	 * @param originalValue
	 * @param editHandler
	 * @param feature
	 * @param source
	 * @return
	 */
	public Control activateCell(final Composite parent, final Object originalValue, final IModelCellEditHandler editHandler, final EStructuralFeature feature, final EObject source) {
		if(!(source instanceof Element)) { //we do the same things than EMF-Facet
			cellEditorComposite = (AbstractCellEditorComposite<EObject>)super.activateCell(parent, originalValue, editHandler, feature, source);
		} else {//we are working with UML
			final EStructuralFeature realFeature = StereotypePropertyFacetElementUtils.getRealFeature(source, feature);
			final EObject realSource = StereotypePropertyFacetElementUtils.getRealSource(source, feature);
			final UMLContentProvider p;
			if(feature instanceof StereotypePropertyElement) {
				assert source instanceof Element;
				final Stereotype ste = StereotypePropertyUtils.getAppliedStereotype((Element)source, (StereotypePropertyElement)feature);
				p = new UMLContentProvider(realSource, realFeature, ste, source.eResource().getResourceSet());
			} else {
				p = new UMLContentProvider(source, feature, null, source.eResource().getResourceSet());
			}

			final TreeToFlatContentProvider flatP = new HierarchicToFlatContentProvider(p);
			final List<Object> list = Arrays.asList(flatP.getElements());
			final List<EObject> availableValues = new ArrayList<EObject>();
			final Iterator<Object> iter = list.iterator();
			while(iter.hasNext()) {
				final Object current = iter.next();
				if(current instanceof EObject) {
					availableValues.add((EObject)current);
				}
			}

			//tricks to do the unset
			if(feature.isUnsettable()) {
				//add the possibility to set the Null value
				availableValues.add(0, new NoReferencedElement("null"));
			}
			this.cellEditorComposite = new UnaryReferencePapyrusCellEditorComposite(parent, availableValues, source, feature);
			this.cellEditorComposite.addCommitListener(new IListener() {

				public void handleEvent() {
					editHandler.commit();
				}
			});
		}
		return this.cellEditorComposite;

	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.internal.core.UnaryReferenceCellEditor#getValue()
	 * 
	 * @return
	 *         the new value for the feature.
	 */
	public Object getValue() {
		final Object selectedValue = this.cellEditorComposite.getValue();
		if(selectedValue instanceof NoReferencedElement) {
			return null;
		}
		return selectedValue;
	}
}
