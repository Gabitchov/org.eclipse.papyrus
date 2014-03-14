/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SourceViewerHandleFactory {
	
	@Inject 
	private XtextSourceViewer.Factory sourceViewerFactory;
	
	@Inject 
	private Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider;
	
	@Inject 
	private Provider<XtextDocument> documentProvider;
	
	@Inject 
	private IResourceValidator resourceValidator;
	
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	private Injector xtextInjector ;
	
	protected static final int VERTICAL_RULER_WIDTH= 12;
	
	/**
	 * @param parent 
	 * @param resourceProvider 
	 * @return SourceViewerHandle
	 *
	 */
	public SourceViewerHandle create(Composite parent, ISyntheticResourceProvider resourceProvider) {
		final IVerticalRuler ruler = new VerticalRuler(VERTICAL_RULER_WIDTH, new DefaultMarkerAnnotationAccess());
		final IOverviewRuler oRuler = new OverviewRuler(new DefaultMarkerAnnotationAccess(), VERTICAL_RULER_WIDTH, getSharedColors());
		//final XtextSourceViewer viewer = sourceViewerFactory.createSourceViewer(parent, ruler, oRuler, true, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		final XtextSourceViewer viewer = new CustomXtextSourceViewer(parent, ruler, oRuler, false, SWT.V_SCROLL | SWT.H_SCROLL);
		/*
		 * final IVerticalRuler ruler = new VerticalRuler(VERTICAL_RULER_WIDTH, null) ;
		final XtextSourceViewer viewer = new CustomXtextSourceViewer(parent, ruler, null, true, SWT.None); 
		 */
		
		
		XtextSourceViewerConfiguration viewerConfiguration = sourceViewerConfigurationProvider.get();
		viewer.configure(viewerConfiguration);
		
		final SourceViewerDecorationSupport viewerDecorationSupport = new SourceViewerDecorationSupport(viewer, null, new DefaultMarkerAnnotationAccess(), getSharedColors());
		MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
		Iterator<AnnotationPreference> e= Iterators.filter(annotationPreferences.getAnnotationPreferences().iterator(), AnnotationPreference.class);
		while (e.hasNext())
			viewerDecorationSupport.setAnnotationPreference(e.next());
		viewerDecorationSupport.install(preferenceStoreAccess.getPreferenceStore());
		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				viewerDecorationSupport.dispose();
			}
		});
		final XtextDocument document = documentProvider.get();
		final SourceViewerHandle result = new SourceViewerHandle(document, viewer, viewerConfiguration, resourceProvider, xtextInjector);
		ValidationJob job = new ValidationJob(resourceValidator, document, 
				new IValidationIssueProcessor() {
					private AnnotationIssueProcessor annotationIssueProcessor;
					
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						if(viewer.getTextWidget() == null) {
							// the text widget is disposed => don't try displaying errors in this widget
							return;
						}
						IValidationIssueProcessor issueProcessor = result.getIssueProcessor();
						if (issueProcessor != null)
							issueProcessor.processIssues(issues, monitor);
						if (annotationIssueProcessor == null) {
							annotationIssueProcessor = new AnnotationIssueProcessor(document, 
									viewer.getAnnotationModel(), 
									new IssueResolutionProvider.NullImpl());
						}
						if (annotationIssueProcessor != null)
							annotationIssueProcessor.processIssues(issues, monitor);						
					}
				}, CheckMode.FAST_ONLY);
		document.setValidationJob(job);
		return result;
	}
	
	protected ISharedTextColors getSharedColors() {
		return EditorsUI.getSharedTextColors();
	}
}
