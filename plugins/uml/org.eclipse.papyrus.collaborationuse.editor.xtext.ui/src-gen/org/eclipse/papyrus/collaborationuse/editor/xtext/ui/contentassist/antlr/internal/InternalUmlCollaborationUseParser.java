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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.papyrus.collaborationuse.editor.xtext.services.UmlCollaborationUseGrammarAccess;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlCollaborationUseParser extends AbstractInternalContentAssistParser {

	public static final String[] tokenNames = new String[]{ "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'", "':'", "'::'" };

	public static final int RULE_ID = 4;

	public static final int RULE_STRING = 7;

	public static final int RULE_UNLIMITEDLITERAL = 5;

	public static final int RULE_ANY_OTHER = 11;

	public static final int RULE_INT = 6;

	public static final int RULE_WS = 10;

	public static final int RULE_SL_COMMENT = 9;

	public static final int EOF = -1;

	public static final int RULE_ML_COMMENT = 8;

	public InternalUmlCollaborationUseParser(TokenStream input) {
		super(input);
	}


	public String[] getTokenNames() {
		return tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g";
	}



	private UmlCollaborationUseGrammarAccess grammarAccess;

	public void setGrammarAccess(UmlCollaborationUseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}




	// $ANTLR start entryRuleCollaborationUseRule
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:61:1: entryRuleCollaborationUseRule : ruleCollaborationUseRule EOF ;
	public final void entryRuleCollaborationUseRule() throws RecognitionException {
		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:62:1: ( ruleCollaborationUseRule EOF )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:63:1: ruleCollaborationUseRule EOF
			{
				before(grammarAccess.getCollaborationUseRuleRule());
				pushFollow(FOLLOW_ruleCollaborationUseRule_in_entryRuleCollaborationUseRule61);
				ruleCollaborationUseRule();
				_fsp--;

				after(grammarAccess.getCollaborationUseRuleRule());
				match(input, EOF, FOLLOW_EOF_in_entryRuleCollaborationUseRule68);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end entryRuleCollaborationUseRule


	// $ANTLR start ruleCollaborationUseRule
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:70:1: ruleCollaborationUseRule : ( ( rule__CollaborationUseRule__Group__0 ) ) ;
	public final void ruleCollaborationUseRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:74:2: ( ( ( rule__CollaborationUseRule__Group__0 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:75:1: ( ( rule__CollaborationUseRule__Group__0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:75:1: ( ( rule__CollaborationUseRule__Group__0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:76:1: ( rule__CollaborationUseRule__Group__0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getGroup());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:77:1: ( rule__CollaborationUseRule__Group__0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:77:2: rule__CollaborationUseRule__Group__0
					{
						pushFollow(FOLLOW_rule__CollaborationUseRule__Group__0_in_ruleCollaborationUseRule94);
						rule__CollaborationUseRule__Group__0();
						_fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getGroup());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end ruleCollaborationUseRule


	// $ANTLR start entryRuleTypeRule
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:89:1: entryRuleTypeRule : ruleTypeRule EOF ;
	public final void entryRuleTypeRule() throws RecognitionException {
		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:90:1: ( ruleTypeRule EOF )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:91:1: ruleTypeRule EOF
			{
				before(grammarAccess.getTypeRuleRule());
				pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule121);
				ruleTypeRule();
				_fsp--;

				after(grammarAccess.getTypeRuleRule());
				match(input, EOF, FOLLOW_EOF_in_entryRuleTypeRule128);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end entryRuleTypeRule


	// $ANTLR start ruleTypeRule
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:98:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
	public final void ruleTypeRule() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:102:2: ( ( ( rule__TypeRule__Group__0 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:103:1: ( ( rule__TypeRule__Group__0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:103:1: ( ( rule__TypeRule__Group__0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:104:1: ( rule__TypeRule__Group__0 )
				{
					before(grammarAccess.getTypeRuleAccess().getGroup());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:105:1: ( rule__TypeRule__Group__0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:105:2: rule__TypeRule__Group__0
					{
						pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule154);
						rule__TypeRule__Group__0();
						_fsp--;


					}

					after(grammarAccess.getTypeRuleAccess().getGroup());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end ruleTypeRule


	// $ANTLR start entryRuleQualifiedName
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:117:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
	public final void entryRuleQualifiedName() throws RecognitionException {
		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:118:1: ( ruleQualifiedName EOF )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:119:1: ruleQualifiedName EOF
			{
				before(grammarAccess.getQualifiedNameRule());
				pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181);
				ruleQualifiedName();
				_fsp--;

				after(grammarAccess.getQualifiedNameRule());
				match(input, EOF, FOLLOW_EOF_in_entryRuleQualifiedName188);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end entryRuleQualifiedName


	// $ANTLR start ruleQualifiedName
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:126:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
	public final void ruleQualifiedName() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:130:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:132:1: ( rule__QualifiedName__Group__0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getGroup());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:133:1: ( rule__QualifiedName__Group__0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:133:2: rule__QualifiedName__Group__0
					{
						pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214);
						rule__QualifiedName__Group__0();
						_fsp--;


					}

					after(grammarAccess.getQualifiedNameAccess().getGroup());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end ruleQualifiedName


	// $ANTLR start entryRuleBoundSpecification
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:147:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
	public final void entryRuleBoundSpecification() throws RecognitionException {
		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:148:1: ( ruleBoundSpecification EOF )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:149:1: ruleBoundSpecification EOF
			{
				before(grammarAccess.getBoundSpecificationRule());
				pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification243);
				ruleBoundSpecification();
				_fsp--;

				after(grammarAccess.getBoundSpecificationRule());
				match(input, EOF, FOLLOW_EOF_in_entryRuleBoundSpecification250);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end entryRuleBoundSpecification


	// $ANTLR start ruleBoundSpecification
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:156:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
	public final void ruleBoundSpecification() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:160:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:161:1: ( ( rule__BoundSpecification__ValueAssignment ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:161:1: ( ( rule__BoundSpecification__ValueAssignment ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:162:1: ( rule__BoundSpecification__ValueAssignment )
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueAssignment());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:163:1: ( rule__BoundSpecification__ValueAssignment )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:163:2: rule__BoundSpecification__ValueAssignment
					{
						pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification276);
						rule__BoundSpecification__ValueAssignment();
						_fsp--;


					}

					after(grammarAccess.getBoundSpecificationAccess().getValueAssignment());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end ruleBoundSpecification


	// $ANTLR start ruleVisibilityKind
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:176:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
	public final void ruleVisibilityKind() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:180:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:181:1: ( ( rule__VisibilityKind__Alternatives ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:181:1: ( ( rule__VisibilityKind__Alternatives ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:182:1: ( rule__VisibilityKind__Alternatives )
				{
					before(grammarAccess.getVisibilityKindAccess().getAlternatives());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:183:1: ( rule__VisibilityKind__Alternatives )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:183:2: rule__VisibilityKind__Alternatives
					{
						pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind313);
						rule__VisibilityKind__Alternatives();
						_fsp--;


					}

					after(grammarAccess.getVisibilityKindAccess().getAlternatives());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end ruleVisibilityKind


	// $ANTLR start rule__CollaborationUseRule__Alternatives_3
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:196:1: rule__CollaborationUseRule__Alternatives_3 : ( ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) ) | ( '<Undefined>' ) );
	public final void rule__CollaborationUseRule__Alternatives_3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:200:1: ( ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) ) | ( '<Undefined>' ) )
			int alt1 = 2;
			int LA1_0 = input.LA(1);

			if((LA1_0 == RULE_ID)) {
				alt1 = 1;
			} else if((LA1_0 == 12)) {
				alt1 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("196:1: rule__CollaborationUseRule__Alternatives_3 : ( ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) ) | ( '<Undefined>' ) );", 1, 0, input);

				throw nvae;
			}
			switch(alt1) {
			case 1:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:201:1: ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:201:1: ( ( rule__CollaborationUseRule__TypeAssignment_3_0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:202:1: ( rule__CollaborationUseRule__TypeAssignment_3_0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:203:1: ( rule__CollaborationUseRule__TypeAssignment_3_0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:203:2: rule__CollaborationUseRule__TypeAssignment_3_0
					{
						pushFollow(FOLLOW_rule__CollaborationUseRule__TypeAssignment_3_0_in_rule__CollaborationUseRule__Alternatives_3350);
						rule__CollaborationUseRule__TypeAssignment_3_0();
						_fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0());

				}


			}
				break;
			case 2:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:207:6: ( '<Undefined>' )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:207:6: ( '<Undefined>' )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:208:1: '<Undefined>'
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1());
					match(input, 12, FOLLOW_12_in_rule__CollaborationUseRule__Alternatives_3369);
					after(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1());

				}


			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Alternatives_3


	// $ANTLR start rule__VisibilityKind__Alternatives
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:220:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
	public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:224:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
			int alt2 = 4;
			switch(input.LA(1)) {
			case 13:
			{
				alt2 = 1;
			}
				break;
			case 14:
			{
				alt2 = 2;
			}
				break;
			case 15:
			{
				alt2 = 3;
			}
				break;
			case 16:
			{
				alt2 = 4;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("220:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );", 2, 0, input);

				throw nvae;
			}

			switch(alt2) {
			case 1:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:225:1: ( ( '+' ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:225:1: ( ( '+' ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:226:1: ( '+' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:227:1: ( '+' )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:227:3: '+'
					{
						match(input, 13, FOLLOW_13_in_rule__VisibilityKind__Alternatives404);

					}

					after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0());

				}


			}
				break;
			case 2:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:232:6: ( ( '-' ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:232:6: ( ( '-' ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:233:1: ( '-' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:234:1: ( '-' )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:234:3: '-'
					{
						match(input, 14, FOLLOW_14_in_rule__VisibilityKind__Alternatives425);

					}

					after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1());

				}


			}
				break;
			case 3:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:239:6: ( ( '#' ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:239:6: ( ( '#' ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:240:1: ( '#' )
				{
					before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:241:1: ( '#' )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:241:3: '#'
					{
						match(input, 15, FOLLOW_15_in_rule__VisibilityKind__Alternatives446);

					}

					after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2());

				}


			}
				break;
			case 4:
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:246:6: ( ( '~' ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:246:6: ( ( '~' ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:247:1: ( '~' )
				{
					before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:248:1: ( '~' )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:248:3: '~'
					{
						match(input, 16, FOLLOW_16_in_rule__VisibilityKind__Alternatives467);

					}

					after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3());

				}


			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__VisibilityKind__Alternatives


	// $ANTLR start rule__CollaborationUseRule__Group__0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:261:1: rule__CollaborationUseRule__Group__0 : rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1 ;
	public final void rule__CollaborationUseRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:265:1: ( rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:266:2: rule__CollaborationUseRule__Group__0__Impl rule__CollaborationUseRule__Group__1
			{
				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__0__Impl_in_rule__CollaborationUseRule__Group__0501);
				rule__CollaborationUseRule__Group__0__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__1_in_rule__CollaborationUseRule__Group__0504);
				rule__CollaborationUseRule__Group__1();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__0


	// $ANTLR start rule__CollaborationUseRule__Group__0__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:273:1: rule__CollaborationUseRule__Group__0__Impl : ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) ) ;
	public final void rule__CollaborationUseRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:277:1: ( ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:278:1: ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:278:1: ( ( rule__CollaborationUseRule__VisibilityAssignment_0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:279:1: ( rule__CollaborationUseRule__VisibilityAssignment_0 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:280:1: ( rule__CollaborationUseRule__VisibilityAssignment_0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:280:2: rule__CollaborationUseRule__VisibilityAssignment_0
					{
						pushFollow(FOLLOW_rule__CollaborationUseRule__VisibilityAssignment_0_in_rule__CollaborationUseRule__Group__0__Impl531);
						rule__CollaborationUseRule__VisibilityAssignment_0();
						_fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__0__Impl


	// $ANTLR start rule__CollaborationUseRule__Group__1
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:290:1: rule__CollaborationUseRule__Group__1 : rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2 ;
	public final void rule__CollaborationUseRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:294:1: ( rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:295:2: rule__CollaborationUseRule__Group__1__Impl rule__CollaborationUseRule__Group__2
			{
				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__1__Impl_in_rule__CollaborationUseRule__Group__1561);
				rule__CollaborationUseRule__Group__1__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__2_in_rule__CollaborationUseRule__Group__1564);
				rule__CollaborationUseRule__Group__2();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__1


	// $ANTLR start rule__CollaborationUseRule__Group__1__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:302:1: rule__CollaborationUseRule__Group__1__Impl : ( ( rule__CollaborationUseRule__NameAssignment_1 ) ) ;
	public final void rule__CollaborationUseRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:306:1: ( ( ( rule__CollaborationUseRule__NameAssignment_1 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:307:1: ( ( rule__CollaborationUseRule__NameAssignment_1 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:307:1: ( ( rule__CollaborationUseRule__NameAssignment_1 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:308:1: ( rule__CollaborationUseRule__NameAssignment_1 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:309:1: ( rule__CollaborationUseRule__NameAssignment_1 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:309:2: rule__CollaborationUseRule__NameAssignment_1
					{
						pushFollow(FOLLOW_rule__CollaborationUseRule__NameAssignment_1_in_rule__CollaborationUseRule__Group__1__Impl591);
						rule__CollaborationUseRule__NameAssignment_1();
						_fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__1__Impl


	// $ANTLR start rule__CollaborationUseRule__Group__2
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:319:1: rule__CollaborationUseRule__Group__2 : rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3 ;
	public final void rule__CollaborationUseRule__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:323:1: ( rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:324:2: rule__CollaborationUseRule__Group__2__Impl rule__CollaborationUseRule__Group__3
			{
				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__2__Impl_in_rule__CollaborationUseRule__Group__2621);
				rule__CollaborationUseRule__Group__2__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__3_in_rule__CollaborationUseRule__Group__2624);
				rule__CollaborationUseRule__Group__3();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__2


	// $ANTLR start rule__CollaborationUseRule__Group__2__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:331:1: rule__CollaborationUseRule__Group__2__Impl : ( ':' ) ;
	public final void rule__CollaborationUseRule__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:335:1: ( ( ':' ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:336:1: ( ':' )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:336:1: ( ':' )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:337:1: ':'
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2());
					match(input, 17, FOLLOW_17_in_rule__CollaborationUseRule__Group__2__Impl652);
					after(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__2__Impl


	// $ANTLR start rule__CollaborationUseRule__Group__3
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:350:1: rule__CollaborationUseRule__Group__3 : rule__CollaborationUseRule__Group__3__Impl ;
	public final void rule__CollaborationUseRule__Group__3() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:354:1: ( rule__CollaborationUseRule__Group__3__Impl )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:355:2: rule__CollaborationUseRule__Group__3__Impl
			{
				pushFollow(FOLLOW_rule__CollaborationUseRule__Group__3__Impl_in_rule__CollaborationUseRule__Group__3683);
				rule__CollaborationUseRule__Group__3__Impl();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__3


	// $ANTLR start rule__CollaborationUseRule__Group__3__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:361:1: rule__CollaborationUseRule__Group__3__Impl : ( ( rule__CollaborationUseRule__Alternatives_3 ) ) ;
	public final void rule__CollaborationUseRule__Group__3__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:365:1: ( ( ( rule__CollaborationUseRule__Alternatives_3 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:366:1: ( ( rule__CollaborationUseRule__Alternatives_3 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:366:1: ( ( rule__CollaborationUseRule__Alternatives_3 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:367:1: ( rule__CollaborationUseRule__Alternatives_3 )
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:368:1: ( rule__CollaborationUseRule__Alternatives_3 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:368:2: rule__CollaborationUseRule__Alternatives_3
					{
						pushFollow(FOLLOW_rule__CollaborationUseRule__Alternatives_3_in_rule__CollaborationUseRule__Group__3__Impl710);
						rule__CollaborationUseRule__Alternatives_3();
						_fsp--;


					}

					after(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__Group__3__Impl


	// $ANTLR start rule__TypeRule__Group__0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:386:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
	public final void rule__TypeRule__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:390:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:391:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
			{
				pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__0748);
				rule__TypeRule__Group__0__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__0751);
				rule__TypeRule__Group__1();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__Group__0


	// $ANTLR start rule__TypeRule__Group__0__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:398:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
	public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:402:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:403:1: ( ( rule__TypeRule__PathAssignment_0 )? )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:403:1: ( ( rule__TypeRule__PathAssignment_0 )? )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:404:1: ( rule__TypeRule__PathAssignment_0 )?
				{
					before(grammarAccess.getTypeRuleAccess().getPathAssignment_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:405:1: ( rule__TypeRule__PathAssignment_0 )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if((LA3_0 == RULE_ID)) {
						int LA3_1 = input.LA(2);

						if((LA3_1 == 18)) {
							alt3 = 1;
						}
					}
					switch(alt3) {
					case 1:
						// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:405:2: rule__TypeRule__PathAssignment_0
					{
						pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl778);
						rule__TypeRule__PathAssignment_0();
						_fsp--;


					}
						break;

					}

					after(grammarAccess.getTypeRuleAccess().getPathAssignment_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__Group__0__Impl


	// $ANTLR start rule__TypeRule__Group__1
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:415:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
	public final void rule__TypeRule__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:419:1: ( rule__TypeRule__Group__1__Impl )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:420:2: rule__TypeRule__Group__1__Impl
			{
				pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__1809);
				rule__TypeRule__Group__1__Impl();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__Group__1


	// $ANTLR start rule__TypeRule__Group__1__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:426:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
	public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:430:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:431:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:431:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:432:1: ( rule__TypeRule__TypeAssignment_1 )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:433:1: ( rule__TypeRule__TypeAssignment_1 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:433:2: rule__TypeRule__TypeAssignment_1
					{
						pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl836);
						rule__TypeRule__TypeAssignment_1();
						_fsp--;


					}

					after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__Group__1__Impl


	// $ANTLR start rule__QualifiedName__Group__0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:447:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
	public final void rule__QualifiedName__Group__0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:451:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:452:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
			{
				pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0870);
				rule__QualifiedName__Group__0__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0873);
				rule__QualifiedName__Group__1();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__0


	// $ANTLR start rule__QualifiedName__Group__0__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:459:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
	public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:463:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:464:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:464:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:465:1: ( rule__QualifiedName__PathAssignment_0 )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:466:1: ( rule__QualifiedName__PathAssignment_0 )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:466:2: rule__QualifiedName__PathAssignment_0
					{
						pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl900);
						rule__QualifiedName__PathAssignment_0();
						_fsp--;


					}

					after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__0__Impl


	// $ANTLR start rule__QualifiedName__Group__1
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:476:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
	public final void rule__QualifiedName__Group__1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:480:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:481:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
			{
				pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1930);
				rule__QualifiedName__Group__1__Impl();
				_fsp--;

				pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1933);
				rule__QualifiedName__Group__2();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__1


	// $ANTLR start rule__QualifiedName__Group__1__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:488:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
	public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:492:1: ( ( '::' ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:493:1: ( '::' )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:493:1: ( '::' )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:494:1: '::'
				{
					before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
					match(input, 18, FOLLOW_18_in_rule__QualifiedName__Group__1__Impl961);
					after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__1__Impl


	// $ANTLR start rule__QualifiedName__Group__2
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:507:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
	public final void rule__QualifiedName__Group__2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:511:1: ( rule__QualifiedName__Group__2__Impl )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:512:2: rule__QualifiedName__Group__2__Impl
			{
				pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2992);
				rule__QualifiedName__Group__2__Impl();
				_fsp--;


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__2


	// $ANTLR start rule__QualifiedName__Group__2__Impl
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:518:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
	public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:522:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:523:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:523:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:524:1: ( rule__QualifiedName__RemainingAssignment_2 )?
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:525:1: ( rule__QualifiedName__RemainingAssignment_2 )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if((LA4_0 == RULE_ID)) {
						int LA4_1 = input.LA(2);

						if((LA4_1 == 18)) {
							alt4 = 1;
						}
					}
					switch(alt4) {
					case 1:
						// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:525:2: rule__QualifiedName__RemainingAssignment_2
					{
						pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1019);
						rule__QualifiedName__RemainingAssignment_2();
						_fsp--;


					}
						break;

					}

					after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__Group__2__Impl


	// $ANTLR start rule__CollaborationUseRule__VisibilityAssignment_0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:544:1: rule__CollaborationUseRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
	public final void rule__CollaborationUseRule__VisibilityAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:548:1: ( ( ruleVisibilityKind ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:549:1: ( ruleVisibilityKind )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:549:1: ( ruleVisibilityKind )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:550:1: ruleVisibilityKind
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());
					pushFollow(FOLLOW_ruleVisibilityKind_in_rule__CollaborationUseRule__VisibilityAssignment_01063);
					ruleVisibilityKind();
					_fsp--;

					after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__VisibilityAssignment_0


	// $ANTLR start rule__CollaborationUseRule__NameAssignment_1
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:559:1: rule__CollaborationUseRule__NameAssignment_1 : ( RULE_ID ) ;
	public final void rule__CollaborationUseRule__NameAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:563:1: ( ( RULE_ID ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:564:1: ( RULE_ID )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:564:1: ( RULE_ID )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:565:1: RULE_ID
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0());
					match(input, RULE_ID, FOLLOW_RULE_ID_in_rule__CollaborationUseRule__NameAssignment_11094);
					after(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__NameAssignment_1


	// $ANTLR start rule__CollaborationUseRule__TypeAssignment_3_0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:574:1: rule__CollaborationUseRule__TypeAssignment_3_0 : ( ruleTypeRule ) ;
	public final void rule__CollaborationUseRule__TypeAssignment_3_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:578:1: ( ( ruleTypeRule ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:579:1: ( ruleTypeRule )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:579:1: ( ruleTypeRule )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:580:1: ruleTypeRule
				{
					before(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0());
					pushFollow(FOLLOW_ruleTypeRule_in_rule__CollaborationUseRule__TypeAssignment_3_01125);
					ruleTypeRule();
					_fsp--;

					after(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__CollaborationUseRule__TypeAssignment_3_0


	// $ANTLR start rule__TypeRule__PathAssignment_0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:589:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
	public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:593:1: ( ( ruleQualifiedName ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:594:1: ( ruleQualifiedName )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:594:1: ( ruleQualifiedName )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:595:1: ruleQualifiedName
				{
					before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());
					pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_01156);
					ruleQualifiedName();
					_fsp--;

					after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__PathAssignment_0


	// $ANTLR start rule__TypeRule__TypeAssignment_1
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:604:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
	public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:608:1: ( ( ( RULE_ID ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:609:1: ( ( RULE_ID ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:609:1: ( ( RULE_ID ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:610:1: ( RULE_ID )
				{
					before(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:611:1: ( RULE_ID )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:612:1: RULE_ID
					{
						before(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1());
						match(input, RULE_ID, FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_11191);
						after(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1());

					}

					after(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__TypeRule__TypeAssignment_1


	// $ANTLR start rule__QualifiedName__PathAssignment_0
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:623:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
	public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:627:1: ( ( ( RULE_ID ) ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:628:1: ( ( RULE_ID ) )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:628:1: ( ( RULE_ID ) )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:629:1: ( RULE_ID )
				{
					before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:630:1: ( RULE_ID )
					// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:631:1: RULE_ID
					{
						before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1());
						match(input, RULE_ID, FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_01230);
						after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1());

					}

					after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__PathAssignment_0


	// $ANTLR start rule__QualifiedName__RemainingAssignment_2
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:642:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
	public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:646:1: ( ( ruleQualifiedName ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:647:1: ( ruleQualifiedName )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:647:1: ( ruleQualifiedName )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:648:1: ruleQualifiedName
				{
					before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0());
					pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_21265);
					ruleQualifiedName();
					_fsp--;

					after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__QualifiedName__RemainingAssignment_2


	// $ANTLR start rule__BoundSpecification__ValueAssignment
	// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:659:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
	public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

		int stackSize = keepStackSize();

		try {
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:663:1: ( ( RULE_UNLIMITEDLITERAL ) )
			// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:664:1: ( RULE_UNLIMITEDLITERAL )
			{
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:664:1: ( RULE_UNLIMITEDLITERAL )
				// ../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g:665:1: RULE_UNLIMITEDLITERAL
				{
					before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0());
					match(input, RULE_UNLIMITEDLITERAL, FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment1298);
					after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0());

				}


			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {

			restoreStackSize(stackSize);

		}
		return;
	}

	// $ANTLR end rule__BoundSpecification__ValueAssignment




	public static final BitSet FOLLOW_ruleCollaborationUseRule_in_entryRuleCollaborationUseRule61 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleCollaborationUseRule68 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__0_in_ruleCollaborationUseRule94 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule121 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule128 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule154 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName188 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification243 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification250 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification276 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind313 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__TypeAssignment_3_0_in_rule__CollaborationUseRule__Alternatives_3350 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_12_in_rule__CollaborationUseRule__Alternatives_3369 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_13_in_rule__VisibilityKind__Alternatives404 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives425 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives446 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives467 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__0__Impl_in_rule__CollaborationUseRule__Group__0501 = new BitSet(new long[]{ 0x0000000000000010L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__1_in_rule__CollaborationUseRule__Group__0504 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__VisibilityAssignment_0_in_rule__CollaborationUseRule__Group__0__Impl531 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__1__Impl_in_rule__CollaborationUseRule__Group__1561 = new BitSet(new long[]{ 0x0000000000020000L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__2_in_rule__CollaborationUseRule__Group__1564 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__NameAssignment_1_in_rule__CollaborationUseRule__Group__1__Impl591 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__2__Impl_in_rule__CollaborationUseRule__Group__2621 = new BitSet(new long[]{ 0x0000000000001010L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__3_in_rule__CollaborationUseRule__Group__2624 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_17_in_rule__CollaborationUseRule__Group__2__Impl652 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Group__3__Impl_in_rule__CollaborationUseRule__Group__3683 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__CollaborationUseRule__Alternatives_3_in_rule__CollaborationUseRule__Group__3__Impl710 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__0748 = new BitSet(new long[]{ 0x0000000000000010L });

	public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__0751 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl778 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__1809 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl836 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0870 = new BitSet(new long[]{ 0x0000000000040000L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0873 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl900 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1930 = new BitSet(new long[]{ 0x0000000000000012L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1933 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_18_in_rule__QualifiedName__Group__1__Impl961 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2992 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1019 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__CollaborationUseRule__VisibilityAssignment_01063 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_ID_in_rule__CollaborationUseRule__NameAssignment_11094 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleTypeRule_in_rule__CollaborationUseRule__TypeAssignment_3_01125 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_01156 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_11191 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_01230 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_21265 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment1298 = new BitSet(new long[]{ 0x0000000000000002L });

}
