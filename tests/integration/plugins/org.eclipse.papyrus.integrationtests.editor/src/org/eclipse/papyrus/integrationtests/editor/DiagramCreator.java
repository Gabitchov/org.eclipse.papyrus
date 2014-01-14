/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.integrationtests.editor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.emftree.CreateEMFTreeDiagramHandler;


/**
 * This class is used to create programmatically various diagram available in Papyrus.
 * <br>
 * This class is designed for tests purpose. It is not intended to be used in regular editor.
 * 
 * @author cedric dumoulin
 *
 */
public class DiagramCreator {

	public ProgramaticPapyrusEditor editorCreator;
	
	/**
	 * Constructor.
	 *
	 */
	public DiagramCreator(ProgramaticPapyrusEditor editorCreator) {
		this.editorCreator = editorCreator;
	}

	/**
	 * Create a diagram of the requested type. Return the {@link IPage} used in {@link ISashWindowsContainer}.
	 * @param name
	 * @return
	 * @throws DiagramCreationException 
	 */
	public IPage createClassDiagram(String name) throws DiagramCreationException {
		
		try {
			ModelSet modelSet = editorCreator.getModelSet();
			
			ICreationCommand command = new CreateClassDiagramCommand();
			command.createDiagram(modelSet, null, name);

			// Return the page created by the container.
			// This should be the activePage
			ISashWindowsContainer container = editorCreator.getServiceRegistry().getService(ISashWindowsContainer.class);
			return container.getActiveSashWindowsPage();
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new DiagramCreationException(e);
		}
	}
	
	/**
	 * Create a diagram of the requested type. Return the {@link IPage} used in {@link ISashWindowsContainer}.
	 * @param name
	 * @return
	 * @throws DiagramCreationException 
	 */
	public IPage createActivityDiagram(String name) throws DiagramCreationException {
		
		try {
			ModelSet modelSet = editorCreator.getModelSet();
			
			ICreationCommand command = new CreateActivityDiagramCommand();
			command.createDiagram(modelSet, null, name);

			// Return the page created by the container.
			// This should be the activePage
			ISashWindowsContainer container = editorCreator.getServiceRegistry().getService(ISashWindowsContainer.class);
			return container.getActiveSashWindowsPage();
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new DiagramCreationException(e);
		}
	}
	/**
	 * Create a diagram of the requested type. Return the {@link IPage} used in {@link ISashWindowsContainer}.
	 * @param name
	 * @return
	 * @throws DiagramCreationException 
	 */
	public IPage createEmfTreeDiagram(String name) throws DiagramCreationException {
		
		try {
			ModelSet modelSet = editorCreator.getModelSet();
			
			CreateEMFTreeDiagramHandler command = new CreateEMFTreeDiagramHandler();
			command.execute(editorCreator.getServiceRegistry());

			// Return the page created by the container.
			// This should be the activePage
			ISashWindowsContainer container = editorCreator.getServiceRegistry().getService(ISashWindowsContainer.class);
			return container.getActiveSashWindowsPage();
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new DiagramCreationException(e);
		} catch (ExecutionException e) {
			throw new DiagramCreationException(e);
		}
	}
}
