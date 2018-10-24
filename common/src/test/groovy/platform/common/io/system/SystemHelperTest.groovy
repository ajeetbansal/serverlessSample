package platform.common.io.system

import org.glassfish.hk2.api.ServiceLocator
import org.glassfish.hk2.utilities.ServiceLocatorUtilities
import org.glassfish.hk2.utilities.binding.AbstractBinder
import platform.common.CommonConfigProperty
import spock.lang.Specification

class SystemHelperTest extends Specification {
    def "ReadConfigurationProperty"() {
        setup:
        ServiceLocator serviceLocator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
        ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {
            @Override
            protected void configure() {
                bind(SystemHelper.class).to(SystemHelper.class);
            }
        });
        SystemHelper systemHelper = serviceLocator.getService(SystemHelper.class);
        when:
        Optional<String> property = systemHelper.readConfigurationProperty(CommonConfigProperty.SERVICE_DESCRIPTION)

        then:
        !property.isPresent()
    }
}
