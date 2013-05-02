package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.qompass.designer.core.StUtils;

public class UpdateUtils {

	public static EList<Element> getDerivedElements(Package pkg, NamedElement source) {
		EList<Element> list = new BasicEList<Element>();
		Iterator<NamedElement> members = pkg.getOwnedMembers().iterator();
		while(members.hasNext()) {
			NamedElement member = members.next();
			if(getSource(member) == source) {
				list.add(member);
			}
			if(member instanceof Package) {
				EList<Element> subList = getDerivedElements((Package)member, source);
				list.addAll(subList);
			}
		}
		return list;
	}

	public static Element getDerivedElement(EList<? extends Element> list, Element source) {
		Iterator<? extends Element> elements = list.iterator();
		while(elements.hasNext()) {
			Element element = elements.next();
			if(StUtils.isApplied(element, DerivedElement.class)) {
				DerivedElement de = StUtils.getApplication(element, DerivedElement.class);
				if((de != null) && (de.getSource() == source)) {
					return element;
				}
			}
		}
		return null;
	}

	public static void setSource(Element derivedElement, Element source) {
		DerivedElement de = StUtils.applyApp(derivedElement, DerivedElement.class);
		de.setSource(source);
	}

	public static Element getSource(Element element) {
		if(StUtils.isApplied(element, DerivedElement.class)) {
			DerivedElement de = StUtils.getApplication(element, DerivedElement.class);
			if(de != null) {
				return de.getSource();
			}
		}
		return null;
	}
}
