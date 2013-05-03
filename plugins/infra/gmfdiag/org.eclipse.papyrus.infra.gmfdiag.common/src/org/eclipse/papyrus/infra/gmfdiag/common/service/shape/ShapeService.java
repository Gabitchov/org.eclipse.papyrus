/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;

/**
 * Service that manages shape.
 */
public class ShapeService extends org.eclipse.gmf.runtime.common.core.service.Service {

	/** singleton instance */
	private static ShapeService instance;

	/**
	 * Constructor (hidden: singleton instance).
	 */
	protected ShapeService() {

	}

	/**
	 * Checks if the given element should display a shape.
	 * 
	 * @return <code>true</code> if a shape should be displayed
	 */
	public boolean hasShapeToDisplay(EObject view) {
		@SuppressWarnings("unchecked")
		List<RenderedImage> images = (List<RenderedImage>)execute(ExecutionStrategy.REVERSE, new GetShapesForViewOperation(view));
		return images != null && images.size() > 0;
	}

	/**
	 * Returns the shape to be displayed
	 * 
	 * @param view
	 *        the EObject for which the shape is computed
	 * @return the shape to be displayed
	 */
	public List<RenderedImage> getShapesToDisplay(EObject view) {
		@SuppressWarnings("unchecked")
		List<List<RenderedImage>> listOfListOfImages = (List<List<RenderedImage>>)execute(ExecutionStrategy.REVERSE, new GetShapesForViewOperation(view));
		List<RenderedImage> images = new ArrayList<RenderedImage>();
		for(List<RenderedImage> listOfImages : listOfListOfImages) {
			if(listOfImages != null && !listOfImages.isEmpty()) {
				images.addAll(listOfImages);
			}
		}
		return images;
	}

	/**
	 * Ask all the shape providers to add their required notification listeners to the diagram event broker.
	 * 
	 * @param diagramEventBroker
	 *        the diagram event broker used to manage notifications
	 * @param view
	 *        view on which required listened elements are retrieved
	 * @param notificationListener
	 *        notification listener that should be notified when there are modifications susceptible to change the shapes
	 */
	protected List<ProviderNotificationManager> createProviderNotificationManagers(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener notificationListener) {
		@SuppressWarnings("unchecked")
		List<ProviderNotificationManager> providerNotificationManagers = (List<ProviderNotificationManager>)execute(ExecutionStrategy.REVERSE, new CreateProviderNotificationManagersOperation(diagramEventBroker, view, notificationListener));
		return providerNotificationManagers;
	}

	/**
	 * gets the singleton instance
	 * 
	 * @return <code>PaletteService</code>
	 */
	public static synchronized ShapeService getInstance() {
		if(instance == null) {
			instance = new ShapeService();
			configureProviders();
		}
		return instance;
	}

	/**
	 * configure the extensions for this service.
	 */
	private static void configureProviders() {
		getInstance().configureProviders(Activator.ID, "shapeProvider"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * @{inheritDoc
	 */
	public List<IShapeProvider> getProviders() {
		List<IShapeProvider> providers = new ArrayList<IShapeProvider>();
		execute(ExecutionStrategy.REVERSE, new GetAllShapeProvidersOperation(providers));
		return providers;
	}

	/**
	 * @{inheritDoc
	 */
	public IShapeProvider getProvider(String id) {
		@SuppressWarnings("unchecked")
		List<IShapeProvider> providers = (List<IShapeProvider>)execute(ExecutionStrategy.REVERSE, new GetShapeProviderByIdentifierOperation(id));
		if(providers == null) {
			return null;
		}
		Iterator<IShapeProvider> it = providers.iterator();
		while(it.hasNext()) {
			IShapeProvider aspectActionProvider = it.next();
			if(aspectActionProvider != null) {
				return aspectActionProvider;
			}
		}
		return null;
	}

	/**
	 * A descriptor for aspect tool providers defined by a configuration
	 * element.
	 */
	protected static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/** the provider configuration parsed from XML */
		protected ShapeProviderConfiguration providerConfiguration;

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for the
		 * specified configuration element.
		 * 
		 * @param element
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);
			this.providerConfiguration = ShapeProviderConfiguration.parse(element);
			Assert.isNotNull(providerConfiguration);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}

			if(!(operation instanceof IShapeProviderOperation)) {
				return false;
			}
			
			if(operation instanceof GetShapeProviderByIdentifierOperation) {
				return providerConfiguration.getId().equals(((GetShapeProviderByIdentifierOperation)operation).getIdentifier());
			}
			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof IShapeProvider) {
					IShapeProvider defaultProvider = (IShapeProvider)newProvider;
					defaultProvider.setConfiguration(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

	/**
	 * Creates the notification manager, initializes it with all managers provided by the service providers, and returns it for the given view
	 * 
	 * @param diagramEventBroker
	 *        event broker on which provider managers register themselves.
	 * @param view
	 *        the view in charge of the display of the shapes
	 * @param notificationListener
	 *        the listener notified when the event broker fires a notification
	 * @return the created notification provider
	 */
	public NotificationManager createNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener notificationListener) {
		NotificationManager manager = new NotificationManager(view);
		List<ProviderNotificationManager> providerNotificationManagers = createProviderNotificationManagers(diagramEventBroker, view, notificationListener);
		manager.getProviderNotificationManagers().addAll(providerNotificationManagers);
		return manager;
	}

}
