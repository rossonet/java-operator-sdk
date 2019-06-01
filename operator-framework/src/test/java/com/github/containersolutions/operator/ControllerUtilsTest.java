package com.github.containersolutions.operator;

import com.github.containersolutions.operator.sample.TestCustomResource;
import com.github.containersolutions.operator.sample.TestResourceController;
import org.junit.jupiter.api.Test;

import static com.github.containersolutions.operator.api.Controller.DEFAULT_FINALIZER;
import static com.github.containersolutions.operator.api.Controller.DEFAULT_VERSION;
import static com.github.containersolutions.operator.sample.TestResourceController.TEST_GROUP;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerUtilsTest {

    @Test
    public void returnsValuesFromControllerAnnotationFinalizer() {
        assertEquals(DEFAULT_FINALIZER, ControllerUtils.getDefaultFinalizer(new TestResourceController()));
        assertEquals(TEST_GROUP + "/" + DEFAULT_VERSION, ControllerUtils.getApiVersion(new TestResourceController()));
        assertEquals(DEFAULT_VERSION, ControllerUtils.getVersion(new TestResourceController()));
        assertEquals(TestResourceController.KIND_NAME, ControllerUtils.getKind(new TestResourceController()));
        assertEquals(TestCustomResource.class, ControllerUtils.getCustomResourceClass(new TestResourceController()));
    }

}