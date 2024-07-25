package com.beuben.pokemontcgcollectorbackend.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ImplementOnlyInterfaceFromPackageCondition extends ArchCondition<JavaClass> {
  private final String packageName;

  public ImplementOnlyInterfaceFromPackageCondition(final String packageName) {
    super("Implement only interfaces from package " + packageName);
    this.packageName = packageName;
  }

  public static ImplementOnlyInterfaceFromPackageCondition implementOnlyInterfaceFromPackage(final String packageName) {
    return new ImplementOnlyInterfaceFromPackageCondition(packageName);
  }

  @Override
  public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
    javaClass.getAllRawInterfaces().stream()
        .filter(iface -> !iface.getPackageName().contains(packageName))
        .forEach(iface -> {
          var message = String.format("Class %s implements interface %s, which is not in package %s",
              javaClass.getName(), iface.getName(), packageName);
          conditionEvents.add(SimpleConditionEvent.violated(javaClass, message));
        });
  }
}
