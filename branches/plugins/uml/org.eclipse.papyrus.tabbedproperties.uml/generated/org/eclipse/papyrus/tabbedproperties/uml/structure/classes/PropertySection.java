/*******************************************************************************
 * Copyright (c) 2008 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     CEA - initial API and implementation
 *     Obeo
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.structure.classes;

//Start of user code for user imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.papyrus.tabbedproperties.core.listeners.NavigationListener;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.ListPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.CreateElementListener;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.forms.InputTextControls;
import org.eclipse.papyrus.tabbedproperties.core.commands.AddReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.CreateElementCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.CustomizableSetValueCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.MoveReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.RemoveReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

import org.eclipse.papyrus.tabbedproperties.uml.figures.PropertyForm;


import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.AggregationKind;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Property property section for the Property element
 * 
 * A property is a structural feature of a classifier that characterizes instances of the classifier. A property related by ownedAttribute to a classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the class to a value or set of values of the type of the attribute. A property related by memberEnd or its specializations to an association represents an end of the association. The type of the property is the type of the end of the association.
 *
 * @generated
 */
public class PropertySection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private PropertyForm property;

	/**
	 * The Property to edit 
	 * @generated
	 */
	private Property propertyElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public PropertySection() {
	
	}
	
	/**
	 * the navigation service
	 * @generated
	 **/
	private NavigationListener navigationListener= new NavigationListener(this);

    /**
     * Create the associated form
     * @return the created form
     * @generated
     */
	public PropertyEditor createFigure() {
		property = new PropertyForm("Property Specifications","A property is a structural feature of a classifier that characterizes instances of the classifier. A property related by ownedAttribute to a classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the class to a value or set of values of the type of the attribute. A property related by memberEnd or its specializations to an association represents an end of the association. The type of the property is the type of the end of the association."+
""+
"A property represents a set of instances that are owned by a containing classifier instance."+
""+
"A property has the capability of being a deployment target in a deployment relationship. This enables modeling the deployment to hierarchical nodes that have properties functioning as internal parts."+
""+
"Property represents a declared state of one or more instances in terms of a named relationship to a value or values. When a property is an attribute of a classifier, the value or values are related to the instance of the classifier by being held in slots of the instance. When a property is an association end, the value or values are related to the instance or instances at the other end(s) of the association. The range of valid values represented by the property can be controlled by setting the property's type."+
""+
"Property specializes ParameterableElement to specify that a property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.");
		return property;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//If isDerived is true, the value of the attribute is derived from information elsewhere. Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDerived of Property
		BooleanPropertyChangeListener isDerivedFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,propertyElement, UMLPackage.eINSTANCE.getProperty_IsDerived(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		property.getIsDerivedForm().setPropertyChangeListener(isDerivedFormListener);

		//---------------------------------------------------------------------
		//Specifies whether the property is derived as the union of all of the properties that are constrained to subset it.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDerivedUnion of Property
		BooleanPropertyChangeListener isDerivedUnionFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,propertyElement, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		property.getIsDerivedUnionForm().setPropertyChangeListener(isDerivedUnionFormListener);

		//---------------------------------------------------------------------
		//Specifies the kind of aggregation that applies to the Property.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature aggregation of Property
		PropertyChangeListener<AggregationKind> aggregationFormListener = new PropertyChangeListener<AggregationKind>(){
		   public void propertyChanged(PropertyEditor editor, AggregationKind newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, propertyElement, UMLPackage.eINSTANCE.getProperty_Aggregation(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		property.getAggregationForm().setPropertyChangeListener(aggregationFormListener);

		//---------------------------------------------------------------------
		//If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute. This is a derived value, indicating whether the aggregation of the Property is composite or not.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isComposite of Property
		BooleanPropertyChangeListener isCompositeFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,propertyElement, UMLPackage.eINSTANCE.getProperty_IsComposite(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		property.getIsCompositeForm().setPropertyChangeListener(isCompositeFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						property.getIsDerivedForm().setValue(propertyElement.isDerived());
 
 

	

			 
				 
														   						property.getIsDerivedUnionForm().setValue(propertyElement.isDerivedUnion());
 
 

	

			 
				 
											  
		property.getAggregationForm().setSelected(propertyElement.getAggregation());
 

	

			 
				 
														   						property.getIsCompositeForm().setValue(propertyElement.isComposite());
 
 

	

 

	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert(selection instanceof IStructuredSelection);
    	Object input = ((IStructuredSelection) selection).getFirstElement();
    	this.propertyElement = (Property)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Property;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		propertyElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		propertyElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(propertyElement!=null){
		propertyElement.eAdapters().remove(modelListener);}
		if(property!=null){
		property.dispose();
		}
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * @author Patrick Tessier
	 *
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {
		
		/**
     	 * @{inheritDoc}
     	 * @generated
     	 */
		public void notifyChanged(Notification notification) {
			if(Notification.REMOVING_ADAPTER != notification.getEventType()){
				refresh();
			}
		}
	}

}