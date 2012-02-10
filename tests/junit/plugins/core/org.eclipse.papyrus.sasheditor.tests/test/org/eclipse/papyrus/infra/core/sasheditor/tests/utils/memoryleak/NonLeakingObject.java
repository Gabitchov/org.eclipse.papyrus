package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.memoryleak;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * For testing purpose
 * @copyright http://www.forkcan.com/viewcode/215/Detecting-memory-leak-in-unit-test
 *
 */
public class NonLeakingObject {

  static Map<NonLeakingObject, Object> leakingMap = new WeakHashMap<NonLeakingObject, Object>();

  public NonLeakingObject() {
    leakingMap.put(this, System.currentTimeMillis());
  }

}