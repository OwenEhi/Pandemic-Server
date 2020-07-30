/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 12 "model.ump"
// line 67 "model.ump"
public class Test
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Test Attributes
  private Date date;
  private Time time;
  private String location;
  private String testLab;
  private Date processingDate;
  private boolean outcome;

  //Test Associations
  private TestLocation testLocation;
  private Patient patient;
  private TestType testType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Test(Date aDate, Time aTime, String aLocation, String aTestLab, Date aProcessingDate, boolean aOutcome, TestLocation aTestLocation, Patient aPatient, TestType aTestType)
  {
    date = aDate;
    time = aTime;
    location = aLocation;
    testLab = aTestLab;
    processingDate = aProcessingDate;
    outcome = aOutcome;
    boolean didAddTestLocation = setTestLocation(aTestLocation);
    if (!didAddTestLocation)
    {
      throw new RuntimeException("Unable to create test due to testLocation. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPatient = setPatient(aPatient);
    if (!didAddPatient)
    {
      throw new RuntimeException("Unable to create test due to patient. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTestType = setTestType(aTestType);
    if (!didAddTestType)
    {
      throw new RuntimeException("Unable to create test due to testType. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestLab(String aTestLab)
  {
    boolean wasSet = false;
    testLab = aTestLab;
    wasSet = true;
    return wasSet;
  }

  public boolean setProcessingDate(Date aProcessingDate)
  {
    boolean wasSet = false;
    processingDate = aProcessingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutcome(boolean aOutcome)
  {
    boolean wasSet = false;
    outcome = aOutcome;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getTime()
  {
    return time;
  }

  public String getLocation()
  {
    return location;
  }

  public String getTestLab()
  {
    return testLab;
  }

  public Date getProcessingDate()
  {
    return processingDate;
  }

  public boolean getOutcome()
  {
    return outcome;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isOutcome()
  {
    return outcome;
  }
  /* Code from template association_GetOne */
  public TestLocation getTestLocation()
  {
    return testLocation;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }
  /* Code from template association_GetOne */
  public TestType getTestType()
  {
    return testType;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTestLocation(TestLocation aTestLocation)
  {
    boolean wasSet = false;
    if (aTestLocation == null)
    {
      return wasSet;
    }

    TestLocation existingTestLocation = testLocation;
    testLocation = aTestLocation;
    if (existingTestLocation != null && !existingTestLocation.equals(aTestLocation))
    {
      existingTestLocation.removeTest(this);
    }
    testLocation.addTest(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setPatient(Patient aPatient)
  {
    boolean wasSet = false;
    //Must provide patient to test
    if (aPatient == null)
    {
      return wasSet;
    }

    if (patient != null && patient.numberOfTests() <= Patient.minimumNumberOfTests())
    {
      return wasSet;
    }

    Patient existingPatient = patient;
    patient = aPatient;
    if (existingPatient != null && !existingPatient.equals(aPatient))
    {
      boolean didRemove = existingPatient.removeTest(this);
      if (!didRemove)
      {
        patient = existingPatient;
        return wasSet;
      }
    }
    patient.addTest(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setTestType(TestType aTestType)
  {
    boolean wasSet = false;
    //Must provide testType to test
    if (aTestType == null)
    {
      return wasSet;
    }

    if (testType != null && testType.numberOfTests() <= TestType.minimumNumberOfTests())
    {
      return wasSet;
    }

    TestType existingTestType = testType;
    testType = aTestType;
    if (existingTestType != null && !existingTestType.equals(aTestType))
    {
      boolean didRemove = existingTestType.removeTest(this);
      if (!didRemove)
      {
        testType = existingTestType;
        return wasSet;
      }
    }
    testType.addTest(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    TestLocation placeholderTestLocation = testLocation;
    this.testLocation = null;
    if(placeholderTestLocation != null)
    {
      placeholderTestLocation.removeTest(this);
    }
    Patient placeholderPatient = patient;
    this.patient = null;
    if(placeholderPatient != null)
    {
      placeholderPatient.removeTest(this);
    }
    TestType placeholderTestType = testType;
    this.testType = null;
    if(placeholderTestType != null)
    {
      placeholderTestType.removeTest(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "," +
            "testLab" + ":" + getTestLab()+ "," +
            "outcome" + ":" + getOutcome()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "processingDate" + "=" + (getProcessingDate() != null ? !getProcessingDate().equals(this)  ? getProcessingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "testLocation = "+(getTestLocation()!=null?Integer.toHexString(System.identityHashCode(getTestLocation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "testType = "+(getTestType()!=null?Integer.toHexString(System.identityHashCode(getTestType())):"null");
  }
}