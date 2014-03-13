/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the selection and/or creation of an element in a list.
 */
public class GetFilteredSubTypingTypeWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<ETypedElement, Object> {

	private final EClass context;
	private final Facet facet;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties.
	 */
	public GetFilteredSubTypingTypeWidget(final Composite parent, final EClass context,
			final Facet facet) {
		super(parent);
		this.context = context;
		this.facet = facet;
	}

	@Override
	protected Map<String, ETypedElement> getElements() {
		final Map<String, ETypedElement> allElements = new HashMap<String, ETypedElement>();
		if (this.context != null) {
			allElements.putAll(getAttributes(this.context));
			allElements.putAll(getOperations(this.context.getEAllOperations()));
		}
		if (this.facet != null) {
			allElements.putAll(getFacetAttributes(this.facet));
			allElements.putAll(getOperations(this.facet.getFacetOperations()));
		}
		return allElements;
	}

	/**
	 * @param facet
	 * @return
	 */
	private static Map<String, ETypedElement> getFacetAttributes(
			final Facet facet) {
		final Map<String, ETypedElement> allElements = new HashMap<String, ETypedElement>();
		for (final EStructuralFeature element : facet.getFacetElements()) {
			final EClassifier eType = element.getEType();
			if ((element instanceof FacetAttribute)
					&& eType.equals(
							EcorePackage.eINSTANCE.getEBoolean())) {
				allElements.put(element.getName(), element);
			}
		}
		return allElements;
	}

	/**
	 * @param context
	 * @return
	 */
	private static Map<String, ETypedElement> getOperations(
			final List<? extends EOperation> elements) {
		final Map<String, ETypedElement> allElements = new HashMap<String, ETypedElement>();
		for (final EOperation operation : elements) {
			// Get all the operations returning a boolean and without any
			// parameter.
			if (operation.getEType().equals(
					EcorePackage.eINSTANCE.getEBoolean())
					&& (operation.getEParameters().size() == 0)) {
				allElements.put(operation.getName(), operation);
			}
		}
		return allElements;
	}

	/**
	 * @param context
	 * @return
	 */
	private static Map<String, ETypedElement> getAttributes(
			final EClass context) {
		final Map<String, ETypedElement> allElements = new HashMap<String, ETypedElement>();
		for (final EAttribute attribute : context.getEAllAttributes()) {
			if (attribute.getEType().equals(
					EcorePackage.eINSTANCE.getEBoolean())) {
				allElements.put(attribute.getName(), attribute);
			}
		}
		return allElements;
	}

	@Override
	protected IDialog<Object> createDialog() {
		// No element can be created.
		return null;
	}

	/**
	 * @return the selected element in the filtredList.
	 */
	public ETypedElement getSubTypeSelected() {
		return getElementSelected();
	}

	@Override
	public Command getCommand() {
		// Here, this widget only return a selected element so, no command is
		// returned.
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}
}
