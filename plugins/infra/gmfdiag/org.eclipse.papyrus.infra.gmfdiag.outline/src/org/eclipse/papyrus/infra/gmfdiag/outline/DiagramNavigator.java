/***********************************************************************
 * Copyright (c) 2007, 2008, 2009 Anyware Technologies, Obeo.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *    Obeo 
 * 
 **********************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IViewerNotification;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.outline.internal.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * <b>Diagram navigator :</b><br>
 * Display the content of the current diagram. <br>
 * 
 * Updated : 18 feb. 2008
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramNavigator extends Composite {

	private TreeViewer viewer;

	/**
	 * The creation command registry
	 */
	ICreationCommandRegistry creationCommandRegistry;

	private final ServicesRegistry registry;

	/**
	 * This content provider filters the event from graphical object to only refresh when it's
	 * needed.
	 * 
	 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
	 */
	protected class NavigatorAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

		/**
		 * Constructor
		 * 
		 * @param adapterFactory
		 *        the factory
		 */
		public NavigatorAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		/**
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification notification) {
			if(notification instanceof IViewerNotification) {
				Object element = ((IViewerNotification)notification).getElement();
				if(!(element instanceof View)) {
					// Filter only non-graphical object events
					super.notifyChanged(notification);
				} else if((element instanceof Diagram) && ((IViewerNotification)notification).isLabelUpdate()) {
					// A diagram or a Diagrams is added or removed : refresh the
					// whole tree
					refreshViewer(true);
				}
			} else {
				super.notifyChanged(notification);
			}
		}
	}

	/**
	 * Constructor
	 * 
	 * @param parent
	 *        the parent composite
	 * @param diagEditor
	 *        the viewer to edit as tree
	 * @param pageSite
	 *        the site
	 */
	public DiagramNavigator(Composite parent, IPageSite pageSite, ServicesRegistry registry) {
		super(parent, SWT.BORDER);
		this.registry = registry;
		GridLayout gl = new GridLayout();
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		setLayout(gl);
		createContents(this);
	}

	/**
	 * Returns the TreeViewer used as navigator
	 * 
	 * @return the navigable tree
	 */
	public TreeViewer getTreeViewer() {
		return viewer;
	}

	public void setSelection(ISelection selection) {
		getTreeViewer().setSelection(selection, true);
	}

	/**
	 * Create the contents of the widget
	 * 
	 * @param parent
	 *        the current widget
	 */
	protected void createContents(Composite parent) {
		this.viewer = new TreeViewer(parent, SWT.MULTI);
		this.viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		initProviders();
		refreshViewer();
	}

	/**
	 * Set the tree providers for the outline
	 */
	protected void initProviders() {
		AdapterFactoryContentProvider adapterContentProvider = new NavigatorAdapterFactoryContentProvider(getAdapterFactory());
		adapterContentProvider.inputChanged(viewer, null, null);
		viewer.setContentProvider(new DiagramOrientedContentProvider(adapterContentProvider));
		try {
			ILabelProvider labelProvider = ServiceUtils.getInstance().getService(LabelProviderService.class, registry).getLabelProvider();
			ILabelProvider fullLabelProvider = new DecoratingLabelProvider(labelProvider, Activator.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator());
			viewer.setLabelProvider(fullLabelProvider);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Refresh the tree viewer in the UI thread if we are in a different thread
	 */
	protected final void refreshViewer() {
		refreshViewer(false);
	}

	/**
	 * Refresh the tree viewer in the UI thread if we are in a different thread
	 * 
	 * @param updateLabel
	 *        <code>true</code> if the label must be refreshed
	 */
	protected final void refreshViewer(final boolean updateLabel) {
		if((viewer != null) && !viewer.getTree().isDisposed()) {
			if(Display.getCurrent() != Display.getDefault()) {
				syncRefreshViewer(updateLabel);
			} else {
				viewer.refresh(updateLabel);
			}
		}
	}

	/**
	 * Refresh the tree viewer in the UI thread
	 * 
	 * @param updateLabel
	 *        <code>true</code> if the label must be refreshed
	 */
	private void syncRefreshViewer(final boolean updateLabel) {
		viewer.getControl().getDisplay().syncExec(new Runnable() {

			public void run() {
				viewer.refresh(updateLabel);
			}
		});
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * Get the AdapterFactory associated with an editor
	 * 
	 * @return AdapterFactory
	 */
	protected AdapterFactory getAdapterFactory() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}

}
