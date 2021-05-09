package pl.coderslab.spring01hibernatekrkw07;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import pl.coderslab.spring01hibernatekrkw07.converter.PublisherConverterTest;
import pl.coderslab.spring01hibernatekrkw07.converter.SimpleSampleTest;

@RunWith(Suite.class)
@SuiteClasses({SimpleSampleTest.class, PublisherConverterTest.class})
public class AllTests {
}