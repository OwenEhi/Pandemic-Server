/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 37 "model.ump"
// line 83 "model.ump"
public class TestType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestType Attributes
  private String manufacturer;
  private String testName;
  private String testVersion;
  private String testTarget;

  //TestType Associations
  private List<Test> tests;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestType(String aManufacturer, String aTestName, String aTestVersion, String aTestTarget)
  {
    manufacturer = aManufacturer;
    testName = aTestName;
    testVersion = aTestVersion;
    testTarget = aTestTarget;
    tests = new ArrayList<Test>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setManufacturer(String aManufacturer)
  {
    boolean wasSet = false;
    manufacturer = aManufacturer;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestName(String aTestName)
  {
    boolean wasSet = false;
    testName = aTestName;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestVersion(String aTestVersion)
  {
    boolean wasSet = false;
    testVersion = aTestVersion;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestTarget(String aTestTarget)
  {
    boolean wasSet = false;
    testTarget = aTestTarget;
    wasSet = true;
    return wasSet;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public String getTestName()
  {
    return testName;
  }

  public String getTestVersion()
  {
    return testVersion;
  }

  public String getTestTarget()
  {
    return testTarget;
  }
  /* Code from template association_GetMany */
  public Test getTest(int index)
  {
    Test aTest = tests.get(index);
    return aTest;
  }

  public List<Test> getTests()
  {
    List<Test> newTests = Collections.unmodifiableList(tests);
    return newTests;
  }

  public int numberOfTests()
  {
    int number = tests.size();
    return number;
  }

  public boolean hasTests()
  {
    boolean has = tests.size() > 0;
    return has;
  }

  public int indexOfTest(Test aTest)
  {
    int index = tests.indexOf(aTest);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTestsValid()
  {
    boolean isValid = numberOfTests() >= minimumNumberOfTests();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTests()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Test addTest(Date aDate, Time aTime, String aLocation, String aTestLab, Date aProcessingDate, boolean aOutcome, TestLocation aTestLocation, Patient aPatient)
  {
    Test aNewTest = new Test(aDate, aTime, aLocation, aTestLab, aProcessingDate, aOutcome, aTestLocation, aPatient, this);
    return aNewTest;
  }

  public boolean addTest(Test aTest)
  {
    boolean wasAdded = false;
    if (tests.contains(aTest)) { return false; }
    TestType existingTestType = aTest.getTestType();
    boolean isNewTestType = existingTestType != null && !this.equals(existingTestType);

    if (isNewTestType && existingTestType.numberOfTests() <= minimumNumberOfTests())
    {
      return wasAdded;
    }
    if (isNewTestType)
    {
      aTest.setTestType(this);
    }
    else
    {
      tests.add(aTest);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTest(Test aTest)
  {
    boolean wasRemoved = false;
    //Unable to remove aTest, as it must always have a testType
    if (this.equals(aTest.getTestType()))
    {
      return wasRemoved;
    }

    //testType already at minimum (1)
    if (numberOfTests() <= minimumNumberOfTests())
    {
      return wasRemoved;
    }

    tests.remove(aTest);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestAt(Test aTest, int index)
  {  
    boolean wasAdded = false;
    if(addTest(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestAt(Test aTest, int index)
  {
    boolean wasAdded = false;
    if(tests.contains(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestAt(aTest, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=tests.size(); i > 0; i--)
    {
      Test aTest = tests.get(i - 1);
      aTest.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "manufacturer" + ":" + getManufacturer()+ "," +
            "testName" + ":" + getTestName()+ "," +
            "testVersion" + ":" + getTestVersion()+ "," +
            "testTarget" + ":" + getTestTarget()+ "]";
  }
}