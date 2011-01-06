package org.eclipse.papyrus.uml.modelexplorer.queries;

import java.util.List;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/** get the name + the list of applied stereotypes */
public class GetComplexName implements IJavaModelQuery<NamedElement, String> {
	/** left Stereotype delimiters ('Guillemets francais'). */
	public static String ST_LEFT = String.valueOf("\u00AB");

	/** Right Stereotype delimiters ('Guillemets francais'). */
	public static String ST_RIGHT = String.valueOf("\u00BB");

	public String evaluate(final NamedElement context,
			final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// TODO Auto-generated method stub
		String txt = "";
		List<Stereotype> stereoList = context.getAppliedStereotypes();
		if (stereoList.size() == 0) {
			return context.getName();
		} else {
			for (int i = 0; i < stereoList.size(); i++) {
				txt = txt + stereoList.get(i).getName();
				if (i < stereoList.size() - 1) {
					txt = txt + ", ";
				}
			}
			txt = ST_LEFT + txt + ST_RIGHT + " " + context.getName();
			return txt;
		}
	}
}
