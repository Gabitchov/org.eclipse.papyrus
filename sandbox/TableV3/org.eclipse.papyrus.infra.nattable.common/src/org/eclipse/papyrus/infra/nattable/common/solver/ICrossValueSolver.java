package org.eclipse.papyrus.infra.nattable.common.solver;


public interface ICrossValueSolver {

	public static final String NOT_AVALAIBLE = "N/A";

	public boolean handles(final Object obj1, final Object obj2);

	public Object getValue(final Object obj1, final Object obj2);

}
