/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  Ansgar Radermacher (CEA LIST) - Minor adaptations
 *
 *****************************************************************************/
package org.eclipse.papyrus.texteditor.cdt.factory;

import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.texteditor.cdt.Activator;
import org.eclipse.papyrus.texteditor.cdt.editor.PapyrusCDTEditor;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;


public class PapyrusCDTEditorFactory extends AbstractEditorFactory {

	/**
	 * Constructor.
	 */
	public PapyrusCDTEditorFactory() {
		super(PapyrusCDTEditor.class, PapyrusCDTEditor.EDITOR_TYPE);
	}

	/**
	 * Create the IPageModel that is used by the SashWindows to manage the editor.
	 * 
	 * @see org.eclipse.papyrus.infra.core.editorsfactory.IEditorFactory#createIPageModel(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 *        The model pushed in the sashmodel by the creation command
	 * @return A model implementing the IPageModel
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new TextEditorModelDelegate(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof TextEditorModel) {
			return ((TextEditorModel)pageIdentifier).getType().equals(this.getExpectedType());
		}
		return false;
	}

	/**
	 * IEditorModel used internally by the SashContainer. This model know how to handle IEditor creation.
	 * 
	 */
	class TextEditorModelDelegate implements IEditorModel {

		/**
		 * The created editor.
		 */
		private IEditorPart editor;

		/**
		 * The raw model stored in the SashProvider.
		 */
		private TextEditorModel rawEditorModel;

		/**
		 * 
		 * Constructor.
		 */
		public TextEditorModelDelegate(Object pageIdentifier) {
			rawEditorModel = (TextEditorModel)pageIdentifier;
		}

		/**
		 * Create the IEditor for the diagram.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel#createIEditorPart()
		 * @return
		 * @throws PartInitException
		 * 
		 */
		public IEditorPart createIEditorPart() throws PartInitException {
			try {
				//we use this way when there is one factory for several editor types
				//				Constructor<?> c = getDiagramClass().getConstructor(ServicesRegistry.class, TextEditorModel.class);
				//				editor = (IEditorPart)c.newInstance(servicesRegistry, rawModel);

				//we use this way when there is only one editor type
				editor = new PapyrusCDTEditor(getServiceRegistry(), rawEditorModel);
				return editor;

			} catch (Exception e) {
				// Lets propagate. This is an implementation problem that should be solved by
				// programmer.
				throw new PartInitException("Can't create TextEditor", e);
			}

		}

		/**
		 * Get the action bar requested by the Editor.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
		 * @return
		 * 
		 */
		public EditorActionBarContributor getActionBarContributor() {

			String actionBarId = editorDescriptor.getActionBarContributorId();

			// Do nothing if no EditorActionBarContributor is specify.
			if(actionBarId == null || actionBarId.length() == 0) {
				return null;
			}

			// Try to get it.

			// Get ServiceRegistry
			// ServicesRegistry serviceRegistry = getServicesRegistry();
			ActionBarContributorRegistry registry;
			try {
				registry = getServiceRegistry().getService(ActionBarContributorRegistry.class);
			} catch (ServiceException e) {
				// Service not found
				Activator.log.error(e);
				return null;
			}

			try {
				return registry.getActionBarContributor(actionBarId);
			} catch (BackboneException e) {
				Activator.log.error(e);
				return null;
			}
		}

		/**
		 * Get the underlying RawModel. Return the TextEditor (normally returns a diagram)
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getRawModel()
		 * @return
		 * 
		 */
		public Object getRawModel() {
			return rawModel;
		}

		/**
		 * Get the icon to be shown by Tabs
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabIcon()
		 * @return
		 * 
		 */
		public Image getTabIcon() {
			org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
				org.eclipse.papyrus.infra.widgets.Activator.getDefault();
			if(widgetsActivator == null) {
				return null;
			}
			String path = getEditorDescriptor().getIconURL();
			if (path.startsWith(Activator.PLUGIN_ID)) {
				// remove PLUGIN-ID prefix from the path (since the image will be searched relative to plugin) 
				path = path.substring(Activator.PLUGIN_ID.length());
			}
			return widgetsActivator.getImage(Activator.PLUGIN_ID, path);
		}

		/**
		 * Get the title of the Diagram.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 * 
		 */
		public String getTabTitle() {
			return rawEditorModel.getName();
		}
	}
}
