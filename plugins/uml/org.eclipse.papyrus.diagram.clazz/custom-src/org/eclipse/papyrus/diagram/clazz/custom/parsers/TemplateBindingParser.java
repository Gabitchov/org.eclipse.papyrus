package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;


public class TemplateBindingParser implements IParser {

	private static final String arrow = String.valueOf("\u0510");
	final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	
	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		String out="";
		if(element instanceof EObjectAdapter) {
			final TemplateBinding binding = ((TemplateBinding)((EObjectAdapter)element).getRealObject());
			Iterator<TemplateParameterSubstitution> bindIter= binding.getParameterSubstitutions().iterator();
			while(bindIter.hasNext()){
				TemplateParameterSubstitution substitution=bindIter.next();
				if(substitution.getFormal().getParameteredElement() instanceof NamedElement){
				out=out+ ((NamedElement)substitution.getFormal().getParameteredElement()).getName();
				}
				if(substitution.getActual() instanceof NamedElement){
					out=out+" -> "+ ((NamedElement)substitution.getActual()).getName()+"\n";
					}
			}
		}
		
		return out;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

}
