package runner.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.in.Facebook;

@RunWith(Suite.class)
@SuiteClasses({test.in.SecondProgram.class,test.in.ShopMobilePhone.class, Facebook .class})
public class TestRunner {

}