package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ExecutionSpecification;


public class LifelineModelChildrenHelper {

	/**
	 * Try to fixed the bug about display ExecutionSpecifications(ES).
	 * 
	 * At some times, the child ES would be displayed under the parent ES.
	 * 
	 * Fixed to sort them with bounds in model before creating.
	 */
	public static List<View> getModelChildren(View lifeline) {
		if(lifeline == null) {
			return Collections.emptyList();
		}
		@SuppressWarnings("unchecked")
		List<View> children = new ArrayList<View>(lifeline.getVisibleChildren());
		sortChildren(children);
		return children;
	}

	private static void sortChildren(List<View> children) {
		Collections.sort(children, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				if(!(o1 instanceof View && o2 instanceof View)) {
					return 0;
				}
				View v1 = (View)o1;
				View v2 = (View)o2;
				EObject e1 = ViewUtil.resolveSemanticElement(v1);
				EObject e2 = ViewUtil.resolveSemanticElement(v2);
				if(!(e1 instanceof ExecutionSpecification && e2 instanceof ExecutionSpecification)) {
					return 0;
				}
				Rectangle r1 = getViewBounds(v1);
				Rectangle r2 = getViewBounds(v2);
				if(r1 == null || r2 == null) {
					return 0;
				}
				if(r1.width <= 0) {
					r1.width = 16;
				}
				if(r2.width <= 0) {
					r2.width = 16;
				}

				if((r1.x < r2.x) || r1.right() < r2.right()) {
					return -1;
				}
				return 1;
			}
		});
	}

	private static Rectangle getViewBounds(View view) {
		if(view == null) {
			return null;
		}
		Integer x = getFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X());
		Integer y = getFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y());
		Integer width = getFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width());
		Integer height = getFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height());
		if(x == null && y == null && width == null && height == null) {
			return null;
		}
		return new Rectangle(x == null ? 0 : x.intValue(), y == null ? 0 : y.intValue(), width == null ? -1 : width.intValue(), height == null ? -1 : height.intValue());
	}

	private static Integer getFeatureValue(View view, EStructuralFeature feature) {
		if(view == null || feature == null) {
			return null;
		}
		return (Integer)ViewUtil.getPropertyValue(view, feature, feature.getEContainingClass());
	}
}
