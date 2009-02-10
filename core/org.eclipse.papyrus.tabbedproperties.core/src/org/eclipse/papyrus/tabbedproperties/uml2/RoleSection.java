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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.tabbedproperties.core.commands.CustomizableSetValueCommand;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.helpers.MultiplicityHelper;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.papyrus.tabbedproperties.uml2.figures.RoleFigure;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * The Label section on the Button tab.
 * 
 * 
 */
public class RoleSection extends AbstractEnhancedPropertySection implements IFilter {

	private RoleFigure roleFigure;

	private Property namedElement;

	private BusinessModelListener modelListener = new BusinessModelListener();

	public RoleSection() {
	}

	@Override
	public PropertyEditor createFigure() {
		roleFigure = new RoleFigure();
		return roleFigure;
	}

	public void initializeFigure() {
		// Listener to listen to the property change
		PropertyChangeListener<String> editorListener = new PropertyChangeListener<String>() {

			public void propertyChanged(PropertyEditor editor, String newValue) {
				// to change to send a command
				namedElement.setName(newValue);
			}

		};
		roleFigure.getNameControl().setPropertyChangeListener(editorListener);

		// Listener to listen to the property change
		PropertyChangeListener<String> editorListener2 = new PropertyChangeListener<String>() {

			public void propertyChanged(PropertyEditor editor, String newValue) {
				// to change to send a command
				namedElement.setName(newValue);
			}

		};
		roleFigure.getNameControl2().setPropertyChangeListener(editorListener2);

		// Visibility
		// Listener to listen to the property change
		PropertyChangeListener<VisibilityKind> visibilityListener = new PropertyChangeListener<VisibilityKind>() {

			public void propertyChanged(PropertyEditor editor, VisibilityKind newValue) {
				// to change to send a command
				namedElement.setVisibility(newValue);
			}

		};
		roleFigure.getVisibility().setPropertyChangeListener(visibilityListener);

		// Aggregation
		// Listener to listen to the property change
		PropertyChangeListener<AggregationKind> aggregationListener = new PropertyChangeListener<AggregationKind>() {

			public void propertyChanged(PropertyEditor editor, AggregationKind newValue) {
				// to change to send a command
				namedElement.setAggregation(newValue);
			}

		};
		roleFigure.getAggregationKind().setPropertyChangeListener(aggregationListener);

		// qualifiers
		BooleanPropertyChangeListener isDerivedListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				// to change to send a command
				namedElement.setIsDerived(newValue);
			}

		};
		roleFigure.getQualifiers().getDerived().setPropertyChangeListener(isDerivedListener);

		BooleanPropertyChangeListener isNavigableListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				// to change to send a command
				namedElement.setIsNavigable(newValue);
			}

		};
		roleFigure.getQualifiers().getNavigable().setPropertyChangeListener(isNavigableListener);

		PropertyChangeListener<String> multiplicityListener = new PropertyChangeListener<String>() {

			public void propertyChanged(PropertyEditor editor, String newValue) {
				// to change to send a command
				setMultiplicityValue(namedElement, newValue);
			}

		};
		roleFigure.getMultiplicity().setPropertyChangeListener(multiplicityListener);

		// init Multiplicity
		roleFigure.getMultiplicity().setSelectableValues(getMultiplicitySelectableValues());
	}

	@Override
	public void refresh() {
		super.refresh();
		roleFigure.getNameControl().setText(namedElement.getName());
		roleFigure.getNameControl2().setText(namedElement.getName());
		roleFigure.getVisibility().setValue(namedElement.getVisibility());
		roleFigure.getAggregationKind().setValue(namedElement.getAggregation());
		roleFigure.getQualifiers().getDerived().setValue(namedElement.isDerived());
		roleFigure.getQualifiers().getNavigable().setValue(namedElement.isNavigable());

		roleFigure.getMultiplicity().setValue(getMultiplicityValue());

	}

	private MultiplicityHelper multiplicityHelper = new MultiplicityHelper();

	/**
	 * Get the multiplicity value
	 * 
	 * @return
	 */
	private String getMultiplicityValue() {
		// TODO Auto-generated method stub
		return Integer.toString(namedElement.getUpper());
	}

	private void setMultiplicityValue(Property namedElement, String newValue) {
		System.out.println("set multiplicity");

		RecordingCommand cmd = new CustomizableSetValueCommand<Property>(editingDomain, namedElement, newValue) {

			@Override
			protected void doExecute() {
				multiplicityHelper.setValueAsString(element, newValue);
			}
		};
		editingDomain.getCommandStack().execute(cmd);

	}

	private String[] getMultiplicitySelectableValues() {
		return new String[] { "0..1", "0..1", "1", "1", "1..*", "1..*", "*", "*" };
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert (selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();

		// this.namedElement = (Property)getBusinessElement(input);
		namedElement = (Property) getBusinessElement(input);
	}

	/**
	 * Return true if this section can select such element.
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean select(Object toTest) {
		// return getBusinessElement(toTest) instanceof Property;
		return getBusinessElement(toTest) instanceof Property;
	}

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		namedElement.eAdapters().add(modelListener);
	}

	@Override
	public void aboutToBeHidden() {
		// Stop listening
		namedElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	@Override
	public void dispose() {
		// stop listening
		namedElement.eAdapters().remove(modelListener);
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * 
	 * @author dumoulin
	 * 
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {

		public void notifyChanged(Notification notification) {
			refresh();
		}
	}

}