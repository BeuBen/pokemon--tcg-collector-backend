package com.beuben.pokemontcgcollectorbackend.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class HaveAssociatedTestClassCondition extends ArchCondition<JavaClass> {
  public HaveAssociatedTestClassCondition() {
    super("Have an associated test class");
  }

  public static HaveAssociatedTestClassCondition haveAssociatedTestClass() {
    return new HaveAssociatedTestClassCondition();
  }

  @Override
  public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
    final var className = javaClass.getSimpleName();
    final var expectedTestClassName = className + "Test";
    final var fullTestClassName = javaClass.getPackageName() + "." + expectedTestClassName;

    try {
      Class.forName(fullTestClassName);
    } catch (ClassNotFoundException e) {
      final var message = String.format("Class %s does not have an associated test class named %s",
          javaClass.getName(), fullTestClassName);
      conditionEvents.add(SimpleConditionEvent.violated(javaClass, message));
    }
  }
}
