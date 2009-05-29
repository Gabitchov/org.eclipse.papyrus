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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import java.lang.reflect.Constructor;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Base class of GmfEditor factories. Editor should subclass this class and provide a 0 args constructor initializing the super class.
 * 
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class GmfEditorFactory extends AbstractEditorFactory {

	public static final String GMF_DIAGRAM = "diagram.gmf";

	/**
	 * Creates a new GmfEditorFactory.
	 * 
	 * @param diagramClass
	 *            expected Class of the diagram to create.
	 * @param expectedType
	 *            expected diagram type (@see {@link Diagram#getType()})
	 */
	protected GmfEditorFactory(Class<?> diagramClass, String expectedType) {
		super(diagramClass, expectedType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEditorFor(Object root) {

		// TODO Change next to remove dependency on di2.
		// Retrieve GMF diagram, if any.
		if (root instanceof org.eclipse.papyrus.di.Diagram) {
			org.eclipse.papyrus.di.Diagram di2Diagram = (org.eclipse.papyrus.di.Diagram) root;
			//FIXME set the correct type in backbone
			//if (!GMF_DIAGRAM.equals(di2Diagram.getType()))
			//	return false;
 			// Ok, this is a gmf diagram
			if(di2Diagram.getSemanticModel() instanceof CoreSemanticModelBridge){
				root = ((CoreSemanticModelBridge) di2Diagram.getSemanticModel()).getElement();
			}
		}
		
		if (root instanceof Diagram) {
			Diagram diagram = (Diagram) root;
			final String type = diagram.getType();
			return getExpectedType().equals(type);
		}
		// no
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEditorPart createEditorFor(IEditorContext context, Object root) throws BackboneException {
		assert (context instanceof GmfEditorContext);
		return createEditorFor((GmfEditorContext) context, root);
	}

	/**
	 * It is used to create the editor by taking account the root element, for example a diagram
	 * 
	 * @param context
	 *            the gmf context
	 * @param root
	 *            the element on which the editor can be launch , for example the editor
	 * @return the created editor
	 * @throws BackboneException
	 *             editor could not be created
	 */
	public IEditorPart createEditorFor(GmfEditorContext context, Object root) throws BackboneException {
		GraphicalEditor editor;

		// TODO Change next to remove dependency on di2.
		// Retrieve GMF diagram, if any.
		if (root instanceof org.eclipse.papyrus.di.Diagram) {
			org.eclipse.papyrus.di.Diagram di2Diagram = (org.eclipse.papyrus.di.Diagram) root;
			if (!GMF_DIAGRAM.equals(di2Diagram.getType()))
				throw new BackboneException("Problem retrieving GMF Diagram.");
			// Ok, this is a gmf diagram
			root = ((CoreSemanticModelBridge) di2Diagram.getSemanticModel()).getElement();
		}

		try {
			Constructor<?> c = getDiagramClass().getConstructor(Diagram.class, GmfEditorContext.class);
			editor = (GraphicalEditor) c.newInstance((Diagram) root, context);
			// editor = new ClassDiagramEditor((Diagram)root, context.getModelMngr(), context.getCommandStack(), context.getActionRegistry() );
			return editor;

		} catch (Exception e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new BackboneException(e);
		}
	}
	
	/**
	 * Return true if this PageModelFactory can create a PageModel for the specified pageIdentifier.
	 * The pageIdentifier is an instance of Diagram.
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 *
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		
		if (pageIdentifier instanceof Diagram) {
			Diagram diagram = (Diagram) pageIdentifier;
			final String type = diagram.getType();
			return getExpectedType().equals(type);
		}
		// no
		return false;

	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#createIPageModel(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 *
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry servicesRegistry) {
		
		return new GMFEditorModel((Diagram)pageIdentifier, servicesRegistry);
	}

	/**
	 * IEditorModel handling creation of the requested Editor.
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
		public GMFEditorModel( Diagram pageIdentifier, ServicesRegistry servicesRegistry) {
			diagram = pageIdentifier;
			this.servicesRegistry = servicesRegistry;
		}
		
		/**
		 * Create the IEditor for the diagram.
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#createIEditorPart()
		 * @return
		 * @throws PartInitException
		 *
		 */
		public IEditorPart createIEditorPart() throws PartInitException {
			GraphicalEditor editor;
			try {
				Constructor<?> c = getDiagramClass().getConstructor(ServicesRegistry.class, Diagram.class);
				editor = (GraphicalEditor) c.newInstance(servicesRegistry, diagram);
				return editor;

			} catch (Exception e) {
				// Lets propagate. This is an implementation problem that should be solved by programmer.
				throw new PartInitException("Can't create IEditorPart for gmf.Diagram '" + diagram + "'.", e);
			}

		}

		/**
		 * Get the action bar requested by the Editor.
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
		 * @return
		 *
		 */
		public EditorActionBarContributor getActionBarContributor() {
			
			String actionBarId = editorDescriptor.getActionBarContributorId();

			// Do nothing if no EditorActionBarContributor is specify.
			if(actionBarId == null || actionBarId.length() == 0)
			{
				return null;
			}
			
			// Try to get it.
			
			// Get ServiceRegistry
//			ServicesRegistry serviceRegistry = getServicesRegistry();
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
				return registry.getActionBarContributor(actionBarId );
			} catch (BackboneException e) {
				// TODO Log the error and throw an exception instead
				e.printStackTrace();
				return null;
			}
		}

		/**
		 * Get the underlying RawModel. Return the Diagram.
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getRawModel()
		 * @return
		 *
		 */
		public Object getRawModel() {
			return diagram;
		}

		/**
		 * Get the icon to be shown by Tabs
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
		 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
		 * @return
		 *
		 */
		public String getTabTitle() {
			return diagram.getName();
		}
		
	}


}
