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
package org.eclipse.papyrus.parameter.editor.xtext.parser.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.papyrus.parameter.editor.xtext.services.UmlParameterGrammarAccess;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlParameterParser extends AbstractInternalAntlrParser {

	public static final String[] tokenNames = new String[]{ "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'<Undefined>'", "'{'", "','", "'}'", "'effect: '", "'::'", "'['", "'..'", "']'", "'exception'", "'stream'", "'ordered'", "'unique'", "'create'", "'read'", "'update'", "'delete'", "'+'", "'-'", "'#'", "'~'", "'in'", "'out'", "'inout'", "'return'" };

	public static final int RULE_ID = 4;

	public static final int RULE_STRING = 7;

	public static final int RULE_UNLIMITEDLITERAL = 5;

	public static final int RULE_ANY_OTHER = 11;

	public static final int RULE_INT = 6;

	public static final int RULE_WS = 10;

	public static final int RULE_SL_COMMENT = 9;

	public static final int EOF = -1;

	public static final int RULE_ML_COMMENT = 8;

	public InternalUmlParameterParser(TokenStream input) {
		super(input);
	}


	public String[] getTokenNames() {
		return tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g";
	}



	private UmlParameterGrammarAccess grammarAccess;

	public InternalUmlParameterParser(TokenStream input, IAstFactory factory, UmlParameterGrammarAccess grammarAccess) {
		this(input);
		this.factory = factory;
		registerRules(grammarAccess.getGrammar());
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected InputStream getTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.tokens");
	}

	@Override
	protected String getFirstRuleName() {
		return "ParameterRule";
	}

	@Override
	protected UmlParameterGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start entryRuleParameterRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:78:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
	public final EObject entryRuleParameterRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleParameterRule = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:79:2: (iv_ruleParameterRule= ruleParameterRule EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:80:2: iv_ruleParameterRule= ruleParameterRule EOF
			{
				currentNode = createCompositeNode(grammarAccess.getParameterRuleRule(), currentNode);
				pushFollow(FOLLOW_ruleParameterRule_in_entryRuleParameterRule75);
				iv_ruleParameterRule = ruleParameterRule();
				_fsp--;

				current = iv_ruleParameterRule;
				match(input, EOF, FOLLOW_EOF_in_entryRuleParameterRule85);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleParameterRule


	// $ANTLR start ruleParameterRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:87:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) ) ;
	public final EObject ruleParameterRule() throws RecognitionException {
		EObject current = null;

		Token lv_name_2_0 = null;
		Enumerator lv_visibility_0_0 = null;

		Enumerator lv_direction_1_0 = null;

		EObject lv_type_4_0 = null;

		EObject lv_multiplicity_6_0 = null;

		EObject lv_modifiers_7_0 = null;

		EObject lv_effect_8_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:92:6: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:95:3: lv_visibility_0_0= ruleVisibilityKind
						{

							currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0(), currentNode);

							pushFollow(FOLLOW_ruleVisibilityKind_in_ruleParameterRule131);
							lv_visibility_0_0 = ruleVisibilityKind();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "visibility", lv_visibility_0_0, "VisibilityKind", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:117:2: ( (lv_direction_1_0= ruleDirection ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:118:1: (lv_direction_1_0= ruleDirection )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:118:1: (lv_direction_1_0= ruleDirection )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:119:3: lv_direction_1_0= ruleDirection
						{

							currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getDirectionDirectionEnumRuleCall_1_0(), currentNode);

							pushFollow(FOLLOW_ruleDirection_in_ruleParameterRule152);
							lv_direction_1_0 = ruleDirection();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "direction", lv_direction_1_0, "Direction", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:141:2: ( (lv_name_2_0= RULE_ID ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:142:1: (lv_name_2_0= RULE_ID )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:142:1: (lv_name_2_0= RULE_ID )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:143:3: lv_name_2_0= RULE_ID
						{
							lv_name_2_0 = (Token)input.LT(1);
							match(input, RULE_ID, FOLLOW_RULE_ID_in_ruleParameterRule169);

							createLeafNode(grammarAccess.getParameterRuleAccess().getNameIDTerminalRuleCall_2_0(), "name");


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode, current);
							}
							try {
								set(current, "name", lv_name_2_0, "ID", lastConsumedNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}


						}


					}

					match(input, 12, FOLLOW_12_in_ruleParameterRule184);

					createLeafNode(grammarAccess.getParameterRuleAccess().getColonKeyword_3(), null);

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:169:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' )
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if((LA1_0 == RULE_ID)) {
						alt1 = 1;
					} else if((LA1_0 == 13)) {
						alt1 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException("169:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' )", 1, 0, input);

						throw nvae;
					}
					switch(alt1) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:169:2: ( (lv_type_4_0= ruleTypeRule ) )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:169:2: ( (lv_type_4_0= ruleTypeRule ) )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:170:1: (lv_type_4_0= ruleTypeRule )
						{
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:170:1: (lv_type_4_0= ruleTypeRule )
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:171:3: lv_type_4_0= ruleTypeRule
							{

								currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0(), currentNode);

								pushFollow(FOLLOW_ruleTypeRule_in_ruleParameterRule206);
								lv_type_4_0 = ruleTypeRule();
								_fsp--;


								if(current == null) {
									current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
									associateNodeWithAstElement(currentNode.getParent(), current);
								}
								try {
									set(current, "type", lv_type_4_0, "TypeRule", currentNode);
								} catch (ValueConverterException vce) {
									handleValueConverterException(vce);
								}
								currentNode = currentNode.getParent();


							}


						}


					}
						break;
					case 2:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:194:7: '<Undefined>'
					{
						match(input, 13, FOLLOW_13_in_ruleParameterRule222);

						createLeafNode(grammarAccess.getParameterRuleAccess().getUndefinedKeyword_4_1(), null);


					}
						break;

					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:198:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if((LA2_0 == 19)) {
						alt2 = 1;
					}
					switch(alt2) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:199:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:199:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:200:3: lv_multiplicity_6_0= ruleMultiplicityRule
						{

							currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0(), currentNode);

							pushFollow(FOLLOW_ruleMultiplicityRule_in_ruleParameterRule244);
							lv_multiplicity_6_0 = ruleMultiplicityRule();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "multiplicity", lv_multiplicity_6_0, "MultiplicityRule", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}
						break;

					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:222:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if((LA3_0 == 14)) {
						int LA3_1 = input.LA(2);

						if(((LA3_1 >= 22 && LA3_1 <= 25))) {
							alt3 = 1;
						}
					}
					switch(alt3) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:223:1: (lv_modifiers_7_0= ruleModifiersRule )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:223:1: (lv_modifiers_7_0= ruleModifiersRule )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:224:3: lv_modifiers_7_0= ruleModifiersRule
						{

							currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0(), currentNode);

							pushFollow(FOLLOW_ruleModifiersRule_in_ruleParameterRule266);
							lv_modifiers_7_0 = ruleModifiersRule();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "modifiers", lv_modifiers_7_0, "ModifiersRule", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}
						break;

					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:246:3: ( (lv_effect_8_0= ruleEffectRule ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:247:1: (lv_effect_8_0= ruleEffectRule )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:247:1: (lv_effect_8_0= ruleEffectRule )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:248:3: lv_effect_8_0= ruleEffectRule
						{

							currentNode = createCompositeNode(grammarAccess.getParameterRuleAccess().getEffectEffectRuleParserRuleCall_7_0(), currentNode);

							pushFollow(FOLLOW_ruleEffectRule_in_ruleParameterRule288);
							lv_effect_8_0 = ruleEffectRule();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getParameterRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "effect", lv_effect_8_0, "EffectRule", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleParameterRule


	// $ANTLR start entryRuleModifiersRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:278:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
	public final EObject entryRuleModifiersRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleModifiersRule = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:279:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:280:2: iv_ruleModifiersRule= ruleModifiersRule EOF
			{
				currentNode = createCompositeNode(grammarAccess.getModifiersRuleRule(), currentNode);
				pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule324);
				iv_ruleModifiersRule = ruleModifiersRule();
				_fsp--;

				current = iv_ruleModifiersRule;
				match(input, EOF, FOLLOW_EOF_in_entryRuleModifiersRule334);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleModifiersRule


	// $ANTLR start ruleModifiersRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:287:1: ruleModifiersRule returns [EObject current=null] : ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) ;
	public final EObject ruleModifiersRule() throws RecognitionException {
		EObject current = null;

		EObject lv_values_1_0 = null;

		EObject lv_values_3_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:292:6: ( ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:293:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:293:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:293:3: '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}'
				{
					match(input, 14, FOLLOW_14_in_ruleModifiersRule369);

					createLeafNode(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0(), null);

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:297:1: ( (lv_values_1_0= ruleModifierSpecification ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:298:1: (lv_values_1_0= ruleModifierSpecification )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:298:1: (lv_values_1_0= ruleModifierSpecification )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:299:3: lv_values_1_0= ruleModifierSpecification
						{

							currentNode = createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0(), currentNode);

							pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule390);
							lv_values_1_0 = ruleModifierSpecification();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getModifiersRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								add(current, "values", lv_values_1_0, "ModifierSpecification", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:321:2: ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
					loop4: do {
						int alt4 = 2;
						int LA4_0 = input.LA(1);

						if((LA4_0 == 15)) {
							alt4 = 1;
						}


						switch(alt4) {
						case 1:
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:321:4: ',' ( (lv_values_3_0= ruleModifierSpecification ) )
						{
							match(input, 15, FOLLOW_15_in_ruleModifiersRule401);

							createLeafNode(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0(), null);

							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:325:1: ( (lv_values_3_0= ruleModifierSpecification ) )
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:326:1: (lv_values_3_0= ruleModifierSpecification )
							{
								// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:326:1: (lv_values_3_0= ruleModifierSpecification )
								// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:327:3: lv_values_3_0= ruleModifierSpecification
								{

									currentNode = createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0(), currentNode);

									pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule422);
									lv_values_3_0 = ruleModifierSpecification();
									_fsp--;


									if(current == null) {
										current = factory.create(grammarAccess.getModifiersRuleRule().getType().getClassifier());
										associateNodeWithAstElement(currentNode.getParent(), current);
									}
									try {
										add(current, "values", lv_values_3_0, "ModifierSpecification", currentNode);
									} catch (ValueConverterException vce) {
										handleValueConverterException(vce);
									}
									currentNode = currentNode.getParent();


								}


							}


						}
							break;

						default:
							break loop4;
						}
					} while(true);

					match(input, 16, FOLLOW_16_in_ruleModifiersRule434);

					createLeafNode(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3(), null);


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleModifiersRule


	// $ANTLR start entryRuleModifierSpecification
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:361:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
	public final EObject entryRuleModifierSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleModifierSpecification = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:362:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:363:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
			{
				currentNode = createCompositeNode(grammarAccess.getModifierSpecificationRule(), currentNode);
				pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification470);
				iv_ruleModifierSpecification = ruleModifierSpecification();
				_fsp--;

				current = iv_ruleModifierSpecification;
				match(input, EOF, FOLLOW_EOF_in_entryRuleModifierSpecification480);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleModifierSpecification


	// $ANTLR start ruleModifierSpecification
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:370:1: ruleModifierSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleModifierKind ) ) ;
	public final EObject ruleModifierSpecification() throws RecognitionException {
		EObject current = null;

		Enumerator lv_value_0_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:375:6: ( ( (lv_value_0_0= ruleModifierKind ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:376:1: ( (lv_value_0_0= ruleModifierKind ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:376:1: ( (lv_value_0_0= ruleModifierKind ) )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:377:1: (lv_value_0_0= ruleModifierKind )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:377:1: (lv_value_0_0= ruleModifierKind )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:378:3: lv_value_0_0= ruleModifierKind
					{

						currentNode = createCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0(), currentNode);

						pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification525);
						lv_value_0_0 = ruleModifierKind();
						_fsp--;


						if(current == null) {
							current = factory.create(grammarAccess.getModifierSpecificationRule().getType().getClassifier());
							associateNodeWithAstElement(currentNode.getParent(), current);
						}
						try {
							set(current, "value", lv_value_0_0, "ModifierKind", currentNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}
						currentNode = currentNode.getParent();


					}


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleModifierSpecification


	// $ANTLR start entryRuleEffectRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:408:1: entryRuleEffectRule returns [EObject current=null] : iv_ruleEffectRule= ruleEffectRule EOF ;
	public final EObject entryRuleEffectRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleEffectRule = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:409:2: (iv_ruleEffectRule= ruleEffectRule EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:410:2: iv_ruleEffectRule= ruleEffectRule EOF
			{
				currentNode = createCompositeNode(grammarAccess.getEffectRuleRule(), currentNode);
				pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule560);
				iv_ruleEffectRule = ruleEffectRule();
				_fsp--;

				current = iv_ruleEffectRule;
				match(input, EOF, FOLLOW_EOF_in_entryRuleEffectRule570);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleEffectRule


	// $ANTLR start ruleEffectRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:417:1: ruleEffectRule returns [EObject current=null] : ( '{' 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) '}' ) ;
	public final EObject ruleEffectRule() throws RecognitionException {
		EObject current = null;

		Enumerator lv_effectKind_2_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:422:6: ( ( '{' 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) '}' ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:423:1: ( '{' 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) '}' )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:423:1: ( '{' 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) '}' )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:423:3: '{' 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) '}'
				{
					match(input, 14, FOLLOW_14_in_ruleEffectRule605);

					createLeafNode(grammarAccess.getEffectRuleAccess().getLeftCurlyBracketKeyword_0(), null);

					match(input, 17, FOLLOW_17_in_ruleEffectRule615);

					createLeafNode(grammarAccess.getEffectRuleAccess().getEffectKeyword_1(), null);

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:431:1: ( (lv_effectKind_2_0= ruleEffectKind ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:432:1: (lv_effectKind_2_0= ruleEffectKind )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:432:1: (lv_effectKind_2_0= ruleEffectKind )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:433:3: lv_effectKind_2_0= ruleEffectKind
						{

							currentNode = createCompositeNode(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0(), currentNode);

							pushFollow(FOLLOW_ruleEffectKind_in_ruleEffectRule636);
							lv_effectKind_2_0 = ruleEffectKind();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getEffectRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "effectKind", lv_effectKind_2_0, "EffectKind", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}

					match(input, 16, FOLLOW_16_in_ruleEffectRule646);

					createLeafNode(grammarAccess.getEffectRuleAccess().getRightCurlyBracketKeyword_3(), null);


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleEffectRule


	// $ANTLR start entryRuleQualifiedName
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:467:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final EObject entryRuleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleQualifiedName = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:468:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:469:2: iv_ruleQualifiedName= ruleQualifiedName EOF
			{
				currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode);
				pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName682);
				iv_ruleQualifiedName = ruleQualifiedName();
				_fsp--;

				current = iv_ruleQualifiedName;
				match(input, EOF, FOLLOW_EOF_in_entryRuleQualifiedName692);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleQualifiedName


	// $ANTLR start ruleQualifiedName
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:476:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
	public final EObject ruleQualifiedName() throws RecognitionException {
		EObject current = null;

		EObject lv_remaining_2_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:481:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:482:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:482:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:482:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:482:2: ( ( RULE_ID ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:483:1: ( RULE_ID )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:483:1: ( RULE_ID )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:484:3: RULE_ID
						{

							if(current == null) {
								current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode, current);
							}

							match(input, RULE_ID, FOLLOW_RULE_ID_in_ruleQualifiedName735);

							createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path");


						}


					}

					match(input, 18, FOLLOW_18_in_ruleQualifiedName745);

					createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null);

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:500:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if((LA5_0 == RULE_ID)) {
						int LA5_1 = input.LA(2);

						if((LA5_1 == 18)) {
							alt5 = 1;
						}
					}
					switch(alt5) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:501:1: (lv_remaining_2_0= ruleQualifiedName )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:501:1: (lv_remaining_2_0= ruleQualifiedName )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:502:3: lv_remaining_2_0= ruleQualifiedName
						{

							currentNode = createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode);

							pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName766);
							lv_remaining_2_0 = ruleQualifiedName();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "remaining", lv_remaining_2_0, "QualifiedName", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}
						break;

					}


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleQualifiedName


	// $ANTLR start entryRuleTypeRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:532:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
	public final EObject entryRuleTypeRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeRule = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:533:2: (iv_ruleTypeRule= ruleTypeRule EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:534:2: iv_ruleTypeRule= ruleTypeRule EOF
			{
				currentNode = createCompositeNode(grammarAccess.getTypeRuleRule(), currentNode);
				pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule803);
				iv_ruleTypeRule = ruleTypeRule();
				_fsp--;

				current = iv_ruleTypeRule;
				match(input, EOF, FOLLOW_EOF_in_entryRuleTypeRule813);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleTypeRule


	// $ANTLR start ruleTypeRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:541:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
	public final EObject ruleTypeRule() throws RecognitionException {
		EObject current = null;

		EObject lv_path_0_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:546:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:547:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:547:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:547:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:547:2: ( (lv_path_0_0= ruleQualifiedName ) )?
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if((LA6_0 == RULE_ID)) {
						int LA6_1 = input.LA(2);

						if((LA6_1 == 18)) {
							alt6 = 1;
						}
					}
					switch(alt6) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:548:1: (lv_path_0_0= ruleQualifiedName )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:548:1: (lv_path_0_0= ruleQualifiedName )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:549:3: lv_path_0_0= ruleQualifiedName
						{

							currentNode = createCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode);

							pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule859);
							lv_path_0_0 = ruleQualifiedName();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								set(current, "path", lv_path_0_0, "QualifiedName", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}
						break;

					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:571:3: ( ( RULE_ID ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:572:1: ( RULE_ID )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:572:1: ( RULE_ID )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:573:3: RULE_ID
						{

							if(current == null) {
								current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode, current);
							}

							match(input, RULE_ID, FOLLOW_RULE_ID_in_ruleTypeRule878);

							createLeafNode(grammarAccess.getTypeRuleAccess().getTypeTypeCrossReference_1_0(), "type");


						}


					}


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleTypeRule


	// $ANTLR start entryRuleMultiplicityRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:593:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
	public final EObject entryRuleMultiplicityRule() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMultiplicityRule = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:594:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:595:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
			{
				currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleRule(), currentNode);
				pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule914);
				iv_ruleMultiplicityRule = ruleMultiplicityRule();
				_fsp--;

				current = iv_ruleMultiplicityRule;
				match(input, EOF, FOLLOW_EOF_in_entryRuleMultiplicityRule924);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleMultiplicityRule


	// $ANTLR start ruleMultiplicityRule
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:602:1: ruleMultiplicityRule returns [EObject current=null] : ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) ;
	public final EObject ruleMultiplicityRule() throws RecognitionException {
		EObject current = null;

		EObject lv_bounds_1_0 = null;

		EObject lv_bounds_3_0 = null;


		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:607:6: ( ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:608:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:608:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:608:3: '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']'
				{
					match(input, 19, FOLLOW_19_in_ruleMultiplicityRule959);

					createLeafNode(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0(), null);

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:612:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:613:1: (lv_bounds_1_0= ruleBoundSpecification )
					{
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:613:1: (lv_bounds_1_0= ruleBoundSpecification )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:614:3: lv_bounds_1_0= ruleBoundSpecification
						{

							currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0(), currentNode);

							pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule980);
							lv_bounds_1_0 = ruleBoundSpecification();
							_fsp--;


							if(current == null) {
								current = factory.create(grammarAccess.getMultiplicityRuleRule().getType().getClassifier());
								associateNodeWithAstElement(currentNode.getParent(), current);
							}
							try {
								add(current, "bounds", lv_bounds_1_0, "BoundSpecification", currentNode);
							} catch (ValueConverterException vce) {
								handleValueConverterException(vce);
							}
							currentNode = currentNode.getParent();


						}


					}

					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:636:2: ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if((LA7_0 == 20)) {
						alt7 = 1;
					}
					switch(alt7) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:636:4: '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
					{
						match(input, 20, FOLLOW_20_in_ruleMultiplicityRule991);

						createLeafNode(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0(), null);

						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:640:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
						// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:641:1: (lv_bounds_3_0= ruleBoundSpecification )
						{
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:641:1: (lv_bounds_3_0= ruleBoundSpecification )
							// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:642:3: lv_bounds_3_0= ruleBoundSpecification
							{

								currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0(), currentNode);

								pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1012);
								lv_bounds_3_0 = ruleBoundSpecification();
								_fsp--;


								if(current == null) {
									current = factory.create(grammarAccess.getMultiplicityRuleRule().getType().getClassifier());
									associateNodeWithAstElement(currentNode.getParent(), current);
								}
								try {
									add(current, "bounds", lv_bounds_3_0, "BoundSpecification", currentNode);
								} catch (ValueConverterException vce) {
									handleValueConverterException(vce);
								}
								currentNode = currentNode.getParent();


							}


						}


					}
						break;

					}

					match(input, 21, FOLLOW_21_in_ruleMultiplicityRule1024);

					createLeafNode(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3(), null);


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleMultiplicityRule


	// $ANTLR start entryRuleBoundSpecification
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:676:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
	public final EObject entryRuleBoundSpecification() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBoundSpecification = null;


		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:677:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:678:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
			{
				currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode);
				pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification1060);
				iv_ruleBoundSpecification = ruleBoundSpecification();
				_fsp--;

				current = iv_ruleBoundSpecification;
				match(input, EOF, FOLLOW_EOF_in_entryRuleBoundSpecification1070);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleBoundSpecification


	// $ANTLR start ruleBoundSpecification
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:685:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
	public final EObject ruleBoundSpecification() throws RecognitionException {
		EObject current = null;

		Token lv_value_0_0 = null;

		EObject temp = null;
		setCurrentLookahead();
		resetLookahead();

		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:690:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:691:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:691:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:692:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:692:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:693:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
					{
						lv_value_0_0 = (Token)input.LT(1);
						match(input, RULE_UNLIMITEDLITERAL, FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification1111);

						createLeafNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0(), "value");


						if(current == null) {
							current = factory.create(grammarAccess.getBoundSpecificationRule().getType().getClassifier());
							associateNodeWithAstElement(currentNode, current);
						}
						try {
							set(current, "value", lv_value_0_0, "UnlimitedLiteral", lastConsumedNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}


					}


				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleBoundSpecification


	// $ANTLR start ruleModifierKind
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:723:1: ruleModifierKind returns [Enumerator current=null] : ( ( 'exception' ) | ( 'stream' ) | ( 'ordered' ) | ( 'unique' ) ) ;
	public final Enumerator ruleModifierKind() throws RecognitionException {
		Enumerator current = null;

		setCurrentLookahead();
		resetLookahead();
		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:727:6: ( ( ( 'exception' ) | ( 'stream' ) | ( 'ordered' ) | ( 'unique' ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:728:1: ( ( 'exception' ) | ( 'stream' ) | ( 'ordered' ) | ( 'unique' ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:728:1: ( ( 'exception' ) | ( 'stream' ) | ( 'ordered' ) | ( 'unique' ) )
				int alt8 = 4;
				switch(input.LA(1)) {
				case 22:
				{
					alt8 = 1;
				}
					break;
				case 23:
				{
					alt8 = 2;
				}
					break;
				case 24:
				{
					alt8 = 3;
				}
					break;
				case 25:
				{
					alt8 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("728:1: ( ( 'exception' ) | ( 'stream' ) | ( 'ordered' ) | ( 'unique' ) )", 8, 0, input);

					throw nvae;
				}

				switch(alt8) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:728:2: ( 'exception' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:728:2: ( 'exception' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:728:4: 'exception'
					{
						match(input, 22, FOLLOW_22_in_ruleModifierKind1163);

						current = grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0(), null);


					}


				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:734:6: ( 'stream' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:734:6: ( 'stream' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:734:8: 'stream'
					{
						match(input, 23, FOLLOW_23_in_ruleModifierKind1178);

						current = grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1(), null);


					}


				}
					break;
				case 3:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:740:6: ( 'ordered' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:740:6: ( 'ordered' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:740:8: 'ordered'
					{
						match(input, 24, FOLLOW_24_in_ruleModifierKind1193);

						current = grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2(), null);


					}


				}
					break;
				case 4:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:746:6: ( 'unique' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:746:6: ( 'unique' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:746:8: 'unique'
					{
						match(input, 25, FOLLOW_25_in_ruleModifierKind1208);

						current = grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3(), null);


					}


				}
					break;

				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleModifierKind


	// $ANTLR start ruleEffectKind
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:756:1: ruleEffectKind returns [Enumerator current=null] : ( ( 'create' ) | ( 'read' ) | ( 'update' ) | ( 'delete' ) ) ;
	public final Enumerator ruleEffectKind() throws RecognitionException {
		Enumerator current = null;

		setCurrentLookahead();
		resetLookahead();
		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:760:6: ( ( ( 'create' ) | ( 'read' ) | ( 'update' ) | ( 'delete' ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:761:1: ( ( 'create' ) | ( 'read' ) | ( 'update' ) | ( 'delete' ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:761:1: ( ( 'create' ) | ( 'read' ) | ( 'update' ) | ( 'delete' ) )
				int alt9 = 4;
				switch(input.LA(1)) {
				case 26:
				{
					alt9 = 1;
				}
					break;
				case 27:
				{
					alt9 = 2;
				}
					break;
				case 28:
				{
					alt9 = 3;
				}
					break;
				case 29:
				{
					alt9 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("761:1: ( ( 'create' ) | ( 'read' ) | ( 'update' ) | ( 'delete' ) )", 9, 0, input);

					throw nvae;
				}

				switch(alt9) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:761:2: ( 'create' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:761:2: ( 'create' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:761:4: 'create'
					{
						match(input, 26, FOLLOW_26_in_ruleEffectKind1251);

						current = grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0(), null);


					}


				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:767:6: ( 'read' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:767:6: ( 'read' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:767:8: 'read'
					{
						match(input, 27, FOLLOW_27_in_ruleEffectKind1266);

						current = grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1(), null);


					}


				}
					break;
				case 3:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:773:6: ( 'update' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:773:6: ( 'update' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:773:8: 'update'
					{
						match(input, 28, FOLLOW_28_in_ruleEffectKind1281);

						current = grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2(), null);


					}


				}
					break;
				case 4:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:779:6: ( 'delete' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:779:6: ( 'delete' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:779:8: 'delete'
					{
						match(input, 29, FOLLOW_29_in_ruleEffectKind1296);

						current = grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3(), null);


					}


				}
					break;

				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleEffectKind


	// $ANTLR start ruleVisibilityKind
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:789:1: ruleVisibilityKind returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) ;
	public final Enumerator ruleVisibilityKind() throws RecognitionException {
		Enumerator current = null;

		setCurrentLookahead();
		resetLookahead();
		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:793:6: ( ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:794:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:794:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
				int alt10 = 4;
				switch(input.LA(1)) {
				case 30:
				{
					alt10 = 1;
				}
					break;
				case 31:
				{
					alt10 = 2;
				}
					break;
				case 32:
				{
					alt10 = 3;
				}
					break;
				case 33:
				{
					alt10 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("794:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )", 10, 0, input);

					throw nvae;
				}

				switch(alt10) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:794:2: ( '+' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:794:2: ( '+' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:794:4: '+'
					{
						match(input, 30, FOLLOW_30_in_ruleVisibilityKind1339);

						current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0(), null);


					}


				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:800:6: ( '-' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:800:6: ( '-' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:800:8: '-'
					{
						match(input, 31, FOLLOW_31_in_ruleVisibilityKind1354);

						current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1(), null);


					}


				}
					break;
				case 3:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:806:6: ( '#' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:806:6: ( '#' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:806:8: '#'
					{
						match(input, 32, FOLLOW_32_in_ruleVisibilityKind1369);

						current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2(), null);


					}


				}
					break;
				case 4:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:812:6: ( '~' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:812:6: ( '~' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:812:8: '~'
					{
						match(input, 33, FOLLOW_33_in_ruleVisibilityKind1384);

						current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3(), null);


					}


				}
					break;

				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleVisibilityKind


	// $ANTLR start ruleDirection
	// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:822:1: ruleDirection returns [Enumerator current=null] : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) | ( 'return' ) ) ;
	public final Enumerator ruleDirection() throws RecognitionException {
		Enumerator current = null;

		setCurrentLookahead();
		resetLookahead();
		try {
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:826:6: ( ( ( 'in' ) | ( 'out' ) | ( 'inout' ) | ( 'return' ) ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:827:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) | ( 'return' ) )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:827:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) | ( 'return' ) )
				int alt11 = 4;
				switch(input.LA(1)) {
				case 34:
				{
					alt11 = 1;
				}
					break;
				case 35:
				{
					alt11 = 2;
				}
					break;
				case 36:
				{
					alt11 = 3;
				}
					break;
				case 37:
				{
					alt11 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("827:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) | ( 'return' ) )", 11, 0, input);

					throw nvae;
				}

				switch(alt11) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:827:2: ( 'in' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:827:2: ( 'in' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:827:4: 'in'
					{
						match(input, 34, FOLLOW_34_in_ruleDirection1427);

						current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0(), null);


					}


				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:833:6: ( 'out' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:833:6: ( 'out' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:833:8: 'out'
					{
						match(input, 35, FOLLOW_35_in_ruleDirection1442);

						current = grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1(), null);


					}


				}
					break;
				case 3:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:839:6: ( 'inout' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:839:6: ( 'inout' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:839:8: 'inout'
					{
						match(input, 36, FOLLOW_36_in_ruleDirection1457);

						current = grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2(), null);


					}


				}
					break;
				case 4:
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:845:6: ( 'return' )
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:845:6: ( 'return' )
					// ../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g:845:8: 'return'
					{
						match(input, 37, FOLLOW_37_in_ruleDirection1472);

						current = grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3(), null);


					}


				}
					break;

				}


			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleDirection




	public static final BitSet FOLLOW_ruleParameterRule_in_entryRuleParameterRule75 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleParameterRule85 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleVisibilityKind_in_ruleParameterRule131 = new BitSet(new long[]{ 0x0000003C00000000L });

	public static final BitSet FOLLOW_ruleDirection_in_ruleParameterRule152 = new BitSet(new long[]{ 0x0000000000000010L });

	public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRule169 = new BitSet(new long[]{ 0x0000000000001000L });

	public static final BitSet FOLLOW_12_in_ruleParameterRule184 = new BitSet(new long[]{ 0x0000000000002010L });

	public static final BitSet FOLLOW_ruleTypeRule_in_ruleParameterRule206 = new BitSet(new long[]{ 0x0000000000084000L });

	public static final BitSet FOLLOW_13_in_ruleParameterRule222 = new BitSet(new long[]{ 0x0000000000084000L });

	public static final BitSet FOLLOW_ruleMultiplicityRule_in_ruleParameterRule244 = new BitSet(new long[]{ 0x0000000000004000L });

	public static final BitSet FOLLOW_ruleModifiersRule_in_ruleParameterRule266 = new BitSet(new long[]{ 0x0000000000004000L });

	public static final BitSet FOLLOW_ruleEffectRule_in_ruleParameterRule288 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule324 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule334 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_14_in_ruleModifiersRule369 = new BitSet(new long[]{ 0x0000000003C00000L });

	public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule390 = new BitSet(new long[]{ 0x0000000000018000L });

	public static final BitSet FOLLOW_15_in_ruleModifiersRule401 = new BitSet(new long[]{ 0x0000000003C00000L });

	public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule422 = new BitSet(new long[]{ 0x0000000000018000L });

	public static final BitSet FOLLOW_16_in_ruleModifiersRule434 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification470 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification480 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification525 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule560 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule570 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_14_in_ruleEffectRule605 = new BitSet(new long[]{ 0x0000000000020000L });

	public static final BitSet FOLLOW_17_in_ruleEffectRule615 = new BitSet(new long[]{ 0x000000003C000000L });

	public static final BitSet FOLLOW_ruleEffectKind_in_ruleEffectRule636 = new BitSet(new long[]{ 0x0000000000010000L });

	public static final BitSet FOLLOW_16_in_ruleEffectRule646 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName682 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName692 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName735 = new BitSet(new long[]{ 0x0000000000040000L });

	public static final BitSet FOLLOW_18_in_ruleQualifiedName745 = new BitSet(new long[]{ 0x0000000000000012L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName766 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule803 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule813 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule859 = new BitSet(new long[]{ 0x0000000000000010L });

	public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule878 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule914 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule924 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_19_in_ruleMultiplicityRule959 = new BitSet(new long[]{ 0x0000000000000020L });

	public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule980 = new BitSet(new long[]{ 0x0000000000300000L });

	public static final BitSet FOLLOW_20_in_ruleMultiplicityRule991 = new BitSet(new long[]{ 0x0000000000000020L });

	public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1012 = new BitSet(new long[]{ 0x0000000000200000L });

	public static final BitSet FOLLOW_21_in_ruleMultiplicityRule1024 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification1060 = new BitSet(new long[]{ 0x0000000000000000L });

	public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification1070 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification1111 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_22_in_ruleModifierKind1163 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_23_in_ruleModifierKind1178 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_24_in_ruleModifierKind1193 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_25_in_ruleModifierKind1208 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_26_in_ruleEffectKind1251 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_27_in_ruleEffectKind1266 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_28_in_ruleEffectKind1281 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_29_in_ruleEffectKind1296 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_30_in_ruleVisibilityKind1339 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_31_in_ruleVisibilityKind1354 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_32_in_ruleVisibilityKind1369 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_33_in_ruleVisibilityKind1384 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_34_in_ruleDirection1427 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_35_in_ruleDirection1442 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_36_in_ruleDirection1457 = new BitSet(new long[]{ 0x0000000000000002L });

	public static final BitSet FOLLOW_37_in_ruleDirection1472 = new BitSet(new long[]{ 0x0000000000000002L });

}
