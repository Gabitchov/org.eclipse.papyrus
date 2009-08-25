package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

public class SlotParser implements IParser {

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
			final Slot slot = ((Slot) ((EObjectAdapter) element).getRealObject());
			if (slot.getDefiningFeature() == null) {
				return "<UNDEFINED>";
			}
			String result = slot.getDefiningFeature().getName();
			if (slot.getValues().isEmpty()) {
				return result;
			} else {
				result = result + ": ";
				Iterator<ValueSpecification> iter = slot.getValues().iterator();
				while (iter.hasNext()) {
					ValueSpecification currentSpecification = iter.next();
					if (currentSpecification instanceof InstanceValue) {
						result = result + ((InstanceValue) currentSpecification).getInstance().getName() + ", ";
					} else {
						result = result + currentSpecification.stringValue() + ", ";
					}
				}
				result = result.substring(0, result.length() - 2);
				return result;
			}
		}
		return "<UNDEFINED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

}
