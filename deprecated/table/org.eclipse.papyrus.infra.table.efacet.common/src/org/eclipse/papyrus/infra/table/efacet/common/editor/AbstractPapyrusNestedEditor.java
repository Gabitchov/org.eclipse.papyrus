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
package org.eclipse.papyrus.infra.table.efacet.common.editor;

import java.util.EventObject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.EditorPart;

//TODO : we should continue to develp this class in order it looks like to the abstract class of GMFDiagramEditor in Papyrus then move it in an upper plugin
public abstract class AbstractPapyrusNestedEditor extends EditorPart implements IEditingDomainProvider {

	protected final ServicesRegistry servicesRegistry;

	private final CommandStackListener commandListener = new CommandStackListener() {

		public void commandStackChanged(final EventObject event) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					firePropertyChange(PROP_DIRTY);
				}
			});
		}
	};

	public AbstractPapyrusNestedEditor(final ServicesRegistry registry) {
		this.servicesRegistry = registry;
	}

	public final EditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This sets up the editing domain for the model editor
	 */
	protected void configureEditorEditingDomain() {
		Assert.isNotNull(getEditingDomain());
		getEditingDomain().getCommandStack().removeCommandStackListener(this.commandListener);
		getEditingDomain().getCommandStack().addCommandStackListener(this.commandListener);
	}

	@Override
	public void dispose() {
		super.dispose();
		getEditingDomain().getCommandStack().removeCommandStackListener(this.commandListener);
	}

	// /**
	// * The location of diagram icon in the plug-in
	// */
	// private static final String DIAG_IMG_PATH =
	// "icons/obj16/Diagram_Class.gif";
	//
	// /**
	// * The image descriptor of the diagram icon
	// */
	// private static final ImageDescriptor DIAG_IMG_DESC =
	// UMLDiagramEditorPlugin.getBundledImageDescriptor(UmlClassDiagramForMultiEditor.DIAG_IMG_PATH);
	//
	//
	// /**
	// * @generated
	// */
	//	public static final String ID = "org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorID"; //$NON-NLS-1$
	//
	// /**
	// * @generated
	// */
	//	public static final String CONTEXT_ID = "org.eclipse.papyrus.uml.diagram.clazz.ui.diagramContext"; //$NON-NLS-1$
	//
	// @Override
	// public void doSave(final IProgressMonitor monitor) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void doSaveAs() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void init(final IEditorSite site, final IEditorInput input) throws
	// PartInitException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean isDirty() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean isSaveAsAllowed() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void createPartControl(final Composite parent) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void setFocus() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// /**
	// * @generated
	// */
	// @Override
	// protected PreferencesHint getPreferencesHint() {
	// return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	// }
	//
	// /**
	// * @generated
	// */
	// public void gotoMarker(final IMarker marker) {
	// MarkerNavigationService.getInstance().gotoMarker(this, marker);
	// }
	//
	// /**
	// * @generated
	// */
	// @Override
	// public boolean isSaveAsAllowed() {
	// return true;
	// }
	//
	// /**
	// * @generated
	// */
	// @Override
	// protected String getContextID() {
	// return CONTEXT_ID;
	// }
	//
	// /**
	// * @generated
	// */
	// @Override
	// public TransactionalEditingDomain getEditingDomain() {
	// return editingDomain;
	// }
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin
	// /**
	// * @generated
	// */
	// @Override
	// public void doSaveAs() {
	// performSaveAs(new NullProgressMonitor());
	// }
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin
	// /**
	// * @generated
	// */
	// @Override
	// protected void performSaveAs(final IProgressMonitor progressMonitor) {
	// // Nothing
	// }
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin
	// /**
	// * @generated
	// */
	// @Override
	// protected TransactionalEditingDomain createEditingDomain() {
	// // Already configured
	// return editingDomain;
	// }
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin
	// /**
	// * @generated
	// */
	// @Override
	// protected void configureDiagramEditDomain() {
	// super.configureDiagramEditDomain();
	// getDiagramEditDomain().getDiagramCommandStack().addCommandStackListener(new
	// CommandStackListener() {
	//
	// public void commandStackChanged(final EventObject event) {
	// firePropertyChange(IEditorPart.PROP_DIRTY);
	// }
	// });
	// }
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin
	// /**
	// * @generated
	// */
	//	@Override
	//	public void doSave(final IProgressMonitor progressMonitor) {
	//		// The saving of the resource is done by the CoreMultiDiagramEditor
	//		lastSavdeOperation = getOperationHistory().getUndoOperation(getUndoContext());
	//	}
	//
	// //------------------------//from UMLDiagramEditor (in class diagram
	// plugin

	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// * The associated Diagram.
	// */
	// private Diagram diagram;
	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// * Object used to synchronize the name of the editor with the name of the
	// * diagram.
	// */
	// private PartNameSynchronizer partNameSynchronizer;
	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// * service serviceRegistry of the backbone
	// */
	// private ServicesRegistry servicesRegistry;
	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// * Constructor.
	// *
	// * @param servicesRegistry
	// * @param diagram
	// * @throws ServiceException
	// */
	// public UmlGmfDiagramEditor(final ServicesRegistry servicesRegistry, final
	// Diagram diagram) throws ServiceException {
	// super(true);
	// this.diagram = diagram;
	// this.servicesRegistry = servicesRegistry;
	// // Install synchronizer
	// this.partNameSynchronizer = new PartNameSynchronizer(diagram);
	//
	// // Register this part to the ISaveAndDirtyService.
	// // This will allows to be notified of saveAs events, and the isDirty
	// // flag will be taken into
	// // account.
	// final ISaveAndDirtyService saveAndDirtyService =
	// servicesRegistry.getService(ISaveAndDirtyService.class);
	// saveAndDirtyService.registerIsaveablePart(this);
	//
	// // TODO: unregister when editor is disposed !
	// }
	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// * Dispose services used in this part.
	// *
	// * @see
	// org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#dispose()
	// *
	// */
	// @Override
	// public void dispose() {
	// super.dispose();
	//
	// ISaveAndDirtyService saveAndDirtyService;
	// try {
	// saveAndDirtyService =
	// this.servicesRegistry.getService(ISaveAndDirtyService.class);
	// saveAndDirtyService.removeIsaveablePart(this);
	//
	// } catch (final ServiceException e) {
	// // the service can't be found. Maybe it is already disposed.
	// // Do nothing
	// }
	//
	// }
	//
	// //---------fro mUMLGrmfDiagramEditor
	// /**
	// *
	// * @return the backbone service serviceRegistry. it cannot return null.
	// */
	// public ServicesRegistry getServicesRegistry() {
	// return this.servicesRegistry;
	// }
	//
	// public class SynchronizableGmfDiagramEditor extends DiagramDocumentEditor
	// implements IRevealSemanticElement {
	//
	// public SynchronizableGmfDiagramEditor(final boolean hasFlyoutPalette) {
	// super(hasFlyoutPalette);
	// }
	//
	//
	// /**
	// * reveal all editpart that represent an element in the given list.
	// *
	// * @see
	// org.eclipse.papyrus.infra.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	// *
	// */
	// public void revealSemanticElement(final List<?> elementList) {
	// //create an instance that can get semantic element from gmf
	// final SemanticFromGMFElement semanticFromGMFElement = new
	// SemanticFromGMFElement();
	//
	// // get the graphical viewer
	// final GraphicalViewer graphicalViewer = getGraphicalViewer();
	// if(graphicalViewer != null) {
	//
	// //look for among all edit part if the semantic is contained in the list
	// final Iterator<?> iter =
	// graphicalViewer.getEditPartRegistry().values().iterator();
	// IGraphicalEditPart researchedEditPart = null;
	// while(iter.hasNext() && researchedEditPart == null) {
	// final Object currentEditPart = iter.next();
	// //look for only among IPrimary editpart to avoid compartment and labels
	// of links
	// if(currentEditPart instanceof IPrimaryEditPart) {
	// if(elementList.contains(semanticFromGMFElement.getSemanticElement(currentEditPart)))
	// {
	// researchedEditPart = ((IGraphicalEditPart)currentEditPart);
	// }
	// }
	//
	// }
	// //an editpart has been found so put selection on it.
	// if(researchedEditPart != null) {
	// graphicalViewer.select(researchedEditPart);
	// }
	// }
	// }
	//
	// /**
	// * Configures my diagram edit domain with its command stack.
	// * This method has been completely overridden in order to use a proxy
	// stack.
	// */
	// @Override
	// protected void configureDiagramEditDomain() {
	//
	// final DefaultEditDomain editDomain = getEditDomain();
	//
	// if(editDomain != null) {
	// final CommandStack stack = editDomain.getCommandStack();
	// if(stack != null) {
	// // dispose the old stack
	// stack.dispose();
	// }
	//
	// // create and assign the new stack
	// final CheckedDiagramCommandStack diagramStack = new
	// CheckedDiagramCommandStack(getDiagramEditDomain());
	//
	// editDomain.setCommandStack(diagramStack);
	// }
	//
	// final DiagramEditDomain diagEditDomain =
	// (DiagramEditDomain)getDiagramEditDomain();
	// diagEditDomain.setActionManager(createActionManager());
	// }
	// }
	//
}
