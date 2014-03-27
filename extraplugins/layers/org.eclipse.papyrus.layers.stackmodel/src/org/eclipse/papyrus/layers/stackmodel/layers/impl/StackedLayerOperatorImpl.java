/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import static org.eclipse.papyrus.layers.stackmodel.Activator.log;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stacked Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StackedLayerOperatorImpl extends AbstractLayerOperatorImpl implements StackedLayerOperator {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected StackedLayerOperatorImpl() {
		super();
		
		// Add an observer
		Adapter adapter = new LayerDescriptorSynchronizer();
		this.eAdapters().add(adapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.STACKED_LAYER_OPERATOR;
	}

	/**
	 * Reset the descriptor accordingly to the descriptor name.
	 * The descriptor is resseted only if the ::application and ::layerOperatorDescriptorName are set.
	 * Nothing is done if one of the attribute is not set.
	 * Nothing is done if the descriptor can not be found (maybe a log is issue).
	 * <!-- begin-user-doc -->
	 * Not used ?
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void resetDescriptor() {
		
		if( getApplication() == null || getLayerOperatorDescriptorName() == null) {
			// A property is not yet set.
			// do nothing
			return;
		}
		
		try {
			LayerOperatorDescriptor descriptor = getApplication().getLayerOperatorDescriptorRegistry().getLayerOperatorDescriptor(getLayerOperatorDescriptorName());
			setLayerOperatorDescriptor(descriptor);
		} catch (NotFoundException e) {
			// Not found
			log.error( this.getClass().getName() 
					+ "- Can't get LayerOperatorDescriptor for descriptorName '" + getLayerOperatorDescriptorName() + "'."
					, e);
		}
	}

	/**
	 * This class listen to #propertyValueMap, and synchronize propertyValues accordingly.
	 * 
	 *
	 */
	public class LayerDescriptorSynchronizer extends AdapterImpl {
		
		@Override
		public void notifyChanged(Notification msg) {
//			System.err.println("event " + msg.getEventType());
			
			switch(msg.getFeatureID(AbstractLayer.class)) {
			case LayersPackage.STACKED_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				notifyDescriptorNameChanged(msg);
				break;
	
			case LayersPackage.STACKED_LAYER_OPERATOR__APPLICATION:
				notifyLayerApplicationFeatureChanged(msg);
				break;
	
			default:
				break;
			}
		}
		
		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 * @param msg
		 */
		protected void notifyDescriptorNameChanged(Notification msg) {
//			System.err.println("descriptor name changed " + msg.getEventType());
			switch(msg.getEventType()) {
			case Notification.SET:	
			{
				// Name is set
				resetDescriptor();
				break;
			}
			default:
				break;
			}
	
		}
		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 * @param msg
		 */
		protected void notifyLayerApplicationFeatureChanged(Notification msg) {
//			System.err.println("application changed " + msg.getEventType());
			switch(msg.getEventType()) {
			case Notification.SET:	
			{
				// Application is set
				resetDescriptor();
				break;
			}
			}
		}
	
	}


} //StackedLayerOperatorImpl
