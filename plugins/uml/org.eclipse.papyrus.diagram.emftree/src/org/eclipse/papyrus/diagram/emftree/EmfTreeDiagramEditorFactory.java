/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.emftree;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory;
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
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class EmfTreeDiagramEditorFactory implements IEditorFactory {

	/**
	 * Descriptor of the editor. Values come from the declaration in the extension point. The
	 * descriptor is set by the EditorFactory.
	 */
	private EditorDescriptor editorDescriptor;

	/** name of the emf diagram in Di2 type diagram */
	public static final String EMF_DIAGRAM_TYPE = "emftree";

	public EmfTreeDiagramEditorFactory() {
	}

	/**
	 * TODO Implements next methods
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#createIPageModel(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry serviceRegistry) {
		return new EmfTreeEditorModel((Diagram)pageIdentifier, serviceRegistry);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
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
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#setEditorDescriptor(org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor)
	 * @param editorDescriptor
	 * 
	 */
	public void init(EditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * Model used to describe an instance of this editor in the SashSystem.
	 * 
	 * @author dumoulin
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
				return new UMLEditor(servicesRegistry);
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
			return "EmfTree";
		}

	}
}
