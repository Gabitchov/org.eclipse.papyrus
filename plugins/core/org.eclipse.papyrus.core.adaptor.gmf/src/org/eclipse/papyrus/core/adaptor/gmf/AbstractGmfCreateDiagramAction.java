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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.sasheditor.extension.ICreateDiagramAction;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramSharedObjects;
import org.eclipse.uml2.diagram.clazz.part.Messages;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;



/**
 * Action creating a new diagram.
 * 
 * @deprecated Use Eclipse native extension mechanism instead.
 * TODO Remove it.

 * @author dumoulin
 *
 */
public abstract class AbstractGmfCreateDiagramAction implements ICreateDiagramAction {

    
    /**
     * Delegate to cast the parameter.
     */
    public void run(MultiDiagramSharedObjects sharedObjects) {
        run((GmfMultiDiagramSharedObjects)sharedObjects);  
    }
    
    /**
     * Create a new class diagram
     */
    public void run(GmfMultiDiagramSharedObjects sharedObjects) {
        final String diagramName = getDiagramName();
        
        final Resource modelResource = sharedObjects.getDomainResource();
        final Resource diagramResource = sharedObjects.getNotationResource();
        TransactionalEditingDomain editingDomain = sharedObjects.getEditingDomain();
        
        
        
        AbstractTransactionalCommand command = new AbstractTransactionalCommand(
                editingDomain,
                Messages.UMLDiagramEditorUtil_CreateDiagramCommandLabel,
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                
                Element model = createInitialModel();
                attachModelToResource(model, modelResource);

                Diagram diagram = ViewService.createDiagram(model, getDiagramNotationID(), getPreferenceHint());
                if (diagram != null) {
                    diagram.setName(diagramName);
                    diagram.setElement(model);
                    diagramResource.getContents().add(diagram);
                }

                return CommandResult.newOKCommandResult();
            }
        };
        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new NullProgressMonitor(), null);
        } catch (ExecutionException e) {
            UMLDiagramEditorPlugin.getInstance().logError(
                    "Unable to create model and diagram", e); //$NON-NLS-1$
        }
    }
    
    /**
     * Create a new instance of domain element associated with canvas.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    abstract protected Element createInitialModel();
//        protected Package createInitialModel() {
//        return UMLFactory.eINSTANCE.createPackage();
//    }

    /**
     * Store model element in the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void attachModelToResource(Element model, Resource resource) {
        resource.getContents().add(model);
    }

    /**
     * @return
     */
    abstract protected String getDiagramNotationID();
    /**
     * @return
     */
    abstract protected PreferencesHint getPreferenceHint();

 
    /**
     * Get the name used for diagram.
     * @return
     */
    abstract protected String getDiagramName();

}
