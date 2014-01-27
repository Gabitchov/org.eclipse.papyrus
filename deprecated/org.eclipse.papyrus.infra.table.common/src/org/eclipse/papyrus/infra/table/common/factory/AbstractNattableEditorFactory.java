/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.factory;

import java.lang.reflect.Constructor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.common.Activator;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Abstract factory for the NattableEditor
 * 
 * 
 * 
 */
public abstract class AbstractNattableEditorFactory extends AbstractEditorFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editorClass
	 *        the editor class
	 * @param editorType
	 *        the type of editor
	 */
	public AbstractNattableEditorFactory(Class<?> editorClass, String editorType) {
		super(editorClass, editorType);
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
		return new NattableEditorModel(pageIdentifier, getServiceRegistry());
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof PapyrusTableInstance) {
			return getExpectedType().equals(((PapyrusTableInstance)pageIdentifier).getType());
		}
		return false;
	}

	/**
	 * IEditorModel used internally by the SashContainer. This model know how to handle IEditor creation.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	class NattableEditorModel implements IEditorModel {


		/**
		 * The servicesRegistry provided at creation.
		 */
		private ServicesRegistry servicesRegistry;

		/**
		 * The raw model stored in the SashProvider.
		 */
		private PapyrusTableInstance rawModel;

		/**
		 * 
		 * Constructor.
		 */
		public NattableEditorModel(Object pageIdentifier, ServicesRegistry servicesRegistry) {
			rawModel = (PapyrusTableInstance)pageIdentifier;
			this.servicesRegistry = servicesRegistry;
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

				Constructor<?> c = getDiagramClass().getConstructor(ServicesRegistry.class, PapyrusTableInstance.class);
				IEditorPart newEditor = (IEditorPart)c.newInstance(servicesRegistry, rawModel);
				//	IEditorPart newEditor = new DefaultNattableEditor(getServiceRegistry(), rawModel);
				return newEditor;
			} catch (Exception e) {
				// Lets propagate. This is an implementation problem that should be solved by
				// programmer.
				throw new PartInitException("Can't create TextEditor", e); //$NON-NLS-1$
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
				registry = servicesRegistry.getService(ActionBarContributorRegistry.class);
			} catch (ServiceException e) {
				// Service not found
				Activator.log.error(e);
				return null;
			}

			try {
				return registry.getActionBarContributor(actionBarId);
			} catch (BackboneException e) {
				// TODO Log the error and throw an exception instead
				Activator.log.error(e);
				return null;
			}
		}

		/**
		 * Get the underlying RawModel. Return the Diagram.
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
			ImageDescriptor imageDescriptor = getEditorDescriptor().getIcon();
			if(imageDescriptor == null) {
				return null;
			}

			return imageDescriptor.createImage();
		}

		/**
		 * Get the title of the Diagram.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 * 
		 */
		public String getTabTitle() {
			return rawModel.getName();
		}
	}
}
