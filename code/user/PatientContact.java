/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.sql.Date;

// line 45 "model.ump"
// line 89 "model.ump"
public class PatientContact
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientContact Attributes
  private Patient patientName;
  private Date lastContactDate;
  private String relationship;

  //PatientContact Associations
  private Patient patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PatientContact(Patient aPatientName, Date aLastContactDate, String aRelationship, Patient aPatient)
  {
    patientName = aPatientName;
    lastContactDate = aLastContactDate;
    relationship = aRelationship;
    boolean didAddPatient = setPatient(aPatient);
    if (!didAddPatient)
    {
      throw new RuntimeException("Unable to create patientContact due to patient. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPatientName(Patient aPatientName)
  {
    boolean wasSet = false;
    patientName = aPatientName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastContactDate(Date aLastContactDate)
  {
    boolean wasSet = false;
    lastContactDate = aLastContactDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setRelationship(String aRelationship)
  {
    boolean wasSet = false;
    relationship = aRelationship;
    wasSet = true;
    return wasSet;
  }

  public Patient getPatientName()
  {
    return patientName;
  }

  public Date getLastContactDate()
  {
    return lastContactDate;
  }

  public String getRelationship()
  {
    return relationship;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatient(Patient aPatient)
  {
    boolean wasSet = false;
    if (aPatient == null)
    {
      return wasSet;
    }

    Patient existingPatient = patient;
    patient = aPatient;
    if (existingPatient != null && !existingPatient.equals(aPatient))
    {
      existingPatient.removePatientContact(this);
    }
    patient.addPatientContact(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Patient placeholderPatient = patient;
    this.patient = null;
    if(placeholderPatient != null)
    {
      placeholderPatient.removePatientContact(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "relationship" + ":" + getRelationship()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "patientName" + "=" + (getPatientName() != null ? !getPatientName().equals(this)  ? getPatientName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lastContactDate" + "=" + (getLastContactDate() != null ? !getLastContactDate().equals(this)  ? getLastContactDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null");
  }
}