/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener;


/**
 * This class is used to synchronize the diagram's properties when something
 * change in the LayerStack.
 * It listen on events from {@link LayersStack} and {@link Diagram}.
 *  
 * @author cedric dumoulin
 *
 */
public class LayerStackSynchronizer implements IDiagramViewEventListener, ILayersModelEventListener {

	/**
	 * The observed diagram.
	 */
	protected Diagram diagram;
	
	/**
	 * The observed LayerStack.
	 */
	protected LayersStack layersStack;
	
	/**
	 * The application object. Required by some methods.
	 * <br>
	 * Method requiring this object must check it before any use, 
	 * as this object can be null.
	 * 
	 */
	protected LayersStackApplication application;
	
	/**
	 * The notifier of layer model events.
	 */
	protected LayersModelEventNotifier layersModelEventNotifier;
	
	/**
	 * The notifier of layer model events.
	 */
	protected DiagramViewEventNotifier diagramViewEventNotifier;
	
	/**
	 * Constructor.
	 *
	 * @param layersStack The layerStack to listen to. It should have an associated diagram.
	 * 
	 */
	public LayerStackSynchronizer(LayersStack layersStack) {
		this.diagram = layersStack.getDiagram();
		this.layersStack = layersStack;
		
		// try to get the application object
		// it is the container of the layerStack
		application = (LayersStackApplication)layersStack.eContainer();
		
		
		activate();
//		System.err.println("LayerStackSynchronizer( " +diagram.getName()+ " ) started");
	}


	
	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}


	
	/**
	 * @return the layersStack
	 */
	public LayersStack getLayersStack() {
		return layersStack;
	}



	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		
		diagramViewEventNotifier = new DiagramViewEventNotifier(diagram);
		diagramViewEventNotifier.addEventListener(this);
		
		layersModelEventNotifier = new LayersModelEventNotifier(layersStack);
		layersModelEventNotifier.addLayersModelEventListener(this);
		
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		diagramViewEventNotifier.removeEventListener(this);
		diagramViewEventNotifier = null;
		
		layersModelEventNotifier.removeLayersModelEventListener(this);
		layersModelEventNotifier = null;
	}
	
	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
		// Deactivate listeners
		deactivate();
		diagramViewEventNotifier = null;
		layersModelEventNotifier = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	protected boolean isDisposed() {
		return diagramViewEventNotifier == null;
	}
	
	/**
	 * Check if the application object is not null.
	 * Throw an exception if the application object is null.
	 * <br>
	 * In normal use, the Application is the container of the LayerStack.
	 * It is set in the constructor of this class.
	 * 
	 * @throws BadStateException
	 */
	protected void checkApplication() throws BadStateException {
		if( application == null) {
			throw new BadStateException("Attempt to call a method requireing the 'application object, but the Application object is not set. You must provide a LayerStack contained in its Application.");
		}
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#propertyValueAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void propertyValueAdded(Notification notification) {
		System.out.println("propertyValueAdded " + notification.getNewValue());

		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueAdd(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			if( views.size() == 0) {
				return;
			}
			
			checkApplication();
			Property property  = application.getPropertyRegistry().getProperty(propertyName);
			
			List<ComputePropertyValueCommand> commands = layersStack.getViewsComputePropertyValueCommand(views, property);
			
			PropertySetter setter = application.getPropertySetterRegistry().getPropertySetter(property);
			
			// Walk each view and set the property
			for( int i=0; i<views.size(); i++) {
				setter.setValue(views.get(i), commands.get(i).getCmdValue() );
			}
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}	catch (LayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}



	@Override
	public void propertyValueRemoved(Notification notification) {
		System.out.println("propertyValueRemoved " + notification.getOldValue());

		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueRemove(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			if( views.size() == 0) {
				return;
			}

			checkApplication();
			Property property  = application.getPropertyRegistry().getProperty(propertyName);

			List<ComputePropertyValueCommand> commands = layersStack.getViewsComputePropertyValueCommand(views, property);
			if( commands == null) {
				// no command
				return;
			}

			PropertySetter setter = application.getPropertySetterRegistry().getPropertySetter(property);

			// Walk each view and set the property
			for( int i=0; i<views.size(); i++) {
				// A command can be null
				ComputePropertyValueCommand cmd = commands.get(i).getCmdValue();
				if( cmd != null ) {
					setter.setValue(views.get(i), cmd.getCmdValue() );
				}

			}
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		} catch (LayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}



	@Override
	public void propertyValueChanged(Notification notification) {
		System.out.println("propertyValueChanged " + notification.getNewValue());

		try {
			// Name of the property
			String propertyName = LayersModelEventUtils.PropertyEvents.getPropertyNameFromValueSet(notification);

			// Need to recompute the associated views
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			List<View> views = layer.getViews();
			if( views.size() == 0) {
				return;
			}
			
			checkApplication();
			Property property  = application.getPropertyRegistry().getProperty(propertyName);
			
			List<ComputePropertyValueCommand> commands = layersStack.getViewsComputePropertyValueCommand(views, property);
			
			PropertySetter setter = application.getPropertySetterRegistry().getPropertySetter(property);
			
			// Walk each view and set the property
			for( int i=0; i<views.size(); i++) {
				setter.setValue(views.get(i), commands.get(i).getCmdValue() );
			}
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		} catch (LayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void layerAdded(Notification notification) {
		System.out.println(this.getClass().getSimpleName() + " layerAdded(not implemented) " + notification.getNewValue());

	}



	@Override
	public void layerRemoved(Notification notification) {
		System.out.println(this.getClass().getSimpleName() + " layerRemoved(not implemented) " + notification.getOldValue());

	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerMoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerMoved(Notification notification) {
		System.out.println(this.getClass().getSimpleName() + " layerMoved(not implemented) " + notification.getNewValue());

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerSet(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void layerSet(Notification notification) {
		System.out.println(this.getClass().getSimpleName() + " layerSet(not implemented) " + notification.getNewValue());

	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewAddedToLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewAddedToLayer(Notification notification) {
		System.out.println("viewAddedToLayer" + notification.getNewValue());

		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {			
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
			View view = LayersModelEventUtils.ViewEvents.getViewAdded(notification);
			
			
			checkApplication();
			List<Property> properties  = layer.getAttachedProperties();
			
			List<ComputePropertyValueCommand> commands = layersStack.getPropertiesComputePropertyValueCommand(view, properties);
			if(commands == null) {
				// No property to set
				return;
			}
			
			PropertySetter setter;
			// Walk each cmd and set the property
			for( int i=0; i<commands.size(); i++) {
				try {
					Property property = properties.get(i);
					setter = application.getPropertySetterRegistry().getPropertySetter(property);
					setter.setValue(view, commands.get(i).getCmdValue() );
				} catch (NotFoundException e) {
					// No setter found
					System.err.println(e.getMessage());
				} catch (NullPointerException e) {
					// A command is null
				}
			}
		} catch (LayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewRemovedFromLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewRemovedFromLayer(Notification notification) {
		// We need to find the view, the layer in which it is added,
		// and the properties attached to this layer.
		// Then, we compute this property and set it to the view.
		try {
			AbstractLayer layer = LayersModelEventUtils.PropertyEvents.getAbstractLayer(notification);
//			View view = LayersModelEventUtils.ViewEvents.getViewRemoved(notification);
			
			
//			List<Property> properties  = layer.getAttachedProperties();
			
			// Here we need to reset default values to the view
			// TODO: reset default values for specified properties.
		} catch (LayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#viewMovedBetweenLayer(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void viewMovedBetweenLayer(Notification notification) {
		System.out.println(this.getClass().getSimpleName() + " viewMovedBetweenLayer(not implemented) " + notification.getNewValue());

	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener#diagramViewAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewAdded(Notification msg) {
		System.out.println(this.getClass().getSimpleName() + " diagramViewAdded(not implemented) " + msg.getNewValue());

		// WARNING !!!
		// Some filtering should be done on the event. 
		// When a View is removed, the event is sent for each of its parts. This
		// result in multiple events receiving.
		// Only events on Shape and Links are useful. So, we need to 
		// do some filtering (in the DiagramViewEventNotifier ?).
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener#diagramViewRemoved(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	@Override
	public void diagramViewRemoved(Notification msg) {
		System.out.println(this.getClass().getSimpleName() + " diagramViewRemoved(not implemented) " + msg.getOldValue());

		// WARNING !!!
		// Some filtering should be done on the event. 
		// When a View is removed, the event is sent for each of its parts. This
		// result in multiple events receiving.
		// Only events on Shape and Links are useful. So, we need to 
		// do some filtering (in the DiagramViewEventNotifier ?).
	}



}
