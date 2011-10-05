/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.collaborationuselabel;

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
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyLabelPartitionScanner;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.CollaborationUse;

/**
 * This class bundles the configuration space of the action language source viewer. Instances of
 * this class are passed to the configure method of <code>SourceViewer</code>.
 * 
 * @see org.eclipse.jface.text.source.SourceViewerConfiguration
 */
public class CollaborationUseLabelSourceViewerConfiguration extends SourceViewerConfiguration {

	/** Edited {@link CollaborationUse} */
	private CollaborationUse collaborationUse;

	/**
	 * Creates a new CollaborationUseLabelSourceViewerConfiguration
	 * 
	 * @param collaborationUse
	 *        the {@link CollaborationUse} to edit
	 */
	public CollaborationUseLabelSourceViewerConfiguration(CollaborationUse collaborationUse) {
		setCollaborationUse(collaborationUse);
	}

	/**
	 * Creates a new CollaborationUseLabelSourceViewerConfiguration
	 */
	public CollaborationUseLabelSourceViewerConfiguration() {
		this(null);
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
		Color colorString = CollaborationUseLabelColorProvider.getDefault().getColor(
				ICollaborationUseLabelColorConstants.STRING);
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(colorString)));

		reconciler.setDamager(dr, PropertyLabelPartitionScanner.PROPERTY_MODIFIERS_STRING);
		reconciler.setRepairer(dr, PropertyLabelPartitionScanner.PROPERTY_MODIFIERS_STRING);

		// creating damager/repairer for other zones (action language zone)
		dr = new DefaultDamagerRepairer(new CollaborationUseLabelScanner());
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

		IContentAssistProcessor processor = new CollaborationUseLabelCompletionProcessor(collaborationUse);
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		// IInformationControlCreator
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		return assistant;
	}

	/**
	 * Returns the edited {@link CollaborationUse}
	 * 
	 * @return the {@link CollaborationUse} to edit
	 */
	public CollaborationUse getCollaborationUse() {
		return collaborationUse;
	}

	/**
	 * Sets the {@link CollaborationUse} to Edit
	 * 
	 * @param collaborationUse
	 *        the {@link CollaborationUse} to edit
	 */
	public void setCollaborationUse(CollaborationUse collaborationUse) {
		this.collaborationUse = collaborationUse;
	}
}
