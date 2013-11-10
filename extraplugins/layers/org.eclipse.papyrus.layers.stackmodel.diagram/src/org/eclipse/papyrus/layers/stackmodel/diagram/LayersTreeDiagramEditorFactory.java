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
package org.eclipse.papyrus.layers.stackmodel.diagram;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.IPluggableEditorFactory;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class LayersTreeDiagramEditorFactory implements IPluggableEditorFactory {

	/**
	 * Descriptor of the editor. Values come from the declaration in the extension point. The
	 * descriptor is set by the EditorFactory.
	 */
	private EditorDescriptor editorDescriptor;

	/**
	 * ServiceRegistry that can be provided to created editors.
	 */
	private ServicesRegistry serviceRegistry;

	/** name of the diagram in the di model */
	public static final String EMF_DIAGRAM_TYPE = "layersTree";

	public LayersTreeDiagramEditorFactory() {
	}

	/**
	 * Initialize the factory with useful Classes.
	 * @see IPluggableEditorFactory#init(ServicesRegistry, EditorDescriptor)
	 * 
	 * @param serviceRegistry Service registry that will be provided to created editor.
	 * @param editorDescriptor Descriptor containing data from the Eclipse Extension.
	 */
	public void init(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
		this.serviceRegistry = serviceRegistry;

	}

	/**
	 * TODO Implements next methods
	 * 
	 * @see org.eclipse.papyrus.infra.core.extension.diagrameditor.IPluggableEditorFactory#createIPageModel(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new EmfTreeEditorModel((Diagram)pageIdentifier, serviceRegistry);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.extension.diagrameditor.IPluggableEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof Diagram) {
			Diagram diagram = (Diagram)pageIdentifier;

			if(EMF_DIAGRAM_TYPE.equals(diagram.getType())) {
				return true;
			}
		}
		// no
		return false;
	}

	/**
	 * Model used to describe an instance of this editor in the SashSystem.
	 * 
	 */
	public class EmfTreeEditorModel implements IEditorModel {

		/**
		 * The object used as page identifier and rawModel.
		 */
		private Diagram pageIdentifier;

		private ServicesRegistry servicesRegistry;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param pageIdentifier
		 * @param servicesRegistry
		 */
		public EmfTreeEditorModel(Diagram pageIdentifier, ServicesRegistry servicesRegistry) {
			this.pageIdentifier = pageIdentifier;
			this.servicesRegistry = servicesRegistry;
		}

		/**
		 * Create the instance of the editor.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#createIEditorPart()
		 * @return
		 * @throws PartInitException
		 * 
		 */
		public IEditorPart createIEditorPart() throws PartInitException {
			try {
				return new LayersTreeEditorDiagram(servicesRegistry);
			} catch (ServiceException e) {
				throw new PartInitException("Can't create Di2Editor.", e);
			} catch (BackboneException e) {
				throw new PartInitException("Can't create Di2Editor.", e);
			}
		}

		public EditorActionBarContributor getActionBarContributor() {

			String actionBarId = editorDescriptor.getActionBarContributorId();

			// Do nothing if no EditorActionBarContributor is specify.
			if(actionBarId == null || actionBarId.length() == 0) {
				return null;
			}

			// Try to get it.

			// Get ServiceRegistry
			ActionBarContributorRegistry registry;
			try {
				registry = servicesRegistry
					.getService(ActionBarContributorRegistry.class);
			} catch (ServiceException e) {
				// Service not found
				// TODO Log the error
				e.printStackTrace();
				return null;
			}

			try {
				return registry.getActionBarContributor(actionBarId);
			} catch (BackboneException e) {
				// TODO Log the error and throw an exception instead
				e.printStackTrace();
				return null;
			}
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getRawModel()
		 * @return
		 * 
		 */
		public Object getRawModel() {
			return pageIdentifier;
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabIcon()
		 * @return
		 * 
		 */
		public Image getTabIcon() {
			ImageDescriptor imageDescriptor = editorDescriptor.getIcon();
			if(imageDescriptor == null) {
				return null;
			}

			return imageDescriptor.createImage();
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 * 
		 */
		public String getTabTitle() {
			return "Layers Tree Editor";
		}

	}
}
