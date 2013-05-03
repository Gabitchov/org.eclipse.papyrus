/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part;


import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.Activator;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.CustomXtextSourceViewer;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.ISyntheticResourceProvider;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.OperationHistoryListener;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.PartialModelEditor;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.SourceViewerHandle;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing.SourceViewerHandleFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.actions.TextViewerAction;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Injector;

/**
 * Base class to handle a small in-diagram XtextEditor.
 * 
 * Override the generated <code>performDirectEdit</code> methods in the EditPart of the label to be directly edited, and
 * call {@link #showEditor()} instead of opening the default {@link TextCellEditor}.
 * 
 * @author koehnlein
 * @author CEA LIST (A. Cuccuru, A. Radermacher): Modifications for the integration into Papyrus 
 * Changes:
 * - Added "implements" relationship towards IPopupEditorHelper, 
 * 		related to the DirectEditor extension point of Papyrus
 * - Signature of the constructor modified
 * - Method showEditor modified, with the creation of a temporary file, underlying the popup xtext editor
 * - Method closeEditor modified, with new statements for managing the reconciliation between the original
 * 		UML model and the textual specification resulting from the edition in the popup xtext editor. The 
 * 		temporary text file created by showEditor is also deleted.
 * - Method createXTextEditor modified. Now uses the Papyrus IEditorSite, and also adds a focus listener for
 * 		managing the context eobject and current xtext editor.
 * - Method setEditorRegin modified (needs some work...)
 * - Method setEditorBounds modified (needs some work...)
 * - Method activateServices and deactivateServices, for managing the key binding of the context diagram
 * 		editor.
 */

public class PopupXtextEditorHelper implements IPopupEditorHelper {

	private static IGraphicalEditPart hostEditPart;
	private IEditorPart diagramEditor;
	private int editorOffset;
	private int initialEditorSize;
	private int initialDocumentSize;
	private Composite xtextEditorComposite;
	private final Injector xtextInjector;
	private XtextResource xtextResource;
	private String semanticElementFragment;
	private EObject semanticElement ;
	private String textToEdit ;
	/** prevent the reconciliation from being applied twice (See Bug 395439) */
	private boolean closing = false;
	
	/**
	 * get the host editpart
	 * @return the editpart
	 */
	public static IGraphicalEditPart getHostEditPart() {
		return hostEditPart;
	}

	/**
	 * The file extension used to dynamically select the appropriate xtext editor
	 */
	public static String fileExtension ;
	private IXtextEMFReconciler modelReconciler;
	private ISyntheticResourceProvider resourceProvider ;
	private SourceViewerHandle sourceViewerHandle ;
	
	/**
	 * @return The source viewer handle for this PopupXtextEditorHelper
	 *
	 */
	public SourceViewerHandle getSourceViewerHandle() {
		return sourceViewerHandle;
	}

	private PartialModelEditor partialEditor ;
	private Shell diagramShell ;
	private OperationHistoryListener operationHistoryListener;
	private IXTextSemanticValidator semanticValidator ;
	/**
	 * The context EObject for this editor. It can be used for content assist, verification, etc.
	 */
	public static EObject context ;
	
	/**
	 *
	 */
	public static boolean ignoreFocusLost = false ;
	
	/**
	 * This element was originally undocumented in the XText/GMF integration example
	 * 
	 * Modifications performed by CEA LIST
	 * 		- Signature changed: was public PopupXtextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector)
	 * @param editPart The editPart on which a direct edit has been performed.
	 * @param xtextInjector The xtextInjector.
	 * @param modelReconciler The IXtextEMFReconciler, to update the context UML model with changes textually specified in the popup xtext editor
	 * @param textToEdit the initialization text, used as the initial textual content for the popup xtext editor 
	 * @param fileExtension the extension for the temporary textual file (underlying the editor)
	 * @param semanticValidator the semantic validator used to semantically validate the xtext model before saving
	 */
	public PopupXtextEditorHelper(IGraphicalEditPart editPart, 
							Injector xtextInjector,
							IXtextEMFReconciler modelReconciler,
							String textToEdit, 
							String fileExtension,
							IXTextSemanticValidator semanticValidator) {
		this.hostEditPart = editPart;
		this.xtextInjector = xtextInjector ;
		this.textToEdit = "" + textToEdit ;
		this.modelReconciler = modelReconciler ;
		PopupXtextEditorHelper.fileExtension = "" + fileExtension ;
		this.semanticValidator = semanticValidator ;
		ignoreFocusLost = false ;
	}

	/**
	 * This element was originally not documented in the XText / GMF integration example.
	 * 
	 */
	public void showEditor() {
		try {
			semanticElement = hostEditPart.resolveSemanticElement();
			if (semanticElement == null) {
				return;
			}
			context = semanticElement ;
			Resource semanticResource = semanticElement.eResource();

			semanticElementFragment = semanticResource.getURIFragment(semanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			IDiagramEditDomain diagramEditDomain = hostEditPart.getDiagramEditDomain();
			
			diagramEditor = ((DiagramEditDomain) diagramEditDomain).getEditorPart();
			
			createXtextEditor(null) ;
			
		} catch (Exception e) {
			Activator.logError(e);
		}
	}
	
	/**
	 * This element was originally not documented in the XText/GMF integration example.
	 * 
	 * Changes performed by CEA LIST:
	 * 	- new statements for managing the reconciliation between the original UML model and 
	 * 		the textual specification resulting from the edition in the popup xtext editor. 
	 * @param isReconcile Determines whether a reconciliation must be performed or not
	 */
	public void closeEditor(boolean isReconcile) {
		if (sourceViewerHandle != null) {
			if (!closing) {
				if (isReconcile && this.semanticValidator.validate()) {
					try {
						final IXtextDocument xtextDocument = sourceViewerHandle.getDocument();
						if (!isDocumentHasErrors(xtextDocument)) {
							int documentGrowth = xtextDocument.getLength() - initialDocumentSize;
							String newText = xtextDocument.get(editorOffset, initialEditorSize + documentGrowth);
							xtextResource = partialEditor.createResource(newText);
							if (xtextResource.getAllContents().hasNext())
								modelReconciler.reconcile(semanticElement, xtextResource.getAllContents().next());
						}
					} catch (Exception exc) {
						Activator.logError(exc);
					}
				}
			}
			try {
				closing = true;
				xtextEditorComposite.setVisible(false);
				xtextEditorComposite.dispose();
			} finally {
				closing = false;
			}
		}
		SourceViewerHandle.bindPartialModelEditorClass(null) ;
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example
	 * 
	 * Changes performed by CEA LIST:
	 * 		- adds a focus listener for managing the context eobject and current xtext editor.
	 * 
	 * @param editorInput
	 */
	private void createXtextEditor(IEditorInput editorInput) throws Exception {
		diagramShell = diagramEditor.getSite().getShell();
		xtextEditorComposite = new Shell(SWT.RESIZE) ;
		xtextEditorComposite.setLayout(new FillLayout());
	
		
		resourceProvider = xtextInjector.getInstance(ISyntheticResourceProvider.class) ;
		SourceViewerHandleFactory factory = xtextInjector.getInstance(SourceViewerHandleFactory.class) ;
		sourceViewerHandle = factory.create(xtextEditorComposite, resourceProvider) ;
		partialEditor = sourceViewerHandle.createPartialEditor("", textToEdit, "", semanticElement, modelReconciler) ;		
		registerKeyListener();
		setEditorBounds();
		
		initializeActions();
		installUndoRedoSupport(sourceViewerHandle.getViewer());
		
		sourceViewerHandle.getViewer().getTextWidget().addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				checkedClose();
			}
			
			public void focusGained(FocusEvent e) {
				context = semanticElement ;
			}
		}) ;
		
		xtextEditorComposite.setVisible(true);
		sourceViewerHandle.getViewer().showAnnotationsOverview(true) ;
		sourceViewerHandle.getViewer().getTextWidget().setFocus() ;
		
		// This last statement is used to trigger initial validation
		sourceViewerHandle.getViewer().getTextWidget().append("") ;
	}

	/**
	 * Perform additional checks before close
	 * (added by CEA LIST)
	 */
	private void checkedClose() {
		context = semanticElement ;
		if (! keyListener.isContentAssistActive()) {
			// additional sanity check: on X11 systems, the focus is already lost during resize.
			// An unwanted closing can be prevented by verifying if the activeShell still points
			// to the xtextEditorComposite
			if (xtextEditorComposite.getDisplay().getActiveShell() != xtextEditorComposite) {
				if (!ignoreFocusLost) {
					closeEditor(true) ;
				}
				else
					closeEditor(false) ;
			}
		}
	}
	
	
	private PopupXtextEditorKeyListener keyListener ;
	
	private void registerKeyListener() {
		//XtextSourceViewer sourceViewer = (XtextSourceViewer) xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewerHandle.getViewer().getTextWidget();
		CustomXtextSourceViewer viewer = (CustomXtextSourceViewer)sourceViewerHandle.getViewer() ;
		keyListener = 
			new PopupXtextEditorKeyListener
						(this, (ContentAssistant) viewer.getContentAssistant());
		//keyListener.installUndoRedoSupport(sourceViewerHandle.getViewer()) ;
		xtextTextWidget.addVerifyKeyListener(keyListener);
		xtextTextWidget.addKeyListener(keyListener);
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example
	 * 
	 * Modifications from CEA LIST:
	 * 		- modifications to rules for computing the initial location and size of the popup editor.
	 * 			This still needs some work...
	 */
	private void setEditorBounds() {
		
		String editString = "" + textToEdit ;
		int[] numLinesNumColums = StringUtil.getNumLinesNumColumns(editString) ;
		int numLines = numLinesNumColums[0] ;
		int numColumns = numLinesNumColums[1];
		// ninimal sizes
		if (numLines < 5) {
			numLines = 5;
		}
		if (numColumns < 60) {
			numColumns = 60;
		}
		
		IFigure figure = hostEditPart.getFigure() ;
		Rectangle bounds = figure.getBounds().getCopy();
		figure.translateToAbsolute(bounds) ;
		Point newCoord = diagramShell.getDisplay().map(hostEditPart.getViewer().getControl(), null, new Point(bounds.x, bounds.y)) ;
		bounds.x = newCoord.x ;
		bounds.y = newCoord.y ;
	
		// not used, delivers wrong results
		// FontData fontData = figure.getFont().getFontData()[0];
		// int fontHeightInPixel = fontData.getHeight();
		
		GC gc = new GC (xtextEditorComposite);
		FontMetrics fm = gc.getFontMetrics ();
		int width  = numColumns * fm.getAverageCharWidth () + 40;
		int height = numLines   * fm.getHeight();
		gc.dispose ();
        
		// xtextEditorComposite contains a composite which in turn contains the text widget and an area for markers.
		// Take difference between client area and size into account. Cannot set size of text widget directly,
		// since suitable packing is not supported by the layout of the text widget's parent.
		org.eclipse.swt.graphics.Rectangle clientArea = xtextEditorComposite.getClientArea();
		// only correct height, since width is estimated anyway.
		height += xtextEditorComposite.getSize().y - clientArea.height;
		xtextEditorComposite.setBounds(bounds.x, bounds.y, width, height);
	}




	private boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || parseResult.hasSyntaxErrors();
			}
		}));
	}
	
	protected Status createErrorStatus(String message, TemplateException e) {
		return new Status(IStatus.ERROR, 
			"org.eclipse.papyrus.property.editor.xtext",message, e);
		
	}
	
	
	protected void installUndoRedoSupport(SourceViewer viewer) {
		IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(viewer.getDocument());
		final IUndoContext context = undoManager.getUndoContext();
		IOperationHistory operationHistory = CheckedOperationHistory.getInstance();
		operationHistoryListener = new OperationHistoryListener(context, new IUpdate() {
			public void update() {
				updateAction(ITextEditorActionConstants.REDO);
				updateAction(ITextEditorActionConstants.UNDO);
			}
		});
		operationHistory.addOperationHistoryListener(operationHistoryListener);
	}
	
	private Map<String, org.eclipse.ui.console.actions.TextViewerAction> fGlobalActions= Maps.newHashMapWithExpectedSize(10);
	private List<String> fSelectionActions = Lists.newArrayListWithExpectedSize(3);
	
	protected void updateAction(String actionId) {
		IAction action= fGlobalActions.get(actionId);
		if (action instanceof IUpdate)
			((IUpdate) action).update();
	}
	
	protected void uninstallUndoRedoSupport() {
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		operationHistory.removeOperationHistoryListener(operationHistoryListener);
		operationHistoryListener = null;
	}
	
	private void initializeActions() {
		final List<IHandlerActivation> handlerActivations= Lists.newArrayListWithExpectedSize(3);
		final IHandlerService handlerService= (IHandlerService) PlatformUI.getWorkbench().getAdapter(IHandlerService.class);
		final Expression expression= new ActiveShellExpression(sourceViewerHandle.getViewer().getControl().getShell());

		diagramShell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
				}
		});

		TextViewerAction action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.UNDO);
		action.setText("UNDO");
		fGlobalActions.put(ITextEditorActionConstants.UNDO, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.REDO);
		action.setText("REDO");
		fGlobalActions.put(ITextEditorActionConstants.REDO, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.CUT);
		action.setText("CUT");
		fGlobalActions.put(ITextEditorActionConstants.CUT, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.COPY);
		action.setText("COPY");
		fGlobalActions.put(ITextEditorActionConstants.COPY, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.PASTE);
		action.setText("PASTE");
		fGlobalActions.put(ITextEditorActionConstants.PASTE, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ITextOperationTarget.SELECT_ALL);
		action.setText("SELECT_ALL");
		fGlobalActions.put(ITextEditorActionConstants.SELECT_ALL, action);

		action= new TextViewerAction(sourceViewerHandle.getViewer(), ISourceViewer.CONTENTASSIST_PROPOSALS);
		action.setText("CONTENTASSIST_PROPOSALS");
		fGlobalActions.put(ITextEditorActionConstants.CONTENT_ASSIST, action);

		fSelectionActions.add(ITextEditorActionConstants.CUT);
		fSelectionActions.add(ITextEditorActionConstants.COPY);
		fSelectionActions.add(ITextEditorActionConstants.PASTE);
		
		sourceViewerHandle.getViewer().getTextWidget().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
			}
			public void focusGained(FocusEvent e) {
				IAction action= fGlobalActions.get(ITextEditorActionConstants.REDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_REDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.UNDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_UNDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.CONTENT_ASSIST);
				handlerActivations.add(handlerService.activateHandler(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, new ActionHandler(action), expression));
			}
		});

	}
}
