package org.eclipse.papyrus.properties.constraints;

import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.constraints.JavaQuery.FalseQuery;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;

/**
 * This constraint allows to define a Java Query (without parameters) without
 * defining it in an environment file.
 * 
 * The constraint takes one parameter ("className"), which defines the
 * qualified name of the Java class used to implement the constraint.
 * 
 * The Java class must implement the {@link JavaQuery} interface
 * 
 * @author Camille Letavernier
 */
public class JavaQueryConstraint extends AbstractConstraint {

	public final static String QUERY_CLASS_NAME_PROPERTY = "className"; //$NON-NLS-1$

	private JavaQuery query = new FalseQuery();

	protected void setDescriptor(ConstraintDescriptor descriptor) {
		String queryClassName = getValue(QUERY_CLASS_NAME_PROPERTY);
		if(queryClassName != null) {
			try {
				Class<? extends JavaQuery> queryClass = Class.forName(queryClassName).asSubclass(JavaQuery.class);
				query = queryClass.newInstance();
			} catch (ClassNotFoundException ex) {
				Activator.log.error(ex);
			} catch (InstantiationException ex) {
				Activator.log.error(ex);
			} catch (IllegalAccessException ex) {
				Activator.log.error(ex);
			}
		}
	}

	public boolean match(Object selection) {
		return query.match(selection);
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint instanceof JavaQueryConstraint) {
			return ((JavaQueryConstraint)constraint).query.getClass().equals(query.getClass());
		}
		return false;
	}


}
