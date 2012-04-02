package org.eclipse.papyrus.infra.gmfdiag.ui.color;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;


public class CSSSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	private final Map<String, String> ruleNameToID = new HashMap<String, String>();

	public CSSSemanticHighlightingCalculator() {
		ruleNameToID.put("CSSId", CSSHighlightingConfiguration.CSS_ID);
		ruleNameToID.put("Class", CSSHighlightingConfiguration.CSS_CLASS);
		ruleNameToID.put("Attribute", CSSHighlightingConfiguration.ATTRIBUTE);

		ruleNameToID.put("Selector", CSSHighlightingConfiguration.SELECTOR);
		ruleNameToID.put("Combinator", CSSHighlightingConfiguration.SELECTOR);

		ruleNameToID.put("Declaration", CSSHighlightingConfiguration.PROPERTY);

		//Values

		ruleNameToID.put("Name", CSSHighlightingConfiguration.STRING_ID);
		ruleNameToID.put("StringValue", CSSHighlightingConfiguration.STRING_ID);
		ruleNameToID.put("Uri", CSSHighlightingConfiguration.STRING_ID);

		ruleNameToID.put("HexColor", CSSHighlightingConfiguration.HEX_COLOR);

		ruleNameToID.put("Length", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Percentage", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Frequency", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Ems", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Exs", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Angle", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Time", CSSHighlightingConfiguration.NUMBER_ID);
		ruleNameToID.put("Number", CSSHighlightingConfiguration.NUMBER_ID);
	}

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if(resource == null || resource.getParseResult() == null) {
			return;
		}

		INode root = resource.getParseResult().getRootNode();
		for(INode node : root.getAsTreeIterable()) {
			if(node.getGrammarElement() instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall)node.getGrammarElement();
				String name = ruleCall.getRule().getName();
				if("Name".equals(name)) {
					//Check the known elements (fonts, colors, ...)
					String value = ""; //TODO
					if(isFont(value)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), CSSHighlightingConfiguration.COLOR);
						continue;
					} else if(isColor(value)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), CSSHighlightingConfiguration.FONT);
						continue;
					}
				}

				if(ruleNameToID.containsKey(name)) {
					acceptor.addPosition(node.getOffset(), node.getLength(), ruleNameToID.get(name));
				}
			}
		}
	}

	public boolean isFont(String value) {
		return false; //TODO
	}

	public boolean isColor(String value) {
		return false; //TODO
	}
}
