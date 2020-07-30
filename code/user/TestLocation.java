/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 23 "model.ump"
// line 73 "model.ump"
public class TestLocation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestLocation Attributes
  private String name;
  private String type;
  private String address;

  //TestLocation Associations
  private List<Test> tests;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestLocation(String aName, String aType, String aAddress)
  {
    name = aName;
    type = aType;
    address = aAddress;
    tests = new ArrayList<Test>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public String getAddress()
  {
    return address;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTests()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Test addTest(Date aDate, Time aTime, String aLocation, String aTestLab, Date aProcessingDate, boolean aOutcome, Patient aPatient, TestType aTestType)
  {
    return new Test(aDate, aTime, aLocation, aTestLab, aProcessingDate, aOutcome, this, aPatient, aTestType);
  }

  public boolean addTest(Test aTest)
  {
    boolean wasAdded = false;
    if (tests.contains(aTest)) { return false; }
    TestLocation existingTestLocation = aTest.getTestLocation();
    boolean isNewTestLocation = existingTestLocation != null && !this.equals(existingTestLocation);
    if (isNewTestLocation)
    {
      aTest.setTestLocation(this);
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
    //Unable to remove aTest, as it must always have a testLocation
    if (!this.equals(aTest.getTestLocation()))
    {
      tests.remove(aTest);
      wasRemoved = true;
    }
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
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "," +
            "address" + ":" + getAddress()+ "]";
  }
}