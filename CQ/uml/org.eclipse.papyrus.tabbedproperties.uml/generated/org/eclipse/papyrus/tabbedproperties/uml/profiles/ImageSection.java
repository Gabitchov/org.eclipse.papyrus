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
package org.eclipse.papyrus.tabbedproperties.uml.profiles;

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

import org.eclipse.uml2.uml.Image;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ImageForm;


import org.eclipse.uml2.uml.Image;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Image property section for the Image element
 * 
 * Physical definition of a graphical image.
 *
 * @generated
 */
public class ImageSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ImageForm image;

	/**
	 * The Image to edit 
	 * @generated
	 */
	private Image imageElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ImageSection() {
	
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
		image = new ImageForm("","Physical definition of a graphical image.");
		image.setBackContext(backbone);
		return image;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//This contains the serialization of the image according to the format. The value could represent a bitmap, image such as a GIF file, or drawing 'instructions' using a standard such as Scalable Vector Graphic (SVG) (which is XML based).
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature content of Image
		PropertyChangeListener<String> contentFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, imageElement, UMLPackage.eINSTANCE.getImage_Content(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		image.getContentForm().setPropertyChangeListener(contentFormListener);

		//---------------------------------------------------------------------
		//This contains a location that can be used by a tool to locate the image as an alternative to embedding it in the stereotype.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature location of Image
		PropertyChangeListener<String> locationFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, imageElement, UMLPackage.eINSTANCE.getImage_Location(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		image.getLocationForm().setPropertyChangeListener(locationFormListener);

		//---------------------------------------------------------------------
		//This indicates the format of the content - which is how the string content should be interpreted. The following values are reserved: SVG, GIF, PNG, JPG, WMF, EMF, BMP. In addition the prefix 'MIME: ' is also reserved. This option can be used as an alternative to express the reserved values above, for example "SVG" could instead be expressed as "MIME: image/svg+xml".
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature format of Image
		PropertyChangeListener<String> formatFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, imageElement, UMLPackage.eINSTANCE.getImage_Format(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		image.getFormatForm().setPropertyChangeListener(formatFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						image.getContentForm().setValue(imageElement.getContent());
 
 

	

			 
				 
														   						image.getLocationForm().setValue(imageElement.getLocation());
 
 

	

			 
				 
														   						image.getFormatForm().setValue(imageElement.getFormat());
 
 

	

 

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
    	this.imageElement = (Image)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Image;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		imageElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		imageElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(imageElement!=null){
		imageElement.eAdapters().remove(modelListener);}
		if(image!=null){
		image.dispose();
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