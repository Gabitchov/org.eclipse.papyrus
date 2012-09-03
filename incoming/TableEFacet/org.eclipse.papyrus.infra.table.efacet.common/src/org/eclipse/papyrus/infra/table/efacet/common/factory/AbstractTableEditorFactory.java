/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.factory;

import java.lang.reflect.Constructor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

public class AbstractTableEditorFactory extends AbstractEditorFactory {

	public AbstractTableEditorFactory(final Class<?> diagramClass, final String expectedType) {
		super(diagramClass, expectedType);
	}

	/**
	 * Create the IPageModel that is used by the SashWindows to manage the
	 * editor.
	 * 
	 * @see org.eclipse.papyrus.infra.core.editorsfactory.IEditorFactory#createIPageModel(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 *        The model pushed in the sashmodel by the creation command
	 * @return A model implementing the IPageModel
	 */
	public IPageModel createIPageModel(final Object pageIdentifier) {
		return new TableEditorModel(pageIdentifier, getServiceRegistry());
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public boolean isPageModelFactoryFor(final Object pageIdentifier) {
		if(pageIdentifier instanceof PapyrusTable) {
			return getExpectedType().equals(((PapyrusTable)pageIdentifier).getType());
		}
		return false;
	}

	/**
	 * IEditorModel used internally by the SashContainer. This model know how to
	 * handle IEditor creation.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	class TableEditorModel implements IEditorModel {

		/**
		 * The servicesRegistry provided at creation.
		 */
		private final ServicesRegistry servicesRegistry;

		/**
		 * The created editor.
		 */
		private IEditorPart editor;

		/**
		 * The raw model stored in the SashProvider.
		 */
		private final PapyrusTable rawModel;

		/**
		 * 
		 * Constructor.
		 */
		public TableEditorModel(final Object pageIdentifier, final ServicesRegistry servicesRegistry) {
			this.rawModel = (PapyrusTable)pageIdentifier;
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

				final Constructor<?> c = getDiagramClass().getConstructor(ServicesRegistry.class, PapyrusTable.class);
				final IEditorPart newEditor = (IEditorPart)c.newInstance(this.servicesRegistry, this.rawModel);
				this.editor = newEditor;
				return this.editor;

			} catch (final Exception e) {
				// Lets propagate. This is an implementation problem that should
				// be solved by
				// programmer.
				throw new PartInitException("Can't create TableEditor", e); //$NON-NLS-1$
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

			final String actionBarId = AbstractTableEditorFactory.this.editorDescriptor.getActionBarContributorId();

			// Do nothing if no EditorActionBarContributor is specify.
			if(actionBarId == null || actionBarId.length() == 0) {
				return null;
			}

			// Try to get it.

			// Get ServiceRegistry
			// ServicesRegistry serviceRegistry = getServicesRegistry();
			ActionBarContributorRegistry registry;
			try {
				registry = this.servicesRegistry.getService(ActionBarContributorRegistry.class);
			} catch (final ServiceException e) {
				Activator.log.error(e);
				return null;
			}

			try {
				return registry.getActionBarContributor(actionBarId);
			} catch (final BackboneException e) {
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
			return this.rawModel;
		}

		/**
		 * Get the icon to be shown by Tabs
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabIcon()
		 * @return
		 * 
		 */
		public Image getTabIcon() {
			final ImageDescriptor imageDescriptor = getEditorDescriptor().getIcon();
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
			return this.rawModel.getName();
		}
	}
}
