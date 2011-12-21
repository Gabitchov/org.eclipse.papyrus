package org.eclipse.papyrus.infra.constraints.constraints;


public interface JavaQuery {

	public boolean match(Object selection);

	public class FalseQuery implements JavaQuery {

		public FalseQuery() {
		}

		public boolean match(Object selection) {
			return false;
		}
	}
}
