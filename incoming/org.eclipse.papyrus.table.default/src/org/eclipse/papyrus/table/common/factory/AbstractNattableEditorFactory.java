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
package org.eclipse.papyrus.table.common.factory;

import java.util.Map;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.table.common.editor.DefaultNattableEditor;
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
	 * @see org.eclipse.papyrus.core.editorsfactory.IEditorFactory#createIPageModel(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 *        The model pushed in the sashmodel by the creation command
	 * @return A model implementing the IPageModel
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new NattableEditorModel(pageIdentifier, getServiceRegistry());
	}

	/**
	 * @see org.eclipse.papyrus.core.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof TableInstance) {
			Object parameter = ((TableInstance)pageIdentifier).getParameter();
			if(parameter instanceof Map<?, ?>) {
				return getExpectedType().equals(((Map<?, ?>)parameter).get(AbstractNattableEditor.TYPE_KEY));
			}
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
		 * The created editor.
		 */
		private IEditorPart editor;

		/**
		 * The raw model stored in the SashProvider.
		 */
		private TableInstance rawModel;

		/**
		 * 
		 * Constructor.
		 */
		public NattableEditorModel(Object pageIdentifier, ServicesRegistry servicesRegistry) {
			rawModel = (TableInstance)pageIdentifier;
			this.servicesRegistry = servicesRegistry;
		}

		/**
		 * Create the IEditor for the diagram.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#createIEditorPart()
		 * @return
		 * @throws PartInitException
		 * 
		 */
		public IEditorPart createIEditorPart() throws PartInitException {
			try {
				IEditorPart newEditor = new DefaultNattableEditor(getServiceRegistry(), rawModel);
				editor = newEditor;
				return newEditor;

			} catch (Exception e) {
				// Lets propagate. This is an implementation problem that should be solved by
				// programmer.
				throw new PartInitException("Can't create TextEditor", e);
			}

		}

		/**
		 * Get the action bar requested by the Editor.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
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
		 * Get the underlying RawModel. Return the Diagram.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getRawModel()
		 * @return
		 * 
		 */
		public Object getRawModel() {
			return rawModel;
		}

		/**
		 * Get the icon to be shown by Tabs
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabIcon()
		 * @return
		 * 
		 */
		public Image getTabIcon() {
			ImageDescriptor imageDescriptor = getEditorDescriptor().getIcon();
			if(imageDescriptor == null)
				return null;

			return imageDescriptor.createImage();
		}

		/**
		 * Get the title of the Diagram.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 * 
		 */
		public String getTabTitle() {
			if(rawModel instanceof TableInstance) {
				Object param = rawModel.getParameter();
				if(param instanceof Map<?, ?>) {
					String name = (String)((Map)param).get(AbstractNattableEditor.NAME_KEY);
					if(name != null) {
						return name;
					}
				}
			}
			return "";
		}
	}
}
