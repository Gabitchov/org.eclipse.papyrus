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
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.adapters.modisco;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * @author cedric dumoulin
 * 
 */
public class ModiscoBrowserEditorFactory extends AbstractEditorFactory {

	/** name of the emf diagram in Di2 type diagram 
	 * TODO Use something else than a Diagram to mark the editor. Add a class in sashdi.
	 */
	public static final String MODISCO_EDITOR_TYPE = "modiscoBrowser";

	/**
	 * @param diagramClass
	 * @param expectedType
	 */
	public ModiscoBrowserEditorFactory() {
		// TODO remove next once the unused methods will be removed
		super(null, null);
	}


	/**
	 * TODO Implements next methods
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IPluggableEditorFactory#createIPageModel(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new ModiscoBrowserPageModel((Diagram)pageIdentifier, getServiceRegistry());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IPluggableEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof Diagram) {
			Diagram diagram = (Diagram)pageIdentifier;

			if(MODISCO_EDITOR_TYPE.equals(diagram.getType())) {
				return true;
			}
		}
		// no
		return false;
	}
	
	
	/**
	 * Inner class.
	 * A model representing the modisco browser in the sasheditor provider.
	 * @author dumoulin
	 *
	 */
	public class ModiscoBrowserPageModel implements IEditorModel {

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
		public ModiscoBrowserPageModel(Diagram pageIdentifier, ServicesRegistry servicesRegistry) {
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
				return new ModiscoBrowserEditor(servicesRegistry);
			} catch (ServiceException e) {
				throw new PartInitException("Can't create ModiscoEditor.", e);
			} catch (BackboneException e) {
				throw new PartInitException("Can't create ModiscoEditor.", e);
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
				registry = (ActionBarContributorRegistry)servicesRegistry
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
			if(imageDescriptor == null)
				return null;

			return imageDescriptor.createImage();
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 * 
		 */
		public String getTabTitle() {
			return "Modisco";
		}

		
	}
}
