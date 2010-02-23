package org.eclipse.papyrus.diagram.composite.custom.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

public class MultiplicityFormatParser implements IParser {

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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	//	private static final MessageFormat MULTIPLICITY = new MessageFormat("[{0}..{1}]"); //$NON-NLS-1$
	//
	// public boolean areSemanticElementsAffected(EObject listener, Object notification) {
	// if (notification instanceof Notification) {
	// Object feature = ((Notification) notification).getFeature();
	// if (feature instanceof EStructuralFeature) {
	// EStructuralFeature featureImpl = (EStructuralFeature) feature;
	// return featureImpl.getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
	// }
	// }
	// return false;
	// }
	//
	// public List<?> getSemanticElementsBeingParsed(EObject eObject) {
	// Connector element = (Connector) eObject;
	//
	// List<EObject> result = new LinkedList<EObject>();
	// result.add(element.getEnds());
	//
	// return result;
	// }
	//
	// public IContentAssistProcessor getCompletionProcessor(IAdaptable subject) {
	// Element element = doAdapt(subject);
	// List<Stereotype> remaining = new LinkedList<Stereotype>();
	// remaining.addAll(element.getApplicableStereotypes());
	// remaining.removeAll(element.getAppliedStereotypes());
	//
	// List<String> names = new LinkedList<String>();
	// for (Stereotype next : remaining) {
	// names.add(next.getName());
	// }
	// return new FixedSetCompletionProcessor(names);
	// }
	//
	// public String getEditString(IAdaptable element, int flags) {
	// Element subject = doAdapt(element);
	// List<Stereotype> stereos = subject.getAppliedStereotypes();
	// if (stereos.isEmpty()) {
	//			return ""; //$NON-NLS-1$
	// }
	// StringBuffer result = new StringBuffer();
	// for (Stereotype next : stereos) {
	// if (result.length() > 0) {
	//				result.append(", "); //$NON-NLS-1$
	// }
	// result.append(next.getName());
	// }
	// return result.toString();
	// }
	//
	// public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
	// return UnexecutableCommand.INSTANCE;
	// }
	//
	// public String getPrintString(IAdaptable element, int flags) {
	// String editString = getEditString(element, flags);
	// return editString == null || editString.length() == 0 ? editString : MULTIPLICITY
	// .format(new Object[] { editString });
	// }
	//
	// public boolean isAffectingEvent(Object event, int flags) {
	// return false;
	// }
	//
	// public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
	// return ParserEditStatus.UNEDITABLE_STATUS;
	// }
	//
	// private Element doAdapt(IAdaptable adaptable) {
	// Element element = (Element) adaptable.getAdapter(EObject.class);
	// return element;
	// }
}
