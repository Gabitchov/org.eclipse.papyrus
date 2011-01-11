package org.eclipse.papyrus.diagram.common.navigation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.navigation.IBaseNameSetter;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;


public class UMLBaseNameSetter implements IBaseNameSetter {
	
	public static final UMLBaseNameSetter instance = new UMLBaseNameSetter();
	
	private UMLBaseNameSetter() {
	}

	public void setBaseName(String base, EObject toName) {
		if (toName instanceof NamedElement) {
			NamedElement namedElement = (NamedElement)toName;

			List<EObject> contents;
			if (namedElement.eContainer() != null) {
				contents = namedElement.eContainer().eContents();
			} else {
				contents = Collections.EMPTY_LIST;
			}
			namedElement.setName(NamedElementUtil.getDefaultNameWithIncrementFromBase(base + toName.eClass().getName(), contents));
		}
	}

}
