/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - service hook for integrating tools into graphical editor (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common;

import java.lang.reflect.Constructor;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.AbstractEditorFactory;
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
 * Base class of GmfEditor factories. Editor should subclass this class and provide a 0 args
 * constructor initializing the super class.
 * 
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class GmfEditorFactory extends AbstractEditorFactory {

	/**
	 * Creates a new GmfEditorFactory.
	 * 
	 * @param diagramClass
	 *        expected Class of the diagram to create.
	 * @param expectedType
	 *        expected diagram type (@see {@link Diagram#getType()})
	 */
	protected GmfEditorFactory(Class<?> diagramClass, String expectedType) {
		super(diagramClass, expectedType);
	}

	/**
	 * Return true if this PageModelFactory can create a PageModel for the specified pageIdentifier.
	 * The pageIdentifier is an instance of Diagram.
	 * 
	 * @see org.eclipse.papyrus.infra.core.extension.diagrameditor.IPluggableEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {

		if(pageIdentifier instanceof Diagram) {
			Diagram diagram = (Diagram)pageIdentifier;
			// disable it when diagram is a proxy (dedicated factory will handle it)
			if(!diagram.eIsProxy()) {
				final String type = diagram.getType();
				return getExpectedType().equals(type);
			}
		}
		// no
		return false;

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.extension.diagrameditor.IPluggableEditorFactory#createIPageModel(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {

		return new GMFEditorModel((Diagram)pageIdentifier, getServiceRegistry());
	}

	/**
	 * IEditorModel handling creation of the requested Editor.
	 * 
	 * @author dumoulin
	 * 
	 */
	class GMFEditorModel implements IEditorModel {

		/**
		 * The Diagram object describing the diagram.
		 */
		private Diagram diagram;

		/**
		 * The servicesRegistry provided at creation.
		 */
		private ServicesRegistry servicesRegistry;

		/**
		 * 
		 * Constructor.
		 */
		public GMFEditorModel(Diagram pageIdentifier, ServicesRegistry servicesRegistry) {
			diagram = pageIdentifier;
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
			GraphicalEditor editor;
			try {
				Constructor<?> c = getDiagramClass().getConstructor(ServicesRegistry.class, Diagram.class);
				editor = (GraphicalEditor)c.newInstance(servicesRegistry, diagram);
				
				IGraphicalEditorSupport editorSupport = servicesRegistry.getService(IGraphicalEditorSupport.class);
				editorSupport.initialize(editor);
				
				return editor;

			} catch (Exception e) {
				// Lets propagate. This is an implementation problem that should be solved by
				// programmer.
				throw new PartInitException(Messages.GmfEditorFactory_ErrorCreatingEditorPart + diagram, e);
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
				registry = (ActionBarContributorRegistry)servicesRegistry.getService(ActionBarContributorRegistry.class);
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
		 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getRawModel()
		 * @return
		 * 
		 */
		public Object getRawModel() {
			return diagram;
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
			if(imageDescriptor == null)
				return null;

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
			return diagram.getName();
		}

	}

}
