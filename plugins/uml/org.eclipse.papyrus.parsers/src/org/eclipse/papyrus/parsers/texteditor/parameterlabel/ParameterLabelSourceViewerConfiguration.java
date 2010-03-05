/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Parameter;

/**
 * This class bundles the configuration space of the action language source viewer. Instances of
 * this class are passed to the configure method of <code>SourceViewer</code>.
 * 
 * @see org.eclipse.jface.text.source.SourceViewerConfiguration
 */
public class ParameterLabelSourceViewerConfiguration extends CompletionFilterSourceViewerConfiguration {

	/** Edited {@link Parameter} */
	private Parameter parameter;

	/**
	 * Creates a new ParameterLabelSourceViewerConfiguration
	 * 
	 * @param parameter
	 *        the {@link Parameter} to edit
	 */
	public ParameterLabelSourceViewerConfiguration(Parameter parameter) {
		super(null);
		setParameter(parameter);
	}

	/**
	 * Creates a new ParameterLabelSourceViewerConfiguration
	 */
	public ParameterLabelSourceViewerConfiguration() {
		this(null, null);
	}

	/**
	 * Instantiates a new property label source viewer configuration.
	 * 
	 * @param property
	 *        the property
	 * @param filter
	 *        the filter
	 */
	public ParameterLabelSourceViewerConfiguration(Parameter parameter, ICompletionFilter filter) {
		super(filter);
		setParameter(parameter);
	}

	/**
	 * @param filter
	 */
	public ParameterLabelSourceViewerConfiguration(ICompletionFilter filter) {
		this(null, filter);
	}

	/**
	 * Token scanner
	 */
	static class SingleTokenScanner extends BufferedRuleBasedScanner {

		/**
		 * Constructor
		 * 
		 * @param attribute
		 */
		public SingleTokenScanner(TextAttribute attribute) {
			setDefaultReturnToken(new Token(attribute));
		}
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		// creating damager/repairer for single line comments
		Color colorString = ParameterLabelColorProvider.getDefault().getColor(IParameterLabelColorConstants.STRING);
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(colorString)));

		reconciler.setDamager(dr, ParameterLabelPartitionScanner.PARAMETER_MODIFIERS_STRING);
		reconciler.setRepairer(dr, ParameterLabelPartitionScanner.PARAMETER_MODIFIERS_STRING);

		// creating damager/repairer for other zones (action language zone)
		dr = new DefaultDamagerRepairer(new ParameterLabelScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();

		IContentAssistProcessor processor = new ParameterLabelCompletionProcessor(parameter, getFilter());
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		// IInformationControlCreator
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		return assistant;
	}

	/**
	 * Returns the edited {@link Parameter}
	 * 
	 * @return the {@link Parameter} to edit
	 */
	public Parameter getParameter() {
		return parameter;
	}

	/**
	 * Sets the {@link Parameter} to Edit
	 * 
	 * @param collaborationUse
	 *        the {@link Parameter} to edit
	 */
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
}
