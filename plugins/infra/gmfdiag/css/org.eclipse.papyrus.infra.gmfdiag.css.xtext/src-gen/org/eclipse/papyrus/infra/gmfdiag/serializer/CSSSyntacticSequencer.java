package org.eclipse.papyrus.infra.gmfdiag.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.services.CSSGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class CSSSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CSSGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AttributeValue_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_AttributeValue_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_Attribute_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Attribute_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_Combinator_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_CompositeSelector_WSTerminalRuleCall_1_0_p;
	protected AbstractElementAlias match_CompositeSelector_WSTerminalRuleCall_1_1_0_a;
	protected AbstractElementAlias match_Declaration_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Declaration_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_Declaration_WSTerminalRuleCall_5_1_a;
	protected AbstractElementAlias match_Function_WSTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Import_WSTerminalRuleCall_1_0_0_a;
	protected AbstractElementAlias match_Import_WSTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Import_WSTerminalRuleCall_3_1_a;
	protected AbstractElementAlias match_Import_WSTerminalRuleCall_3_2_1_a;
	protected AbstractElementAlias match_Import_WSTerminalRuleCall_5_a;
	protected AbstractElementAlias match_Media_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_Media_WSTerminalRuleCall_4_1_a;
	protected AbstractElementAlias match_Media_WSTerminalRuleCall_6_a;
	protected AbstractElementAlias match_Media_WSTerminalRuleCall_9_a;
	protected AbstractElementAlias match_Page_WSTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Page_WSTerminalRuleCall_5_a;
	protected AbstractElementAlias match_Page_WSTerminalRuleCall_9_a;
	protected AbstractElementAlias match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__a;
	protected AbstractElementAlias match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__p;
	protected AbstractElementAlias match_PseudoPage_WSTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Pseudo_WSTerminalRuleCall_1_1_2_a;
	protected AbstractElementAlias match_Pseudo_WSTerminalRuleCall_1_1_3_1_a;
	protected AbstractElementAlias match_Ruleset_WSTerminalRuleCall_1_1_a;
	protected AbstractElementAlias match_Ruleset_WSTerminalRuleCall_3_a;
	protected AbstractElementAlias match_Ruleset_WSTerminalRuleCall_7_a;
	protected AbstractElementAlias match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__a;
	protected AbstractElementAlias match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__p;
	protected AbstractElementAlias match_Selector_WSTerminalRuleCall_0_1_a;
	protected AbstractElementAlias match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__a;
	protected AbstractElementAlias match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__p;
	protected AbstractElementAlias match_Stylesheet_____CDCTerminalRuleCall_2_1_1_0_WSTerminalRuleCall_2_1_1_1_a___or___CDOTerminalRuleCall_2_1_0_0_WSTerminalRuleCall_2_1_0_1_a____a;
	protected AbstractElementAlias match_Stylesheet_____CDCTerminalRuleCall_3_1_1_0_WSTerminalRuleCall_3_1_1_1_a___or___CDOTerminalRuleCall_3_1_0_0_WSTerminalRuleCall_3_1_0_1_a____a;
	protected AbstractElementAlias match_Term_WSTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Uri_WSTerminalRuleCall_1_q;
	protected AbstractElementAlias match_Uri_WSTerminalRuleCall_3_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CSSGrammarAccess) access;
		match_AttributeValue_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getAttributeValueAccess().getWSTerminalRuleCall_1());
		match_AttributeValue_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getAttributeValueAccess().getWSTerminalRuleCall_3());
		match_Attribute_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getAttributeAccess().getWSTerminalRuleCall_1());
		match_Attribute_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getAttributeAccess().getWSTerminalRuleCall_3());
		match_Combinator_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getCombinatorAccess().getWSTerminalRuleCall_1());
		match_CompositeSelector_WSTerminalRuleCall_1_0_p = new TokenAlias(true, false, grammarAccess.getCompositeSelectorAccess().getWSTerminalRuleCall_1_0());
		match_CompositeSelector_WSTerminalRuleCall_1_1_0_a = new TokenAlias(true, true, grammarAccess.getCompositeSelectorAccess().getWSTerminalRuleCall_1_1_0());
		match_Declaration_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_1());
		match_Declaration_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_3());
		match_Declaration_WSTerminalRuleCall_5_1_a = new TokenAlias(true, true, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_5_1());
		match_Function_WSTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getFunctionAccess().getWSTerminalRuleCall_2());
		match_Import_WSTerminalRuleCall_1_0_0_a = new TokenAlias(true, true, grammarAccess.getImportAccess().getWSTerminalRuleCall_1_0_0());
		match_Import_WSTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getImportAccess().getWSTerminalRuleCall_2());
		match_Import_WSTerminalRuleCall_3_1_a = new TokenAlias(true, true, grammarAccess.getImportAccess().getWSTerminalRuleCall_3_1());
		match_Import_WSTerminalRuleCall_3_2_1_a = new TokenAlias(true, true, grammarAccess.getImportAccess().getWSTerminalRuleCall_3_2_1());
		match_Import_WSTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getImportAccess().getWSTerminalRuleCall_5());
		match_Media_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getMediaAccess().getWSTerminalRuleCall_3());
		match_Media_WSTerminalRuleCall_4_1_a = new TokenAlias(true, true, grammarAccess.getMediaAccess().getWSTerminalRuleCall_4_1());
		match_Media_WSTerminalRuleCall_6_a = new TokenAlias(true, true, grammarAccess.getMediaAccess().getWSTerminalRuleCall_6());
		match_Media_WSTerminalRuleCall_9_a = new TokenAlias(true, true, grammarAccess.getMediaAccess().getWSTerminalRuleCall_9());
		match_Page_WSTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getPageAccess().getWSTerminalRuleCall_2());
		match_Page_WSTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getPageAccess().getWSTerminalRuleCall_5());
		match_Page_WSTerminalRuleCall_9_a = new TokenAlias(true, true, grammarAccess.getPageAccess().getWSTerminalRuleCall_9());
		match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getPageAccess().getSemicolonKeyword_7_0()), new TokenAlias(true, true, grammarAccess.getPageAccess().getWSTerminalRuleCall_7_1()));
		match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getPageAccess().getSemicolonKeyword_7_0()), new TokenAlias(true, true, grammarAccess.getPageAccess().getWSTerminalRuleCall_7_1()));
		match_PseudoPage_WSTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getPseudoPageAccess().getWSTerminalRuleCall_2());
		match_Pseudo_WSTerminalRuleCall_1_1_2_a = new TokenAlias(true, true, grammarAccess.getPseudoAccess().getWSTerminalRuleCall_1_1_2());
		match_Pseudo_WSTerminalRuleCall_1_1_3_1_a = new TokenAlias(true, true, grammarAccess.getPseudoAccess().getWSTerminalRuleCall_1_1_3_1());
		match_Ruleset_WSTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_1_1());
		match_Ruleset_WSTerminalRuleCall_3_a = new TokenAlias(true, true, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_3());
		match_Ruleset_WSTerminalRuleCall_7_a = new TokenAlias(true, true, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_7());
		match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getRulesetAccess().getSemicolonKeyword_5_0()), new TokenAlias(true, true, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_5_1()));
		match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getRulesetAccess().getSemicolonKeyword_5_0()), new TokenAlias(true, true, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_5_1()));
		match_Selector_WSTerminalRuleCall_0_1_a = new TokenAlias(true, true, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_0_1());
		match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_1_2()), new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_1_1()), new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_1_0()));
		match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__p = new AlternativeAlias(true, false, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_1_2()), new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_1_1()), new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_1_0()));
		match_Stylesheet_____CDCTerminalRuleCall_2_1_1_0_WSTerminalRuleCall_2_1_1_1_a___or___CDOTerminalRuleCall_2_1_0_0_WSTerminalRuleCall_2_1_0_1_a____a = new AlternativeAlias(true, true, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_2_1_1_0()), new TokenAlias(true, true, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_2_1_1_1())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_2_1_0_0()), new TokenAlias(true, true, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_2_1_0_1())));
		match_Stylesheet_____CDCTerminalRuleCall_3_1_1_0_WSTerminalRuleCall_3_1_1_1_a___or___CDOTerminalRuleCall_3_1_0_0_WSTerminalRuleCall_3_1_0_1_a____a = new AlternativeAlias(true, true, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_3_1_1_0()), new TokenAlias(true, true, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_3_1_1_1())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_3_1_0_0()), new TokenAlias(true, true, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_3_1_0_1())));
		match_Term_WSTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getTermAccess().getWSTerminalRuleCall_1());
		match_Uri_WSTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getUriAccess().getWSTerminalRuleCall_1());
		match_Uri_WSTerminalRuleCall_3_q = new TokenAlias(false, true, grammarAccess.getUriAccess().getWSTerminalRuleCall_3());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getCDCRule())
			return getCDCToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCDORule())
			return getCDOToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getT_IMPORTANTRule())
			return getT_IMPORTANTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal CDC:
	 * 	'-->';
	 */
	protected String getCDCToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-->";
	}
	
	/**
	 * terminal CDO:
	 * 	'<!--';
	 */
	protected String getCDOToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "<!--";
	}
	
	/**
	 * terminal T_IMPORTANT:
	 * 	'!important';
	 */
	protected String getT_IMPORTANTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "!important";
	}
	
	/**
	 * terminal WS:
	 * 	(' ' | '\t' | '\r' | '\n')+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AttributeValue_WSTerminalRuleCall_1_a.equals(syntax))
				emit_AttributeValue_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AttributeValue_WSTerminalRuleCall_3_a.equals(syntax))
				emit_AttributeValue_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Attribute_WSTerminalRuleCall_1_a.equals(syntax))
				emit_Attribute_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Attribute_WSTerminalRuleCall_3_a.equals(syntax))
				emit_Attribute_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Combinator_WSTerminalRuleCall_1_a.equals(syntax))
				emit_Combinator_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeSelector_WSTerminalRuleCall_1_0_p.equals(syntax))
				emit_CompositeSelector_WSTerminalRuleCall_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeSelector_WSTerminalRuleCall_1_1_0_a.equals(syntax))
				emit_CompositeSelector_WSTerminalRuleCall_1_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Declaration_WSTerminalRuleCall_1_a.equals(syntax))
				emit_Declaration_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Declaration_WSTerminalRuleCall_3_a.equals(syntax))
				emit_Declaration_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Declaration_WSTerminalRuleCall_5_1_a.equals(syntax))
				emit_Declaration_WSTerminalRuleCall_5_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Function_WSTerminalRuleCall_2_a.equals(syntax))
				emit_Function_WSTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Import_WSTerminalRuleCall_1_0_0_a.equals(syntax))
				emit_Import_WSTerminalRuleCall_1_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Import_WSTerminalRuleCall_2_a.equals(syntax))
				emit_Import_WSTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Import_WSTerminalRuleCall_3_1_a.equals(syntax))
				emit_Import_WSTerminalRuleCall_3_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Import_WSTerminalRuleCall_3_2_1_a.equals(syntax))
				emit_Import_WSTerminalRuleCall_3_2_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Import_WSTerminalRuleCall_5_a.equals(syntax))
				emit_Import_WSTerminalRuleCall_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Media_WSTerminalRuleCall_3_a.equals(syntax))
				emit_Media_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Media_WSTerminalRuleCall_4_1_a.equals(syntax))
				emit_Media_WSTerminalRuleCall_4_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Media_WSTerminalRuleCall_6_a.equals(syntax))
				emit_Media_WSTerminalRuleCall_6_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Media_WSTerminalRuleCall_9_a.equals(syntax))
				emit_Media_WSTerminalRuleCall_9_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Page_WSTerminalRuleCall_2_a.equals(syntax))
				emit_Page_WSTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Page_WSTerminalRuleCall_5_a.equals(syntax))
				emit_Page_WSTerminalRuleCall_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Page_WSTerminalRuleCall_9_a.equals(syntax))
				emit_Page_WSTerminalRuleCall_9_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__a.equals(syntax))
				emit_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__p.equals(syntax))
				emit_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PseudoPage_WSTerminalRuleCall_2_a.equals(syntax))
				emit_PseudoPage_WSTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Pseudo_WSTerminalRuleCall_1_1_2_a.equals(syntax))
				emit_Pseudo_WSTerminalRuleCall_1_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Pseudo_WSTerminalRuleCall_1_1_3_1_a.equals(syntax))
				emit_Pseudo_WSTerminalRuleCall_1_1_3_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ruleset_WSTerminalRuleCall_1_1_a.equals(syntax))
				emit_Ruleset_WSTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ruleset_WSTerminalRuleCall_3_a.equals(syntax))
				emit_Ruleset_WSTerminalRuleCall_3_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ruleset_WSTerminalRuleCall_7_a.equals(syntax))
				emit_Ruleset_WSTerminalRuleCall_7_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__a.equals(syntax))
				emit_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__p.equals(syntax))
				emit_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Selector_WSTerminalRuleCall_0_1_a.equals(syntax))
				emit_Selector_WSTerminalRuleCall_0_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__a.equals(syntax))
				emit_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__p.equals(syntax))
				emit_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Stylesheet_____CDCTerminalRuleCall_2_1_1_0_WSTerminalRuleCall_2_1_1_1_a___or___CDOTerminalRuleCall_2_1_0_0_WSTerminalRuleCall_2_1_0_1_a____a.equals(syntax))
				emit_Stylesheet_____CDCTerminalRuleCall_2_1_1_0_WSTerminalRuleCall_2_1_1_1_a___or___CDOTerminalRuleCall_2_1_0_0_WSTerminalRuleCall_2_1_0_1_a____a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Stylesheet_____CDCTerminalRuleCall_3_1_1_0_WSTerminalRuleCall_3_1_1_1_a___or___CDOTerminalRuleCall_3_1_0_0_WSTerminalRuleCall_3_1_0_1_a____a.equals(syntax))
				emit_Stylesheet_____CDCTerminalRuleCall_3_1_1_0_WSTerminalRuleCall_3_1_1_1_a___or___CDOTerminalRuleCall_3_1_0_0_WSTerminalRuleCall_3_1_0_1_a____a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Term_WSTerminalRuleCall_1_a.equals(syntax))
				emit_Term_WSTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Uri_WSTerminalRuleCall_1_q.equals(syntax))
				emit_Uri_WSTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Uri_WSTerminalRuleCall_3_q.equals(syntax))
				emit_Uri_WSTerminalRuleCall_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_AttributeValue_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_AttributeValue_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Attribute_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Attribute_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Combinator_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS+
	 */
	protected void emit_CompositeSelector_WSTerminalRuleCall_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_CompositeSelector_WSTerminalRuleCall_1_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Declaration_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Declaration_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Declaration_WSTerminalRuleCall_5_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Function_WSTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Import_WSTerminalRuleCall_1_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Import_WSTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Import_WSTerminalRuleCall_3_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Import_WSTerminalRuleCall_3_2_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Import_WSTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Media_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Media_WSTerminalRuleCall_4_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Media_WSTerminalRuleCall_6_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Media_WSTerminalRuleCall_9_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Page_WSTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Page_WSTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Page_WSTerminalRuleCall_9_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (';' WS*)*
	 */
	protected void emit_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (';' WS*)+
	 */
	protected void emit_Page___SemicolonKeyword_7_0_WSTerminalRuleCall_7_1_a__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_PseudoPage_WSTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Pseudo_WSTerminalRuleCall_1_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Pseudo_WSTerminalRuleCall_1_1_3_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Ruleset_WSTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Ruleset_WSTerminalRuleCall_3_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Ruleset_WSTerminalRuleCall_7_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (';' WS*)*
	 */
	protected void emit_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (';' WS*)+
	 */
	protected void emit_Ruleset___SemicolonKeyword_5_0_WSTerminalRuleCall_5_1_a__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Selector_WSTerminalRuleCall_0_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (WS | CDC | CDO)*
	 */
	protected void emit_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (WS | CDC | CDO)+
	 */
	protected void emit_Stylesheet___CDCTerminalRuleCall_1_2_or_CDOTerminalRuleCall_1_1_or_WSTerminalRuleCall_1_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ((CDC WS*) | (CDO WS*))*
	 */
	protected void emit_Stylesheet_____CDCTerminalRuleCall_2_1_1_0_WSTerminalRuleCall_2_1_1_1_a___or___CDOTerminalRuleCall_2_1_0_0_WSTerminalRuleCall_2_1_0_1_a____a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ((CDO WS*) | (CDC WS*))*
	 */
	protected void emit_Stylesheet_____CDCTerminalRuleCall_3_1_1_0_WSTerminalRuleCall_3_1_1_1_a___or___CDOTerminalRuleCall_3_1_0_0_WSTerminalRuleCall_3_1_0_1_a____a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS*
	 */
	protected void emit_Term_WSTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS?
	 */
	protected void emit_Uri_WSTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     WS?
	 */
	protected void emit_Uri_WSTerminalRuleCall_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
