/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Belmudes (Atos Origin) Jeremie.Belmudes@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubMenuManager;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

/**
 * A composite used to edit some documentation in a plain text mode working with the eclipse spell checking tool.<br>
 * Creation : 2 july 2010<br>
 * 
 * @author jbelmudes
 */
public class SpellingTextComposite extends Composite implements IText, Observer
{

    protected StyledText fTextField; // updated only by modify events

    protected SourceViewer sourceViewer;

    protected Document document;

    protected final static String CURRENT_LINE = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE;

    protected final static String CURRENT_LINE_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR;

    private IHandlerActivation quickFixhandlerActivation;

    /**
     * @param composite the parent of this Composite
     */
    public SpellingTextComposite(final Composite composite)
    {
        this(composite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL, false);
    }

    /**
     * @param composite the parent of this Composite
     * @param style the style of the text control
     */
    public SpellingTextComposite(final Composite composite, int style)
    {
        this(composite, style, false);
    }

    /**
     * @param composite the parent of this Composite
     * @param style the style of the text control
     * @param colored tells if the widget has a colored line where the cursor is set
     */
    public SpellingTextComposite(final Composite composite, int style, boolean colored)
    {
        super(composite, SWT.BORDER);
        this.setLayout(new FillLayout());
        AnnotationModel annotationModel = new AnnotationModel();
        IAnnotationAccess annotationAccess = new DefaultMarkerAnnotationAccess();

        sourceViewer = new SourceViewer(this, null, null, true, style);
        fTextField = sourceViewer.getTextWidget();

        final SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(sourceViewer, null, annotationAccess, EditorsUI.getSharedTextColors());
        // display or not a colored line where the field is edited
        if (colored)
        {
            support.setCursorLinePainterPreferenceKeys(CURRENT_LINE, CURRENT_LINE_COLOR);
        }
        Iterator<?> e = new MarkerAnnotationPreferences().getAnnotationPreferences().iterator();
        while (e.hasNext())
            support.setAnnotationPreference((AnnotationPreference) e.next());

        support.install(EditorsUI.getPreferenceStore());

        final IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

        final ActionHandler quickFixActionHandler = createQuickFixActionHandler(sourceViewer);

        final TextViewerAction cutAction = new TextViewerAction(sourceViewer, ITextOperationTarget.CUT);
        cutAction.setText(Messages.SpellingTextComposite_cut);
        cutAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_CUT);
        
        final TextViewerAction copyAction = new TextViewerAction(sourceViewer, ITextOperationTarget.COPY);
        copyAction.setText(Messages.SpellingTextComposite_copy);
        copyAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
        
        final TextViewerAction pasteAction = new TextViewerAction(sourceViewer, ITextOperationTarget.PASTE);
        pasteAction.setText(Messages.SpellingTextComposite_paste);
        pasteAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_PASTE);
        
        final TextViewerAction selectAllAction = new TextViewerAction(sourceViewer, ITextOperationTarget.SELECT_ALL);
        selectAllAction.setText(Messages.SpellingTextComposite_selectAll);
        selectAllAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_SELECT_ALL);
        
        final MenuManager contextMenu = new MenuManager();
        contextMenu.add(cutAction);
        contextMenu.add(copyAction);
        contextMenu.add(pasteAction);
        contextMenu.add(selectAllAction);
        contextMenu.add(new Separator());
        final SubMenuManager quickFixMenu = new SubMenuManager(contextMenu);
        quickFixMenu.setVisible(true);
        quickFixMenu.addMenuListener(new IMenuListener()
        {

            public void menuAboutToShow(IMenuManager manager)
            {
                quickFixMenu.removeAll();
                if (fTextField != null && fTextField.getEditable())
                {
                    IAnnotationModel annotationModel = sourceViewer.getAnnotationModel();
                    Iterator<?> annotationIterator = annotationModel.getAnnotationIterator();
                    while (annotationIterator.hasNext())
                    {
                        Annotation annotation = (Annotation) annotationIterator.next();
                        if (!annotation.isMarkedDeleted() && includes(annotationModel.getPosition(annotation), sourceViewer.getTextWidget().getCaretOffset())
                                && sourceViewer.getQuickAssistAssistant().canFix(annotation))
                        {
                            ICompletionProposal[] computeQuickAssistProposals = sourceViewer.getQuickAssistAssistant().getQuickAssistProcessor().computeQuickAssistProposals(
                                    sourceViewer.getQuickAssistInvocationContext());
                            for (int i = 0; i < computeQuickAssistProposals.length; i++)
                            {
                                final ICompletionProposal proposal = computeQuickAssistProposals[i];
                                quickFixMenu.add(new Action(proposal.getDisplayString())
                                {
                                    
                                    /*
                                     * (non-Javadoc)
                                     * 
                                     * @see org.eclipse.jface.action.Action#run()
                                     */
                                    public void run()
                                    {
                                        proposal.apply(sourceViewer.getDocument());
                                    }
                                    
                                    /*
                                     * (non-Javadoc)
                                     * 
                                     * @see org.eclipse.jface.action.Action#getImageDescriptor()
                                     */
                                    public ImageDescriptor getImageDescriptor()
                                    {
                                        if (proposal.getImage() != null)
                                        {
                                            return ImageDescriptor.createFromImage(proposal.getImage());
                                        }
                                        return null;
                                    }
                                });
                            }
                        }
                    }
                }
            }

        });

        fTextField.addFocusListener(new FocusListener()
        {
            private IHandlerActivation cutHandlerActivation;
            private IHandlerActivation copyHandlerActivation;
            private IHandlerActivation pasteHandlerActivation;
            private IHandlerActivation selectAllHandlerActivation;
            public void focusGained(FocusEvent e)
            {
                cutAction.update();
                copyAction.update();
                IHandlerService service = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
                this.cutHandlerActivation = service.activateHandler(IWorkbenchCommandConstants.EDIT_CUT, new ActionHandler(cutAction), new ActiveShellExpression(getShell()));
                this.copyHandlerActivation = service.activateHandler(IWorkbenchCommandConstants.EDIT_COPY, new ActionHandler(copyAction), new ActiveShellExpression(getShell()));
                this.pasteHandlerActivation = service.activateHandler(IWorkbenchCommandConstants.EDIT_PASTE, new ActionHandler(pasteAction), new ActiveShellExpression(getShell()));
                this.selectAllHandlerActivation = service.activateHandler(IWorkbenchCommandConstants.EDIT_SELECT_ALL, new ActionHandler(selectAllAction), new ActiveShellExpression(getShell()));
                quickFixhandlerActivation = installQuickFixActionHandler(handlerService, sourceViewer, quickFixActionHandler);

            }

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            public void focusLost(FocusEvent e)
            {
                IHandlerService service = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
                if (quickFixhandlerActivation != null)
                {
                    service.deactivateHandler(quickFixhandlerActivation);
                }
                
                if (cutHandlerActivation != null) {
                    service.deactivateHandler(cutHandlerActivation);
                }
                
                if (copyHandlerActivation != null) {
                    service.deactivateHandler(copyHandlerActivation);
                }
                
                if (pasteHandlerActivation != null) {
                    service.deactivateHandler(pasteHandlerActivation);
                }
                
                if (selectAllHandlerActivation != null) {
                    service.deactivateHandler(selectAllHandlerActivation);
                }
            }

        });
        
        sourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            
            public void selectionChanged(SelectionChangedEvent event) {
                cutAction.update();
                copyAction.update();
            }
            
        });

        sourceViewer.getTextWidget().addDisposeListener(new DisposeListener()
        {

            public void widgetDisposed(DisposeEvent e)
            {
                support.uninstall();
                if (quickFixhandlerActivation != null)
                {
                    handlerService.deactivateHandler(quickFixhandlerActivation);
                }
            }

        });

        document = new Document();

        // NOTE: Configuration must be applied before the document is set in order for
        // Hyperlink coloring to work. (Presenter needs document object up front)
        sourceViewer.configure(new TextSourceViewerConfiguration(EditorsUI.getPreferenceStore()));
        sourceViewer.setDocument(document, annotationModel);
        fTextField.setMenu(contextMenu.createContextMenu(fTextField));
    }

    protected boolean includes(Position position, int caretOffset)
    {
        return position.includes(caretOffset) || (position.offset + position.length) == caretOffset;
    }

    /**
     * Set the color of the texte area background
     */
    public void setBackground(Color object)
    {
        fTextField.setBackground(object);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.swt.widgets.Control#setForeground(org.eclipse.swt.graphics.Color)
     */
    public void setForeground(Color color)
    {
        fTextField.setForeground(color);
    }

    /**
     * Installs the quick fix action handler and returns the handler activation.
     * 
     * @param handlerService the handler service
     * @param sourceViewer the source viewer
     * @param createQuickFixActionHandler
     * @return the handler activation
     * @since 3.4
     */
    private IHandlerActivation installQuickFixActionHandler(IHandlerService handlerService, SourceViewer sourceViewer, IHandler createQuickFixActionHandler)
    {

        return handlerService.activateHandler(ITextEditorActionDefinitionIds.QUICK_ASSIST, createQuickFixActionHandler, AlwaysTrue.INSTANCE
        /*
         * ,/*, new ActiveShellExpression(sourceViewer.getTextWidget().getShell())
         */);
    }

    /**
     * Creates and returns a quick fix action handler.
     * 
     * @param textOperationTarget the target for text operations
     * @since 3.4
     */
    private ActionHandler createQuickFixActionHandler(final ITextOperationTarget textOperationTarget)
    {
        Action quickFixAction = new Action()
        {
            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.jface.action.Action#run()
             */
            public void run()
            {
                textOperationTarget.doOperation(ISourceViewer.QUICK_ASSIST);
            }
        };
        quickFixAction.setActionDefinitionId(ITextEditorActionDefinitionIds.QUICK_ASSIST);
        return new ActionHandler(quickFixAction);
    }

    public void setEnabled(boolean enabled)
    {
        fTextField.setEditable(enabled);
        if (!enabled)
        {
        	fTextField.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY));
        }
        else
        {
        	fTextField.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
        }
    }

    public void update(Observable o, Object arg)
    {
        if (arg instanceof String)
        {
            setText((String) arg); // triggers a modify event
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.IText#getText()
     */
    public String getText()
    {
        return document.get();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.IText#getControl()
     */
    public Control getControl()
    {
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.IText#getTextControl()
     */
    public Control getTextControl()
    {
        return fTextField;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.IText#setEditable(boolean)
     */
    public void setEditable(boolean isChangeable)
    {
        fTextField.setEditable(isChangeable);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.IText#setText(java.lang.String)
     */
    public void setText(String string)
    {
        document.set(string);
    }
    
    private static class AlwaysTrue extends Expression
    {
        public static final AlwaysTrue INSTANCE = new AlwaysTrue();
        private AlwaysTrue ()
        {
        }

        @Override
        public EvaluationResult evaluate(IEvaluationContext context) throws CoreException
        {
            return EvaluationResult.TRUE;
        }
            
    }
    
    

}
