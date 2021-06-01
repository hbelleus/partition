package net.adneom.hr.partition;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ PartitionServiceImplTest.class, PartitionServiceOptimizationImplTest.class })
public class PartitionImplementationTestSuite {

}
