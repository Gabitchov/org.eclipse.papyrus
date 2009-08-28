package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;

public class ClassifierTemplateParameterParser implements IParser {

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {
			final ClassifierTemplateParameter templateParam = ((ClassifierTemplateParameter) ((EObjectAdapter) element)
					.getRealObject());
			if (templateParam.getOwnedParameteredElement() == null) {
				return "<UNDEFINED>";
			}
			String out = "";
			if (templateParam.getOwnedParameteredElement() instanceof Classifier) {
				Classifier namedElement = (Classifier) templateParam.getOwnedParameteredElement();
				out = out + namedElement.getName() + ": " + namedElement.eClass().getName();
			}
			if (!templateParam.getConstrainingClassifiers().isEmpty()) {
				out = out + ">";
				for (int i = 0; i < templateParam.getConstrainingClassifiers().size(); i++) {
					out = out + templateParam.getConstrainingClassifiers().get(i).getName();
					if (i < templateParam.getConstrainingClassifiers().size() - 1) {
						out = out + ", ";
					}
				}

			}
			return out;

		}

		return "<UNDEFINED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

}
