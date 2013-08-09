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
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.exteditor.cdt.editor;

import org.eclipse.cdt.codan.internal.ui.cxx.CodanCReconciler;
import org.eclipse.cdt.internal.ui.editor.CEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.exteditor.cdt.Activator;
import org.eclipse.papyrus.exteditor.cdt.sync.RevealCurrentOperation;
import org.eclipse.papyrus.exteditor.cdt.sync.SyncCDTtoModel;
import org.eclipse.papyrus.exteditor.cdt.sync.SyncModelToCDT;
import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;

/**
 * A specialization of the CDT editor made for integration into Papyrus
 *
 */
public class PapyrusCDTEditor extends CEditor {

	/** the service registry */
	protected final ServicesRegistry registry;

	/** the papyrus text instance */
	protected final PapyrusTextInstance papyrusTextInstance;

	/** the text listener */
	protected FocusListener focusListener;

	public static final String EDITOR_DEFAULT_NAME = "CDT Editor";

	public static final String EDITOR_TYPE = "CDTEditorInPapyrus"; //$NON-NLS-1$

	protected SyncCDTtoModel syncCpp;

	protected RevealCurrentOperation reveal;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param registry
	 * @param papyrusTextInstance
	 */
	public PapyrusCDTEditor(final ServicesRegistry registry, final PapyrusTextInstance papyrusTextInstance) {
		super();
		this.registry = registry;
		this.papyrusTextInstance = papyrusTextInstance;
		try {
			saveAndDirtyService = registry.getService(ISaveAndDirtyService.class);
			saveAndDirtyService.registerIsaveablePart(this);
			ILifeCycleEventsProvider lifeCycleEvents = registry.getService(ILifeCycleEventsProvider.class);
			ISaveEventListener preSaveEvent = new ISaveEventListener() {
				
				public void doSaveAs(DoSaveEvent event) {
					// TODO Auto-generated method stub
				}
				
				public void doSave(DoSaveEvent event) {
					syncCpp.syncCDTtoModel();		
				}
			};
			lifeCycleEvents.addAboutToDoSaveListener(preSaveEvent);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}
		
	/**
	 * override method in order to save & restore action bars entries
	 */
	@Override
	public void createPartControl(Composite parent) {
		// save Papyrus (GMF) handlers
		IActionBars actionBars = getEditorSite().getActionBars();
		if((actionBars != null) && (gmfUndo == null)) {
			gmfUndo = actionBars.getGlobalActionHandler(ITextEditorActionConstants.UNDO);
			gmfRedo = actionBars.getGlobalActionHandler(ITextEditorActionConstants.REDO);
		}

		super.createPartControl(parent);

		if(actionBars != null) {
			// save CDT (textEditor) handlers
			textUndo = actionBars.getGlobalActionHandler(ITextEditorActionConstants.UNDO);
			textRedo = actionBars.getGlobalActionHandler(ITextEditorActionConstants.REDO);
			// & restore Papyrus bar
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO, gmfUndo);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO, gmfRedo);
			actionBars.updateActionBars();
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.jface.text.source.IVerticalRuler, int)
	 * 
	 * @param parent
	 * @param ruler
	 * @param styles
	 * @return
	 */
	@Override
	public ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = super.createSourceViewer(parent, ruler, styles);
		// ISourceViewer viewer = new DelegatingSourceViewer(origViewer, (Classifier)papyrusTextInstance.getEditedObject());
		
		focusListener = new FocusListener() {

			public void focusLost(FocusEvent e) {
				// potential problem for undo/redo!!
				if(isDirty()) {
					syncCpp.syncCDTtoModel();
					Classifier classifier = (Classifier)papyrusTextInstance.getEditedObject();
					// apparently doSave does not work properly
					System.err.println("before save:" + isDirty());
					doSave(new NullProgressMonitor());
					System.err.println("after save:" + isDirty());
					// regenerate code. TODO: raises update dialog
					SyncModelToCDT.syncModelToCDT(classifier);
				}
				// restore handlers
				IActionBars actionBars = getEditorSite().getActionBars();
				if(actionBars != null) {
					if((gmfUndo != null) && (gmfRedo != null)) {
						actionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO, gmfUndo);
						actionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO, gmfRedo);
						actionBars.updateActionBars();
					}
				}
			}

			public void focusGained(FocusEvent e) {
				// restore handlers
				IActionBars actionBars = getEditorSite().getActionBars();
				if(actionBars != null) {
					if((textUndo != null) && (textRedo != null)) {
						actionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO, textUndo);
						actionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO, textRedo);
						actionBars.updateActionBars();
					}
				}
			}
		};
		// register focus listener
		viewer.getTextWidget().addFocusListener(focusListener);
		
		SelectionListener selectionListener = new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				IEditorPart ep = getEditorSite().getPage().getActiveEditor();
				ISelection selection = getSelectionProvider().getSelection(); 
				if ((ep instanceof IGotoMarker) && (selection instanceof ITextSelection)) {
					IMarker marker;
					/*
	                 * create a temporary validation marker on the
	                 * srcFile file, call the gotoMarker operation of the editor
	                 * and remove the marker afterwards.
	                 * TODO: operation activates the model-explorer
	                 */
					try {
						Element element = reveal.obtainSelectedElement((ITextSelection) selection);
						String modelURI = EcoreUtil.getURI(element).toString();
						marker = srcFile.createMarker(EValidator.MARKER);
						marker.setAttribute(EValidator.URI_ATTRIBUTE, modelURI);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
						((IGotoMarker) ep).gotoMarker(marker);
						marker.delete();
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		
		viewer.getTextWidget().addSelectionListener(selectionListener);
		
		return viewer;
	}

	@Override
	public boolean isDirty() {
		boolean isDirty = super.isDirty();
		if (isDirty != oldDirty) {
			oldDirty = isDirty;
			// hack. Normally, the saveAndDirtyService detects this itself (should find a solution how it can do that)
			// ((SaveAndDirtyService) saveAndDirtyService).fireIsDirtyChanged();
		}
		return isDirty;
	}
	
	/**
	 * We override this method because setInput can't be overriden for TextEditor.
	 * We replace the default Papyrus input with the CPP file
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#doSetInput(org.eclipse.ui.IEditorInput)
	 * 
	 * @param input
	 * @throws CoreException
	 */
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {

		URI uri = papyrusTextInstance.eResource().getURI();
		Classifier classifier = (Classifier)papyrusTextInstance.getEditedObject();
		srcFile = SyncModelToCDT.syncModelToCDT(classifier);
		if (srcFile == null) {
			throw new PartInitException("Code generation before editing was not attempted. In most cases, this indicates that the projet (in which your model is stored) does not have a CDT nature"); //$NON-NLS-1$
		}
		if(!srcFile.exists()) {
			throw new PartInitException("Code generation before editing failed");
		}
		IEditorInput newInput = new FileEditorInput(srcFile);

		// IStorage storage = new TextStorage(string);
		super.doSetInput(newInput);

		syncCpp = new SyncCDTtoModel(newInput, classifier, uri.segment(1));
		reveal = new RevealCurrentOperation(newInput, classifier, uri.segment(1));
		
		// add the reconciler to get syntax check and completion. (still no full checks)
		addReconcileListener(new CodanCReconciler());
	}

	/**
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 * 
	 */
	@Override
	public void dispose() {

		saveAndDirtyService.removeIsaveablePart(this);
		
		//we remove the listener
		StyledText st = getSourceViewer().getTextWidget();
		st.removeFocusListener(focusListener);
		super.dispose();
		// assure that embedded text widget is disposed now. Otherwise, it will be closed
		// later, when the editorSite is already set to null by Papyrus (mainEditorSite attribute in MultiPageEditorSite4x)
		// resulting in a null pointer exception and resulting inconsistencies in the Papyrus editor.
		st.dispose();
	}

	protected IAction gmfUndo, gmfRedo;

	protected IAction textUndo, textRedo;

	// TODO: remove, unused
	protected IActionBars gmfActionBars, textActionBars;
	
	protected boolean oldDirty;
	
	protected ISaveAndDirtyService saveAndDirtyService;
	
	protected IFile srcFile;
	
	protected ISelectionProvider sp;
}
