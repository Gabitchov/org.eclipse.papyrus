
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui;

import org.eclipse.xtext.ui.DefaultUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manual modifications go to {org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.StereotypeApplicationWithVSLUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractStereotypeApplicationWithVSLUiModule extends DefaultUiModule {
	
	public AbstractStereotypeApplicationWithVSLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
		return org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.IDamagerRepairer> bindIDamagerRepairer() {
		return org.eclipse.xtext.ui.editor.FastDamagerRepairer.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.labeling.StereotypeApplicationWithVSLLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.labeling.StereotypeApplicationWithVSLDescriptionLabelProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.TransformerFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.transformer.ISemanticModelTransformer> bindISemanticModelTransformer() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.outline.StereotypeApplicationWithVSLTransformer.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineNodeAdapterFactoryFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.actions.IContentOutlineNodeAdapterFactory> bindIContentOutlineNodeAdapterFactory() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.outline.StereotypeApplicationWithVSLOutlineNodeAdapterFactory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.quickfix.StereotypeApplicationWithVSLQuickfixProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contentassist.StereotypeApplicationWithVSLProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contentassist.antlr.StereotypeApplicationWithVSLParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contentassist.antlr.internal.InternalStereotypeApplicationWithVSLLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contentassist.antlr.internal.InternalStereotypeApplicationWithVSLLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contentassist.antlr.internal.InternalStereotypeApplicationWithVSLLexer.class);
	}


}
