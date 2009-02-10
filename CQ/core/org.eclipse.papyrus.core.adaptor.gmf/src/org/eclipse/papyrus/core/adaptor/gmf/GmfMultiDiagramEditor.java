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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.sasheditor.extension.ExtensionMultiDiagramEditor;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramSharedObjects;
import org.eclipse.papyrus.sasheditor.gef.GefMultiPageEditorPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;




/**
 * Base class to create GMF multitab editor.
 * A multitab editor contains sub editor which are modified GMF generated editors.
 * This class provides (implements or initializes) services needed by GMF
 * @author dumoulin
 *
 */
public abstract class GmfMultiDiagramEditor extends ExtensionMultiDiagramEditor 
      implements IDiagramWorkbenchPart, IShowInSource, ITabbedPropertySheetPageContributor,
      IDocumentEditor, IReusableEditor {


	/**
	 * Loader used to load the models.
	 */
	private ModelManagerEditor loadedEditor;
	
	
	/**
	 * Document provider holding all open diagrams documents.
	 */
//	private MultiDiagramDocumentProvider documentProvider;
	
	/** Palette component, holding the tools and shapes. */
	private static PaletteRoot PALETTE_MODEL;
	/**
	 * The associated ModelFactory 
	 */
	private EditDomain editDomain;
	
	/**
	 * Listener on editorModel events.
	 */
	private PropertyChangeListener editorModelListener = new PropertyChangeListener(){

		public void propertyChange(PropertyChangeEvent event) {
			System.out.println("modelRoot changed");
			String prop = event.getPropertyName();
			if (ModelManagerEditor.DIAGRAM_ADDED.equals(prop)
					|| ModelManagerEditor.DIAGRAM_REMOVED.equals(prop)) {
				refreshTabs();
			}
			
		}
	};
	
	/**
	 * Constructor.
	 *
	 */
	public GmfMultiDiagramEditor()
	{
		super();
		System.out.println("Create GmfMultiDiagramEditor");
//		setEditDomain(new DefaultEditDomain(this));
	}
	
	
//	protected void setEditDomain(DefaultEditDomain editDomain) {
//		this.editDomain = editDomain;
//	}

	

	/**
	 * Returns this text editor's document provider.
	 *
	 * @return the document provider or <code>null</code> if none, e.g. after closing the editor
	 */
	public IDocumentProvider getDocumentProvider() {
		return loadedEditor.getDocumentProvider();
	}

	

	/**
	 * Call the loadedEditor counterpart in order to initialize it.
	 * Should be done with init rather than setInput because the setSite() method should be called.
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		System.out.println("call setInput()");
		super.init(site, input);
		loadedEditor = createModelManagerEditor();
		loadedEditor.init(site, input);
		setPartName(input.getName());
	}
	
	/**
	 * Create an instance of the ModelManagerEditor which will be used to manage the models.
	 * @return
	 */
	protected abstract ModelManagerEditor createModelManagerEditor(); 

	/**
	 * Save the models.
	 * Forward to the model manager.
	 */
	public void doSave(IProgressMonitor monitor) {
		System.out.println("call doSave");
		loadedEditor.doSave(monitor);
	}

	/**
	 * Mark the command stack of all sub-editors
	 *
	 */
//	protected void markSaveLocation() {
//		for (int i=0; i<getPageCount(); i++) {
//			IEditorPart editor = getEditor(i);
//			if (editor instanceof GraphicalPageWithFlyoutPalette ) {
//				GraphicalPageWithFlyoutPalette graphEditor = (GraphicalPageWithFlyoutPalette)editor;
//				graphEditor.markSaveLocation();
//			}
//		}
//	}
	
	/**
	 * Perform the doSaveAs operation.
	 * Forward to the model manager.
	 */
	public void doSaveAs() {
		System.out.println("call doSave");
		loadedEditor.doSaveAs();
	}

	/**
	 * Forward to the model manager.
	 */
	public boolean isSaveAsAllowed() {
		System.out.println("call isSaveAsAllowed");
		return loadedEditor.isSaveAsAllowed();
	}

	
	
	private void showStack()
	{
	try {
		throw new UnsupportedOperationException();
	}
	catch(UnsupportedOperationException ex)
	{
		ex.printStackTrace();
	}
	}
	
	/**
	 * @return the editDomain
	 */
	protected EditDomain getEditDomain() {
		return editDomain;
	}

	/**
	 * 
	 * @param editDomain
	 */
	protected void setEditDomain(DefaultEditDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * Get the list of models to be displayed.
	 * Get the root of the models, and return the list of root elements.
	 */
	public List getModels() {
		DiagramDocument document = (DiagramDocument)getDocumentProvider().getDocument(getEditorInput());
		
		Diagram diagram = document.getDiagram();
		
		return diagram.eResource().getContents();	
	}
		
	/**
	 * Set an observer to the "diagram added" object.
	 */
	public void activate()
	{
		super.activate();
		loadedEditor.activate();
		loadedEditor.getDiagramListListener().addPropertyChangeListener(editorModelListener);
	}

	/**
	 * Remove the observer to the "diagram added" object.
	 */
	public void deactivate()
	{
		loadedEditor.deactivate();
		loadedEditor.getDiagramListListener().addPropertyChangeListener(editorModelListener);
		super.deactivate();
	}

	/**
	 * Get the diagram associated to the active editor.
	 * Return null if there is no active page.
	 * @return
	 */
	public Diagram getDiagram() {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)getActiveEditor();
		if( editor == null )
		  return null;
		return editor.getDiagram();
	}

	/**
	 * 
	 */
	public IDiagramEditDomain getDiagramEditDomain() {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)getActiveEditor();
		if( editor == null )
		  return null;
		return editor.getDiagramEditDomain();
	}

	/**
	 * 
	 */
	public DiagramEditPart getDiagramEditPart() {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)getActiveEditor();
		if( editor == null )
		  return null;
		return editor.getDiagramEditPart();
	}

	/**
	 * 
	 */
	public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)getActiveEditor();
		if( editor == null )
		  return null;
		return editor.getDiagramGraphicalViewer();
	}

	/**
	 * Initialize the newly created shared object.
	 */
//	protected void initSharedObject(MultiDiagramSharedObjects sharedObject)
//	{
//	}

	/**
	 * Create shared object.
	 * The shared object will be initialized with a call to initSharedObject();
	 * @return
	 */
	protected MultiDiagramSharedObjects createSharedObject()
	{
		return new GmfMultiDiagramSharedObjects(loadedEditor);
	}

    /**
     * Returns the context to show, or <code>null</code> if there is 
     * currently no valid context to show.
     * 
     * @return the context to show, or <code>null</code>
     */
    public ShowInContext getShowInContext()
    {
		EditorPart editor = (EditorPart)getActiveEditor();
		if( editor instanceof IShowInSource )
			  return  ((IShowInSource)editor).getShowInContext();
		// No editor, or not good type
		return null;

    }

	/**
	 * Returns the contributor ID for the tabbed property sheet page.
	 * 
	 * @return the contributor ID for the tabbed property sheet page.
	 */
	public String getContributorId()
	{
		EditorPart editor = (EditorPart)getActiveEditor();
		if( editor instanceof ITabbedPropertySheetPageContributor )
		  return  ((ITabbedPropertySheetPageContributor)editor).getContributorId();
		// No editor, or not good type
		return null;
	}

	/* ------------------------- */
	/* IDocumentEditor interface */
	/* ------------------------- */
	
	/**
	 * Closes this text editor after optionally saving changes.
	 *
	 * @param save <code>true</code> if unsaved changed should be saved, and
	 *   <code>false</code> if unsaved changed should be discarded
	 */
	public void close(boolean save)
	{
		throw new UnsupportedOperationException("Not yet implemented");
//		return loadedEditor.close(save);
	}

	/**
	 * Returns whether the text in this text editor can be changed by the user.
	 *
	 * @return <code>true</code> if it can be edited, and <code>false</code> if it is read-only
	 */
	public boolean isEditable()
	{
		throw new UnsupportedOperationException("Not yet implemented");
		//		return loadedEditor.isEditable();
	}

	/**
	 * Returns whether the editor's input is read-only. The semantics of
	 * this method is orthogonal to <code>isEditable</code> as it talks about the
	 * editor input, i.e. the domain element, and <b>not</b> about the editor
	 * document.
	 *
	 * @return <code>true</code> if the editor input is read-only
	 */
	public boolean isEditorInputReadOnly()
	{
		throw new UnsupportedOperationException("Not yet implemented");
		//		return loadedEditor.isEditorInputReadOnly();
	}


	/**
	 * Returns whether the editor's input can be persistently be modified.
	 * This is orthogonal to <code>ITextEditorExtension.isEditorInputReadOnly</code> as read-only elements may be modifiable and
	 * writable elements may not be modifiable. If the given element is not connected to this document
	 * provider, the result is undefined. Document providers are allowed to use a cache to answer this
	 * question, i.e. there can be a difference between the "real" state of the element and the return
	 * value.
	 *
	 * @return <code>true</code> if the editor input is modifiable
	 */
	public boolean isEditorInputModifiable()
	{
		throw new UnsupportedOperationException("Not yet implemented");
		//		return loadedEditor.isEditorInputModifiable();

	}

	/**
	 * Validates the state of the given editor input. The predominate intent
	 * of this method is to take any action probably necessary to ensure that
	 * the input can persistently be changed.
	 *
	 * @return <code>true</code> if the input was validated, <code>false</code> otherwise
	 */
	public boolean validateEditorInputState()
	{
		throw new UnsupportedOperationException("Not yet implemented");
		//		return loadedEditor.validateEditorInputState();
	}

}
