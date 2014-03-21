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
package org.eclipse.papyrus.layers.runtime;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.impl.StringToTypeInstanceMapImpl;
import org.eclipse.papyrus.layers.stackmodel.layers.util.ECoreUtils;


/**
 * 
 * @author cedric dumoulin
 *
 */
public class LayersModelEventUtils {


	static public class PropertyEvents {
		
		/**
		 * Get the abstract layer containing the notifier.
		 * 
		 * @param notification
		 * @return
		 * @throws NotFoundException
		 */
		static public AbstractLayer getAbstractLayer(Notification notification) throws NotFoundException {
			return (AbstractLayer)ECoreUtils.lookupAncestorOfType((EObject)notification.getNotifier(), LayersPackage.eINSTANCE.getAbstractLayer());
		}
		
		/**
		 * Get the name of the property concerned by the event.
		 * @return
		 */
		static public String getPropertyNameFromValueAdd(Notification notification) {
			
			StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)notification.getNewValue();
			return entry.getKey();
		}
		/**
		 * Get the name of the property concerned by the event.
		 * @return
		 */
		static public String getPropertyNameFromValueRemove(Notification notification) {
			
			StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)notification.getOldValue();
			return entry.getKey();
		}
		/**
		 * Get the name of the property concerned by the event.
		 * @return
		 * @throws NotFoundException 
		 */
		static public String getPropertyNameFromValueSet(Notification notification) throws NotFoundException {
			
			StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)ECoreUtils.lookupAncestorOfType((EObject)notification.getNotifier(), LayersPackage.eINSTANCE.getStringToTypeInstanceMap());
			return entry.getKey();
		}
	}
	
	/**
	 * 
	 *
	 */
	static public class ViewEvents {
		
		/**
		 * Get the abstract layer containing the notifier.
		 * 
		 * @param notification
		 * @return
		 * @throws NotFoundException
		 */
		static public AbstractLayer getAbstractLayer(Notification notification) throws NotFoundException {
			return (AbstractLayer)notification.getNotifier();
		}

		/**
		 * Get the view added to layer
		 * 
		 * @param notification
		 * @return
		 * @throws NotFoundException
		 */
		static public View getViewAdded(Notification notification) throws NotFoundException {
			return (View)notification.getNewValue();
		}
		
		/**
		 * Get the view removed from layer
		 * 
		 * @param notification
		 * @return
		 * @throws NotFoundException
		 */
		static public View getViewRemoved(Notification notification) throws NotFoundException {
			return (View)notification.getOldValue();
		}

		/**
		 * Get the views[*] that have been removed from the layer.
		 * 
		 * @param notification
		 * @return
		 */
		public static List<View> getViewsRemoved(Notification notification) {
			return (List<View>)notification.getOldValue();
		}

		public static List<View> getViewsAdded(Notification notification) {
			return (List<View>)notification.getNewValue();
		}
		

	}
}
