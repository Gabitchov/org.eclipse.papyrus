package org.eclipse.papyrus.texteditor.cdt.sync;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.IFunctionDeclaration;
import org.eclipse.cdt.core.model.IParent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

public class ObtainICElement {
	/**
	 * Return the ICelement associated with a UML element. Currently, only methods are supported.
	 * @param parent the parent (typically the translation unit of a CDT file)  
	 * @param element A named UML element
	 * @throws CoreException
	 */
	public static ICElement getICElement(IParent parent, NamedElement element) {
		try {	
			for(ICElement child : parent.getChildren()) {
				if(child instanceof IParent) {
					getICElement((IParent)child, element);
				}
				if(child instanceof IFunctionDeclaration) {
					// IFunctionDeclaration function = (IFunctionDeclaration) child;
					
					if (element instanceof Operation) {						
						if (child.getElementName().endsWith("::" + element.getName())) {
							return child;
						}
					}
				}
			}
		}
		catch (CoreException e) {
		}
		return null;
	}

}
