package org.eclipse.papyrus.infra.gmfdiag.ui.color;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;


public class CSSSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	private final Map<String, String> ruleNameToID = new HashMap<String, String>();

	private final Set<String> fontNames = new HashSet<String>();

	public CSSSemanticHighlightingCalculator() {
		ruleNameToID.put("CSSId", CSSHighlightingConfiguration.CSS_ID);
		ruleNameToID.put("Class", CSSHighlightingConfiguration.CSS_CLASS);
		ruleNameToID.put("Attribute", CSSHighlightingConfiguration.ATTRIBUTE);

		ruleNameToID.put("Selector", CSSHighlightingConfiguration.SELECTOR);
		ruleNameToID.put("Combinator", CSSHighlightingConfiguration.SELECTOR);

		ruleNameToID.put("Declaration", CSSHighlightingConfiguration.PROPERTY);
		ruleNameToID.put("Function", CSSHighlightingConfiguration.FUNCTION);

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

		//Available fonts

		FontData[] fontData = Display.getCurrent().getFontList(null, true);
		for(FontData data : fontData) {
			fontNames.add(data.getName().toLowerCase());
		}
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

				String stringOrNameValue = null;

				if("Name".equals(name)) { //TODO: Strings should also be taken into account
					//Check the known elements (fonts, colors, ...)
					stringOrNameValue = node.getText();
				} else if("StringValue".equals(name)) {
					stringOrNameValue = node.getText();
					stringOrNameValue = stringOrNameValue.substring(1, stringOrNameValue.length() - 1);
				}

				if(stringOrNameValue != null) {
					if(isFont(stringOrNameValue)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), CSSHighlightingConfiguration.FONT);
						continue;
					} else if(isColor(stringOrNameValue)) {
						acceptor.addPosition(node.getOffset(), node.getLength(), CSSHighlightingConfiguration.COLOR);
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
		return fontNames.contains(value.toLowerCase());
	}

	public boolean isColor(String value) {
		return CSS2ColorHelper.isColorName(value.toLowerCase());
	}
}
