/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.tabbedproperties.uml2;

//Start of user code for user imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.papyrus.tabbedproperties.uml2.figures.LabeledPropertyQualifiersForm;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

//End of user code for user imports

/**
 * The PropertyQualifiers property section for the Property element
 * 
 */
public class PropertyQualifiersSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 */
	private LabeledPropertyQualifiersForm labeledPropertyQualifiers;

	// private FeatureQualifiersForm featureQualifiers;

	/**
	 * The Property to edit
	 */
	private Property property;

	/**
	 * The model element listener
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 */
	public PropertyQualifiersSection() {
	}

	/**
	 * Create the associated form
	 * 
	 * @return the created form
	 */
	@Override
	public PropertyEditor createFigure() {
		labeledPropertyQualifiers = new LabeledPropertyQualifiersForm("Qualifiers:", "");
		return labeledPropertyQualifiers;
	}

	/**
	 * Initialize the form
	 */
	public void initializeFigure() {
		// Listener to listen to the property change
		BooleanPropertyChangeListener derivedListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getProperty_IsDerived(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getDerived().setPropertyChangeListener(derivedListener);

		// Listener to listen to the property change
		BooleanPropertyChangeListener derivedUnionListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getProperty_Aggregation(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getDerivedUnion().setPropertyChangeListener(derivedUnionListener);

		// Listener to listen to the property change
		BooleanPropertyChangeListener orderedListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getOrdered().setPropertyChangeListener(orderedListener);

		// Listener to listen to the property change
		BooleanPropertyChangeListener readOnlyListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getReadOnly().setPropertyChangeListener(readOnlyListener);

		// Listener to listen to the property change
		BooleanPropertyChangeListener statiqueListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getFeature_IsStatic(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getStatique().setPropertyChangeListener(statiqueListener);

		// Listener to listen to the property change
		BooleanPropertyChangeListener uniqueListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newValue);
				editingDomain.getCommandStack().execute(command);
			}

		};
		labeledPropertyQualifiers.getUnique().setPropertyChangeListener(uniqueListener);

	}

	/**
	 * Refresh the section
	 * 
	 */
	@Override
	public void refresh() {
		super.refresh();
		labeledPropertyQualifiers.getDerived().setValue(property.isDerived());
		labeledPropertyQualifiers.getDerivedUnion().setValue(property.isDerivedUnion());
		labeledPropertyQualifiers.getOrdered().setValue(property.isOrdered());
		labeledPropertyQualifiers.getReadOnly().setValue(property.isReadOnly());
		labeledPropertyQualifiers.getStatique().setValue(property.isStatic());
		labeledPropertyQualifiers.getUnique().setValue(property.isUnique());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert (selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();
		this.property = (Property) getBusinessElement(input);
	}

	/**
	 * Return true if this section can select such element.
	 * 
	 * @param toTest
	 *            the element to test
	 * @return true if this section can select such element.
	 */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Property;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.core.AbstractEnhancedPropertySection#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		property.eAdapters().add(modelListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.core.AbstractEnhancedPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		// Stop listening
		property.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.core.AbstractEnhancedPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		// stop listening
		property.eAdapters().remove(modelListener);
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * 
	 * @author cea
	 * 
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {

		public void notifyChanged(Notification notification) {
			refresh();
		}
	}

}