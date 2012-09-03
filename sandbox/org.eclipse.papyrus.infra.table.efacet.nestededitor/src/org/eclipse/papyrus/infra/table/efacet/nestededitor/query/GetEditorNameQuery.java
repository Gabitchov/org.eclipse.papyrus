package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.Activator;


public class GetEditorNameQuery extends AbstractNestedEditorQuery<String> {

	private static List<String> possibleNameFieldName = null;

	public String evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {



		String editorName = null;
		if(source instanceof PapyrusTable) {
			editorName = ((PapyrusTable)source).getName();
		} else {
			if(possibleNameFieldName == null) {
				initContextFieldName();
			}
			final Iterator<String> iter = possibleNameFieldName.iterator();
			Field contextField = null;
			while(iter.hasNext() && contextField == null) {
				final String currentName = iter.next();
				try {
					contextField = source.getClass().getDeclaredField(currentName);
				} catch (SecurityException e) {
					Activator.log.error(e);
				} catch (NoSuchFieldException e) {
					Activator.log.error(e);
				}
			}
			if(contextField != null) {
				boolean oldAccessibilityValue = contextField.isAccessible();
				contextField.setAccessible(true);
				Object tmp = null;
				try {
					tmp = contextField.get(source);
				} catch (IllegalArgumentException e) {
					Activator.log.error(e);
				} catch (IllegalAccessException e) {
					Activator.log.error(e);
				}
				if(tmp instanceof String) {
					editorName = (String)tmp;
				}
				contextField.setAccessible(oldAccessibilityValue);
			}
		}
		return editorName;
	}


	private static final void initContextFieldName() {
		possibleNameFieldName = new ArrayList<String>();
		possibleNameFieldName.add("name"); //$NON-NLS-1$
	}

}
