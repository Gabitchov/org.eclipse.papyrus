package org.eclipse.papyrus.uml.nattable.common.solver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.solver.ICrossValueSolver;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

//FIXME : move this class to remove UML dependency
public class StereotypePropertyValueSolver implements ICrossValueSolver {

	public static final String STEREOTYPE_PREFIX = "property_of_stereotype:/";

	public boolean handles(final Object obj1, final Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	public Object getValue(final Object obj1, final Object obj2) {
		final List<Object> elements = organizeObject(obj1, obj2);
		final Element el = (Element)elements.get(0);
		final Property prop = (Property)elements.get(1);
		final String propertyName = prop.getName();

		final String stereotypeQN = ((Stereotype)prop.eContainer()).getQualifiedName();
		final Stereotype ste = el.getAppliedStereotype(stereotypeQN);
		if(ste != null) {
			return el.getValue(ste, propertyName);
		}
		return NOT_AVALAIBLE;
	}

	/**
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected List<Object> organizeObject(final Object obj1, final Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		//		String str = null;
		if(obj1 instanceof Element && obj2 instanceof Property) {
			if(((EObject)obj2).eContainer() instanceof Stereotype) {
				objects.add(obj1);
				objects.add(obj2);
				//				str = (String)obj2;
			}
		} else if(obj2 instanceof Element && obj1 instanceof Property) {
			if(((EObject)obj1).eContainer() instanceof Stereotype) {
			objects.add(obj2);
			objects.add(obj1);
				//			str = (String)obj1;
			}
		}
		//		if(str == null || str.startsWith(STEREOTYPE_PREFIX)) {
		//			return Collections.emptyList();
		//		}
		return objects;
	}
}
