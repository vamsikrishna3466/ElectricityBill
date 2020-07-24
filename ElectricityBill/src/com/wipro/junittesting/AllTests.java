package com.wipro.junittesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GenerateBillTesting.class, TestingBillAmount.class, ValidationTesting.class })
public class AllTests {

}
