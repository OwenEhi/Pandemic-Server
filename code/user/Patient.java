/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 2 "model.ump"
// line 60 "model.ump"
public class Patient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String name;
  private String address;
  private String phoneNumber;
  private String healthNumber;

  //Patient Associations
  private List<Test> tests;
  private List<Symptom> symptoms;
  private List<PatientContact> patientContacts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aName, String aAddress, String aPhoneNumber, String aHealthNumber)
  {
    name = aName;
    address = aAddress;
    phoneNumber = aPhoneNumber;
    healthNumber = aHealthNumber;
    tests = new ArrayList<Test>();
    symptoms = new ArrayList<Symptom>();
    patientContacts = new ArrayList<PatientContact>();
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setHealthNumber(String aHealthNumber)
  {
    boolean wasSet = false;
    healthNumber = aHealthNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getHealthNumber()
  {
    return healthNumber;
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
  /* Code from template association_GetMany */
  public Symptom getSymptom(int index)
  {
    Symptom aSymptom = symptoms.get(index);
    return aSymptom;
  }

  public List<Symptom> getSymptoms()
  {
    List<Symptom> newSymptoms = Collections.unmodifiableList(symptoms);
    return newSymptoms;
  }

  public int numberOfSymptoms()
  {
    int number = symptoms.size();
    return number;
  }

  public boolean hasSymptoms()
  {
    boolean has = symptoms.size() > 0;
    return has;
  }

  public int indexOfSymptom(Symptom aSymptom)
  {
    int index = symptoms.indexOf(aSymptom);
    return index;
  }
  /* Code from template association_GetMany */
  public PatientContact getPatientContact(int index)
  {
    PatientContact aPatientContact = patientContacts.get(index);
    return aPatientContact;
  }

  public List<PatientContact> getPatientContacts()
  {
    List<PatientContact> newPatientContacts = Collections.unmodifiableList(patientContacts);
    return newPatientContacts;
  }

  public int numberOfPatientContacts()
  {
    int number = patientContacts.size();
    return number;
  }

  public boolean hasPatientContacts()
  {
    boolean has = patientContacts.size() > 0;
    return has;
  }

  public int indexOfPatientContact(PatientContact aPatientContact)
  {
    int index = patientContacts.indexOf(aPatientContact);
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
  public Test addTest(Date aDate, Time aTime, String aLocation, String aTestLab, Date aProcessingDate, boolean aOutcome, TestLocation aTestLocation, TestType aTestType)
  {
    Test aNewTest = new Test(aDate, aTime, aLocation, aTestLab, aProcessingDate, aOutcome, aTestLocation, this, aTestType);
    return aNewTest;
  }

  public boolean addTest(Test aTest)
  {
    boolean wasAdded = false;
    if (tests.contains(aTest)) { return false; }
    Patient existingPatient = aTest.getPatient();
    boolean isNewPatient = existingPatient != null && !this.equals(existingPatient);

    if (isNewPatient && existingPatient.numberOfTests() <= minimumNumberOfTests())
    {
      return wasAdded;
    }
    if (isNewPatient)
    {
      aTest.setPatient(this);
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
    //Unable to remove aTest, as it must always have a patient
    if (this.equals(aTest.getPatient()))
    {
      return wasRemoved;
    }

    //patient already at minimum (1)
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSymptoms()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Symptom addSymptom(String aDescription, Date aStartDate, Date aEndDate)
  {
    return new Symptom(aDescription, aStartDate, aEndDate, this);
  }

  public boolean addSymptom(Symptom aSymptom)
  {
    boolean wasAdded = false;
    if (symptoms.contains(aSymptom)) { return false; }
    Patient existingPatient = aSymptom.getPatient();
    boolean isNewPatient = existingPatient != null && !this.equals(existingPatient);
    if (isNewPatient)
    {
      aSymptom.setPatient(this);
    }
    else
    {
      symptoms.add(aSymptom);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSymptom(Symptom aSymptom)
  {
    boolean wasRemoved = false;
    //Unable to remove aSymptom, as it must always have a patient
    if (!this.equals(aSymptom.getPatient()))
    {
      symptoms.remove(aSymptom);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSymptomAt(Symptom aSymptom, int index)
  {  
    boolean wasAdded = false;
    if(addSymptom(aSymptom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymptoms()) { index = numberOfSymptoms() - 1; }
      symptoms.remove(aSymptom);
      symptoms.add(index, aSymptom);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSymptomAt(Symptom aSymptom, int index)
  {
    boolean wasAdded = false;
    if(symptoms.contains(aSymptom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymptoms()) { index = numberOfSymptoms() - 1; }
      symptoms.remove(aSymptom);
      symptoms.add(index, aSymptom);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSymptomAt(aSymptom, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientContacts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientContact addPatientContact(Patient aPatientName, Date aLastContactDate, String aRelationship)
  {
    return new PatientContact(aPatientName, aLastContactDate, aRelationship, this);
  }

  public boolean addPatientContact(PatientContact aPatientContact)
  {
    boolean wasAdded = false;
    if (patientContacts.contains(aPatientContact)) { return false; }
    Patient existingPatient = aPatientContact.getPatient();
    boolean isNewPatient = existingPatient != null && !this.equals(existingPatient);
    if (isNewPatient)
    {
      aPatientContact.setPatient(this);
    }
    else
    {
      patientContacts.add(aPatientContact);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatientContact(PatientContact aPatientContact)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatientContact, as it must always have a patient
    if (!this.equals(aPatientContact.getPatient()))
    {
      patientContacts.remove(aPatientContact);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientContactAt(PatientContact aPatientContact, int index)
  {  
    boolean wasAdded = false;
    if(addPatientContact(aPatientContact))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientContacts()) { index = numberOfPatientContacts() - 1; }
      patientContacts.remove(aPatientContact);
      patientContacts.add(index, aPatientContact);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientContactAt(PatientContact aPatientContact, int index)
  {
    boolean wasAdded = false;
    if(patientContacts.contains(aPatientContact))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientContacts()) { index = numberOfPatientContacts() - 1; }
      patientContacts.remove(aPatientContact);
      patientContacts.add(index, aPatientContact);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientContactAt(aPatientContact, index);
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
    for(int i=symptoms.size(); i > 0; i--)
    {
      Symptom aSymptom = symptoms.get(i - 1);
      aSymptom.delete();
    }
    for(int i=patientContacts.size(); i > 0; i--)
    {
      PatientContact aPatientContact = patientContacts.get(i - 1);
      aPatientContact.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "healthNumber" + ":" + getHealthNumber()+ "]";
  }
}