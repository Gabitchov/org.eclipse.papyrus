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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.propertylabel;

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
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Property;

/**
 * This class bundles the configuration space of the action language source viewer. Instances of
 * this class are passed to the configure method of <code>SourceViewer</code>.
 * 
 * @see org.eclipse.jface.text.source.SourceViewerConfiguration
 */
public class PropertyLabelSourceViewerConfiguration extends SourceViewerConfiguration {

	/** edited PropertyUtil */
	private Property property;

	/**
	 * Creates a new PropertyLabelSourceViewerConfiguration
	 * 
	 * @param property
	 *            the property to edit
	 */
	public PropertyLabelSourceViewerConfiguration(Property property) {
		setProperty(property);
	}

	/**
	 * Creates a new PropertyLabelSourceViewerConfiguration
	 */
	public PropertyLabelSourceViewerConfiguration() {
		this(null);
	}

	/**
     * 
     */
	static class SingleTokenScanner extends BufferedRuleBasedScanner {

		/**
		 * 
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
		Color colorString = PropertyLabelColorProvider.getDefault().getColor(IPropertyLabelColorConstants.STRING);
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(colorString)));

		reconciler.setDamager(dr, PropertyLabelPartitionScanner.PROPERTY_MODIFIERS_STRING);
		reconciler.setRepairer(dr, PropertyLabelPartitionScanner.PROPERTY_MODIFIERS_STRING);

		// creating damager/repairer for other zones (action language zone)
		dr = new DefaultDamagerRepairer(new PropertyLabelScanner());
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

		IContentAssistProcessor processor = new PropertyLabelCompletionProcessor(property);
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		// IInformationControlCreator
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		return assistant;
	}

	/**
	 * Returns the edited PropertyUtil
	 * 
	 * @return the property to edit
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * Sets the property to Edit
	 * 
	 * @param property
	 *            the property to edit
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
}